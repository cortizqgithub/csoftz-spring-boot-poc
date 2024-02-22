package com.tips.java14;

/**
 * "Switch Expressions" (SE) instead of "Switch Statements" (SS)
 * (Both can be used, but SE is better than SS)
 */
public class SwitchExpressions {

    public static void main(String[] args) {

        oldStyleWithBreak(FruitType.APPLE);

        withSwitchExpression(FruitType.PEAR);

        switchExpressionWithReturn(FruitType.KIWI);

        switchWithYield(FruitType.PINEAPPLE);
    }

    // Old style is more verbose and error-prone (forgotten "break;" causes the switch to fall through)
    private static void oldStyleWithBreak(FruitType fruit) {
        System.out.println("==== Old style with break ====");
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("Common fruit");
                break;
            case PINEAPPLE, KIWI:
                System.out.println("Exotic fruit");
                break;
            default:
                System.out.println("Undefined fruit");
        }
    }

    private static void withSwitchExpression(FruitType fruit) {
        System.out.println("==== With switch expression ====");
        switch (fruit) {
            case APPLE, PEAR -> System.out.println("Common fruit");
            case PINEAPPLE -> System.out.println("Exotic fruit");
            default -> System.out.println("Undefined fruit");
        }
    }

    private static void switchExpressionWithReturn(FruitType fruit) {
        System.out.println("==== With return value ====");

        // or just "return switch" right away
        String text = switch (fruit) {
            case APPLE, PEAR -> "Common fruit";
            case PINEAPPLE -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    /**
     * "Yield" is like "return" but with an important difference:
     * "yield" returns a value and exits the switch statement. Execution stays within the enclosing method
     * "return" exits the switch and the enclosing method
     */
    // https://stackoverflow.com/questions/58049131/what-does-the-new-keyword-yield-mean-in-java-13
    private static void switchWithYield(FruitType fruit) {
        System.out.println("==== With yield ====");
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("the given fruit was: " + fruit);
                yield "Common fruit";
            }
            case PINEAPPLE -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    public enum FruitType {APPLE, PEAR, PINEAPPLE, KIWI}
}