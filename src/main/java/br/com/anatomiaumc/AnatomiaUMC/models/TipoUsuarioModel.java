package br.com.anatomiaumc.AnatomiaUMC.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TIPOUSUARIO")
@Data
public class TipoUsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTipo")
	private Long idTipo;

	@Column(name = "Tipo")
	private String tipo;

	
}
