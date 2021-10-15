package b.i.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import b.b.k.i;
import b.i.e.b.c;
import b.i.e.b.d;
import b.i.i.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e extends j {

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f1753b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Constructor<?> f1754c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f1755d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f1756e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1757f = false;

    public static boolean g(Object obj, String str, int i, boolean z) {
        h();
        try {
            return ((Boolean) f1755d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void h() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1757f) {
            f1757f = true;
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
            f1754c = constructor;
            f1753b = cls;
            f1755d = method;
            f1756e = method2;
        }
    }

    @Override // b.i.f.j
    public Typeface a(Context context, c cVar, Resources resources, int i) {
        h();
        try {
            Object newInstance = f1754c.newInstance(new Object[0]);
            d[] dVarArr = cVar.f1725a;
            for (d dVar : dVarArr) {
                File I = i.j.I(context);
                if (I == null) {
                    return null;
                }
                try {
                    if (!i.j.o(I, resources, dVar.f1731f)) {
                        I.delete();
                        return null;
                    }
                    if (!g(newInstance, I.getPath(), dVar.f1727b, dVar.f1728c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    I.delete();
                }
            }
            h();
            try {
                Object newInstance2 = Array.newInstance(f1753b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f1756e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e A[SYNTHETIC, Splitter:B:18:0x004e] */
    @Override // b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        File file;
        FileInputStream fileInputStream;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f(fVarArr, i).f1791a, "r", cancellationSignal);
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
                    Typeface c2 = super.c(context, fileInputStream);
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
                Typeface c22 = super.c(context, fileInputStream);
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
