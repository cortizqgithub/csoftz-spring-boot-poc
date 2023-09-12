package com.acme.domain;


public class CustomCardCallToAction {
    private String label;
    private String type;
    private String uri;

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
}
