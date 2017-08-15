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
public class cinemas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.bioscope),R.drawable.skyl, "286 Fox St,City and Suburban,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.sterk), R.drawable.skyl,"Newtown Mall,Miriam Makeba St,Newtown,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.sabc), R.drawable.skyl,"Henley Rd & Artillery Rd,Aukland Park,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.maboneng), R.drawable.skyl,"286 Fox St & Kruger St,Jeppestown,Johannesburg,south africa"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.cinemas);
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