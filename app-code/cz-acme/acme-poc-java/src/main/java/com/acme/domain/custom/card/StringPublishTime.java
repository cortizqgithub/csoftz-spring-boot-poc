package com.acme.domain.custom.card;

import java.util.Objects;

public class StringPublishTime {
    private String start;
    private String end;

    public StringPublishTime() {
    }

    StringPublishTime(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringPublishTime that = (StringPublishTime) o;
        return Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "StringPublishTime{" + "start='" + start + '\'' + ", end='" + end + '\'' + '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String start;
        private String end;

        Builder() {
        }

        public Builder start(String start) {
            this.start = start;
            return this;
        }

        public Builder end(String end) {
            this.end = end;
            return this;
        }

        public StringPublishTime build() {
            return new StringPublishTime(start, end);
        }
    }
}
