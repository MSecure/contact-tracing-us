package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {
    public static final boolean SYSTRACE_LIBRARY_LOADING = true;
    public static boolean isSystemApp;
    public static ApplicationSoSource sApplicationSoSource;
    public static UnpackingSoSource[] sBackupSoSources;
    public static int sFlags;
    public static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    public static SoFileLoader sSoFileLoader;
    public static SoSource[] sSoSources = null;
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    public static volatile int sSoSourcesVersion = 0;
    public static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    @DoNotOptimize
    @TargetApi(14)
    public static class Api14Utils {
        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("ClassLoader ");
                outline17.append(classLoader.getClass().getName());
                outline17.append(" should be of type BaseDexClassLoader");
                throw new IllegalStateException(outline17.toString());
            }
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        /* JADX WARNING: Illegal instructions before constructor call */
        public WrongAbiError(Throwable th, String str) {
            super(r0.toString());
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("APK was built for a different platform. Supported ABIs: ");
            outline17.append(Arrays.toString(SysUtil$MarshmallowSysdeps.getSupportedAbis()));
            outline17.append(" error: ");
            outline17.append(str);
            initCause(th);
        }
    }

    public static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (!(sSoSources != null)) {
                throw new RuntimeException("SoLoader.init() not yet called");
            }
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012a  */
    public static void doLoadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z;
        Throwable th;
        int i2;
        String message;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                sSoSourcesLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z = true;
                } else {
                    z = false;
                }
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, "]");
                }
                try {
                    sSoSourcesLock.readLock().lock();
                    i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 == 0) {
                            try {
                                if (i3 < sSoSources.length) {
                                    i2 = sSoSources[i3].loadLibrary(str, i, threadPolicy);
                                    if (i2 != 3 || sBackupSoSources == null) {
                                        i3++;
                                    } else {
                                        UnpackingSoSource[] unpackingSoSourceArr = sBackupSoSources;
                                        int length = unpackingSoSourceArr.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 < length) {
                                                UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i4];
                                                synchronized (unpackingSoSource) {
                                                    synchronized (unpackingSoSource.getLibraryLock(str)) {
                                                        unpackingSoSource.mCorruptedLib = str;
                                                        unpackingSoSource.prepare(2);
                                                    }
                                                }
                                                int loadLibrary = unpackingSoSource.loadLibrary(str, i, threadPolicy);
                                                if (loadLibrary == 1) {
                                                    i2 = loadLibrary;
                                                    break;
                                                }
                                                i4++;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                sSoSourcesLock.readLock().unlock();
                                throw th2;
                            }
                        }
                    }
                    try {
                        sSoSourcesLock.readLock().unlock();
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Trace.endSection();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i2 == 0 || i2 == 3) {
                            StringBuilder outline19 = GeneratedOutlineSupport.outline19("couldn't find DSO to load: ", str);
                            sSoSourcesLock.readLock().lock();
                            for (int i5 = 0; i5 < sSoSources.length; i5++) {
                                outline19.append("\n\tSoSource ");
                                outline19.append(i5);
                                outline19.append(": ");
                                outline19.append(sSoSources[i5].toString());
                            }
                            ApplicationSoSource applicationSoSource = sApplicationSoSource;
                            if (applicationSoSource != null) {
                                File nativeLibDirFromContext = ApplicationSoSource.getNativeLibDirFromContext(applicationSoSource.getUpdatedContext());
                                outline19.append("\n\tNative lib dir: ");
                                outline19.append(nativeLibDirFromContext.getAbsolutePath());
                                outline19.append("\n");
                            }
                            sSoSourcesLock.readLock().unlock();
                            outline19.append(" result: ");
                            outline19.append(i2);
                            String sb = outline19.toString();
                            Log.e("SoLoader", sb);
                            throw new UnsatisfiedLinkError(sb);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Trace.endSection();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i2 != 0 || i2 == 3) {
                            StringBuilder outline192 = GeneratedOutlineSupport.outline19("couldn't find DSO to load: ", str);
                            message = th.getMessage();
                            if (message == null) {
                                message = th.toString();
                            }
                            outline192.append(" caused by: ");
                            outline192.append(message);
                            th.printStackTrace();
                            outline192.append(" result: ");
                            outline192.append(i2);
                            String sb2 = outline192.toString();
                            Log.e("SoLoader", sb2);
                            throw new UnsatisfiedLinkError(sb2);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i2 = 0;
                    if (SYSTRACE_LIBRARY_LOADING) {
                    }
                    if (z) {
                    }
                    if (i2 != 0) {
                    }
                    StringBuilder outline1922 = GeneratedOutlineSupport.outline19("couldn't find DSO to load: ", str);
                    message = th.getMessage();
                    if (message == null) {
                    }
                    outline1922.append(" caused by: ");
                    outline1922.append(message);
                    th.printStackTrace();
                    outline1922.append(" result: ");
                    outline1922.append(i2);
                    String sb22 = outline1922.toString();
                    Log.e("SoLoader", sb22);
                    throw new UnsatisfiedLinkError(sb22);
                }
            } else {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
        } catch (Throwable th5) {
            sSoSourcesLock.readLock().unlock();
            throw th5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[SYNTHETIC] */
    public static void init(Context context, int i) throws IOException {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z2 = true;
        if ((i & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & 129) != 0) {
                    z = true;
                    isSystemApp = z;
                    initSoLoader(null);
                    initSoSources(context, i);
                    synchronized (NativeLoader.class) {
                        if (NativeLoader.sDelegate == null) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        NativeLoaderToSoLoaderDelegate nativeLoaderToSoLoaderDelegate = new NativeLoaderToSoLoaderDelegate();
                        synchronized (NativeLoader.class) {
                            if (NativeLoader.sDelegate == null) {
                                NativeLoader.sDelegate = nativeLoaderToSoLoaderDelegate;
                            } else {
                                throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                            }
                        }
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return;
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        }
        z = false;
        isSystemApp = z;
        initSoLoader(null);
        initSoSources(context, i);
        synchronized (NativeLoader.class) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    public static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        final Method method;
        final String classLoaderLdLoadLibrary;
        final String str;
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            if (Build.VERSION.SDK_INT <= 27) {
                try {
                    method = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                    method.setAccessible(true);
                } catch (NoSuchMethodException | SecurityException e) {
                    Log.w("SoLoader", "Cannot get nativeLoad method", e);
                }
                final boolean z = method == null;
                classLoaderLdLoadLibrary = !z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
                if (classLoaderLdLoadLibrary != null) {
                    str = null;
                } else {
                    String[] split = classLoaderLdLoadLibrary.split(ColorPropConverter.PACKAGE_DELIMITER);
                    ArrayList arrayList = new ArrayList(split.length);
                    for (String str2 : split) {
                        if (!str2.contains("!")) {
                            arrayList.add(str2);
                        }
                    }
                    str = TextUtils.join(ColorPropConverter.PACKAGE_DELIMITER, arrayList);
                }
                sSoFileLoader = new SoFileLoader() {
                    /* class com.facebook.soloader.SoLoader.AnonymousClass1 */

                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                        r0 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                        r1.close();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
                        r1 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
                        r7.addSuppressed(r1);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
                        throw r0;
                     */
                    public final String getLibHash(String str) {
                        try {
                            File file = new File(str);
                            MessageDigest instance = MessageDigest.getInstance("MD5");
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read > 0) {
                                    instance.update(bArr, 0, read);
                                } else {
                                    String format = String.format("%32x", new BigInteger(1, instance.digest()));
                                    fileInputStream.close();
                                    return format;
                                }
                            }
                        } catch (IOException e) {
                            return e.toString();
                        } catch (SecurityException e2) {
                            return e2.toString();
                        } catch (NoSuchAlgorithmException e3) {
                            return e3.toString();
                        }
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                        if (r1 == null) goto L_?;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                        r1 = com.android.tools.r8.GeneratedOutlineSupport.outline20("Error when loading lib: ", r1, " lib hash: ");
                        r1.append(getLibHash(r9));
                        r1.append(" search path is ");
                        r1.append(r10);
                        android.util.Log.e("SoLoader", r1.toString());
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
                        r1 = e;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
                    public void load(String str, int i) {
                        AnonymousClass1 r2;
                        Throwable th;
                        Throwable th2;
                        if (z) {
                            String str2 = (i & 4) == 4 ? classLoaderLdLoadLibrary : str;
                            String str3 = null;
                            try {
                                synchronized (runtime) {
                                    try {
                                        String str4 = (String) method.invoke(runtime, str, SoLoader.class.getClassLoader(), str2);
                                        if (str4 == null) {
                                            try {
                                            } catch (Throwable th3) {
                                                r2 = this;
                                                th2 = th3;
                                                str3 = str4;
                                                while (true) {
                                                    try {
                                                        break;
                                                    } catch (Throwable th4) {
                                                        th2 = th4;
                                                    }
                                                }
                                                throw th2;
                                            }
                                        } else {
                                            throw new UnsatisfiedLinkError(str4);
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        r2 = this;
                                        while (true) {
                                            break;
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                Throwable e2 = e;
                                r2 = this;
                                try {
                                    throw new RuntimeException("Error: Cannot load " + str, e2);
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (str3 != null) {
                                        StringBuilder outline20 = GeneratedOutlineSupport.outline20("Error when loading lib: ", str3, " lib hash: ");
                                        outline20.append(r2.getLibHash(str));
                                        outline20.append(" search path is ");
                                        outline20.append(str2);
                                        Log.e("SoLoader", outline20.toString());
                                    }
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                r2 = this;
                                if (str3 != null) {
                                }
                                throw th;
                            }
                        } else {
                            System.load(str);
                        }
                    }
                };
            }
            method = null;
            if (method == null) {
            }
            if (!z) {
            }
            if (classLoaderLdLoadLibrary != null) {
            }
            sSoFileLoader = new SoFileLoader() {
                /* class com.facebook.soloader.SoLoader.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
                    r7.addSuppressed(r1);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
                    throw r0;
                 */
                public final String getLibHash(String str) {
                    try {
                        File file = new File(str);
                        MessageDigest instance = MessageDigest.getInstance("MD5");
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                instance.update(bArr, 0, read);
                            } else {
                                String format = String.format("%32x", new BigInteger(1, instance.digest()));
                                fileInputStream.close();
                                return format;
                            }
                        }
                    } catch (IOException e) {
                        return e.toString();
                    } catch (SecurityException e2) {
                        return e2.toString();
                    } catch (NoSuchAlgorithmException e3) {
                        return e3.toString();
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    r1 = com.android.tools.r8.GeneratedOutlineSupport.outline20("Error when loading lib: ", r1, " lib hash: ");
                    r1.append(getLibHash(r9));
                    r1.append(" search path is ");
                    r1.append(r10);
                    android.util.Log.e("SoLoader", r1.toString());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
                    r1 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
                public void load(String str, int i) {
                    AnonymousClass1 r2;
                    Throwable th;
                    Throwable th2;
                    if (z) {
                        String str2 = (i & 4) == 4 ? classLoaderLdLoadLibrary : str;
                        String str3 = null;
                        try {
                            synchronized (runtime) {
                                try {
                                    String str4 = (String) method.invoke(runtime, str, SoLoader.class.getClassLoader(), str2);
                                    if (str4 == null) {
                                        try {
                                        } catch (Throwable th3) {
                                            r2 = this;
                                            th2 = th3;
                                            str3 = str4;
                                            while (true) {
                                                try {
                                                    break;
                                                } catch (Throwable th4) {
                                                    th2 = th4;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } else {
                                        throw new UnsatisfiedLinkError(str4);
                                    }
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    r2 = this;
                                    while (true) {
                                        break;
                                    }
                                    throw th2;
                                }
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            Throwable e2 = e;
                            r2 = this;
                            try {
                                throw new RuntimeException("Error: Cannot load " + str, e2);
                            } catch (Throwable th6) {
                                th = th6;
                                if (str3 != null) {
                                    StringBuilder outline20 = GeneratedOutlineSupport.outline20("Error when loading lib: ", str3, " lib hash: ");
                                    outline20.append(r2.getLibHash(str));
                                    outline20.append(" search path is ");
                                    outline20.append(str2);
                                    Log.e("SoLoader", outline20.toString());
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            r2 = this;
                            if (str3 != null) {
                            }
                            throw th;
                        }
                    } else {
                        System.load(str);
                    }
                }
            };
        }
    }

    /* JADX INFO: finally extract failed */
    public static void initSoSources(Context context, int i) throws IOException {
        int i2;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = SysUtil$MarshmallowSysdeps.is64Bit() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                int i3 = 0;
                for (String str2 : str.split(ColorPropConverter.PACKAGE_DELIMITER)) {
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        arrayList.add(0, new ExoSoSource(context, "lib-main"));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            ApplicationSoSource applicationSoSource = new ApplicationSoSource(context, 0);
                            sApplicationSoSource = applicationSoSource;
                            applicationSoSource.toString();
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, "lib-main", i2);
                            arrayList2.add(apkSoSource);
                            apkSoSource.toString();
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, new File(strArr[i4]), "lib-" + i5, i2);
                                    apkSoSource2.toString();
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                sSoSourcesLock.writeLock().lock();
                try {
                    if ((sFlags & 2) != 0) {
                        i3 = 1;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    int length2 = soSourceArr.length;
                    while (true) {
                        int i6 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        String str3 = "Preparing SO source: " + soSourceArr[i6];
                        soSourceArr[i6].prepare(i3);
                        length2 = i6;
                    }
                    sSoSources = soSourceArr;
                    sSoSourcesVersion++;
                    int length3 = sSoSources.length;
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
            sSoSourcesLock.writeLock().unlock();
        } catch (Throwable th2) {
            sSoSourcesLock.writeLock().unlock();
            throw th2;
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r1 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (com.facebook.soloader.SoLoader.sLoadedLibraries.contains(r6) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r8 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        if (r1 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        doLoadLibraryBySoName(r6, r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0055, code lost:
        monitor-enter(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        com.facebook.soloader.SoLoader.sLoadedLibraries.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005b, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0061, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0062, code lost:
        r7 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0066, code lost:
        if (r7 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r6, r7.substring(r7.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0080, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0086, code lost:
        if ((r9 & 16) != 0) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x008c, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0094, code lost:
        if (com.facebook.soloader.SoLoader.sLoadedAndMergedLibraries.contains(r7) == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0096, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0097, code lost:
        if (r8 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0099, code lost:
        if (r2 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x009d, code lost:
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x009f, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r7, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        com.facebook.react.uimanager.ReactYogaConfigProvider.invokeJniOnload(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a9, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ab, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00cf, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r7 + "', which has been merged into '" + r6 + "'.  See comment for details.", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d0, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d3, code lost:
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d5, code lost:
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d8, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d9, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00dc, code lost:
        return !r1;
     */
    public static boolean loadLibraryBySoNameImpl(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            if (!sLoadedLibraries.contains(str)) {
                z = false;
            } else if (str3 == null) {
                return false;
            } else {
                z = true;
            }
            if (sLoadingLibraries.containsKey(str)) {
                obj = sLoadingLibraries.get(str);
            } else {
                obj = new Object();
                sLoadingLibraries.put(str, obj);
            }
        }
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource soSource : sSoSources) {
                File unpackLibrary = soSource.unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        boolean z;
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z2;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z2 = !sLoadedLibraries.contains(str);
                        if (z2) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return z2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            if (!isSystemApp || (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) == null) {
                String mapLibraryName = System.mapLibraryName(str);
                boolean z3 = false;
                do {
                    try {
                        z3 = loadLibraryBySoNameImpl(mapLibraryName, str, null, i, null);
                        z = false;
                        continue;
                    } catch (UnsatisfiedLinkError e) {
                        int i2 = sSoSourcesVersion;
                        sSoSourcesLock.writeLock().lock();
                        try {
                            if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                                z = false;
                            } else {
                                Log.w("SoLoader", "sApplicationSoSource updated during load: " + mapLibraryName + ", attempting load again.");
                                sSoSourcesVersion = sSoSourcesVersion + 1;
                                z = true;
                            }
                            sSoSourcesLock.writeLock().unlock();
                            if (sSoSourcesVersion == i2) {
                                throw e;
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        } catch (Throwable th) {
                            sSoSourcesLock.writeLock().unlock();
                            throw th;
                        }
                    }
                } while (z);
                return z3;
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th2) {
            sSoSourcesLock.readLock().unlock();
            throw th2;
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
