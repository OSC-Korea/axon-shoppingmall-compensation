package com.axon.order.controller;

import com.axon.order.dto.ProductCreateDto;
import com.axon.order.entity.ProductEntity;
import com.axon.order.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "*")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductEntity>> getProducts() throws ExecutionException, InterruptedException {
        List<ProductEntity> productEntities = productService.getProducts();
        return ResponseEntity.ok(productEntities);

    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> productCreate(@RequestBody ProductCreateDto productCreateDto) {
        String productId = productService.createProduct(productCreateDto.getName(),
                BigDecimal.valueOf(productCreateDto.getPrice()),
                productCreateDto.getQuantity());
        HashMap<String, String> m = new HashMap<>();
        m.put("productId", productId);
        m.put("productName", productCreateDto.getName());

        return ResponseEntity.ok(m);
    }
}
