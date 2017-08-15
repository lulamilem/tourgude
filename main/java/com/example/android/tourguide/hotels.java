package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class hotels extends AppCompatActivity {
    public static Class getposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.four), R.drawable.skyl,"66 Jan Smuts Ave,Westcliff,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.royal), R.drawable.skyl,"Nugget St & Leyds St,Joubert Park,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.protea), R.drawable.skyl,"120 De Korte St,Wanderers View Estate,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.hotel), R.drawable.skyl,"191 Oxford Rd,Rosebank,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.park_s), R.drawable.skyl,"Wanderers St,Park Station,Johannesburg,south africa"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.hotels);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+pos.getLocation()+"?q="+pos.getText() + "  Johannesburg"));
                startActivity(intent);
            }
        });
    }
}