package com.victor.coordinatorlayoutdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

import com.victor.coordinatorlayoutdemo.R;
import com.victor.coordinatorlayoutdemo.fragment.FoundFragment;
import com.victor.coordinatorlayoutdemo.fragment.FriendFragment;
import com.victor.coordinatorlayoutdemo.fragment.MsgFragment;
import com.victor.coordinatorlayoutdemo.fragment.NWFragment;
import com.victor.coordinatorlayoutdemo.fragment.WaterFallFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Fragment> mFragments;
    private String[] mTabTitles = { "瀑布", "消息", "好友", "动态", "你玩"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initToolBar();
        initFragment();

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_main);

        // 初始化Adapter
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this);
        // 设置adapter将ViewPager和Fragment关联起来
        viewPager.setAdapter(adapter);
        // 将TabLayout和ViewPager关联，达到TabLayout和Viewpager、Fragment联动的效果
        tabLayout.setupWithViewPager(viewPager);

    }

    /**
     * 初始化toolBar
     */
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_main);
        // 指定ToolBar的标题
        toolbar.setTitle("CoordinatorLayout");
        // 将toolBar和actionBar进行关联
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();//隐藏掉整个ActionBar，包括下面的Tabs
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        MsgFragment msgFragment = new MsgFragment();
        FriendFragment friendFragment = new FriendFragment();
        FoundFragment foundFragment = new FoundFragment();
        NWFragment nwFragment = new NWFragment();
        WaterFallFragment waterFallFragment = new WaterFallFragment();
        // 将三个fragment放入List里面管理，方便使用
        mFragments = new ArrayList<>();
        mFragments.add(waterFallFragment);
        mFragments.add(msgFragment);
        mFragments.add(friendFragment);
        mFragments.add(foundFragment);
        mFragments.add(nwFragment);
    }


    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private Context context;

        public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            // 获取指定位置的Fragment对象
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            // ViewPager管理页面的数量
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // 设置indicator的标题（TabLayout中tab的标题）
            return mTabTitles[position];
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
    }
}
