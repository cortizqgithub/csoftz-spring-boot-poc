package com.tips.java14;

public class SwitchExpression {
    public static void main(String[] args) {
        int dayOfWeek = 2;
        String dayType = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };

        System.out.println(dayType);

        dayType = switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("Working day");
                yield "Weekday";
            }
            case 6, 7 -> {
                System.out.println("Weekend");
                yield "Weekend";
            }
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };

        System.out.println(dayType);
    }
}
