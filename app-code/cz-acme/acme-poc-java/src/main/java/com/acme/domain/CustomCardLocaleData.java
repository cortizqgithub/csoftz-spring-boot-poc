package com.acme.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title", "description", "ctaLabel", "media", "callToAction"
})
public class CustomCardLocaleData {
    private String title;
    private String description;
    private String ctaLabel;

    private CustomCardMedia media;
    private CustomCardCallToActionNew callToAction;

    public CustomCardLocaleData() {
    }

    public CustomCardLocaleData(String title, String description, String ctaLabel, CustomCardMedia media, CustomCardCallToActionNew callToAction) {
        this.title = title;
        this.description = description;
        this.ctaLabel = ctaLabel;
        this.media = media;
        this.callToAction = callToAction;
    }

    public String getTitle() {
        return title;
    }

    public CustomCardLocaleData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CustomCardLocaleData setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCtaLabel() {
        return ctaLabel;
    }

    public CustomCardLocaleData setCtaLabel(String ctaLabel) {
        this.ctaLabel = ctaLabel;
        return this;
    }

    public CustomCardMedia getMedia() {
        return media;
    }

    public CustomCardLocaleData setMedia(CustomCardMedia media) {
        this.media = media;
        return this;
    }

    public CustomCardCallToActionNew getCallToAction() {
        return callToAction;
    }

    public CustomCardLocaleData setCallToAction(CustomCardCallToActionNew callToAction) {
        this.callToAction = callToAction;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCardLocaleData that = (CustomCardLocaleData) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(ctaLabel, that.ctaLabel) && Objects.equals(media, that.media) && Objects.equals(callToAction, that.callToAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, ctaLabel, media, callToAction);
    }

    @Override
    public String toString() {
        return "CustomCardLocaleData{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", ctaLabel='" + ctaLabel + '\'' +
            ", media=" + media +
            ", callToAction=" + callToAction +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String description;
        private String ctaLabel;

        private CustomCardMedia media;
        private CustomCardCallToActionNew callToAction;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder ctaLabel(String ctaLabel) {
            this.ctaLabel = ctaLabel;
            return this;
        }

        public Builder media(CustomCardMedia media) {
            this.media = media;
            return this;
        }

        public Builder callToAction(CustomCardCallToActionNew callToAction) {
            this.callToAction = callToAction;
            return this;
        }

        public CustomCardLocaleData build() {
            return new CustomCardLocaleData(title, description, ctaLabel, media, callToAction);
        }
    }
}
