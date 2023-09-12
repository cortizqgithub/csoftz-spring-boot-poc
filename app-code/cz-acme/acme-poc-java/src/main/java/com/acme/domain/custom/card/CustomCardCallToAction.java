package com.acme.domain.custom.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"label", "type", "uri"})
public class CustomCardCallToAction {
    private String label;
    private String type;
    private String uri;

    public CustomCardCallToAction() {
    }

    public CustomCardCallToAction(String label, String type, String uri) {
        this.label = label;
        this.type = type;
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        CustomCardCallToAction that = (CustomCardCallToAction) o;
        return Objects.equals(label, that.label)
            && Objects.equals(type, that.type)
            && Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, type, uri);
    }

    @Override
    public String toString() {
        return "CustomCardCallToAction{"
            + "label='"
            + label
            + '\''
            + ", type='"
            + type
            + '\''
            + ", uri='"
            + uri
            + '\''
            + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String label;
        private String type;
        private String uri;

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public CustomCardCallToAction build() {
            return new CustomCardCallToAction(label, type, uri);
        }
    }
}
