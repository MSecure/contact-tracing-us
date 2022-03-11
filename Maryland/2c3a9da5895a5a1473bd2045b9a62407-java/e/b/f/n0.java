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
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import e.b.a.m;
import e.b.f.j;
import e.e.h;
import e.e.i;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class n0 {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f921h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public static n0 f922i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f923j = new c(6);
    public WeakHashMap<Context, i<ColorStateList>> a;
    public h<String, e> b;
    public i<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap<Context, e.e.e<WeakReference<Drawable.ConstantState>>> f924d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f925e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f926f;

    /* renamed from: g  reason: collision with root package name */
    public f f927g;

    public static class a implements e {
        @Override // e.b.f.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.b.c.a.a.g(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    public static class b implements e {
        @Override // e.b.f.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                e.x.a.a.c cVar = new e.x.a.a.c(context, null, null);
                cVar.inflate(resources, xmlPullParser, attributeSet, theme);
                return cVar;
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    public static class c extends e.e.f<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }
    }

    public static class d implements e {
        @Override // e.b.f.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute == null) {
                return null;
            }
            try {
                Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                return drawable;
            } catch (Exception e2) {
                Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                return null;
            }
        }
    }

    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
    }

    public static class g implements e {
        @Override // e.b.f.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.x.a.a.g.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    public static synchronized n0 d() {
        n0 n0Var;
        synchronized (n0.class) {
            if (f922i == null) {
                n0 n0Var2 = new n0();
                f922i = n0Var2;
                j(n0Var2);
            }
            n0Var = f922i;
        }
        return n0Var;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (n0.class) {
            c cVar = f923j;
            Objects.requireNonNull(cVar);
            int i3 = (i2 + 31) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) cVar.a(Integer.valueOf(mode.hashCode() + i3));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                Objects.requireNonNull(cVar);
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) cVar.b(Integer.valueOf(mode.hashCode() + i3), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public static void j(n0 n0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            n0Var.a("vector", new g());
            n0Var.a("animated-vector", new b());
            n0Var.a("animated-selector", new a());
            n0Var.a("drawable", new d());
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
            e.e.e<WeakReference<Drawable.ConstantState>> eVar = this.f924d.get(context);
            if (eVar == null) {
                eVar = new e.e.e<>();
                this.f924d.put(context, eVar);
            }
            eVar.j(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Drawable c(Context context, int i2) {
        int i3;
        if (this.f925e == null) {
            this.f925e = new TypedValue();
        }
        TypedValue typedValue = this.f925e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable e2 = e(context, j2);
        if (e2 != null) {
            return e2;
        }
        f fVar = this.f927g;
        LayerDrawable layerDrawable = null;
        if (fVar != null) {
            j.a aVar = (j.a) fVar;
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
        e.e.e<WeakReference<Drawable.ConstantState>> eVar = this.f924d.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> g2 = eVar.g(j2, null);
        if (g2 != null) {
            Drawable.ConstantState constantState = g2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            eVar.k(j2);
        }
        return null;
    }

    public synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    public synchronized Drawable g(Context context, int i2, boolean z) {
        Drawable k2;
        if (!this.f926f) {
            boolean z2 = true;
            this.f926f = true;
            Drawable f2 = f(context, androidx.appcompat.resources.R$drawable.abc_vector_test);
            if (f2 != null) {
                if (!(f2 instanceof e.x.a.a.g)) {
                    if (!"android.graphics.drawable.VectorDrawable".equals(f2.getClass().getName())) {
                        z2 = false;
                    }
                }
            }
            this.f926f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        k2 = k(context, i2);
        if (k2 == null) {
            k2 = c(context, i2);
        }
        if (k2 == null) {
            Object obj = e.i.b.a.a;
            k2 = context.getDrawable(i2);
        }
        if (k2 != null) {
            k2 = l(context, i2, z, k2);
        }
        if (k2 != null) {
            e0.b(k2);
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
            f fVar = this.f927g;
            if (fVar != null) {
                colorStateList2 = ((j.a) fVar).d(context, i2);
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

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[Catch:{ Exception -> 0x00a7 }] */
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
        if (this.f925e == null) {
            this.f925e = new TypedValue();
        }
        TypedValue typedValue = this.f925e;
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
                        if (next != 2) {
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
                    }
                }
                if (next != 2) {
                }
            } catch (Exception e4) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e4);
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
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable w1 = m.h.w1(drawable);
            w1.setTintList(i3);
            f fVar = this.f927g;
            if (fVar != null) {
                j.a aVar = (j.a) fVar;
                if (i2 == R$drawable.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return w1;
            }
            w1.setTintMode(mode);
            return w1;
        }
        f fVar2 = this.f927g;
        if (fVar2 != null) {
            j.a aVar2 = (j.a) fVar2;
            Objects.requireNonNull(aVar2);
            boolean z2 = true;
            if (i2 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i4 = R$attr.colorControlNormal;
                int c2 = t0.c(context, i4);
                PorterDuff.Mode mode2 = j.b;
                aVar2.e(findDrawableByLayerId, c2, mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908303), t0.c(context, i4), mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908301), t0.c(context, R$attr.colorControlActivated), mode2);
            } else if (i2 == R$drawable.abc_ratingbar_material || i2 == R$drawable.abc_ratingbar_indicator_material || i2 == R$drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int b2 = t0.b(context, R$attr.colorControlNormal);
                PorterDuff.Mode mode3 = j.b;
                aVar2.e(findDrawableByLayerId2, b2, mode3);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i5 = R$attr.colorControlActivated;
                aVar2.e(findDrawableByLayerId3, t0.c(context, i5), mode3);
                aVar2.e(layerDrawable2.findDrawableByLayerId(16908301), t0.c(context, i5), mode3);
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

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public boolean m(Context context, int i2, Drawable drawable) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        f fVar = this.f927g;
        if (fVar != null) {
            j.a aVar = (j.a) fVar;
            Objects.requireNonNull(aVar);
            PorterDuff.Mode mode = j.b;
            int i5 = 16842801;
            if (aVar.a(aVar.a, i2)) {
                i5 = R$attr.colorControlNormal;
            } else if (aVar.a(aVar.c, i2)) {
                i5 = R$attr.colorControlActivated;
            } else if (aVar.a(aVar.f908d, i2)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else if (i2 == R$drawable.abc_list_divider_mtrl_alpha) {
                i3 = 16842800;
                i4 = Math.round(40.8f);
                z = true;
                if (z) {
                    if (e0.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(j.c(t0.c(context, i3), mode));
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
                    return false;
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
