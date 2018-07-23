package br.com.anatomiaumc.AnatomiaUMC.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.anatomiaumc.AnatomiaUMC.models.Role;
import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;
@Repository
public interface RolesRepository extends CrudRepository<Role, Long> {
	@Query("select R from Role R where R.name = :name")
	Role findByRole(@Param("name") String name);
}
