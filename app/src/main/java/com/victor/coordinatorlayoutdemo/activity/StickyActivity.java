package com.victor.coordinatorlayoutdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.victor.coordinatorlayoutdemo.R;
import com.victor.coordinatorlayoutdemo.adapter.LangyaAdapter;
import com.victor.coordinatorlayoutdemo.bean.LangyaSimple;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class StickyActivity extends Activity {

    public StickyListHeadersListView list;

    private LangyaAdapter langyaAdapter;

    private List<LangyaSimple> mLangyaDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);

        list = (StickyListHeadersListView) findViewById(R.id.stickList);
        mLangyaDatas = new ArrayList<LangyaSimple>();
        Log.i("sticky", String.valueOf(list));
        Log.i("sticky", String.valueOf(mLangyaDatas));
        initDatas();

        list.setOnItemClickListener(new OnPlanItemClick());
        list.setOnItemLongClickListener(new OnPlanItemLongClick());

        langyaAdapter = new LangyaAdapter(this, mLangyaDatas);
        list.setAdapter(langyaAdapter);

    }

    private void updateData() {

        if (langyaAdapter != null && mLangyaDatas != null) {

            langyaAdapter.notifyDataSetChanged();
        }
    }

    private class OnPlanItemClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            LangyaSimple oLangyaSimple = (LangyaSimple) parent.getAdapter().getItem(
                    position);
            Log.e("tag", oLangyaSimple.toString());
        }
    }

    private class OnPlanItemLongClick implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            LangyaSimple oLangyaSimple = mLangyaDatas.get(position);

            Log.e("tag", oLangyaSimple.toString());

            mLangyaDatas.remove(oLangyaSimple);

            updateData();

            return true;
        }
    }

    private void initDatas() {

        mLangyaDatas.add(new LangyaSimple("1", "1", "react", "声明式、组件化、学习一次，到处使用", "前端JS框架"));
        mLangyaDatas.add(new LangyaSimple("2", "1", "vue", "易用、灵活、高效", "前端JS框架"));
        mLangyaDatas.add(new LangyaSimple("3", "1", "angular", "一套框架，多种平台移动端&桌面端", "前端JS框架"));



        mLangyaDatas.add(new LangyaSimple("4", "2", "react native", "React Native is like React, but it uses native components instead of web components as building blocks", "近原生"));
        mLangyaDatas.add(new LangyaSimple("5", "2", "flutter", "Flutter is Google’s mobile app SDK for crafting high-quality native interfaces on iOS and Android in record time", "近原生"));

        mLangyaDatas.add(new LangyaSimple("6", "3", "vue+mui", "最接近原生APP体验的高性能前端框架", "web native"));
        mLangyaDatas.add(new LangyaSimple("7", "3", "ionic + cordova", "The top open source framework for building amazing mobile apps", "web native"));
        mLangyaDatas.add(new LangyaSimple("8", "3", "vue + cordova", "暂无评论", "web native"));

        mLangyaDatas.add(new LangyaSimple("9", "4", "java", "暂无评论", "后端"));
        mLangyaDatas.add(new LangyaSimple("11", "5", "kotlin", "暂无评论", "原生"));
        mLangyaDatas.add(new LangyaSimple("10", "5", "android", "储备中", "原生"));
        mLangyaDatas.add(new LangyaSimple("12", "5", "ios", "预储备", "原生"));

        mLangyaDatas.add(new LangyaSimple("13", "6", "PSCC", "暂无评论", "工具"));
        mLangyaDatas.add(new LangyaSimple("14", "6", "AI", "暂无评论", "工具"));
        mLangyaDatas.add(new LangyaSimple("15", "6", "Intellij IDEA", "后端java工具", "工具"));
        mLangyaDatas.add(new LangyaSimple("16", "6", "HBuilder", "mui配套工具", "工具"));
        mLangyaDatas.add(new LangyaSimple("17", "6", "WebStorm", "前端神器", "工具"));
        mLangyaDatas.add(new LangyaSimple("17", "6", "Android Studio", "android 工具", "工具"));
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
    }
}

