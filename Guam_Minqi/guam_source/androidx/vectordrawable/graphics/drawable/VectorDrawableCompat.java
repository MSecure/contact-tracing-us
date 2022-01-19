package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.graphics.PathParser$PathDataNode;
import com.facebook.react.uimanager.BaseViewManager;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public boolean mAllowCaching;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public final Rect mTmpBounds;
    public final float[] mTmpFloats;
    public final Matrix mTmpMatrix;
    public VectorDrawableCompatState mVectorState;

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    public static abstract class VObject {
        public VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }

        public VObject(AnonymousClass1 r1) {
        }
    }

    public static class VectorDrawableCompatState extends Drawable.ConstantState {
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public ColorStateList mCachedTint;
        public PorterDuff.Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public ColorStateList mTint;
        public PorterDuff.Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                this.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public boolean isStateful() {
            VPathRenderer vPathRenderer = this.mVPathRenderer;
            if (vPathRenderer.mIsStateful == null) {
                vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
            }
            return vPathRenderer.mIsStateful.booleanValue();
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mCachedBitmap);
            VPathRenderer vPathRenderer = this.mVPathRenderer;
            vPathRenderer.drawGroupTree(vPathRenderer.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas, i, i2, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    public static int applyAlpha(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    public static VectorDrawableCompat create(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = resources.getDrawable(i, theme);
            new VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next != 2) {
                        return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next != 2) {
            }
        } catch (XmlPullParserException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.mCachedBitmap.getHeight()) == false) goto L_0x00d1;
     */
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            boolean z = false;
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (!(abs3 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && abs4 == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.mTmpBounds.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.mTmpBounds.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.mTmpBounds;
                canvas.translate((float) rect.left, (float) rect.top);
                if (isAutoMirrored() && getLayoutDirection() == 1) {
                    canvas.translate((float) this.mTmpBounds.width(), BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.mTmpBounds.offsetTo(0, 0);
                VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
                Bitmap bitmap = vectorDrawableCompatState.mCachedBitmap;
                if (bitmap != null) {
                }
                vectorDrawableCompatState.mCachedBitmap = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                vectorDrawableCompatState.mCacheDirty = true;
                if (!this.mAllowCaching) {
                    this.mVectorState.updateCachedBitmap(min, min2);
                } else {
                    VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
                    if (!(!vectorDrawableCompatState2.mCacheDirty && vectorDrawableCompatState2.mCachedTint == vectorDrawableCompatState2.mTint && vectorDrawableCompatState2.mCachedTintMode == vectorDrawableCompatState2.mTintMode && vectorDrawableCompatState2.mCachedAutoMirrored == vectorDrawableCompatState2.mAutoMirrored && vectorDrawableCompatState2.mCachedRootAlpha == vectorDrawableCompatState2.mVPathRenderer.getRootAlpha())) {
                        this.mVectorState.updateCachedBitmap(min, min2);
                        VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                        vectorDrawableCompatState3.mCachedTint = vectorDrawableCompatState3.mTint;
                        vectorDrawableCompatState3.mCachedTintMode = vectorDrawableCompatState3.mTintMode;
                        vectorDrawableCompatState3.mCachedRootAlpha = vectorDrawableCompatState3.mVPathRenderer.getRootAlpha();
                        vectorDrawableCompatState3.mCachedAutoMirrored = vectorDrawableCompatState3.mAutoMirrored;
                        vectorDrawableCompatState3.mCacheDirty = false;
                    }
                }
                VectorDrawableCompatState vectorDrawableCompatState4 = this.mVectorState;
                Rect rect2 = this.mTmpBounds;
                if (vectorDrawableCompatState4.mVPathRenderer.getRootAlpha() < 255) {
                    z = true;
                }
                if (z || colorFilter != null) {
                    if (vectorDrawableCompatState4.mTempPaint == null) {
                        Paint paint2 = new Paint();
                        vectorDrawableCompatState4.mTempPaint = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    vectorDrawableCompatState4.mTempPaint.setAlpha(vectorDrawableCompatState4.mVPathRenderer.getRootAlpha());
                    vectorDrawableCompatState4.mTempPaint.setColorFilter(colorFilter);
                    paint = vectorDrawableCompatState4.mTempPaint;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(vectorDrawableCompatState4.mCachedBitmap, (Rect) null, rect2, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.mColorFilter;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mVectorState.mAutoMirrored;
    }

    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((vectorDrawableCompatState = this.mVectorState) != null && (vectorDrawableCompatState.isStateful() || ((colorStateList = this.mVectorState.mTint) != null && colorStateList.isStateful())));
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (!(colorStateList == null || (mode = vectorDrawableCompatState.mTintMode) == null)) {
            this.mTintFilter = updateTintFilter(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (vectorDrawableCompatState.isStateful()) {
            boolean onStateChanged = vectorDrawableCompatState.mVPathRenderer.mRootGroup.onStateChanged(iArr);
            vectorDrawableCompatState.mCacheDirty |= onStateChanged;
            if (onStateChanged) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public static class VectorDrawableDelegateState extends Drawable.ConstantState {
        public final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public static abstract class VPath extends VObject {
        public int mChangingConfigurations;
        public int mFillRule = 0;
        public PathParser$PathDataNode[] mNodes = null;
        public String mPathName;

        public VPath() {
            super(null);
        }

        public PathParser$PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
            if (!AppCompatDelegateImpl.ConfigurationImplApi17.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
                this.mNodes = AppCompatDelegateImpl.ConfigurationImplApi17.deepCopyNodes(pathParser$PathDataNodeArr);
                return;
            }
            PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = this.mNodes;
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                pathParser$PathDataNodeArr2[i].mType = pathParser$PathDataNodeArr[i].mType;
                for (int i2 = 0; i2 < pathParser$PathDataNodeArr[i].mParams.length; i2++) {
                    pathParser$PathDataNodeArr2[i].mParams[i2] = pathParser$PathDataNodeArr[i].mParams[i2];
                }
            }
        }

        public VPath(VPath vPath) {
            super(null);
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = AppCompatDelegateImpl.ConfigurationImplApi17.deepCopyNodes(vPath.mNodes);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ColorStateList colorStateList;
        char c;
        int i;
        int i2;
        boolean z;
        VPathRenderer vPathRenderer;
        VPathRenderer vPathRenderer2;
        ArrayDeque arrayDeque;
        VGroup vGroup;
        VFullPath vFullPath;
        TypedArray typedArray;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes1 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
        VPathRenderer vPathRenderer3 = vectorDrawableCompatState2.mVPathRenderer;
        int namedInt = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes1, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i3 = 3;
        if (namedInt == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (namedInt != 5) {
            if (namedInt != 9) {
                switch (namedInt) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        vectorDrawableCompatState2.mTintMode = mode;
        boolean z2 = false;
        int i4 = 1;
        if (AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            obtainAttributes1.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + 1 + ": " + typedValue);
            } else if (i5 < 28 || i5 > 31) {
                Resources resources2 = obtainAttributes1.getResources();
                try {
                    colorStateList = AppCompatDelegateImpl.ConfigurationImplApi17.createFromXml(resources2, resources2.getXml(obtainAttributes1.getResourceId(1, 0)), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
                if (colorStateList != null) {
                    vectorDrawableCompatState2.mTint = colorStateList;
                }
                boolean z3 = vectorDrawableCompatState2.mAutoMirrored;
                if (AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "autoMirrored")) {
                    z3 = obtainAttributes1.getBoolean(5, z3);
                }
                vectorDrawableCompatState2.mAutoMirrored = z3;
                vPathRenderer3.mViewportWidth = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportWidth", 7, vPathRenderer3.mViewportWidth);
                float namedFloat = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportHeight", 8, vPathRenderer3.mViewportHeight);
                vPathRenderer3.mViewportHeight = namedFloat;
                if (vPathRenderer3.mViewportWidth <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    throw new XmlPullParserException(obtainAttributes1.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
                } else if (namedFloat > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    vPathRenderer3.mBaseWidth = obtainAttributes1.getDimension(3, vPathRenderer3.mBaseWidth);
                    float dimension = obtainAttributes1.getDimension(2, vPathRenderer3.mBaseHeight);
                    vPathRenderer3.mBaseHeight = dimension;
                    if (vPathRenderer3.mBaseWidth <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        throw new XmlPullParserException(obtainAttributes1.getPositionDescription() + "<vector> tag requires width > 0");
                    } else if (dimension > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        vPathRenderer3.setAlpha(AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "alpha", 4, vPathRenderer3.getAlpha()));
                        String string = obtainAttributes1.getString(0);
                        if (string != null) {
                            vPathRenderer3.mRootName = string;
                            vPathRenderer3.mVGTargetsMap.put(string, vPathRenderer3);
                        }
                        obtainAttributes1.recycle();
                        vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
                        vectorDrawableCompatState.mCacheDirty = true;
                        VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                        VPathRenderer vPathRenderer4 = vectorDrawableCompatState3.mVPathRenderer;
                        ArrayDeque arrayDeque2 = new ArrayDeque();
                        arrayDeque2.push(vPathRenderer4.mRootGroup);
                        int eventType = xmlPullParser.getEventType();
                        int depth = xmlPullParser.getDepth() + 1;
                        boolean z4 = true;
                        while (eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != i3)) {
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                VGroup vGroup2 = (VGroup) arrayDeque2.peek();
                                if ("path".equals(name)) {
                                    VFullPath vFullPath2 = new VFullPath();
                                    TypedArray obtainAttributes12 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                                    vFullPath2.mThemeAttrs = null;
                                    if (!AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "pathData")) {
                                        arrayDeque = arrayDeque2;
                                        vPathRenderer2 = vPathRenderer4;
                                        typedArray = obtainAttributes12;
                                        vFullPath = vFullPath2;
                                        i = depth;
                                        c = '\b';
                                        vGroup = vGroup2;
                                    } else {
                                        String string2 = obtainAttributes12.getString(0);
                                        if (string2 != null) {
                                            vFullPath2.mPathName = string2;
                                        }
                                        String string3 = obtainAttributes12.getString(2);
                                        if (string3 != null) {
                                            vFullPath2.mNodes = AppCompatDelegateImpl.ConfigurationImplApi17.createNodesFromPathData(string3);
                                        }
                                        arrayDeque = arrayDeque2;
                                        vPathRenderer2 = vPathRenderer4;
                                        i = depth;
                                        vGroup = vGroup2;
                                        vFullPath = vFullPath2;
                                        vFullPath.mFillColor = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedComplexColor(obtainAttributes12, xmlPullParser, theme, "fillColor", 1, 0);
                                        vFullPath.mFillAlpha = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes12, xmlPullParser, "fillAlpha", 12, vFullPath.mFillAlpha);
                                        int namedInt2 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes12, xmlPullParser, "strokeLineCap", 8, -1);
                                        Paint.Cap cap = vFullPath.mStrokeLineCap;
                                        if (namedInt2 == 0) {
                                            cap = Paint.Cap.BUTT;
                                        } else if (namedInt2 == 1) {
                                            cap = Paint.Cap.ROUND;
                                        } else if (namedInt2 == 2) {
                                            cap = Paint.Cap.SQUARE;
                                        }
                                        vFullPath.mStrokeLineCap = cap;
                                        int namedInt3 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes12, xmlPullParser, "strokeLineJoin", 9, -1);
                                        Paint.Join join = vFullPath.mStrokeLineJoin;
                                        if (namedInt3 == 0) {
                                            join = Paint.Join.MITER;
                                        } else if (namedInt3 == 1) {
                                            join = Paint.Join.ROUND;
                                        } else if (namedInt3 == 2) {
                                            join = Paint.Join.BEVEL;
                                        }
                                        vFullPath.mStrokeLineJoin = join;
                                        vFullPath.mStrokeMiterlimit = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes12, xmlPullParser, "strokeMiterLimit", 10, vFullPath.mStrokeMiterlimit);
                                        c = '\b';
                                        typedArray = obtainAttributes12;
                                        vFullPath.mStrokeColor = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedComplexColor(obtainAttributes12, xmlPullParser, theme, "strokeColor", 3, 0);
                                        vFullPath.mStrokeAlpha = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, vFullPath.mStrokeAlpha);
                                        vFullPath.mStrokeWidth = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, vFullPath.mStrokeWidth);
                                        vFullPath.mTrimPathEnd = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, vFullPath.mTrimPathEnd);
                                        vFullPath.mTrimPathOffset = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, vFullPath.mTrimPathOffset);
                                        vFullPath.mTrimPathStart = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, vFullPath.mTrimPathStart);
                                        vFullPath.mFillRule = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(typedArray, xmlPullParser, "fillType", 13, vFullPath.mFillRule);
                                    }
                                    typedArray.recycle();
                                    vGroup.mChildren.add(vFullPath);
                                    if (vFullPath.getPathName() != null) {
                                        vPathRenderer = vPathRenderer2;
                                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                                    } else {
                                        vPathRenderer = vPathRenderer2;
                                    }
                                    vectorDrawableCompatState3.mChangingConfigurations |= vFullPath.mChangingConfigurations;
                                    arrayDeque2 = arrayDeque;
                                    z = false;
                                    i2 = 3;
                                    z4 = false;
                                } else {
                                    vPathRenderer = vPathRenderer4;
                                    i = depth;
                                    c = '\b';
                                    if ("clip-path".equals(name)) {
                                        VClipPath vClipPath = new VClipPath();
                                        if (AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "pathData")) {
                                            TypedArray obtainAttributes13 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                                            String string4 = obtainAttributes13.getString(0);
                                            if (string4 != null) {
                                                vClipPath.mPathName = string4;
                                            }
                                            String string5 = obtainAttributes13.getString(1);
                                            if (string5 != null) {
                                                vClipPath.mNodes = AppCompatDelegateImpl.ConfigurationImplApi17.createNodesFromPathData(string5);
                                            }
                                            vClipPath.mFillRule = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes13, xmlPullParser, "fillType", 2, 0);
                                            obtainAttributes13.recycle();
                                        }
                                        vGroup2.mChildren.add(vClipPath);
                                        if (vClipPath.getPathName() != null) {
                                            vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                                        }
                                        vectorDrawableCompatState3.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState3.mChangingConfigurations;
                                    } else if ("group".equals(name)) {
                                        VGroup vGroup3 = new VGroup();
                                        TypedArray obtainAttributes14 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                                        vGroup3.mThemeAttrs = null;
                                        vGroup3.mRotate = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes14, xmlPullParser, "rotation", 5, vGroup3.mRotate);
                                        vGroup3.mPivotX = obtainAttributes14.getFloat(1, vGroup3.mPivotX);
                                        vGroup3.mPivotY = obtainAttributes14.getFloat(2, vGroup3.mPivotY);
                                        vGroup3.mScaleX = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes14, xmlPullParser, "scaleX", 3, vGroup3.mScaleX);
                                        vGroup3.mScaleY = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes14, xmlPullParser, "scaleY", 4, vGroup3.mScaleY);
                                        vGroup3.mTranslateX = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes14, xmlPullParser, "translateX", 6, vGroup3.mTranslateX);
                                        vGroup3.mTranslateY = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes14, xmlPullParser, "translateY", 7, vGroup3.mTranslateY);
                                        z = false;
                                        String string6 = obtainAttributes14.getString(0);
                                        if (string6 != null) {
                                            vGroup3.mGroupName = string6;
                                        }
                                        vGroup3.updateLocalMatrix();
                                        obtainAttributes14.recycle();
                                        vGroup2.mChildren.add(vGroup3);
                                        arrayDeque2 = arrayDeque2;
                                        arrayDeque2.push(vGroup3);
                                        if (vGroup3.getGroupName() != null) {
                                            vPathRenderer.mVGTargetsMap.put(vGroup3.getGroupName(), vGroup3);
                                        }
                                        vectorDrawableCompatState3.mChangingConfigurations = vGroup3.mChangingConfigurations | vectorDrawableCompatState3.mChangingConfigurations;
                                        i2 = 3;
                                    }
                                    arrayDeque2 = arrayDeque2;
                                    z = false;
                                    i2 = 3;
                                }
                            } else {
                                vPathRenderer = vPathRenderer4;
                                z = z2;
                                i = depth;
                                i2 = 3;
                                c = '\b';
                                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                                    arrayDeque2.pop();
                                }
                            }
                            eventType = xmlPullParser.next();
                            z2 = z;
                            i3 = i2;
                            depth = i;
                            i4 = 1;
                            vPathRenderer4 = vPathRenderer;
                        }
                        if (!z4) {
                            this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
                            return;
                        }
                        throw new XmlPullParserException("no path defined");
                    } else {
                        throw new XmlPullParserException(obtainAttributes1.getPositionDescription() + "<vector> tag requires height > 0");
                    }
                } else {
                    throw new XmlPullParserException(obtainAttributes1.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
                if (colorStateList != null) {
                }
                boolean z32 = vectorDrawableCompatState2.mAutoMirrored;
                if (AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "autoMirrored")) {
                }
                vectorDrawableCompatState2.mAutoMirrored = z32;
                vPathRenderer3.mViewportWidth = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportWidth", 7, vPathRenderer3.mViewportWidth);
                float namedFloat2 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportHeight", 8, vPathRenderer3.mViewportHeight);
                vPathRenderer3.mViewportHeight = namedFloat2;
                if (vPathRenderer3.mViewportWidth <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                }
            }
        }
        colorStateList = null;
        if (colorStateList != null) {
        }
        boolean z322 = vectorDrawableCompatState2.mAutoMirrored;
        if (AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xmlPullParser, "autoMirrored")) {
        }
        vectorDrawableCompatState2.mAutoMirrored = z322;
        vPathRenderer3.mViewportWidth = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportWidth", 7, vPathRenderer3.mViewportWidth);
        float namedFloat22 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xmlPullParser, "viewportHeight", 8, vPathRenderer3.mViewportHeight);
        vPathRenderer3.mViewportHeight = namedFloat22;
        if (vPathRenderer3.mViewportWidth <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
        }
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public static class VFullPath extends VPath {
        public float mFillAlpha = 1.0f;
        public ComplexColorCompat mFillColor;
        public float mStrokeAlpha = 1.0f;
        public ComplexColorCompat mStrokeColor;
        public Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
        public Paint.Join mStrokeLineJoin = Paint.Join.MITER;
        public float mStrokeMiterlimit = 4.0f;
        public float mStrokeWidth = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public int[] mThemeAttrs;
        public float mTrimPathEnd = 1.0f;
        public float mTrimPathOffset = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public float mTrimPathStart = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;

        public VFullPath() {
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public int getFillColor() {
            return this.mFillColor.mColor;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public int getStrokeColor() {
            return this.mStrokeColor.mColor;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            return this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr);
        }

        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        public void setFillColor(int i) {
            this.mFillColor.mColor = i;
        }

        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor.mColor = i;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }
    }

    public static class VPathRenderer {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public float mBaseHeight;
        public float mBaseWidth;
        public int mChangingConfigurations;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public Boolean mIsStateful;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap<String, Object> mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mBaseHeight = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mViewportWidth = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mViewportHeight = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: android.graphics.PathMeasure */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            VPathRenderer vPathRenderer;
            VPathRenderer vPathRenderer2 = this;
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            ?? r11 = 0;
            int i3 = 0;
            while (i3 < vGroup.mChildren.size()) {
                VObject vObject = vGroup.mChildren.get(i3);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (vObject instanceof VPath) {
                    VPath vPath = (VPath) vObject;
                    float f = ((float) i) / vPathRenderer2.mViewportWidth;
                    float f2 = ((float) i2) / vPathRenderer2.mViewportHeight;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = vGroup.mStackedMatrix;
                    vPathRenderer2.mFinalPathMatrix.set(matrix2);
                    vPathRenderer2.mFinalPathMatrix.postScale(f, f2);
                    float[] fArr = {BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f, 1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER};
                    matrix2.mapVectors(fArr);
                    char c = r11 == true ? 1 : 0;
                    char c2 = r11 == true ? 1 : 0;
                    char c3 = r11 == true ? 1 : 0;
                    float f3 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[c], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? Math.abs(f3) / max : 0.0f;
                    if (abs == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        vPathRenderer = this;
                    } else {
                        vPathRenderer = this;
                        Path path = vPathRenderer.mPath;
                        if (vPath != null) {
                            path.reset();
                            PathParser$PathDataNode[] pathParser$PathDataNodeArr = vPath.mNodes;
                            if (pathParser$PathDataNodeArr != null) {
                                PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArr, path);
                            }
                            Path path2 = vPathRenderer.mPath;
                            vPathRenderer.mRenderPath.reset();
                            if (vPath.isClipPath()) {
                                vPathRenderer.mRenderPath.setFillType(vPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                vPathRenderer.mRenderPath.addPath(path2, vPathRenderer.mFinalPathMatrix);
                                canvas.clipPath(vPathRenderer.mRenderPath);
                            } else {
                                VFullPath vFullPath = (VFullPath) vPath;
                                if (!(vFullPath.mTrimPathStart == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && vFullPath.mTrimPathEnd == 1.0f)) {
                                    float f4 = vFullPath.mTrimPathStart;
                                    float f5 = vFullPath.mTrimPathOffset;
                                    float f6 = (f4 + f5) % 1.0f;
                                    float f7 = (vFullPath.mTrimPathEnd + f5) % 1.0f;
                                    if (vPathRenderer.mPathMeasure == null) {
                                        vPathRenderer.mPathMeasure = new PathMeasure();
                                    }
                                    vPathRenderer.mPathMeasure.setPath(vPathRenderer.mPath, r11);
                                    float length = vPathRenderer.mPathMeasure.getLength();
                                    float f8 = f6 * length;
                                    float f9 = f7 * length;
                                    path2.reset();
                                    if (f8 > f9) {
                                        vPathRenderer.mPathMeasure.getSegment(f8, length, path2, true);
                                        vPathRenderer.mPathMeasure.getSegment(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, f9, path2, true);
                                    } else {
                                        vPathRenderer.mPathMeasure.getSegment(f8, f9, path2, true);
                                    }
                                    path2.rLineTo(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                }
                                vPathRenderer.mRenderPath.addPath(path2, vPathRenderer.mFinalPathMatrix);
                                ComplexColorCompat complexColorCompat = vFullPath.mFillColor;
                                if (complexColorCompat.isGradient() || complexColorCompat.mColor != 0) {
                                    ComplexColorCompat complexColorCompat2 = vFullPath.mFillColor;
                                    if (vPathRenderer.mFillPaint == null) {
                                        Paint paint = new Paint(1);
                                        vPathRenderer.mFillPaint = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    }
                                    Paint paint2 = vPathRenderer.mFillPaint;
                                    if (complexColorCompat2.isGradient()) {
                                        Shader shader = complexColorCompat2.mShader;
                                        shader.setLocalMatrix(vPathRenderer.mFinalPathMatrix);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        paint2.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat2.mColor, vFullPath.mFillAlpha));
                                    }
                                    paint2.setColorFilter(colorFilter);
                                    vPathRenderer.mRenderPath.setFillType(vFullPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(vPathRenderer.mRenderPath, paint2);
                                }
                                ComplexColorCompat complexColorCompat3 = vFullPath.mStrokeColor;
                                if (complexColorCompat3.isGradient() || complexColorCompat3.mColor != 0) {
                                    ComplexColorCompat complexColorCompat4 = vFullPath.mStrokeColor;
                                    if (vPathRenderer.mStrokePaint == null) {
                                        Paint paint3 = new Paint(1);
                                        vPathRenderer.mStrokePaint = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = vPathRenderer.mStrokePaint;
                                    Paint.Join join = vFullPath.mStrokeLineJoin;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = vFullPath.mStrokeLineCap;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                                    if (complexColorCompat4.isGradient()) {
                                        Shader shader2 = complexColorCompat4.mShader;
                                        shader2.setLocalMatrix(vPathRenderer.mFinalPathMatrix);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        paint4.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat4.mColor, vFullPath.mStrokeAlpha));
                                    }
                                    paint4.setColorFilter(colorFilter);
                                    paint4.setStrokeWidth(vFullPath.mStrokeWidth * abs * min);
                                    canvas.drawPath(vPathRenderer.mRenderPath, paint4);
                                }
                            }
                        } else {
                            throw null;
                        }
                    }
                    i3++;
                    vPathRenderer2 = vPathRenderer;
                    r11 = 0;
                }
                vPathRenderer = vPathRenderer2;
                i3++;
                vPathRenderer2 = vPathRenderer;
                r11 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mBaseHeight = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mViewportWidth = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mViewportHeight = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                this.mVGTargetsMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }
    }

    public static class VGroup extends VObject {
        public int mChangingConfigurations;
        public final ArrayList<VObject> mChildren = new ArrayList<>();
        public String mGroupName = null;
        public final Matrix mLocalMatrix = new Matrix();
        public float mPivotX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public float mPivotY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public float mRotate = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public float mScaleX = 1.0f;
        public float mScaleY = 1.0f;
        public final Matrix mStackedMatrix = new Matrix();
        public int[] mThemeAttrs;
        public float mTranslateX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public float mTranslateY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super(null);
            VPath vPath;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<VObject> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                VObject vObject = arrayList.get(i);
                if (vObject instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vPath);
                    String str2 = vPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            for (int i = 0; i < this.mChildren.size(); i++) {
                if (this.mChildren.get(i).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.mChildren.size(); i++) {
                z |= this.mChildren.get(i).onStateChanged(iArr);
            }
            return z;
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }

        public final void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public VGroup() {
            super(null);
        }
    }
}
