package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.product.Product;
import com.example.loginauthapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // Página que lista todos os produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "products";
    }

    // Página para criar um novo produto
    @GetMapping("/form")
    public String formNovo(Model model) {
        model.addAttribute("produto", new Product());
        return "product-form";
    }

    // Página para editar um produto existente onde carrega dados pelo ID
    @GetMapping("/form/{id}")
    public String formEditar(@PathVariable String id, Model model) {
        Product produto = service.buscarPorId(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "product-form";
    }

    // Salva um novo produto ou atualiza um existente
    @PostMapping("/save")
    public String salvar(Product produto) {
        service.criar(produto);
        return "redirect:/products";
    }

    // Exclui um produto pelo ID
    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable String id) {
        service.deletar(id);
        return "redirect:/products";
    }
}
