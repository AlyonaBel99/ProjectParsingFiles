import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Parsing {
    private List<String[]> fileData = new ArrayList<>();
    private String[][] arryData;
    private static Map<String,Set> result = new LinkedHashMap<>();

    public void SetFileData(List<String[]> fileData) {
        this.fileData = fileData;
        this.arryData = new String[fileData.get(0).length][fileData.size()];
        this.arryData = transpositionData(fileData);
    }

    public List<String[]> getFileData(){
        return fileData;
    }

    public String[][] getArryData() {
        return arryData;
    }

    private String[][] transpositionData(List<String[]> fileData){

        for (int i=0;i<fileData.size();i++){
            for (int j=0;j<fileData.get(0).length;j++)
                arryData[j][i] = fileData.get(i)[j];
        }
        return arryData;
    }

    public void sorting(){
            for (int h = 0; h < arryData.length; h++) {
                Set<String> value = new TreeSet<>();
                for (int w = 1; w < arryData[h].length; w++) {
                    value.add(arryData[h][w]);
                }
                synchronized (this) {
                    if (mapKeyByValue(result, arryData[h][0]) == true) {
                        result.get(arryData[h][0]).addAll(value);
                    } else {
                        result.put(arryData[h][0], value);
                    }
                }
            }
    }
    private boolean mapKeyByValue (Map<String,Set> map, String value){
        for(Map.Entry<String,Set> item : map.entrySet()){
            if(item.getKey().equals(value) == true){
                return true;
        }
        }
        return false;
    }
    public Map<String,Set> GetData(){
        return result;
    }
}
