package com.acme.domain.custom.card.request;

import com.acme.domain.custom.card.CustomCardLocaleData;
import com.acme.domain.custom.card.StringPublishTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "actionType", "timeZone", "sortOrder", "publish", "sites", "localeData"})
public class CustomCardRequest {
    private String id;
    private String actionType;
    private String timeZone;

    private Integer sortOrder;
    private List<String> sites;
    private Map<String, CustomCardLocaleData> localeData;
    private StringPublishTime publish;

    public CustomCardRequest() {
    }

    public CustomCardRequest(
        String id,
        String actionType,
        String timeZone,
        Integer sortOrder,
        List<String> sites,
        Map<String, CustomCardLocaleData> localeData,
        StringPublishTime publish) {
        this.id = id;
        this.actionType = actionType;
        this.timeZone = timeZone;
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
        CustomCardRequest that = (CustomCardRequest) o;
        return Objects.equals(id, that.id)
            && Objects.equals(actionType, that.actionType)
            && Objects.equals(timeZone, that.timeZone)
            && Objects.equals(sortOrder, that.sortOrder)
            && Objects.equals(sites, that.sites)
            && Objects.equals(localeData, that.localeData)
            && Objects.equals(publish, that.publish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionType, timeZone, sortOrder, sites, localeData, publish);
    }

    @Override
    public String toString() {
        return "CustomCardRequest{"
            + "id='"
            + id
            + '\''
            + ", actionType='"
            + actionType
            + '\''
            + ", timeZone='"
            + timeZone
            + '\''
            + ", sortOrder="
            + sortOrder
            + ", sites="
            + sites
            + ", localeData="
            + localeData
            + ", publish="
            + publish
            + '}';
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

        public CustomCardRequest build() {
            return new CustomCardRequest(id, actionType, timeZone, sortOrder, sites, localeData, publish);
        }
    }
}
