package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import e.b.a.m;
import e.e.h;
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
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class g extends l {
    public static final Class<?> b;
    public static final Constructor<?> c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1491d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1492e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            cls = null;
            method2 = null;
            method = null;
        }
        c = constructor;
        b = cls;
        f1491d = method;
        f1492e = method2;
    }

    public static boolean f(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f1491d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface g(Object obj) {
        try {
            Object newInstance = Array.newInstance(b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1492e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // e.i.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        e[] eVarArr = dVar.a;
        for (e eVar : eVarArr) {
            int i3 = eVar.f1484f;
            File B0 = m.e.B0(context);
            if (B0 != null) {
                try {
                    if (m.e.B(B0, resources, i3)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(B0);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                                fileInputStream.close();
                                B0.delete();
                                if (!(mappedByteBuffer == null && f(obj, mappedByteBuffer, eVar.f1483e, eVar.b, eVar.c))) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        } catch (IOException unused2) {
                            mappedByteBuffer = null;
                        }
                    }
                } finally {
                    B0.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer == null) {
                return null;
            }
        }
        return g(obj);
        throw th;
    }

    @Override // e.i.c.l
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i2) {
        Object obj;
        try {
            obj = c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        h hVar = new h();
        for (l lVar : lVarArr) {
            Uri uri = lVar.a;
            ByteBuffer byteBuffer = (ByteBuffer) hVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = m.e.V0(context, cancellationSignal, uri);
                hVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !f(obj, byteBuffer, lVar.b, lVar.c, lVar.f1511d)) {
                return null;
            }
        }
        Typeface g2 = g(obj);
        if (g2 == null) {
            return null;
        }
        return Typeface.create(g2, i2);
    }
}
