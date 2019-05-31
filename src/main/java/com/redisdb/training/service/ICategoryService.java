package com.redisdb.training.service;

import com.redisdb.training.entity.Category;
import com.redisdb.training.entity.Product;
import com.redisdb.training.exception.ProductNotFoundException;
import com.redisdb.training.exception.CategoryAlreadyExistsException;
import com.redisdb.training.exception.CategoryNotFoundException;
import com.redisdb.training.exception.ProductAlreadyExistsException;

import java.util.List;

public interface ICategoryService {


    /**
     *
     * @return
     * @throws CategoryNotFoundException
     */
    List<Category> findAll()  throws CategoryNotFoundException;

    /**
     *
     * @param categoryId
     * @return
     * @throws CategoryNotFoundException
     */
    Category findCategoryById(Long categoryId)  throws CategoryNotFoundException;

    /**
     *
     * @param name
     * @return
     * @throws CategoryNotFoundException
     */
    Category findCategoryByName(String name)  throws CategoryNotFoundException;


    /**
     *
     * @param letter
     * @return
     * @throws CategoryNotFoundException
     */
    List<Category> findCategoryByLetterOccurrence(char letter) throws CategoryNotFoundException;

    /**
     *
     * @param categoryId
     * @param product
     * @return
     * @throws ProductAlreadyExistsException
     * @throws CategoryNotFoundException
     */
    Category addProductIntoCategory(Long categoryId, Product product) throws ProductAlreadyExistsException, CategoryNotFoundException, ProductNotFoundException;

    /**
     *
     * @param category
     * @return
     * @throws CategoryAlreadyExistsException
     * @throws CategoryNotFoundException
     */
    Category createCategory(Category category) throws CategoryAlreadyExistsException, CategoryNotFoundException;


}
