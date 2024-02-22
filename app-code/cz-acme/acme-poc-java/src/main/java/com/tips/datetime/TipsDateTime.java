package com.tips.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TipsDateTime {
    public static void main(String[] args) {
        var epochMillis = 1708300800000L;
        var zoneIdUTC = ZoneId.of("UTC");
        var zoneIdDefault = ZoneId.systemDefault();
        var dtUTC = convertToLocalDateTime(epochMillis, zoneIdUTC);
        var dtDefault = convertToLocalDateTime(epochMillis, zoneIdDefault);

        System.out.println("dt UTC => " + dtUTC);
        System.out.println("dt Default => " + dtDefault);
    }

    private static LocalDateTime convertToLocalDateTime(Long epochMillis, ZoneId zoneId) {
        if (epochMillis == null) return null;

        return Instant.ofEpochMilli(epochMillis).atZone(zoneId).toLocalDateTime();
    }
}
