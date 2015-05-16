package br.unifor.pin.saa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Cursos;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")

public class CursosDAOTeste {

		
	
	@Autowired
	private CursosDAO cursosDAO;

	@Test
	public void testSalvar() throws Exception {
		
		Cursos cursos = new Cursos();
		cursos.setId(3);
		cursos.setNome("ADS");
		cursosDAO.salvar(cursos);
		
		Assert.assertNotNull(cursos.getId());
		System.out.println(cursos.getId());		
	}
	
	@Test
	public void testListaPorNome(){
		List<Cursos> cursos = cursosDAO.listarPorNome("a");
		Assert.assertEquals(1, cursos.size());
		
	}

	
	
}
