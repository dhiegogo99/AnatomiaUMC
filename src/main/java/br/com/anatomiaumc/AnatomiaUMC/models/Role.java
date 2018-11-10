package br.com.anatomiaumc.AnatomiaUMC.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UsuarioModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UsuarioModel> users) {
		this.users = users;
	}

	private String name;
  
    @ManyToMany(mappedBy = "roles")
    private Set<UsuarioModel> users = new HashSet<>();
	
}