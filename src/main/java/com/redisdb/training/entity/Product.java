package com.redisdb.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PRODUCT")
@Getter
@Setter
@EqualsAndHashCode
public class Product {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "PRODUCT_ID", length = 20)
    private Long productId;

    @Column(name = "PRODUCT_NAME", length = 50)
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION", length = 80)
    private String description;

    @Column(name = "PRODUCT_COST", length = 30)
    private Double cost;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Category> categories = new ArrayList();

}
