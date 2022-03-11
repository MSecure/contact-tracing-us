package e.j.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import e.b.a.m;
import e.j.b.b.d;
import e.j.b.b.e;
import e.j.g.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class f extends l {
    public static Class<?> b;
    public static Constructor<?> c;

    /* renamed from: d */
    public static Method f1572d;

    /* renamed from: e */
    public static Method f1573e;

    /* renamed from: f */
    public static boolean f1574f;

    public static boolean f(Object obj, String str, int i2, boolean z) {
        g();
        try {
            return ((Boolean) f1572d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void g() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1574f) {
            f1574f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.getClass().getName();
                method2 = null;
                cls = null;
                method = null;
            }
            c = constructor;
            b = cls;
            f1572d = method;
            f1573e = method2;
        }
    }

    @Override // e.j.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        g();
        try {
            Object newInstance = c.newInstance(new Object[0]);
            e[] eVarArr = dVar.a;
            for (e eVar : eVarArr) {
                File D0 = m.e.D0(context);
                if (D0 == null) {
                    return null;
                }
                try {
                    if (!m.e.B(D0, resources, eVar.f1568f)) {
                        return null;
                    }
                    if (!f(newInstance, D0.getPath(), eVar.b, eVar.c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    D0.delete();
                }
            }
            g();
            try {
                Object newInstance2 = Array.newInstance(b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f1573e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // e.j.c.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i2) {
        File file;
        String readlink;
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
                readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
            } catch (ErrnoException unused) {
            }
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                file = new File(readlink);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface c2 = c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c2;
            }
            file = null;
            if (file != null) {
                Typeface createFromFile2 = Typeface.createFromFile(file);
                openFileDescriptor.close();
                return createFromFile2;
            }
            FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface c22 = c(context, fileInputStream2);
            fileInputStream2.close();
            openFileDescriptor.close();
            return c22;
        } catch (IOException unused2) {
            return null;
        }
    }
}
