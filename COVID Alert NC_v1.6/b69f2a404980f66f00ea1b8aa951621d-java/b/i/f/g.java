package b.i.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import b.i.e.b.c;
import b.i.e.b.d;
import b.i.i.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class g extends e {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = o(cls2);
            method2 = p(cls2);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            method5 = q(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method3;
        this.j = method2;
        this.k = method;
        this.l = method4;
        this.m = method5;
    }

    private Object n() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.i.f.e, b.i.f.j
    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        if (!m()) {
            return super.a(context, cVar, resources, i2);
        }
        Object n = n();
        if (n == null) {
            return null;
        }
        d[] dVarArr = cVar.f1029a;
        for (d dVar : dVarArr) {
            if (!j(context, n, dVar.f1030a, dVar.f1034e, dVar.f1031b, dVar.f1032c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.f1033d))) {
                i(n);
                return null;
            }
        }
        if (!l(n)) {
            return null;
        }
        return k(n);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x00a1 */
    @Override // b.i.f.e, b.i.f.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        Typeface k2;
        boolean z;
        if (fVarArr.length < 1) {
            return null;
        }
        if (!m()) {
            b.f f = f(fVarArr, i2);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(f.f1087a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(f.f1089c).setItalic(f.f1090d).build();
                    openFileDescriptor.close();
                    return build;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            Map<Uri, ByteBuffer> d2 = b.d(context, fVarArr, cancellationSignal);
            Object n = n();
            if (n == null) {
                return null;
            }
            int length = fVarArr.length;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < length) {
                b.f fVar = fVarArr[i3];
                ByteBuffer byteBuffer = d2.get(fVar.f1087a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.j.invoke(n, byteBuffer, Integer.valueOf(fVar.f1088b), null, Integer.valueOf(fVar.f1089c), Integer.valueOf(fVar.f1090d ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        z = false;
                    }
                    if (!z) {
                        i(n);
                        return null;
                    }
                    z2 = true;
                }
                i3++;
                z2 = z2;
            }
            if (!z2) {
                i(n);
                return null;
            } else if (l(n) && (k2 = k(n)) != null) {
                return Typeface.create(k2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Override // b.i.f.j
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        if (!m()) {
            return super.d(context, resources, i2, str, i3);
        }
        Object n = n();
        if (n == null) {
            return null;
        }
        if (!j(context, n, str, 0, -1, -1, null)) {
            i(n);
            return null;
        } else if (!l(n)) {
            return null;
        } else {
            return k(n);
        }
    }

    public final void i(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean j(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface k(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean l(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean m() {
        Method method = this.i;
        return this.i != null;
    }

    public Method o(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method p(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method q(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
