package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;

public class ConstraintWidget {
    public boolean hasBaseline = false;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun = new HorizontalWidgetRun(this);
    public boolean inPlaceholder;
    public boolean[] isTerminalWidget = {true, true};
    public ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    public int mBaselineDistance;
    public ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor mCenter;
    public ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public float mCircleConstraintAngle = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public Object mCompanionWidget;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public int mHorizontalChainStyle;
    public int mHorizontalResolution = -1;
    public boolean[] mIsInBarrier;
    public ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight = 0;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintMaxHeight = 0;
    public int mMatchConstraintMaxWidth = 0;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMinWidth = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    public float mMatchConstraintPercentWidth = 1.0f;
    public int[] mMaxDimension = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public ConstraintWidget mParent;
    public float mResolvedDimensionRatio = 1.0f;
    public int mResolvedDimensionRatioSide = -1;
    public int[] mResolvedMatchConstraintDefault = new int[2];
    public ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public String mType;
    public float mVerticalBiasPercent;
    public int mVerticalChainStyle;
    public int mVerticalResolution = -1;
    public int mVisibility;
    public float[] mWeight;
    public int mWidth;
    public int mX;
    public int mY;
    public boolean measured = false;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun = new VerticalWidgetRun(this);
    public int[] wrapMeasure = {0, 0, 0, 0};

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.mAnchors = arrayList;
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        arrayList.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x047c  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0570  */
    /* JADX WARNING: Removed duplicated region for block: B:303:? A[RETURN, SYNTHETIC] */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        boolean z5;
        int i3;
        char c;
        int i4;
        boolean z6;
        char c2;
        DimensionBehaviour dimensionBehaviour;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        DependencyNode dependencyNode;
        int i5;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        int i6;
        int i7;
        int i8;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget;
        boolean z7;
        int i9;
        boolean z8;
        boolean z9;
        ConstraintWidget constraintWidget2 = this;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintWidget2.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintWidget2.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintWidget2.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintWidget2.mBaseline);
        HorizontalWidgetRun horizontalWidgetRun = constraintWidget2.horizontalRun;
        DependencyNode dependencyNode2 = horizontalWidgetRun.start;
        if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
            VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
            if (verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                linearSystem.addEquality(createObjectVariable, dependencyNode2.value);
                linearSystem.addEquality(createObjectVariable2, constraintWidget2.horizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, constraintWidget2.verticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, constraintWidget2.verticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, constraintWidget2.verticalRun.baseline.value);
                ConstraintWidget constraintWidget3 = constraintWidget2.mParent;
                if (constraintWidget3 != null) {
                    boolean z10 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[0] == dimensionBehaviour2;
                    ConstraintWidget constraintWidget4 = constraintWidget2.mParent;
                    boolean z11 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[1] == dimensionBehaviour2;
                    if (z10 && constraintWidget2.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 8);
                    }
                    if (z11 && constraintWidget2.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mBottom), createObjectVariable4, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ConstraintWidget constraintWidget5 = constraintWidget2.mParent;
        if (constraintWidget5 != null) {
            boolean z12 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == dimensionBehaviour2;
            ConstraintWidget constraintWidget6 = constraintWidget2.mParent;
            boolean z13 = constraintWidget6 != null && constraintWidget6.mListDimensionBehaviors[1] == dimensionBehaviour2;
            if (constraintWidget2.isChainHead(0)) {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 0);
                z8 = true;
            } else {
                z8 = isInHorizontalChain();
            }
            if (constraintWidget2.isChainHead(1)) {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 1);
                z9 = true;
            } else {
                z9 = isInVerticalChain();
            }
            if (!z8 && z12 && constraintWidget2.mVisibility != 8 && constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (!z9 && z13 && constraintWidget2.mVisibility != 8 && constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z3 = z12;
            z4 = z13;
            z = z8;
            z2 = z9;
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        int i10 = constraintWidget2.mWidth;
        int i11 = constraintWidget2.mMinWidth;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = constraintWidget2.mHeight;
        int i13 = constraintWidget2.mMinHeight;
        if (i12 < i13) {
            i12 = i13;
        }
        boolean z14 = constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour3;
        boolean z15 = constraintWidget2.mListDimensionBehaviors[1] != dimensionBehaviour3;
        constraintWidget2.mResolvedDimensionRatioSide = constraintWidget2.mDimensionRatioSide;
        float f = constraintWidget2.mDimensionRatio;
        constraintWidget2.mResolvedDimensionRatio = f;
        int i14 = constraintWidget2.mMatchConstraintDefaultWidth;
        int i15 = constraintWidget2.mMatchConstraintDefaultHeight;
        if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || constraintWidget2.mVisibility == 8) {
            c = 0;
            i3 = i12;
            i2 = i15;
            i = i14;
            z5 = false;
        } else {
            if (constraintWidget2.mListDimensionBehaviors[0] == dimensionBehaviour3 && i14 == 0) {
                i14 = 3;
            }
            if (constraintWidget2.mListDimensionBehaviors[1] == dimensionBehaviour3 && i15 == 0) {
                i15 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget2.mListDimensionBehaviors;
            if (dimensionBehaviourArr[0] == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3 && i14 == 3 && i15 == 3) {
                if (constraintWidget2.mResolvedDimensionRatioSide == -1) {
                    if (z14 && !z15) {
                        constraintWidget2.mResolvedDimensionRatioSide = 0;
                    } else if (!z14 && z15) {
                        constraintWidget2.mResolvedDimensionRatioSide = 1;
                        if (constraintWidget2.mDimensionRatioSide == -1) {
                            constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                        }
                    }
                }
                if (constraintWidget2.mResolvedDimensionRatioSide == 0 && (!constraintWidget2.mTop.isConnected() || !constraintWidget2.mBottom.isConnected())) {
                    constraintWidget2.mResolvedDimensionRatioSide = 1;
                } else if (constraintWidget2.mResolvedDimensionRatioSide == 1 && (!constraintWidget2.mLeft.isConnected() || !constraintWidget2.mRight.isConnected())) {
                    constraintWidget2.mResolvedDimensionRatioSide = 0;
                }
                if (constraintWidget2.mResolvedDimensionRatioSide == -1 && (!constraintWidget2.mTop.isConnected() || !constraintWidget2.mBottom.isConnected() || !constraintWidget2.mLeft.isConnected() || !constraintWidget2.mRight.isConnected())) {
                    if (constraintWidget2.mTop.isConnected() && constraintWidget2.mBottom.isConnected()) {
                        constraintWidget2.mResolvedDimensionRatioSide = 0;
                    } else if (constraintWidget2.mLeft.isConnected() && constraintWidget2.mRight.isConnected()) {
                        constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                        constraintWidget2.mResolvedDimensionRatioSide = 1;
                    }
                }
                if (constraintWidget2.mResolvedDimensionRatioSide == -1) {
                    if (constraintWidget2.mMatchConstraintMinWidth > 0 && constraintWidget2.mMatchConstraintMinHeight == 0) {
                        constraintWidget2.mResolvedDimensionRatioSide = 0;
                    } else if (constraintWidget2.mMatchConstraintMinWidth == 0 && constraintWidget2.mMatchConstraintMinHeight > 0) {
                        constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                        constraintWidget2.mResolvedDimensionRatioSide = 1;
                    }
                }
            } else {
                DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget2.mListDimensionBehaviors;
                if (dimensionBehaviourArr2[0] == dimensionBehaviour3 && i14 == 3) {
                    constraintWidget2.mResolvedDimensionRatioSide = 0;
                    int i16 = (int) (constraintWidget2.mResolvedDimensionRatio * ((float) constraintWidget2.mHeight));
                    i3 = i12;
                    if (dimensionBehaviourArr2[1] != dimensionBehaviour3) {
                        i4 = i16;
                        i2 = i15;
                        i = 4;
                        c = 0;
                        z5 = false;
                    } else {
                        i4 = i16;
                        z5 = true;
                        i2 = i15;
                        i = i14;
                        c = 0;
                    }
                    int[] iArr = constraintWidget2.mResolvedMatchConstraintDefault;
                    iArr[c] = i;
                    iArr[1] = i2;
                    if (!z5) {
                    }
                    z6 = false;
                    if (constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour2) {
                    }
                    if (r20) {
                    }
                    boolean z16 = !constraintWidget2.mCenter.isConnected();
                    boolean[] zArr = constraintWidget2.mIsInBarrier;
                    boolean z17 = zArr[0];
                    boolean z18 = zArr[1];
                    SolverVariable solverVariable11 = null;
                    if (constraintWidget2.mHorizontalResolution != 2) {
                    }
                    constraintWidget2 = this;
                    VerticalWidgetRun verticalWidgetRun2 = constraintWidget2.verticalRun;
                    dependencyNode = verticalWidgetRun2.start;
                    if (dependencyNode.resolved) {
                    }
                    linearSystem2 = linearSystem;
                    solverVariable8 = solverVariable5;
                    solverVariable7 = solverVariable4;
                    solverVariable6 = solverVariable3;
                    i8 = 8;
                    i7 = 0;
                    i6 = 1;
                    i5 = 1;
                    if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
                    }
                    if (!z5) {
                    }
                    if (!constraintWidget.mCenter.isConnected()) {
                    }
                } else if (constraintWidget2.mListDimensionBehaviors[1] == dimensionBehaviour3 && i15 == 3) {
                    constraintWidget2.mResolvedDimensionRatioSide = 1;
                    if (constraintWidget2.mDimensionRatioSide == -1) {
                        constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                    }
                    i12 = (int) (constraintWidget2.mResolvedDimensionRatio * ((float) constraintWidget2.mWidth));
                    c = 0;
                    if (constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour3) {
                        i3 = i12;
                        i = i14;
                        z5 = false;
                        i2 = 4;
                    }
                    i3 = i12;
                    i2 = i15;
                    i = i14;
                    i4 = i10;
                    z5 = true;
                    int[] iArr2 = constraintWidget2.mResolvedMatchConstraintDefault;
                    iArr2[c] = i;
                    iArr2[1] = i2;
                    if (!z5) {
                        int i17 = constraintWidget2.mResolvedDimensionRatioSide;
                        c2 = 65535;
                        if (i17 == 0 || i17 == -1) {
                            z6 = true;
                            boolean z19 = constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour2 && (constraintWidget2 instanceof ConstraintWidgetContainer);
                            int i18 = z19 ? 0 : i4;
                            boolean z162 = !constraintWidget2.mCenter.isConnected();
                            boolean[] zArr2 = constraintWidget2.mIsInBarrier;
                            boolean z172 = zArr2[0];
                            boolean z182 = zArr2[1];
                            SolverVariable solverVariable112 = null;
                            if (constraintWidget2.mHorizontalResolution != 2) {
                                HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget2.horizontalRun;
                                DependencyNode dependencyNode3 = horizontalWidgetRun2.start;
                                if (!dependencyNode3.resolved || !horizontalWidgetRun2.end.resolved) {
                                    ConstraintWidget constraintWidget7 = constraintWidget2.mParent;
                                    SolverVariable createObjectVariable6 = constraintWidget7 != null ? linearSystem.createObjectVariable(constraintWidget7.mRight) : null;
                                    ConstraintWidget constraintWidget8 = constraintWidget2.mParent;
                                    solverVariable5 = createObjectVariable5;
                                    solverVariable4 = createObjectVariable4;
                                    solverVariable3 = createObjectVariable3;
                                    solverVariable2 = createObjectVariable2;
                                    solverVariable = createObjectVariable;
                                    dimensionBehaviour = dimensionBehaviour2;
                                    applyConstraints(linearSystem, true, z3, z4, constraintWidget2.isTerminalWidget[0], constraintWidget8 != null ? linearSystem.createObjectVariable(constraintWidget8.mLeft) : null, createObjectVariable6, constraintWidget2.mListDimensionBehaviors[0], z19, constraintWidget2.mLeft, constraintWidget2.mRight, constraintWidget2.mX, i18, constraintWidget2.mMinWidth, constraintWidget2.mMaxDimension[0], constraintWidget2.mHorizontalBiasPercent, z6, z, z2, z172, i, i2, constraintWidget2.mMatchConstraintMinWidth, constraintWidget2.mMatchConstraintMaxWidth, constraintWidget2.mMatchConstraintPercentWidth, z162);
                                } else {
                                    linearSystem.addEquality(createObjectVariable, dependencyNode3.value);
                                    linearSystem.addEquality(createObjectVariable2, constraintWidget2.horizontalRun.end.value);
                                    if (constraintWidget2.mParent != null && z3 && constraintWidget2.isTerminalWidget[0] && !isInHorizontalChain()) {
                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 8);
                                    }
                                    solverVariable4 = createObjectVariable4;
                                    solverVariable3 = createObjectVariable3;
                                    solverVariable2 = createObjectVariable2;
                                    solverVariable = createObjectVariable;
                                    dimensionBehaviour = dimensionBehaviour2;
                                    solverVariable5 = createObjectVariable5;
                                    VerticalWidgetRun verticalWidgetRun22 = constraintWidget2.verticalRun;
                                    dependencyNode = verticalWidgetRun22.start;
                                    if (dependencyNode.resolved || !verticalWidgetRun22.end.resolved) {
                                        linearSystem2 = linearSystem;
                                        solverVariable8 = solverVariable5;
                                        solverVariable7 = solverVariable4;
                                        solverVariable6 = solverVariable3;
                                        i8 = 8;
                                        i7 = 0;
                                        i6 = 1;
                                        i5 = 1;
                                    } else {
                                        linearSystem2 = linearSystem;
                                        solverVariable6 = solverVariable3;
                                        linearSystem2.addEquality(solverVariable6, dependencyNode.value);
                                        solverVariable7 = solverVariable4;
                                        linearSystem2.addEquality(solverVariable7, constraintWidget2.verticalRun.end.value);
                                        solverVariable8 = solverVariable5;
                                        linearSystem2.addEquality(solverVariable8, constraintWidget2.verticalRun.baseline.value);
                                        ConstraintWidget constraintWidget9 = constraintWidget2.mParent;
                                        if (constraintWidget9 == null || z2 || !z4) {
                                            i8 = 8;
                                            i7 = 0;
                                            i6 = 1;
                                        } else {
                                            i6 = 1;
                                            if (constraintWidget2.isTerminalWidget[1]) {
                                                i8 = 8;
                                                i7 = 0;
                                                linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget9.mBottom), solverVariable7, 0, 8);
                                            } else {
                                                i8 = 8;
                                                i7 = 0;
                                            }
                                        }
                                        i5 = i7;
                                    }
                                    if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
                                        boolean z20 = (constraintWidget2.mListDimensionBehaviors[i6] != dimensionBehaviour || !(constraintWidget2 instanceof ConstraintWidgetContainer)) ? i7 : i6;
                                        if (z20) {
                                            i3 = i7;
                                        }
                                        boolean z21 = (!z5 || !((i9 = constraintWidget2.mResolvedDimensionRatioSide) == i6 || i9 == -1)) ? i7 : i6;
                                        ConstraintWidget constraintWidget10 = constraintWidget2.mParent;
                                        SolverVariable createObjectVariable7 = constraintWidget10 != null ? linearSystem2.createObjectVariable(constraintWidget10.mBottom) : null;
                                        ConstraintWidget constraintWidget11 = constraintWidget2.mParent;
                                        if (constraintWidget11 != null) {
                                            solverVariable112 = linearSystem2.createObjectVariable(constraintWidget11.mTop);
                                        }
                                        if (constraintWidget2.mBaselineDistance > 0 || constraintWidget2.mVisibility == i8) {
                                            linearSystem2.addEquality(solverVariable8, solverVariable6, constraintWidget2.mBaselineDistance, i8);
                                            ConstraintAnchor constraintAnchor = constraintWidget2.mBaseline.mTarget;
                                            if (constraintAnchor != null) {
                                                linearSystem2.addEquality(solverVariable8, linearSystem2.createObjectVariable(constraintAnchor), i7, i8);
                                                if (z4) {
                                                    linearSystem2.addGreaterThan(createObjectVariable7, linearSystem2.createObjectVariable(constraintWidget2.mBottom), i7, 5);
                                                }
                                                z7 = i7;
                                                solverVariable10 = solverVariable7;
                                                solverVariable9 = solverVariable6;
                                                applyConstraints(linearSystem, false, z4, z3, constraintWidget2.isTerminalWidget[i6], solverVariable112, createObjectVariable7, constraintWidget2.mListDimensionBehaviors[i6], z20, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.mY, i3, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[i6], constraintWidget2.mVerticalBiasPercent, z21, z2, z, z182, i2, i, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z7);
                                            } else if (constraintWidget2.mVisibility == i8) {
                                                linearSystem2.addEquality(solverVariable8, solverVariable6, i7, i8);
                                            }
                                        }
                                        z7 = z162;
                                        solverVariable10 = solverVariable7;
                                        solverVariable9 = solverVariable6;
                                        applyConstraints(linearSystem, false, z4, z3, constraintWidget2.isTerminalWidget[i6], solverVariable112, createObjectVariable7, constraintWidget2.mListDimensionBehaviors[i6], z20, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.mY, i3, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[i6], constraintWidget2.mVerticalBiasPercent, z21, z2, z, z182, i2, i, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z7);
                                    } else {
                                        solverVariable10 = solverVariable7;
                                        solverVariable9 = solverVariable6;
                                    }
                                    if (!z5) {
                                        constraintWidget = this;
                                        if (constraintWidget.mResolvedDimensionRatioSide == 1) {
                                            linearSystem.addRatio(solverVariable10, solverVariable9, solverVariable2, solverVariable, constraintWidget.mResolvedDimensionRatio, 8);
                                        } else {
                                            linearSystem.addRatio(solverVariable2, solverVariable, solverVariable10, solverVariable9, constraintWidget.mResolvedDimensionRatio, 8);
                                        }
                                    } else {
                                        constraintWidget = this;
                                    }
                                    if (!constraintWidget.mCenter.isConnected()) {
                                        ConstraintWidget constraintWidget12 = constraintWidget.mCenter.mTarget.mOwner;
                                        int margin = constraintWidget.mCenter.getMargin();
                                        ConstraintAnchor.Type type = ConstraintAnchor.Type.BOTTOM;
                                        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                                        SolverVariable createObjectVariable8 = linearSystem.createObjectVariable(constraintWidget.getAnchor(type4));
                                        SolverVariable createObjectVariable9 = linearSystem.createObjectVariable(constraintWidget.getAnchor(type3));
                                        SolverVariable createObjectVariable10 = linearSystem.createObjectVariable(constraintWidget.getAnchor(type2));
                                        SolverVariable createObjectVariable11 = linearSystem.createObjectVariable(constraintWidget.getAnchor(type));
                                        SolverVariable createObjectVariable12 = linearSystem.createObjectVariable(constraintWidget12.getAnchor(type4));
                                        SolverVariable createObjectVariable13 = linearSystem.createObjectVariable(constraintWidget12.getAnchor(type3));
                                        SolverVariable createObjectVariable14 = linearSystem.createObjectVariable(constraintWidget12.getAnchor(type2));
                                        SolverVariable createObjectVariable15 = linearSystem.createObjectVariable(constraintWidget12.getAnchor(type));
                                        ArrayRow createRow = linearSystem.createRow();
                                        double radians = (double) ((float) Math.toRadians((double) (constraintWidget.mCircleConstraintAngle + 90.0f)));
                                        double d = (double) margin;
                                        createRow.createRowWithAngle(createObjectVariable9, createObjectVariable11, createObjectVariable13, createObjectVariable15, (float) (Math.sin(radians) * d));
                                        linearSystem.addConstraint(createRow);
                                        ArrayRow createRow2 = linearSystem.createRow();
                                        createRow2.createRowWithAngle(createObjectVariable8, createObjectVariable10, createObjectVariable12, createObjectVariable14, (float) (Math.cos(radians) * d));
                                        linearSystem.addConstraint(createRow2);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                solverVariable4 = createObjectVariable4;
                                solverVariable3 = createObjectVariable3;
                                solverVariable2 = createObjectVariable2;
                                solverVariable = createObjectVariable;
                                dimensionBehaviour = dimensionBehaviour2;
                                solverVariable5 = createObjectVariable5;
                            }
                            constraintWidget2 = this;
                            VerticalWidgetRun verticalWidgetRun222 = constraintWidget2.verticalRun;
                            dependencyNode = verticalWidgetRun222.start;
                            if (dependencyNode.resolved) {
                            }
                            linearSystem2 = linearSystem;
                            solverVariable8 = solverVariable5;
                            solverVariable7 = solverVariable4;
                            solverVariable6 = solverVariable3;
                            i8 = 8;
                            i7 = 0;
                            i6 = 1;
                            i5 = 1;
                            if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
                            }
                            if (!z5) {
                            }
                            if (!constraintWidget.mCenter.isConnected()) {
                            }
                        }
                    } else {
                        c2 = 65535;
                    }
                    z6 = false;
                    if (constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour2) {
                    }
                    if (z19) {
                    }
                    boolean z1622 = !constraintWidget2.mCenter.isConnected();
                    boolean[] zArr22 = constraintWidget2.mIsInBarrier;
                    boolean z1722 = zArr22[0];
                    boolean z1822 = zArr22[1];
                    SolverVariable solverVariable1122 = null;
                    if (constraintWidget2.mHorizontalResolution != 2) {
                    }
                    constraintWidget2 = this;
                    VerticalWidgetRun verticalWidgetRun2222 = constraintWidget2.verticalRun;
                    dependencyNode = verticalWidgetRun2222.start;
                    if (dependencyNode.resolved) {
                    }
                    linearSystem2 = linearSystem;
                    solverVariable8 = solverVariable5;
                    solverVariable7 = solverVariable4;
                    solverVariable6 = solverVariable3;
                    i8 = 8;
                    i7 = 0;
                    i6 = 1;
                    i5 = 1;
                    if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
                    }
                    if (!z5) {
                    }
                    if (!constraintWidget.mCenter.isConnected()) {
                    }
                }
            }
            c = 0;
            i3 = i12;
            i2 = i15;
            i = i14;
            i4 = i10;
            z5 = true;
            int[] iArr22 = constraintWidget2.mResolvedMatchConstraintDefault;
            iArr22[c] = i;
            iArr22[1] = i2;
            if (!z5) {
            }
            z6 = false;
            if (constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour2) {
            }
            if (z19) {
            }
            boolean z16222 = !constraintWidget2.mCenter.isConnected();
            boolean[] zArr222 = constraintWidget2.mIsInBarrier;
            boolean z17222 = zArr222[0];
            boolean z18222 = zArr222[1];
            SolverVariable solverVariable11222 = null;
            if (constraintWidget2.mHorizontalResolution != 2) {
            }
            constraintWidget2 = this;
            VerticalWidgetRun verticalWidgetRun22222 = constraintWidget2.verticalRun;
            dependencyNode = verticalWidgetRun22222.start;
            if (dependencyNode.resolved) {
            }
            linearSystem2 = linearSystem;
            solverVariable8 = solverVariable5;
            solverVariable7 = solverVariable4;
            solverVariable6 = solverVariable3;
            i8 = 8;
            i7 = 0;
            i6 = 1;
            i5 = 1;
            if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
            }
            if (!z5) {
            }
            if (!constraintWidget.mCenter.isConnected()) {
            }
        }
        i4 = i10;
        int[] iArr222 = constraintWidget2.mResolvedMatchConstraintDefault;
        iArr222[c] = i;
        iArr222[1] = i2;
        if (!z5) {
        }
        z6 = false;
        if (constraintWidget2.mListDimensionBehaviors[0] != dimensionBehaviour2) {
        }
        if (z19) {
        }
        boolean z162222 = !constraintWidget2.mCenter.isConnected();
        boolean[] zArr2222 = constraintWidget2.mIsInBarrier;
        boolean z172222 = zArr2222[0];
        boolean z182222 = zArr2222[1];
        SolverVariable solverVariable112222 = null;
        if (constraintWidget2.mHorizontalResolution != 2) {
        }
        constraintWidget2 = this;
        VerticalWidgetRun verticalWidgetRun222222 = constraintWidget2.verticalRun;
        dependencyNode = verticalWidgetRun222222.start;
        if (dependencyNode.resolved) {
        }
        linearSystem2 = linearSystem;
        solverVariable8 = solverVariable5;
        solverVariable7 = solverVariable4;
        solverVariable6 = solverVariable3;
        i8 = 8;
        i7 = 0;
        i6 = 1;
        i5 = 1;
        if ((constraintWidget2.mVerticalResolution != 2 ? i7 : i5) == 0) {
        }
        if (!z5) {
        }
        if (!constraintWidget.mCenter.isConnected()) {
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x029c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02fe A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03c9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x03f1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:286:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:290:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0185  */
    public final void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, int i5, int i6, int i7, int i8, float f2, boolean z10) {
        int i9;
        SolverVariable solverVariable3;
        int i10;
        boolean z11;
        boolean z12;
        int i11;
        boolean z13;
        int i12;
        int i13;
        boolean z14;
        char c;
        boolean z15;
        int i14;
        SolverVariable solverVariable4;
        int i15;
        int i16;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i17;
        SolverVariable solverVariable7;
        ConstraintAnchor constraintAnchor3;
        DimensionBehaviour[] dimensionBehaviourArr;
        DimensionBehaviour dimensionBehaviour2;
        boolean z16;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i18;
        int i19;
        SolverVariable solverVariable10;
        int i20;
        boolean z17;
        int i21;
        int i22;
        boolean z18;
        boolean z19;
        boolean z20;
        int i23;
        boolean z21;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable11;
        boolean z22;
        int i24;
        int i25;
        SolverVariable solverVariable12;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget3;
        boolean z23;
        int i26;
        int i27;
        ConstraintWidget constraintWidget4;
        int i28;
        boolean z24;
        int i29;
        boolean z25;
        int i30;
        int i31;
        int i32;
        SolverVariable solverVariable14;
        SolverVariable solverVariable15;
        char c2;
        int i33 = i7;
        int i34 = i8;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor.mTarget);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2.mTarget);
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        if (isConnected2) {
            i9 = (isConnected ? 1 : 0) + 1;
        } else {
            i9 = isConnected ? 1 : 0;
        }
        if (isConnected3) {
            i9++;
        }
        if (z6) {
            solverVariable3 = createObjectVariable4;
            i10 = 3;
        } else {
            i10 = i5;
            solverVariable3 = createObjectVariable4;
        }
        int ordinal = dimensionBehaviour.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i10 != 4) {
                z11 = true;
                z12 = z11;
                if (this.mVisibility != 8) {
                    i11 = 0;
                    z12 = false;
                } else {
                    i11 = i2;
                }
                if (!z10) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable, i);
                    } else if (isConnected && !isConnected2) {
                        z13 = isConnected3;
                        i12 = 8;
                        linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 8);
                    }
                    z13 = isConnected3;
                    i12 = 8;
                } else {
                    z13 = isConnected3;
                    i12 = 8;
                }
                if (z12) {
                    if (z5) {
                        c2 = 3;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                        if (i3 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i3, i12);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i4, i12);
                        }
                    } else {
                        c2 = 3;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, i12);
                    }
                    c = c2;
                } else {
                    c = 3;
                    if (i9 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                        if (i33 == -2) {
                            i33 = i11;
                        }
                        if (i34 == -2) {
                            i34 = i11;
                        }
                        if (i11 > 0 && i10 != 1) {
                            i11 = 0;
                        }
                        if (i33 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i33, 8);
                            i11 = Math.max(i11, i33);
                        }
                        if (i34 > 0) {
                            if (!z2 || i10 != 1) {
                                i32 = 8;
                                linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i34, 8);
                            } else {
                                i32 = 8;
                            }
                            i11 = Math.min(i11, i34);
                        } else {
                            i32 = 8;
                        }
                        if (i10 == 1) {
                            if (z2) {
                                linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, i32);
                            } else if (z7) {
                                linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                                linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i32);
                            } else {
                                linearSystem.addEquality(createObjectVariable2, createObjectVariable, i11, 5);
                                linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i11, i32);
                            }
                        } else if (i10 == 2) {
                            ConstraintAnchor.Type type3 = constraintAnchor.mType;
                            if (type3 == type2 || type3 == type) {
                                solverVariable15 = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                                solverVariable14 = linearSystem.createObjectVariable(this.mParent.getAnchor(type));
                            } else {
                                solverVariable15 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                solverVariable14 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            }
                            ArrayRow createRow = linearSystem.createRow();
                            createRow.createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable14, solverVariable15, f2);
                            linearSystem.addConstraint(createRow);
                        } else {
                            i13 = i33;
                            z14 = true;
                            if (z10) {
                                solverVariable5 = solverVariable;
                                solverVariable7 = solverVariable2;
                                solverVariable6 = createObjectVariable2;
                                z15 = z14;
                                i16 = i9;
                                i17 = 0;
                                i14 = 1;
                                solverVariable4 = createObjectVariable;
                                i15 = 2;
                            } else if (z7) {
                                solverVariable5 = solverVariable;
                                solverVariable7 = solverVariable2;
                                solverVariable6 = createObjectVariable2;
                                z15 = z14;
                                i16 = i9;
                                i17 = 0;
                                i15 = 2;
                                i14 = 1;
                                solverVariable4 = createObjectVariable;
                            } else {
                                if ((isConnected || isConnected2 || z13) && (!isConnected || isConnected2)) {
                                    if (isConnected || !isConnected2) {
                                        solverVariable8 = solverVariable3;
                                        i20 = 0;
                                        if (isConnected && isConnected2) {
                                            ConstraintWidget constraintWidget5 = constraintAnchor.mTarget.mOwner;
                                            ConstraintWidget constraintWidget6 = constraintAnchor2.mTarget.mOwner;
                                            ConstraintWidget constraintWidget7 = this.mParent;
                                            int i35 = 6;
                                            if (!z12) {
                                                z19 = true;
                                                z24 = true;
                                                z20 = true;
                                            } else if (i10 == 0) {
                                                if (i34 == 0 && i13 == 0) {
                                                    z20 = false;
                                                    z18 = true;
                                                    i22 = 8;
                                                    i21 = 8;
                                                } else {
                                                    z20 = true;
                                                    z18 = false;
                                                    i22 = 5;
                                                    i21 = 5;
                                                }
                                                if ((constraintWidget5 instanceof Barrier) || (constraintWidget6 instanceof Barrier)) {
                                                    i28 = i22;
                                                    z19 = true;
                                                    z17 = false;
                                                    i22 = i28;
                                                    i23 = 6;
                                                    i21 = 4;
                                                    if (z17 || createObjectVariable3 != solverVariable8 || constraintWidget5 == constraintWidget7) {
                                                        z21 = z19;
                                                    } else {
                                                        z21 = false;
                                                        z17 = false;
                                                    }
                                                    if (!z20) {
                                                        constraintWidget2 = constraintWidget5;
                                                        z16 = z14;
                                                        i24 = i10;
                                                        constraintWidget3 = constraintWidget6;
                                                        i25 = 4;
                                                        z22 = true;
                                                        solverVariable12 = createObjectVariable3;
                                                        constraintWidget = constraintWidget7;
                                                        solverVariable11 = createObjectVariable2;
                                                        solverVariable13 = createObjectVariable;
                                                        linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, solverVariable8, createObjectVariable2, constraintAnchor2.getMargin(), this.mVisibility == 8 ? 4 : i23);
                                                    } else {
                                                        constraintWidget2 = constraintWidget5;
                                                        constraintWidget = constraintWidget7;
                                                        z22 = z19;
                                                        solverVariable12 = createObjectVariable3;
                                                        solverVariable11 = createObjectVariable2;
                                                        i24 = i10;
                                                        z16 = z14;
                                                        i25 = 4;
                                                        constraintWidget3 = constraintWidget6;
                                                        solverVariable13 = createObjectVariable;
                                                    }
                                                    if (this.mVisibility == 8) {
                                                        if (z17) {
                                                            int i36 = (!z2 || solverVariable12 == solverVariable8 || z12 || (!(constraintWidget2 instanceof Barrier) && !(constraintWidget3 instanceof Barrier))) ? i22 : 6;
                                                            linearSystem.addGreaterThan(solverVariable13, solverVariable12, constraintAnchor.getMargin(), i36);
                                                            solverVariable9 = solverVariable11;
                                                            linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i36);
                                                            i22 = i36;
                                                        } else {
                                                            solverVariable9 = solverVariable11;
                                                        }
                                                        if (!z2 || !z9 || (constraintWidget2 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                            i27 = i22;
                                                            i26 = i21;
                                                            z23 = z21;
                                                        } else {
                                                            i27 = 6;
                                                            i26 = 6;
                                                            z23 = z22;
                                                        }
                                                        if (z23) {
                                                            if (!z18 || (z8 && !z3)) {
                                                                constraintWidget4 = constraintWidget;
                                                            } else {
                                                                constraintWidget4 = constraintWidget;
                                                                if (!(constraintWidget2 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                    i35 = i26;
                                                                }
                                                                if ((constraintWidget2 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) {
                                                                    i35 = 5;
                                                                }
                                                                if ((constraintWidget2 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                                    i35 = 5;
                                                                }
                                                                i26 = Math.max(z8 ? 5 : i35, i26);
                                                            }
                                                            int i37 = i26;
                                                            if (z2) {
                                                                i37 = Math.min(i27, i37);
                                                                if (z6 && !z8 && (constraintWidget2 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                    i37 = i25;
                                                                }
                                                            }
                                                            linearSystem.addEquality(solverVariable13, solverVariable12, constraintAnchor.getMargin(), i37);
                                                            linearSystem.addEquality(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i37);
                                                        }
                                                        if (z2) {
                                                            int margin = solverVariable == solverVariable12 ? constraintAnchor.getMargin() : 0;
                                                            if (solverVariable12 != solverVariable) {
                                                                linearSystem.addGreaterThan(solverVariable13, solverVariable, margin, 5);
                                                            }
                                                        }
                                                        if (z2 && z12 && i3 == 0 && i13 == 0) {
                                                            if (!z12 || i24 != 3) {
                                                                i18 = 0;
                                                                linearSystem.addGreaterThan(solverVariable9, solverVariable13, 0, 5);
                                                            } else {
                                                                i18 = 0;
                                                                linearSystem.addGreaterThan(solverVariable9, solverVariable13, 0, 8);
                                                            }
                                                            if (!z2 && z16) {
                                                                if (constraintAnchor2.mTarget != null) {
                                                                    i19 = constraintAnchor2.getMargin();
                                                                    solverVariable10 = solverVariable2;
                                                                } else {
                                                                    solverVariable10 = solverVariable2;
                                                                    i19 = i18;
                                                                }
                                                                if (solverVariable8 != solverVariable10) {
                                                                    linearSystem.addGreaterThan(solverVariable10, solverVariable9, i19, 5);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    i23 = 6;
                                                    z19 = true;
                                                    z17 = false;
                                                    if (z17) {
                                                    }
                                                    z21 = z19;
                                                    if (!z20) {
                                                    }
                                                    if (this.mVisibility == 8) {
                                                    }
                                                }
                                            } else {
                                                if (i10 == 1) {
                                                    i28 = 8;
                                                    z20 = true;
                                                    z19 = true;
                                                    z18 = false;
                                                    z17 = true;
                                                } else if (i10 == 3) {
                                                    if (this.mResolvedDimensionRatioSide == -1) {
                                                        i23 = z8 ? z2 ? 5 : 4 : 8;
                                                        i29 = 8;
                                                        z19 = true;
                                                    } else {
                                                        if (z6) {
                                                            if (i6 != 2) {
                                                                z19 = true;
                                                                if (i6 != 1) {
                                                                    z25 = false;
                                                                    if (z25) {
                                                                        i31 = 8;
                                                                        i30 = 5;
                                                                    } else {
                                                                        i31 = 5;
                                                                        i30 = 4;
                                                                    }
                                                                    i22 = i31;
                                                                    i21 = i30;
                                                                    z20 = z19;
                                                                    z18 = z20;
                                                                    z17 = z18;
                                                                    i23 = 6;
                                                                }
                                                            } else {
                                                                z19 = true;
                                                            }
                                                            z25 = z19;
                                                            if (z25) {
                                                            }
                                                            i22 = i31;
                                                            i21 = i30;
                                                            z20 = z19;
                                                            z18 = z20;
                                                            z17 = z18;
                                                            i23 = 6;
                                                        } else {
                                                            z19 = true;
                                                            if (i34 > 0) {
                                                                i23 = 6;
                                                                i29 = 5;
                                                            } else if (i34 != 0 || i13 != 0) {
                                                                z24 = true;
                                                                z20 = true;
                                                                z18 = true;
                                                                z17 = z24;
                                                                i28 = 5;
                                                            } else if (!z8) {
                                                                z20 = true;
                                                                z18 = true;
                                                                z17 = true;
                                                                i23 = 6;
                                                                i22 = 5;
                                                                i21 = 8;
                                                            } else {
                                                                i28 = (constraintWidget5 == constraintWidget7 || constraintWidget6 == constraintWidget7) ? 5 : 4;
                                                                z20 = true;
                                                                z18 = true;
                                                                z17 = true;
                                                            }
                                                        }
                                                        if (z17) {
                                                        }
                                                        z21 = z19;
                                                        if (!z20) {
                                                        }
                                                        if (this.mVisibility == 8) {
                                                        }
                                                    }
                                                    i22 = i29;
                                                    z20 = z19;
                                                    z18 = z20;
                                                    z17 = z18;
                                                    i21 = 5;
                                                    if (z17) {
                                                    }
                                                    z21 = z19;
                                                    if (!z20) {
                                                    }
                                                    if (this.mVisibility == 8) {
                                                    }
                                                } else {
                                                    z19 = true;
                                                    z24 = false;
                                                    z20 = false;
                                                }
                                                i22 = i28;
                                                i23 = 6;
                                                i21 = 4;
                                                if (z17) {
                                                }
                                                z21 = z19;
                                                if (!z20) {
                                                }
                                                if (this.mVisibility == 8) {
                                                }
                                            }
                                            z18 = false;
                                            z17 = z24;
                                            i28 = 5;
                                            i22 = i28;
                                            i23 = 6;
                                            i21 = 4;
                                            if (z17) {
                                            }
                                            z21 = z19;
                                            if (!z20) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                        }
                                    } else {
                                        solverVariable8 = solverVariable3;
                                        linearSystem.addEquality(createObjectVariable2, solverVariable8, -constraintAnchor2.getMargin(), 8);
                                        if (z2) {
                                            i20 = 0;
                                            linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 5);
                                        } else {
                                            solverVariable9 = createObjectVariable2;
                                            z16 = z14;
                                        }
                                    }
                                    i18 = i20;
                                    solverVariable9 = createObjectVariable2;
                                    z16 = z14;
                                    if (!z2) {
                                        return;
                                    }
                                    return;
                                }
                                solverVariable9 = createObjectVariable2;
                                z16 = z14;
                                solverVariable8 = solverVariable3;
                                i18 = 0;
                                if (!z2) {
                                }
                            }
                            if (i16 < i15 && z2 && z15) {
                                linearSystem.addGreaterThan(solverVariable4, solverVariable5, i17, 8);
                                int i38 = (z || this.mBaseline.mTarget == null) ? i14 : i17;
                                if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                                    ConstraintWidget constraintWidget8 = constraintAnchor3.mOwner;
                                    i38 = (constraintWidget8.mDimensionRatio != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && (dimensionBehaviourArr = constraintWidget8.mListDimensionBehaviors)[i17] == (dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT) && dimensionBehaviourArr[i14] == dimensionBehaviour2) ? i14 : i17;
                                }
                                if (i38 != 0) {
                                    linearSystem.addGreaterThan(solverVariable7, solverVariable6, i17, 8);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        int max = Math.max(i33, i11);
                        if (i34 > 0) {
                            max = Math.min(i34, max);
                        }
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, max, 8);
                    }
                    z14 = z4;
                    i13 = i33;
                    z12 = false;
                    if (z10) {
                    }
                    if (i16 < i15) {
                        return;
                    }
                    return;
                }
                z14 = z4;
                i13 = i33;
                if (z10) {
                }
                if (i16 < i15) {
                }
            }
        }
        z11 = false;
        z12 = z11;
        if (this.mVisibility != 8) {
        }
        if (!z10) {
        }
        if (z12) {
        }
        z14 = z4;
        i13 = i33;
        if (z10) {
        }
        if (i16 < i15) {
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                throw new AssertionError(type.name());
        }
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public final boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (!(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i2].mTarget.mTarget == constraintAnchorArr[i2])) {
            int i3 = i2 + 1;
            return constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget == constraintAnchorArr[i3];
        }
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable();
        this.mTop.resetSolverVariable();
        this.mRight.resetSolverVariable();
        this.mBottom.resetSolverVariable();
        this.mBaseline.resetSolverVariable();
        this.mCenter.resetSolverVariable();
        this.mCenterX.resetSolverVariable();
        this.mCenterY.resetSolverVariable();
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(this.mType != null ? GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline15("type: "), this.mType, " ") : str);
        if (this.mDebugName != null) {
            str = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline15("id: "), this.mDebugName, " ");
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return GeneratedOutlineSupport.outline11(sb, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        boolean z3 = z & horizontalWidgetRun.resolved;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        boolean z4 = z2 & verticalWidgetRun.resolved;
        int i3 = horizontalWidgetRun.start.value;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.mX = i3;
        }
        if (z4) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (z3) {
            if (this.mListDimensionBehaviors[0] == dimensionBehaviour && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (z4) {
            if (this.mListDimensionBehaviors[1] == dimensionBehaviour && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int i;
        int i2;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                objectVariableValue = dependencyNode.value;
                objectVariableValue3 = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                objectVariableValue2 = dependencyNode3.value;
                objectVariableValue4 = dependencyNode4.value;
            }
        }
        int i3 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i3 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        int i4 = objectVariableValue3 - objectVariableValue;
        int i5 = objectVariableValue4 - objectVariableValue2;
        this.mX = objectVariableValue;
        this.mY = objectVariableValue2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == dimensionBehaviour && i4 < (i2 = this.mWidth)) {
            i4 = i2;
        }
        if (this.mListDimensionBehaviors[1] == dimensionBehaviour && i5 < (i = this.mHeight)) {
            i5 = i;
        }
        this.mWidth = i4;
        this.mHeight = i5;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
        int i7 = this.mWidth;
        int i8 = this.mMinWidth;
        if (i7 < i8) {
            this.mWidth = i8;
        }
    }
}
