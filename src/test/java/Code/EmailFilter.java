package Code;

import java.util.*;

public class EmailFilter {

    public static void main(String[] args) {
        ArrayList<String> emails = new ArrayList<>(List.of(
                "Ivan.Petrov@@Gmail.Com",
                "Katya_1989MAIL.ru",
                "oleg#example.com",
                "sergey@gnail.com",
                "natalia@outlok.com",
                "dmitriy@mail..ru",
                "anna.smirnova@gmail.com",
                "mikhail1988@yandex.ru",
                "elena_kovalenko@outlook.com",
                "roman-ivanov@mail.ru",
                "roman-ivanov1@myax.ru"
        ));

        List<String> correctedEmails = new ArrayList<>();

        for (String email : emails) {
            String fixed = toLowerCase(email);
            fixed = fixDoubleAt(fixed);
            fixed = removeForbiddenChars(fixed);
            fixed = addMissingAt(fixed);
            fixed = fixDomainTypos(fixed);
            fixed = replaceRuWithUa(fixed);
            fixed = fixDoubleDot(fixed);

            correctedEmails.add(fixed);
        }

        System.out.println("Исправленные emails:");
        for (int i = 0; i < correctedEmails.size(); i++) {
            System.out.println(correctedEmails.get(i));
        }
    }

    static String toLowerCase(String email) {
        return email.toLowerCase();
    }
    static String removeForbiddenChars(String email) {
        return email.replaceAll("[^a-zA-Z0-9.@]", "");
    }

    static String fixDoubleAt(String email) {
        if (email.contains("@@")){
            email = email.replace("@@","@");
        }
        return email;
    }
    static String fixDoubleDot(String email) {
        if (email.contains("..")){
            email = email.replace("..",".");
        }
        return email;
    }

    static String replaceRuWithUa(String email) {
        if (email.endsWith(".ru")) {
            email = email.substring(0, email.length() - 3) + ".ua";
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

        if (domainPart.contains("e") && domainPart.contains("x")  && !domainPart.equals("example.com")) { return localPart + "@example.com"; }
        if (domainPart.contains("g") && domainPart.contains("m")  && !domainPart.equals("gmail.com")) { return localPart + "@gmail.com"; }
        if (domainPart.contains("o") && domainPart.contains("l")  && !domainPart.equals("outlook.com")) { return localPart + "@outlook.com"; }
        if (domainPart.contains("y") && domainPart.contains("x")  && !domainPart.equals("yandex.ru")) { return localPart + "@yandex.ru"; }
        if (domainPart.contains("m") && domainPart.contains("a")  && !domainPart.equals("mail.ru")) { return localPart + "@mail.ru"; }

        return email;
    }
}