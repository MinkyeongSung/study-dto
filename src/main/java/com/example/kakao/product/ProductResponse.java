package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer productId;
        private String productName;
        private String image;
        private Integer price;

        public FindAllDTO(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();

        }

    }

    // (기능2) 상품 상세보기
    @Setter
    public static class FindByIdDTO {

    }

}