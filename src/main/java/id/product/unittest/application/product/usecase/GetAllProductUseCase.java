package id.product.unittest.application.product.usecase;

import id.product.unittest.application.product.entity.Product;
import id.product.unittest.shared.exception.DataNotFoundException;

import java.util.List;

public interface GetAllProductUseCase {
    List<Product> getAllProduct() throws DataNotFoundException;
}
