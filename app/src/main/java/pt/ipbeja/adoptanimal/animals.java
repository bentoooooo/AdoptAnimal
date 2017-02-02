package pt.ipbeja.adoptanimal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bento on 30/01/2017.
 */

public class Animals {

    static List<String> ListAnimal = new ArrayList<String>();
    static List<String> ListContent = new ArrayList<String>();
    static List<Integer> ListPhoto = new ArrayList<Integer>();
    static List<String> ListGPS = new ArrayList<String>();
    static List<String> ListPhone = new ArrayList<String>();

    static int GetNumberOfListAnimal(){
        return ListAnimal.size();
    }
}
