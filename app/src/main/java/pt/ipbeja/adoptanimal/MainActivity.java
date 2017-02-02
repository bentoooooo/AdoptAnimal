package pt.ipbeja.adoptanimal;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        ListAnimal.OnListSelectedListener {

    public int pos;
    static String helpNumber = "tel: 968526910";

    public void onContentSelected(int position) {
        if (findViewById(R.id.fragment_container) != null) {

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

        } else {
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

        if (savedInstanceState == null) {
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

    public void Initialize() {

        DBHelper db = new DBHelper(this);
        /*
        db.insertAnimals("Putchi - Gata", "Gata - Europeu Comum\n" +
                "Idade: Jovem\n" +
                "Sexo: Fêmea\n" +
                "Porte: Médio\n" +
                "Pêlo: Laranja e Preto\n" +
                "Não Esterilizada, Não Vacinada, Não Desparasitada\n" +
                "\n" +
                "Dou gatinha nascida em Março do ano passado. É muito meiga e arisca, já vai ao caixote mas só como paté. Está habituada a estar com outros gatos. Qualquer interesse por favor ligar .\n" +
                "\n" +
                "Contacto para Adopção:\n" +
                "Nome: Ana\n" +
                "Morada: Rua do Bem Formoso\n" +
                "Localidade: Lisboa (Lisboa)\n" +
                "Tel: 966888262\n" +
                "Email: christinne1998@gmail.com", R.drawable.putchi, "https://goo.gl/maps/w8K76nNqDW52", "tel: 966888262");

        db.insertAnimals("Fifi - Gata", "Gata - Europeu Comum\n" +
                "Idade: Adulta\n" +
                "Sexo: Fêmea\n" +
                "Porte: Pequeno\n" +
                "Pêlo: Laranja\n" +
                "Não Esterilizada, Algumas Vacinas, Não Desparasitada\n" +
                "\n" +
                "Por mudar de casa e não poder ter animais estou a dar para adoção a minha querida linda e mimalha fifi quero que alguém fique com ela e lhe de muito amor\n" +
                "\n" +
                "Contacto para Adopção:\n" +
                "Nome: Filipa\n" +
                "Localidade: Porto (Porto)\n" +
                "Tel: 915344325\n" +
                "Email: Avrilfan2006@hotmail.com", R.drawable.fifi, "https://goo.gl/maps/LMGcNTbqTJo", "tel: 915344325");

        db.insertAnimals("Bruce - Cão", "Cão - Rafeiro Comum\n" +
                "Idade: Jovem\n" +
                "Sexo: Macho\n" +
                "Porte: Médio\n" +
                "Pêlo: Preto e Branco\n" +
                "Esterilizado, Vacinas em Dia, Desparasitado\n" +
                "\n" +
                "Olá eu sou o Bruce.\n" +
                "Fui resgatado da Rua, sou muito meigo e não estrago nem faço nada de disparates em casa. Sou um jovem de uma ano a ano e meio. \n" +
                "Quem me salvou já tem 3 cães e um gato e queria muito que eu tivesse uma família como mereço. Fui adoptado, mas quem me recolheu não pode continuar a ter-me lá em casa.\n" +
                "Estou à guarda na APCA em São Pedro de Sintra, mas queria tanto ter uma família. \n" +
                "Alguém com um espacinho em casa e no coração para mim?\n" +
                "\n" +
                "Contacto para Adopção:\n" +
                "Nome: APCA\n" +
                "Morada: Rua do Canil, 8\n" +
                "Localidade: Sintra (Lisboa)\n" +
                "Tel: 929037591 ou 964530419\n" +
                "Email: info@apca.org.pt\n" +
                "Site: www.apca.org.pt/", R.drawable.bruce, "https://goo.gl/maps/cDKRBfVvmWA2", "tel: 929037591");

        db.insertAnimals("Rosa - Cadela", "Cadela - Rafeiro Comum\n" +
                "Idade: Jovem\n" +
                "Sexo: Fêmea\n" +
                "Porte: Pequeno\n" +
                "Pêlo: Castanho e Preto\n" +
                "Esterilizada, Não Vacinada, Desparasitada\n" +
                "\n" +
                "A Rosa deu entrada no Canil municipal de Odemira em Janeiro de 2017.\n" +
                "É uma menina muito meiguinha e simpática. Gosta muito de pessoas e de brincar e dá-se bem com todos os cães.\n" +
                "Seria uma óptima companhia para crianças e quem a adoptar vai ganhar uma verdadeira amiga.\n" +
                "à data de entrada no canil, a Rosa tinha 2 anos.\n" +
                "Disponível para adopção a partir de 20.02.17 (após esterilização e recuperação).\n" +
                "No ato da adopção, o animal leva o microchip e vacina anti-rábica (gratuitos)..\n" +
                "\n" +
                "Contacto para Adopção:\n" +
                "Nome: Isabel Trigo\n" +
                "Localidade: Odemira (Beja)\n" +
                "Tel: 938335738\n" +
                "Email: cirnetrigo@gmail.com", R.drawable.rosa, "https://goo.gl/maps/8myrpE7iMn62", "tel: 938335738");

        */
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
    protected void onStart() {
        super.onStart();
    }

    public void btnCall_onClick(View view) {
        Uri number = Uri.parse(Animals.ListPhone.get(pos));
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void btnGPS_onClick(View view) {
        Intent mapGoogle = new Intent(MainActivity.this, GPSCoordinates.class);
        mapGoogle.putExtra("gps", Animals.ListGPS.get(pos));
        startActivity(mapGoogle);
    }

    public void btnHelp_onClick(View view) {
        Uri number = Uri.parse(helpNumber);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public static String testPhoneOperator() {
        return helpNumber;
    }
}
