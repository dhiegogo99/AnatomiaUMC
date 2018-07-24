package br.com.anatomiaumc.AnatomiaUMC.services;
import java.util.Optional;

import br.com.anatomiaumc.AnatomiaUMC.models.UsuarioModel;

public interface UserService {
    public Optional<UsuarioModel> findUserByEmail(String email);
    public Optional<UsuarioModel> findUserByResetToken(String resetToken);
    public void save(UsuarioModel user);
}