package com.example.boletin_saulblancobenjacasal;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView_idpreg,textView_pregu, textView_resp1,textView_resp2,textView_resp3,textView_resp4,textView_respcorr;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.textView_idpreg =(TextView) itemView.findViewById(R.id.textView_idpreg);
        this.textView_pregu = (TextView) itemView.findViewById(R.id.textView_pregu);

       // this.textView_resp1 = (TextView) itemView.findViewById(R.id.textView_resp1);
       // this.textView_resp2 = (TextView) itemView.findViewById(R.id.textView_resp2);
        //this.textView_resp3 = (TextView) itemView.findViewById(R.id.textView_resp3);
        //this.textView_resp4 = (TextView) itemView.findViewById(R.id.textView_resp4);
        this.textView_respcorr= (TextView) itemView.findViewById(R.id.textView_respcorr);


    }


}
