package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTShapeShadowNode extends ARTVirtualNode {
    public float[] mBrushData;
    public Path mPath;
    public int mStrokeCap = 1;
    public float[] mStrokeColor;
    public float[] mStrokeDash;
    public int mStrokeJoin = 1;
    public float mStrokeWidth = 1.0f;

    @Override // com.facebook.react.views.art.ARTVirtualNode
    public void draw(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.mOpacity;
        if (f2 > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mPath != null) {
                if (setupFillPaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                if (setupStrokePaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                canvas.restore();
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        markUpdateSeen();
    }

    @ReactProp(name = "fill")
    public void setFill(ReadableArray readableArray) {
        this.mBrushData = ReactYogaConfigProvider.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "d")
    public void setShapePath(ReadableArray readableArray) {
        int i;
        int i2;
        float[] floatArray = ReactYogaConfigProvider.toFloatArray(readableArray);
        Path path = new Path();
        path.moveTo(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        int i3 = 0;
        while (i3 < floatArray.length) {
            int i4 = i3 + 1;
            int i5 = (int) floatArray[i3];
            if (i5 != 0) {
                boolean z = true;
                if (i5 == 1) {
                    path.close();
                    i3 = i4;
                } else if (i5 != 2) {
                    if (i5 == 3) {
                        int i6 = i4 + 1;
                        float f = floatArray[i4];
                        float f2 = this.mScale;
                        int i7 = i6 + 1;
                        float f3 = floatArray[i6] * f2;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        float f4 = floatArray[i8] * f2;
                        int i10 = i9 + 1;
                        i2 = i10 + 1;
                        path.cubicTo(f * f2, f3, floatArray[i7] * f2, f4, floatArray[i9] * f2, floatArray[i10] * f2);
                    } else if (i5 == 4) {
                        int i11 = i4 + 1;
                        float f5 = floatArray[i4];
                        float f6 = this.mScale;
                        float f7 = f5 * f6;
                        int i12 = i11 + 1;
                        float f8 = floatArray[i11] * f6;
                        int i13 = i12 + 1;
                        float f9 = floatArray[i12] * f6;
                        int i14 = i13 + 1;
                        float degrees = (float) Math.toDegrees((double) floatArray[i13]);
                        int i15 = i14 + 1;
                        float degrees2 = (float) Math.toDegrees((double) floatArray[i14]);
                        i2 = i15 + 1;
                        if (floatArray[i15] == 1.0f) {
                            z = false;
                        }
                        float f10 = degrees2 - degrees;
                        if (Math.abs(f10) >= 360.0f) {
                            path.addCircle(f7, f8, f9, z ? Path.Direction.CCW : Path.Direction.CW);
                        } else {
                            float f11 = f10 % 360.0f;
                            if (f11 < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                f11 += 360.0f;
                            }
                            if (z && f11 < 360.0f) {
                                f11 = (360.0f - f11) * -1.0f;
                            }
                            path.arcTo(new RectF(f7 - f9, f8 - f9, f7 + f9, f8 + f9), degrees, f11);
                        }
                    } else {
                        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline4("Unrecognized drawing instruction ", i5));
                    }
                    i3 = i2;
                } else {
                    int i16 = i4 + 1;
                    float f12 = floatArray[i4];
                    float f13 = this.mScale;
                    i = i16 + 1;
                    path.lineTo(f12 * f13, floatArray[i16] * f13);
                }
            } else {
                int i17 = i4 + 1;
                float f14 = floatArray[i4];
                float f15 = this.mScale;
                i = i17 + 1;
                path.moveTo(f14 * f15, floatArray[i17] * f15);
            }
            i3 = i;
        }
        this.mPath = path;
        markUpdated();
    }

    @ReactProp(name = "stroke")
    public void setStroke(ReadableArray readableArray) {
        this.mStrokeColor = ReactYogaConfigProvider.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.mStrokeCap = i;
        markUpdated();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(ReadableArray readableArray) {
        this.mStrokeDash = ReactYogaConfigProvider.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.mStrokeJoin = i;
        markUpdated();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        markUpdated();
    }

    public boolean setupFillPaint(Paint paint, float f) {
        float[] fArr;
        int[] iArr;
        float[] fArr2 = this.mBrushData;
        int i = 0;
        if (fArr2 == null || fArr2.length <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        float[] fArr3 = this.mBrushData;
        int i2 = (int) fArr3[0];
        if (i2 == 0) {
            float f2 = fArr3.length > 4 ? fArr3[4] * f * 255.0f : f * 255.0f;
            float[] fArr4 = this.mBrushData;
            paint.setARGB((int) f2, (int) (fArr4[1] * 255.0f), (int) (fArr4[2] * 255.0f), (int) (fArr4[3] * 255.0f));
            return true;
        } else if (i2 != 1) {
            FLog.w("ReactNative", "ART: Color type " + i2 + " not supported!");
            return true;
        } else {
            int i3 = 5;
            if (fArr3.length < 5) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("[ARTShapeShadowNode setupFillPaint] expects 5 elements, received ");
                outline15.append(this.mBrushData.length);
                FLog.w("ReactNative", outline15.toString());
                return false;
            }
            float f3 = fArr3[1];
            float f4 = this.mScale;
            float f5 = f3 * f4;
            float f6 = fArr3[2] * f4;
            float f7 = fArr3[3] * f4;
            float f8 = fArr3[4] * f4;
            int length = (fArr3.length - 5) / 5;
            if (length > 0) {
                int[] iArr2 = new int[length];
                float[] fArr5 = new float[length];
                while (i < length) {
                    float[] fArr6 = this.mBrushData;
                    fArr5[i] = fArr6[(length * 4) + i3 + i];
                    int i4 = (i * 4) + i3;
                    iArr2[i] = Color.argb((int) (fArr6[i4 + 3] * 255.0f), (int) (fArr6[i4 + 0] * 255.0f), (int) (fArr6[i4 + 1] * 255.0f), (int) (fArr6[i4 + 2] * 255.0f));
                    i++;
                    i3 = 5;
                }
                iArr = iArr2;
                fArr = fArr5;
            } else {
                iArr = null;
                fArr = null;
            }
            paint.setShader(new LinearGradient(f5, f6, f7, f8, iArr, fArr, Shader.TileMode.CLAMP));
            return true;
        }
    }

    public boolean setupStrokePaint(Paint paint, float f) {
        float[] fArr;
        if (this.mStrokeWidth == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || (fArr = this.mStrokeColor) == null || fArr.length == 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        int i = this.mStrokeCap;
        if (i == 0) {
            paint.setStrokeCap(Paint.Cap.BUTT);
        } else if (i == 1) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        } else if (i == 2) {
            paint.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline11(GeneratedOutlineSupport.outline15("strokeCap "), this.mStrokeCap, " unrecognized"));
        }
        int i2 = this.mStrokeJoin;
        if (i2 == 0) {
            paint.setStrokeJoin(Paint.Join.MITER);
        } else if (i2 == 1) {
            paint.setStrokeJoin(Paint.Join.ROUND);
        } else if (i2 == 2) {
            paint.setStrokeJoin(Paint.Join.BEVEL);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline11(GeneratedOutlineSupport.outline15("strokeJoin "), this.mStrokeJoin, " unrecognized"));
        }
        paint.setStrokeWidth(this.mStrokeWidth * this.mScale);
        float[] fArr2 = this.mStrokeColor;
        int i3 = (int) (fArr2.length > 3 ? fArr2[3] * f * 255.0f : f * 255.0f);
        float[] fArr3 = this.mStrokeColor;
        paint.setARGB(i3, (int) (fArr3[0] * 255.0f), (int) (fArr3[1] * 255.0f), (int) (fArr3[2] * 255.0f));
        float[] fArr4 = this.mStrokeDash;
        if (fArr4 != null && fArr4.length > 0) {
            paint.setPathEffect(new DashPathEffect(this.mStrokeDash, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
        return true;
    }
}
