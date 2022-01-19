package androidx.appcompat.widget;

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
import androidx.appcompat.R$drawable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourceManagerInternal {
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static ResourceManagerInternal INSTANCE;
    public SimpleArrayMap<String, InflateDelegate> mDelegates;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public ResourceManagerHooks mHooks;
    public SparseArrayCompat<String> mKnownDrawableIdTags;
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    public TypedValue mTypedValue;

    public static class AsldcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context, null, null);
                animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
                return animatedVectorDrawableCompat;
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }
    }

    public interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface ResourceManagerHooks {
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (INSTANCE == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                INSTANCE = resourceManagerInternal2;
                if (Build.VERSION.SDK_INT < 24) {
                    resourceManagerInternal2.addDelegate("vector", new VdcInflateDelegate());
                    resourceManagerInternal2.addDelegate("animated-vector", new AvdcInflateDelegate());
                    resourceManagerInternal2.addDelegate("animated-selector", new AsldcInflateDelegate());
                }
            }
            resourceManagerInternal = INSTANCE;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            if (colorFilterLruCache != null) {
                int i2 = (i + 31) * 31;
                porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + i2));
                if (porterDuffColorFilter == null) {
                    porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                    ColorFilterLruCache colorFilterLruCache2 = COLOR_FILTER_CACHE;
                    if (colorFilterLruCache2 != null) {
                        PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) colorFilterLruCache2.put(Integer.valueOf(mode.hashCode() + i2), porterDuffColorFilter);
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

    public final void addDelegate(String str, InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    public final synchronized boolean addDrawableToCache(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.mDrawableCaches.put(context, longSparseArray);
        }
        longSparseArray.put(j, new WeakReference<>(constantState));
        return true;
    }

    public final Drawable createDrawableIfNeeded(Context context, int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        LayerDrawable layerDrawable = null;
        if (resourceManagerHooks != null) {
            AppCompatDrawableManager.AnonymousClass1 r1 = (AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks;
            if (i == R$drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R$drawable.abc_cab_background_internal_bg), getDrawable(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable getCachedDrawable(Context context, long j) {
        Object[] objArr;
        Object obj;
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int binarySearch = ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, j);
            if (binarySearch >= 0 && (objArr = longSparseArray.mValues)[binarySearch] != (obj = LongSparseArray.DELETED)) {
                objArr[binarySearch] = obj;
                longSparseArray.mGarbage = true;
            }
        }
        return null;
    }

    public synchronized Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, false);
    }

    public synchronized ColorStateList getTintList(Context context, int i) {
        ColorStateList colorStateList;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
        ColorStateList colorStateList2 = null;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = sparseArrayCompat.get(i, null);
        }
        if (colorStateList == null) {
            if (this.mHooks != null) {
                colorStateList2 = ((AppCompatDrawableManager.AnonymousClass1) this.mHooks).getTintListForDrawableRes(context, i);
            }
            if (colorStateList2 != null) {
                if (this.mTintLists == null) {
                    this.mTintLists = new WeakHashMap<>();
                }
                SparseArrayCompat<ColorStateList> sparseArrayCompat2 = this.mTintLists.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat<>(10);
                    this.mTintLists.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.append(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1 A[Catch:{ Exception -> 0x00a9 }] */
    public final Drawable loadDrawableFromDelegates(Context context, int i) {
        int next;
        SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(i, null);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.mDelegates.getOrDefault(str, null) == null)) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat<>(10);
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        if (next != 2) {
                            String name = xml.getName();
                            this.mKnownDrawableIdTags.append(i, name);
                            InflateDelegate inflateDelegate = this.mDelegates.get(name);
                            if (inflateDelegate != null) {
                                cachedDrawable = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                            }
                            if (cachedDrawable != null) {
                                cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                                addDrawableToCache(context, j, cachedDrawable);
                            }
                        } else {
                            throw new XmlPullParserException("No start tag found");
                        }
                    }
                }
                if (next != 2) {
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i, "appcompat_skip_skip");
        }
        return cachedDrawable;
    }

    public final Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList tintList = getTintList(context, i);
        PorterDuff.Mode mode = null;
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setTintList(tintList);
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks != null) {
                AppCompatDrawableManager.AnonymousClass1 r10 = (AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks;
                if (i == R$drawable.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return drawable;
            }
            drawable.setTintMode(mode);
            return drawable;
        }
        ResourceManagerHooks resourceManagerHooks2 = this.mHooks;
        if (resourceManagerHooks2 != null) {
            AppCompatDrawableManager.AnonymousClass1 r0 = (AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks2;
            if (r0 != null) {
                boolean z2 = true;
                if (i == R$drawable.abc_seekbar_track_material) {
                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                } else if (i == R$drawable.abc_ratingbar_material || i == R$drawable.abc_ratingbar_indicator_material || i == R$drawable.abc_ratingbar_small_material) {
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                    r0.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                } else {
                    z2 = false;
                }
                if (z2) {
                    return drawable;
                }
            } else {
                throw null;
            }
        }
        if (tintDrawableUsingColorFilter(context, i, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks != null) {
            AppCompatDrawableManager.AnonymousClass1 r0 = (AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks;
            if (r0 != null) {
                PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                int i4 = 16842801;
                if (r0.arrayContains(r0.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                    i4 = R$attr.colorControlNormal;
                } else if (r0.arrayContains(r0.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                    i4 = R$attr.colorControlActivated;
                } else if (r0.arrayContains(r0.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                    mode = PorterDuff.Mode.MULTIPLY;
                } else if (i == R$drawable.abc_list_divider_mtrl_alpha) {
                    i2 = 16842800;
                    i3 = Math.round(40.8f);
                    z = true;
                    if (z) {
                        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                            drawable = drawable.mutate();
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
                        if (i3 != -1) {
                            drawable.setAlpha(i3);
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                } else if (i != R$drawable.abc_dialog_material_background) {
                    i2 = 0;
                    z = false;
                    i3 = -1;
                    if (z) {
                    }
                    if (z2) {
                    }
                }
                i2 = i4;
                i3 = -1;
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    public synchronized Drawable getDrawable(Context context, int i, boolean z) {
        Drawable loadDrawableFromDelegates;
        if (!this.mHasCheckedVectorDrawableSetup) {
            boolean z2 = true;
            this.mHasCheckedVectorDrawableSetup = true;
            Drawable drawable = getDrawable(context, androidx.appcompat.resources.R$drawable.abc_vector_test);
            if (drawable != null) {
                if (!(drawable instanceof VectorDrawableCompat)) {
                    if (!"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                        z2 = false;
                    }
                }
            }
            this.mHasCheckedVectorDrawableSetup = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
        }
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = ContextCompat.getDrawable(context, i);
        }
        if (loadDrawableFromDelegates != null) {
            loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
        }
        if (loadDrawableFromDelegates != null) {
            DrawableUtils.fixDrawable(loadDrawableFromDelegates);
        }
        return loadDrawableFromDelegates;
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = tintInfo.mHasTintList ? tintInfo.mTintList : null;
                PorterDuff.Mode mode = tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE;
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
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
}
