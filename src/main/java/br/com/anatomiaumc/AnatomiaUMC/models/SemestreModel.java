package br.com.anatomiaumc.AnatomiaUMC.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SEMESTRE")
@Data
public class SemestreModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSemestre")
	private Long idSemestre;

	@Column(name = "Semestre")
	private Byte Semestre;




}
