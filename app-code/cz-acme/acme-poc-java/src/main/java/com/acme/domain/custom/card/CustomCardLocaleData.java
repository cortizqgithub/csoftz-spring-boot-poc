package com.acme.domain.custom.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "description", "ctaLabel", "media", "callToAction"})
public class CustomCardLocaleData {
    private String title;
    private String description;

    private CustomCardMedia media;
    private CustomCardCallToAction callToAction;

    public CustomCardLocaleData() {
    }

    public CustomCardLocaleData(String title, String description, CustomCardMedia media, CustomCardCallToAction callToAction) {
        this.title = title;
        this.description = description;
        this.media = media;
        this.callToAction = callToAction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomCardMedia getMedia() {
        return media;
    }

    public void setMedia(CustomCardMedia media) {
        this.media = media;
    }

    public CustomCardCallToAction getCallToAction() {
        return callToAction;
    }

    public void setCallToAction(CustomCardCallToAction callToAction) {
        this.callToAction = callToAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCardLocaleData that = (CustomCardLocaleData) o;
        return Objects.equals(title, that.title)
            && Objects.equals(description, that.description)
            && Objects.equals(media, that.media)
            && Objects.equals(callToAction, that.callToAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, media, callToAction);
    }

    @Override
    public String toString() {
        return "CustomCardLocaleData{"
            + "title='"
            + title
            + '\''
            + ", description='"
            + description
            + '\''
            + ", media="
            + media
            + ", callToAction="
            + callToAction
            + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String description;

        private CustomCardMedia media;
        private CustomCardCallToAction callToAction;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder media(CustomCardMedia media) {
            this.media = media;
            return this;
        }

        public Builder callToAction(CustomCardCallToAction callToAction) {
            this.callToAction = callToAction;
            return this;
        }

        public CustomCardLocaleData build() {
            return new CustomCardLocaleData(title, description, media, callToAction);
        }
    }
}
