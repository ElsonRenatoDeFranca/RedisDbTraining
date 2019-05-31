package com.redisdb.training.service;

import com.redisdb.training.constants.DemoAppConstants;
import com.redisdb.training.entity.Category;
import com.redisdb.training.entity.Product;
import com.redisdb.training.exception.ProductAlreadyExistsException;
import com.redisdb.training.exception.ProductNotFoundException;
import com.redisdb.training.repository.ProductRepository;
import com.redisdb.training.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ICategoryService categoryService;



    @Override
    public Product findProductById(Long id) throws ProductNotFoundException {
        return productRepository.findByproductId(id);
    }

    @Override
    public List<Product> findProductByCategoryId(Long id) throws ProductNotFoundException, CategoryNotFoundException {
        Category category = categoryService.findCategoryById(id);

        if(category != null){
            return category.getProducts();
        }else{
            throw new ProductNotFoundException(DemoAppConstants.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
        }

    }

    @Override
    @Cacheable("products")
    public List<Product> findAll() throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product createProduct(Product product) throws ProductAlreadyExistsException, ProductNotFoundException {
        Product searchedProduct = this.findProductById(product.getId());

        if(searchedProduct != null){
            throw new ProductNotFoundException(DemoAppConstants.PRODUCT_ALREADY_EXISTS_ERROR_MESSAGE);
        }
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Long id) throws ProductNotFoundException {
        Product searchedProduct = this.findProductById(id);

        if(searchedProduct == null){
            throw new ProductNotFoundException(DemoAppConstants.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
        }
        productRepository.delete(searchedProduct);
    }

}
