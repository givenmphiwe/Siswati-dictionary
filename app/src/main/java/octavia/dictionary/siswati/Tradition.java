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

public class Tradition extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradition);

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
        animalLocationEiffelTower.imageurl = "https://media.istockphoto.com/photos/boiled-peanuts-with-salt-picture-id182513004?k=6&m=182513004&s=612x612&w=0&h=2KTOsagh4hc5EfwABMkVPkJMqymT_2mzOHe0Z_raVA0=";
        animalLocationEiffelTower.title = "Umbhonyo wematomangomane";
        animalLocationEiffelTower.location = "Boiled peanuts";

        animalLocations.add(animalLocationEiffelTower);

        AnimalLocation animalLocationLion = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationLion.imageurl ="http://1.bp.blogspot.com/_X82_Ab0X2yE/Slj14emZ3cI/AAAAAAAABtc/avon-x7EA-s/s400/IMG_1466.JPG";
        animalLocationLion.title = "Umbhonyo wetindlubu";
        animalLocationLion.location = "Jugo beans";

        animalLocations.add(animalLocationLion);

        AnimalLocation animalLocationtribe = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationtribe.imageurl = "https://thumbs.dreamstime.com/b/boiled-tripe-boiled-tripe-white-background-145350891.jpg";
        animalLocationtribe.title = "Ematfumbu";
        animalLocationtribe.location = "Boiled tribe";

        animalLocations.add(animalLocationtribe);

        AnimalLocation animalLocationpor = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationpor.imageurl = "https://i2.wp.com/www.outdoorcuisine.co.za/wp-content/uploads/2020/01/Maize-porridge.jpg?resize=768%2C768&ssl=1";
        animalLocationpor.title = "Sidvwidvwi";
        animalLocationpor.location = "Soft porridge";

        animalLocations.add(animalLocationpor);

        AnimalLocation animalLocationSamp = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationSamp.imageurl = "https://img-global.cpcdn.com/recipes/f2f7af45bd7958b0/680x482cq70/creamy-samp-recipe-main-photo.webp";
        animalLocationSamp.title = "Sitambu";
        animalLocationSamp.location = "Samp";

        animalLocations.add(animalLocationSamp);

        AnimalLocation animalLocationCorn = new AnimalLocation();
        //enter the url link for the animals here
        animalLocationCorn.imageurl = "https://images.all-free-download.com/images/graphiclarge/corn_183790.jpg";
        animalLocationCorn.title = "Umbhila";
        animalLocationCorn.location = "Corn";

        animalLocations.add(animalLocationCorn);

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