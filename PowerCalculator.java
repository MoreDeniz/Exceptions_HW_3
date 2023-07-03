// Задача1. Напишите программу-калькулятор, которая запрашивает у пользователя два числа
// и выполняет операцию возведения первого числа в степень второго числа.
// Если введены некорректные числа или происходит деление на ноль, необходимо обработать
// соответствующие исключения и вывести информативное сообщение об ошибке.
// Важно! С использованием принципа одного уровня абстракции!
//**В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(),
// выполняющий операцию возведения числа в степень. Если введено некорректное основание (ноль)
// и отрицательная степень, выбрасывается исключение InvalidInputException.

// В методе main() мы запрашиваем у пользователя основание и показатель степени,
// вызываем метод calculatePower() и выводим результат.
// Если введены некорректные числа или происходит ошибка ввода,
// соответствующие исключения перехватываются и выводится информативное сообщение об ошибке.

// Обратите внимание, что в этой задаче мы использовали собственное исключение InvalidInputException,
// чтобы явно указать на некорректный ввод. Это помогает разделить обработку ошибок на соответствующие уровни абстракции.**

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerCalculator {

    public static int calculatePower(int value, int powValue) throws InvalidInputException {
        if (value == 0) {
            throw new InvalidInputException("Введено некорректное основание!");
        }
        if (powValue < 0) {
            throw new InvalidInputException("Степень не может быть отрицательной!");
        }
        return (int) Math.pow(value, powValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value, powValue;

        System.out.println("Возведение числа в степень");
        System.out.println("==========================");
        while (true) {
            try {
                System.out.print("Введите число: ");
                value = scanner.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: некорректный ввод");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Введите степень: ");
                powValue = scanner.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: некорректный ввод");
                scanner.nextLine();
            }
        }

        try {
            double result = calculatePower(value, powValue);
            System.out.println("Результат: " + result);
        } catch (InvalidInputException e) {
            handleInvalidInputException(e);
        }
    }

    private static void handleInvalidInputException(InvalidInputException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }

    static class InvalidInputException extends Exception{
        public InvalidInputException(String message) {
            super(message);
        }
    }
}



