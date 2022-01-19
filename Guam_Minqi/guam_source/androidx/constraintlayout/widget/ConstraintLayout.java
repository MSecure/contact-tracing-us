package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.http2.Http2Connection;

public class ConstraintLayout extends ViewGroup {
    public SparseArray<View> mChildrenByIds = new SparseArray<>();
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    public ConstraintLayoutStates mConstraintLayoutSpec = null;
    public ConstraintSet mConstraintSet = null;
    public int mConstraintSetId = -1;
    public HashMap<String, Integer> mDesignIds = new HashMap<>();
    public boolean mDirtyHierarchy = true;
    public int mLastMeasureHeight = -1;
    public int mLastMeasureWidth = -1;
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    public int mMaxHeight = Integer.MAX_VALUE;
    public int mMaxWidth = Integer.MAX_VALUE;
    public Measurer mMeasurer;
    public int mMinHeight = 0;
    public int mMinWidth = 0;
    public int mOptimizationLevel = 263;
    public SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public class Measurer implements BasicMeasure.Measurer {
        public ConstraintLayout layout;
        public int layoutHeightSpec;
        public int layoutWidthSpec;
        public int paddingBottom;
        public int paddingHeight;
        public int paddingTop;
        public int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r17v1 */
        /* JADX WARN: Type inference failed for: r9v10, types: [int[]] */
        /* JADX WARN: Type inference failed for: r17v2 */
        /* JADX WARN: Type inference failed for: r17v3 */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x017d  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0188  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x019b A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x01b4  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x01d3  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01de  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01f4  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0206  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x0213  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x021d  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0225 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x023c A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:161:0x0247  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x024d  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x0264  */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x0266  */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x026c  */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x027b  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x027d  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0154  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0162  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0164  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0167  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0169  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x016c A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0174 A[ADDED_TO_REGION] */
        /* JADX WARNING: Unknown variable types count: 2 */
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int i;
            boolean z;
            int i2;
            int ordinal;
            int i3;
            boolean z2;
            boolean z3;
            boolean z4;
            int i4;
            int i5;
            int i6;
            int i7;
            boolean z5;
            int measuredWidth;
            int measuredHeight;
            ?? r17;
            int max;
            int i8;
            int max2;
            int i9;
            int i10;
            int makeMeasureSpec;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (constraintWidget != null) {
                if (constraintWidget.mVisibility != 8 || constraintWidget.inPlaceholder) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = measure.horizontalBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.verticalBehavior;
                    int i11 = measure.horizontalDimension;
                    int i12 = measure.verticalDimension;
                    int i13 = this.paddingTop + this.paddingBottom;
                    int i14 = this.paddingWidth;
                    View view = (View) constraintWidget.mCompanionWidget;
                    int ordinal2 = dimensionBehaviour4.ordinal();
                    if (ordinal2 != 0) {
                        if (ordinal2 == 1) {
                            i2 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i14, -2);
                            i = 2;
                            constraintWidget.wrapMeasure[2] = -2;
                            z = true;
                        } else if (ordinal2 == 2) {
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i14, -2);
                            boolean z6 = constraintWidget.mMatchConstraintDefaultWidth == 1;
                            int[] iArr = constraintWidget.wrapMeasure;
                            iArr[2] = 0;
                            if (measure.useCurrentDimensions) {
                                boolean z7 = !(!z6 || iArr[3] == 0 || iArr[0] == constraintWidget.getWidth()) || (view instanceof Placeholder);
                                if (!z6 || z7) {
                                    i2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                                    z = false;
                                    i = 2;
                                }
                            }
                            i2 = childMeasureSpec;
                            z = true;
                            i = 2;
                        } else if (ordinal2 != 3) {
                            i = 2;
                            i2 = 0;
                        } else {
                            int i15 = this.layoutWidthSpec;
                            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                            int i16 = constraintAnchor != null ? constraintAnchor.mMargin + 0 : 0;
                            ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
                            if (constraintAnchor2 != null) {
                                i16 += constraintAnchor2.mMargin;
                            }
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i15, i14 + i16, -1);
                            constraintWidget.wrapMeasure[2] = -1;
                            i = 2;
                            i2 = childMeasureSpec2;
                        }
                        ordinal = dimensionBehaviour5.ordinal();
                        if (ordinal == 0) {
                            if (ordinal != 1) {
                                if (ordinal == i) {
                                    i10 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i13, -2);
                                    boolean z8 = constraintWidget.mMatchConstraintDefaultHeight == 1;
                                    int[] iArr2 = constraintWidget.wrapMeasure;
                                    iArr2[3] = 0;
                                    if (measure.useCurrentDimensions) {
                                        boolean z9 = !(!z8 || iArr2[2] == 0 || iArr2[1] == constraintWidget.getHeight()) || (view instanceof Placeholder);
                                        if (!z8 || z9) {
                                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                        }
                                    }
                                } else if (ordinal != 3) {
                                    z2 = false;
                                    i3 = 0;
                                    boolean z10 = dimensionBehaviour4 != dimensionBehaviour3;
                                    boolean z11 = dimensionBehaviour5 != dimensionBehaviour3;
                                    boolean z12 = dimensionBehaviour5 != dimensionBehaviour2 || dimensionBehaviour5 == dimensionBehaviour;
                                    boolean z13 = dimensionBehaviour4 != dimensionBehaviour2 || dimensionBehaviour4 == dimensionBehaviour;
                                    z3 = !z10 && constraintWidget.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                    boolean z14 = !z11 && constraintWidget.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                    if (!measure.useCurrentDimensions || !z10 || constraintWidget.mMatchConstraintDefaultWidth != 0 || !z11 || constraintWidget.mMatchConstraintDefaultHeight != 0) {
                                        if ((view instanceof VirtualLayout) || !(constraintWidget instanceof VirtualLayout)) {
                                            view.measure(i2, i3);
                                        } else {
                                            VirtualLayout virtualLayout = (VirtualLayout) constraintWidget;
                                            ((VirtualLayout) view).onMeasure();
                                        }
                                        measuredWidth = view.getMeasuredWidth();
                                        measuredHeight = view.getMeasuredHeight();
                                        i4 = view.getBaseline();
                                        if (!z) {
                                            int[] iArr3 = constraintWidget.wrapMeasure;
                                            r17 = 0;
                                            iArr3[0] = measuredWidth;
                                            iArr3[2] = measuredHeight;
                                        } else {
                                            r17 = 0;
                                            int[] iArr4 = constraintWidget.wrapMeasure;
                                            iArr4[0] = 0;
                                            iArr4[2] = 0;
                                        }
                                        if (!z2) {
                                            int[] iArr5 = constraintWidget.wrapMeasure;
                                            iArr5[1] = measuredHeight;
                                            iArr5[3] = measuredWidth;
                                        } else {
                                            ?? r9 = constraintWidget.wrapMeasure;
                                            int i17 = r17 == true ? 1 : 0;
                                            int i18 = r17 == true ? 1 : 0;
                                            int i19 = r17 == true ? 1 : 0;
                                            int i20 = r17 == true ? 1 : 0;
                                            r9[1] = i17;
                                            r9[3] = r17;
                                        }
                                        int i21 = constraintWidget.mMatchConstraintMinWidth;
                                        max = i21 <= 0 ? Math.max(i21, measuredWidth) : measuredWidth;
                                        i8 = constraintWidget.mMatchConstraintMaxWidth;
                                        if (i8 > 0) {
                                            max = Math.min(i8, max);
                                        }
                                        int i22 = constraintWidget.mMatchConstraintMinHeight;
                                        max2 = i22 <= 0 ? Math.max(i22, measuredHeight) : measuredHeight;
                                        i9 = constraintWidget.mMatchConstraintMaxHeight;
                                        if (i9 > 0) {
                                            max2 = Math.min(i9, max2);
                                        }
                                        if (!z3 && z12) {
                                            max = (int) ((((float) max2) * constraintWidget.mDimensionRatio) + 0.5f);
                                        } else if (z14 && z13) {
                                            max2 = (int) ((((float) max) / constraintWidget.mDimensionRatio) + 0.5f);
                                        }
                                        if (measuredWidth == max || measuredHeight != max2) {
                                            if (measuredWidth != max) {
                                                i2 = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                                            }
                                            if (measuredHeight != max2) {
                                                i3 = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                                            }
                                            view.measure(i2, i3);
                                            i7 = view.getMeasuredWidth();
                                            i6 = view.getMeasuredHeight();
                                            i4 = view.getBaseline();
                                        } else {
                                            i7 = max;
                                            i6 = max2;
                                        }
                                        i5 = -1;
                                        z4 = r17;
                                    } else {
                                        i7 = 0;
                                        i6 = 0;
                                        i5 = -1;
                                        i4 = 0;
                                        z4 = false;
                                    }
                                    boolean z15 = i4 == i5 ? true : z4;
                                    if (i7 == measure.horizontalDimension || i6 != measure.verticalDimension) {
                                        z5 = true;
                                    } else {
                                        boolean z16 = z4 ? 1 : 0;
                                        boolean z17 = z4 ? 1 : 0;
                                        boolean z18 = z4 ? 1 : 0;
                                        boolean z19 = z4 ? 1 : 0;
                                        boolean z20 = z4 ? 1 : 0;
                                        z5 = z16;
                                    }
                                    measure.measuredNeedsSolverPass = z5;
                                    boolean z21 = !layoutParams.needsBaseline ? true : z15;
                                    if (!(!z21 || i4 == -1 || constraintWidget.mBaselineDistance == i4)) {
                                        measure.measuredNeedsSolverPass = true;
                                    }
                                    measure.measuredWidth = i7;
                                    measure.measuredHeight = i6;
                                    measure.measuredHasBaseline = z21;
                                    measure.measuredBaseline = i4;
                                    return;
                                } else {
                                    int i23 = this.layoutHeightSpec;
                                    int i24 = constraintWidget.mLeft != null ? constraintWidget.mTop.mMargin + 0 : 0;
                                    if (constraintWidget.mRight != null) {
                                        i24 += constraintWidget.mBottom.mMargin;
                                    }
                                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(i23, i13 + i24, -1);
                                    constraintWidget.wrapMeasure[3] = -1;
                                }
                                i3 = makeMeasureSpec;
                            } else {
                                i10 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i13, -2);
                                constraintWidget.wrapMeasure[3] = -2;
                            }
                            i3 = i10;
                            z2 = true;
                            if (dimensionBehaviour4 != dimensionBehaviour3) {
                            }
                            if (dimensionBehaviour5 != dimensionBehaviour3) {
                            }
                            if (dimensionBehaviour5 != dimensionBehaviour2) {
                            }
                            if (dimensionBehaviour4 != dimensionBehaviour2) {
                            }
                            if (!z10) {
                            }
                            if (!z11) {
                            }
                            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                            if (!measure.useCurrentDimensions) {
                            }
                            if (view instanceof VirtualLayout) {
                            }
                            view.measure(i2, i3);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            i4 = view.getBaseline();
                            if (!z) {
                            }
                            if (!z2) {
                            }
                            int i212 = constraintWidget.mMatchConstraintMinWidth;
                            if (i212 <= 0) {
                            }
                            i8 = constraintWidget.mMatchConstraintMaxWidth;
                            if (i8 > 0) {
                            }
                            int i222 = constraintWidget.mMatchConstraintMinHeight;
                            if (i222 <= 0) {
                            }
                            i9 = constraintWidget.mMatchConstraintMaxHeight;
                            if (i9 > 0) {
                            }
                            if (!z3) {
                            }
                            max2 = (int) ((((float) max) / constraintWidget.mDimensionRatio) + 0.5f);
                            if (measuredWidth == max) {
                            }
                            if (measuredWidth != max) {
                            }
                            if (measuredHeight != max2) {
                            }
                            view.measure(i2, i3);
                            i7 = view.getMeasuredWidth();
                            i6 = view.getMeasuredHeight();
                            i4 = view.getBaseline();
                            i5 = -1;
                            z4 = r17;
                            if (i4 == i5) {
                            }
                            if (i7 == measure.horizontalDimension) {
                            }
                            z5 = true;
                            measure.measuredNeedsSolverPass = z5;
                            if (!layoutParams2.needsBaseline) {
                            }
                            measure.measuredNeedsSolverPass = true;
                            measure.measuredWidth = i7;
                            measure.measuredHeight = i6;
                            measure.measuredHasBaseline = z21;
                            measure.measuredBaseline = i4;
                            return;
                        }
                        i3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                        constraintWidget.wrapMeasure[3] = i12;
                        z2 = false;
                        if (dimensionBehaviour4 != dimensionBehaviour3) {
                        }
                        if (dimensionBehaviour5 != dimensionBehaviour3) {
                        }
                        if (dimensionBehaviour5 != dimensionBehaviour2) {
                        }
                        if (dimensionBehaviour4 != dimensionBehaviour2) {
                        }
                        if (!z10) {
                        }
                        if (!z11) {
                        }
                        LayoutParams layoutParams22 = (LayoutParams) view.getLayoutParams();
                        if (!measure.useCurrentDimensions) {
                        }
                        if (view instanceof VirtualLayout) {
                        }
                        view.measure(i2, i3);
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        i4 = view.getBaseline();
                        if (!z) {
                        }
                        if (!z2) {
                        }
                        int i2122 = constraintWidget.mMatchConstraintMinWidth;
                        if (i2122 <= 0) {
                        }
                        i8 = constraintWidget.mMatchConstraintMaxWidth;
                        if (i8 > 0) {
                        }
                        int i2222 = constraintWidget.mMatchConstraintMinHeight;
                        if (i2222 <= 0) {
                        }
                        i9 = constraintWidget.mMatchConstraintMaxHeight;
                        if (i9 > 0) {
                        }
                        if (!z3) {
                        }
                        max2 = (int) ((((float) max) / constraintWidget.mDimensionRatio) + 0.5f);
                        if (measuredWidth == max) {
                        }
                        if (measuredWidth != max) {
                        }
                        if (measuredHeight != max2) {
                        }
                        view.measure(i2, i3);
                        i7 = view.getMeasuredWidth();
                        i6 = view.getMeasuredHeight();
                        i4 = view.getBaseline();
                        i5 = -1;
                        z4 = r17;
                        if (i4 == i5) {
                        }
                        if (i7 == measure.horizontalDimension) {
                        }
                        z5 = true;
                        measure.measuredNeedsSolverPass = z5;
                        if (!layoutParams22.needsBaseline) {
                        }
                        measure.measuredNeedsSolverPass = true;
                        measure.measuredWidth = i7;
                        measure.measuredHeight = i6;
                        measure.measuredHasBaseline = z21;
                        measure.measuredBaseline = i4;
                        return;
                    }
                    i = 2;
                    i2 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                    constraintWidget.wrapMeasure[2] = i11;
                    z = false;
                    ordinal = dimensionBehaviour5.ordinal();
                    if (ordinal == 0) {
                    }
                    z2 = false;
                    if (dimensionBehaviour4 != dimensionBehaviour3) {
                    }
                    if (dimensionBehaviour5 != dimensionBehaviour3) {
                    }
                    if (dimensionBehaviour5 != dimensionBehaviour2) {
                    }
                    if (dimensionBehaviour4 != dimensionBehaviour2) {
                    }
                    if (!z10) {
                    }
                    if (!z11) {
                    }
                    LayoutParams layoutParams222 = (LayoutParams) view.getLayoutParams();
                    if (!measure.useCurrentDimensions) {
                    }
                    if (view instanceof VirtualLayout) {
                    }
                    view.measure(i2, i3);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    i4 = view.getBaseline();
                    if (!z) {
                    }
                    if (!z2) {
                    }
                    int i21222 = constraintWidget.mMatchConstraintMinWidth;
                    if (i21222 <= 0) {
                    }
                    i8 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i8 > 0) {
                    }
                    int i22222 = constraintWidget.mMatchConstraintMinHeight;
                    if (i22222 <= 0) {
                    }
                    i9 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i9 > 0) {
                    }
                    if (!z3) {
                    }
                    max2 = (int) ((((float) max) / constraintWidget.mDimensionRatio) + 0.5f);
                    if (measuredWidth == max) {
                    }
                    if (measuredWidth != max) {
                    }
                    if (measuredHeight != max2) {
                    }
                    view.measure(i2, i3);
                    i7 = view.getMeasuredWidth();
                    i6 = view.getMeasuredHeight();
                    i4 = view.getBaseline();
                    i5 = -1;
                    z4 = r17;
                    if (i4 == i5) {
                    }
                    if (i7 == measure.horizontalDimension) {
                    }
                    z5 = true;
                    measure.measuredNeedsSolverPass = z5;
                    if (!layoutParams222.needsBaseline) {
                    }
                    measure.measuredNeedsSolverPass = true;
                    measure.measuredWidth = i7;
                    measure.measuredHeight = i6;
                    measure.measuredHasBaseline = z21;
                    measure.measuredBaseline = i4;
                    return;
                }
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Measurer measurer = new Measurer(this);
        this.mMeasurer = measurer;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mCompanionWidget = this;
        constraintWidgetContainer.mMeasurer = measurer;
        constraintWidgetContainer.mDependencyGraph.mMeasurer = measurer;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, 0, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0219  */
    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.BASELINE;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
        layoutParams.validate();
        constraintWidget.mVisibility = view.getVisibility();
        if (layoutParams.isInPlaceholder) {
            constraintWidget.inPlaceholder = true;
            constraintWidget.mVisibility = 8;
        }
        constraintWidget.mCompanionWidget = view;
        if (view instanceof ConstraintHelper) {
            boolean z2 = this.mLayoutWidget.mIsRtl;
            Barrier barrier = (Barrier) ((ConstraintHelper) view);
            int i10 = barrier.mIndicatedType;
            barrier.mResolvedType = i10;
            dimensionBehaviour2 = dimensionBehaviour4;
            dimensionBehaviour = dimensionBehaviour5;
            if (z2) {
                if (i10 == 5) {
                    barrier.mResolvedType = 1;
                } else if (i10 == 6) {
                    barrier.mResolvedType = 0;
                }
            } else if (i10 == 5) {
                barrier.mResolvedType = 0;
            } else if (i10 == 6) {
                barrier.mResolvedType = 1;
            }
            if (constraintWidget instanceof Barrier) {
                ((Barrier) constraintWidget).mBarrierType = barrier.mResolvedType;
            }
        } else {
            dimensionBehaviour2 = dimensionBehaviour4;
            dimensionBehaviour = dimensionBehaviour5;
        }
        if (layoutParams.isGuideline) {
            Guideline guideline = (Guideline) constraintWidget;
            int i11 = layoutParams.resolvedGuideBegin;
            int i12 = layoutParams.resolvedGuideEnd;
            float f3 = layoutParams.resolvedGuidePercent;
            int i13 = (f3 > -1.0f ? 1 : (f3 == -1.0f ? 0 : -1));
            if (i13 != 0) {
                if (i13 > 0) {
                    guideline.mRelativePercent = f3;
                    guideline.mRelativeBegin = -1;
                    guideline.mRelativeEnd = -1;
                }
            } else if (i11 != -1) {
                if (i11 > -1) {
                    guideline.mRelativePercent = -1.0f;
                    guideline.mRelativeBegin = i11;
                    guideline.mRelativeEnd = -1;
                }
            } else if (i12 != -1 && i12 > -1) {
                guideline.mRelativePercent = -1.0f;
                guideline.mRelativeBegin = -1;
                guideline.mRelativeEnd = i12;
            }
        } else {
            int i14 = layoutParams.resolvedLeftToLeft;
            int i15 = layoutParams.resolvedLeftToRight;
            int i16 = layoutParams.resolvedRightToLeft;
            int i17 = layoutParams.resolvedRightToRight;
            int i18 = layoutParams.resolveGoneLeftMargin;
            int i19 = layoutParams.resolveGoneRightMargin;
            float f4 = layoutParams.resolvedHorizontalBias;
            int i20 = layoutParams.circleConstraint;
            if (i20 != -1) {
                ConstraintWidget constraintWidget5 = sparseArray.get(i20);
                if (constraintWidget5 != null) {
                    float f5 = layoutParams.circleAngle;
                    int i21 = layoutParams.circleRadius;
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER;
                    constraintWidget.getAnchor(type6).connect(constraintWidget5.getAnchor(type6), i21, 0, true);
                    constraintWidget.mCircleConstraintAngle = f5;
                }
            } else {
                if (i14 != -1) {
                    ConstraintWidget constraintWidget6 = sparseArray.get(i14);
                    if (constraintWidget6 != null) {
                        constraintWidget.getAnchor(type3).connect(constraintWidget6.getAnchor(type3), ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i18, true);
                    }
                } else {
                    i6 = -1;
                    if (i15 != -1) {
                        ConstraintWidget constraintWidget7 = sparseArray.get(i15);
                        if (constraintWidget7 != null) {
                            constraintWidget.getAnchor(type3).connect(constraintWidget7.getAnchor(type2), ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i18, true);
                        }
                    }
                    if (i16 == i6) {
                        ConstraintWidget constraintWidget8 = sparseArray.get(i16);
                        if (constraintWidget8 != null) {
                            constraintWidget.getAnchor(type2).connect(constraintWidget8.getAnchor(type3), ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i19, true);
                        }
                    } else if (!(i17 == i6 || (constraintWidget4 = sparseArray.get(i17)) == null)) {
                        constraintWidget.getAnchor(type2).connect(constraintWidget4.getAnchor(type2), ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i19, true);
                    }
                    i7 = layoutParams.topToTop;
                    if (i7 == -1) {
                        ConstraintWidget constraintWidget9 = sparseArray.get(i7);
                        if (constraintWidget9 != null) {
                            constraintWidget.getAnchor(type5).connect(constraintWidget9.getAnchor(type5), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin, true);
                        }
                    } else {
                        int i22 = layoutParams.topToBottom;
                        if (!(i22 == -1 || (constraintWidget3 = sparseArray.get(i22)) == null)) {
                            constraintWidget.getAnchor(type5).connect(constraintWidget3.getAnchor(type4), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin, true);
                        }
                    }
                    i8 = layoutParams.bottomToTop;
                    if (i8 == -1) {
                        ConstraintWidget constraintWidget10 = sparseArray.get(i8);
                        if (constraintWidget10 != null) {
                            constraintWidget.getAnchor(type4).connect(constraintWidget10.getAnchor(type5), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, true);
                        }
                    } else {
                        int i23 = layoutParams.bottomToBottom;
                        if (!(i23 == -1 || (constraintWidget2 = sparseArray.get(i23)) == null)) {
                            constraintWidget.getAnchor(type4).connect(constraintWidget2.getAnchor(type4), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, true);
                        }
                    }
                    i9 = layoutParams.baselineToBaseline;
                    if (i9 != -1) {
                        View view2 = this.mChildrenByIds.get(i9);
                        ConstraintWidget constraintWidget11 = sparseArray.get(layoutParams.baselineToBaseline);
                        if (!(constraintWidget11 == null || view2 == null || !(view2.getLayoutParams() instanceof LayoutParams))) {
                            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                            layoutParams.needsBaseline = true;
                            layoutParams2.needsBaseline = true;
                            constraintWidget.getAnchor(type).connect(constraintWidget11.getAnchor(type), 0, -1, true);
                            constraintWidget.hasBaseline = true;
                            layoutParams2.widget.hasBaseline = true;
                            constraintWidget.getAnchor(type5).reset();
                            constraintWidget.getAnchor(type4).reset();
                        }
                    }
                    if (f4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        constraintWidget.mHorizontalBiasPercent = f4;
                    }
                    f2 = layoutParams.verticalBias;
                    if (f2 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        constraintWidget.mVerticalBiasPercent = f2;
                    }
                }
                i6 = -1;
                if (i16 == i6) {
                }
                i7 = layoutParams.topToTop;
                if (i7 == -1) {
                }
                i8 = layoutParams.bottomToTop;
                if (i8 == -1) {
                }
                i9 = layoutParams.baselineToBaseline;
                if (i9 != -1) {
                }
                if (f4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                }
                f2 = layoutParams.verticalBias;
                if (f2 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                }
            }
            if (z && !(layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1)) {
                int i24 = layoutParams.editorAbsoluteX;
                int i25 = layoutParams.editorAbsoluteY;
                constraintWidget.mX = i24;
                constraintWidget.mY = i25;
            }
            if (layoutParams.horizontalDimensionFixed) {
                constraintWidget.mListDimensionBehaviors[0] = dimensionBehaviour;
                constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                    constraintWidget.mListDimensionBehaviors[0] = dimensionBehaviour2;
                }
            } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                if (layoutParams.constrainedWidth) {
                    constraintWidget.mListDimensionBehaviors[0] = dimensionBehaviour6;
                } else {
                    constraintWidget.mListDimensionBehaviors[0] = dimensionBehaviour3;
                }
                constraintWidget.getAnchor(type3).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget.getAnchor(type2).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            } else {
                constraintWidget.mListDimensionBehaviors[0] = dimensionBehaviour6;
                constraintWidget.setWidth(0);
            }
            if (!layoutParams.verticalDimensionFixed) {
                i = -1;
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    if (layoutParams.constrainedHeight) {
                        constraintWidget.mListDimensionBehaviors[1] = dimensionBehaviour6;
                    } else {
                        constraintWidget.mListDimensionBehaviors[1] = dimensionBehaviour3;
                    }
                    constraintWidget.getAnchor(type5).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    constraintWidget.getAnchor(type4).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else {
                    constraintWidget.mListDimensionBehaviors[1] = dimensionBehaviour6;
                    constraintWidget.setHeight(0);
                }
            } else {
                i = -1;
                constraintWidget.mListDimensionBehaviors[1] = dimensionBehaviour;
                constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                    constraintWidget.mListDimensionBehaviors[1] = dimensionBehaviour2;
                }
            }
            String str = layoutParams.dimensionRatio;
            if (str == null || str.length() == 0) {
                constraintWidget.mDimensionRatio = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            } else {
                int length = str.length();
                int indexOf = str.indexOf(44);
                if (indexOf <= 0 || indexOf >= length - 1) {
                    i2 = 1;
                    i3 = i;
                    i4 = 0;
                } else {
                    String substring = str.substring(0, indexOf);
                    if (substring.equalsIgnoreCase("W")) {
                        i2 = 1;
                        i5 = 0;
                    } else if (substring.equalsIgnoreCase("H")) {
                        i2 = 1;
                        i5 = 1;
                    } else {
                        i5 = i;
                        i2 = 1;
                    }
                    i4 = indexOf + 1;
                    i3 = i5;
                }
                int indexOf2 = str.indexOf(58);
                if (indexOf2 < 0 || indexOf2 >= length - i2) {
                    String substring2 = str.substring(i4);
                    if (substring2.length() > 0) {
                        f = Float.parseFloat(substring2);
                        if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            constraintWidget.mDimensionRatio = f;
                            constraintWidget.mDimensionRatioSide = i3;
                        }
                    }
                } else {
                    String substring3 = str.substring(i4, indexOf2);
                    String substring4 = str.substring(indexOf2 + i2);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        try {
                            float parseFloat = Float.parseFloat(substring3);
                            float parseFloat2 = Float.parseFloat(substring4);
                            if (parseFloat > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && parseFloat2 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                f = i3 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                                if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                }
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
                f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                }
            }
            float f6 = layoutParams.horizontalWeight;
            float[] fArr = constraintWidget.mWeight;
            fArr[0] = f6;
            fArr[1] = layoutParams.verticalWeight;
            constraintWidget.mHorizontalChainStyle = layoutParams.horizontalChainStyle;
            constraintWidget.mVerticalChainStyle = layoutParams.verticalChainStyle;
            int i26 = layoutParams.matchConstraintDefaultWidth;
            int i27 = layoutParams.matchConstraintMinWidth;
            int i28 = layoutParams.matchConstraintMaxWidth;
            float f7 = layoutParams.matchConstraintPercentWidth;
            constraintWidget.mMatchConstraintDefaultWidth = i26;
            constraintWidget.mMatchConstraintMinWidth = i27;
            if (i28 == Integer.MAX_VALUE) {
                i28 = 0;
            }
            constraintWidget.mMatchConstraintMaxWidth = i28;
            constraintWidget.mMatchConstraintPercentWidth = f7;
            if (f7 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f7 < 1.0f && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                constraintWidget.mMatchConstraintDefaultWidth = 2;
            }
            int i29 = layoutParams.matchConstraintDefaultHeight;
            int i30 = layoutParams.matchConstraintMinHeight;
            int i31 = layoutParams.matchConstraintMaxHeight;
            float f8 = layoutParams.matchConstraintPercentHeight;
            constraintWidget.mMatchConstraintDefaultHeight = i29;
            constraintWidget.mMatchConstraintMinHeight = i30;
            constraintWidget.mMatchConstraintMaxHeight = i31 == Integer.MAX_VALUE ? 0 : i31;
            constraintWidget.mMatchConstraintPercentHeight = f8;
            if (f8 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f8 < 1.0f && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                constraintWidget.mMatchConstraintDefaultHeight = 2;
            }
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).updatePreDraw();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = (float) i3;
                        float f2 = (float) i4;
                        float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public void forceLayout() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.mOptimizationLevel;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    public boolean isRtl() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x;
                int height = constraintWidget.getHeight() + y;
                childAt.layout(x, y, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x, y, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0587  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0757  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x07a0  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x07a9  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0427 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0199  */
    public void onMeasure(int i, int i2) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i3;
        int i4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        int i5;
        int i6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        BasicMeasure basicMeasure;
        boolean z;
        int i7;
        int i8;
        BasicMeasure.Measurer measurer;
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        boolean z2;
        int i9;
        boolean z3;
        boolean z4;
        int size;
        int i10;
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z5;
        int i11;
        ConstraintWidgetContainer constraintWidgetContainer2;
        int i12;
        ConstraintWidgetContainer constraintWidgetContainer3;
        int i13;
        int i14;
        BasicMeasure.Measurer measurer2;
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        int i15;
        int i16;
        int i17;
        boolean z6;
        int i18;
        int i19;
        boolean z7;
        Iterator<WidgetRun> it;
        Iterator<WidgetRun> it2;
        boolean z8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        int i20;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        this.mLayoutWidget.mIsRtl = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutWidget;
                BasicMeasure basicMeasure2 = constraintWidgetContainer4.mBasicMeasureSolver;
                basicMeasure2.mVariableDimensionsWidgets.clear();
                int size2 = constraintWidgetContainer4.mChildren.size();
                for (int i21 = 0; i21 < size2; i21++) {
                    ConstraintWidget constraintWidget = constraintWidgetContainer4.mChildren.get(i21);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour6 || constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour5 || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour6 || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour5) {
                        basicMeasure2.mVariableDimensionsWidgets.add(constraintWidget);
                    }
                }
                constraintWidgetContainer4.invalidateGraph();
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer5 = this.mLayoutWidget;
        int i22 = this.mOptimizationLevel;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        int mode = View.MeasureSpec.getMode(i);
        int size3 = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i23 = max + max2;
        int paddingWidth = getPaddingWidth();
        Measurer measurer3 = this.mMeasurer;
        measurer3.paddingTop = max;
        measurer3.paddingBottom = max2;
        measurer3.paddingWidth = paddingWidth;
        measurer3.paddingHeight = i23;
        measurer3.layoutWidthSpec = i;
        measurer3.layoutHeightSpec = i2;
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max3 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            max3 = max4;
        }
        int i24 = size3 - paddingWidth;
        int i25 = size4 - i23;
        Measurer measurer4 = this.mMeasurer;
        int i26 = measurer4.paddingHeight;
        int i27 = measurer4.paddingWidth;
        int childCount = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    dimensionBehaviour2 = dimensionBehaviour7;
                    i3 = 0;
                } else {
                    dimensionBehaviour = dimensionBehaviour8;
                    i4 = Integer.MIN_VALUE;
                    i3 = Math.min(this.mMaxWidth - i27, i24);
                    dimensionBehaviour2 = dimensionBehaviour7;
                    if (mode2 != i4) {
                        if (mode2 != 0) {
                            if (mode2 != 1073741824) {
                                dimensionBehaviour3 = dimensionBehaviour7;
                                i6 = 0;
                            } else {
                                i6 = Math.min(this.mMaxHeight - i26, i25);
                                i5 = i25;
                                dimensionBehaviour3 = dimensionBehaviour7;
                                if (!(i3 == constraintWidgetContainer5.getWidth() && i6 == constraintWidgetContainer5.getHeight())) {
                                    constraintWidgetContainer5.mDependencyGraph.mNeedRedoMeasures = true;
                                }
                                constraintWidgetContainer5.mX = 0;
                                constraintWidgetContainer5.mY = 0;
                                int[] iArr = constraintWidgetContainer5.mMaxDimension;
                                iArr[0] = this.mMaxWidth - i27;
                                iArr[1] = this.mMaxHeight - i26;
                                constraintWidgetContainer5.setMinWidth(0);
                                constraintWidgetContainer5.setMinHeight(0);
                                constraintWidgetContainer5.mListDimensionBehaviors[0] = dimensionBehaviour2;
                                constraintWidgetContainer5.setWidth(i3);
                                constraintWidgetContainer5.mListDimensionBehaviors[1] = dimensionBehaviour3;
                                constraintWidgetContainer5.setHeight(i6);
                                constraintWidgetContainer5.setMinWidth(this.mMinWidth - i27);
                                constraintWidgetContainer5.setMinHeight(this.mMinHeight - i26);
                                constraintWidgetContainer5.mPaddingLeft = max3;
                                constraintWidgetContainer5.mPaddingTop = max;
                                basicMeasure = constraintWidgetContainer5.mBasicMeasureSolver;
                                if (basicMeasure != null) {
                                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BOTTOM;
                                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.RIGHT;
                                    BasicMeasure.Measurer measurer5 = constraintWidgetContainer5.mMeasurer;
                                    int size5 = constraintWidgetContainer5.mChildren.size();
                                    int width = constraintWidgetContainer5.getWidth();
                                    int height = constraintWidgetContainer5.getHeight();
                                    boolean enabled = Optimizer.enabled(i22, 128);
                                    boolean z9 = enabled || Optimizer.enabled(i22, 64);
                                    if (z9) {
                                        int i28 = 0;
                                        while (true) {
                                            if (i28 >= size5) {
                                                break;
                                            }
                                            ConstraintWidget constraintWidget2 = constraintWidgetContainer5.mChildren.get(i28);
                                            boolean z10 = (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour6) && (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour6) && constraintWidget2.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                                            if ((!constraintWidget2.isInHorizontalChain() || !z10) && ((!constraintWidget2.isInVerticalChain() || !z10) && !(constraintWidget2 instanceof VirtualLayout) && !constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVerticalChain())) {
                                                i28++;
                                                z9 = z9;
                                            }
                                        }
                                        i7 = 1073741824;
                                        z = false;
                                        if (!z || !((mode != i7 && mode2 == i7) || enabled)) {
                                            int min = Math.min(constraintWidgetContainer5.mMaxDimension[0], i24);
                                            int min2 = Math.min(constraintWidgetContainer5.mMaxDimension[1], i5);
                                            if (mode == 1073741824) {
                                                if (constraintWidgetContainer5.getWidth() != min) {
                                                    constraintWidgetContainer5.setWidth(min);
                                                    constraintWidgetContainer5.invalidateGraph();
                                                }
                                                i15 = 1073741824;
                                            } else {
                                                i15 = 1073741824;
                                            }
                                            if (mode2 == i15 && constraintWidgetContainer5.getHeight() != min2) {
                                                constraintWidgetContainer5.setHeight(min2);
                                                constraintWidgetContainer5.invalidateGraph();
                                            }
                                            if (mode == i15 && mode2 == i15) {
                                                DependencyGraph dependencyGraph = constraintWidgetContainer5.mDependencyGraph;
                                                boolean z11 = enabled & true;
                                                if (dependencyGraph.mNeedBuildGraph || dependencyGraph.mNeedRedoMeasures) {
                                                    for (Iterator<ConstraintWidget> it3 = dependencyGraph.container.mChildren.iterator(); it3.hasNext(); it3 = it3) {
                                                        ConstraintWidget next = it3.next();
                                                        next.measured = false;
                                                        next.horizontalRun.reset();
                                                        next.verticalRun.reset();
                                                    }
                                                    ConstraintWidgetContainer constraintWidgetContainer6 = dependencyGraph.container;
                                                    i19 = 0;
                                                    constraintWidgetContainer6.measured = false;
                                                    constraintWidgetContainer6.horizontalRun.reset();
                                                    dependencyGraph.container.verticalRun.reset();
                                                    dependencyGraph.mNeedRedoMeasures = false;
                                                } else {
                                                    i19 = 0;
                                                }
                                                dependencyGraph.basicMeasureWidgets(dependencyGraph.mContainer);
                                                ConstraintWidgetContainer constraintWidgetContainer7 = dependencyGraph.container;
                                                constraintWidgetContainer7.mX = i19;
                                                constraintWidgetContainer7.mY = i19;
                                                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = constraintWidgetContainer7.getDimensionBehaviour(i19);
                                                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dependencyGraph.container.getDimensionBehaviour(1);
                                                if (dependencyGraph.mNeedBuildGraph) {
                                                    dependencyGraph.buildGraph();
                                                }
                                                int x = dependencyGraph.container.getX();
                                                type2 = type5;
                                                int y = dependencyGraph.container.getY();
                                                type = type6;
                                                dependencyGraph.container.horizontalRun.start.resolve(x);
                                                dependencyGraph.container.verticalRun.start.resolve(y);
                                                dependencyGraph.measureWidgets();
                                                if (dimensionBehaviour9 == dimensionBehaviour || dimensionBehaviour10 == dimensionBehaviour) {
                                                    boolean z12 = z11;
                                                    if (z11) {
                                                        Iterator<WidgetRun> it4 = dependencyGraph.mRuns.iterator();
                                                        while (true) {
                                                            if (it4.hasNext()) {
                                                                if (!it4.next().supportsWrapComputation()) {
                                                                    z12 = false;
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (!z12 || dimensionBehaviour9 != dimensionBehaviour) {
                                                        measurer = measurer5;
                                                        i8 = width;
                                                    } else {
                                                        ConstraintWidgetContainer constraintWidgetContainer8 = dependencyGraph.container;
                                                        measurer = measurer5;
                                                        i8 = width;
                                                        constraintWidgetContainer8.mListDimensionBehaviors[0] = dimensionBehaviour7;
                                                        constraintWidgetContainer8.setWidth(dependencyGraph.computeWrap(constraintWidgetContainer8, 0));
                                                        ConstraintWidgetContainer constraintWidgetContainer9 = dependencyGraph.container;
                                                        constraintWidgetContainer9.horizontalRun.dimension.resolve(constraintWidgetContainer9.getWidth());
                                                    }
                                                    if (z12 && dimensionBehaviour10 == dimensionBehaviour) {
                                                        ConstraintWidgetContainer constraintWidgetContainer10 = dependencyGraph.container;
                                                        constraintWidgetContainer10.mListDimensionBehaviors[1] = dimensionBehaviour7;
                                                        constraintWidgetContainer10.setHeight(dependencyGraph.computeWrap(constraintWidgetContainer10, 1));
                                                        ConstraintWidgetContainer constraintWidgetContainer11 = dependencyGraph.container;
                                                        constraintWidgetContainer11.verticalRun.dimension.resolve(constraintWidgetContainer11.getHeight());
                                                    }
                                                } else {
                                                    measurer = measurer5;
                                                    i8 = width;
                                                }
                                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dependencyGraph.container.mListDimensionBehaviors;
                                                dimensionBehaviour = dimensionBehaviour;
                                                if (dimensionBehaviourArr[0] != dimensionBehaviour7) {
                                                    dimensionBehaviour4 = dimensionBehaviour5;
                                                    if (dimensionBehaviourArr[0] != dimensionBehaviour4) {
                                                        z7 = false;
                                                        it = dependencyGraph.mRuns.iterator();
                                                        while (it.hasNext()) {
                                                            WidgetRun next2 = it.next();
                                                            if (next2.widget != dependencyGraph.container || next2.resolved) {
                                                                next2.applyToWidget();
                                                            }
                                                        }
                                                        it2 = dependencyGraph.mRuns.iterator();
                                                        while (true) {
                                                            if (it2.hasNext()) {
                                                                z8 = true;
                                                                break;
                                                            }
                                                            WidgetRun next3 = it2.next();
                                                            if ((z7 || next3.widget != dependencyGraph.container) && (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference))))) {
                                                                z8 = false;
                                                            }
                                                        }
                                                        z8 = false;
                                                        dependencyGraph.container.setHorizontalDimensionBehaviour(dimensionBehaviour9);
                                                        dependencyGraph.container.setVerticalDimensionBehaviour(dimensionBehaviour10);
                                                        z2 = z8;
                                                        i16 = 1073741824;
                                                        i9 = 2;
                                                    }
                                                } else {
                                                    dimensionBehaviour4 = dimensionBehaviour5;
                                                }
                                                int width2 = dependencyGraph.container.getWidth() + x;
                                                dependencyGraph.container.horizontalRun.end.resolve(width2);
                                                dependencyGraph.container.horizontalRun.dimension.resolve(width2 - x);
                                                dependencyGraph.measureWidgets();
                                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dependencyGraph.container.mListDimensionBehaviors;
                                                if (dimensionBehaviourArr2[1] == dimensionBehaviour7 || dimensionBehaviourArr2[1] == dimensionBehaviour4) {
                                                    int height2 = dependencyGraph.container.getHeight() + y;
                                                    dependencyGraph.container.verticalRun.end.resolve(height2);
                                                    dependencyGraph.container.verticalRun.dimension.resolve(height2 - y);
                                                }
                                                dependencyGraph.measureWidgets();
                                                z7 = true;
                                                it = dependencyGraph.mRuns.iterator();
                                                while (it.hasNext()) {
                                                }
                                                it2 = dependencyGraph.mRuns.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                    }
                                                }
                                                z8 = false;
                                                dependencyGraph.container.setHorizontalDimensionBehaviour(dimensionBehaviour9);
                                                dependencyGraph.container.setVerticalDimensionBehaviour(dimensionBehaviour10);
                                                z2 = z8;
                                                i16 = 1073741824;
                                                i9 = 2;
                                            } else {
                                                type2 = type5;
                                                type = type6;
                                                measurer = measurer5;
                                                i8 = width;
                                                DependencyGraph dependencyGraph2 = constraintWidgetContainer5.mDependencyGraph;
                                                if (dependencyGraph2.mNeedBuildGraph) {
                                                    Iterator<ConstraintWidget> it5 = dependencyGraph2.container.mChildren.iterator();
                                                    while (it5.hasNext()) {
                                                        ConstraintWidget next4 = it5.next();
                                                        next4.measured = false;
                                                        HorizontalWidgetRun horizontalWidgetRun = next4.horizontalRun;
                                                        horizontalWidgetRun.dimension.resolved = false;
                                                        horizontalWidgetRun.resolved = false;
                                                        horizontalWidgetRun.reset();
                                                        VerticalWidgetRun verticalWidgetRun = next4.verticalRun;
                                                        verticalWidgetRun.dimension.resolved = false;
                                                        verticalWidgetRun.resolved = false;
                                                        verticalWidgetRun.reset();
                                                    }
                                                    i17 = 0;
                                                    ConstraintWidgetContainer constraintWidgetContainer12 = dependencyGraph2.container;
                                                    constraintWidgetContainer12.measured = false;
                                                    HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer12.horizontalRun;
                                                    horizontalWidgetRun2.dimension.resolved = false;
                                                    horizontalWidgetRun2.resolved = false;
                                                    horizontalWidgetRun2.reset();
                                                    VerticalWidgetRun verticalWidgetRun2 = dependencyGraph2.container.verticalRun;
                                                    verticalWidgetRun2.dimension.resolved = false;
                                                    verticalWidgetRun2.resolved = false;
                                                    verticalWidgetRun2.reset();
                                                    dependencyGraph2.buildGraph();
                                                } else {
                                                    i17 = 0;
                                                }
                                                dependencyGraph2.basicMeasureWidgets(dependencyGraph2.mContainer);
                                                ConstraintWidgetContainer constraintWidgetContainer13 = dependencyGraph2.container;
                                                constraintWidgetContainer13.mX = i17;
                                                constraintWidgetContainer13.mY = i17;
                                                constraintWidgetContainer13.horizontalRun.start.resolve(i17);
                                                dependencyGraph2.container.verticalRun.start.resolve(i17);
                                                i16 = 1073741824;
                                                if (mode == 1073741824) {
                                                    i18 = 1;
                                                    i9 = 1;
                                                    z6 = constraintWidgetContainer5.directMeasureWithOrientation(enabled, i17) & true;
                                                } else {
                                                    i18 = 1;
                                                    z6 = true;
                                                    i9 = 0;
                                                }
                                                if (mode2 == 1073741824) {
                                                    z2 = z6 & constraintWidgetContainer5.directMeasureWithOrientation(enabled, i18);
                                                    i9++;
                                                } else {
                                                    z2 = z6;
                                                }
                                            }
                                            if (z2) {
                                                constraintWidgetContainer5.updateFromRuns(mode == i16, mode2 == i16);
                                            }
                                        } else {
                                            type2 = type5;
                                            type = type6;
                                            measurer = measurer5;
                                            i8 = width;
                                            i9 = 0;
                                            z2 = false;
                                        }
                                        if (!z2 || i9 != 2) {
                                            if (size5 > 0) {
                                                int size6 = constraintWidgetContainer5.mChildren.size();
                                                BasicMeasure.Measurer measurer6 = constraintWidgetContainer5.mMeasurer;
                                                for (int i29 = 0; i29 < size6; i29++) {
                                                    ConstraintWidget constraintWidget3 = constraintWidgetContainer5.mChildren.get(i29);
                                                    if (!(constraintWidget3 instanceof Guideline) && (!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved)) {
                                                        if (!(constraintWidget3.getDimensionBehaviour(0) == dimensionBehaviour6 && constraintWidget3.mMatchConstraintDefaultWidth != 1 && constraintWidget3.getDimensionBehaviour(1) == dimensionBehaviour6 && constraintWidget3.mMatchConstraintDefaultHeight != 1)) {
                                                            basicMeasure.measure(measurer6, constraintWidget3, false);
                                                        }
                                                    }
                                                }
                                                Measurer measurer7 = (Measurer) measurer6;
                                                int childCount2 = measurer7.layout.getChildCount();
                                                for (int i30 = 0; i30 < childCount2; i30++) {
                                                    View childAt = measurer7.layout.getChildAt(i30);
                                                    if (childAt instanceof Placeholder) {
                                                        ((Placeholder) childAt).updatePostMeasure();
                                                    }
                                                }
                                                int size7 = measurer7.layout.mConstraintHelpers.size();
                                                if (size7 > 0) {
                                                    for (int i31 = 0; i31 < size7; i31++) {
                                                        measurer7.layout.mConstraintHelpers.get(i31).updatePostMeasure();
                                                    }
                                                }
                                            }
                                            int i32 = constraintWidgetContainer5.mOptimizationLevel;
                                            size = basicMeasure.mVariableDimensionsWidgets.size();
                                            int i33 = i8;
                                            if (size5 > 0) {
                                                basicMeasure.solveLinearSystem(constraintWidgetContainer5, i33, height);
                                            }
                                            if (size <= 0) {
                                                boolean z13 = constraintWidgetContainer5.getHorizontalDimensionBehaviour() == dimensionBehaviour;
                                                boolean z14 = constraintWidgetContainer5.getVerticalDimensionBehaviour() == dimensionBehaviour;
                                                int max5 = Math.max(constraintWidgetContainer5.getWidth(), basicMeasure.constraintWidgetContainer.mMinWidth);
                                                int max6 = Math.max(constraintWidgetContainer5.getHeight(), basicMeasure.constraintWidgetContainer.mMinHeight);
                                                int i34 = 0;
                                                boolean z15 = false;
                                                while (i34 < size) {
                                                    ConstraintWidget constraintWidget4 = basicMeasure.mVariableDimensionsWidgets.get(i34);
                                                    if (!(constraintWidget4 instanceof VirtualLayout)) {
                                                        i14 = i32;
                                                        type3 = type2;
                                                        type4 = type;
                                                        measurer2 = measurer;
                                                    } else {
                                                        int width3 = constraintWidget4.getWidth();
                                                        int height3 = constraintWidget4.getHeight();
                                                        i14 = i32;
                                                        measurer2 = measurer;
                                                        boolean measure = z15 | basicMeasure.measure(measurer2, constraintWidget4, true);
                                                        int width4 = constraintWidget4.getWidth();
                                                        boolean z16 = measure;
                                                        int height4 = constraintWidget4.getHeight();
                                                        if (width4 != width3) {
                                                            constraintWidget4.setWidth(width4);
                                                            if (!z13 || constraintWidget4.getRight() <= max5) {
                                                                type4 = type;
                                                            } else {
                                                                type4 = type;
                                                                max5 = Math.max(max5, constraintWidget4.getAnchor(type4).getMargin() + constraintWidget4.getRight());
                                                            }
                                                            z16 = true;
                                                        } else {
                                                            type4 = type;
                                                        }
                                                        if (height4 != height3) {
                                                            constraintWidget4.setHeight(height4);
                                                            if (!z14 || constraintWidget4.getBottom() <= max6) {
                                                                type3 = type2;
                                                            } else {
                                                                type3 = type2;
                                                                max6 = Math.max(max6, constraintWidget4.getAnchor(type3).getMargin() + constraintWidget4.getBottom());
                                                            }
                                                            z16 = true;
                                                        } else {
                                                            type3 = type2;
                                                        }
                                                        z15 = ((VirtualLayout) constraintWidget4).mNeedsCallFromSolver | z16;
                                                    }
                                                    i34++;
                                                    type = type4;
                                                    type2 = type3;
                                                    measurer = measurer2;
                                                    i32 = i14;
                                                }
                                                i10 = i32;
                                                int i35 = 0;
                                                int i36 = 2;
                                                while (i35 < i36) {
                                                    boolean z17 = z15;
                                                    int i37 = 0;
                                                    while (i37 < size) {
                                                        ConstraintWidget constraintWidget5 = basicMeasure.mVariableDimensionsWidgets.get(i37);
                                                        if ((!(constraintWidget5 instanceof Helper) || (constraintWidget5 instanceof VirtualLayout)) && !(constraintWidget5 instanceof Guideline)) {
                                                            i13 = i35;
                                                            if (constraintWidget5.mVisibility != 8 && ((!constraintWidget5.horizontalRun.dimension.resolved || !constraintWidget5.verticalRun.dimension.resolved) && !(constraintWidget5 instanceof VirtualLayout))) {
                                                                int width5 = constraintWidget5.getWidth();
                                                                int height5 = constraintWidget5.getHeight();
                                                                i12 = i33;
                                                                int i38 = constraintWidget5.mBaselineDistance;
                                                                constraintWidgetContainer3 = constraintWidgetContainer5;
                                                                boolean measure2 = z17 | basicMeasure.measure(measurer, constraintWidget5, true);
                                                                int width6 = constraintWidget5.getWidth();
                                                                int height6 = constraintWidget5.getHeight();
                                                                if (width6 != width5) {
                                                                    constraintWidget5.setWidth(width6);
                                                                    if (z13 && constraintWidget5.getRight() > max5) {
                                                                        max5 = Math.max(max5, constraintWidget5.getAnchor(type).getMargin() + constraintWidget5.getRight());
                                                                    }
                                                                    measure2 = true;
                                                                }
                                                                if (height6 != height5) {
                                                                    constraintWidget5.setHeight(height6);
                                                                    if (z14 && constraintWidget5.getBottom() > max6) {
                                                                        max6 = Math.max(max6, constraintWidget5.getAnchor(type2).getMargin() + constraintWidget5.getBottom());
                                                                    }
                                                                    measure2 = true;
                                                                }
                                                                if (!constraintWidget5.hasBaseline || i38 == constraintWidget5.mBaselineDistance) {
                                                                    z17 = measure2;
                                                                    i37++;
                                                                    size = size;
                                                                    i35 = i13;
                                                                    constraintWidgetContainer5 = constraintWidgetContainer3;
                                                                    i33 = i12;
                                                                } else {
                                                                    z17 = true;
                                                                    i37++;
                                                                    size = size;
                                                                    i35 = i13;
                                                                    constraintWidgetContainer5 = constraintWidgetContainer3;
                                                                    i33 = i12;
                                                                }
                                                            }
                                                        } else {
                                                            i13 = i35;
                                                        }
                                                        i12 = i33;
                                                        constraintWidgetContainer3 = constraintWidgetContainer5;
                                                        i37++;
                                                        size = size;
                                                        i35 = i13;
                                                        constraintWidgetContainer5 = constraintWidgetContainer3;
                                                        i33 = i12;
                                                    }
                                                    if (z17) {
                                                        constraintWidgetContainer2 = constraintWidgetContainer5;
                                                        i11 = i33;
                                                        basicMeasure.solveLinearSystem(constraintWidgetContainer2, i11, height);
                                                        z15 = false;
                                                    } else {
                                                        constraintWidgetContainer2 = constraintWidgetContainer5;
                                                        i11 = i33;
                                                        z15 = z17;
                                                    }
                                                    constraintWidgetContainer5 = constraintWidgetContainer2;
                                                    i35++;
                                                    i36 = 2;
                                                    i33 = i11;
                                                    size = size;
                                                }
                                                constraintWidgetContainer = constraintWidgetContainer5;
                                                if (z15) {
                                                    basicMeasure.solveLinearSystem(constraintWidgetContainer, i33, height);
                                                    if (constraintWidgetContainer.getWidth() < max5) {
                                                        constraintWidgetContainer.setWidth(max5);
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (constraintWidgetContainer.getHeight() < max6) {
                                                        constraintWidgetContainer.setHeight(max6);
                                                        z5 = true;
                                                    }
                                                    if (z5) {
                                                        basicMeasure.solveLinearSystem(constraintWidgetContainer, i33, height);
                                                    }
                                                }
                                            } else {
                                                i10 = i32;
                                                constraintWidgetContainer = constraintWidgetContainer5;
                                            }
                                            constraintWidgetContainer.setOptimizationLevel(i10);
                                        }
                                        int width7 = this.mLayoutWidget.getWidth();
                                        int height7 = this.mLayoutWidget.getHeight();
                                        ConstraintWidgetContainer constraintWidgetContainer14 = this.mLayoutWidget;
                                        z3 = constraintWidgetContainer14.mWidthMeasuredTooSmall;
                                        z4 = constraintWidgetContainer14.mHeightMeasuredTooSmall;
                                        Measurer measurer8 = this.mMeasurer;
                                        int i39 = measurer8.paddingHeight;
                                        int min3 = Math.min(this.mMaxWidth, ViewGroup.resolveSizeAndState(width7 + measurer8.paddingWidth, i, 0) & 16777215);
                                        int min4 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(height7 + i39, i2, 0) & 16777215);
                                        if (z3) {
                                            min3 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                                        }
                                        if (z4) {
                                            min4 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                                        }
                                        setMeasuredDimension(min3, min4);
                                        this.mLastMeasureWidth = min3;
                                        this.mLastMeasureHeight = min4;
                                        return;
                                    }
                                    z = z9;
                                    i7 = 1073741824;
                                    if (!z || !((mode != i7 && mode2 == i7) || enabled)) {
                                    }
                                    if (size5 > 0) {
                                    }
                                    int i322 = constraintWidgetContainer5.mOptimizationLevel;
                                    size = basicMeasure.mVariableDimensionsWidgets.size();
                                    int i332 = i8;
                                    if (size5 > 0) {
                                    }
                                    if (size <= 0) {
                                    }
                                    constraintWidgetContainer.setOptimizationLevel(i10);
                                    int width72 = this.mLayoutWidget.getWidth();
                                    int height72 = this.mLayoutWidget.getHeight();
                                    ConstraintWidgetContainer constraintWidgetContainer142 = this.mLayoutWidget;
                                    z3 = constraintWidgetContainer142.mWidthMeasuredTooSmall;
                                    z4 = constraintWidgetContainer142.mHeightMeasuredTooSmall;
                                    Measurer measurer82 = this.mMeasurer;
                                    int i392 = measurer82.paddingHeight;
                                    int min32 = Math.min(this.mMaxWidth, ViewGroup.resolveSizeAndState(width72 + measurer82.paddingWidth, i, 0) & 16777215);
                                    int min42 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(height72 + i392, i2, 0) & 16777215);
                                    if (z3) {
                                    }
                                    if (z4) {
                                    }
                                    setMeasuredDimension(min32, min42);
                                    this.mLastMeasureWidth = min32;
                                    this.mLastMeasureHeight = min42;
                                    return;
                                }
                                throw null;
                            }
                        } else if (childCount == 0) {
                            i5 = i25;
                            i6 = Math.max(0, this.mMinHeight);
                        } else {
                            i6 = 0;
                            dimensionBehaviour3 = dimensionBehaviour;
                        }
                        i5 = i25;
                        constraintWidgetContainer5.mDependencyGraph.mNeedRedoMeasures = true;
                        constraintWidgetContainer5.mX = 0;
                        constraintWidgetContainer5.mY = 0;
                        int[] iArr2 = constraintWidgetContainer5.mMaxDimension;
                        iArr2[0] = this.mMaxWidth - i27;
                        iArr2[1] = this.mMaxHeight - i26;
                        constraintWidgetContainer5.setMinWidth(0);
                        constraintWidgetContainer5.setMinHeight(0);
                        constraintWidgetContainer5.mListDimensionBehaviors[0] = dimensionBehaviour2;
                        constraintWidgetContainer5.setWidth(i3);
                        constraintWidgetContainer5.mListDimensionBehaviors[1] = dimensionBehaviour3;
                        constraintWidgetContainer5.setHeight(i6);
                        constraintWidgetContainer5.setMinWidth(this.mMinWidth - i27);
                        constraintWidgetContainer5.setMinHeight(this.mMinHeight - i26);
                        constraintWidgetContainer5.mPaddingLeft = max3;
                        constraintWidgetContainer5.mPaddingTop = max;
                        basicMeasure = constraintWidgetContainer5.mBasicMeasureSolver;
                        if (basicMeasure != null) {
                        }
                    } else if (childCount == 0) {
                        i6 = Math.max(0, this.mMinHeight);
                        i5 = i25;
                    } else {
                        i6 = i25;
                        i5 = i6;
                    }
                    dimensionBehaviour3 = dimensionBehaviour;
                    constraintWidgetContainer5.mDependencyGraph.mNeedRedoMeasures = true;
                    constraintWidgetContainer5.mX = 0;
                    constraintWidgetContainer5.mY = 0;
                    int[] iArr22 = constraintWidgetContainer5.mMaxDimension;
                    iArr22[0] = this.mMaxWidth - i27;
                    iArr22[1] = this.mMaxHeight - i26;
                    constraintWidgetContainer5.setMinWidth(0);
                    constraintWidgetContainer5.setMinHeight(0);
                    constraintWidgetContainer5.mListDimensionBehaviors[0] = dimensionBehaviour2;
                    constraintWidgetContainer5.setWidth(i3);
                    constraintWidgetContainer5.mListDimensionBehaviors[1] = dimensionBehaviour3;
                    constraintWidgetContainer5.setHeight(i6);
                    constraintWidgetContainer5.setMinWidth(this.mMinWidth - i27);
                    constraintWidgetContainer5.setMinHeight(this.mMinHeight - i26);
                    constraintWidgetContainer5.mPaddingLeft = max3;
                    constraintWidgetContainer5.mPaddingTop = max;
                    basicMeasure = constraintWidgetContainer5.mBasicMeasureSolver;
                    if (basicMeasure != null) {
                    }
                }
            } else if (childCount == 0) {
                i20 = Math.max(0, this.mMinWidth);
            } else {
                i3 = 0;
                dimensionBehaviour2 = dimensionBehaviour8;
            }
            dimensionBehaviour = dimensionBehaviour8;
            i4 = RecyclerView.UNDEFINED_DURATION;
            if (mode2 != i4) {
            }
            dimensionBehaviour3 = dimensionBehaviour;
            constraintWidgetContainer5.mDependencyGraph.mNeedRedoMeasures = true;
            constraintWidgetContainer5.mX = 0;
            constraintWidgetContainer5.mY = 0;
            int[] iArr222 = constraintWidgetContainer5.mMaxDimension;
            iArr222[0] = this.mMaxWidth - i27;
            iArr222[1] = this.mMaxHeight - i26;
            constraintWidgetContainer5.setMinWidth(0);
            constraintWidgetContainer5.setMinHeight(0);
            constraintWidgetContainer5.mListDimensionBehaviors[0] = dimensionBehaviour2;
            constraintWidgetContainer5.setWidth(i3);
            constraintWidgetContainer5.mListDimensionBehaviors[1] = dimensionBehaviour3;
            constraintWidgetContainer5.setHeight(i6);
            constraintWidgetContainer5.setMinWidth(this.mMinWidth - i27);
            constraintWidgetContainer5.setMinHeight(this.mMinHeight - i26);
            constraintWidgetContainer5.mPaddingLeft = max3;
            constraintWidgetContainer5.mPaddingTop = max;
            basicMeasure = constraintWidgetContainer5.mBasicMeasureSolver;
            if (basicMeasure != null) {
            }
        } else {
            i20 = childCount == 0 ? Math.max(0, this.mMinWidth) : i24;
        }
        i3 = i20;
        dimensionBehaviour2 = dimensionBehaviour8;
        dimensionBehaviour = dimensionBehaviour2;
        i4 = RecyclerView.UNDEFINED_DURATION;
        if (mode2 != i4) {
        }
        dimensionBehaviour3 = dimensionBehaviour;
        constraintWidgetContainer5.mDependencyGraph.mNeedRedoMeasures = true;
        constraintWidgetContainer5.mX = 0;
        constraintWidgetContainer5.mY = 0;
        int[] iArr2222 = constraintWidgetContainer5.mMaxDimension;
        iArr2222[0] = this.mMaxWidth - i27;
        iArr2222[1] = this.mMaxHeight - i26;
        constraintWidgetContainer5.setMinWidth(0);
        constraintWidgetContainer5.setMinHeight(0);
        constraintWidgetContainer5.mListDimensionBehaviors[0] = dimensionBehaviour2;
        constraintWidgetContainer5.setWidth(i3);
        constraintWidgetContainer5.mListDimensionBehaviors[1] = dimensionBehaviour3;
        constraintWidgetContainer5.setHeight(i6);
        constraintWidgetContainer5.setMinWidth(this.mMinWidth - i27);
        constraintWidgetContainer5.setMinHeight(this.mMinHeight - i26);
        constraintWidgetContainer5.mPaddingLeft = max3;
        constraintWidgetContainer5.mPaddingTop = max;
        basicMeasure = constraintWidgetContainer5.mBasicMeasureSolver;
        if (basicMeasure != null) {
        }
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.mChildren.remove(viewWidget);
        viewWidget.mParent = null;
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        super.requestLayout();
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(ColorPropConverter.PATH_DELIMITER);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null && constraintLayoutStates == null) {
            throw null;
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        this.mLayoutWidget.mOptimizationLevel = i;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(i, 256);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final boolean updateHierarchy() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        String str;
        int findId;
        int i3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        NoSuchMethodException e;
        IllegalAccessException e2;
        InvocationTargetException e3;
        String str2;
        ConstraintWidget constraintWidget;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i = 1;
            if (i7 >= childCount) {
                z = false;
                break;
            } else if (getChildAt(i7).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i7++;
            }
        }
        if (!z) {
            return z;
        }
        boolean isInEditMode = isInEditMode();
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i8));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        int i9 = -1;
        if (isInEditMode) {
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt = getChildAt(i10);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    int id = childAt.getId();
                    if (id == 0) {
                        constraintWidget = this.mLayoutWidget;
                    } else {
                        View view = this.mChildrenByIds.get(id);
                        if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
                            onViewAdded(view);
                        }
                        constraintWidget = view == this ? this.mLayoutWidget : view == null ? null : ((LayoutParams) view.getLayoutParams()).widget;
                    }
                    constraintWidget.mDebugName = resourceName;
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            int childCount3 = getChildCount();
            HashSet hashSet = new HashSet(constraintSet.mConstraints.keySet());
            while (i6 < childCount3) {
                View childAt3 = getChildAt(i6);
                int id2 = childAt3.getId();
                if (!constraintSet.mConstraints.containsKey(Integer.valueOf(id2))) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("id unknown ");
                    try {
                        str2 = childAt3.getContext().getResources().getResourceEntryName(childAt3.getId());
                    } catch (Exception unused2) {
                        str2 = "UNKNOWN";
                    }
                    outline15.append(str2);
                    Log.w("ConstraintSet", outline15.toString());
                } else if (constraintSet.mForceId && id2 == i9) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                } else if (id2 != i9 && constraintSet.mConstraints.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    ConstraintSet.Constraint constraint = constraintSet.mConstraints.get(Integer.valueOf(id2));
                    if (childAt3 instanceof Barrier) {
                        constraint.layout.mHelperType = i;
                    }
                    int i12 = constraint.layout.mHelperType;
                    if (i12 != i9 && i12 == i) {
                        Barrier barrier = (Barrier) childAt3;
                        barrier.setId(id2);
                        barrier.setType(constraint.layout.mBarrierDirection);
                        barrier.setMargin(constraint.layout.mBarrierMargin);
                        barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                        ConstraintSet.Layout layout = constraint.layout;
                        int[] iArr = layout.mReferenceIds;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str3 = layout.mReferenceIdString;
                            if (str3 != null) {
                                layout.mReferenceIds = constraintSet.convertReferenceString(barrier, str3);
                                barrier.setReferencedIds(constraint.layout.mReferenceIds);
                            }
                        }
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    layoutParams.validate();
                    constraint.applyTo(layoutParams);
                    HashMap<String, ConstraintAttribute> hashMap = constraint.mCustomConstraints;
                    i4 = childCount3;
                    Class<?> cls = childAt3.getClass();
                    for (String str4 : hashMap.keySet()) {
                        ConstraintAttribute constraintAttribute = hashMap.get(str4);
                        String outline8 = GeneratedOutlineSupport.outline8("set", str4);
                        try {
                            switch (constraintAttribute.mType.ordinal()) {
                                case 0:
                                    i5 = childCount2;
                                    cls.getMethod(outline8, Integer.TYPE).invoke(childAt3, Integer.valueOf(constraintAttribute.mIntegerValue));
                                    break;
                                case 1:
                                    i5 = childCount2;
                                    cls.getMethod(outline8, Float.TYPE).invoke(childAt3, Float.valueOf(constraintAttribute.mFloatValue));
                                    break;
                                case 2:
                                    i5 = childCount2;
                                    cls.getMethod(outline8, Integer.TYPE).invoke(childAt3, Integer.valueOf(constraintAttribute.mColorValue));
                                    break;
                                case 3:
                                    i5 = childCount2;
                                    Method method = cls.getMethod(outline8, Drawable.class);
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(constraintAttribute.mColorValue);
                                    method.invoke(childAt3, colorDrawable);
                                    break;
                                case 4:
                                    i5 = childCount2;
                                    cls.getMethod(outline8, CharSequence.class).invoke(childAt3, constraintAttribute.mStringValue);
                                    break;
                                case 5:
                                    i5 = childCount2;
                                    cls.getMethod(outline8, Boolean.TYPE).invoke(childAt3, Boolean.valueOf(constraintAttribute.mBooleanValue));
                                    break;
                                case 6:
                                    i5 = childCount2;
                                    try {
                                        cls.getMethod(outline8, Float.TYPE).invoke(childAt3, Float.valueOf(constraintAttribute.mFloatValue));
                                    } catch (NoSuchMethodException e4) {
                                        e = e4;
                                        Log.e("TransitionLayout", e.getMessage());
                                        Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(cls.getName());
                                        sb.append(" must have a method ");
                                        sb.append(outline8);
                                        Log.e("TransitionLayout", sb.toString());
                                        z = z;
                                        hashMap = hashMap;
                                        isInEditMode = isInEditMode;
                                        childCount2 = i5;
                                    } catch (IllegalAccessException e5) {
                                        e2 = e5;
                                        StringBuilder outline17 = GeneratedOutlineSupport.outline17(" Custom Attribute \"", str4, "\" not found on ");
                                        outline17.append(cls.getName());
                                        Log.e("TransitionLayout", outline17.toString());
                                        e2.printStackTrace();
                                        z = z;
                                        hashMap = hashMap;
                                        isInEditMode = isInEditMode;
                                        childCount2 = i5;
                                    } catch (InvocationTargetException e6) {
                                        e3 = e6;
                                        StringBuilder outline172 = GeneratedOutlineSupport.outline17(" Custom Attribute \"", str4, "\" not found on ");
                                        outline172.append(cls.getName());
                                        Log.e("TransitionLayout", outline172.toString());
                                        e3.printStackTrace();
                                        z = z;
                                        hashMap = hashMap;
                                        isInEditMode = isInEditMode;
                                        childCount2 = i5;
                                    }
                                default:
                                    i5 = childCount2;
                                    break;
                            }
                        } catch (NoSuchMethodException e7) {
                            e = e7;
                            i5 = childCount2;
                            Log.e("TransitionLayout", e.getMessage());
                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(cls.getName());
                            sb2.append(" must have a method ");
                            sb2.append(outline8);
                            Log.e("TransitionLayout", sb2.toString());
                            z = z;
                            hashMap = hashMap;
                            isInEditMode = isInEditMode;
                            childCount2 = i5;
                        } catch (IllegalAccessException e8) {
                            e2 = e8;
                            i5 = childCount2;
                            StringBuilder outline173 = GeneratedOutlineSupport.outline17(" Custom Attribute \"", str4, "\" not found on ");
                            outline173.append(cls.getName());
                            Log.e("TransitionLayout", outline173.toString());
                            e2.printStackTrace();
                            z = z;
                            hashMap = hashMap;
                            isInEditMode = isInEditMode;
                            childCount2 = i5;
                        } catch (InvocationTargetException e9) {
                            e3 = e9;
                            i5 = childCount2;
                            StringBuilder outline1722 = GeneratedOutlineSupport.outline17(" Custom Attribute \"", str4, "\" not found on ");
                            outline1722.append(cls.getName());
                            Log.e("TransitionLayout", outline1722.toString());
                            e3.printStackTrace();
                            z = z;
                            hashMap = hashMap;
                            isInEditMode = isInEditMode;
                            childCount2 = i5;
                        }
                        z = z;
                        hashMap = hashMap;
                        isInEditMode = isInEditMode;
                        childCount2 = i5;
                    }
                    z5 = z;
                    z4 = isInEditMode;
                    i3 = childCount2;
                    childAt3.setLayoutParams(layoutParams);
                    ConstraintSet.PropertySet propertySet = constraint.propertySet;
                    if (propertySet.mVisibilityMode == 0) {
                        childAt3.setVisibility(propertySet.visibility);
                    }
                    childAt3.setAlpha(constraint.propertySet.alpha);
                    childAt3.setRotation(constraint.transform.rotation);
                    childAt3.setRotationX(constraint.transform.rotationX);
                    childAt3.setRotationY(constraint.transform.rotationY);
                    childAt3.setScaleX(constraint.transform.scaleX);
                    childAt3.setScaleY(constraint.transform.scaleY);
                    if (!Float.isNaN(constraint.transform.transformPivotX)) {
                        childAt3.setPivotX(constraint.transform.transformPivotX);
                    }
                    if (!Float.isNaN(constraint.transform.transformPivotY)) {
                        childAt3.setPivotY(constraint.transform.transformPivotY);
                    }
                    childAt3.setTranslationX(constraint.transform.translationX);
                    childAt3.setTranslationY(constraint.transform.translationY);
                    childAt3.setTranslationZ(constraint.transform.translationZ);
                    ConstraintSet.Transform transform = constraint.transform;
                    if (transform.applyElevation) {
                        childAt3.setElevation(transform.elevation);
                    }
                    i6++;
                    i9 = -1;
                    i = 1;
                    childCount3 = i4;
                    z = z5;
                    isInEditMode = z4;
                    childCount2 = i3;
                }
                i4 = childCount3;
                z5 = z;
                z4 = isInEditMode;
                i3 = childCount2;
                i6++;
                i9 = -1;
                i = 1;
                childCount3 = i4;
                z = z5;
                isInEditMode = z4;
                childCount2 = i3;
            }
            z3 = z;
            z2 = isInEditMode;
            i2 = childCount2;
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                ConstraintSet.Constraint constraint2 = constraintSet.mConstraints.get(num);
                int i13 = constraint2.layout.mHelperType;
                if (i13 != -1 && i13 == 1) {
                    Barrier barrier2 = new Barrier(getContext());
                    barrier2.setId(num.intValue());
                    ConstraintSet.Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str5 = layout2.mReferenceIdString;
                        if (str5 != null) {
                            layout2.mReferenceIds = constraintSet.convertReferenceString(barrier2, str5);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(getContext());
                    guideline.setId(num.intValue());
                    LayoutParams generateDefaultLayoutParams2 = generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    addView(guideline, generateDefaultLayoutParams2);
                }
            }
        } else {
            z3 = z;
            z2 = isInEditMode;
            i2 = childCount2;
        }
        this.mLayoutWidget.mChildren.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintHelper constraintHelper = this.mConstraintHelpers.get(i14);
                if (constraintHelper.isInEditMode()) {
                    constraintHelper.setIds(constraintHelper.mReferenceIds);
                }
                Helper helper = constraintHelper.mHelperWidget;
                if (helper != null) {
                    HelperWidget helperWidget = (HelperWidget) helper;
                    helperWidget.mWidgetsCount = 0;
                    Arrays.fill(helperWidget.mWidgets, (Object) null);
                    for (int i15 = 0; i15 < constraintHelper.mCount; i15++) {
                        int i16 = constraintHelper.mIds[i15];
                        View viewById = getViewById(i16);
                        if (viewById == null && (findId = constraintHelper.findId(this, (str = constraintHelper.mMap.get(Integer.valueOf(i16))))) != 0) {
                            constraintHelper.mIds[i15] = findId;
                            constraintHelper.mMap.put(Integer.valueOf(findId), str);
                            viewById = getViewById(findId);
                        }
                        if (viewById != null) {
                            Helper helper2 = constraintHelper.mHelperWidget;
                            ConstraintWidget viewWidget2 = getViewWidget(viewById);
                            HelperWidget helperWidget2 = (HelperWidget) helper2;
                            if (helperWidget2 == null) {
                                throw null;
                            } else if (!(viewWidget2 == helperWidget2 || viewWidget2 == null)) {
                                int i17 = helperWidget2.mWidgetsCount + 1;
                                ConstraintWidget[] constraintWidgetArr = helperWidget2.mWidgets;
                                if (i17 > constraintWidgetArr.length) {
                                    helperWidget2.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
                                }
                                ConstraintWidget[] constraintWidgetArr2 = helperWidget2.mWidgets;
                                int i18 = helperWidget2.mWidgetsCount;
                                constraintWidgetArr2[i18] = viewWidget2;
                                helperWidget2.mWidgetsCount = i18 + 1;
                            }
                        }
                    }
                    constraintHelper.mHelperWidget.updateConstraints(this.mLayoutWidget);
                }
            }
        }
        for (int i19 = 0; i19 < i2; i19++) {
            View childAt4 = getChildAt(i19);
            if (childAt4 instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) childAt4;
                if (placeholder.mContentId == -1 && !placeholder.isInEditMode()) {
                    placeholder.setVisibility(placeholder.mEmptyVisibility);
                }
                View findViewById = findViewById(placeholder.mContentId);
                placeholder.mContent = findViewById;
                if (findViewById != null) {
                    ((LayoutParams) findViewById.getLayoutParams()).isInPlaceholder = true;
                    placeholder.mContent.setVisibility(0);
                    placeholder.setVisibility(0);
                }
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i20 = 0; i20 < i2; i20++) {
            View childAt5 = getChildAt(i20);
            this.mTempMapIdToWidget.put(childAt5.getId(), getViewWidget(childAt5));
        }
        for (int i21 = 0; i21 < i2; i21++) {
            View childAt6 = getChildAt(i21);
            ConstraintWidget viewWidget3 = getViewWidget(childAt6);
            if (viewWidget3 != null) {
                LayoutParams layoutParams2 = (LayoutParams) childAt6.getLayoutParams();
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                constraintWidgetContainer.mChildren.add(viewWidget3);
                ConstraintWidget constraintWidget2 = viewWidget3.mParent;
                if (constraintWidget2 != null) {
                    ((WidgetContainer) constraintWidget2).mChildren.remove(viewWidget3);
                    viewWidget3.mParent = null;
                }
                viewWidget3.mParent = constraintWidgetContainer;
                applyConstraintsFromLayoutParams(z2, childAt6, viewWidget3, layoutParams2, this.mTempMapIdToWidget);
            }
        }
        return z3;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String constraintTag = null;
        public String dimensionRatio = null;
        public int dimensionRatioSide = 1;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        public boolean isGuideline = false;
        public boolean isHelper = false;
        public boolean isInPlaceholder = false;
        public boolean isVirtualGroup = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        public boolean needsBaseline = false;
        public int orientation = -1;
        public int resolveGoneLeftMargin = -1;
        public int resolveGoneRightMargin = -1;
        public int resolvedGuideBegin;
        public int resolvedGuideEnd;
        public float resolvedGuidePercent;
        public float resolvedHorizontalBias = 0.5f;
        public int resolvedLeftToLeft = -1;
        public int resolvedLeftToRight = -1;
        public int resolvedRightToLeft = -1;
        public int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        public ConstraintWidget widget = new ConstraintWidget();

        public static class Table {
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                map.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = Table.map.get(index);
                switch (i3) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f;
                        if (f < BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            this.circleAngle = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioSide = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i);
                                        if (substring2.length() > 0) {
                                            Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.dimensionRatio.substring(i, indexOf2);
                                        String substring4 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && parseFloat2 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                                    if (this.dimensionRatioSide == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                continue;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                continue;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                continue;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                continue;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            this.resolvedHorizontalBias = this.horizontalBias;
            this.resolvedGuideBegin = this.guideBegin;
            this.resolvedGuideEnd = this.guideEnd;
            this.resolvedGuidePercent = this.guidePercent;
            if (z2) {
                int i8 = this.startToEnd;
                if (i8 != -1) {
                    this.resolvedRightToLeft = i8;
                } else {
                    int i9 = this.startToStart;
                    if (i9 != -1) {
                        this.resolvedRightToRight = i9;
                    }
                    i2 = this.endToStart;
                    if (i2 != -1) {
                        this.resolvedLeftToRight = i2;
                        z = true;
                    }
                    i3 = this.endToEnd;
                    if (i3 != -1) {
                        this.resolvedLeftToLeft = i3;
                        z = true;
                    }
                    i4 = this.goneStartMargin;
                    if (i4 != -1) {
                        this.resolveGoneRightMargin = i4;
                    }
                    i5 = this.goneEndMargin;
                    if (i5 != -1) {
                        this.resolveGoneLeftMargin = i5;
                    }
                    if (z) {
                        this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                    }
                    if (this.isGuideline && this.orientation == 1) {
                        f = this.guidePercent;
                        if (f == -1.0f) {
                            this.resolvedGuidePercent = 1.0f - f;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuideEnd = -1;
                        } else {
                            int i10 = this.guideBegin;
                            if (i10 != -1) {
                                this.resolvedGuideEnd = i10;
                                this.resolvedGuideBegin = -1;
                                this.resolvedGuidePercent = -1.0f;
                            } else {
                                int i11 = this.guideEnd;
                                if (i11 != -1) {
                                    this.resolvedGuideBegin = i11;
                                    this.resolvedGuideEnd = -1;
                                    this.resolvedGuidePercent = -1.0f;
                                }
                            }
                        }
                    }
                }
                z = true;
                i2 = this.endToStart;
                if (i2 != -1) {
                }
                i3 = this.endToEnd;
                if (i3 != -1) {
                }
                i4 = this.goneStartMargin;
                if (i4 != -1) {
                }
                i5 = this.goneEndMargin;
                if (i5 != -1) {
                }
                if (z) {
                }
                f = this.guidePercent;
                if (f == -1.0f) {
                }
            } else {
                int i12 = this.startToEnd;
                if (i12 != -1) {
                    this.resolvedLeftToRight = i12;
                }
                int i13 = this.startToStart;
                if (i13 != -1) {
                    this.resolvedLeftToLeft = i13;
                }
                int i14 = this.endToStart;
                if (i14 != -1) {
                    this.resolvedRightToLeft = i14;
                }
                int i15 = this.endToEnd;
                if (i15 != -1) {
                    this.resolvedRightToRight = i15;
                }
                int i16 = this.goneStartMargin;
                if (i16 != -1) {
                    this.resolveGoneLeftMargin = i16;
                }
                int i17 = this.goneEndMargin;
                if (i17 != -1) {
                    this.resolveGoneRightMargin = i17;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i18 = this.rightToLeft;
                if (i18 != -1) {
                    this.resolvedRightToLeft = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i19 = this.rightToRight;
                    if (i19 != -1) {
                        this.resolvedRightToRight = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i20 = this.leftToLeft;
                if (i20 != -1) {
                    this.resolvedLeftToLeft = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                        return;
                    }
                    return;
                }
                int i21 = this.leftToRight;
                if (i21 != -1) {
                    this.resolvedLeftToRight = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                    }
                }
            }
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == 0 || i == -1) {
                this.horizontalDimensionFixed = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == 0 || i2 == -1) {
                this.verticalDimensionFixed = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
