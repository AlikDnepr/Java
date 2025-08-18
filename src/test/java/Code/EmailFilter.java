package Code;

import java.util.*;

public class EmailFilter {

    public static void main(String[] args) {
        String[] emails = new String[20];
        System.out.println("Emails до исправления: ");
        for (int i = 0; i < emails.length; i++) {
            emails[i] = RandomCharFromSet() + DoubleAt() + RandomArrayElement();
            System.out.println(emails[i]);
        }

        List<String> correctedEmails = new ArrayList<>();

        for (String email : emails) {
            String fixed = toLowerCase(email);
            fixed = fixDoubleAt(fixed);
            fixed = removeForbiddenChars(fixed);
            fixed = addMissingAt(fixed);
            fixed = fixDomainTypos(fixed);
            fixed = replaceRuWithUa(fixed);
            fixed = fixDoubleDot(fixed);

            if (isValidEmail(fixed)) {
                correctedEmails.add(fixed);
            } else {
                correctedEmails.add(fixed + "       <-- INVALID");
            }
        }

        System.out.println("\nИсправленные emails:");
        for (String corrected : correctedEmails) {
            System.out.println(corrected);
        }
    }

    static String toLowerCase(String email) {
        return email.toLowerCase();
    }
    static String removeForbiddenChars(String email) {
        return email.replaceAll("[^a-zA-Z0-9.@]", "");
    }
    static String fixDoubleAt(String email) {
        return email.replaceAll("@{2,}", "@");
    }
    static String fixDoubleDot(String email) {
        return email.replaceAll("\\.{2,}", ".");
    }
    static String replaceRuWithUa(String email) {
        if (email.endsWith(".ru")) {
            return email.substring(0, email.length() - 3) + ".ua";
        }
        return email;
    }
    static String addMissingAt(String email) {
        if (!email.contains("@")) {
            String[] domains = {"example.com", "gmail.com", "outlook.com", "yandex.ru", "mail.ru"};
            for (String domain : domains) {
                int pos = email.indexOf(domain);
                if (pos > 0) {
                    return email.substring(0, pos) + "@" + email.substring(pos);
                }
            }
        }
        return email;
    }
    static String fixDomainTypos(String email) {
        if (!email.contains("@")) return email;
        String[] parts = email.split("@", 2);
        String localPart = parts[0];
        String domainPart = parts[1];

        if (domainPart.contains("e") && domainPart.contains("x") && !domainPart.equals("example.com")) return localPart + "@example.com";
        if (domainPart.contains("g") && domainPart.contains("m") && !domainPart.equals("gmail.com")) return localPart + "@gmail.com";
        if (domainPart.contains("o") && domainPart.contains("l") && !domainPart.equals("outlook.com")) return localPart + "@outlook.com";
        if (domainPart.contains("y") && domainPart.contains("x") && !domainPart.equals("yandex.ru")) return localPart + "@yandex.ru";
        if (domainPart.contains("m") && domainPart.contains("a") && !domainPart.equals("mail.ru")) return localPart + "@mail.ru";

        return email;
    }

    static String RandomArrayElement() {
        String[] domains = {"example.com", "gmail.com", "outlook.com", "yandex.ru", "mail.ru"};
        Random random = new Random();
        return domains[random.nextInt(domains.length)];
    }
    static StringBuilder RandomCharFromSet() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        int length = random.nextInt(15) + 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = symbols.charAt(random.nextInt(symbols.length()));
            result.append(randomChar);
        }
        return result;
    }
    static String DoubleAt() {
        Random random = new Random();
        return "@".repeat(random.nextInt(3) + 1);
    }

    static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}