package com.example.boletin_saulblancobenjacasal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorPreguntas  extends RecyclerView.Adapter<AdaptadorPreguntas.MyViewHolder> {

    private List<Pregunta> listaDepreguntas;

    public AdaptadorPreguntas(List<Pregunta> listaDepreguntas) {
        this.listaDepreguntas = listaDepreguntas;
    }

    public List<Pregunta> getListaDepreguntas() {
        return listaDepreguntas;
    }

    public void setListaDepreguntas(List<Pregunta> listaDepreguntas) {
        this.listaDepreguntas = listaDepreguntas;
    }


    @NonNull
    @Override
    //9.43 From AdaptadorPreguntas.MyViewHolder to ----> this
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filaProducto = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_producto, parent, false);
        return new MyViewHolder(filaProducto);
    }

    //9.43 From AdaptadorPreguntas.MyViewHolder to ----> this
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        // Obtener la producto de nuestra lista gracias al índice i
        Pregunta pregunta = listaDepreguntas.get(i);

        // Obtener los datos de la lista
        String idpreg = String.valueOf(pregunta.getIdpregunta());
        String preguntaInfo = pregunta.getPregunta();
        String resp1 = pregunta.getResp1();
        String resp2 = pregunta.getResp2();
        String resp3 = pregunta.getResp3();
        String resp4 = pregunta.getResp4();
        String respcorr= pregunta.getRespcorr();

        // Y poner a los TextView los datos con setText
        holder.textView_idpreg.setText(idpreg);
        holder.textView_pregu.setText(preguntaInfo);
        holder.textView_resp1.setText(resp1);
        holder.textView_resp2.setText(resp2);
        holder.textView_resp3.setText(resp3);
        holder.textView_resp4.setText(resp4);
        holder.textView_respcorr.setText(respcorr);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_idpreg, textView_pregu, textView_resp1,textView_resp2,textView_resp3,textView_resp4,textView_respcorr;

        MyViewHolder(View itemView) {
            super(itemView);
            this.textView_idpreg = itemView.findViewById(R.id.textView_idpreg);
            this.textView_pregu = itemView.findViewById(R.id.textView_pregu);
           // this.textView_resp1 = itemView.findViewById(R.id.textView_resp1);
            //this.textView_resp2 = itemView.findViewById(R.id.textView_resp2);
            //this.textView_resp3 = itemView.findViewById(R.id.textView_resp3);
            //this.textView_resp4 = itemView.findViewById(R.id.textView_resp4);
            this.textView_respcorr=itemView.findViewById(R.id.textView_respcorr);
        }
    }
}
