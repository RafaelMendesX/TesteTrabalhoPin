package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "disciplinas")
public class Disciplinas implements Serializable {
	
	private static final long serialVersionUID = -548755361406044151L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String codigoDiscplina;
	
	private String nome;

	public String getCodigoDiscplina() {
		return codigoDiscplina;
	}

	public void setCodigoDiscplina(String codigoDiscplina) {
		this.codigoDiscplina = codigoDiscplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
