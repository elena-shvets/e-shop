package com.ecommerce.model;

/**
 * Class {@link com.ecommerce.model.MediaType}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */

public enum MediaType {
    VIDEO("video"),
    IMAGE("image");

    MediaType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public static MediaType getMediaType(String type) {
        if (type.startsWith("video/")) return MediaType.VIDEO;
        if (type.startsWith("image/")) return MediaType.IMAGE;
        return null;
    }
}
