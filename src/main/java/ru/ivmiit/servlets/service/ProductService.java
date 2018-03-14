package ru.ivmiit.servlets.service;


import ru.ivmiit.servlets.entity.Product;

import java.util.List;

public interface ProductService {

    void addProduct (Product product);
    void updateProduct(Product product);
    Product getByName (String name);
    List<Product> getAll ();
}
