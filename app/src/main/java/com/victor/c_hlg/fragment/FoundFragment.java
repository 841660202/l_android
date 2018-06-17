package com.victor.c_hlg.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.activity.CaptureActivity;
import com.victor.c_hlg.activity.CollapsingActivity;
import com.victor.c_hlg.activity.StickyActivity;
import com.victor.c_hlg.R;

/**
 * Created by Victor on 2017/1/23.
 */

public class FoundFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_found, container, false);
//        RelativeLayout rlDynamic = (RelativeLayout) view.findViewById(R.id.rl_dynamic);
//        rlDynamic.setOnClickListener(new View.OnClickListener() {
        TextView tv_btn = (TextView) view.findViewById(R.id.tv_btn);
        TextView tv_btn_list = (TextView) view.findViewById(R.id.tv_btn_list);
        ImageView img_btn = (ImageView) view.findViewById(R.id.img_btn);

        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_collapsing = new Intent(getContext(), CollapsingActivity.class);
//                        intent_collapsing.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent_collapsing);
            }
        });

        tv_btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sticky = new Intent(getContext(), StickyActivity.class);
//                        intent_collapsing.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // 无返回值
                startActivity(intent_sticky);
                // 有返回值

            }
        });
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sticky = new Intent(getContext(), CaptureActivity.class);
//                        intent_collapsing.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // 无返回值
                startActivity(intent_sticky);
                // 有返回值

            }
        });
        return view;

    }

}
