package pt.ipbeja.adoptanimal;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                Toast.makeText(this, animals.animal[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(this, animals.animalContent[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(this, animals.animal[1], Toast.LENGTH_SHORT).show();
                Toast.makeText(this, animals.animalContent[1], Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
                }
            ListAnimal animals = new ListAnimal();
            animals.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, animals).commit();
        }

    }
}
