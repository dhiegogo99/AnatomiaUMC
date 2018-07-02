package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEMESTRE", schema = "public")
public class SemestreModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDSemestre")
	private Integer idSemestre;

	@Column(name = "Semestre")
	private Integer Semestre;



	// ############### METODOS GETTERS AND SETTERS ######################
	
	public Integer getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}

	public Integer getSemestre() {
		return Semestre;
	}

	public void setSemestre(Integer semestre) {
		Semestre = semestre;
	}

}
