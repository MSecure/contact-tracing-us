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
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("ClassLoader ");
                outline15.append(classLoader.getClass().getName());
                outline15.append(" should be of type BaseDexClassLoader");
                throw new IllegalStateException(outline15.toString());
            }
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        /* JADX WARNING: Illegal instructions before constructor call */
        public WrongAbiError(Throwable th, String str) {
            super(r0.toString());
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("APK was built for a different platform. Supported ABIs: ");
            outline15.append(Arrays.toString(SysUtil$LollipopSysdeps.getSupportedAbis()));
            outline15.append(" error: ");
            outline15.append(str);
            initCause(th);
        }
    }

    public static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                throw new RuntimeException("SoLoader.init() not yet called");
            }
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public static void doLoadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z;
        boolean z2;
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
                int i2 = 0;
                do {
                    try {
                        sSoSourcesLock.readLock().lock();
                        int i3 = sSoSourcesVersion;
                        int i4 = 0;
                        while (true) {
                            if (i2 != 0) {
                                break;
                            }
                            try {
                                if (i4 < sSoSources.length) {
                                    i2 = sSoSources[i4].loadLibrary(str, i, threadPolicy);
                                    if (i2 == 3 && sBackupSoSources != null) {
                                        UnpackingSoSource[] unpackingSoSourceArr = sBackupSoSources;
                                        int length = unpackingSoSourceArr.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length) {
                                                break;
                                            }
                                            UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i5];
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
                                            i5++;
                                        }
                                    } else {
                                        i4++;
                                    }
                                } else {
                                    break;
                                }
                            } catch (Throwable th) {
                                sSoSourcesLock.readLock().unlock();
                                throw th;
                            }
                        }
                        sSoSourcesLock.readLock().unlock();
                        if ((i & 2) == 2 && i2 == 0) {
                            sSoSourcesLock.writeLock().lock();
                            try {
                                if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                    sSoSourcesVersion++;
                                }
                                z2 = sSoSourcesVersion != i3;
                                continue;
                            } finally {
                                sSoSourcesLock.writeLock().unlock();
                            }
                        } else {
                            z2 = false;
                            continue;
                        }
                    } catch (Throwable th2) {
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Trace.endSection();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i2 == 0 || i2 == 3) {
                            String outline8 = GeneratedOutlineSupport.outline8("couldn't find DSO to load: ", str);
                            String message = th2.getMessage();
                            if (message == null) {
                                message = th2.toString();
                            }
                            th2.printStackTrace();
                            String str2 = (outline8 + " caused by: " + message) + " result: " + i2;
                            Log.e("SoLoader", str2);
                            throw new UnsatisfiedLinkError(str2);
                        }
                        return;
                    }
                } while (z2);
                if (SYSTRACE_LIBRARY_LOADING) {
                    Trace.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i2 == 0 || i2 == 3) {
                    String str3 = GeneratedOutlineSupport.outline8("couldn't find DSO to load: ", str) + " result: " + i2;
                    Log.e("SoLoader", str3);
                    throw new UnsatisfiedLinkError(str3);
                }
                return;
            }
            Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } catch (Throwable th3) {
            sSoSourcesLock.readLock().unlock();
            throw th3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[SYNTHETIC] */
    public static void init(Context context, int i) throws IOException {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z2 = true;
        if (context != null) {
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
                        r1 = com.android.tools.r8.GeneratedOutlineSupport.outline17("Error when loading lib: ", r1, " lib hash: ");
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
                                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Error when loading lib: ", str3, " lib hash: ");
                                        outline17.append(r2.getLibHash(str));
                                        outline17.append(" search path is ");
                                        outline17.append(str2);
                                        Log.e("SoLoader", outline17.toString());
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
                    r1 = com.android.tools.r8.GeneratedOutlineSupport.outline17("Error when loading lib: ", r1, " lib hash: ");
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
                                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Error when loading lib: ", str3, " lib hash: ");
                                    outline17.append(r2.getLibHash(str));
                                    outline17.append(" search path is ");
                                    outline17.append(str2);
                                    Log.e("SoLoader", outline17.toString());
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
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(ColorPropConverter.PACKAGE_DELIMITER);
                int i3 = 0;
                for (int i4 = 0; i4 < split.length; i4++) {
                    String str2 = split[i4];
                    arrayList.add(new DirectorySoSource(new File(split[i4]), 2));
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
                                int i5 = 0;
                                int i6 = 0;
                                while (i5 < length) {
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, new File(strArr[i5]), "lib-" + i6, i2);
                                    apkSoSource2.toString();
                                    arrayList2.add(apkSoSource2);
                                    i5++;
                                    i6++;
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
                        int i7 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        String str3 = "Preparing SO source: " + soSourceArr[i7];
                        soSourceArr[i7].prepare(i3);
                        length2 = i7;
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

    /* JADX INFO: finally extract failed */
    public static boolean loadLibrary(String str) {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean contains;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        contains = true ^ sLoadedLibraries.contains(str);
                        if (contains) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return contains;
                }
            }
            sSoSourcesLock.readLock().unlock();
            if (!isSystemApp || (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) == null) {
                return loadLibraryBySoName(System.mapLibraryName(str), str, null, 2, null);
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        monitor-enter(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (com.facebook.soloader.SoLoader.sLoadedLibraries.contains(r3) == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        doLoadLibraryBySoName(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
        monitor-enter(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.facebook.soloader.SoLoader.sLoadedLibraries.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004e, code lost:
        monitor-exit(com.facebook.soloader.SoLoader.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        if ((r6 & 16) != 0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        r3 = com.facebook.soloader.SoLoader.sLoadedAndMergedLibraries.contains(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005f, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0060, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0065, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
        r4 = r3.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006a, code lost:
        if (r4 == null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0083, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r3, r4.substring(r4.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0084, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0085, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x008b, code lost:
        throw new java.lang.RuntimeException(r3);
     */
    public static boolean loadLibraryBySoName(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        Object obj;
        if (!TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            if (sLoadedLibraries.contains(str)) {
                return false;
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
        for (int i = 0; i < sSoSources.length; i++) {
            try {
                File unpackLibrary = sSoSources[i].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        sSoSourcesLock.readLock().unlock();
        throw new FileNotFoundException(str);
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
