package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.product.Product;
import com.example.loginauthapi.repositories.ProdutoRepository;
import com.example.loginauthapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "products";
    }

    @GetMapping("/form")
    public String formNovo(Model model) {
        model.addAttribute("produto", new Product());
        return "product-form";
    }

    @GetMapping("/form/{id}")
    public String formEditar(@PathVariable String id, Model model) {
        Product produto = service.buscarPorId(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "product-form";
    }

    @PostMapping("/save")
    public String salvar(Product produto) {
        service.criar(produto);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable String id) {
        service.deletar(id);
        return "redirect:/products";
    }
}


