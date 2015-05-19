package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AulasDAO;
import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.exceptions.DAOException;

/**
 * @author rafael.mendes
 * 
 */


public class AulasBO {

	@Autowired
	private AulasDAO aulasDAO;
	
	public void salvar(Aulas alunos) {
		
	}
	
	public void atualizar(Aulas usuario){
		aulasDAO.atualizar(usuario);
		
	}

	@Loggable(enable=false)
	public List<Aulas> listaAulas(String temas) {
		List<Aulas> aulas = aulasDAO.listarPorTema(temas);
		return aulas;
	}
	
	public Aulas buscarPorId(Integer id){
		try {
			return aulasDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Aulas aulas) {
		try {
			aulas = aulasDAO.buscaPorId(aulas.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		aulasDAO.excluir(aulas);
	}

}
