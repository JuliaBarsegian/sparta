package SpartaTests.tasks;


import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double num1 = getNumber();
        double num2 = getNumber();
        char operation = getOperation();
        double result = calc(num1, num2, operation);
        System.out.println("Результат выбранной операции:" + result);
    }

    private static double getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        } else {
            System.out.println("Ошибка при вводе. Повторите ввод");
            return getNumber();
        }
    }

    private static char getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите номер операции:\n1 - Сложение\n2 - Вычитание\n3 - Умножение\n4 - Деление");
        int operationNumber = 0;
        if (sc.hasNextInt()) {
            operationNumber = sc.nextInt();
        } else {
            System.out.println("Вы ввели не число! Повторите ввод!");
            return getOperation();
        }
        switch (operationNumber) {
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
            default:
                System.out.println("Такой операции не существует! Повторите ввод!");
                return getOperation();
        }
    }

    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static double sub(double num1, double num2) {
        return num1 - num2;
    }

    private static double mul(double num1, double num2) {
        return num1 * num2;
    }

    private static double div(double num1, double num2) {
        if (num2 != 0.0) {
            return num1 / num2;
        } else {
            System.out.println("На 0 делить нельзя!");
            return Double.NaN;
        }
    }

    private static double calc(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return add(num1, num2);
            case '-':
                return sub(num1, num2);
            case '*':
                return mul(num1, num2);
            case '/':
                return div(num1, num2);
            default:
                return Double.NaN;
        }
    }
}