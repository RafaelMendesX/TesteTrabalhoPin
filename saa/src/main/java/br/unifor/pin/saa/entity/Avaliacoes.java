package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacoes implements Serializable {
	
	private static final long serialVersionUID = 1786076438046621030L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numerodaAvaliacao;
	
	@Column
	private Integer nota;

	public Integer getNumerodaAvaliacao() {
		return numerodaAvaliacao;
	}

	public void setNumerodaAvaliacao(Integer numerodaAvaliacao) {
		this.numerodaAvaliacao = numerodaAvaliacao;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	
	
}
