package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class ApplicationSoSource extends SoSource {
    public Context applicationContext;
    public int flags;
    public DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        if (applicationContext2 == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.applicationContext = context;
        }
        this.flags = i;
        this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), i);
    }

    public boolean checkAndMaybeUpdate() throws IOException {
        try {
            File file = this.soSource.soDirectory;
            Context createPackageContext = this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
            File file2 = new File(createPackageContext.getApplicationInfo().nativeLibraryDir);
            if (file.equals(file2)) {
                return false;
            }
            String str = "Native library directory updated from " + file + " to " + file2;
            int i = this.flags | 1;
            this.flags = i;
            this.soSource = new DirectorySoSource(file2, i);
            this.applicationContext = createPackageContext;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.soSource.loadLibrary(str, i, threadPolicy);
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        this.soSource.prepare(i);
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return this.soSource.toString();
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) throws IOException {
        DirectorySoSource directorySoSource = this.soSource;
        if (directorySoSource != null) {
            File file = new File(directorySoSource.soDirectory, str);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        throw null;
    }
}
