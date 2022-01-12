package com.facebook.soloader;

import android.os.StrictMode;
import android.os.Trace;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DirectorySoSource extends SoSource {
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    /* JADX INFO: finally extract failed */
    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file.getCanonicalPath();
            return 0;
        }
        file.getCanonicalPath();
        if (!((i & 1) == 0 || (this.flags & 2) == 0)) {
            return 2;
        }
        if ((this.flags & 1) != 0) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", file2.getName(), "]");
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                try {
                    String[] extract_DT_NEEDED = ReactYogaConfigProvider.extract_DT_NEEDED(fileInputStream.getChannel());
                    fileInputStream.close();
                    Arrays.toString(extract_DT_NEEDED);
                    for (String str2 : extract_DT_NEEDED) {
                        if (!str2.startsWith(ColorPropConverter.PATH_DELIMITER)) {
                            SoLoader.loadLibraryBySoNameImpl(str2, null, null, i | 1, threadPolicy);
                        }
                    }
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } finally {
                if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    Trace.endSection();
                }
            }
        }
        try {
            ((SoLoader.AnonymousClass1) SoLoader.sSoFileLoader).load(file2.getAbsolutePath(), i);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            if (e.getMessage().contains("bad ELF magic")) {
                return 3;
            }
            throw e;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.flags + ']';
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
