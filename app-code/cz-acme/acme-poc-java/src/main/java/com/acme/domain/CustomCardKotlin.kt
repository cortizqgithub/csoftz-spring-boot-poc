package com.acme.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import java.util.Objects

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "actionType", "timeZone", "sortOrder", "publish", "sites", "media", "localeData", "updated")
class CustomCardKotlin {
    var id: String? = null
    var actionType: String? = null
    var timeZone: String? = null
    var updated: String? = null
    var sortOrder: Int? = null
    var sites: List<String>? = null
    var localeData: Map<String, CustomCardLocaleData>? = null
    var publish: StringPublishTime? = null

    constructor()
    constructor(
        id: String?, actionType: String?, timeZone: String?, updated: String?,
        sortOrder: Int?, sites: List<String>?, localeData: Map<String, CustomCardLocaleData>?, publish: StringPublishTime?
    ) {
        this.id = id
        this.actionType = actionType
        this.timeZone = timeZone
        this.updated = updated
        this.sortOrder = sortOrder
        this.sites = sites
        this.localeData = localeData
        this.publish = publish
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as CustomCardKotlin
        return id == that.id && actionType == that.actionType && timeZone == that.timeZone && updated == that.updated && sortOrder == that.sortOrder && sites == that.sites && localeData == that.localeData && publish == that.publish
    }

    override fun hashCode(): Int {
        return Objects.hash(id, actionType, timeZone, updated, sortOrder, sites, localeData, publish)
    }

    override fun toString(): String {
        return "CustomCardNew{" +
            "id='" + id + '\'' +
            ", actionType='" + actionType + '\'' +
            ", timeZone='" + timeZone + '\'' +
            ", updated='" + updated + '\'' +
            ", sortOrder=" + sortOrder +
            ", sites=" + sites +
            ", localeData=" + localeData +
            ", publish=" + publish +
            '}'
    }

    class Builder {
        private var id: String? = null
        private var actionType: String? = null
        private var timeZone: String? = null
        private var updated: String? = null
        private var sortOrder: Int? = null
        private var sites: List<String>? = null
        private var localeData: Map<String, CustomCardLocaleData>? = null
        private var publish: StringPublishTime? = null
        fun id(id: String?): Builder {
            this.id = id
            return this
        }

        fun actionType(actionType: String?): Builder {
            this.actionType = actionType
            return this
        }

        fun timeZone(timeZone: String?): Builder {
            this.timeZone = timeZone
            return this
        }

        fun updated(updated: String?): Builder {
            this.updated = updated
            return this
        }

        fun sortOrder(sortOrder: Int?): Builder {
            this.sortOrder = sortOrder
            return this
        }

        fun sites(sites: List<String>?): Builder {
            this.sites = sites
            return this
        }

        fun localeData(localeData: Map<String, CustomCardLocaleData>?): Builder {
            this.localeData = localeData
            return this
        }

        fun publish(publish: StringPublishTime?): Builder {
            this.publish = publish
            return this
        }

        fun build(): CustomCardKotlin {
            return CustomCardKotlin(id, actionType, timeZone, updated, sortOrder, sites, localeData, publish)
        }
    }

    companion object {
        fun builder(): Builder {
            return Builder()
        }
    }
}
