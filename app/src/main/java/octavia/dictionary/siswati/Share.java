package octavia.dictionary.siswati;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class Share extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //variables
        Element adsElemement = new Element();
        adsElemement.setTitle("Lulwimi le Siswati letfu");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Email us on how to improve our dictionary")
                .addItem(new Element().setTitle("version 1.0"))
                .addTwitter("https://twitter.com/home?lang=en")
                .addEmail("giggslive52@gmail.com")
                .addWebsite("Www.siswati")
                .addItem(getCopyRightsElement())
                .create();
        setContentView(aboutPage);


        //i don't require set support bar cause the new version has it built in.

        //navigationView.bringToFront();
    }

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.about_twitter), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setAutoIconColor(true);
        copyRightsElement.setIcon(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIcon(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Share.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

}
