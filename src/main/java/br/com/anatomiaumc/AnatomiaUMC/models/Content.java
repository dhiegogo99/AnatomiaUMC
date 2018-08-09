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
@Table(name = "Content")
@Data
public class Content  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;


	@OneToOne
	@JoinColumn(name = "IdUser")
	private User User;
	@OneToOne
	@JoinColumn
	private Subject subject;
}
