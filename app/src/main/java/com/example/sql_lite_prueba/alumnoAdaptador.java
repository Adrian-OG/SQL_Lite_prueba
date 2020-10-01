package com.example.sql_lite_prueba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class alumnoAdaptador extends RecyclerView.Adapter<alumnoAdaptador.ViewHolder> {

 public static class ViewHolder extends RecyclerView.ViewHolder{
     private TextView tv_nombre, tv_codigo , tv_celular, tv_email;
     private ImageView ic_person;

     public ViewHolder(View itemView){
         super(itemView);
         tv_nombre = (TextView) itemView.findViewById(R.id.id_tv_nombre);
         tv_codigo = (TextView) itemView.findViewById(R.id.id_tv_codigo);
         tv_celular = (TextView) itemView.findViewById(R.id._id_tv_celular);
         tv_email = (TextView) itemView.findViewById(R.id.id_tv_email);
         ic_person = (ImageView) itemView.findViewById(R.id.id_ic_person);

     }
 }
public List<Alumno> alumnos;
 public alumnoAdaptador(List<Alumno> alumnos){
     this.alumnos=alumnos;
 }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
       return  viewHolder;
    }

    @Override
    public void onBindViewHolder(    ViewHolder holder, int position) {
        holder.tv_nombre.setText(alumnos.get(position).getNombre());
        holder.tv_codigo.setText(alumnos.get(position).getCodigo());
        holder.tv_celular.setText(alumnos.get(position).getCelular());
        holder.tv_email.setText(alumnos.get(position).getEmail());



    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }
}
