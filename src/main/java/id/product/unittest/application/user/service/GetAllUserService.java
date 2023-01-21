package id.product.unittest.application.user.service;

import id.product.unittest.application.user.entity.User;
import id.product.unittest.application.user.repository.UserRepository;
import id.product.unittest.application.user.usecase.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }
}
