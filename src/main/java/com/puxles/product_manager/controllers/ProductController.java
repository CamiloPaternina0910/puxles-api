package com.puxles.product_manager.controllers;

import com.puxles.product_manager.dtos.DataPage;
import com.puxles.product_manager.dtos.GeneralResponse;
import com.puxles.product_manager.dtos.PricesDto;
import com.puxles.product_manager.dtos.ProductDto;
import com.puxles.product_manager.entities.Product;
import com.puxles.product_manager.mappers.ProductMapper;
import com.puxles.product_manager.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/new")
    public ResponseEntity<GeneralResponse> createProduct(@Valid @RequestBody ProductDto productDto){
        productService.save(productMapper.toEntity(productDto));
        return new ResponseEntity<>(GeneralResponse.builder()
                .error(false)
                .status(200)
                .data("Product create")
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<GeneralResponse> getAllProducts(@ModelAttribute DataPage dataPage){
        Page<ProductDto> dtos = productMapper.toDto(productService.findAll(dataPage.getPage(), dataPage.getElements()));
        return new ResponseEntity<>(GeneralResponse.builder()
                .error(false)
                .status(200)
                .data(dtos)
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/filter/by/name")
    public ResponseEntity<GeneralResponse> filterByName(@RequestParam("name") String name){
         List<Product> products = productService.findByName(name);
         return new ResponseEntity<>(GeneralResponse.builder()
                 .error(false)
                 .status(200)
                 .data(productMapper.toDto(products))
                 .build(),
                 HttpStatus.OK);
    }

    @GetMapping("/filter/by/price")
    public ResponseEntity<GeneralResponse> filterByPrice(@RequestBody PricesDto prices, @ModelAttribute DataPage dataPage){
        Page<Product> products = productService.findByPrice(prices.getPrice1(),prices.getPrice2()   , dataPage.getPage(), dataPage.getElements());
        return new ResponseEntity<>(GeneralResponse.builder()
                .error(false)
                .status(200)
                .data(productMapper.toDto(products))
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getById(@ModelAttribute Long id){
        Product product = productService.findById(id);
        return new ResponseEntity<>(GeneralResponse.builder()
                .error(false)
                .status(200)
                .data(productMapper.toDto(product))
                .build(),
                HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteProduct(@PathVariable Long id){
        Product product = productService.findById(id);
        productService.remove(product);
        return new ResponseEntity<>(GeneralResponse.builder()
                .error(false)
                .status(200)
                .data("Product delete")
                .build(),
                HttpStatus.OK);
    }
}
