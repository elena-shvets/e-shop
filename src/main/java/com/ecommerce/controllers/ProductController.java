package com.ecommerce.controllers;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@link com.ecommerce.controllers.ProductController}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger LOG = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * Method that create and add an object to the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param productDto
     * @return result
     * *
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        if(productDto == null){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        productService.save(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    /**
     * Method that receives all objects from the database
     * and return response with error message if something wrong. If everything ok -
     * returns list of objects
     *
     * @return formed result
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Product> getAllProducts() {
    public String getAllProducts() {
        List<Product> products = productService.getAll();
//        if (CollectionUtils.isEmpty(products)) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(products, HttpStatus.OK);
        return "test";
    }

    /**
     * Method that receives an object by id from the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param productId
     * @return result
     * *
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getOneById(@PathVariable Long productId) {
        if (!productService.isProductExist(productId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(productService.findOneById(productId), HttpStatus.OK);
    }

}
