package b.b.q;

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
import b.b.q.j;
import b.e.h;
import b.e.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class n0 {
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static n0 i;
    public static final c j = new c(6);

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap<Context, i<ColorStateList>> f894a;

    /* renamed from: b  reason: collision with root package name */
    public h<String, d> f895b;

    /* renamed from: c  reason: collision with root package name */
    public i<String> f896c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap<Context, b.e.e<WeakReference<Drawable.ConstantState>>> f897d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f898e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f899f;

    /* renamed from: g  reason: collision with root package name */
    public e f900g;

    public static class a implements d {
        @Override // b.b.q.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.b.m.a.a.h(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class b implements d {
        @Override // b.b.q.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                b.y.a.a.b bVar = new b.y.a.a.b(context, null, null);
                bVar.inflate(resources, xmlPullParser, attributeSet, theme);
                return bVar;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class c extends b.e.f<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }
    }

    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface e {
    }

    public static class f implements d {
        @Override // b.b.q.n0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.y.a.a.f.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static synchronized n0 d() {
        n0 n0Var;
        synchronized (n0.class) {
            if (i == null) {
                n0 n0Var2 = new n0();
                i = n0Var2;
                if (Build.VERSION.SDK_INT < 24) {
                    n0Var2.a("vector", new f());
                    n0Var2.a("animated-vector", new b());
                    n0Var2.a("animated-selector", new a());
                }
            }
            n0Var = i;
        }
        return n0Var;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (n0.class) {
            c cVar = j;
            if (cVar != null) {
                int i3 = (i2 + 31) * 31;
                porterDuffColorFilter = (PorterDuffColorFilter) cVar.a(Integer.valueOf(mode.hashCode() + i3));
                if (porterDuffColorFilter == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                    c cVar2 = j;
                    if (cVar2 != null) {
                        PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) cVar2.b(Integer.valueOf(mode.hashCode() + i3), porterDuffColorFilter);
                    } else {
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        return porterDuffColorFilter;
    }

    public static void l(Drawable drawable, w0 w0Var, int[] iArr) {
        if (!e0.a(drawable) || drawable.mutate() == drawable) {
            if (w0Var.f971d || w0Var.f970c) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = w0Var.f971d ? w0Var.f968a : null;
                PorterDuff.Mode mode = w0Var.f970c ? w0Var.f969b : h;
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = h(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final void a(String str, d dVar) {
        if (this.f895b == null) {
            this.f895b = new h<>();
        }
        this.f895b.put(str, dVar);
    }

    public final synchronized boolean b(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            b.e.e<WeakReference<Drawable.ConstantState>> eVar = this.f897d.get(context);
            if (eVar == null) {
                eVar = new b.e.e<>();
                this.f897d.put(context, eVar);
            }
            eVar.g(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Drawable c(Context context, int i2) {
        if (this.f898e == null) {
            this.f898e = new TypedValue();
        }
        TypedValue typedValue = this.f898e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable e2 = e(context, j2);
        if (e2 != null) {
            return e2;
        }
        e eVar = this.f900g;
        LayerDrawable layerDrawable = null;
        if (eVar != null) {
            j.a aVar = (j.a) eVar;
            if (i2 == b.b.e.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, b.b.e.abc_cab_background_internal_bg), f(context, b.b.e.abc_cab_background_top_mtrl_alpha)});
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
        b.e.e<WeakReference<Drawable.ConstantState>> eVar = this.f897d.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> f2 = eVar.f(j2, null);
        if (f2 != null) {
            Drawable.ConstantState constantState = f2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b2 = b.e.d.b(eVar.f1383c, eVar.f1385e, j2);
            if (b2 >= 0 && (objArr = eVar.f1384d)[b2] != (obj = b.e.e.f1381f)) {
                objArr[b2] = obj;
                eVar.f1382b = true;
            }
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
        Drawable j2;
        if (!this.f899f) {
            boolean z2 = true;
            this.f899f = true;
            Drawable f2 = f(context, b.b.n.a.abc_vector_test);
            if (f2 != null) {
                if (!(f2 instanceof b.y.a.a.f)) {
                    if (!"android.graphics.drawable.VectorDrawable".equals(f2.getClass().getName())) {
                        z2 = false;
                    }
                }
            }
            this.f899f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        j2 = j(context, i2);
        if (j2 == null) {
            j2 = c(context, i2);
        }
        if (j2 == null) {
            j2 = b.i.e.a.c(context, i2);
        }
        if (j2 != null) {
            j2 = k(context, i2, z, j2);
        }
        if (j2 != null) {
            e0.b(j2);
        }
        return j2;
    }

    public synchronized ColorStateList i(Context context, int i2) {
        ColorStateList colorStateList;
        i<ColorStateList> iVar;
        WeakHashMap<Context, i<ColorStateList>> weakHashMap = this.f894a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap == null || (iVar = weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = iVar.e(i2, null);
        }
        if (colorStateList == null) {
            if (this.f900g != null) {
                colorStateList2 = ((j.a) this.f900g).c(context, i2);
            }
            if (colorStateList2 != null) {
                if (this.f894a == null) {
                    this.f894a = new WeakHashMap<>();
                }
                i<ColorStateList> iVar2 = this.f894a.get(context);
                if (iVar2 == null) {
                    iVar2 = new i<>();
                    this.f894a.put(context, iVar2);
                }
                iVar2.a(i2, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[Catch:{ Exception -> 0x00a7 }] */
    public final Drawable j(Context context, int i2) {
        int next;
        h<String, d> hVar = this.f895b;
        if (hVar == null || hVar.isEmpty()) {
            return null;
        }
        i<String> iVar = this.f896c;
        if (iVar != null) {
            String e2 = iVar.e(i2, null);
            if ("appcompat_skip_skip".equals(e2) || (e2 != null && this.f895b.getOrDefault(e2, null) == null)) {
                return null;
            }
        } else {
            this.f896c = new i<>();
        }
        if (this.f898e == null) {
            this.f898e = new TypedValue();
        }
        TypedValue typedValue = this.f898e;
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
                            this.f896c.a(i2, name);
                            d dVar = this.f895b.get(name);
                            if (dVar != null) {
                                e3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
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
            } catch (Exception unused) {
            }
        }
        if (e3 == null) {
            this.f896c.a(i2, "appcompat_skip_skip");
        }
        return e3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    public final Drawable k(Context context, int i2, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i3;
        ColorStateList i4 = i(context, i2);
        PorterDuff.Mode mode = null;
        if (i4 != null) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setTintList(i4);
            e eVar = this.f900g;
            if (eVar != null) {
                j.a aVar = (j.a) eVar;
                if (i2 == b.b.e.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return drawable;
            }
            drawable.setTintMode(mode);
            return drawable;
        }
        e eVar2 = this.f900g;
        if (eVar2 != null) {
            j.a aVar2 = (j.a) eVar2;
            if (aVar2 != null) {
                boolean z2 = true;
                if (i2 == b.b.e.abc_seekbar_track_material) {
                    layerDrawable = (LayerDrawable) drawable;
                    aVar2.d(layerDrawable.findDrawableByLayerId(16908288), t0.c(context, b.b.a.colorControlNormal), j.f867b);
                    findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                    i3 = b.b.a.colorControlNormal;
                } else if (i2 == b.b.e.abc_ratingbar_material || i2 == b.b.e.abc_ratingbar_indicator_material || i2 == b.b.e.abc_ratingbar_small_material) {
                    layerDrawable = (LayerDrawable) drawable;
                    aVar2.d(layerDrawable.findDrawableByLayerId(16908288), t0.b(context, b.b.a.colorControlNormal), j.f867b);
                    findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                    i3 = b.b.a.colorControlActivated;
                } else {
                    z2 = false;
                    if (z2) {
                        return drawable;
                    }
                }
                aVar2.d(findDrawableByLayerId, t0.c(context, i3), j.f867b);
                aVar2.d(layerDrawable.findDrawableByLayerId(16908301), t0.c(context, b.b.a.colorControlActivated), j.f867b);
                if (z2) {
                }
            } else {
                throw null;
            }
        }
        if (m(context, i2, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public boolean m(Context context, int i2, Drawable drawable) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        e eVar = this.f900g;
        if (eVar != null) {
            j.a aVar = (j.a) eVar;
            if (aVar != null) {
                PorterDuff.Mode mode = j.f867b;
                int i5 = 16842801;
                if (aVar.a(aVar.f870a, i2)) {
                    i5 = b.b.a.colorControlNormal;
                } else if (aVar.a(aVar.f872c, i2)) {
                    i5 = b.b.a.colorControlActivated;
                } else if (aVar.a(aVar.f873d, i2)) {
                    mode = PorterDuff.Mode.MULTIPLY;
                } else if (i2 == b.b.e.abc_list_divider_mtrl_alpha) {
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
                } else if (i2 != b.b.e.abc_dialog_material_background) {
                    i3 = 0;
                    z = false;
                    i4 = -1;
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
            } else {
                throw null;
            }
        }
        return false;
    }
}
