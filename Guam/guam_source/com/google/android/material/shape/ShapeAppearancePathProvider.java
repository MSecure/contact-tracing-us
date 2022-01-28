package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.List;

public class ShapeAppearancePathProvider {
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public final Matrix[] edgeTransforms = new Matrix[4];
    public final PointF pointF = new PointF();
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final ShapePath shapePath = new ShapePath();

    public interface PathListener {
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
        float f2;
        EdgeTreatment edgeTreatment;
        char c;
        char c2;
        CornerSize cornerSize;
        CornerTreatment cornerTreatment;
        path.rewind();
        char c3 = 0;
        int i = 0;
        while (i < 4) {
            if (i == 1) {
                cornerSize = shapeAppearanceModel.bottomRightCornerSize;
            } else if (i == 2) {
                cornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            } else if (i != 3) {
                cornerSize = shapeAppearanceModel.topRightCornerSize;
            } else {
                cornerSize = shapeAppearanceModel.topLeftCornerSize;
            }
            if (i == 1) {
                cornerTreatment = shapeAppearanceModel.bottomRightCorner;
            } else if (i == 2) {
                cornerTreatment = shapeAppearanceModel.bottomLeftCorner;
            } else if (i != 3) {
                cornerTreatment = shapeAppearanceModel.topRightCorner;
            } else {
                cornerTreatment = shapeAppearanceModel.topLeftCorner;
            }
            ShapePath shapePath2 = this.cornerPaths[i];
            if (cornerTreatment != null) {
                cornerTreatment.getCornerPath(shapePath2, 90.0f, f, cornerSize.getCornerSize(rectF));
                int i2 = i + 1;
                float f3 = (float) (i2 * 90);
                this.cornerTransforms[i].reset();
                PointF pointF2 = this.pointF;
                if (i == 1) {
                    pointF2.set(rectF.right, rectF.bottom);
                } else if (i == 2) {
                    pointF2.set(rectF.left, rectF.bottom);
                } else if (i != 3) {
                    pointF2.set(rectF.right, rectF.top);
                } else {
                    pointF2.set(rectF.left, rectF.top);
                }
                Matrix matrix = this.cornerTransforms[i];
                PointF pointF3 = this.pointF;
                matrix.setTranslate(pointF3.x, pointF3.y);
                this.cornerTransforms[i].preRotate(f3);
                float[] fArr = this.scratch;
                ShapePath[] shapePathArr = this.cornerPaths;
                fArr[0] = shapePathArr[i].endX;
                fArr[1] = shapePathArr[i].endY;
                this.cornerTransforms[i].mapPoints(fArr);
                this.edgeTransforms[i].reset();
                Matrix matrix2 = this.edgeTransforms[i];
                float[] fArr2 = this.scratch;
                matrix2.setTranslate(fArr2[0], fArr2[1]);
                this.edgeTransforms[i].preRotate(f3);
                i = i2;
            } else {
                throw null;
            }
        }
        int i3 = 0;
        while (i3 < 4) {
            float[] fArr3 = this.scratch;
            ShapePath[] shapePathArr2 = this.cornerPaths;
            fArr3[c3] = shapePathArr2[i3].startX;
            fArr3[1] = shapePathArr2[i3].startY;
            this.cornerTransforms[i3].mapPoints(fArr3);
            if (i3 == 0) {
                float[] fArr4 = this.scratch;
                path.moveTo(fArr4[c3], fArr4[1]);
            } else {
                float[] fArr5 = this.scratch;
                path.lineTo(fArr5[c3], fArr5[1]);
            }
            this.cornerPaths[i3].applyToPath(this.cornerTransforms[i3], path);
            if (pathListener != null) {
                ShapePath shapePath3 = this.cornerPaths[i3];
                Matrix matrix3 = this.cornerTransforms[i3];
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr = MaterialShapeDrawable.this.cornerShadowOperation;
                shapePath3.addConnectingShadowIfNecessary(shapePath3.endShadowAngle);
                shadowCompatOperationArr[i3] = new ShapePath.ShadowCompatOperation(shapePath3, new ArrayList(shapePath3.shadowCompatOperations), matrix3) {
                    /* class com.google.android.material.shape.ShapePath.AnonymousClass1 */
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transform;

                    {
                        this.val$operations = r2;
                        this.val$transform = r3;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                        for (ShadowCompatOperation shadowCompatOperation : this.val$operations) {
                            shadowCompatOperation.draw(this.val$transform, shadowRenderer, i, canvas);
                        }
                    }
                };
            }
            int i4 = i3 + 1;
            int i5 = i4 % 4;
            float[] fArr6 = this.scratch;
            ShapePath[] shapePathArr3 = this.cornerPaths;
            fArr6[c3] = shapePathArr3[i3].endX;
            fArr6[1] = shapePathArr3[i3].endY;
            this.cornerTransforms[i3].mapPoints(fArr6);
            float[] fArr7 = this.scratch2;
            ShapePath[] shapePathArr4 = this.cornerPaths;
            fArr7[c3] = shapePathArr4[i5].startX;
            fArr7[1] = shapePathArr4[i5].startY;
            this.cornerTransforms[i5].mapPoints(fArr7);
            float[] fArr8 = this.scratch;
            float f4 = fArr8[c3];
            float[] fArr9 = this.scratch2;
            float max = Math.max(((float) Math.hypot((double) (f4 - fArr9[c3]), (double) (fArr8[1] - fArr9[1]))) - 0.001f, (float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            float[] fArr10 = this.scratch;
            ShapePath[] shapePathArr5 = this.cornerPaths;
            fArr10[c3] = shapePathArr5[i3].endX;
            fArr10[1] = shapePathArr5[i3].endY;
            this.cornerTransforms[i3].mapPoints(fArr10);
            if (i3 == 1 || i3 == 3) {
                f2 = Math.abs(rectF.centerX() - this.scratch[c3]);
            } else {
                f2 = Math.abs(rectF.centerY() - this.scratch[1]);
            }
            this.shapePath.reset(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 270.0f, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            if (i3 != 1) {
                c2 = 2;
                if (i3 != 2) {
                    c = 3;
                    if (i3 != 3) {
                        edgeTreatment = shapeAppearanceModel.rightEdge;
                    } else {
                        edgeTreatment = shapeAppearanceModel.topEdge;
                    }
                } else {
                    c = 3;
                    edgeTreatment = shapeAppearanceModel.leftEdge;
                }
            } else {
                c2 = 2;
                c = 3;
                edgeTreatment = shapeAppearanceModel.bottomEdge;
            }
            edgeTreatment.getEdgePath(max, f2, f, this.shapePath);
            this.shapePath.applyToPath(this.edgeTransforms[i3], path);
            if (pathListener != null) {
                ShapePath shapePath4 = this.shapePath;
                Matrix matrix4 = this.edgeTransforms[i3];
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr2 = MaterialShapeDrawable.this.edgeShadowOperation;
                shapePath4.addConnectingShadowIfNecessary(shapePath4.endShadowAngle);
                shadowCompatOperationArr2[i3] = new ShapePath.ShadowCompatOperation(shapePath4, new ArrayList(shapePath4.shadowCompatOperations), matrix4) {
                    /* class com.google.android.material.shape.ShapePath.AnonymousClass1 */
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transform;

                    {
                        this.val$operations = r2;
                        this.val$transform = r3;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                        for (ShadowCompatOperation shadowCompatOperation : this.val$operations) {
                            shadowCompatOperation.draw(this.val$transform, shadowRenderer, i, canvas);
                        }
                    }
                };
            }
            i3 = i4;
            c3 = 0;
        }
        path.close();
    }
}
