package com.example.demo_bagels;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    /** GridView */
    GridView gridView;

    String bagelList[] ={
            "Bus Stop Bagel", "Collegtown Bagel DT", "Collgetown Bagel", "Collegtown Bagel E"
    };

    int bagelsIcon[] = {
            R.drawable.bagel1, R.drawable.bagel2, R.drawable.bagel3, R.drawable.bagel4
    };

    /** Toggle*/
    ToggleButton toggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** GridView*/
        gridView = (GridView) findViewById(R.id.gridView);

        GridAdapter adapter = new GridAdapter(MainActivity.this, bagelsIcon, bagelList);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked bagel:" + bagelList[position], Toast.LENGTH_SHORT).show();
            }
        });

//        /** Toggle*/
//        toggleButton = (ToggleButton)findViewById(R.id.toggle);
//        toggleButton.setChecked(false);
//        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.empty_heart));
//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked)
//                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.red_heart));
//                else
//                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.empty_heart));
//            }
//        });


        /** BottomNavigation*/
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListenner);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListenner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_add:
                            selectedFragment = new AddFragment();
                            break;

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_album:
                            selectedFragment = new AlbumFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };
}
