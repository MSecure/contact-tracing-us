package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import e.b.a.m;
import e.i.b.b.c;
import e.i.b.b.d;
import e.i.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e extends k {
    public static Class<?> b = null;
    public static Constructor<?> c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f1423d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f1424e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1425f = false;

    public static boolean f(Object obj, String str, int i2, boolean z) {
        g();
        try {
            return ((Boolean) f1423d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void g() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1425f) {
            f1425f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
                method2 = null;
                cls = null;
                method = null;
            }
            c = constructor;
            b = cls;
            f1423d = method;
            f1424e = method2;
        }
    }

    @Override // e.i.c.k
    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        g();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            d[] dVarArr = cVar.a;
            for (d dVar : dVarArr) {
                File p0 = m.h.p0(context);
                if (p0 == null) {
                    return null;
                }
                try {
                    if (!m.h.y(p0, resources, dVar.f1420f)) {
                        p0.delete();
                        return null;
                    }
                    if (!f(newInstance, p0.getPath(), dVar.b, dVar.c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    p0.delete();
                }
            }
            g();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f1424e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055 A[SYNTHETIC, Splitter:B:18:0x0055] */
    @Override // e.i.c.k
    public Typeface b(Context context, CancellationSignal cancellationSignal, e.c[] cVarArr, int i2) {
        File file;
        FileInputStream fileInputStream;
        if (cVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(((e.c) k.e(cVarArr, i2, new j(this))).a, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                String readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                    file = new File(readlink);
                    if (file != null) {
                        try {
                            if (file.canRead()) {
                                Typeface createFromFile = Typeface.createFromFile(file);
                                openFileDescriptor.close();
                                return createFromFile;
                            }
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                    fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    Typeface c2 = c(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return c2;
                }
            } catch (ErrnoException unused) {
            }
            file = null;
            if (file != null) {
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                Typeface c22 = c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c22;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } catch (IOException unused2) {
            return null;
        }
        throw th;
        throw th;
    }
}
