package br.com.anatomiaumc.AnatomiaUMC.services;
import java.util.Optional;

import br.com.anatomiaumc.AnatomiaUMC.models.User;

public interface UserService {
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);
    public void save(User user);
}