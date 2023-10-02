import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadMap {

    private static ArrayList<String> map = new ArrayList<>();


    public static void loadMap(String file) throws FileNotFoundException 
    {

        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            map.add(line);
        }

        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }

    }

    public static ArrayList<String> getMap() {
        return map;
    }
}
