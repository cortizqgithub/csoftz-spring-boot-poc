package com.acme.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id", "actionType",
    "timeZone", "sortOrder", "publish",
    "sites", "media", "localeData",
    "updated"
})
public class CustomCardNew {

    private String id;
    private String actionType;
    private String timeZone;
    private String updated;

    private Integer sortOrder;
    private List<String> sites;
    private Map<String, CustomCardLocaleData> localeData;
    private StringPublishTime publish;


    public CustomCardNew() {
    }

    public CustomCardNew(String id, String actionType, String timeZone, String updated,
                         Integer sortOrder, List<String> sites, Map<String, CustomCardLocaleData> localeData, StringPublishTime publish) {
        this.id = id;
        this.actionType = actionType;
        this.timeZone = timeZone;
        this.updated = updated;
        this.sortOrder = sortOrder;
        this.sites = sites;
        this.localeData = localeData;
        this.publish = publish;
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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
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

    public Map<String, CustomCardLocaleData> getLocaleData() {
        return localeData;
    }

    public void setLocaleData(Map<String, CustomCardLocaleData> localeData) {
        this.localeData = localeData;
    }

    public StringPublishTime getPublish() {
        return publish;
    }

    public void setPublish(StringPublishTime publish) {
        this.publish = publish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCardNew that = (CustomCardNew) o;
        return Objects.equals(id, that.id) && Objects.equals(actionType, that.actionType) && Objects.equals(timeZone, that.timeZone) && Objects.equals(updated, that.updated) && Objects.equals(sortOrder, that.sortOrder) && Objects.equals(sites, that.sites) && Objects.equals(localeData, that.localeData) && Objects.equals(publish, that.publish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionType, timeZone, updated, sortOrder, sites, localeData, publish);
    }

    @Override
    public String toString() {
        return "CustomCardNew{" +
            "id='" + id + '\'' +
            ", actionType='" + actionType + '\'' +
            ", timeZone='" + timeZone + '\'' +
            ", updated='" + updated + '\'' +
            ", sortOrder=" + sortOrder +
            ", sites=" + sites +
            ", localeData=" + localeData +
            ", publish=" + publish +
            '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String actionType;
        private String timeZone;
        private String updated;

        private Integer sortOrder;
        private List<String> sites;
        private Map<String, CustomCardLocaleData> localeData;
        private StringPublishTime publish;

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

        public Builder updated(String updated) {
            this.updated = updated;
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

        public Builder localeData(Map<String, CustomCardLocaleData> localeData) {
            this.localeData = localeData;
            return this;
        }

        public Builder publish(StringPublishTime publish) {
            this.publish = publish;
            return this;
        }

        public CustomCardNew build() {
            return new CustomCardNew(id, actionType, timeZone, updated, sortOrder, sites, localeData, publish);
        }
    }
}
