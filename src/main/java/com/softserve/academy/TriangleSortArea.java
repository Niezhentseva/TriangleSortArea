/*3.	Сортировка треугольников
Разработать консольную программу, выполняющую вывод треугольников в порядке убывания их площади.
После добавления каждого нового треугольника программа спрашивает,
хочет ли пользователь добавить ещё один.
Если пользователь ответит “y” или “yes” (без учёта регистра),
программа попросит ввести данные для ещё одного треугольника,
в противном случае – выводит результат в консоль.
•	Расчёт площади треугольника должны производится по формуле Герона.
•	Каждый треугольник определяется именем и длинами его сторон.
Формат ввода (разделитель - запятая):
<имя>, <длина стороны>, <длина стороны>, <длина стороны>
• Приложение должно обрабатывать ввод чисел с плавающей точкой.
• Ввод должен быть нечувствителен к регистру, пробелам, табам.
• Вывод данных должен быть следующем примере:
============= Triangles list: ===============
1. [Triangle first]: 17.23 сm
2. [Triangle 22]: 13 cm
3. [Triangle 1]: 1.5 cm
 */
package com.softserve.academy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.softserve.academy.InformMessage.*;

public class TriangleSortArea {
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>(); // create a list
        do {
            ConsoleIO.printToConsole(START_PROGRAM);
            String input = ConsoleIO.enterValue();
            if (!(WorkWithAttributes.isForCommas(input))) { //checking the number of commas
                ConsoleIO.printToConsole(INFORM_NO_THREE_SIDES);
            } else {
                String[] arrInput = WorkWithAttributes.parseInput(input); // split string
                Triangle triangle = null;
                try {
                    triangle = Triangle.createTriangle(
                                    arrInput[0],
                                    Double.parseDouble(arrInput[1]),
                                    Double.parseDouble(arrInput[2]),
                                    Double.parseDouble(arrInput[3]));
                } catch (NumberFormatException e) {
                    ConsoleIO.printToConsole(INFORM_NO_NUMBER);
                } catch (IllegalArgumentException e) {
                    ConsoleIO.printToConsole(INFORM_NO_TRIANGLE);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ConsoleIO.printToConsole(INFORM_NO_THREE_SIDES);
                }
                triangles.add(triangle);
            }
            ConsoleIO.printToConsole(CONTINUE_PROGRAM);
        } while (ConsoleIO.isContinue());
        triangles.sort(Comparator.comparing(Triangle::getArea).thenComparing(Triangle::getName).reversed());
        ConsoleIO.printListTriangles(triangles);
        ConsoleIO.closeScanner();
    }
}