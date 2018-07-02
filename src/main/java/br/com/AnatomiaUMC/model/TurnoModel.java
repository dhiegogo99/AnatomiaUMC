package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TURNO", schema = "public")
public class TurnoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDTURNO")
	private Integer idTurno;

	@Column(name = "Turno")
	private String descrTurno;

	// ############### METODOS GETTERS AND SETTERS ######################
	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public String getDescrTurno() {
		return descrTurno;
	}

	public void setDescrTurno(String descrTurno) {
		this.descrTurno = descrTurno;
	}

}
