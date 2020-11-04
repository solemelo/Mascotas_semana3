package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listadoMascotas;
    public mascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        listadoMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager(llm);

        inicializaListaMascotas();

        inicializaAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, ranking.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void inicializaAdaptador() {
        adaptador = new mascotaAdaptador(mascotas, this);
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.pluto, "Pluto"));
        mascotas.add(new Mascota(R.drawable.negrito, "Negrito"));
        mascotas.add(new Mascota(R.drawable.linda, "Linda"));
        mascotas.add(new Mascota(R.drawable.coqueto, "Coqueto"));
        mascotas.add(new Mascota(R.drawable.pulgoso, "Pulgoso"));
        mascotas.add(new Mascota(R.drawable.manchi, "Manchi"));


    }
}