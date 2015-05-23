package br.unifor.pin.saa.bussines;

import java.io.NotActiveException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AvaliacoesDAO;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.exceptions.DAOException;


public class AvaliacoesBO {
	@Autowired
	private AvaliacoesDAO avaliacoesDAO;
	
	public void salvar(Avaliacoes avaliacoes) {
		
			avaliacoes.setNumerodaAvaliacao(1);
			avaliacoes.setNota(10);
			avaliacoesDAO.salvar(avaliacoes);
		
		
	}
	
	public void atualizar(Avaliacoes avaliacoes){
		avaliacoesDAO.atualizar(avaliacoes);
		
	}

	@Loggable(enable=false)
	public List<Avaliacoes> listaAvaliacoes(String notas) {
		List<Avaliacoes> avaliacoes = avaliacoesDAO.listarPorNota(notas);
		return avaliacoes;
	}
	
	public Avaliacoes buscarPorId(Integer id){
		try {
			return avaliacoesDAO.buscaPornumeroDaAvaliacao(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Avaliacoes avaliacoes) {
		try {
			avaliacoes = avaliacoesDAO.buscaPornumeroDaAvaliacao(avaliacoes.getNumerodaAvaliacao());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		avaliacoesDAO.excluir(avaliacoes);
	}
}
