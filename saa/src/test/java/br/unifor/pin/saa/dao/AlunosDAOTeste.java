package br.unifor.pin.saa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.exceptions.DAOException;

/*TESTES ESTAO COM ERRO*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class AlunosDAOTeste {

	@Autowired
	private AlunosDAO alunosDAO;
	
	@Test
	public void testSalvar() throws Exception {
		Alunos alunos = new  Alunos();
		alunos.setNome("Rafael");
		alunos.setEmail("rafa090796@hotmail.com");
		alunos.setSenha("123456");
		alunosDAO.salvar(alunos); 
		
		Assert.assertNotNull(alunos);
		System.out.println(alunos.getMatricula());
	}
	
	@Test
	public void testAtualizar() {
		final String nome = "Rafael";
		final String nomeAlterado = "Alice";
		Alunos aluno = new Alunos();
		aluno.setNome(nome);

		alunosDAO.salvar(aluno);
		aluno.setNome(nomeAlterado);		
		alunosDAO.atualizar(aluno);

		Assert.assertEquals(nomeAlterado, aluno.getNome());
		
		alunosDAO.excluir(aluno);
	}

	@Test
	public void testListaPorNome(){
		List<Alunos> aluno = alunosDAO.listarPorNome("raf");
		Assert.assertEquals(1, aluno.size());
	}
	
	@Test
	public void testBuscarPorId() throws DAOException {
		final String nome = "Matheus";	
		Alunos aluno = new Alunos();
		aluno.setNome(nome);	
		alunosDAO.salvar(aluno);
		
		List<Alunos> alunoRetorno = alunosDAO.listarPorNome("Mat");
		Integer id = ((Alunos) alunoRetorno).getMatricula();
		Alunos alunoNovo = alunosDAO.buscaPorId(id);
		
		Assert.assertNotNull(alunoNovo);
		
		alunosDAO.excluir((Alunos) alunoRetorno);
	}
	

}
