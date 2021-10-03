package octavia.dictionary.siswati;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find views for home screen new intent
        findViewById(R.id.siswati).setOnClickListener(this);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.Animals).setOnClickListener(this);
        findViewById(R.id.idioms).setOnClickListener(this);
        findViewById(R.id.Tradition).setOnClickListener(this);
        findViewById(R.id.Swazi).setOnClickListener(this);
        findViewById(R.id.History).setOnClickListener(this);
        findViewById(R.id.Month).setOnClickListener(this);

        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_defination:
                Intent intent = new Intent(MainActivity.this,Defination.class);
                startActivity(intent);
                break;
            case R.id.nav_english:
                Intent intent1 = new Intent(MainActivity.this,Translation.class);
                startActivity(intent1);
                break;
            case R.id.nav_idioms:
                Intent intent2 = new Intent(MainActivity.this,idioms.class);
                startActivity(intent2);
                break;
            case R.id.nav_history:
                Intent intent3 = new Intent(MainActivity.this,History.class);
                startActivity(intent3);
                break;
            case R.id.nav_share:
                Intent intent4 = new Intent(MainActivity.this,Share.class);
                startActivity(intent4);
                break;
            case R.id.nav_exit:
                finish();
                System.exit(0);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.siswati){
        //open a new activity
        Intent intent=new Intent(this,Defination.class);
        startActivity(intent);
        }

        if (view.getId() ==R.id.english){
            //new activity here
            Intent intent2 = new Intent(this,Translation.class);
            startActivity(intent2);
        }

        if (view.getId() ==R.id.Animals){
            //new activity here
            Intent intent2 = new Intent(this,Animals.class);
            startActivity(intent2);
        }

        if (view.getId() ==R.id.idioms){
            //new activity here
            Intent intent3 = new Intent(this,idioms.class);
            startActivity(intent3);
        }

        if (view.getId() ==R.id.Tradition){
            //new activity here
            Intent intent4 = new Intent(this,Tradition.class);
            startActivity(intent4);
        }

        if (view.getId() ==R.id.History){
            //new activity here
            Intent intent5 = new Intent(this,History.class);
            startActivity(intent5);
        }

        if (view.getId() ==R.id.Swazi){
            //new activity
            Intent intent6 = new Intent(this,Random.class);
            startActivity(intent6);
        }

        if (view.getId() ==R.id.Month){
            //new activity
            Intent intent7 = new Intent(this,Months.class);
            startActivity(intent7);
        }
    }

}