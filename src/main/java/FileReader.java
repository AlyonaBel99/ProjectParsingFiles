import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileReader extends Thread{
    private String fileName;
    private List<String[]> fileData = new ArrayList<>();
    Parsing parsing;

public FileReader(String fileName, Parsing parsing){
    this.fileName = fileName; // передача имени файла
    this.parsing = parsing;
    }

public void run(){
    File file = new File(fileName);
    try (Scanner scanner = new Scanner(file)) { // открытие файла
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] value = line.split(";");
            fileData.add(value);
        }
        scanner.close();
        System.out.println(Thread.currentThread().getName() + "файл "+fileName + " прочитан");
            parsing.SetFileData(this.fileData);
            parsing.sorting();
    } catch (FileNotFoundException e) {
        System.out.println("Файл "+fileName+" не найден!");
        e.printStackTrace();
    }
}
}
