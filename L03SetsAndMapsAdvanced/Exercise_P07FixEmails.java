package L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> emailsData = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                emailsData.put(name,email);
            }
            name = scanner.nextLine();
        }
        emailsData.entrySet().forEach(e ->System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
