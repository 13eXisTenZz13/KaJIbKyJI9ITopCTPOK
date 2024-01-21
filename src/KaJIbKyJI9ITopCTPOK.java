import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class KaJIbKyJI9ITopCTPOK {
    static char operation;
    static String userInput;
    static String chast1;
    static String chast2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        userInput = scanner.nextLine();

        String FinalResult = calc(userInput);
        System.out.println("<<< Результат >>>");
        System.out.println(chast1 + " " + operation + " " + chast2 + " = " + FinalResult);
    }
    public static String calc(String input) {
        String z = null;
        char[] under_char = new char[50];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
                calcPlus(userInput);
                System.out.println(calcPlus(userInput));
                return calcPlus(userInput);
            }
            if (under_char[i] == '-') {
                operation = '-';
                calcMinus(userInput);
                System.out.println(calcMinus(userInput));
                return calcMinus(userInput);
            }
            if (under_char[i] == '*') {
                operation = '*';
                calcUmnojenie(userInput);
                System.out.println(calcUmnojenie(userInput));
                return calcUmnojenie(userInput);
            }
            if (under_char[i] == '/') {
                operation = '/';
                calcDelenie(userInput);
                System.out.println(calcDelenie(userInput));
                return calcDelenie(userInput);
            }
        }
        if (operation == 0) {
            throw new IllegalArgumentException("ВЫРАЖЕНИЕ ВВЕДЕНО НЕ ПРАВИЛЬНО");
        }
        return z;
    }
    public static String calcPlus(String inputP){
        String[] chasti = inputP.split(" \\+ ");
        chast1 = chasti[0];
        chast2 = chasti[1];
        boolean chast1Reg = chast1.matches("^\".*\"$");
        boolean chast2Reg = chast2.matches("^\".*\"$");
        String sumPlus = null;
        if(chast1Reg & chast2Reg == true){
            String chas1 = chast1.replace("\"", "");
            String chas2 = chast2.replace("\"", "");
            if(chas1.length() > 10 | chas2.length() > 10 ){
                throw new IllegalArgumentException("СТРОКА ДОЛЖНА БЫТЬ НЕ БОЛЕЕ 10 СИМВОЛОВ");
            }
            sumPlus = "\""+chas1 + chas2+"\"";
        } else {
            throw new IllegalArgumentException("НЕ ВЕРНЫЙ ФОРМАТ ВВОДИМЫХ ДАННЫХ");
        }
        return sumPlus;
    }
    public static String calcMinus(String inputM){
        String[] chasti = inputM.split(" - ");
        chast1 = chasti[0];
        chast2 = chasti[1];
        boolean chast1Reg = chast1.matches("^\".*\"$");
        boolean chast2Reg = chast2.matches("^\".*\"$");
        String minMin = null;
        if(chast1Reg & chast2Reg == true){
            String chas2 = chast2.replace("\"", "");
            if(chast1.length() > 12 | chas2.length() > 10 ){
                throw new IllegalArgumentException("СТРОКА ДОЛЖНА БЫТЬ НЕ БОЛЕЕ 10 СИМВОЛОВ");
            }
            minMin = chast1.replace(chas2, "");
        } else {
            throw new IllegalArgumentException("НЕ ВЕРНЫЙ ФОРМАТ ВВОДИМЫХ ДАННЫХ");
        }
        return minMin;
    }
    public static String calcUmnojenie(String inputU) {
        String inputRep = inputU.replace(" ", "");
        String[] chasti = inputRep.split("\\*");
        chast1 = chasti[0];
        chast2 = chasti[1];
        boolean chast1Reg = chast1.matches("^\".*\"$");
        boolean chast2Reg;
        int chas2;
        try {
            chas2 = parseInt(chast2);
        } catch (NumberFormatException exz){
            throw new IllegalArgumentException ("Первым аргументом выражения должна быть строка, Вторым аргументом только целые числа");
        }
        if ((chas2 > 0) & (chas2 <= 10)){
            chast2Reg = true;
        }else { chast2Reg = false;
            throw new IllegalArgumentException("ДОЛЖНЫ ИСПОЛЬЗОВАТЬСЯ ЧИСЛА ОТ 1 до 10");
        }
        String umUmn = "";
        if (chast1Reg & chast2Reg == true) {
            String chas1 = chast1.replace("\"", "");
            if(chas1.length() <= 10) {
                for (int i = 0; i < chas2; i++) {
                    umUmn = umUmn + chas1;
                }
            } else {
                throw new IllegalArgumentException("ДЛИННА ВВОДИМОЙ СТРОКИ ДОЛЖНА БЫТЬ НЕ БОЛЕЕ 10 СИМВОЛОВ");
            }
            if(umUmn.length()<=40) {
                umUmn = "\"" + umUmn + "\"";
            }else {umUmn ="\"" + umUmn.substring(0,40) + "..." + "\"";}
        }
        return umUmn;
    }
    public static String calcDelenie(String inputD) {
        String inputRep = inputD.replace(" ", "");
        String[] chasti = inputRep.split("/");
        chast1 = chasti[0];
        chast2 = chasti[1];
        boolean chast1Reg = chast1.matches("^\".*\"$");
        boolean chast2Reg;
        int chas2;
        try {
            chas2 = parseInt(chast2);
        } catch (NumberFormatException exz){
            throw new IllegalArgumentException ("Первым аргументом выражения должна быть строка, Вторым аргументом только целые числа");
        }
        if ((chas2 > 0) & (chas2 <= 10)) {
            chast2Reg = true;
        } else {
            chast2Reg = false;
            throw new IllegalArgumentException("ДОЛЖНЫ ИСПОЛЬЗОВАТЬСЯ ЧИСЛА ОТ 1 до 10");
        }
        String delDel = "";
        int delInt = 0;
        if (chast1Reg & chast2Reg == true) {
            String chas1 = chast1.replace("\"", "");
            delInt = chas1.length() / chas2;
            if (chas1.length() <= 10) {
                delDel = "\"" + chas1.substring(0, delInt) + "\"";
            }
        } else {
            throw new IllegalArgumentException("ДЛИННА ВВОДИМОЙ СТРОКИ ДОЛЖНА БЫТЬ НЕ БОЛЕЕ 10 СИМВОЛОВ");
        }
        return delDel;
    }
}