package br.com.anatomiaumc.AnatomiaUMC.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TopicContent")
@Data
public class Topic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;

	@Column(name = "Title")
	private String Name;

	@OneToOne
	Topic parent;

	@OneToMany(mappedBy="parent")
	List<Topic> children;
}
