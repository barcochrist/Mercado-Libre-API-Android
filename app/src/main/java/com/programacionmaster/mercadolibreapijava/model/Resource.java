package com.programacionmaster.mercadolibreapijava.model;

import android.support.annotation.NonNull;

import com.programacionmaster.mercadolibreapijava.enums.HttpMethod;
import com.programacionmaster.mercadolibreapijava.enums.ResourceType;

import java.io.Serializable;

public class Resource implements Serializable {

    @NonNull
    private String id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String uri;

    @NonNull
    private ResourceType type;

    @NonNull
    private HttpMethod method;

    private Resource() {
    }

    private Resource(String id, String title, String description,
                     String uri, ResourceType type, HttpMethod method) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.uri = uri;
        this.type = type;
        this.method = method;
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
            @NonNull String uri,
            @NonNull ResourceType type,
            @NonNull HttpMethod method) {
        return new Resource(id, title, description, uri, type, method);
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

    public ResourceType getType() {
        return type;
    }

    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", uri='" + uri + '\'' +
                ", type=" + type +
                ", method=" + method +
                '}';
    }
}
