package b.i.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import b.b.k.i;
import b.e.h;
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
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class f extends j {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?> f1060b;

    /* renamed from: c  reason: collision with root package name */
    public static final Constructor<?> f1061c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1062d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f1063e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            cls = null;
            method2 = null;
            method = null;
        }
        f1061c = constructor;
        f1060b = cls;
        f1062d = method;
        f1063e = method2;
    }

    public static boolean g(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1062d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance(f1060b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1063e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.i.f.j
    public Typeface a(Context context, c cVar, Resources resources, int i) {
        Object obj;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = f1061c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        d[] dVarArr = cVar.f1029a;
        for (d dVar : dVarArr) {
            int i2 = dVar.f;
            File o0 = i.j.o0(context);
            if (o0 != null) {
                try {
                    if (i.j.B(o0, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(o0);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                                fileInputStream.close();
                                o0.delete();
                                if (!(mappedByteBuffer == null && g(obj, mappedByteBuffer, dVar.f1034e, dVar.f1031b, dVar.f1032c))) {
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
                    o0.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer == null) {
                return null;
            }
        }
        return h(obj);
        throw th;
    }

    @Override // b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Object obj;
        try {
            obj = f1061c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        h hVar = new h();
        for (b.f fVar : fVarArr) {
            Uri uri = fVar.f1087a;
            ByteBuffer byteBuffer = (ByteBuffer) hVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = i.j.B0(context, cancellationSignal, uri);
                hVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !g(obj, byteBuffer, fVar.f1088b, fVar.f1089c, fVar.f1090d)) {
                return null;
            }
        }
        Typeface h = h(obj);
        if (h == null) {
            return null;
        }
        return Typeface.create(h, i);
    }
}
