package pt.ipbeja.adoptanimal;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bento on 30/01/2017.
 */

public class Animals {

    static List<String> ListAnimal = new ArrayList<String>();
    static List<String> ListContent = new ArrayList<String>();

    static void InsertAnimal(String animal, String content){
        ListAnimal.add(animal);
        ListContent.add(content);
    }

    static void ListArticles(){
        for( int i = 0; i < ListAnimal.size(); i++){
            Log.d("NewsData:", ListAnimal.get(i));
            Log.d("NewsData:", ListContent.get(i));
        }
    }

    static String GetListAnimalWithNumber( int number){
        if( (number >= 0 ) && ( number < ListAnimal.size()) )
            return ListAnimal.get(number);
        else
            return "";
    }

    static String GetListContentWithNumber( int number){
        if( (number >= 0 ) && ( number < ListContent.size() ) )
            return ListContent.get(number);
        else
            return "";
    }

    static int GetNumberOfListAnimal(){
        return ListAnimal.size();
    }
}
