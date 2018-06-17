package com.victor.c_hlg.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.victor.c_hlg.adapter.HomeIconAdapter;
import com.victor.c_hlg.bean.Icon;
import com.victor.c_hlg.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = HomeActivity.this;
        grid_photo = (GridView) findViewById(R.id.grid_photo);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.iv_icon_1, "周一"));
        mData.add(new Icon(R.mipmap.iv_icon_2, "周二"));
        mData.add(new Icon(R.mipmap.iv_icon_3, "周三"));
        mData.add(new Icon(R.mipmap.iv_icon_4, "周四"));
        mData.add(new Icon(R.mipmap.iv_icon_5, "周五"));
        mData.add(new Icon(R.mipmap.iv_icon_6, "周六"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "周日"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "加班"));

        mAdapter = new HomeIconAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(HomeIconAdapter.ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(
                                HomeActivity.this,
                                MainActivity.class
                        );
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(
                                HomeActivity.this,
                                PieActivity.class
                        );
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(
                                HomeActivity.this,
                                PicActivity.class
                        );
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(
                                HomeActivity.this,
                                PickerActivity.class
                        );
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(
                                HomeActivity.this,
                                AppBadgeActivity.class
                        );
                        startActivity(intent4);
                        break;
                    default:

                }
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();

                overridePendingTransition(R.anim.go_right, R.anim.go_left);
            }
        });

    }

    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
    }
}