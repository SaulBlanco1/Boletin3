package com.example.boletin_saulblancobenjacasal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorPreguntas  extends RecyclerView.Adapter<MyViewHolder> {

    private List<Pregunta> listaDepreguntas;
    private Context cont;


    public List<Pregunta> getListaDepreguntas() {
        return listaDepreguntas;
    }

    public void setListaDepreguntas(List<Pregunta> listaDepreguntas) {
        this.listaDepreguntas = listaDepreguntas;
    }

    public AdaptadorPreguntas(List<Pregunta> listaDepreguntas) {
        this.listaDepreguntas = listaDepreguntas;

    }

    @NonNull


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaPregunta =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_producto, viewGroup, false);
        return new MyViewHolder(filaPregunta);

    }

    //9.43 From AdaptadorPreguntas.MyViewHolder to ----> this

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        // Obtener la producto de nuestra lista gracias al índice i
        Pregunta pregunta = listaDepreguntas.get(i);

        // Obtener los datos de la lista
        String idpreg = String.valueOf(pregunta.getIdpregunta());
        String preguntaInfo = pregunta.getPregunta();
        //String resp1 = pregunta.getResp1();
        //String resp2 = pregunta.getResp2();
        //String resp3 = pregunta.getResp3();
        //String resp4 = pregunta.getResp4();
        String respcorr= pregunta.getRespcorr();




        // Y poner a los TextView los datos con setText
        myViewHolder.textView_idpreg.setText(idpreg);
        myViewHolder.textView_pregu.setText(preguntaInfo);
        //myViewHolder.textView_resp1.setText(resp1);
        //myViewHolder.textView_resp2.setText(resp2);
        //myViewHolder.textView_resp3.setText(resp3);
        //myViewHolder.textView_resp4.setText(resp4);
        myViewHolder.textView_respcorr.setText(respcorr);


    }
    public int getItemCount() {
        return getListaDepreguntas().size();
    }


}
