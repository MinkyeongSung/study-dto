package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회

    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(Integer totalPrice, List<Cart> cartList) {
            this.totalPrice = totalPrice;

            this.products = cartList.stream()
                    .map(c -> c.getOption().getProduct()).distinct()
                    .map(c -> new ProductDTO(c.getOption().getProduct(), cartList))                    
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer productId;
            private String produceName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> cartList) {
                this.productId = product.getId();
                this.produceName = product.getProductName();
                this.carts = cartList.stream()
                        .map(c -> new CartDTO(c))
                        .collect(Collectors.toList());
            }

            @Getter
            @Setter
            public class CartDTO {
                private Integer cartId;
                private Integer quantity;
                private Integer cartprice;
                private Integer opationId;
                private String optionName;
                private Integer optionPrice;

                public CartDTO(Cart cart) {
                    this.cartId = cart.getId();
                    this.quantity = cart.getQuantity();
                    this.cartprice = cart.getPrice();
                    this.opationId = cart.getOption().getId();
                    this.optionName = cart.getOption().getOptionName();
                    this.optionPrice = cart.getOption().getPrice();
                }
            }
        }
    }
}
