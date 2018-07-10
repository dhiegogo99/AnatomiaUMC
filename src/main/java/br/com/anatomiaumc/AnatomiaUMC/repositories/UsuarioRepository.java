package br.com.anatomiaumc.AnatomiaUMC.repositories;

import br.com.anatomiaumc.AnatomiaUMC.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	@Query("select U from UsuarioModel U where U.RGM.NumeroRGM = :rgm")
	UsuarioModel findByRGM(@Param("rgm") String rgm);

}