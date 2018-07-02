package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Acesso", schema = "public")
public class AcessoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDAcesso")
	private Integer idRGM;

	@OneToOne
	@JoinColumn(name = "IDUsuario", nullable = false)
	private UsuarioModel usuario;

	// ############### METODOS GETTERS AND SETTERS ######################

}
