package com.example.loginauthapi.service;

import com.example.loginauthapi.domain.product.Product;
import com.example.loginauthapi.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProdutoRepository repository;

    public List<Product> listarTodos() {
        return repository.findAll();
    }

    public Optional<Product> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Product criar(Product product) {
        return repository.save(product);
    }

    public Optional<Product> atualizar(String id, Product novo) {
        return repository.findById(id).map(product -> {
            product.setName(novo.getName());
            product.setDescription(novo.getDescription());
            product.setPrice(novo.getPrice());
            product.setAmount(novo.getAmount());
            product.setCategory(novo.getCategory());
            return repository.save(product);
        });
    }

    public boolean deletar(String id) {
        return repository.findById(id).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
    }
}
