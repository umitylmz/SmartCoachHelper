package com.wth.testapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Detail extends AppCompatActivity {

    PieChartView pieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int infoindex= getIntent().getExtras().getInt("Info");

        Log.v("gggggg",String.valueOf(infoindex));

        int color = Color.argb(255, 135, 206, 250);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pieChartView = findViewById(R.id.StepGoal);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(90, Color.BLUE).setLabel("Atılan adım"));

        pieData.add(new SliceValue(60, color).setLabel("Kalan adım"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("STEPS").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
        pieChartView.setChartRotation(90,false  );


        pieChartView = findViewById(R.id.SleepGoal);

        List pieData2 = new ArrayList<>();
        pieData2.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData2.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData2 = new PieChartData(pieData2);
        pieChartData2.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData2.setHasCenterCircle(true).setCenterText1("SLEEP").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData2);
        pieChartView.setChartRotation(90,false);


        pieChartView = findViewById(R.id.CaloriGoal);

        List pieData3 = new ArrayList<>();
        pieData3.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData3.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData3 = new PieChartData(pieData3);
        pieChartData3.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData3.setHasCenterCircle(true).setCenterText1("CALORY").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData3);
        pieChartView.setChartRotation(90,false);


        Button button=(Button)findViewById(R.id.Weekly);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Detail.this,History.class);
                i.putExtra("type", "weekly");
                startActivity(i);
            }
        });

        Button button2=(Button)findViewById(R.id.Monthly);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Detail.this,History.class);
                i.putExtra("type", "monthly");
                startActivity(i);
            }
        });






    }
}
