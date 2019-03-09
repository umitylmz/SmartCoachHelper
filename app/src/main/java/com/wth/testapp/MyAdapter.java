package com.wth.testapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.amulyakhare.textdrawable.TextDrawable;
import com.wth.testapp.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    public void refreshData(List<Person> personList){
        this.personList = personList;
        notifyDataSetChanged();
    }

    private Context mContext;
    private List<Person> personList;
    public MyAdapter(Context mContext, List<Person> personList ){
        this.mContext = mContext;
        this.personList = personList;
    }
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        Context        context                         = viewGroup.getContext();
        int            layoutIdForListItem             = R.layout.profil;
        LayoutInflater inflater                        = LayoutInflater.from(context);
        boolean        shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }


    public void onBindViewHolder(MyAdapter.MyViewHolder viewHolder, int i){
        try{
            if(personList.get(i).isOverallReached(0)){
                viewHolder.tick.setImageResource(R.drawable.bluetic);
            }
            else{
                viewHolder.tick.setImageResource(R.drawable.redx);
            }

            viewHolder.name.setText(personList.get(i).getFirstName() + " " + personList.get(i).getLastName());
            viewHolder.status.setText(personList.get(i).getStatus());
            int color;
            if(personList.get(i).getGender().equals("Male")){
                color = Color.rgb(135, 206, 250);
            }
            else{
                color = Color.rgb(255,182,193);
            }
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(String.valueOf((personList.get(i).getFirstName().charAt(0))), color);
            viewHolder.profilePic.setImageDrawable(drawable);
        } catch (Exception e){
            Log.v("HATA","dsada");
        }

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView profilePic;
        TextView status;
        ImageView tick;
        ConstraintLayout layout;
        public MyViewHolder(View v){
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            profilePic = (ImageView) v.findViewById(R.id.ProfilPicture);
            status = (TextView) v.findViewById(R.id.bmi);
            tick = (ImageView) v.findViewById(R.id.tick);
            layout=(ConstraintLayout)v.findViewById(R.id.parent_layout);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        Person clickedItem = personList.get(position);
                        Intent intent = new Intent(mContext, Detail.class);
                        intent.putExtra("POSITION", position);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
