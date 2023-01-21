package id.product.unittest.application.product.usecase;

import id.product.unittest.shared.exception.DataNotFoundException;

public interface DeleteProductUseCase {
    boolean deleteProduct(Long id) throws DataNotFoundException;
}
