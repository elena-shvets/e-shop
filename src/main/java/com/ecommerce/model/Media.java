package com.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@link Media}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.10.15
 */

@Entity
@Table(name = "media")
@NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media as m")
public class Media implements Serializable {

    private Long id;
    private Long productId;
    private MediaType mediaType;
    private Long size;
    private String path;

    public Media() {
    }

    public Media(MediaType mediaType, Long size, String path) {
        this.mediaType = mediaType;
        this.size = size;
        this.path = path;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Enumerated(EnumType.STRING)
    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Column(name = "size")
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
