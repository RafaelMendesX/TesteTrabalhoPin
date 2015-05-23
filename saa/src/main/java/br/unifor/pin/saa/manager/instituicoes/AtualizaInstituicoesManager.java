package br.unifor.pin.saa.manager.instituicoes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author james.lucas
 * 
 */
@RequestScoped
@ManagedBean(name = "atualizaInstituicoes")
@Component(value = "atualizaInstituicoes")
public class AtualizaInstituicoesManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	private Instituicoes instituicaoSelecionada;
	
	public String atualizar() {
		instituicoesBO.atualizar(instituicaoSelecionada);
		MessagesUtils.info("Usuário atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Instituicoes instituicoes) {
		instituicaoSelecionada = instituicoesBO.busInstituicoes(instituicoes.getSigla());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		instituicaoSelecionada.setSigla("");
		instituicaoSelecionada.setNome("");
		
	}

	public Instituicoes getInstituicaoSelecionada () {
		return instituicaoSelecionada;
	}
	public void setInstituicaoSelecionada(Instituicoes instituicoaoSelecionada) {
		this.instituicaoSelecionada = instituicoaoSelecionada;
	}
	
	
	public InstituicoesBO getInstituicoesBO() {
		return instituicoesBO;
	}

	public void setInstituicoesBO(InstituicoesBO instituicoesBO) {
		this.instituicoesBO = instituicoesBO;
	}

	
	
}
