package br.unifor.pin.saa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Alunos;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")


public class AlunosDAOTest {
	
		
	@Autowired
	private AlunosDAO alunosDAO;
	
	@Test
	public void testSalvarAluno() throws Exception {
		Alunos alunos = new  Alunos();
		alunos.setNome("Rafael");
		alunos.setEmail("rafa090796@hotmail.com");
		alunos.setSenha("123456");
		alunosDAO.salvar(alunos); 
		
		Assert.assertNotNull(alunos.getMatricula());
		System.out.println(alunos.getMatricula());
		
	}
	
	@Test
	public void testListaPorNomeAluno(){
		List<Alunos> alunos = alunosDAO.listarPorNome("rafa");
		Assert.assertEquals(1, alunos.size());
		
	}


}
