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
@ManagedBean(name="cadInstituicao")
@Component(value="cadInstituicao")
public class CadInstituicoesManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	@Autowired
	private ListInstituicoesManager listInstiuicoes;
	private String sigla;
	private String nome;
	
	public String salvar(){
		Instituicoes instituicoes = new Instituicoes();
		instituicoes.setSigla(sigla);
		instituicoes.setNome(nome);
		instituicoesBO.salvar(instituicoes);
		MessagesUtils.info("Instituição salva com sucesso!");
		listInstiuicoes.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados() {
		this.nome = "";
		this.sigla = "";
		
	}
	

	public InstituicoesBO getInstituicoesBO() {
		return instituicoesBO;
	}

	public void setInstituicoesBO(InstituicoesBO instituicoesBO) {
		this.instituicoesBO = instituicoesBO;
	}

	public ListInstituicoesManager getListInstiuicoes() {
		return listInstiuicoes;
	}

	public void setListInstiuicoes(ListInstituicoesManager listInstiuicoes) {
		this.listInstiuicoes = listInstiuicoes;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
