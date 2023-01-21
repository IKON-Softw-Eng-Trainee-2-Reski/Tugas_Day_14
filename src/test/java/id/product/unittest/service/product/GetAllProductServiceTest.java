package id.product.unittest.service.product;

import id.product.unittest.application.product.entity.Product;
import id.product.unittest.application.product.repository.ProductRepository;
import id.product.unittest.application.product.service.GetAllProductService;
import id.product.unittest.shared.exception.DataNotFoundException;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest()
public class GetAllProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private GetAllProductService getAllProductService;
    @Test
    public void getAllProduct_WhenExist_ShouldReturnListOfProductSuccess () throws DataNotFoundException {
        EasyRandom easyRandom = new EasyRandom();
        // Given
        List<Product> expectedProducts = new ArrayList<Product>();
        expectedProducts.add(easyRandom.nextObject(Product.class));
        expectedProducts.add(easyRandom.nextObject(Product.class));
        given(productRepository.getAllProducts()).willReturn(expectedProducts);
        // When
        List<Product> actualProducts = getAllProductService.getAllProduct();
        // Then
        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void getAllProduct_WhenNotExist_ShouldThrowDataNotFoundExceptionErr(){
        // Given
        String expectedMessage = "Product not found";
        // When
        Exception exception = assertThrows(DataNotFoundException.class, () -> {
            getAllProductService.getAllProduct();
        });
        // Then
        assertEquals(exception.getClass(), DataNotFoundException.class);
        assertEquals(exception.getMessage(),expectedMessage);
    }
}
