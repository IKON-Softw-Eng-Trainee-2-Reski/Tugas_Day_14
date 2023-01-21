package id.product.unittest.application.product.service;

import id.product.unittest.application.product.entity.Product;
import id.product.unittest.application.product.repository.ProductRepository;
import id.product.unittest.application.product.usecase.CreateProductUseCase;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    @Override
    public Product createProduct(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        return productRepository.createProduct(product);
    }
}
