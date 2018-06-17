package com.victor.coordinatorlayoutdemo.Service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.victor.coordinatorlayoutdemo.R;

import me.leolin.shortcutbadger.ShortcutBadger;

public class BadgeIntentService extends IntentService {

    private int notificationId = 0;

    public BadgeIntentService() {
        super("BadgeIntentService");
    }

    private NotificationManager mNotificationManager;

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int badgeCount = intent.getIntExtra("badgeCount", 0);
            Log.i("service", "hello world");
            mNotificationManager.cancel(notificationId);
            notificationId++;

            String appName=(String) this.getResources().getText(R.string.app_name);

            Notification.Builder builder = new Notification.Builder(getApplicationContext())
                    .setContentTitle(appName)
                    .setContentText(Integer.toString(badgeCount))
                    .setSmallIcon(R.mipmap.ic_launcher);
            Notification notification = builder.build();
            ShortcutBadger.applyNotification(getApplicationContext(), notification, badgeCount);
            mNotificationManager.notify(notificationId, notification);
        }
    }
}
