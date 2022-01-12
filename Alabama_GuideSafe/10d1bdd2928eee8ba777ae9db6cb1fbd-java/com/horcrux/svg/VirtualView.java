package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.common.util.concurrent.MoreExecutors;
import com.horcrux.svg.SVGLength;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public abstract class VirtualView extends ReactViewGroup {
    public static final int CLIP_RULE_EVENODD = 0;
    public static final int CLIP_RULE_NONZERO = 1;
    public static final double M_SQRT1_2l = 0.7071067811865476d;
    public static final float[] sRawMatrix = {1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f};
    public double canvasDiagonal = -1.0d;
    public float canvasHeight = -1.0f;
    public float canvasWidth = -1.0f;
    public ArrayList<PathElement> elements;
    public double fontSize = -1.0d;
    public GlyphContext glyphContext;
    public RectF mBox;
    public Matrix mCTM = new Matrix();
    public boolean mCTMInvertible = true;
    public Path mCachedClipPath;
    public RectF mClientRect;
    public RectF mClipBounds;
    public String mClipPath;
    public Region mClipRegion;
    public Path mClipRegionPath;
    public int mClipRule;
    public final ReactContext mContext;
    public String mDisplay;
    public RectF mFillBounds;
    public Path mFillPath;
    public Matrix mInvCTM = new Matrix();
    public Matrix mInvMatrix = new Matrix();
    public final Matrix mInvTransform = new Matrix();
    public boolean mInvertible = true;
    public RectF mMarkerBounds;
    public String mMarkerEnd;
    public String mMarkerMid;
    public Path mMarkerPath;
    public Region mMarkerRegion;
    public String mMarkerStart;
    public String mMask;
    public Matrix mMatrix = new Matrix();
    public String mName;
    public boolean mOnLayout;
    public float mOpacity = 1.0f;
    public Path mPath;
    public PointerEvents mPointerEvents;
    public Region mRegion;
    public boolean mResponsible;
    public final float mScale;
    public RectF mStrokeBounds;
    public Path mStrokePath;
    public Region mStrokeRegion;
    public GroupView mTextRoot;
    public Matrix mTransform = new Matrix();
    public boolean mTransformInvertible = true;
    public SvgView svgView;

    public VirtualView(ReactContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
        this.mScale = AppCompatDelegateImpl.ConfigurationImplApi17.sScreenDisplayMetrics.density;
    }

    private void clearParentCache() {
        VirtualView virtualView = this;
        while (true) {
            ViewParent parent = virtualView.getParent();
            if (parent instanceof VirtualView) {
                virtualView = (VirtualView) parent;
                if (virtualView.mPath != null) {
                    virtualView.clearCache();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private double fromRelativeFast(SVGLength sVGLength) {
        double d;
        switch (sVGLength.unit.ordinal()) {
            case 3:
                d = getFontSizeFromContext();
                break;
            case 4:
                d = getFontSizeFromContext() / 2.0d;
                break;
            case 5:
            default:
                d = 1.0d;
                break;
            case 6:
                d = 35.43307d;
                break;
            case 7:
                d = 3.543307d;
                break;
            case 8:
                d = 90.0d;
                break;
            case 9:
                d = 1.25d;
                break;
            case 10:
                d = 15.0d;
                break;
        }
        return sVGLength.value * d * ((double) this.mScale);
    }

    private double getCanvasDiagonal() {
        double d = this.canvasDiagonal;
        if (d != -1.0d) {
            return d;
        }
        double sqrt = Math.sqrt(Math.pow((double) getCanvasHeight(), 2.0d) + Math.pow((double) getCanvasWidth(), 2.0d)) * 0.7071067811865476d;
        this.canvasDiagonal = sqrt;
        return sqrt;
    }

    private float getCanvasHeight() {
        float f = this.canvasHeight;
        if (f != -1.0f) {
            return f;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasHeight = (float) getSvgView().getCanvasBounds().height();
        } else {
            this.canvasHeight = textRoot.mGlyphContext.mHeight;
        }
        return this.canvasHeight;
    }

    private float getCanvasWidth() {
        float f = this.canvasWidth;
        if (f != -1.0f) {
            return f;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasWidth = (float) getSvgView().getCanvasBounds().width();
        } else {
            this.canvasWidth = textRoot.mGlyphContext.mWidth;
        }
        return this.canvasWidth;
    }

    private double getFontSizeFromContext() {
        double d = this.fontSize;
        if (d != -1.0d) {
            return d;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            return 12.0d;
        }
        if (this.glyphContext == null) {
            this.glyphContext = textRoot.mGlyphContext;
        }
        double d2 = this.glyphContext.mFontSize;
        this.fontSize = d2;
        return d2;
    }

    public void clearCache() {
        this.canvasDiagonal = -1.0d;
        this.canvasHeight = -1.0f;
        this.canvasWidth = -1.0f;
        this.fontSize = -1.0d;
        this.mStrokeRegion = null;
        this.mMarkerRegion = null;
        this.mRegion = null;
        this.mPath = null;
    }

    public void clearChildCache() {
        clearCache();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).clearChildCache();
            }
        }
    }

    public void clip(Canvas canvas, Paint paint) {
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
    }

    public abstract void draw(Canvas canvas, Paint paint, float f);

    public RectF getClientRect() {
        return this.mClientRect;
    }

    public Path getClipPath() {
        return this.mCachedClipPath;
    }

    public GroupView getParentTextRoot() {
        ViewParent parent = getParent();
        if (!(parent instanceof VirtualView)) {
            return null;
        }
        return ((VirtualView) parent).getTextRoot();
    }

    public abstract Path getPath(Canvas canvas, Paint paint);

    public SvgView getSvgView() {
        SvgView svgView2 = this.svgView;
        if (svgView2 != null) {
            return svgView2;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        if (parent instanceof SvgView) {
            this.svgView = (SvgView) parent;
        } else if (parent instanceof VirtualView) {
            this.svgView = ((VirtualView) parent).getSvgView();
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("RNSVG: ");
            outline17.append(getClass().getName());
            outline17.append(" should be descendant of a SvgView.");
            FLog.e("ReactNative", outline17.toString());
        }
        return this.svgView;
    }

    public GroupView getTextRoot() {
        if (this.mTextRoot == null) {
            VirtualView virtualView = this;
            while (true) {
                if (virtualView == null) {
                    break;
                }
                if (virtualView instanceof GroupView) {
                    GroupView groupView = (GroupView) virtualView;
                    if (groupView.mGlyphContext != null) {
                        this.mTextRoot = groupView;
                        break;
                    }
                }
                ViewParent parent = virtualView.getParent();
                if (!(parent instanceof VirtualView)) {
                    virtualView = null;
                } else {
                    virtualView = (VirtualView) parent;
                }
            }
        }
        return this.mTextRoot;
    }

    public abstract int hitTest(float[] fArr);

    public void invalidate() {
        if (!(this instanceof RenderableView) || this.mPath != null) {
            clearCache();
            clearParentCache();
            super.invalidate();
        }
    }

    public boolean isResponsible() {
        return this.mResponsible;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        RectF rectF = this.mClientRect;
        if (rectF != null) {
            if (!(this instanceof GroupView)) {
                setLeft((int) Math.floor((double) rectF.left));
                setTop((int) Math.floor((double) this.mClientRect.top));
                setRight((int) Math.ceil((double) this.mClientRect.right));
                setBottom((int) Math.ceil((double) this.mClientRect.bottom));
            }
            setMeasuredDimension((int) Math.ceil((double) this.mClientRect.width()), (int) Math.ceil((double) this.mClientRect.height()));
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        RectF rectF = this.mClientRect;
        if (rectF != null) {
            i3 = (int) Math.ceil((double) rectF.width());
        } else {
            i3 = ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        RectF rectF2 = this.mClientRect;
        if (rectF2 != null) {
            i4 = (int) Math.ceil((double) rectF2.height());
        } else {
            i4 = ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(i3, i4);
    }

    public double relativeOnHeight(SVGLength sVGLength) {
        double d;
        float canvasHeight2;
        SVGLength.UnitType unitType = sVGLength.unit;
        if (unitType == SVGLength.UnitType.NUMBER) {
            d = sVGLength.value;
            canvasHeight2 = this.mScale;
        } else if (unitType != SVGLength.UnitType.PERCENTAGE) {
            return fromRelativeFast(sVGLength);
        } else {
            d = sVGLength.value / 100.0d;
            canvasHeight2 = getCanvasHeight();
        }
        return d * ((double) canvasHeight2);
    }

    public double relativeOnOther(SVGLength sVGLength) {
        double d;
        double canvasDiagonal2;
        SVGLength.UnitType unitType = sVGLength.unit;
        if (unitType == SVGLength.UnitType.NUMBER) {
            d = sVGLength.value;
            canvasDiagonal2 = (double) this.mScale;
        } else if (unitType != SVGLength.UnitType.PERCENTAGE) {
            return fromRelativeFast(sVGLength);
        } else {
            d = sVGLength.value / 100.0d;
            canvasDiagonal2 = getCanvasDiagonal();
        }
        return d * canvasDiagonal2;
    }

    public double relativeOnWidth(SVGLength sVGLength) {
        double d;
        float canvasWidth2;
        SVGLength.UnitType unitType = sVGLength.unit;
        if (unitType == SVGLength.UnitType.NUMBER) {
            d = sVGLength.value;
            canvasWidth2 = this.mScale;
        } else if (unitType != SVGLength.UnitType.PERCENTAGE) {
            return fromRelativeFast(sVGLength);
        } else {
            d = sVGLength.value / 100.0d;
            canvasWidth2 = getCanvasWidth();
        }
        return d * ((double) canvasWidth2);
    }

    public void render(Canvas canvas, Paint paint, float f) {
        draw(canvas, paint, f);
    }

    public void restoreCanvas(Canvas canvas, int i) {
        canvas.restoreToCount(i);
    }

    public int saveAndSetupCanvas(Canvas canvas, Matrix matrix) {
        int save = canvas.save();
        this.mCTM.setConcat(this.mMatrix, this.mTransform);
        canvas.concat(this.mCTM);
        this.mCTM.preConcat(matrix);
        this.mCTMInvertible = this.mCTM.invert(this.mInvCTM);
        return save;
    }

    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
    }

    public void setClientRect(RectF rectF) {
        RectF rectF2 = this.mClientRect;
        if (rectF2 == null || !rectF2.equals(rectF)) {
            this.mClientRect = rectF;
            if (rectF != null) {
                int ceil = (int) Math.ceil((double) rectF.width());
                int ceil2 = (int) Math.ceil((double) this.mClientRect.height());
                int floor = (int) Math.floor((double) this.mClientRect.left);
                int floor2 = (int) Math.floor((double) this.mClientRect.top);
                int ceil3 = (int) Math.ceil((double) this.mClientRect.right);
                int ceil4 = (int) Math.ceil((double) this.mClientRect.bottom);
                setMeasuredDimension(ceil, ceil2);
                if (!(this instanceof GroupView)) {
                    setLeft(floor);
                    setTop(floor2);
                    setRight(ceil3);
                    setBottom(ceil4);
                }
                if (this.mOnLayout) {
                    ((UIManagerModule) this.mContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(getId(), floor, floor2, ceil, ceil2));
                }
            }
        }
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(String str) {
        this.mCachedClipPath = null;
        this.mClipPath = str;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "clipRule")
    public void setClipRule(int i) {
        this.mClipRule = i;
        invalidate();
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        this.mDisplay = str;
        invalidate();
    }

    @ReactProp(name = "markerEnd")
    public void setMarkerEnd(String str) {
        this.mMarkerEnd = str;
        invalidate();
    }

    @ReactProp(name = "markerMid")
    public void setMarkerMid(String str) {
        this.mMarkerMid = str;
        invalidate();
    }

    @ReactProp(name = "markerStart")
    public void setMarkerStart(String str) {
        this.mMarkerStart = str;
        invalidate();
    }

    @ReactProp(name = "mask")
    public void setMask(String str) {
        this.mMask = str;
        invalidate();
    }

    @ReactProp(name = "matrix")
    public void setMatrix(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (dynamic.isNull() || !type.equals(ReadableType.Array)) {
            this.mMatrix.reset();
            this.mInvMatrix.reset();
            this.mInvertible = true;
        } else {
            int matrixData = MoreExecutors.toMatrixData(dynamic.asArray(), sRawMatrix, this.mScale);
            if (matrixData == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                    this.mInvMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
                this.mInvertible = this.mMatrix.invert(this.mInvMatrix);
            } else if (matrixData != -1) {
                FLog.w("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        }
        super.invalidate();
        clearParentCache();
    }

    @ReactProp(name = "name")
    public void setName(String str) {
        this.mName = str;
        invalidate();
    }

    @ReactProp(name = "onLayout")
    public void setOnLayout(boolean z) {
        this.mOnLayout = z;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f) {
        this.mOpacity = f;
        invalidate();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    @ReactProp(name = "responsible")
    public void setResponsible(boolean z) {
        this.mResponsible = z;
        invalidate();
    }

    public Path getClipPath(Canvas canvas, Paint paint) {
        Path path;
        if (this.mClipPath != null) {
            ClipPathView clipPathView = (ClipPathView) getSvgView().getDefinedClipPath(this.mClipPath);
            if (clipPathView != null) {
                if (clipPathView.mClipRule == 0) {
                    path = clipPathView.getPath(canvas, paint);
                } else {
                    path = clipPathView.getPath(canvas, paint, Region.Op.UNION);
                }
                path.transform(clipPathView.mMatrix);
                path.transform(clipPathView.mTransform);
                int i = clipPathView.mClipRule;
                if (i == 0) {
                    path.setFillType(Path.FillType.EVEN_ODD);
                } else if (i != 1) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("RNSVG: clipRule: ");
                    outline17.append(this.mClipRule);
                    outline17.append(" unrecognized");
                    FLog.w("ReactNative", outline17.toString());
                }
                this.mCachedClipPath = path;
            } else {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("RNSVG: Undefined clipPath: ");
                outline172.append(this.mClipPath);
                FLog.w("ReactNative", outline172.toString());
            }
        }
        return getClipPath();
    }
}
