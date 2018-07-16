package br.com.anatomiaumc.AnatomiaUMC.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.anatomiaumc.AnatomiaUMC.models.RgmModel;
import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;

@Repository
public interface RgmRepository extends CrudRepository<RgmModel, Long> {
	@Query("select R from RgmModel R where R.NumeroRGM = :NumeroRGM")
	 RgmModel findByRGM(@Param("NumeroRGM") String RGM);
}