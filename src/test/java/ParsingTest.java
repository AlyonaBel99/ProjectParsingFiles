import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParsingTest {
    Parsing parsing;
    public List<String[]> list = Arrays.asList(new String[]{"id", "name","version"},new String[]{"1", "Мари","11"},new String[]{"2", "Антон","11"});
    public String [][] strings = {{"id","1", "2"},{"name", "Мари","Антон"},{"version", "11","11"}};
    Map<String, Set> map = new LinkedHashMap<>();
    @BeforeEach
    void createParsing(){
        parsing = new Parsing();
        parsing.SetFileData(list);
        map.put("id",Set.of("1","2"));
        map.put("name",Set.of("Мари","Антон"));
        map.put("version",Set.of("11"));
    }

    @Test
    void setFileData() {
        assertArrayEquals(list.toArray(),parsing.getFileData().toArray());
    }

    @Test
    void getArryData() {
    assertArrayEquals(strings,parsing.getArryData());
    }

    @Test
    void sorting() {
        parsing.sorting();
        for(Map.Entry<String,Set> item: map.entrySet()) {
            assertEquals(, item.getKey());
        }
    }


    @Test
    void getData() {
    }
}