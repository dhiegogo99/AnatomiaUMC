package br.com.anatomiaumc.AnatomiaUMC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CURSO")
@Data
public class CursoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCurso")
	private Long idCurso;

	@Column(name = "Curso")
	private String descrCurso;
}
;