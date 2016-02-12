package com.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Class {@link com.ecommerce.dto.ProductCategoryDto}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 05.02.16
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductCategoryDto implements Serializable {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
