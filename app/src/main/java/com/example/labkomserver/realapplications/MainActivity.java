package com.example.labkomserver.realapplications;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mTextMessage;

    ArrayList<Categories> mCategories = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_maps:
                    mTextMessage.setText(R.string.title_maps);
                    return true;
                case R.id.navigation_about:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Log.d(TAG, "onCreate: started.");

        mCategories.add(new Categories(R.drawable.carrot, "Tanaman Sayur"));
        mCategories.add(new Categories(R.drawable.apple, "Tanaman Buah"));
        mCategories.add(new Categories(R.drawable.flower, "Tanaman Hias"));
        mCategories.add(new Categories(R.drawable.fertilizer, "Tanaman Obat"));

        RecyclerView recyclerView = findViewById(R.id.grid_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);

        MainAdapter adapter = new MainAdapter(this, mCategories);
        recyclerView.setAdapter(adapter);

    }

}
