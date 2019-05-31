package com.redisdb.training.service;

import com.redisdb.training.repository.CategoryRepository;
import com.redisdb.training.constants.DemoAppConstants;
import com.redisdb.training.entity.Category;
import com.redisdb.training.entity.Product;
import com.redisdb.training.exception.CategoryAlreadyExistsException;
import com.redisdb.training.exception.CategoryNotFoundException;
import com.redisdb.training.exception.ProductAlreadyExistsException;
import com.redisdb.training.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private IProductService productService;


    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException {
        return Optional.of(categoryRepository.findBycategoryId(categoryId)).orElseThrow(() -> new CategoryNotFoundException(DemoAppConstants.CATEGORY_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public Category findCategoryByName(String name) throws CategoryNotFoundException {
        return Optional.of(categoryRepository.findByname(name)).orElseThrow(() -> new CategoryNotFoundException(DemoAppConstants.CATEGORY_NOT_FOUND_ERROR_MESSAGE));
    }

    private Long getMaxNumberOfLetters(TreeMap<String, Long> map){
        return map.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();
    }

    private List<String> getListOfMaxOccurrencesOfOneLetter(TreeMap<String, Long> map){

        Long maxNumberOfOccurrence = getMaxNumberOfLetters(map);

       return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxNumberOfOccurrence && maxNumberOfOccurrence > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


    }

    @Override
    public List<Category> findCategoryByLetterOccurrence(char letter) throws CategoryNotFoundException {

        List<Category> categories = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        TreeMap<String, Long> map = new TreeMap<>();

        categories.forEach(category -> map.put(category.getName(), category.getName().chars().filter(ch -> ch == letter).count()));
        List<String> maxOccurrencesOfLetter = getListOfMaxOccurrencesOfOneLetter(map);
        maxOccurrencesOfLetter.stream().forEach(categoryName -> categoryList.add(this.categoryRepository.findByname(categoryName)));

        return categoryList;
    }


    @Override
    public Category addProductIntoCategory(Long categoryId, Product product) throws ProductAlreadyExistsException, CategoryNotFoundException,ProductNotFoundException {
           Category category = this.findCategoryById(categoryId);
           category.addProduct(product);
           categoryRepository.save(category);
           return category;


    }

    @Override
    public Category createCategory(Category category) throws CategoryAlreadyExistsException, CategoryNotFoundException{

        Category newCategory = this.categoryRepository.findBycategoryId(category.getCategoryId());

        if(newCategory == null){
            this.categoryRepository.save(category);
        }else{
            throw new CategoryAlreadyExistsException(DemoAppConstants.CATEGORY_ALREADY_EXISTS_ERROR_MESSAGE);
        }
        return newCategory;
    }


}
