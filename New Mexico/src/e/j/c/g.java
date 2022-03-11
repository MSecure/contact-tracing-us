package e.j.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import e.b.a.m;
import e.f.h;
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
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
/* loaded from: classes.dex */
public class g extends l {
    public static final Class<?> b;
    public static final Constructor<?> c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1575d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1576e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            cls = null;
            method2 = null;
            method = null;
        }
        c = constructor;
        b = cls;
        f1575d = method;
        f1576e = method2;
    }

    public static boolean f(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f1575d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface g(Object obj) {
        try {
            Object newInstance = Array.newInstance(b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1576e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // e.j.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
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
            int i3 = eVar.f1568f;
            File D0 = m.e.D0(context);
            if (D0 != null) {
                try {
                    if (m.e.B(D0, resources, i3)) {
                        try {
                            fileInputStream = new FileInputStream(D0);
                        } catch (IOException unused2) {
                            mappedByteBuffer = null;
                        }
                        try {
                            FileChannel channel = fileInputStream.getChannel();
                            mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                            fileInputStream.close();
                            if (!(mappedByteBuffer == null && f(obj, mappedByteBuffer, eVar.f1567e, eVar.b, eVar.c))) {
                                return null;
                            }
                        } finally {
                            break;
                        }
                    }
                } finally {
                    D0.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer == null) {
                return null;
            }
        }
        return g(obj);
    }

    @Override // e.j.c.l
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
                byteBuffer = m.e.b1(context, cancellationSignal, uri);
                hVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !f(obj, byteBuffer, lVar.b, lVar.c, lVar.f1596d)) {
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
