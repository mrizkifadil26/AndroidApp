package com.example.labkomserver.realapplications;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    private static final String TAG = "ListView";

    ArrayList<Species> mSpecies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Log.d(TAG, "onCreate: started.");

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("categories"));

        initImages();
    }

    private void initImages() {
        Log.d(TAG, "initImages: preparing.");

        mSpecies.add(new Species(R.drawable.alpukat, "Alpukat", "Persea americana", "Pandeglang", "Apokat (KBBI: Avokad), avokad, atau Persea americana ialah tumbuhan penghasil buah meja dengan nama sama. \n\nTumbuhan ini berasal dari Meksiko dan Amerika Tengah dan kini banyak dibudidayakan di Amerika Selatan dan Amerika Tengah sebagai tanaman perkebunan monokultur dan sebagai tanaman pekarangan di daerah-daerah tropika lainnya di dunia."));
        mSpecies.add(new Species(R.drawable.belimbing, "Belimbing", "Averrhoa carambola", "Serang", "Belimbing / Belimbing Manis adalah tumbuhan penghasil buah berbentuk khas yang berasal dari Indonesia, India, dan Sri Langka. \n\nSaat ini, belimbing telah tersebar ke penjuru Asia Tenggara, Republik Dominika, Brasil, Peru, Ghana, Guyana, Tonga, dan Polinesia. \n\nUsaha penanaman secara komersial dilakukan di Amerika Serikat, yaitu di Florida Selatan dan Hawaii. \n\nDi Indonesia, buah ini menjadi ikon kota Depok, Jawa Barat, sejak tahun 2007."));
        mSpecies.add(new Species(R.drawable.jambu_air, "Jambu Air", "Syzygium aqueum", "Cilegon", "Jambu air adalah tumbuhan dalam suku jambu-jambuan atau Myrtaceae yang berasal dari Asia Tenggara. \n\nJambu air sebetulnya berbeda dengan jambu semarang (Syzygium samarangense), kerabat dekatnya yang memiliki pohon dan buah hampir serupa. \n\nBeberapa kultivarnya bahkan sukar dibedakan, sehingga kedua-duanya kerap dinamai dengan nama umum jambu air atau jambu saja. \n\nJambu air mudah ditanam dan di budidaya."));
        mSpecies.add(new Species(R.drawable.jeruk, "Jeruk", "Citrus L.", "Tangerang", "Jeruk atau limau adalah semua tumbuhan berbunga anggota marga Citrus dari suku Rutaceae (suku jeruk-jerukan). \n\nAnggotanya berbentuk pohon dengan buah yang berdaging dengan rasa masam yang segar, meskipun banyak di antara anggotanya yang memiliki rasa manis. \n\nRasa masam berasal dari kandungan asam sitrat yang memang menjadi terkandung pada semua anggotanya."));
        mSpecies.add(new Species(R.drawable.kelengkeng, "Kelengkeng", "Dimocarpus longan", "Lebak", "Lengkeng (juga disebut kelengkeng, matakucing, longan,[butuh rujukan] Dimocarpus longan, suku lerak-lerakan atau Sapindaceae) adalah tanaman buah-buahan yang berasal dari daratan Asia Tenggara."));

        initRecyclerView();
    }

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerView.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ListViewAdapter adapter = new ListViewAdapter(this, mSpecies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
