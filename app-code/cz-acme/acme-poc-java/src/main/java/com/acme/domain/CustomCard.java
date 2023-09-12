package com.acme.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id", "title", "description", "actionType",
    "timeZone", "sortOrder", "publish",
    "sites", "media", "callToAction",
    "updated", "newField"
})
public class CustomCard {

    private String id;
    private String actionType;
    private String title;
    private String description;
    private String timeZone;
    private String newField;
    private String updated;

    private Integer sortOrder;
    private List<String> sites;
    private StringPublishTime publish;
    private CustomCardMedia media;
    private CustomCardCallToAction callToAction;

    public CustomCard() {
    }

    public CustomCard(
        String id,
        String actionType,
        String title,
        String description,
        String timeZone,
        Integer sortOrder,
        List<String> sites,
        StringPublishTime publish,
        String updated,
        CustomCardMedia media,
        CustomCardCallToAction callToAction,
        String newField) {
        this.id = id;
        this.actionType = actionType;
        this.title = title;
        this.description = description;
        this.timeZone = timeZone;
        this.sortOrder = sortOrder;
        this.sites = sites;
        this.publish = publish;
        this.updated = updated;
        this.media = media;
        this.callToAction = callToAction;
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

    public StringPublishTime getPublish() {
        return publish;
    }

    public void setPublish(StringPublishTime publish) {
        this.publish = publish;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
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

    public String getNewField() {
        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }

    @Override
    public String toString() {
        return "CustomCard{"
            + "id='"
            + id
            + '\''
            + ", actionType='"
            + actionType
            + '\''
            + ", title='"
            + title
            + '\''
            + ", description='"
            + description
            + '\''
            + ", sortOrder="
            + sortOrder
            + ", sites="
            + sites
            + ", publish="
            + publish
            + ", updated='"
            + updated
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

        private String id;
        private String actionType;
        private String title;
        private String description;
        private String timeZone;
        private Integer sortOrder;
        private List<String> sites;
        private StringPublishTime publish;
        private String updated;
        private CustomCardMedia media;
        private CustomCardCallToAction callToAction;
        private String newField;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

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

        public Builder publish(StringPublishTime publish) {
            this.publish = publish;
            return this;
        }

        public Builder updated(String updated) {
            this.updated = updated;
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

        public Builder newField(String newField) {
            this.newField = newField;
            return this;
        }

        public CustomCard build() {
            return new CustomCard(
                id,
                actionType,
                title,
                description,
                timeZone,
                sortOrder,
                sites,
                publish,
                updated,
                media,
                callToAction,
                newField);
        }
    }
}
