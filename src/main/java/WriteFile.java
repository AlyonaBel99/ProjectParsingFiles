import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class WriteFile {
    Parsing parsing;
    private Map<String, Set> result;
    public WriteFile(Parsing parsing){
        this.parsing = parsing;
        this.result = parsing.GetData();
    }

    public void writeData(){
         try {
            PrintWriter printWriter = new PrintWriter(new File("output.csv"));
             for(Map.Entry<String,Set> item : result.entrySet()) {
                 printWriter.println(item.getKey() + ":");
                 System.out.println(item.getKey() + ":");
                 for (Object o:item.getValue()) {
                     System.out.print(o+";");
                     printWriter.print(o+";");
                 }
                 printWriter.println();
                 System.out.println();
             }
             printWriter.close();
        } catch (FileNotFoundException e) {
             System.out.println("Файл output.csv не удалось создать!");
            e.printStackTrace();
        }
    }
}
