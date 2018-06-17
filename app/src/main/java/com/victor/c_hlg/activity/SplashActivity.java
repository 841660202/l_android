package com.victor.c_hlg.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

import com.victor.c_hlg.R;


public class SplashActivity extends Activity {
    private TextView mCountDownTextView;



    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private Handler handler;
    private MyCountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        mCountDownTextView = (TextView) findViewById(R.id.start_skip_count_down);
        handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
//        handler.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this,
//                        MainActivity.class);
//                startActivity(intent);
//                SplashActivity.this.finish();
//            }
//        }, SPLASH_DISPLAY_LENGHT);




        mCountDownTextView.setText("3s 跳过");
        //创建倒计时类
        mCountDownTimer = new MyCountDownTimer(SPLASH_DISPLAY_LENGHT, 1000);
        mCountDownTimer.start();
        //这是一个 Handler 里面的逻辑是从 Splash 界面跳转到 Main 界面，这里的逻辑每个公司基本上一致
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.go_right, R.anim.go_left);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);

    }
    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }

    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以「 毫秒 」为单位倒计时的总数
         *                          例如 millisInFuture = 1000 表示1秒
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick()
         *                          例如: countDownInterval = 1000 ; 表示每 1000 毫秒调用一次 onTick()
         */

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }


        public void onFinish() {
            mCountDownTextView.setText("0s 跳过");
        }

        public void onTick(long millisUntilFinished) {
            mCountDownTextView.setText(millisUntilFinished / 1000 + "s 跳过");
        }

    }
}




