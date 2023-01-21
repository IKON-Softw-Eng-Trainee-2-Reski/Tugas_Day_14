package id.product.unittest.application.user.service;

import id.product.unittest.application.user.entity.User;
import id.product.unittest.application.user.repository.UserRepository;
import id.product.unittest.application.user.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
