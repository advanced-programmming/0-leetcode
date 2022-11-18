import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Mexico", "UK", "US", "Colombia", "Argentine");

        List<String> capitalLetter = list.stream().filter(country -> country.startsWith("U")).toList();
        System.out.println(capitalLetter);

        try {
           int  value = 9 / 0;
        } catch (Exception e) {
            System.err.printf("Error mapping operations", e.getMessage());
        } finally {
            System.out.printf("Error mapping operations");
            // to mapping other logging services
        }

        try (9 / 0) {
            int  value = 9 / 0;
        } catch (Exception e) {
            System.err.printf("Error mapping operations", e.getMessage());
        }



    }

}