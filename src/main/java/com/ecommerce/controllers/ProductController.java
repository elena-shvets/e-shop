package com.ecommerce.controllers;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductCategoryDao;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Autowired
    private ProductCategoryDao categoryRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAdminForm() {
        return "view.admin_form";
    }

    /**
     * Method that create and add an object to the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     //     * @param productDto
     * @return result
     * *
     */
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
//        if (!isValid(productDto)) return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//        Product product = new Product();
//        product.setTitle(productDto.getTitle());
//        product.setPrice(productDto.getPrice());
//        product.setDescription(productDto.getDescription());
//               productService.save(product);
//        return new ResponseEntity<Product>(HttpStatus.OK);
//    }
    @RequestMapping(value="/created", method=RequestMethod.POST)
    public String createProduct(@ModelAttribute ProductDto productDto, Model model) throws IOException {
//        if(productDto == null){
//            return String.valueOf(HttpStatus.NOT_ACCEPTABLE);
//        }
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        model.addAttribute("created", product);
        productService.save(product);
        return "created_prod";
    }


    /**
     * Method that receives all objects from the database
     * and return response with error message if something wrong. If everything ok -
     * returns list of objects
     *
     * @return formed result
     */

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)

    public String getAllProduct() {
        List<Product> products = productService.getAll();
        if (CollectionUtils.isEmpty(products)) {
            return "Any product doesn't exist";
        }

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
    public String getOneById(@PathVariable Long productId, Model model) {
        if (!productService.isProductExist(productId)) {
            return "Product doesn't exist";
        }
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
    public ResponseEntity delete(@PathVariable long productId) {
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
//    public boolean isValid(ProductDto productDto) {
//        if (productDto.getTitle() == null || productDto.getCategory() == null) return false;
//        return true;
//    }
    public boolean isValid(ProductDto productDto) {
        if (productDto.getTitle() == null) return false;
        return true;
    }


//    class ProductEditor extends PropertyEditorSupport {
//
//        @Override
//        public void setAsText(String text) throws java.lang.IllegalArgumentException{
//
//            BigDecimal price = BigDecimal.valueOf(Long.parseLong(text));
//            Product product = new Product();
//            setValue(product);
//        }
//    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Product.class, new ProductEditor());
//
//    }
//    public static class NumberFormatUtil {
//        public static void registerDoubleFormat(WebDataBinder binder) {
//        binder.registerCustomEditor(Long.TYPE, new CustomerDoubleEditor());
//    }
//
//        private static class CustomerDoubleEditor extends PropertyEditorSupport {
//            public String getAsText() {
//            Long l = (Long) getValue();
//            return l.toString();
//        }
//
//            public void setAsText(String str) {
//            if (str == null || str.trim().equals(""))
//                setValue(0L);
//            else
//                setValue(Long.parseLong(str));
//        }
//
//        }
//    }
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        NumberFormatUtil.registerDoubleFormat(binder);
//    }
}
