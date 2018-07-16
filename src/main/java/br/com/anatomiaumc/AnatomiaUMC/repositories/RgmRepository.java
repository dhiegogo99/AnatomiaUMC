package br.com.anatomiaumc.AnatomiaUMC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.anatomiaumc.AnatomiaUMC.models.RgmModel;

@Repository
public interface RgmRepository extends CrudRepository<RgmModel, Long> {


}