package br.unifor.pin.saa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.InstituicoesDAO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.exceptions.DAOException;

/**
 * @author James.Lucas
 * 
 */

@Loggable
@Component
public class InstituicoesBO {
	
	@Autowired
	private InstituicoesDAO instituicoesDAO;
	
	public void salvar(Instituicoes instituicoes) {
		instituicoes.setSigla("UNIFOR");
		instituicoes.setNome("Universidade de fortaleza");
		instituicoesDAO.salvar(instituicoes);
	}
	
	public void atualizar(Instituicoes instituicoes){
		instituicoesDAO.atualizar(instituicoes);
		
	}

	@Loggable(enable=false)
	public List<Instituicoes> listaInstituicoes(String nome) {
		List<Instituicoes> instituicoes = instituicoesDAO.listarPoriNome(nome);
		return instituicoes;
	}
	
	public Instituicoes busInstituicoes(String sigla){
		try {
			return instituicoesDAO.buscarporInstituicoes(sigla);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Instituicoes instituicoes) {
		try {
			instituicoes = instituicoesDAO.buscarporInstituicoes(instituicoes.getSigla());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		instituicoesDAO.excluir(instituicoes);
	}

	
	
	
	
	
	
	

}
