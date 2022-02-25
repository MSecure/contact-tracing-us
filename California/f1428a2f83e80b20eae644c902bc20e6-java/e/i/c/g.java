package e.i.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import e.b.a.m;
import e.e.f;
import e.i.b.b.c;
import e.i.b.b.d;
import e.i.f.e;
import f.a.a.a.a;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class g extends e {

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f1429g;

    /* renamed from: h  reason: collision with root package name */
    public final Constructor<?> f1430h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f1431i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f1432j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f1433k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f1434l;
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
            method3 = n(cls2);
            method2 = o(cls2);
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            method5 = p(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            StringBuilder h2 = a.h("Unable to collect necessary methods for class ");
            h2.append(e2.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", h2.toString(), e2);
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f1429g = cls;
        this.f1430h = constructor;
        this.f1431i = method3;
        this.f1432j = method2;
        this.f1433k = method;
        this.f1434l = method4;
        this.m = method5;
    }

    private Object m() {
        try {
            return this.f1430h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // e.i.c.k, e.i.c.e
    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        if (!l()) {
            return super.a(context, cVar, resources, i2);
        }
        Object m2 = m();
        if (m2 == null) {
            return null;
        }
        d[] dVarArr = cVar.a;
        for (d dVar : dVarArr) {
            if (!i(context, m2, dVar.a, dVar.f1420e, dVar.b, dVar.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.f1419d))) {
                h(m2);
                return null;
            }
        }
        if (!k(m2)) {
            return null;
        }
        return j(m2);
    }

    @Override // e.i.c.k, e.i.c.e
    public Typeface b(Context context, CancellationSignal cancellationSignal, e.c[] cVarArr, int i2) {
        Typeface j2;
        boolean z;
        if (cVarArr.length < 1) {
            return null;
        }
        if (!l()) {
            e.c cVar = (e.c) k.e(cVarArr, i2, new j(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(cVar.a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(cVar.c).setItalic(cVar.f1447d).build();
                    openFileDescriptor.close();
                    return build;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            f<String, Typeface> fVar = e.a;
            HashMap hashMap = new HashMap();
            for (e.c cVar2 : cVarArr) {
                if (cVar2.f1448e == 0) {
                    Uri uri = cVar2.a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, m.h.D0(context, cancellationSignal, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            Object m2 = m();
            if (m2 == null) {
                return null;
            }
            boolean z2 = false;
            for (e.c cVar3 : cVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(cVar3.a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.f1432j.invoke(m2, byteBuffer, Integer.valueOf(cVar3.b), null, Integer.valueOf(cVar3.c), Integer.valueOf(cVar3.f1447d ? 1 : 0))).booleanValue();
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

    @Override // e.i.c.k
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
            this.f1434l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean i(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1431i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1429g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.f1433k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        if (this.f1431i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1431i != null;
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
