package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURSO", schema = "public")
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDCurso")
	private Integer idCurso;

	@Column(name = "Curso")
	private String descrCurso;

	// ############### METODOS GETTERS AND SETTERS ######################
	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescrCurso() {
		return descrCurso;
	}

	public void setDescrCurso(String descrCurso) {
		this.descrCurso = descrCurso;
	}

}
