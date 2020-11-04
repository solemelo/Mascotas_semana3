package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ranking extends AppCompatActivity {

    private RecyclerView listadoMascotas;
    public mascotaRankingAdaptador adaptador;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listadoMascotas = (RecyclerView) findViewById(R.id.rvMascotas_ranking);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listadoMascotas.setLayoutManager(llm);

        inicializaListaMascotas();

        inicializaAdaptador();
    }

    public void inicializaAdaptador() {
        adaptador = new mascotaRankingAdaptador(mascotas, this);
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.coqueto, "Coqueto",5));
        mascotas.add(new Mascota(R.drawable.linda, "Linda",15));
        mascotas.add(new Mascota(R.drawable.negrito, "Negrito",22));
        mascotas.add(new Mascota(R.drawable.manchi, "Manchi", 35));
        mascotas.add(new Mascota(R.drawable.pluto, "Pluto",18));
    }
}