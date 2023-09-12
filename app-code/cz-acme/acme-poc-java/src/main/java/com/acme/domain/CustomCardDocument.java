package com.acme.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.cloud.Timestamp;
import java.util.List;

@JsonPropertyOrder({
    "id", "title", "description", "actionType",
    "timeZone", "sortOrder", "publish",
    "sites", "media", "callToAction",
    "updated", "newField"
})
public class CustomCardDocument {

    private String id;
    private String actionType;
    private String title;
    private String description;
    private String timeZone;
    private String newField;

    private Integer sortOrder;
    private List<String> sites;
    private TimestampPublishTime publish;
    private CustomCardMedia media;
    private CustomCardCallToAction callToAction;
    private Timestamp updated;

    CustomCardDocument() {
    }

    CustomCardDocument(
        String actionType,
        String title,
        String description,
        String timeZone,
        Integer sortOrder,
        List<String> sites,
        TimestampPublishTime publish,
        CustomCardMedia media,
        CustomCardCallToAction callToAction,
        Timestamp updated,
        String newField) {
        this.actionType = actionType;
        this.title = title;
        this.description = description;
        this.timeZone = timeZone;
        this.sortOrder = sortOrder;
        this.sites = sites;
        this.publish = publish;
        this.media = media;
        this.callToAction = callToAction;
        this.updated = updated;
        this.newField = newField;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<String> getSites() {
        return sites;
    }

    public void setSites(List<String> sites) {
        this.sites = sites;
    }

    public TimestampPublishTime getPublish() {
        return publish;
    }

    public void setPublish(TimestampPublishTime publish) {
        this.publish = publish;
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

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getNewField() {
        return newField;
    }

    public CustomCardDocument setNewField(String newField) {
        this.newField = newField;
        return this;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String actionType;
        private String title;
        private String description;
        private String timeZone;
        private Integer sortOrder;
        private List<String> sites;
        private TimestampPublishTime publish;
        private CustomCardMedia media;
        private CustomCardCallToAction callToAction;
        private Timestamp updated;
        private String newField;

        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder timeZone(String timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public Builder sortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Builder sites(List<String> sites) {
            this.sites = sites;
            return this;
        }

        public Builder publish(TimestampPublishTime publish) {
            this.publish = publish;
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

        public Builder updated(Timestamp updated) {
            this.updated = updated;
            return this;
        }

        public Builder newField(String newField) {
            this.newField = newField;
            return this;
        }

        public CustomCardDocument build() {
            return new CustomCardDocument(
                actionType,
                title,
                description,
                timeZone,
                sortOrder,
                sites,
                publish,
                media,
                callToAction,
                updated,
                newField);
        }
    }
}
