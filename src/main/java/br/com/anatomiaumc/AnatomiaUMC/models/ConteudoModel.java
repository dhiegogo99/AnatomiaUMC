package br.com.anatomiaumc.AnatomiaUMC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Conteudo")
@Data
public class ConteudoModel  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDConteudo")
	private Long idConteudo;

	@OneToOne
	@JoinColumn(name = "IDTopico")
	private TopicoConteudoModel Topico;
	
	@OneToOne
	@JoinColumn(name = "IDUsuario")
	private UsuarioModel Usuario;
	
	@Column(name = "Conteudo")
	private String conteudo;
}
