package com.wth.testapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class History extends AppCompatActivity {

    PieChartView pieChartView;
    PieChartView pieChartView2;
    PieChartView pieChartView3;
    PieChartView pieChartView4;
    PieChartView pieChartView5;
    PieChartView pieChartView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        String type= getIntent().getExtras().getString("type");

        if(type.equals("weekly")){

        }

        int color = Color.argb(255, 135, 206, 250);

        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        LimitLine upper_limit = new LimitLine(60f, "GOAL");

        upper_limit.setLineWidth(4f);
        upper_limit.enableDashedLine(10f, 10f, 0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_limit.setTextSize(10f);

        YAxis leftAxis = barChart.getAxisLeft();

        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(upper_limit);




        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);


        leftAxis.setDrawLimitLinesBehindData(false);

        barChart.getAxisRight().setEnabled(false);



        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 80f));
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh



        pieChartView = findViewById(R.id.BarStepGoal);

        pieChartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView2.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView3.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView4.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView5.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView6.setBackgroundColor(Color.argb(0,220,220,220));

            }
        });


        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(50, Color.BLUE).setLabel("Atılan"));

        pieData.add(new SliceValue(150, color).setLabel("Kalan"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setChartRotationEnabled(false);
        pieChartData.setHasLabels(false).setValueLabelTextSize(0);
        pieChartData.setHasCenterCircle(true).setCenterText1("Steps").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
        pieChartView.setChartRotation(90,false);



        pieChartView2 = findViewById(R.id.BarSleepGoal);

        pieChartView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView2.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView3.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView4.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView5.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView6.setBackgroundColor(Color.argb(0,220,220,220));
            }
        });

        List pieData2 = new ArrayList<>();
        pieData2.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData2.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData2 = new PieChartData(pieData2);
        pieChartData2.setHasLabels(false).setValueLabelTextSize(0);
        pieChartData2.setHasCenterCircle(true).setCenterText1("Sleep").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView2.setPieChartData(pieChartData2);
        pieChartView2.setChartRotationEnabled(false);
        pieChartView2.setChartRotation(90,false);


         pieChartView3 = findViewById(R.id.BarCaloriGoal);

        pieChartView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView3.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView2.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView4.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView5.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView6.setBackgroundColor(Color.argb(0,220,220,220));
            }
        });

        List pieData3 = new ArrayList<>();
        pieData3.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData3.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData3 = new PieChartData(pieData3);
        pieChartData3.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData3.setHasCenterCircle(true).setCenterText1("Calory").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView3.setPieChartData(pieChartData3);
        pieChartView3.setChartRotationEnabled(false);
        pieChartView3.setChartRotation(90,false);

        pieChartView4 = findViewById(R.id.OverallGoal);
        pieChartView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView4.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView2.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView3.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView5.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView6.setBackgroundColor(Color.argb(0,220,220,220));
            }
        });

        List pieData4 = new ArrayList<>();
        pieData4.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData4.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData4 = new PieChartData(pieData4);
        pieChartData4.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData4.setHasCenterCircle(true).setCenterText1("Overall").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView4.setPieChartData(pieChartData4);
        pieChartView4.setChartRotationEnabled(false);
        pieChartView4.setChartRotation(90,false);

        pieChartView5 = findViewById(R.id.Regeneration);
        pieChartView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView5.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView2.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView3.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView4.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView6.setBackgroundColor(Color.argb(0,220,220,220));
            }
        });

        List pieData5 = new ArrayList<>();
        pieData5.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData5.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData5 = new PieChartData(pieData5);
        pieChartData5.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData5.setHasCenterCircle(true).setCenterText1("Regeneration").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView5.setPieChartData(pieChartData5);
        pieChartView5.setChartRotationEnabled(false);
        pieChartView5.setChartRotation(90,false);

        pieChartView6 = findViewById(R.id.StresLevel);
        pieChartView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChartView6.setBackgroundColor(Color.argb(127,220,220,220));
                pieChartView2.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView3.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView4.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView5.setBackgroundColor(Color.argb(0,220,220,220));
                pieChartView.setBackgroundColor(Color.argb(0,220,220,220));
            }
        });

        List pieData6 = new ArrayList<>();
        pieData6.add(new SliceValue(50, Color.BLUE).setLabel("Atılan adım"));

        pieData6.add(new SliceValue(150, color).setLabel("Kalan adım"));

        PieChartData pieChartData6 = new PieChartData(pieData6);
        pieChartData6.setHasLabels(false).setValueLabelTextSize(14);
        pieChartData6.setHasCenterCircle(true).setCenterText1("Stres Level").setCenterText1FontSize(14).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView6.setPieChartData(pieChartData6);
        pieChartView6.setChartRotationEnabled(false);
        pieChartView6.setChartRotation(90,false);








    }
}
