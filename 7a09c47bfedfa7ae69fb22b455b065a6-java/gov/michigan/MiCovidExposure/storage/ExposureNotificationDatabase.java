package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import b.b.k.i;
import b.s.h;
import java.util.HashSet;

public abstract class ExposureNotificationDatabase extends h {
    public static final String DATABASE_NAME = "exposurenotification";
    public static volatile ExposureNotificationDatabase INSTANCE;

    public static ExposureNotificationDatabase buildDatabase(Context context) {
        h.a u = i.j.u(context.getApplicationContext(), ExposureNotificationDatabase.class, DATABASE_NAME);
        int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        if (u.m == null) {
            u.m = new HashSet(21);
        }
        for (int i = 0; i < 21; i++) {
            u.m.add(Integer.valueOf(iArr[i]));
        }
        return (ExposureNotificationDatabase) u.b();
    }

    public static synchronized ExposureNotificationDatabase getInstance(Context context) {
        ExposureNotificationDatabase exposureNotificationDatabase;
        synchronized (ExposureNotificationDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context);
            }
            exposureNotificationDatabase = INSTANCE;
        }
        return exposureNotificationDatabase;
    }

    public abstract ExposureDao exposureDao();

    public abstract PositiveDiagnosisDao positiveDiagnosisDao();

    public abstract TokenDao tokenDao();
}
