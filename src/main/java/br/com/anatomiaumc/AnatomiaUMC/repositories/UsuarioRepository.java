package br.com.anatomiaumc.AnatomiaUMC.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	@Query("select U from UsuarioModel U where U.login = :login")
	UsuarioModel findByLogin(@Param("login") String login);
	
	
	
//	@Query("update UsuarioModel U set U.nome = :usuario.nome,"
//			+ " U.email = :usuario.email,"
//			+ " U.login = :usuario.login,"
//			+ " U.senha = :usuario.senha,"
//			+ " U.Status = :usuario.Status,"
//			+ " U.CursoUsuario.descrCurso = :usuario.CursoUsuario.descrCurso"
//			+ " where U.email = :usuario.email")
//	void UpdateAluno(@Param("usuario") UsuarioModel usuario);

}