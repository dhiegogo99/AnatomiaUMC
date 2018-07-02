package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOCONTEUDO", schema = "public")
public class TipoUsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDTipo")
	private Integer idTipo;

	@Column(name = "Tipo")
	private String tipo;

	// ############### METODOS GETTERS AND SETTERS ######################
	
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
