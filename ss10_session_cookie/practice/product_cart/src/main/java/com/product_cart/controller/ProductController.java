package com.product_cart.controller;

import com.product_cart.dto.CartDto;
import com.product_cart.dto.ProductDto;
import com.product_cart.model.Product;
import com.product_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/")
    public String showListProduct(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        model.addAttribute("productList", iProductService.findAll());
        return "product/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("product", iProductService.findById(id).get());
        return "product/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/minus/{id}")
    public String minusProduct(@PathVariable Long id, @ModelAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.minusProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDetail.get(), productDto);
        cart.remove(productDto);
        return "redirect:/cart";
    }
}
