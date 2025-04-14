package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Product, String> {
}
