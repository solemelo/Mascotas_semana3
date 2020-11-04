package com.example.materialdesign;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public mascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.img.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tv_rk.setText(Integer.toString(mascota.getPuntos()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setPuntos(mascota.getPuntos()+1);
                Toast.makeText(activity, Integer.toString(mascota.getPuntos()), Toast.LENGTH_SHORT).show();
            }
        });

        mascotaViewHolder.btn_rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascotaViewHolder.tv_rk.setText(Integer.toString(mascota.getPuntos()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tvNombre;
        private final TextView tv_rk;
        private ImageButton btnLike;
        private ImageButton btn_rk;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tv_rk = (TextView) itemView.findViewById(R.id.tv_rk);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btn_rk = (ImageButton) itemView.findViewById(R.id.btn_rk);
        }
    }
}
