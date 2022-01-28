package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RenderableView extends VirtualView {
    public static final int CAP_BUTT = 0;
    public static final int CAP_ROUND = 1;
    public static final int CAP_SQUARE = 2;
    public static final int FILL_RULE_EVENODD = 0;
    public static final int FILL_RULE_NONZERO = 1;
    public static final int JOIN_BEVEL = 2;
    public static final int JOIN_MITER = 0;
    public static final int JOIN_ROUND = 1;
    public static final int VECTOR_EFFECT_DEFAULT = 0;
    public static final int VECTOR_EFFECT_NON_SCALING_STROKE = 1;
    public static RenderableView contextElement;
    public static final Pattern regex = Pattern.compile("[0-9.-]+");
    public ReadableArray fill;
    public float fillOpacity = 1.0f;
    public Path.FillType fillRule = Path.FillType.WINDING;
    public ArrayList<String> mAttributeList;
    public ArrayList<String> mLastMergedList;
    public ArrayList<Object> mOriginProperties;
    public ArrayList<String> mPropList;
    public ReadableArray stroke;
    public SVGLength[] strokeDasharray;
    public float strokeDashoffset = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public Paint.Cap strokeLinecap = Paint.Cap.BUTT;
    public Paint.Join strokeLinejoin = Paint.Join.MITER;
    public float strokeMiterlimit = 4.0f;
    public float strokeOpacity = 1.0f;
    public SVGLength strokeWidth = new SVGLength(1.0d);
    public int vectorEffect = 0;

    public RenderableView(ReactContext reactContext) {
        super(reactContext);
        setPivotX(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        setPivotY(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    private ArrayList<String> getAttributeList() {
        return this.mAttributeList;
    }

    private boolean hasOwnProperty(String str) {
        ArrayList<String> arrayList = this.mAttributeList;
        return arrayList != null && arrayList.contains(str);
    }

    public static double saturate(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        return d;
    }

    private void setupPaint(Paint paint, float f, ReadableArray readableArray) {
        float f2;
        float f3;
        float[] fArr;
        char c;
        int[] iArr;
        ReadableArray readableArray2;
        RenderableView renderableView;
        ReadableArray readableArray3;
        int i = readableArray.getInt(0);
        if (i != 0) {
            if (i == 1) {
                Brush definedBrush = getSvgView().getDefinedBrush(readableArray.getString(1));
                if (definedBrush != null) {
                    RectF rectF = this.mBox;
                    float f4 = this.mScale;
                    if (!definedBrush.mUseObjectBoundingBox) {
                        rectF = new RectF(definedBrush.mUserSpaceBoundingBox);
                    }
                    float width = rectF.width();
                    float height = rectF.height();
                    if (definedBrush.mUseObjectBoundingBox) {
                        f2 = rectF.left;
                        f3 = rectF.top;
                    } else {
                        f3 = 0.0f;
                        f2 = 0.0f;
                    }
                    RectF rectF2 = new RectF(f2, f3, width + f2, height + f3);
                    float width2 = rectF2.width();
                    float height2 = rectF2.height();
                    float f5 = rectF2.left;
                    float f6 = rectF2.top;
                    float textSize = paint.getTextSize();
                    if (definedBrush.mType == Brush.BrushType.PATTERN) {
                        double d = (double) width2;
                        double val = definedBrush.getVal(definedBrush.mPoints[0], d, f4, textSize);
                        double d2 = (double) height2;
                        double val2 = definedBrush.getVal(definedBrush.mPoints[1], d2, f4, textSize);
                        double val3 = definedBrush.getVal(definedBrush.mPoints[2], d, f4, textSize);
                        double val4 = definedBrush.getVal(definedBrush.mPoints[3], d2, f4, textSize);
                        if (val3 > 1.0d && val4 > 1.0d) {
                            Bitmap createBitmap = Bitmap.createBitmap((int) val3, (int) val4, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            PatternView patternView = definedBrush.mPattern;
                            if (patternView != null) {
                                float f7 = patternView.mMinX;
                                float f8 = patternView.mScale;
                                float f9 = patternView.mMinY;
                                RectF rectF3 = new RectF(f7 * f8, f9 * f8, (f7 + patternView.mVbWidth) * f8, (f9 + patternView.mVbHeight) * f8);
                                if (rectF3.width() > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && rectF3.height() > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                    RectF rectF4 = new RectF((float) val, (float) val2, (float) val3, (float) val4);
                                    PatternView patternView2 = definedBrush.mPattern;
                                    canvas.concat(PathParser.getTransform(rectF3, rectF4, patternView2.mAlign, patternView2.mMeetOrSlice));
                                }
                                if (definedBrush.mUseContentObjectBoundingBoxUnits) {
                                    canvas.scale(width2 / f4, height2 / f4);
                                }
                                definedBrush.mPattern.draw(canvas, new Paint(), f);
                                Matrix matrix = new Matrix();
                                Matrix matrix2 = definedBrush.mMatrix;
                                if (matrix2 != null) {
                                    matrix.preConcat(matrix2);
                                }
                                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
                                bitmapShader.setLocalMatrix(matrix);
                                paint.setShader(bitmapShader);
                                return;
                            }
                            throw null;
                        }
                        return;
                    }
                    int size = definedBrush.mColors.size();
                    String str = "ReactNative";
                    if (size == 0) {
                        FLog.w(str, "Gradient contains no stops");
                        return;
                    }
                    int i2 = size / 2;
                    int[] iArr2 = new int[i2];
                    float[] fArr2 = new float[i2];
                    ReadableArray readableArray4 = definedBrush.mColors;
                    int i3 = 0;
                    while (i3 < i2) {
                        int i4 = i3 * 2;
                        fArr2[i3] = (float) readableArray4.getDouble(i4);
                        int i5 = readableArray4.getInt(i4 + 1);
                        iArr2[i3] = (i5 & 16777215) | (Math.round(((float) (i5 >>> 24)) * f) << 24);
                        i3++;
                        str = str;
                    }
                    if (i2 == 1) {
                        c = 0;
                        iArr = new int[]{iArr2[0], iArr2[0]};
                        fArr = new float[]{fArr2[0], fArr2[0]};
                        FLog.w(str, "Gradient contains only one stop");
                    } else {
                        c = 0;
                        iArr = iArr2;
                        fArr = fArr2;
                    }
                    Brush.BrushType brushType = definedBrush.mType;
                    if (brushType == Brush.BrushType.LINEAR_GRADIENT) {
                        double d3 = (double) width2;
                        double d4 = (double) f5;
                        double val5 = definedBrush.getVal(definedBrush.mPoints[c], d3, f4, textSize) + d4;
                        double d5 = (double) height2;
                        double d6 = (double) f6;
                        Shader linearGradient = new LinearGradient((float) val5, (float) (definedBrush.getVal(definedBrush.mPoints[1], d5, f4, textSize) + d6), (float) (d4 + definedBrush.getVal(definedBrush.mPoints[2], d3, f4, textSize)), (float) (definedBrush.getVal(definedBrush.mPoints[3], d5, f4, textSize) + d6), iArr, fArr, Shader.TileMode.CLAMP);
                        if (definedBrush.mMatrix != null) {
                            Matrix matrix3 = new Matrix();
                            matrix3.preConcat(definedBrush.mMatrix);
                            linearGradient.setLocalMatrix(matrix3);
                        }
                        paint.setShader(linearGradient);
                    } else if (brushType == Brush.BrushType.RADIAL_GRADIENT) {
                        double d7 = (double) width2;
                        double val6 = definedBrush.getVal(definedBrush.mPoints[2], d7, f4, textSize);
                        double d8 = (double) height2;
                        double val7 = definedBrush.getVal(definedBrush.mPoints[3], d8, f4, textSize) / val6;
                        Shader radialGradient = new RadialGradient((float) (definedBrush.getVal(definedBrush.mPoints[4], d7, f4, textSize) + ((double) f5)), (float) ((((double) f6) / val7) + definedBrush.getVal(definedBrush.mPoints[5], d8 / val7, f4, textSize)), (float) val6, iArr, fArr, Shader.TileMode.CLAMP);
                        Matrix matrix4 = new Matrix();
                        matrix4.preScale(1.0f, (float) val7);
                        Matrix matrix5 = definedBrush.mMatrix;
                        if (matrix5 != null) {
                            matrix4.preConcat(matrix5);
                        }
                        radialGradient.setLocalMatrix(matrix4);
                        paint.setShader(radialGradient);
                    }
                }
            } else if (i == 2) {
                paint.setColor(getSvgView().mTintColor);
            } else if (i == 3) {
                RenderableView renderableView2 = contextElement;
                if (renderableView2 != null && (readableArray2 = renderableView2.fill) != null) {
                    setupPaint(paint, f, readableArray2);
                }
            } else if (i == 4 && (renderableView = contextElement) != null && (readableArray3 = renderableView.stroke) != null) {
                setupPaint(paint, f, readableArray3);
            }
        } else if (readableArray.size() == 2) {
            int i6 = readableArray.getInt(1);
            paint.setColor((i6 & 16777215) | (Math.round(((float) (i6 >>> 24)) * f) << 24));
        } else {
            paint.setARGB((int) (readableArray.size() > 4 ? readableArray.getDouble(4) * ((double) f) * 255.0d : (double) (255.0f * f)), (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
        }
    }

    @Override // com.horcrux.svg.VirtualView
    public void draw(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.mOpacity;
        boolean z = false;
        boolean z2 = ((VirtualView) this).mPath == null;
        if (z2) {
            Path path = getPath(canvas, paint);
            ((VirtualView) this).mPath = path;
            path.setFillType(this.fillRule);
        }
        if (this.vectorEffect == 1) {
            z = true;
        }
        Path path2 = ((VirtualView) this).mPath;
        if (z) {
            path2 = new Path();
            ((VirtualView) this).mPath.transform(this.mCTM, path2);
            canvas.setMatrix(null);
        }
        if (z2 || path2 != ((VirtualView) this).mPath) {
            RectF rectF = new RectF();
            this.mBox = rectF;
            path2.computeBounds(rectF, true);
        }
        RectF rectF2 = new RectF(this.mBox);
        this.mCTM.mapRect(rectF2);
        setClientRect(rectF2);
        clip(canvas, paint);
        if (setupFillPaint(paint, this.fillOpacity * f2)) {
            if (z2) {
                Path path3 = new Path();
                this.mFillPath = path3;
                paint.getFillPath(path2, path3);
            }
            canvas.drawPath(path2, paint);
        }
        if (setupStrokePaint(paint, this.strokeOpacity * f2)) {
            if (z2) {
                Path path4 = new Path();
                this.mStrokePath = path4;
                paint.getFillPath(path2, path4);
            }
            canvas.drawPath(path2, paint);
        }
        renderMarkers(canvas, paint, f2);
    }

    @Override // com.horcrux.svg.VirtualView
    public abstract Path getPath(Canvas canvas, Paint paint);

    public Region getRegion(Path path, RectF rectF) {
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom)));
        return region;
    }

    @Override // com.horcrux.svg.VirtualView
    public int hitTest(float[] fArr) {
        Region region;
        Region region2;
        if (((VirtualView) this).mPath == null || !this.mInvertible || !this.mTransformInvertible || ((VirtualView) this).mPointerEvents == PointerEvents.NONE) {
            return -1;
        }
        float[] fArr2 = new float[2];
        this.mInvMatrix.mapPoints(fArr2, fArr);
        this.mInvTransform.mapPoints(fArr2);
        int round = Math.round(fArr2[0]);
        int round2 = Math.round(fArr2[1]);
        initBounds();
        Region region3 = this.mRegion;
        if ((region3 != null && region3.contains(round, round2)) || ((region = this.mStrokeRegion) != null && (region.contains(round, round2) || ((region2 = this.mMarkerRegion) != null && region2.contains(round, round2))))) {
            if (getClipPath() == null || this.mClipRegion.contains(round, round2)) {
                return getId();
            }
            return -1;
        }
        return -1;
    }

    public void initBounds() {
        if (this.mRegion == null && this.mFillPath != null) {
            RectF rectF = new RectF();
            this.mFillBounds = rectF;
            this.mFillPath.computeBounds(rectF, true);
            this.mRegion = getRegion(this.mFillPath, this.mFillBounds);
        }
        if (this.mRegion == null && ((VirtualView) this).mPath != null) {
            RectF rectF2 = new RectF();
            this.mFillBounds = rectF2;
            ((VirtualView) this).mPath.computeBounds(rectF2, true);
            this.mRegion = getRegion(((VirtualView) this).mPath, this.mFillBounds);
        }
        if (this.mStrokeRegion == null && this.mStrokePath != null) {
            RectF rectF3 = new RectF();
            this.mStrokeBounds = rectF3;
            this.mStrokePath.computeBounds(rectF3, true);
            this.mStrokeRegion = getRegion(this.mStrokePath, this.mStrokeBounds);
        }
        if (this.mMarkerRegion == null && this.mMarkerPath != null) {
            RectF rectF4 = new RectF();
            this.mMarkerBounds = rectF4;
            this.mMarkerPath.computeBounds(rectF4, true);
            this.mMarkerRegion = getRegion(this.mMarkerPath, this.mMarkerBounds);
        }
        Path clipPath = getClipPath();
        if (clipPath != null && this.mClipRegionPath != clipPath) {
            this.mClipRegionPath = clipPath;
            RectF rectF5 = new RectF();
            this.mClipBounds = rectF5;
            clipPath.computeBounds(rectF5, true);
            this.mClipRegion = getRegion(clipPath, this.mClipBounds);
        }
    }

    public void mergeProperties(RenderableView renderableView) {
        ArrayList<String> attributeList = renderableView.getAttributeList();
        if (!(attributeList == null || attributeList.size() == 0)) {
            this.mOriginProperties = new ArrayList<>();
            this.mAttributeList = this.mPropList == null ? new ArrayList<>() : new ArrayList<>(this.mPropList);
            int size = attributeList.size();
            for (int i = 0; i < size; i++) {
                try {
                    String str = attributeList.get(i);
                    Field field = getClass().getField(str);
                    Object obj = field.get(renderableView);
                    this.mOriginProperties.add(field.get(this));
                    if (!hasOwnProperty(str)) {
                        this.mAttributeList.add(str);
                        field.set(this, obj);
                    }
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
            this.mLastMergedList = attributeList;
        }
    }

    @Override // com.horcrux.svg.VirtualView
    public void render(Canvas canvas, Paint paint, float f) {
        MaskView maskView = this.mMask != null ? (MaskView) getSvgView().getDefinedMask(this.mMask) : null;
        if (maskView != null) {
            Rect clipBounds = canvas.getClipBounds();
            int height = clipBounds.height();
            int width = clipBounds.width();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap3);
            canvas3.clipRect((float) relativeOnWidth(maskView.mX), (float) relativeOnHeight(maskView.mY), (float) relativeOnWidth(maskView.mW), (float) relativeOnHeight(maskView.mH));
            Paint paint2 = new Paint(1);
            maskView.draw(canvas3, paint2, 1.0f);
            int i = width * height;
            int[] iArr = new int[i];
            createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i2 = 0;
            while (i2 < i) {
                int i3 = iArr[i2];
                double d = ((double) ((i3 >> 8) & 255)) * 0.587d;
                iArr[i2] = ((int) (((double) (i3 >>> 24)) * saturate(((((double) (i3 & 255)) * 0.144d) + (d + (((double) ((i3 >> 16) & 255)) * 0.299d))) / 255.0d))) << 24;
                i2++;
                i = i;
                paint2 = paint2;
            }
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            draw(canvas2, paint, f);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas4.drawBitmap(createBitmap2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (Paint) null);
            canvas4.drawBitmap(createBitmap, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, paint2);
            canvas.drawBitmap(createBitmap3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, paint);
            return;
        }
        draw(canvas, paint, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b9, code lost:
        if (com.horcrux.svg.RNSVGMarkerPosition.isZero(r14) != false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ed, code lost:
        if (com.horcrux.svg.RNSVGMarkerPosition.isZero(r14) != false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0110, code lost:
        if (com.horcrux.svg.RNSVGMarkerPosition.isZero(r14) != false) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014a  */
    public void renderMarkers(Canvas canvas, Paint paint, float f) {
        int i;
        MarkerView markerView;
        char c;
        boolean z;
        Point point;
        Point point2;
        Point point3;
        int i2;
        ElementType elementType;
        Point point4;
        Point point5;
        Point point6;
        MarkerView markerView2 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerStart);
        MarkerView markerView3 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerMid);
        MarkerView markerView4 = (MarkerView) getSvgView().getDefinedMarker(this.mMarkerEnd);
        if (this.elements == null) {
            return;
        }
        if (markerView2 != null || markerView3 != null || markerView4 != null) {
            contextElement = this;
            ArrayList<PathElement> arrayList = this.elements;
            RNSVGMarkerPosition.positions_ = new ArrayList<>();
            RNSVGMarkerPosition.element_index_ = 0;
            RNSVGMarkerPosition.origin_ = new Point(0.0d, 0.0d);
            RNSVGMarkerPosition.subpath_start_ = new Point(0.0d, 0.0d);
            Iterator<PathElement> it = arrayList.iterator();
            while (true) {
                i = 2;
                if (!it.hasNext()) {
                    break;
                }
                PathElement next = it.next();
                Point[] pointArr = next.points;
                int ordinal = next.type.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        point6 = pointArr[1];
                        Point point7 = RNSVGMarkerPosition.origin_;
                        Point point8 = pointArr[0];
                        Point point9 = pointArr[1];
                        point5 = RNSVGMarkerPosition.subtract(point8, point7);
                        point4 = RNSVGMarkerPosition.subtract(point9, point8);
                        if (!RNSVGMarkerPosition.isZero(point5)) {
                        }
                    } else if (ordinal == 2 || ordinal == 3) {
                        point6 = pointArr[0];
                        point5 = RNSVGMarkerPosition.subtract(point6, RNSVGMarkerPosition.origin_);
                        point4 = RNSVGMarkerPosition.subtract(point6, RNSVGMarkerPosition.origin_);
                    } else if (ordinal != 4) {
                        point3 = null;
                        point2 = null;
                        point = null;
                        RNSVGMarkerPosition.out_slope_ = point2;
                        i2 = RNSVGMarkerPosition.element_index_;
                        if (i2 > 0) {
                            RNSVGMarkerType rNSVGMarkerType = i2 == 1 ? RNSVGMarkerType.kStartMarker : RNSVGMarkerType.kMidMarker;
                            RNSVGMarkerPosition.positions_.add(new RNSVGMarkerPosition(rNSVGMarkerType, RNSVGMarkerPosition.origin_, RNSVGMarkerPosition.CurrentAngle(rNSVGMarkerType)));
                        }
                        RNSVGMarkerPosition.in_slope_ = point;
                        RNSVGMarkerPosition.origin_ = point3;
                        elementType = next.type;
                        if (elementType == ElementType.kCGPathElementMoveToPoint) {
                            RNSVGMarkerPosition.subpath_start_ = next.points[0];
                        } else if (elementType == ElementType.kCGPathElementCloseSubpath) {
                            RNSVGMarkerPosition.subpath_start_ = new Point(0.0d, 0.0d);
                            RNSVGMarkerPosition.element_index_++;
                        }
                        RNSVGMarkerPosition.element_index_++;
                    } else {
                        point6 = RNSVGMarkerPosition.subpath_start_;
                        point5 = RNSVGMarkerPosition.subtract(point6, RNSVGMarkerPosition.origin_);
                        point4 = RNSVGMarkerPosition.subtract(point6, RNSVGMarkerPosition.origin_);
                    }
                    point = point4;
                    point3 = point6;
                    point2 = point5;
                    RNSVGMarkerPosition.out_slope_ = point2;
                    i2 = RNSVGMarkerPosition.element_index_;
                    if (i2 > 0) {
                    }
                    RNSVGMarkerPosition.in_slope_ = point;
                    RNSVGMarkerPosition.origin_ = point3;
                    elementType = next.type;
                    if (elementType == ElementType.kCGPathElementMoveToPoint) {
                    }
                    RNSVGMarkerPosition.element_index_++;
                } else {
                    point6 = pointArr[2];
                    Point subtract = RNSVGMarkerPosition.subtract(pointArr[0], RNSVGMarkerPosition.origin_);
                    point4 = RNSVGMarkerPosition.subtract(pointArr[2], pointArr[1]);
                    if (RNSVGMarkerPosition.isZero(subtract)) {
                        Point point10 = pointArr[0];
                        Point point11 = pointArr[1];
                        Point point12 = pointArr[2];
                        subtract = RNSVGMarkerPosition.subtract(point11, point10);
                        point4 = RNSVGMarkerPosition.subtract(point12, point11);
                        if (!RNSVGMarkerPosition.isZero(subtract)) {
                        }
                    } else {
                        if (RNSVGMarkerPosition.isZero(point4)) {
                            Point point13 = RNSVGMarkerPosition.origin_;
                            Point point14 = pointArr[0];
                            Point point15 = pointArr[1];
                            subtract = RNSVGMarkerPosition.subtract(point14, point13);
                            point4 = RNSVGMarkerPosition.subtract(point15, point14);
                            if (!RNSVGMarkerPosition.isZero(subtract)) {
                            }
                        }
                        point5 = subtract;
                        point = point4;
                        point3 = point6;
                        point2 = point5;
                        RNSVGMarkerPosition.out_slope_ = point2;
                        i2 = RNSVGMarkerPosition.element_index_;
                        if (i2 > 0) {
                        }
                        RNSVGMarkerPosition.in_slope_ = point;
                        RNSVGMarkerPosition.origin_ = point3;
                        elementType = next.type;
                        if (elementType == ElementType.kCGPathElementMoveToPoint) {
                        }
                        RNSVGMarkerPosition.element_index_++;
                    }
                    point5 = subtract;
                    point4 = point5;
                    point = point4;
                    point3 = point6;
                    point2 = point5;
                    RNSVGMarkerPosition.out_slope_ = point2;
                    i2 = RNSVGMarkerPosition.element_index_;
                    if (i2 > 0) {
                    }
                    RNSVGMarkerPosition.in_slope_ = point;
                    RNSVGMarkerPosition.origin_ = point3;
                    elementType = next.type;
                    if (elementType == ElementType.kCGPathElementMoveToPoint) {
                    }
                    RNSVGMarkerPosition.element_index_++;
                }
                point5 = point4;
                point4 = point5;
                point = point4;
                point3 = point6;
                point2 = point5;
                RNSVGMarkerPosition.out_slope_ = point2;
                i2 = RNSVGMarkerPosition.element_index_;
                if (i2 > 0) {
                }
                RNSVGMarkerPosition.in_slope_ = point;
                RNSVGMarkerPosition.origin_ = point3;
                elementType = next.type;
                if (elementType == ElementType.kCGPathElementMoveToPoint) {
                }
                RNSVGMarkerPosition.element_index_++;
            }
            RNSVGMarkerType rNSVGMarkerType2 = RNSVGMarkerType.kEndMarker;
            RNSVGMarkerPosition.positions_.add(new RNSVGMarkerPosition(rNSVGMarkerType2, RNSVGMarkerPosition.origin_, RNSVGMarkerPosition.CurrentAngle(rNSVGMarkerType2)));
            ArrayList<RNSVGMarkerPosition> arrayList2 = RNSVGMarkerPosition.positions_;
            SVGLength sVGLength = this.strokeWidth;
            float relativeOnOther = (float) (sVGLength != null ? relativeOnOther(sVGLength) : 1.0d);
            this.mMarkerPath = new Path();
            Iterator<RNSVGMarkerPosition> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                RNSVGMarkerPosition next2 = it2.next();
                int ordinal2 = next2.type.ordinal();
                MarkerView markerView5 = ordinal2 != 0 ? ordinal2 != 1 ? ordinal2 != i ? null : markerView4 : markerView3 : markerView2;
                if (markerView5 != null) {
                    int saveAndSetupCanvas = markerView5.saveAndSetupCanvas(canvas, markerView5.mCTM);
                    markerView5.markerTransform.reset();
                    Point point16 = next2.origin;
                    Matrix matrix = markerView5.markerTransform;
                    float f2 = markerView5.mScale;
                    matrix.setTranslate(((float) point16.x) * f2, ((float) point16.y) * f2);
                    double parseDouble = "auto".equals(markerView5.mOrient) ? -1.0d : Double.parseDouble(markerView5.mOrient);
                    if (parseDouble == -1.0d) {
                        parseDouble = next2.angle;
                    }
                    markerView5.markerTransform.preRotate(((float) parseDouble) + 180.0f);
                    if ("strokeWidth".equals(markerView5.mMarkerUnits)) {
                        relativeOnOther = relativeOnOther;
                        markerView5.markerTransform.preScale(relativeOnOther, relativeOnOther);
                    } else {
                        relativeOnOther = relativeOnOther;
                    }
                    RectF rectF = new RectF(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) (markerView5.relativeOnWidth(markerView5.mMarkerWidth) / ((double) markerView5.mScale)), (float) (markerView5.relativeOnHeight(markerView5.mMarkerHeight) / ((double) markerView5.mScale)));
                    if (markerView5.mAlign != null) {
                        float f3 = markerView5.mMinX;
                        float f4 = markerView5.mScale;
                        float f5 = markerView5.mMinY;
                        markerView = markerView2;
                        Matrix transform = PathParser.getTransform(new RectF(f3 * f4, f5 * f4, (f3 + markerView5.mVbWidth) * f4, (f5 + markerView5.mVbHeight) * f4), rectF, markerView5.mAlign, markerView5.mMeetOrSlice);
                        float[] fArr = new float[9];
                        transform.getValues(fArr);
                        z = false;
                        c = 4;
                        markerView5.markerTransform.preScale(fArr[0], fArr[4]);
                    } else {
                        markerView = markerView2;
                        z = false;
                        c = 4;
                    }
                    markerView5.markerTransform.preTranslate((float) (-markerView5.relativeOnWidth(markerView5.mRefX)), (float) (-markerView5.relativeOnHeight(markerView5.mRefY)));
                    canvas.concat(markerView5.markerTransform);
                    markerView5.drawGroup(canvas, paint, f);
                    markerView5.restoreCanvas(canvas, saveAndSetupCanvas);
                    this.mMarkerPath.addPath(markerView5.getPath(canvas, paint), markerView5.markerTransform);
                    markerView3 = markerView3;
                    markerView2 = markerView;
                    i = 2;
                }
            }
            contextElement = null;
        }
    }

    public void resetProperties() {
        ArrayList<String> arrayList = this.mLastMergedList;
        if (arrayList != null && this.mOriginProperties != null) {
            try {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    getClass().getField(this.mLastMergedList.get(size)).set(this, this.mOriginProperties.get(size));
                }
                this.mLastMergedList = null;
                this.mOriginProperties = null;
                this.mAttributeList = this.mPropList;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @ReactProp(name = "fill")
    public void setFill(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.fill = null;
            invalidate();
            return;
        }
        ReadableType type = dynamic.getType();
        int i = 0;
        if (type.equals(ReadableType.Number)) {
            this.fill = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
        } else if (type.equals(ReadableType.Array)) {
            this.fill = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double parseDouble = Double.parseDouble(matcher.group());
                int i2 = i + 1;
                if (i < 3) {
                    parseDouble /= 255.0d;
                }
                javaOnlyArray.pushDouble(parseDouble);
                i = i2;
            }
            this.fill = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(float f) {
        this.fillOpacity = f;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(int i) {
        if (i == 0) {
            this.fillRule = Path.FillType.EVEN_ODD;
        } else if (i != 1) {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("fillRule ", i, " unrecognized"));
        }
        invalidate();
    }

    public void setId(int i) {
        super.setId(i);
        RenderableViewManager.setRenderableView(i, this);
    }

    @ReactProp(name = "propList")
    public void setPropList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mAttributeList = arrayList;
            this.mPropList = arrayList;
            for (int i = 0; i < readableArray.size(); i++) {
                this.mPropList.add(readableArray.getString(i));
            }
        }
        invalidate();
    }

    @ReactProp(name = "stroke")
    public void setStroke(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.stroke = null;
            invalidate();
            return;
        }
        ReadableType type = dynamic.getType();
        int i = 0;
        if (type.equals(ReadableType.Number)) {
            this.stroke = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
        } else if (type.equals(ReadableType.Array)) {
            this.stroke = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double parseDouble = Double.parseDouble(matcher.group());
                int i2 = i + 1;
                if (i < 3) {
                    parseDouble /= 255.0d;
                }
                javaOnlyArray.pushDouble(parseDouble);
                i = i2;
            }
            this.stroke = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            this.strokeDasharray = new SVGLength[size];
            for (int i = 0; i < size; i++) {
                this.strokeDasharray[i] = SVGLength.from(readableArray.getDynamic(i));
            }
        } else {
            this.strokeDasharray = null;
        }
        invalidate();
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(float f) {
        this.strokeDashoffset = f * this.mScale;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(int i) {
        if (i == 0) {
            this.strokeLinecap = Paint.Cap.BUTT;
        } else if (i == 1) {
            this.strokeLinecap = Paint.Cap.ROUND;
        } else if (i == 2) {
            this.strokeLinecap = Paint.Cap.SQUARE;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("strokeLinecap ", i, " unrecognized"));
        }
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(int i) {
        if (i == 0) {
            this.strokeLinejoin = Paint.Join.MITER;
        } else if (i == 1) {
            this.strokeLinejoin = Paint.Join.ROUND;
        } else if (i == 2) {
            this.strokeLinejoin = Paint.Join.BEVEL;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("strokeLinejoin ", i, " unrecognized"));
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(float f) {
        this.strokeMiterlimit = f;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(float f) {
        this.strokeOpacity = f;
        invalidate();
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(Dynamic dynamic) {
        this.strokeWidth = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(int i) {
        this.vectorEffect = i;
        invalidate();
    }

    public boolean setupFillPaint(Paint paint, float f) {
        ReadableArray readableArray = this.fill;
        if (readableArray == null || readableArray.size() <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Paint.Style.FILL);
        setupPaint(paint, f, this.fill);
        return true;
    }

    public boolean setupStrokePaint(Paint paint, float f) {
        ReadableArray readableArray;
        paint.reset();
        double relativeOnOther = relativeOnOther(this.strokeWidth);
        if (relativeOnOther == 0.0d || (readableArray = this.stroke) == null || readableArray.size() == 0) {
            return false;
        }
        paint.setFlags(385);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.strokeLinecap);
        paint.setStrokeJoin(this.strokeLinejoin);
        paint.setStrokeMiter(this.strokeMiterlimit * this.mScale);
        paint.setStrokeWidth((float) relativeOnOther);
        setupPaint(paint, f, this.stroke);
        SVGLength[] sVGLengthArr = this.strokeDasharray;
        if (sVGLengthArr == null) {
            return true;
        }
        int length = sVGLengthArr.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) relativeOnOther(this.strokeDasharray[i]);
        }
        paint.setPathEffect(new DashPathEffect(fArr, this.strokeDashoffset));
        return true;
    }
}
