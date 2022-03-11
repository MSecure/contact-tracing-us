package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import e.b.a.m;
import e.b.f.k;
import e.f.h;
import e.f.i;
import e.j.b.a;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: i */
    public static r0 f1018i;
    public WeakHashMap<Context, i<ColorStateList>> a;
    public h<String, e> b;
    public i<String> c;

    /* renamed from: d */
    public final WeakHashMap<Context, e.f.e<WeakReference<Drawable.ConstantState>>> f1020d = new WeakHashMap<>(0);

    /* renamed from: e */
    public TypedValue f1021e;

    /* renamed from: f */
    public boolean f1022f;

    /* renamed from: g */
    public f f1023g;

    /* renamed from: h */
    public static final PorterDuff.Mode f1017h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j */
    public static final c f1019j = new c(6);

    /* loaded from: classes.dex */
    public static class a implements e {
        @Override // e.b.f.r0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.b.b.a.a.g(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e {
        @Override // e.b.f.r0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                e.a0.a.a.c cVar = new e.a0.a.a.c(context, null, null);
                cVar.inflate(resources, xmlPullParser, attributeSet, theme);
                return cVar;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e.f.f<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements e {
        @Override // e.b.f.r0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute == null) {
                return null;
            }
            try {
                Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                e.b.c.b.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                return drawable;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public static class g implements e {
        @Override // e.b.f.r0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.a0.a.a.g.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static synchronized r0 d() {
        r0 r0Var;
        synchronized (r0.class) {
            if (f1018i == null) {
                r0 r0Var2 = new r0();
                f1018i = r0Var2;
                j(r0Var2);
            }
            r0Var = f1018i;
        }
        return r0Var;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (r0.class) {
            c cVar = f1019j;
            Objects.requireNonNull(cVar);
            int i3 = (i2 + 31) * 31;
            a2 = cVar.a(Integer.valueOf(mode.hashCode() + i3));
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                Objects.requireNonNull(cVar);
                cVar.b(Integer.valueOf(mode.hashCode() + i3), a2);
            }
        }
        return a2;
    }

    public static void j(r0 r0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            r0Var.a("vector", new g());
            r0Var.a("animated-vector", new b());
            r0Var.a("animated-selector", new a());
            r0Var.a("drawable", new d());
        }
    }

    public final void a(String str, e eVar) {
        if (this.b == null) {
            this.b = new h<>();
        }
        this.b.put(str, eVar);
    }

    public final synchronized boolean b(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            e.f.e<WeakReference<Drawable.ConstantState>> eVar = this.f1020d.get(context);
            if (eVar == null) {
                eVar = new e.f.e<>();
                this.f1020d.put(context, eVar);
            }
            eVar.g(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Drawable c(Context context, int i2) {
        int i3;
        if (this.f1021e == null) {
            this.f1021e = new TypedValue();
        }
        TypedValue typedValue = this.f1021e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable e2 = e(context, j2);
        if (e2 != null) {
            return e2;
        }
        f fVar = this.f1023g;
        LayerDrawable layerDrawable = null;
        if (fVar != null) {
            k.a aVar = (k.a) fVar;
            if (i2 == R$drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, R$drawable.abc_cab_background_internal_bg), f(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            } else {
                if (i2 == R$drawable.abc_ratingbar_material) {
                    i3 = R$dimen.abc_star_big;
                } else if (i2 == R$drawable.abc_ratingbar_indicator_material) {
                    i3 = R$dimen.abc_star_medium;
                } else if (i2 == R$drawable.abc_ratingbar_small_material) {
                    i3 = R$dimen.abc_star_small;
                }
                layerDrawable = aVar.c(this, context, i3);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j2) {
        Object[] objArr;
        Object obj;
        e.f.e<WeakReference<Drawable.ConstantState>> eVar = this.f1020d.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> f2 = eVar.f(j2, null);
        if (f2 != null) {
            Drawable.ConstantState constantState = f2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b2 = e.f.d.b(eVar.c, eVar.f1302e, j2);
            if (b2 >= 0 && (objArr = eVar.f1301d)[b2] != (obj = e.f.e.f1300f)) {
                objArr[b2] = obj;
                eVar.b = true;
            }
        }
        return null;
    }

    public synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    public synchronized Drawable g(Context context, int i2, boolean z) {
        Drawable k2;
        if (!this.f1022f) {
            boolean z2 = true;
            this.f1022f = true;
            Drawable f2 = f(context, androidx.appcompat.resources.R$drawable.abc_vector_test);
            if (f2 != null) {
                if (!(f2 instanceof e.a0.a.a.g) && !"android.graphics.drawable.VectorDrawable".equals(f2.getClass().getName())) {
                    z2 = false;
                }
            }
            this.f1022f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        k2 = k(context, i2);
        if (k2 == null) {
            k2 = c(context, i2);
        }
        if (k2 == null) {
            Object obj = e.j.b.a.a;
            k2 = a.b.b(context, i2);
        }
        if (k2 != null) {
            k2 = l(context, i2, z, k2);
        }
        if (k2 != null) {
            i0.b(k2);
        }
        return k2;
    }

    public synchronized ColorStateList i(Context context, int i2) {
        ColorStateList colorStateList;
        i<ColorStateList> iVar;
        WeakHashMap<Context, i<ColorStateList>> weakHashMap = this.a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap == null || (iVar = weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = iVar.e(i2, null);
        }
        if (colorStateList == null) {
            f fVar = this.f1023g;
            if (fVar != null) {
                colorStateList2 = ((k.a) fVar).d(context, i2);
            }
            if (colorStateList2 != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap<>();
                }
                i<ColorStateList> iVar2 = this.a.get(context);
                if (iVar2 == null) {
                    iVar2 = new i<>();
                    this.a.put(context, iVar2);
                }
                iVar2.a(i2, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    public final Drawable k(Context context, int i2) {
        int next;
        h<String, e> hVar = this.b;
        if (hVar == null || hVar.isEmpty()) {
            return null;
        }
        i<String> iVar = this.c;
        if (iVar != null) {
            String e2 = iVar.e(i2, null);
            if ("appcompat_skip_skip".equals(e2) || (e2 != null && this.b.getOrDefault(e2, null) == null)) {
                return null;
            }
        } else {
            this.c = new i<>();
        }
        if (this.f1021e == null) {
            this.f1021e = new TypedValue();
        }
        TypedValue typedValue = this.f1021e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable e3 = e(context, j2);
        if (e3 != null) {
            return e3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.c.a(i2, name);
                    e eVar = this.b.get(name);
                    if (eVar != null) {
                        e3 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (e3 != null) {
                        e3.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, j2, e3);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception unused) {
            }
        }
        if (e3 == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return e3;
    }

    public final Drawable l(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList i3 = i(context, i2);
        PorterDuff.Mode mode = null;
        if (i3 != null) {
            if (i0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable X1 = m.e.X1(drawable);
            X1.setTintList(i3);
            f fVar = this.f1023g;
            if (fVar != null) {
                k.a aVar = (k.a) fVar;
                if (i2 == R$drawable.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return X1;
            }
            X1.setTintMode(mode);
            return X1;
        }
        f fVar2 = this.f1023g;
        if (fVar2 != null) {
            k.a aVar2 = (k.a) fVar2;
            Objects.requireNonNull(aVar2);
            boolean z2 = true;
            if (i2 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i4 = R$attr.colorControlNormal;
                int c2 = x0.c(context, i4);
                PorterDuff.Mode mode2 = k.b;
                aVar2.e(findDrawableByLayerId, c2, mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908303), x0.c(context, i4), mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908301), x0.c(context, R$attr.colorControlActivated), mode2);
            } else if (i2 == R$drawable.abc_ratingbar_material || i2 == R$drawable.abc_ratingbar_indicator_material || i2 == R$drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int b2 = x0.b(context, R$attr.colorControlNormal);
                PorterDuff.Mode mode3 = k.b;
                aVar2.e(findDrawableByLayerId2, b2, mode3);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i5 = R$attr.colorControlActivated;
                aVar2.e(findDrawableByLayerId3, x0.c(context, i5), mode3);
                aVar2.e(layerDrawable2.findDrawableByLayerId(16908301), x0.c(context, i5), mode3);
            } else {
                z2 = false;
            }
            if (z2) {
                return drawable;
            }
        }
        if (m(context, i2, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean m(Context context, int i2, Drawable drawable) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        f fVar = this.f1023g;
        if (fVar != null) {
            k.a aVar = (k.a) fVar;
            Objects.requireNonNull(aVar);
            PorterDuff.Mode mode = k.b;
            int i5 = 16842801;
            if (aVar.a(aVar.a, i2)) {
                i5 = R$attr.colorControlNormal;
            } else if (aVar.a(aVar.c, i2)) {
                i5 = R$attr.colorControlActivated;
            } else if (aVar.a(aVar.f981d, i2)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else if (i2 == R$drawable.abc_list_divider_mtrl_alpha) {
                i3 = 16842800;
                i4 = Math.round(40.8f);
                z = true;
                if (z) {
                    if (i0.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(k.c(x0.c(context, i3), mode));
                    if (i4 != -1) {
                        drawable.setAlpha(i4);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            } else if (i2 != R$drawable.abc_dialog_material_background) {
                i3 = 0;
                i4 = -1;
                z = false;
                if (z) {
                }
                if (z2) {
                }
            }
            i3 = i5;
            i4 = -1;
            z = true;
            if (z) {
            }
            if (z2) {
            }
        }
        return false;
    }
}
