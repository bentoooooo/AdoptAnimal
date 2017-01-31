package pt.ipbeja.adoptanimal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                //Toast.makeText(this, animals.animal[0], Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, animals.animalContent[0], Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, animals.animal[1], Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, animals.animalContent[1], Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            ListAnimal firstFragment = new ListAnimal();

            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }
}
