package br.com.anatomiaumc.AnatomiaUMC.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.anatomiaumc.AnatomiaUMC.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("select U from User U where U.login = :login")
	User findByLogin(@Param("login") String login);
	
	@Query("select U from User U where U.resetToken = :resetToken")
	Optional<User> findByResetToken(@Param("resetToken") String resetToken);
	
	@Query("select U from User U where U.email = :email")
	public Optional<User> findUserByEmail(@Param("email") String email);
	


}