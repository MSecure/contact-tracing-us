package com.google.android.apps.exposurenotification.restore;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import f.b.a.a.a.n0.a1;
import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public class ExposureNotificationBackupAgent extends BackupAgentHelper {

    /* loaded from: classes.dex */
    public interface a {
        a1 b();
    }

    @Override // android.app.backup.BackupAgent
    public void onCreate() {
        getSharedPreferences("enx_backup_preferences", 0).edit().commit();
        addHelper("enx_backup_prefs_key", new SharedPreferencesBackupHelper(this, "enx_backup_preferences"));
    }

    @Override // android.app.backup.BackupAgent
    public void onRestoreFinished() {
        super.onRestoreFinished();
        ((a) b.u0(getApplicationContext(), a.class)).b().a.edit().putBoolean("ExposureNotificationSharedPreferences.HAS_PENDING_RESTORE_NOTIFICATION", true).commit();
    }
}
