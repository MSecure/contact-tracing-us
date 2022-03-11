package e.j.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import e.b.a.m;
import e.j.b.b.d;
import e.j.b.b.e;
import e.j.g.l;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends f {

    /* renamed from: g */
    public final Class<?> f1577g;

    /* renamed from: h */
    public final Constructor<?> f1578h;

    /* renamed from: i */
    public final Method f1579i;

    /* renamed from: j */
    public final Method f1580j;

    /* renamed from: k */
    public final Method f1581k;

    /* renamed from: l */
    public final Method f1582l;
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
        this.f1577g = cls;
        this.f1578h = constructor;
        this.f1579i = method3;
        this.f1580j = method2;
        this.f1581k = method;
        this.f1582l = method4;
        this.m = method5;
    }

    private Object m() {
        try {
            return this.f1578h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // e.j.c.f, e.j.c.l
    public Typeface a(Context context, d dVar, Resources resources, int i2) {
        if (!l()) {
            return super.a(context, dVar, resources, i2);
        }
        Object m = m();
        if (m == null) {
            return null;
        }
        e[] eVarArr = dVar.a;
        for (e eVar : eVarArr) {
            if (!i(context, m, eVar.a, eVar.f1567e, eVar.b, eVar.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(eVar.f1566d))) {
                h(m);
                return null;
            }
        }
        if (!k(m)) {
            return null;
        }
        return j(m);
    }

    @Override // e.j.c.f, e.j.c.l
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
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(lVar.c).setItalic(lVar.f1596d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        } else {
            HashMap hashMap = new HashMap();
            for (l lVar2 : lVarArr) {
                if (lVar2.f1597e == 0) {
                    Uri uri = lVar2.a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, m.e.b1(context, cancellationSignal, uri));
                    }
                }
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            Object m = m();
            if (m == null) {
                return null;
            }
            boolean z2 = false;
            for (l lVar3 : lVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(lVar3.a);
                if (byteBuffer != null) {
                    try {
                        z = ((Boolean) this.f1580j.invoke(m, byteBuffer, Integer.valueOf(lVar3.b), null, Integer.valueOf(lVar3.c), Integer.valueOf(lVar3.f1596d ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                        z = false;
                    }
                    if (!z) {
                        h(m);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                h(m);
                return null;
            } else if (k(m) && (j2 = j(m)) != null) {
                return Typeface.create(j2, i2);
            } else {
                return null;
            }
        }
    }

    @Override // e.j.c.l
    public Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        if (!l()) {
            return super.d(context, resources, i2, str, i3);
        }
        Object m = m();
        if (m == null) {
            return null;
        }
        if (!i(context, m, str, 0, -1, -1, null)) {
            h(m);
            return null;
        } else if (!k(m)) {
            return null;
        } else {
            return j(m);
        }
    }

    public final void h(Object obj) {
        try {
            this.f1582l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean i(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1579i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1577g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean k(Object obj) {
        try {
            return ((Boolean) this.f1581k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean l() {
        return this.f1579i != null;
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
