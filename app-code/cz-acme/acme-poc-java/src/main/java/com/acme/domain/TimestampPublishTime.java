package com.acme.domain;

import com.google.cloud.Timestamp;

public class TimestampPublishTime {
    private Timestamp start;
    private Timestamp end;

    TimestampPublishTime(Timestamp start, Timestamp end) {
        this.start = start;
        this.end = end;
    }

    public TimestampPublishTime() {
    }

    public Timestamp getStart() {
        return start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Timestamp start;
        private Timestamp end;

        Builder() {
        }

        public Builder start(Timestamp start) {
            this.start = start;
            return this;
        }

        public Builder end(Timestamp end) {
            this.end = end;
            return this;
        }

        public TimestampPublishTime build() {
            return new TimestampPublishTime(start, end);
        }

        @Override
        public String toString() {
            return "TimestampPublishTime{" + "start=" + start + ", end=" + end + '}';
        }
    }
}
