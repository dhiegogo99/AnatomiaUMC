package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RGM", schema = "public")
public class rgmModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDRGM")
	private Integer idRGM;

	@Column(name = "RGM")
	private String RGM;

	// ############### METODOS GETTERS AND SETTERS ######################

	public Integer getIdRGM() {
		return idRGM;
	}

	public void setIdRGM(Integer idRGM) {
		this.idRGM = idRGM;
	}

	public String getRGM() {
		return RGM;
	}

	public void setRGM(String rGM) {
		RGM = rGM;
	}

}
