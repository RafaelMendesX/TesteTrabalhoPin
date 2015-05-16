package br.unifor.pin.saa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Avaliacoes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")

public class AvaliacoesDAOTeste {
	
	@Autowired
	public AvaliacoesDAO avaliacoesDAO;
	
	@Test
	public void testSalvar() throws Exception {
		
		Avaliacoes avaliacoes = new Avaliacoes();
		avaliacoes.setNumerodaAvaliacao(1);
		avaliacoes.setNota(10);
		
		avaliacoesDAO.salvar(avaliacoes);
		
		
		Assert.assertNotNull(avaliacoes.getNumerodaAvaliacao());
		System.out.println(avaliacoes.getNumerodaAvaliacao());
		
	}
	
}
