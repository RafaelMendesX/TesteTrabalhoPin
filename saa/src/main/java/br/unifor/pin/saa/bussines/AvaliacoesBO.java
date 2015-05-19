package br.unifor.pin.saa.bussines;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.unifor.pin.saa.aspectj.Loggable;
import br.unifor.pin.saa.dao.AvaliacoesDAO;
import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.exceptions.DAOException;

public class AvaliacoesBO {
	@Autowired
	private AvaliacoesDAO avaliacoesDAO;
	
	public void salvar(Avaliacoes avaliacoes) {
		
	}
	
	public void atualizar(Avaliacoes avaliacoes){
		avaliacoesDAO.atualizar(avaliacoes);
		
	}

	@Loggable(enable=false)
	public List<Avaliacoes> listaAulas(String temas) {
		List<Avaliacoes> avaliacoes = avaliacoesDAO.listarPorTema(temas);
		return avaliacoes;
	}
	
	public Avaliacoes buscarPorId(Integer id){
		try {
			return avaliacoesDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Avaliacoes avaliacoes) {
		try {
			avaliacoes = avaliacoesDAO.buscaPorId(avaliacoes.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		avaliacoesDAO.excluir(avaliacoes);
	}
}
