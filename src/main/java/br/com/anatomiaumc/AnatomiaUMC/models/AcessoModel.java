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
@Table(name = "Acesso")
@Data
public class AcessoModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDAcesso")
	private Long idRGM;

	@OneToOne
	@JoinColumn(name = "IDUsuario")
	private UsuarioModel usuario;


}
