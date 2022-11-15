import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static Map<Character, Integer> ROMAN_NUMBERS =  Map.ofEntries(
            Map.entry('I', 1)
            ,Map.entry('V', 5)
            ,Map.entry('X', 10)
            ,Map.entry('L', 50)
            ,Map.entry('C', 100)
            ,Map.entry('D', 500)
            ,Map.entry('M', 1000)
    );

    public static void main(String[] args) {
        String romanNumber = getCase();
        int number = romanToInt(romanNumber);
        System.out.println(number);
    }

    private static int romanToInt(String romanNumber) {
        romanNumber = romanValidations(romanNumber);
        String finalRomanNumber = romanNumber;
        return IntStream.range(0, romanNumber.length()).map(i -> ROMAN_NUMBERS.get(finalRomanNumber.charAt(i))).sum();
    }

    private static String romanValidations(String romanNumber) {
        romanNumber = romanNumber.contains("IV") ? romanNumber.replace("IV", "IIII") : romanNumber;
        romanNumber = romanNumber.contains("IX") ? romanNumber.replace("IX", "VIIII") : romanNumber;
        romanNumber = romanNumber.contains("CM") ? romanNumber.replace("CM", "DCCCC") : romanNumber;
        romanNumber = romanNumber.contains("XC") ? romanNumber.replace("XC", "LXXXX") : romanNumber;
        romanNumber = romanNumber.contains("XL") ? romanNumber.replace("XL", "XXXX") : romanNumber;
        romanNumber = romanNumber.contains("CD") ? romanNumber.replace("CD", "CCCC") : romanNumber;
        return romanNumber;
    }

    private static String getCase() {
        //return "MCMXCIV";
        return "LVIII";
    }
}