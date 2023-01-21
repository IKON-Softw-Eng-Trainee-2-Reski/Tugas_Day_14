package id.product.unittest.application.product.service;

import id.product.unittest.application.product.entity.Product;
import id.product.unittest.application.product.repository.ProductRepository;
import id.product.unittest.application.product.usecase.GetAllProductUseCase;
import id.product.unittest.shared.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductService implements GetAllProductUseCase {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() throws DataNotFoundException {
        List<Product> products = productRepository.getAllProducts();
        if (products.size() == 0){
            throw new DataNotFoundException("Data product not found");
        }
        return products;
    }
}
