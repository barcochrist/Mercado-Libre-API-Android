package com.programacionmaster.mercadolibreapijava.model;

import android.support.annotation.NonNull;

public class Resource {

    private String id;

    private String title;

    private String description;

    private String uri;

    private Resource() {
    }

    private Resource(String id, String title, String description, String uri) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.uri = uri;
    }

    /**
     * Factory method.
     *
     * @param id          Identifier
     * @param title       Title
     * @param description Description
     * @param uri         complete URI
     * @return A new Resource instance
     */
    public static Resource from(
            @NonNull String id,
            @NonNull String title,
            @NonNull String description,
            @NonNull String uri) {
        return new Resource(id, title, description, uri);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }
}
