package br.com.AnatomiaUMC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USUARIO", schema = "public")
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDUsuario")
	private Integer idUsuario;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "TelefoneUsuario")
	private String TelUsuario;
	
	@OneToOne
	@JoinColumn(name = "IDTipo", nullable = false)
	private TipoUsuarioModel TipoUsuario;
	
	@OneToOne
	@JoinColumn(name = "IDTurno", nullable = false)
	private TurnoModel TurnoUsuario;
	
	@OneToOne
	@JoinColumn(name = "IDCurso", nullable = false)
	private CursoModel CursoUsuario;
	
	@OneToOne
	@JoinColumn(name = "IDSemestre", nullable = false)
	private SemestreModel SemestreUsuario;




	// ############### METODOS GETTERS AND SETTERS ######################
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelUsuario() {
		return TelUsuario;
	}

	public void setTelUsuario(String telUsuario) {
		TelUsuario = telUsuario;
	}

	public TipoUsuarioModel getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioModel tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public TurnoModel getTurnoUsuario() {
		return TurnoUsuario;
	}

	public void setTurnoUsuario(TurnoModel turnoUsuario) {
		TurnoUsuario = turnoUsuario;
	}

	public CursoModel getCursoUsuario() {
		return CursoUsuario;
	}

	public void setCursoUsuario(CursoModel cursoUsuario) {
		CursoUsuario = cursoUsuario;
	}

	public SemestreModel getSemestreUsuario() {
		return SemestreUsuario;
	}

	public void setSemestreUsuario(SemestreModel semestreUsuario) {
		SemestreUsuario = semestreUsuario;
	}


}
