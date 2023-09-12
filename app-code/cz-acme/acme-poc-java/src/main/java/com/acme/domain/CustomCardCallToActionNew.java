package com.acme.domain;


import java.util.Objects;

public class CustomCardCallToActionNew {
    private String type;
    private String uri;

    public CustomCardCallToActionNew() {
    }

    public CustomCardCallToActionNew(String type, String uri) {
        this.type = type;
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCardCallToActionNew that = (CustomCardCallToActionNew) o;
        return Objects.equals(type, that.type) && Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, uri);
    }

    @Override
    public String toString() {
        return "CustomCardCallToActionNew{" +
            "type='" + type + '\'' +
            ", uri='" + uri + '\'' +
            '}';
    }
}
