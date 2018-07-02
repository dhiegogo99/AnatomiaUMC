package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOPICOCONTEUDO", schema = "public")
public class TopicoConteudoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDTopicoConteudo")
	private Integer idTopicoConteudo;

	@Column(name = "Titulo")
	private String Titulo;


	// ############### METODOS GETTERS AND SETTERS ######################

	public Integer getIdTopicoConteudo() {
		return idTopicoConteudo;
	}

	public void setIdTopicoConteudo(Integer idTopicoConteudo) {
		this.idTopicoConteudo = idTopicoConteudo;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

}
