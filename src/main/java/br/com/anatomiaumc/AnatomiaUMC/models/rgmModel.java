package br.com.anatomiaumc.AnatomiaUMC.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RGM")
@Data
public class RgmModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRGM")
	private Long idRGM;

	@Column(name = "RGM")
	private String NumeroRGM;


}
