package com.ecommerce.controllers;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    static final int DEFAULT_PAGE_SIZE = 6;

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

//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    public String getAllProduct(Model model) {
//        List<Product> products = productService.getAll();
//        if (CollectionUtils.isEmpty(products)) {
//            return "Any product doesn't exist";
//        }
//        model.addAttribute("products", products);
//
//        return "view.all_products";
//    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getSortedProduct(HttpServletRequest request, Model model,  @PageableDefault Pageable pageable) {
        String param = request.getParameter("sort");

        ArrayList<String> sorts = new ArrayList<String>(Arrays.asList( "title", "price_asc", "price_desc"));
        if(!sorts.contains(param)){
            param = "title";
        }
        List<Product> products;

        if(param.equals("title")) {
            products  = productService.getProductSortedByTitle();
//            Page<Product> page = (Page<Product>)  sort_products;
            if (CollectionUtils.isEmpty(products)) {
                return "Any product doesn't exist";
            }
            model.addAttribute("products",  products);
        }

        if(param.equals("price_asc")) {
            products  = productService.getProductSortedByPrice();
//            Page<Product> page = (Page<Product>)  sort_products;
            if (CollectionUtils.isEmpty(products)) {
                return "Any product doesn't exist";
            }
            model.addAttribute("products",  products);

        }
        if(param.equals("price_desc")){
            products  = productService.getProductSortedByPrice();
            if (CollectionUtils.isEmpty(products)) {
                return "Any product doesn't exist";
            }
            Collections.reverse(products);

            model.addAttribute("products",  products);
        }

        return "view.all_products";
    }

    @RequestMapping( method = RequestMethod.GET)
    public String showFindForm(){
        return "view.find";
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
        findOne(productId,model);
        return "view.one_product";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String getOne(HttpServletRequest request, Model model) {

        String param = request.getParameter("search");
        Long productId = Long.parseLong(param);
        if (!productService.isProductExist(productId)) {
            return "Product doesn't exist";
        }

        findOne(productId,model);
        return "view.one_product";
    }


    private Product findOne(Long productId, Model model){
        Product product = productService.findOneById(productId);
        model.addAttribute("title", product.getTitle());
        model.addAttribute("description", product.getDescription());
        model.addAttribute("prodId", product.getId());
        model.addAttribute("price", product.getPrice());
        return product;
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
    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
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
