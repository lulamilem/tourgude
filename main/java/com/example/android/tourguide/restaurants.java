package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words(getString(R.string.nandoss), R.drawable.skyl,"Rissik St,Shop C29,Western Concourse,Park Station,Johannesburg 2000,south africa"));
        words.add(new Words(getString(R.string.mcdonalds), R.drawable.skyl,"195,Jeppe St & Small St,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.debonairs), R.drawable.skyl,"Shop 200 Carlton Centre,Corner of Commissioner street & Kruis Road,Marshalltown,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.mr), R.drawable.skyl," 252 Smith St, Joubert Park, Sandton, South Africa"));
        words.add(new Words(getString(R.string.kfc), R.drawable.skyl,"De Korte St & Biccard St,Johannesburg,south africa"));

        InputAdapter adapter = new InputAdapter(this, words, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words pos = words.get(position);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + "?q=" + pos.getText() + "  Johannesburg"));
                startActivity(mapIntent);

            }
        });
    }
}

