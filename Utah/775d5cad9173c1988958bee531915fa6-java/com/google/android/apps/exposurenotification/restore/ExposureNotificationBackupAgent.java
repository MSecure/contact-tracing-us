package com.google.android.apps.exposurenotification.restore;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import f.b.a.a.a.l0.v0;
import f.b.a.c.b.o.b;

public class ExposureNotificationBackupAgent extends BackupAgentHelper {

    public interface a {
        v0 b();
    }

    public void onCreate() {
        getSharedPreferences("enx_backup_preferences", 0).edit().commit();
        addHelper("enx_backup_prefs_key", new SharedPreferencesBackupHelper(this, "enx_backup_preferences"));
    }

    public void onRestoreFinished() {
        super.onRestoreFinished();
        ((a) b.t0(getApplicationContext(), a.class)).b().a.edit().putBoolean("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION", true).commit();
    }
}
