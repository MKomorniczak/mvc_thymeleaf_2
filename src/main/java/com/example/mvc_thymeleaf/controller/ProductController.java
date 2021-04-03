package com.example.mvc_thymeleaf.controller;

import com.example.mvc_thymeleaf.dto.ProductDetailsDto;
import com.example.mvc_thymeleaf.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<ProductDto> productDtoList;

@PostConstruct
    public void init() {
        if (productDtoList == null) productDtoList = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setPrice(20);
        productDto.setName("OCA BOOK");

        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setId(1);
        productDetailsDto.setName("Test");
        productDetailsDto.setDescription("Test description");

        productDto.setProductDetailsDto(productDetailsDto);
        productDtoList.add(productDto);

    ProductDto productDto2 = new ProductDto();
    productDto2.setId(2);
    productDto2.setPrice(50);
    productDto2.setName("OCP BOOK");

    ProductDetailsDto productDetailsDto2 = new ProductDetailsDto();
    productDetailsDto2.setId(2);
    productDetailsDto2.setName("Test2");
    productDetailsDto2.setDescription("Test description 2");

    productDto2.setProductDetailsDto(productDetailsDto2);
    productDtoList.add(productDto2);
    }

@GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("productDtoList", productDtoList);
        return "productList";
    }

}
