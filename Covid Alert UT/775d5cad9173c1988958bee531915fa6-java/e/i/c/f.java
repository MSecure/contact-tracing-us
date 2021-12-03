package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import e.b.a.m;
import e.i.b.b.d;
import e.i.b.b.e;
import e.i.f.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f extends l {
    public static Class<?> b = null;
    public static Constructor<?> c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f1488d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f1489e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1490f = false;

    public static boolean f(Object obj, String str, int i2, boolean z) {
        g();
        try {
            return ((Boolean) f1488d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void g() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1490f) {
            f1490f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.getClass().getName();
                method2 = null;
                cls = null;
                method = null;
            }
            c = constructor;
            b = cls;
            f1488d = method;
            f1489e = method2;
        }
    }

    @Override // e.i.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        g();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            e[] eVarArr = dVar.a;
            for (e eVar : eVarArr) {
                File B0 = m.e.B0(context);
                if (B0 == null) {
                    return null;
                }
                try {
                    if (!m.e.B(B0, resources, eVar.f1484f)) {
                        B0.delete();
                        return null;
                    }
                    if (!f(newInstance, B0.getPath(), eVar.b, eVar.c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    B0.delete();
                }
            }
            g();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f1489e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055 A[SYNTHETIC, Splitter:B:18:0x0055] */
    @Override // e.i.c.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i2) {
        File file;
        FileInputStream fileInputStream;
        if (lVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(((l) l.e(lVarArr, i2, new k(this))).a, "r", cancellationSignal);
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
