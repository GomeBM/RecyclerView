package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CharacterDetailsClickListener{

    private ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomAdapter adapter;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet = new ArrayList<>();
        myData.populateShortDescriptionArray(this);
        recyclerView =  findViewById(R.id.resView);
        searchBar=findViewById(R.id.searchBarText);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        for ( int i =0 ; i < myData.nameArray.length ; i++){
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.raceArray[i],
                    myData.drawableArray[i],
                    myData.descriptionArray[i],
                    myData.id_[i]
            ));
        }

        adapter = new CustomAdapter(dataSet,this);
        recyclerView.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public void showCharacterDetails(DataModel dataModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        View alertDialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_dialog, null);
        builder.setView(alertDialogView);
        AlertDialog alert= builder.create();
        alert.show();
        TextView alertHeader=alertDialogView.findViewById(R.id.headerTextView);
        TextView alertDescription=alertDialogView.findViewById(R.id.descriptionTv);
        ImageView alertImage=alertDialogView.findViewById(R.id.dialogImage);
        alertImage.setImageResource(dataModel.getImage());
        alertHeader.setText(dataModel.getName());
        alertDescription.setText(dataModel.getDescription());
        Button confirmButton=alertDialogView.findViewById(R.id.confirmButton);
        Button animateButton=alertDialogView.findViewById(R.id.animateButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator scaleAnimatorX = ObjectAnimator.ofFloat(alertImage, "scaleX", 1f, 1.3f,1f);
                ObjectAnimator scaleAnimatorY = ObjectAnimator.ofFloat(alertImage, "scaleY", 1f, 1.3f,1f);
                ObjectAnimator bounceAnimator = ObjectAnimator.ofFloat(alertImage, "translationY", 0f, -200f, 0f);
                bounceAnimator.setInterpolator(new BounceInterpolator());
                AnimatorSet scaleAnimatorSet = new AnimatorSet();
                scaleAnimatorSet.playTogether(scaleAnimatorX, scaleAnimatorY,bounceAnimator);
                scaleAnimatorSet.setDuration(1000);
                scaleAnimatorSet.start();
            }
        });

    }
    private void filter(String text) {
        ArrayList<DataModel> filteredList = new ArrayList<>();
        for (DataModel item : dataSet) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}








