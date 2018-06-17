package com.victor.c_hlg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.victor.c_hlg.R;

/**
 * Created by Victor on 2017/1/23.
 */

public class NWFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_center, container, false);
//        RelativeLayout rlDynamic = (RelativeLayout) view.findViewById(R.id.rl_dynamic);
//        rlDynamic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), CollapsingActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView textView1 = (TextView) getView().findViewById(R.id.textView1);
//        textView1.setText("test???");
//        textView1.setTextSize(40);
//        textView1.setTextColor(Color.YELLOW);
        final TextView title = (TextView) getView().findViewById(R.id.main_tv_toolbar_title);
        final Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        AppBarLayout mAblBar = (AppBarLayout) getView().findViewById(R.id.main_abl_app_bar);
        mAblBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int halfScroll = appBarLayout.getTotalScrollRange() / 2;
                int offSetAbs = Math.abs(verticalOffset);
                float percentage;
                if (offSetAbs < halfScroll) {
                    title.setText("魔都");
                    percentage = 1 - (float) offSetAbs / (float) halfScroll;
                } else {
                    title.setText("个人中心");
                    percentage = (float) (offSetAbs - halfScroll) / (float) halfScroll;
                }
                toolbar.setAlpha(percentage);
            }
        });

    }


}
