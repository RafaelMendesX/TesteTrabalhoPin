package br.unifor.pin.saa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Aulas;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class AulasDAOTeste {
	
	@Autowired
	private AulasDAO aulasDAO;

	@Test
	public void testSalvar() throws Exception {
		
		Aulas aulas = new Aulas();
		//aulas.setDataAula();
		aulas.setTema("Poo");
		
		aulasDAO.salvar(aulas);
		
		Assert.assertNotNull(aulas.getDataAula());
		System.out.println(aulas.getDataAula());
		
	}
	
	

}
