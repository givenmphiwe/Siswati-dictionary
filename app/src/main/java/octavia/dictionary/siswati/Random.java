package octavia.dictionary.siswati;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Random extends AppCompatActivity {

    Button button;
    TextView textView;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(jokes.length);
            }
        });
    }

    private int nextInt(int length) {
        return length;
    }

    private String jokes [] = {"Buhlungu", "Emaphuzu", "Etibukweni", "Imfula", "Imphundvu", "Incola", "Itelevishini/mabonakudze", "Kuchifita", "Khondakta", "Ludzaka", "Lilanga", "Lihlatsi", "Ligovu", "Litulu", "umiti", "Ucubashi", "Umagodzi", "Umshiza","Sidziya", "Silutfo"};
    
}