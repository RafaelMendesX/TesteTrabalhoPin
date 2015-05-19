package br.unifor.pin.saa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author james.lucas
 * 
 */

@Entity
@Table(name = "instituicoes")

public class Instituicoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String sigla;

	@Column
	private String nome;

	
	
	
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
