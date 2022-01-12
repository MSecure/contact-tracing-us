package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.FileStore;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;

public class SessionStore extends FileStore {
    public static final Comparator<File> SESSION_COMPARATOR = new Comparator<File>() {
        /* class com.bugsnag.android.SessionStore.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3 == null && file4 == null) {
                return 0;
            }
            if (file3 == null) {
                return 1;
            }
            if (file4 == null) {
                return -1;
            }
            return file3.getName().compareTo(file4.getName());
        }
    };

    public SessionStore(Context context, Logger logger, FileStore.Delegate delegate) {
        super(context, "/bugsnag-sessions/", 128, SESSION_COMPARATOR, logger, null);
    }

    @Override // com.bugsnag.android.FileStore
    public String getFilename(Object obj) {
        return String.format(Locale.US, "%s%s%d_v2.json", this.storeDirectory, UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis()));
    }
}
