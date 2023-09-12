package com.acme.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.cloud.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
    "id", "title", "description", "actionType",
    "timeZone", "sortOrder", "publish",
    "sites", "media", "callToAction",
    "updated", "newField"
})
public class CustomCardDocumentNew {

    private String id;
    private String actionType;
    private String timeZone;

    private Integer sortOrder;
    private List<String> sites;
    private TimestampPublishTime publish;
    private Map<String, CustomCardLocaleData> localeData;
    private Timestamp updated;

    CustomCardDocumentNew() {
    }

    public CustomCardDocumentNew(String id, String actionType, String timeZone, Integer sortOrder,
                                 List<String> sites, TimestampPublishTime publish, Map<String, CustomCardLocaleData> localeData, Timestamp updated) {
        this.id = id;
        this.actionType = actionType;
        this.timeZone = timeZone;
        this.sortOrder = sortOrder;
        this.sites = sites;
        this.publish = publish;
        this.localeData = localeData;
        this.updated = updated;
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

    public Map<String, CustomCardLocaleData> getLocaleData() {
        return localeData;
    }

    public void setLocaleData(Map<String, CustomCardLocaleData> localeData) {
        this.localeData = localeData;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCardDocumentNew that = (CustomCardDocumentNew) o;
        return Objects.equals(id, that.id) && Objects.equals(actionType, that.actionType) && Objects.equals(timeZone, that.timeZone) && Objects.equals(sortOrder, that.sortOrder) && Objects.equals(sites, that.sites) && Objects.equals(publish, that.publish) && Objects.equals(localeData, that.localeData) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionType, timeZone, sortOrder, sites, publish, localeData, updated);
    }

    @Override
    public String toString() {
        return "CustomCardDocumentNew{" +
            "id='" + id + '\'' +
            ", actionType='" + actionType + '\'' +
            ", timeZone='" + timeZone + '\'' +
            ", sortOrder=" + sortOrder +
            ", sites=" + sites +
            ", publish=" + publish +
            ", localeData=" + localeData +
            ", updated=" + updated +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String actionType;
        private String timeZone;

        private Integer sortOrder;
        private List<String> sites;
        private TimestampPublishTime publish;
        private Map<String, CustomCardLocaleData> localeData;
        private Timestamp updated;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder actionType(String actionType) {
            this.actionType = actionType;
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

        public Builder localeData(Map<String, CustomCardLocaleData> localeData) {
            this.localeData = localeData;
            return this;
        }

        public Builder updated(Timestamp updated) {
            this.updated = updated;
            return this;
        }

        public CustomCardDocumentNew build() {
            return new CustomCardDocumentNew(id, actionType, timeZone, sortOrder, sites, publish, localeData, updated);
        }
    }
}
