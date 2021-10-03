package octavia.dictionary.siswati;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Months extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public ArrayList<ObjectModel> data;
    DatabaseHelper db;
    ArrayList<String> wordcombinelist;
    ArrayList<String> meancombinelist;
    LinkedHashMap<String,String> namelist;
    SearchView searchView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        db = new DatabaseHelper(this);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQueryHint("Search");
        searchView.setQueryRefinementEnabled(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<ObjectModel>();
        fetchData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {


                newText = newText.toLowerCase();

                final ArrayList<ObjectModel> filteredList = new ArrayList<ObjectModel>();

                for (int i = 0; i < wordcombinelist.size(); i++) {

                    final String text = wordcombinelist.get(i).toLowerCase();
                    if (text.contains(newText)) {

                        filteredList.add(new ObjectModel(wordcombinelist.get(i),meancombinelist.get(i)));
                    }
                }
                adapter = new CustomAdapter(filteredList);
                recyclerView.setAdapter(adapter);


                return true;
            }
        });

    }

    private void fetchData() {

        db = new DatabaseHelper(this);
        try
        {
            db.createDataBase();
            db.openDatabase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        namelist = new LinkedHashMap<>();
        int li;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("Years" ,null, null, null, null, null, null);
        li = cursor.getColumnIndex("tinyanga");
        wordcombinelist = new ArrayList<String>();
        meancombinelist = new ArrayList<String>();

        while (cursor.moveToNext()){
            namelist.put(cursor.getString(li), cursor.getString(cursor.getColumnIndex("months")));
        }

        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordcombinelist.add(String.valueOf(thisEntry.getKey()));
            meancombinelist.add("-"+String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < wordcombinelist.size(); i++){
            data.add(new ObjectModel(wordcombinelist.get(i), meancombinelist.get(i)));
        }

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}