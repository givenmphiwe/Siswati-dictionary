package octavia.dictionary.siswati;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class Animals extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewpage);

        List<AnimalLocation> animalLocations = new ArrayList<>();

        //to add pictures here

        AnimalLocation animalLocationEiffelTower = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationEiffelTower.imageurl = "https://images.all-free-download.com/images/graphicthumb/giraffe_191772.jpg";
        animalLocationEiffelTower.title = "Indlulamitsi";
        animalLocationEiffelTower.location = "Giraffe";

        animalLocations.add(animalLocationEiffelTower);

        AnimalLocation animalLocationLion = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationLion.imageurl = "https://www.nicepng.com/png/detail/1-16267_download-lion-roar-png-image-roaring-lion-images.png";
        animalLocationLion.title = "Libhubhesi";
        animalLocationLion.location = "Lion";

        animalLocations.add(animalLocationLion);

        AnimalLocation animalLocationElephant = new AnimalLocation();
        animalLocationElephant.imageurl = "http://res.freestockphotos.biz/pictures/10/10012-an-elephant-with-a-calf-pv.jpg";
        animalLocationElephant.title = "Indlovu";
        animalLocationElephant.location = "Elephant";

        animalLocations.add(animalLocationElephant);

        AnimalLocation animalLocationMonkey = new AnimalLocation();
        animalLocationMonkey.imageurl = "https://pixnio.com/free-images/2018/12/03/2018-12-03-11-51-48-1200x800.jpg";
        animalLocationMonkey.title = "Ingob'yane";
        animalLocationMonkey.location = "Monkey";

        animalLocations.add(animalLocationMonkey);

        AnimalLocation animalLocationHyena = new AnimalLocation();
        animalLocationHyena.imageurl = "https://wallpaperaccess.com/full/1927351.jpg";
        animalLocationHyena.title = "Impisi";
        animalLocationHyena.location = "Hyena";

        animalLocations.add(animalLocationHyena);

        AnimalLocation animalLocationImpala = new AnimalLocation();
        animalLocationImpala.imageurl = "https://images.pexels.com/photos/3857080/pexels-photo-3857080.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        animalLocationImpala.title = "Impala";
        animalLocationImpala.location = "Impala";

        animalLocations.add(animalLocationImpala);

        AnimalLocation animalLocationOstrich = new AnimalLocation();
        animalLocationOstrich.imageurl = "https://images.pexels.com/photos/5502089/pexels-photo-5502089.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        animalLocationOstrich.title = "Inshi";
        animalLocationOstrich.location = "Ostrich";

        animalLocations.add(animalLocationOstrich);

        AnimalLocation animalLocationRhino = new AnimalLocation();
        animalLocationRhino.imageurl = "https://images.all-free-download.com/images/graphicthumb/africa_african_animal_274409.jpg";
        animalLocationRhino.title = "Bhejane";
        animalLocationRhino.location = "Rhino";

        animalLocations.add(animalLocationRhino);

        AnimalLocation animalLocationLeopard = new AnimalLocation();
        animalLocationLeopard.imageurl = "https://images.all-free-download.com/images/graphicthumb/portrait_of_a_leopard_199638.jpg";
        animalLocationLeopard.title = "Ingwe";
        animalLocationLeopard.location = "Leopard";

        animalLocations.add(animalLocationLeopard);

        AnimalLocation animalLocationwild = new AnimalLocation();
        animalLocationwild.imageurl = "https://images.all-free-download.com/images/graphicthumb/standing_wild_dog_514178.jpg";
        animalLocationwild.title = "Nkalwane";
        animalLocationwild.location = "wild dog";

        animalLocations.add(animalLocationwild);

        AnimalLocation animalLocationzebra = new AnimalLocation();
        animalLocationzebra.imageurl = "https://images.freeimages.com/images/large-previews/983/zebra-1-1406429.jpg";
        animalLocationzebra.title = "lidvuba";
        animalLocationzebra.location = "Zebra";

        animalLocations.add(animalLocationzebra);

        AnimalLocation animalLocationcat = new AnimalLocation();
        animalLocationcat.imageurl = "https://images.all-free-download.com/images/graphiclarge/two_young_cats_189918.jpg";
        animalLocationcat.title = "mangobe";
        animalLocationcat.location = "cat";

        animalLocations.add(animalLocationcat);





        //end here to add pictures ..down it's for the image to slide and show 3 pictures in one screen

        locationsViewPager.setAdapter(new AnimalLocationAdapter(animalLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);

            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);
    }
}