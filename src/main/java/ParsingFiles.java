import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParsingFiles {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите названия файлов через пробел, " +
        "которые находятся в корне проекта (в папке с данным проектом): ");
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();   // ввод данных
        String[] fileName = input.split(" "); // разбиение строки
        Parsing parsing = new Parsing();
        List<Thread> threads = new ArrayList<>();
        for (String name : fileName) {
            Thread thread = new FileReader(name,parsing);
            threads.add(thread);
            thread.start();
        }
        for (Thread th:threads) th.join();
        System.out.println("потоки завершили работу");
        WriteFile writeFile = new WriteFile(parsing);
        writeFile.writeData();
        System.out.println("Результат работы программы записан в файл: output.csv.");
    }
}
