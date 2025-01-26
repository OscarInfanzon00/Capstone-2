package com.infanzon.collaborativestorybuilder.Utils;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.infanzon.collaborativestorybuilder.R;

public class NotificationManager {
    private static NotificationManager instance;
    private View notificationView;
    private Handler handler = new Handler();

    private NotificationManager() {}

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void showNotification(Activity activity, String message, int iconResId, int duration) {
        // Inflate and add the custom notification layout if not already added
        if (notificationView == null) {
            LayoutInflater inflater = LayoutInflater.from(activity);
            notificationView = inflater.inflate(R.layout.custom_notification, null);
            activity.addContentView(notificationView, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
            ));
        }

        // Set message and icon
        TextView textView = notificationView.findViewById(R.id.notification_text);
        ImageView imageView = notificationView.findViewById(R.id.notification_icon);
        textView.setText(message);
        imageView.setImageResource(iconResId);

        // Show the notification
        notificationView.setVisibility(View.VISIBLE);

        // Auto-hide the notification after the specified duration
        handler.postDelayed(() -> {
            if (notificationView != null) {
                notificationView.setVisibility(View.GONE);
            }
        }, duration);
    }
}
