package br.com.anatomiaumc.AnatomiaUMC.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.context.annotation.Bean;
@Entity
@Table(name = "USUARIO")
@Data
@EqualsAndHashCode(exclude = "roles")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUsuario")
	private Long idUsuario;
	@Column(name = "Nome")
	private String nome;
	@Column(name = "Email")
	private String email;
	@Column(name = "Login")
	private String login;
	@Column(name = "Senha")
	private String senha;
	@Column(name = "Status")
	private Boolean Status;
	@Column(name = "reset_token")
	private String resetToken;
	@OneToOne
	@JoinColumn(name = "IDCurso")
	private CursoModel CursoUsuario;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

}
