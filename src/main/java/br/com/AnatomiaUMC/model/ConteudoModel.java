package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Conteudo", schema = "public")
public class ConteudoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDConteudo")
	private Integer idConteudo;


	@OneToOne
	@JoinColumn(name = "IDTopico", nullable = false)
	private TopicoConteudoModel Topico;
	
	@OneToOne
	@JoinColumn(name = "IDUsuario", nullable = false)
	private UsuarioModel Usuario;
	
	@Column(name = "Email")
	private String email;
	




	// ############### METODOS GETTERS AND SETTERS ######################

}
