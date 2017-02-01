package pt.ipbeja.adoptanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class GPSCoordinates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpscoordinates);

        Intent intentGPS = getIntent();
        String gps = intentGPS.getStringExtra("gps");
        WebView gpsWeb = (WebView) findViewById(R.id.webViewGPS);
        gpsWeb.loadUrl(gps);
    }
}
