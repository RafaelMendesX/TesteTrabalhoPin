package br.unifor.pin.saa.bussines;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AlunosDAO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.exceptions.DAOException;

/**
 * @author rafael.mendes
 * 
 */

public class AlunosBO {

	@Autowired
	private AlunosDAO alunosDAO;
	
	public void salvar(Alunos alunos) {
		
	}
	
	public void atualizar(Alunos usuario){
		alunosDAO.atualizar(usuario);
		
	}

	@Loggable(enable=false)
	public List<Alunos> listaAlunosPorNome(String nome) {
		List<Alunos> alunos = alunosDAO.listarPorNome(nome);
		return alunos;
	}
	
	public Alunos buscarPorId(Integer matricula){
		try {
			return alunosDAO.buscaPorMatricula(matricula);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Alunos alunos) {
		try {
			alunos = alunosDAO.buscaPorMatricula(alunos.getMatricula());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		alunosDAO.excluir(alunos);
	}
}
