package com.getkeepsafe.relinker;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.getkeepsafe.relinker.ApkLibraryInstaller;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance {
    public final ReLinker$LibraryInstaller libraryInstaller;
    public final ReLinker$LibraryLoader libraryLoader;
    public final Set<String> loadedLibraries = new HashSet();

    public ReLinkerInstance() {
        SystemLibraryLoader systemLibraryLoader = new SystemLibraryLoader();
        ApkLibraryInstaller apkLibraryInstaller = new ApkLibraryInstaller();
        this.libraryLoader = systemLibraryLoader;
        this.libraryInstaller = apkLibraryInstaller;
    }

    public File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    public File getWorkaroundLibFile(Context context, String str, String str2) {
        String mapLibraryName = ((SystemLibraryLoader) this.libraryLoader).mapLibraryName(str);
        if (ReactYogaConfigProvider.isEmpty(str2)) {
            return new File(getWorkaroundLibDir(context), mapLibraryName);
        }
        return new File(getWorkaroundLibDir(context), GeneratedOutlineSupport.outline11(mapLibraryName, ".", str2));
    }

    public void loadLibrary(final Context context, final String str, final String str2, final ReLinker$LoadListener reLinker$LoadListener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!ReactYogaConfigProvider.isEmpty(str)) {
            String.format(Locale.US, "Beginning load of %s...", str);
            if (reLinker$LoadListener == null) {
                loadLibraryInternal(context, str, str2);
            } else {
                new Thread(new Runnable() {
                    /* class com.getkeepsafe.relinker.ReLinkerInstance.AnonymousClass1 */

                    public void run() {
                        try {
                            ReLinkerInstance.this.loadLibraryInternal(context, str, str2);
                            reLinker$LoadListener.success();
                        } catch (UnsatisfiedLinkError e) {
                            reLinker$LoadListener.failure(e);
                        } catch (MissingLibraryException e2) {
                            reLinker$LoadListener.failure(e2);
                        }
                    }
                }).start();
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:62|63|64|65|66|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x017e, code lost:
        if (r11.zipFile != null) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0136, code lost:
        if (r11.zipFile != null) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        r11.zipFile.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0128 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A[SYNTHETIC, Splitter:B:106:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01c4 A[SYNTHETIC, Splitter:B:132:0x01c4] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0156 A[SYNTHETIC, Splitter:B:81:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015b A[SYNTHETIC, Splitter:B:85:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0163 A[SYNTHETIC, Splitter:B:95:0x0163] */
    public final void loadLibraryInternal(Context context, String str, String str2) {
        ApkLibraryInstaller.ZipFileInZipEntry zipFileInZipEntry;
        Throwable th;
        ApkLibraryInstaller.ZipFileInZipEntry findAPKWithLibrary;
        String[] strArr;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Closeable closeable;
        InputStream inputStream2;
        Throwable th2;
        Closeable closeable2;
        boolean z = false;
        int i = 1;
        if (this.loadedLibraries.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            if (((SystemLibraryLoader) this.libraryLoader) != null) {
                System.loadLibrary(str);
                this.loadedLibraries.add(str);
                String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
                return;
            }
            throw null;
        } catch (UnsatisfiedLinkError e) {
            String.format(Locale.US, "Loading the library normally failed: %s", Log.getStackTraceString(e));
            String.format(Locale.US, "%s (%s) was not loaded normally, re-linking...", str, str2);
            File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
            if (!workaroundLibFile.exists()) {
                File workaroundLibDir = getWorkaroundLibDir(context);
                File workaroundLibFile2 = getWorkaroundLibFile(context, str, str2);
                final String mapLibraryName = ((SystemLibraryLoader) this.libraryLoader).mapLibraryName(str);
                File[] listFiles = workaroundLibDir.listFiles(new FilenameFilter(this) {
                    /* class com.getkeepsafe.relinker.ReLinkerInstance.AnonymousClass2 */

                    public boolean accept(File file, String str) {
                        return str.startsWith(mapLibraryName);
                    }
                });
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (!file.getAbsolutePath().equals(workaroundLibFile2.getAbsolutePath())) {
                            file.delete();
                        }
                    }
                }
                ReLinker$LibraryInstaller reLinker$LibraryInstaller = this.libraryInstaller;
                if (((SystemLibraryLoader) this.libraryLoader) != null) {
                    String[] strArr2 = Build.SUPPORTED_ABIS;
                    if (strArr2.length <= 0) {
                        strArr2 = !ReactYogaConfigProvider.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
                    }
                    String mapLibraryName2 = ((SystemLibraryLoader) this.libraryLoader).mapLibraryName(str);
                    ApkLibraryInstaller apkLibraryInstaller = (ApkLibraryInstaller) reLinker$LibraryInstaller;
                    if (apkLibraryInstaller != null) {
                        findAPKWithLibrary = apkLibraryInstaller.findAPKWithLibrary(context, strArr2, mapLibraryName2, this);
                        if (findAPKWithLibrary != null) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2 + 1;
                                if (i2 < 5) {
                                    Object[] objArr = new Object[i];
                                    char c = z ? 1 : 0;
                                    char c2 = z ? 1 : 0;
                                    char c3 = z ? 1 : 0;
                                    char c4 = z ? 1 : 0;
                                    objArr[c] = mapLibraryName2;
                                    String.format(Locale.US, "Found %s! Extracting...", objArr);
                                    try {
                                        if (workaroundLibFile.exists() || workaroundLibFile.createNewFile()) {
                                            try {
                                                inputStream = findAPKWithLibrary.zipFile.getInputStream(findAPKWithLibrary.zipEntry);
                                                try {
                                                    fileOutputStream = new FileOutputStream(workaroundLibFile);
                                                } catch (FileNotFoundException unused) {
                                                    fileOutputStream = null;
                                                    if (inputStream != null) {
                                                    }
                                                    if (fileOutputStream == null) {
                                                    }
                                                    fileOutputStream.close();
                                                    i2 = i3;
                                                    z = false;
                                                    i = 1;
                                                } catch (IOException unused2) {
                                                    fileOutputStream = null;
                                                    if (inputStream != null) {
                                                    }
                                                    if (fileOutputStream == null) {
                                                    }
                                                    fileOutputStream.close();
                                                    i2 = i3;
                                                    z = false;
                                                    i = 1;
                                                } catch (Throwable th3) {
                                                    th2 = th3;
                                                    closeable2 = null;
                                                    closeable = closeable2;
                                                    inputStream2 = inputStream;
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (closeable != null) {
                                                    }
                                                    throw th2;
                                                }
                                                try {
                                                    byte[] bArr = new byte[4096];
                                                    long j = 0;
                                                    boolean z2 = i;
                                                    while (true) {
                                                        int read = inputStream.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        int i4 = z ? 1 : 0;
                                                        int i5 = z ? 1 : 0;
                                                        int i6 = z ? 1 : 0;
                                                        int i7 = z ? 1 : 0;
                                                        fileOutputStream.write(bArr, i4, read);
                                                        j += (long) read;
                                                        z = false;
                                                        z2 = true;
                                                    }
                                                    fileOutputStream.flush();
                                                    fileOutputStream.getFD().sync();
                                                    if (j != workaroundLibFile.length()) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused3) {
                                                        }
                                                        fileOutputStream.close();
                                                        i2 = i3;
                                                        z = false;
                                                        i = 1;
                                                    } else {
                                                        inputStream.close();
                                                        fileOutputStream.close();
                                                        workaroundLibFile.setReadable(z2, z);
                                                        workaroundLibFile.setExecutable(z2, z);
                                                        workaroundLibFile.setWritable(z2);
                                                    }
                                                } catch (FileNotFoundException unused4) {
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused5) {
                                                        }
                                                    }
                                                    if (fileOutputStream == null) {
                                                        i2 = i3;
                                                        z = false;
                                                        i = 1;
                                                    }
                                                    fileOutputStream.close();
                                                    i2 = i3;
                                                    z = false;
                                                    i = 1;
                                                } catch (IOException unused6) {
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused7) {
                                                        }
                                                    }
                                                    if (fileOutputStream == null) {
                                                        i2 = i3;
                                                        z = false;
                                                        i = 1;
                                                    }
                                                    fileOutputStream.close();
                                                    i2 = i3;
                                                    z = false;
                                                    i = 1;
                                                } catch (Throwable th4) {
                                                    th2 = th4;
                                                    closeable2 = fileOutputStream;
                                                    closeable = closeable2;
                                                    inputStream2 = inputStream;
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (IOException unused8) {
                                                        }
                                                    }
                                                    if (closeable != null) {
                                                        try {
                                                            closeable.close();
                                                        } catch (IOException unused9) {
                                                        }
                                                    }
                                                    throw th2;
                                                }
                                            } catch (FileNotFoundException unused10) {
                                                inputStream = null;
                                                fileOutputStream = null;
                                                if (inputStream != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                                fileOutputStream.close();
                                                i2 = i3;
                                                z = false;
                                                i = 1;
                                            } catch (IOException unused11) {
                                                inputStream = null;
                                                fileOutputStream = null;
                                                if (inputStream != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                                fileOutputStream.close();
                                                i2 = i3;
                                                z = false;
                                                i = 1;
                                            } catch (Throwable th5) {
                                                th2 = th5;
                                                inputStream2 = null;
                                                closeable = null;
                                                if (inputStream2 != null) {
                                                }
                                                if (closeable != null) {
                                                }
                                                throw th2;
                                            }
                                        } else {
                                            i2 = i3;
                                            z = false;
                                            i = 1;
                                        }
                                    } catch (IOException unused12) {
                                    }
                                }
                            }
                        } else {
                            try {
                                strArr = apkLibraryInstaller.getSupportedABIs(context, mapLibraryName2);
                            } catch (Exception e2) {
                                strArr = new String[]{e2.toString()};
                            }
                            throw new MissingLibraryException(mapLibraryName2, strArr2, strArr);
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            ReLinker$LibraryLoader reLinker$LibraryLoader = this.libraryLoader;
            String absolutePath = workaroundLibFile.getAbsolutePath();
            if (((SystemLibraryLoader) reLinker$LibraryLoader) != null) {
                System.load(absolutePath);
                this.loadedLibraries.add(str);
                String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
                return;
            }
            throw null;
        } catch (Throwable th6) {
            th = th6;
            zipFileInZipEntry = findAPKWithLibrary;
            if (zipFileInZipEntry != null) {
            }
            throw th;
        }
    }
}
