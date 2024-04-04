package com.nvgrig.coding.ya;

import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String newPhone = scanner.nextLine();
        String existPhone1 = scanner.nextLine();
        String existPhone2 = scanner.nextLine();
        String existPhone3 = scanner.nextLine();
        isEqual(newPhone, existPhone1);
        isEqual(newPhone, existPhone2);
        isEqual(newPhone, existPhone3);
    }

    private static void isEqual(String phone1, String phone2) {
        String normalizedPhone1 = normalizePhone(phone1);
        String normalizedPhone2 = normalizePhone(phone2);
        String[] codeNumber1 = getCodeNumber(normalizedPhone1);
        String[] codeNumber2 = getCodeNumber(normalizedPhone2);
        System.out.println(codeNumber1[0].equals(codeNumber2[0]) && codeNumber1[1].equals(codeNumber2[1]) ? "YES" : "NO");
    }

    private static String normalizePhone(String phone) {
        return phone.replace("(", "").replace(")", "").replace("-", "");
    }

    private static String[] getCodeNumber(String phone) {
        if (phone.length() > 7) {
            return phone.length() == 11 ? new String[]{phone.substring(1, 4), phone.substring(4, 11)} : new String[]{phone.substring(2, 5), phone.substring(5, 12)};
        } else {
            return phone.length() == 7 ? new String[]{"495", phone} : new String[]{phone.substring(0, 3), phone.substring(3, 7)};
        }
    }

}
