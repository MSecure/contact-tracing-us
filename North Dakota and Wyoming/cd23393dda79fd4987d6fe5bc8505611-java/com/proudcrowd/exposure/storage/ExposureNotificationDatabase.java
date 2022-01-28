package com.proudcrowd.exposure.storage;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/* access modifiers changed from: package-private */
public abstract class ExposureNotificationDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "exposurenotification";
    private static volatile ExposureNotificationDatabase INSTANCE;

    /* access modifiers changed from: package-private */
    public abstract ExposureDao exposureDao();

    /* access modifiers changed from: package-private */
    public abstract KeyScanDao keyScanDao();

    /* access modifiers changed from: package-private */
    public abstract WatermarkUrlDao keyUrlDao();

    /* access modifiers changed from: package-private */
    public abstract PartyDao partyDao();

    ExposureNotificationDatabase() {
    }

    static synchronized ExposureNotificationDatabase getInstance(Context context) {
        ExposureNotificationDatabase exposureNotificationDatabase;
        synchronized (ExposureNotificationDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context);
            }
            exposureNotificationDatabase = INSTANCE;
        }
        return exposureNotificationDatabase;
    }

    private static ExposureNotificationDatabase buildDatabase(Context context) {
        return (ExposureNotificationDatabase) Room.databaseBuilder(context.getApplicationContext(), ExposureNotificationDatabase.class, DATABASE_NAME).fallbackToDestructiveMigrationFrom(1, 2).build();
    }
}
