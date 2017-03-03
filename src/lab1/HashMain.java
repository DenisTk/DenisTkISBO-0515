package lab1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashMain {
    public static void main(String [] arg) throws FileNotFoundException {

        HashMap<String, Integer> map = new HashMap<>();
        try (Scanner s=new Scanner(new File("1.txt"),"Cp1251")) {
            while (s.hasNext()){
                String word=s.next();
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                }
                else {
                    int count = map.get(word);
                    map.put(word,++count);
                }

            }
        }

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        list.sort((e1,e2)->-e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry);
        }


    }
}
