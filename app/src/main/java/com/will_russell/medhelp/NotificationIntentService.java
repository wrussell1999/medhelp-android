package com.will_russell.medhelp;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;

public abstract class NotificationIntentService extends IntentService {

    private static final int NOTIFICATION_ID = 3;

    public NotificationIntentService() {
        super("NotificationIntentService");
    }

    protected void onHandledIntent(Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Time to take medication!");
        builder.setContentText("Remember it's time to take {X}");
        builder.setSmallIcon(R.drawable.ic_assignment_white_24dp);

        Intent notificationIntent = new Intent(this, MedicationOverview.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notification);
    }


}
