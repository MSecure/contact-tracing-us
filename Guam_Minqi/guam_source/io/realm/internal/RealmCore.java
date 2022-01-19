package io.realm.internal;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinkerInstance;
import java.io.File;

public class RealmCore {
    public static final String FILE_SEP = File.separator;
    public static final String PATH_SEP = File.pathSeparator;
    public static boolean libraryIsLoaded = false;

    public static synchronized void loadLibrary(Context context) {
        synchronized (RealmCore.class) {
            if (!libraryIsLoaded) {
                new ReLinkerInstance().loadLibrary(context, "realm-jni", "7.0.5", null);
                libraryIsLoaded = true;
            }
        }
    }
}
