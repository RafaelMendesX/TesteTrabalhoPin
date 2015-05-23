package br.unifor.pin.saa.manager.instituicoes;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.unifor.pin.saa.bussines.InstituicoesBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;
/**
 * @author james.lucas
 * 
 */
@RequestScoped
@ManagedBean(name="lisInstituicoes")
@Component(value="listInstituicoes")
public class ListInstituicoesManager {

	@Autowired
	private InstituicoesBO instituicoesBO;
	private String nome;
	private List<Instituicoes> instituicoes;

	public void lista(){
		
		instituicoes = instituicoesBO.listaInstituicoes(nome);
		
	}
	
	public void excluir(Instituicoes instituicao){
		instituicoesBO.excluir(instituicao);
		instituicoes = instituicoesBO.listaInstituicoes(nome);
	}
	
	public String preparaAtualizar(Instituicoes instituicao){
		System.out.println(instituicao.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.instituicoes = null;
	}
	
	
	public String salvar(){
		return null;
	}

	
	
	public InstituicoesBO getInstituicoesBO() {
		return instituicoesBO;
	}

	public void setInstituicoesBO(InstituicoesBO instituicoesBO) {
		this.instituicoesBO = instituicoesBO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Instituicoes> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicoes> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	
}
