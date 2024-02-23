package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    private CharacterDetailsClickListener clickListener;//to pass to the adapter

    public CustomAdapter(ArrayList<DataModel> dataSet, CharacterDetailsClickListener clickListener) {
        this.dataSet = dataSet;
        this.clickListener = clickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewRace;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewAbove);
            textViewRace = itemView.findViewById(R.id.textViewBellow);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(dataSet.get(position).getName());
        holder.textViewRace.setText(dataSet.get(position).getRace());
        holder.imageView.setImageResource(dataSet.get(position).getImage());
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    clickListener.showCharacterDetails(dataSet.get(clickedPosition));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public void filterList(ArrayList<DataModel> filteredList) {
        dataSet = filteredList;
        notifyDataSetChanged();
    }

}