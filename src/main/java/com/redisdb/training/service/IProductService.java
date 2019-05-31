package com.redisdb.training.service;

import com.redisdb.training.entity.Product;
import com.redisdb.training.exception.ProductAlreadyExistsException;
import com.redisdb.training.exception.ProductNotFoundException;
import com.redisdb.training.exception.CategoryNotFoundException;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param id
     * @return
     * @throws ProductNotFoundException
     */
    Product findProductById(Long id) throws ProductNotFoundException;


    /**
     *
     * @param id
     * @return
     * @throws ProductNotFoundException
     */
    List<Product> findProductByCategoryId(Long id) throws ProductNotFoundException, CategoryNotFoundException;

    /**
     *
     * @return
     * @throws ProductNotFoundException
     */
    List<Product> findAll() throws ProductNotFoundException;


    /**
     *
     * @param product
     * @return
     */
    Product createProduct(Product product)  throws ProductAlreadyExistsException, ProductNotFoundException;

    /**
     *
     * @param id
     * @throws ProductNotFoundException
     */
    void removeProduct(Long id) throws ProductNotFoundException;

}
