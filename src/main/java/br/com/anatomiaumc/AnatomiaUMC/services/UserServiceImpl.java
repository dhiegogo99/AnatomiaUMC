package br.com.anatomiaumc.AnatomiaUMC.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UsuarioRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public Optional findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public Optional findUserByResetToken(String resetToken) {
		return userRepository.findByResetToken(resetToken);
	}

	@Override
	public void save(UsuarioModel user) {
		userRepository.save(user);
	}


}