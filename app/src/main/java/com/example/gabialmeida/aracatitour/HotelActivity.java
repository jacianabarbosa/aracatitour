package com.example.gabialmeida.aracatitour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gabialmeida.aracatitour.Database.ManageDatabase;

import java.util.ArrayList;

/**
 * Created by Gabi Almeida on 25/11/2016.
 */

public class HotelActivity extends Activity {

    public int id;
    private int var = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hot);

        ManageDatabase dbManager = new ManageDatabase(this);

        ArrayList<String> itens = dbManager.getAllItens("tbHotel", "HOT_NOME");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itens
        );

        ListView listaItens = (ListView) findViewById(R.id.list_view_hoteis);
        listaItens.setAdapter(adapter);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(HotelActivity.this, DefaultActivity.class));
            }
        });
    };

}
