package pt.ipbeja.adoptanimal;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        ListAnimal.OnListSelectedListener {

    public int pos;

    public void onContentSelected(int position) {
        if (findViewById(R.id.fragment_container) != null){

            /*Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait." + NewsData.Headlines[pos],
                    Toast.LENGTH_SHORT).show();*/

        // Create fragment and give it an argument specifying the article it should show
        ContentAnimal newContent = new ContentAnimal();
        Bundle args = new Bundle();
        args.putInt("position", position);
        newContent.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newContent);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();

        }
        else{
            /*Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape." + NewsData.Headlines[pos],
                    Toast.LENGTH_SHORT).show();*/
        ContentAnimal ContentFrag = (ContentAnimal)
        getSupportFragmentManager().findFragmentById(R.id.fragment_content_animal);
        ContentFrag.updateArticleView(position);
        }
        pos = position;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toast.makeText(this, NewsData.GetArticleWithNumber(-1),
                Toast.LENGTH_SHORT).show();*/

        if( savedInstanceState == null) {
        Initialize();
        //NewsData.ListArticles();

            /*Log.d("MainActivity:",
                    Integer.toString(NewsData.GetNumberOfArticles()));*/
        }

        /*Toast.makeText(this, NewsData.Headlines[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, NewsData.Articles[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, NewsData.Headlines[1], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, NewsData.Articles[1], Toast.LENGTH_SHORT).show();*/

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

        // However, if we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
        return;
        }

        // Create a new Fragment to be placed in the activity layout
        ListAnimal listFragment = new ListAnimal();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
            listFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, listFragment).commit();
        }
        }

    public void Initialize(){

        DBHelper db = new DBHelper(this);
        //db.insertAnimals("Animal1", "Cão1", "R.drawable.animal1", "https://goo.gl/maps/MeUV5yRDjQ22", "tel: 968526910");
        //db.insertAnimals("Animal2", "Gato2", "R.drawable.animal2", "https://goo.gl/maps/yKPHE2PxZj72", "tel: 969762806");

        Animals.ListAnimal = db.getAllNames();
        Animals.ListContent = db.getAllContent();
        Animals.ListPhoto = db.getAllPhoto();
        Animals.ListGPS = db.getAllGPS();
        Animals.ListPhone = db.getAllPhone();
        //Animals.InsertAnimal("Animal1",
                //"Cão1");

        //Animals.InsertAnimal("Animal2",
                //"Gato1");

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void btnCall_onClick(View view) {

        Uri number = Uri.parse(Animals.ListPhone.get(pos));
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
    }

    public void btnGPS_onClick(View view) {


    }
}
