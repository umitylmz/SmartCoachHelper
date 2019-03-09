package com.wth.testapp;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilHolder extends RecyclerView.ViewHolder {

    public ImageView ProfilPicture;
    public ImageView tick;
    public TextView name;
    public TextView bmi;



    public ConstraintLayout layout;

    @SuppressLint("WrongViewCast")
    public ProfilHolder(@NonNull View itemView) {
        super(itemView);


        ProfilPicture=itemView.findViewById(R.id.ProfilPicture);
        tick=itemView.findViewById(R.id.tick);
        name=itemView.findViewById(R.id.name);
        bmi=itemView.findViewById(R.id.bmi);

        layout=itemView.findViewById(R.id.parent_layout);


    }


}

