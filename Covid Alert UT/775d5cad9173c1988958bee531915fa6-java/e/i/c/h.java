package e.i.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import e.b.a.m;
import e.i.b.b.d;
import e.i.b.b.e;
import e.i.f.l;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class h extends f {

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f1493g;

    /* renamed from: h  reason: collision with root package name */
    public final Constructor<?> f1494h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f1495i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f1496j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f1497k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f1498l;
    public final Method m;

    public h() {
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
            method3 = n(cls2);
            method2 = o(cls2);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            method5 = p(cls2);
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
        this.f1493g = cls;
        this.f1494h = constructor;
        this.f1495i = method3;
        this.f1496j = method2;
        this.f1497k = method;
        this.f1498l = method4;
        this.m = method5;
    }

    private Object m() {
        try {
            return this.f1494h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // e.i.c.l, e.i.c.f
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        if (!l()) {
            return super.a(context, dVar, resources, i2);
        }
        Object m2 = m();
        if (m2 == null) {
            return null;
        }
        e[] eVarArr = dVar.a;
        for (e eVar : eVarArr) {
            if (!i(context, m2, eVar.a, eVar.f1483e, eVar.b, eVar.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(eVar.f1482d))) {
                h(m2);
                return null;
            }
        }
        if (!k(m2)) {
            return null;
        }
        return j(m2);
    }

    @Override // e.i.c.l, e.i.c.f
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i2) {
        Typeface j2;
        boolean z;
        if (lVarArr.length < 1) {
            return null;
        }
        if (!l()) {
            l lVar = (l) l.e(lVarArr, i2, new k(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(lVar.a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(lVar.c).setItalic(lVar.f1511d).build();
                    openFileDescriptor.close();
                    return build;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            HashMap hashMap = new HashMap();
            for (l lVar2 : lVarArr) {
                if (lVar2.f1512e == 0) {
                    Uri uri = lVar2.a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, m.e.V0(context, cancellationSignal, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            Object m2 = m();
            if (m2 == null) {
                return null;
            }
            boolean z2 = false;
            for (l lVar3 : lVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(lVar3.a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.f1496j.invoke(m2, byteBuffer, Integer.valueOf(lVar3.b), null, Integer.valueOf(lVar3.c), Integer.valueOf(lVar3.f1511d ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        z = false;
                    }
                    if (!z) {
                        h(m2);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                h(m2);
                return null;
            } else if (k(m2) && (j2 = j(m2)) != null) {
                return Typeface.create(j2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Override // e.i.c.l
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        if (!l()) {
            return super.d(context, resources, i2, str, i3);
        }
        Object m2 = m();
        if (m2 == null) {
            return null;
        }
        if (!i(context, m2, str, 0, -1, -1, null)) {
            h(m2);
            return null;
        } else if (!k(m2)) {
            return null;
        } else {
            return j(m2);
        }
    }

    public final void h(Object obj) {
        try {
            this.f1498l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean i(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1495i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1493g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.f1497k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        return this.f1495i != null;
    }

    public Method n(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method o(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method p(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
