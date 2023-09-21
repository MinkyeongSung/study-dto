package com.example.kakao.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakao._core.utils.ApiUtils;
import com.example.kakao.product.option.Option;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService; // 자바에서 final 변수는 반드시 초기화되어야 함.
    private final HttpSession session;

    // (기능1) 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return null;
    }

    // (기능2) 상품 상세보기
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        
        return null;
    }

}