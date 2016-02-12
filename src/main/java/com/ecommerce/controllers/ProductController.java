package com.ecommerce.controllers;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@link ProductController}
 * Handles product - related requests
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
     * Method that shows the form for adding a new product
     *
     * @return result page
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAdminForm() {
        return "view.admin_form";
    }

    /**
     * Method that create and add an object to the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param productDto
     * @param model
     * @return results page
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute ProductDto productDto, Model model) {

        if (!isValid(productDto)) {
            LOG.info("NOT_ACCEPTABLE");
        }
        Product product = new Product();
        model.addAttribute("title", productDto.getTitle());
        model.addAttribute("price", productDto.getPrice());
        model.addAttribute("description", productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        productService.save(product);
        return "view.created_prod";
    }


    /**
     * Method that receives all objects from the database
     * and return response with error message if something wrong. If everything ok -
     * returns list of objects
     *
     * @return formed result
     */

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllProduct(Model model) {
        List<Product> products = productService.getAll();
        if (CollectionUtils.isEmpty(products)) {
            return "Any product doesn't exist";
        }
        model.addAttribute("products", products);

        return "view.all_products";
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
    public String getOneById(@PathVariable(value = "productId") Long productId, Model model) {
        if (!productService.isProductExist(productId)) {
            return "Product doesn't exist";
        }
        Product product = productService.findOneById(productId);
        System.out.println(product);
        model.addAttribute("title", product.getTitle());
        model.addAttribute("description", product.getDescription());
        model.addAttribute("prodId", product.getId());
        model.addAttribute("price", product.getPrice());
        return "view.one_product";
    }

    /**
     * Method that delete an object by id from the database
     * and return response with error message if product doesn't exist . If everything ok -
     * response with success message
     *
     * @param productId
     * @return result, HttpStatus
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable Long productId) {
        if (!productService.isProductExist(productId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        productService.deleteById(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Method that validates data
     * return "false" - if the data is not valid or missing
     * If everything ok - return "true"
     *
     * @param productDto
     * @return result
     */
    public boolean isValid(ProductDto productDto) {
        if (productDto.getTitle() == null || productDto.getDescription() == null) {
            return false;
        }
        return true;
    }

}
