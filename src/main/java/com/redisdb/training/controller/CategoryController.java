package com.redisdb.training.controller;


import com.redisdb.training.entity.Category;
import com.redisdb.training.entity.Product;
import com.redisdb.training.exception.CategoryAlreadyExistsException;
import com.redisdb.training.exception.CategoryNotFoundException;
import com.redisdb.training.exception.ProductAlreadyExistsException;
import com.redisdb.training.exception.ProductNotFoundException;
import com.redisdb.training.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/category/listAll")
    public List<Category> findAll() throws CategoryNotFoundException, ProductNotFoundException {
        return categoryService.findAll();
    }

    @RequestMapping(value ="/category/{letter}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> findCategoryByLetterOccurrence(@PathVariable(name="letter") char letter) throws CategoryNotFoundException, ProductNotFoundException {
        return categoryService.findCategoryByLetterOccurrence(letter);
    }

    @RequestMapping(method=RequestMethod.GET,value="/category/{categoryId}")
    public ResponseEntity<Category> findCategoryByCategoryId(@PathVariable Long categoryId){
        try {
            Category category = categoryService.findCategoryById(categoryId);
            return new ResponseEntity<>(category, HttpStatus.OK);

        }catch(CategoryNotFoundException catEx){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.POST,value="/category/{categoryId}/products",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> addProductIntoCategory(@PathVariable Long categoryId, @RequestBody Product product){
        try {
            Category categorySaved = categoryService.addProductIntoCategory(categoryId, product);
            return new ResponseEntity<>(categorySaved, HttpStatus.OK);
        }catch(ProductAlreadyExistsException | CategoryNotFoundException | ProductNotFoundException ex){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method= RequestMethod.POST, value="/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws CategoryAlreadyExistsException {
        try {
            Category categorySaved = categoryService.createCategory(category);
            return new ResponseEntity<>(categorySaved, HttpStatus.OK);
        }catch(CategoryAlreadyExistsException | CategoryNotFoundException  ex){
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }

    }


}
