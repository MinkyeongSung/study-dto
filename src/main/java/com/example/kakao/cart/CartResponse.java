package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    // (기능3) 장바구니 조회
    // 내가 지금 디비에서 조회한 Entity가 머지?
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(List<Cart> cartList) {
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getPrice()).sum();
            this.products = cartList.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(product, cartList))
                    .collect(Collectors.toList());
        }

        @Getter @Setter
        class ProductDTO {
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> carts) {
                this.productName = product.getProductName();
                this.carts = carts.stream()
                                .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                                .map(cart -> new CartDTO(cart))
                                .collect(Collectors.toList());
            }

            @Getter @Setter
            class CartDTO {
                private String cartOptionName;
                private Integer cartQuantity;
                private Integer cartPrice;

                public CartDTO(Cart cart) {
                    this.cartOptionName = cart.getOption().getOptionName();
                    this.cartQuantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                }


            }
        }
    }
}

// public class CartResponse {

//     // (기능3) 장바구니 조회

//     @ToString
//     @Getter
//     @Setter
//     public static class FindAllByUserDTO {
//         private Integer totalPrice;
//         private List<ProductDTO> products;

//         public FindAllByUserDTO(Integer totalPrice, List<Cart> cartList) {
//             this.totalPrice = totalPrice;

//             this.products = cartList.stream()
//                     .map(c -> c.getOption().getProduct()).distinct()
//                     .map(c -> new ProductDTO(c.getOption().getProduct(), cartList))                    
//                     .collect(Collectors.toList());
//         }

//         @Getter
//         @Setter
//         public class ProductDTO {
//             private Integer productId;
//             private String produceName;
//             private List<CartDTO> carts;

//             public ProductDTO(Product product, List<Cart> cartList) {
//                 this.productId = product.getId();
//                 this.produceName = product.getProductName();
//                 this.carts = cartList.stream()
//                         .map(c -> new CartDTO(c))
//                         .collect(Collectors.toList());
//             }

//             @Getter
//             @Setter
//             public class CartDTO {
//                 private Integer cartId;
//                 private Integer quantity;
//                 private Integer cartprice;
//                 private Integer opationId;
//                 private String optionName;
//                 private Integer optionPrice;

//                 public CartDTO(Cart cart) {
//                     this.cartId = cart.getId();
//                     this.quantity = cart.getQuantity();
//                     this.cartprice = cart.getPrice();
//                     this.opationId = cart.getOption().getId();
//                     this.optionName = cart.getOption().getOptionName();
//                     this.optionPrice = cart.getOption().getPrice();
//                 }
//             }
//         }
//     }
// }


