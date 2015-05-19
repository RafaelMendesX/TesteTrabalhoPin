package br.unifor.pin.saa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rafael.mendes
 * 
 */

@Entity
@Table(name = "aulas")
public class Aulas implements Serializable {
	

	private static final long serialVersionUID = 7339520643296472163L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date DataAula;
	
	@Column
	private String tema;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAula() {
		return DataAula;
	}

	public void setDataAula(Date dataAula) {
		DataAula = dataAula;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	
}
