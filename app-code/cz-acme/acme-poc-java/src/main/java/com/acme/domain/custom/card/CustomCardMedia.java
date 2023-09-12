package com.acme.domain.custom.card;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "uri"})
public class CustomCardMedia {
    private String type;
    private String uri;

    public CustomCardMedia() {
    }

    public CustomCardMedia(String type, String uri) {
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
        CustomCardMedia that = (CustomCardMedia) o;
        return Objects.equals(type, that.type) && Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, uri);
    }

    @Override
    public String toString() {
        return "CustomCardMedia{" + "type='" + type + '\'' + ", uri='" + uri + '\'' + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String type;
        private String uri;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public CustomCardMedia build() {
            return new CustomCardMedia(type, uri);
        }
    }
}
