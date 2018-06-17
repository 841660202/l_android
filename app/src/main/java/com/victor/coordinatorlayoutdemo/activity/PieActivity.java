package com.victor.coordinatorlayoutdemo.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.victor.coordinatorlayoutdemo.R;
import com.victor.coordinatorlayoutdemo.bean.PieChartEntity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER;


/**
 * 源码新版图表使用demo 涉及修改源码
 * Created by jinB
 */
public class PieActivity extends AppCompatActivity {
    private List<String> dataList;
    private DecimalFormat mFormat;
    private float maxData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pie);
        updatePieChart();

    }


    /**
     * 添加数据均匀饼装图
     */
    public void updatePieChart() {
        int[] colors = {
                Color.parseColor("#faa74c"),
                Color.parseColor("#58D4C5"),
                Color.parseColor("#36a3eb"),
                Color.parseColor("#cc435f"),
                Color.parseColor("#f1ea56"),
                Color.parseColor("#f49468"),
                Color.parseColor("#d5932c"),
                Color.parseColor("#34b5cc"),
                Color.parseColor("#8169c6"),
                Color.parseColor("#ca4561"),
                Color.parseColor("#fee335")
        };
//        堆数据
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        for (int i = 0; i <= 5; i++) {
            PieEntry pieEntry = new PieEntry(60, "项目" + i);
            entries.add(pieEntry);
        }

        for (int i = 6; i <= 7; i++) {
            PieEntry pieEntry = new PieEntry(100, "项目" + i);
            entries.add(pieEntry);
        }

        PieEntry pieEntry = new PieEntry(100, "项目8");
        entries.add(pieEntry);
//        堆完

        if (entries.size() != 0) {
            PieChart new_pie_chart = (PieChart) findViewById(R.id.new_pie_chart);
            PieChartEntity pieChartEntity = new PieChartEntity(
                    new_pie_chart, // 节点
                    entries, // 数据源
                    new String[]{"啊啊啊", "吖吖吖", "兔兔兔"},
                    colors,
                    12f,
                    Color.GRAY,
                    PieDataSet.ValuePosition.OUTSIDE_SLICE
            );
            pieChartEntity.setHoleEnabled(
                    Color.TRANSPARENT,
                    40f,
                    Color.TRANSPARENT,
                    40f
            );
            pieChartEntity.setLegendEnabled(true);
            pieChartEntity.setPercentValues(false);

            Legend l = new_pie_chart.getLegend();

            l .setPosition(RIGHT_OF_CHART_CENTER);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
    }
}
