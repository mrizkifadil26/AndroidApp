package com.example.labkomserver.realapplications;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Articles extends AppCompatActivity {

    private static final String TAG = "Articles";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: started.");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d(TAG, "getIncomingIntent: checking intent");

        int img = getIntent().getIntExtra("img", 0);
        String name = getIntent().getStringExtra("name");
        String species = getIntent().getStringExtra("species");
        String location = getIntent().getStringExtra("location");
        String desc = getIntent().getStringExtra("desc");

        Log.d(TAG, "setLayout: setting Layout.");

        ImageView mImageView = findViewById(R.id.images);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        TextView mSpeciesView = findViewById(R.id.species);
        TextView mLocationView = findViewById(R.id.location);
        TextView mDescView = findViewById(R.id.desc);

        mImageView.setImageResource(img);
        collapsingToolbarLayout.setTitle(name);
        mSpeciesView.setText(species);
        mLocationView.setText(location);
        mDescView.setText(desc);

    }

}
