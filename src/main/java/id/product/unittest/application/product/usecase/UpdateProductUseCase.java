package id.product.unittest.application.product.usecase;

import id.product.unittest.application.product.entity.Product;
import id.product.unittest.shared.exception.DataNotFoundException;

public interface UpdateProductUseCase {
    Product updateProduct(Long id, Product product) throws DataNotFoundException;
}
