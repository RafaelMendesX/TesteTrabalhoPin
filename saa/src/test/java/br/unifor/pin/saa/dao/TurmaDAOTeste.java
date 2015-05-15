package br.unifor.pin.saa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Turmas;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")


public class TurmaDAOTeste {
	
	@Autowired
	private TurmasDAO turmaDAO;
	
	@Test
	public void testeSalvar () throws Exception {
		
		Turmas turmas = new Turmas();
		turmas.setId(10);
		turmaDAO.salvar(turmas);

		
		Assert.assertNotNull(turmas.getId());
		System.out.println(turmas.getId());
		
	
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
