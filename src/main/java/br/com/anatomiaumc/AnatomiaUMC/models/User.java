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
@Entity
@Table(name = "UserUMC")
@Data
@EqualsAndHashCode(exclude = "roles")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Email")
	private String email;
	@Column(name = "Login")
	private String login;
	@Column(name = "Password")
	private String Password;
	@Column(name = "Status")
	private Boolean Status;
	@Column(name = "reset_token")
	private String resetToken;
	@OneToOne
	@JoinColumn(name = "IdCourse")
	private Course UserCourse;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

}
