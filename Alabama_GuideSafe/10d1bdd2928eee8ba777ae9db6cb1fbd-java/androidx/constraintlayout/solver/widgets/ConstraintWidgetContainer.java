package androidx.constraintlayout.solver.widgets;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ConstraintWidgetContainer extends WidgetContainer {
    public BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mHeightMeasuredTooSmall = false;
    public ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    public int mHorizontalChainsSize = 0;
    public boolean mIsRtl = false;
    public BasicMeasure.Measurer mMeasurer = null;
    public int mOptimizationLevel = 263;
    public int mPaddingLeft;
    public int mPaddingTop;
    public LinearSystem mSystem = new LinearSystem();
    public ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public int mVerticalChainsSize = 0;
    public boolean mWidthMeasuredTooSmall = false;

    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, this.mIsRtl);
            this.mHorizontalChainsSize++;
        } else if (i == 1) {
            int i3 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr2 = this.mVerticalChainsArray;
            if (i3 >= chainHeadArr2.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr2, chainHeadArr2.length * 2);
            }
            this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, this.mIsRtl);
            this.mVerticalChainsSize++;
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            boolean[] zArr = constraintWidget.mIsInBarrier;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int i3 = 0; i3 < barrier.mWidgetsCount; i3++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i3];
                        int i4 = barrier.mBarrierType;
                        if (i4 == 0 || i4 == 1) {
                            constraintWidget3.mIsInBarrier[0] = true;
                        } else if (i4 == 2 || i4 == 3) {
                            constraintWidget3.mIsInBarrier[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget4 = this.mChildren.get(i5);
            if (constraintWidget4 != null) {
                if ((constraintWidget4 instanceof VirtualLayout) || (constraintWidget4 instanceof Guideline)) {
                    constraintWidget4.addToSolver(linearSystem);
                }
            } else {
                throw null;
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget5 = this.mChildren.get(i6);
            if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[1];
                if (dimensionBehaviour3 == dimensionBehaviour2) {
                    dimensionBehaviourArr[0] = dimensionBehaviour;
                }
                if (dimensionBehaviour4 == dimensionBehaviour2) {
                    constraintWidget5.mListDimensionBehaviors[1] = dimensionBehaviour;
                }
                constraintWidget5.addToSolver(linearSystem);
                if (dimensionBehaviour3 == dimensionBehaviour2) {
                    constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour3);
                }
                if (dimensionBehaviour4 == dimensionBehaviour2) {
                    constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour4);
                }
            } else {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                constraintWidget5.mHorizontalResolution = -1;
                constraintWidget5.mVerticalResolution = -1;
                if (this.mListDimensionBehaviors[0] != dimensionBehaviour2 && constraintWidget5.mListDimensionBehaviors[0] == dimensionBehaviour5) {
                    int i7 = constraintWidget5.mLeft.mMargin;
                    int width = getWidth() - constraintWidget5.mRight.mMargin;
                    ConstraintAnchor constraintAnchor = constraintWidget5.mLeft;
                    constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
                    ConstraintAnchor constraintAnchor2 = constraintWidget5.mRight;
                    constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
                    linearSystem.addEquality(constraintWidget5.mLeft.mSolverVariable, i7);
                    linearSystem.addEquality(constraintWidget5.mRight.mSolverVariable, width);
                    constraintWidget5.mHorizontalResolution = 2;
                    constraintWidget5.mX = i7;
                    int i8 = width - i7;
                    constraintWidget5.mWidth = i8;
                    int i9 = constraintWidget5.mMinWidth;
                    if (i8 < i9) {
                        constraintWidget5.mWidth = i9;
                    }
                }
                if (this.mListDimensionBehaviors[1] != dimensionBehaviour2 && constraintWidget5.mListDimensionBehaviors[1] == dimensionBehaviour5) {
                    int i10 = constraintWidget5.mTop.mMargin;
                    int height = getHeight() - constraintWidget5.mBottom.mMargin;
                    ConstraintAnchor constraintAnchor3 = constraintWidget5.mTop;
                    constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
                    ConstraintAnchor constraintAnchor4 = constraintWidget5.mBottom;
                    constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
                    linearSystem.addEquality(constraintWidget5.mTop.mSolverVariable, i10);
                    linearSystem.addEquality(constraintWidget5.mBottom.mSolverVariable, height);
                    if (constraintWidget5.mBaselineDistance > 0 || constraintWidget5.mVisibility == 8) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget5.mBaseline;
                        constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
                        linearSystem.addEquality(constraintWidget5.mBaseline.mSolverVariable, constraintWidget5.mBaselineDistance + i10);
                    }
                    constraintWidget5.mVerticalResolution = 2;
                    constraintWidget5.mY = i10;
                    int i11 = height - i10;
                    constraintWidget5.mHeight = i11;
                    int i12 = constraintWidget5.mMinHeight;
                    if (i11 < i12) {
                        constraintWidget5.mHeight = i12;
                    }
                }
                if (!((constraintWidget5 instanceof VirtualLayout) || (constraintWidget5 instanceof Guideline))) {
                    constraintWidget5.addToSolver(linearSystem);
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            AppCompatDelegateImpl.ConfigurationImplApi17.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            AppCompatDelegateImpl.ConfigurationImplApi17.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013a A[EDGE_INSN: B:73:0x013a->B:59:0x013a ?: BREAK  , SYNTHETIC] */
    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2;
        Iterator<WidgetRun> it;
        Iterator<WidgetRun> it2;
        DependencyGraph dependencyGraph = this.mDependencyGraph;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dependencyGraph.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dependencyGraph.container.getDimensionBehaviour(1);
        int x = dependencyGraph.container.getX();
        int y = dependencyGraph.container.getY();
        if (z4 && (dimensionBehaviour4 == dimensionBehaviour2 || dimensionBehaviour5 == dimensionBehaviour2)) {
            Iterator<WidgetRun> it3 = dependencyGraph.mRuns.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                WidgetRun next = it3.next();
                if (next.orientation == i && !next.supportsWrapComputation()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour4 == dimensionBehaviour2) {
                    ConstraintWidgetContainer constraintWidgetContainer = dependencyGraph.container;
                    constraintWidgetContainer.mListDimensionBehaviors[0] = dimensionBehaviour3;
                    constraintWidgetContainer.setWidth(dependencyGraph.computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = dependencyGraph.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z4 && dimensionBehaviour5 == dimensionBehaviour2) {
                ConstraintWidgetContainer constraintWidgetContainer3 = dependencyGraph.container;
                constraintWidgetContainer3.mListDimensionBehaviors[1] = dimensionBehaviour3;
                constraintWidgetContainer3.setHeight(dependencyGraph.computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = dependencyGraph.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i == 0) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dependencyGraph.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr[0] == dimensionBehaviour3 || dimensionBehaviourArr[0] == dimensionBehaviour) {
                int width = dependencyGraph.container.getWidth() + x;
                dependencyGraph.container.horizontalRun.end.resolve(width);
                dependencyGraph.container.horizontalRun.dimension.resolve(width - x);
                z2 = true;
                dependencyGraph.measureWidgets();
                it = dependencyGraph.mRuns.iterator();
                while (it.hasNext()) {
                    WidgetRun next2 = it.next();
                    if (next2.orientation == i && (next2.widget != dependencyGraph.container || next2.resolved)) {
                        next2.applyToWidget();
                    }
                }
                it2 = dependencyGraph.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    WidgetRun next3 = it2.next();
                    if (next3.orientation == i && ((z2 || next3.widget != dependencyGraph.container) && (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)))) {
                        z3 = false;
                    }
                }
                z3 = false;
                dependencyGraph.container.setHorizontalDimensionBehaviour(dimensionBehaviour4);
                dependencyGraph.container.setVerticalDimensionBehaviour(dimensionBehaviour5);
                return z3;
            }
        } else {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dependencyGraph.container.mListDimensionBehaviors;
            if (dimensionBehaviourArr2[1] == dimensionBehaviour3 || dimensionBehaviourArr2[1] == dimensionBehaviour) {
                int height = dependencyGraph.container.getHeight() + y;
                dependencyGraph.container.verticalRun.end.resolve(height);
                dependencyGraph.container.verticalRun.dimension.resolve(height - y);
                z2 = true;
                dependencyGraph.measureWidgets();
                it = dependencyGraph.mRuns.iterator();
                while (it.hasNext()) {
                }
                it2 = dependencyGraph.mRuns.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                    }
                }
                z3 = false;
                dependencyGraph.container.setHorizontalDimensionBehaviour(dimensionBehaviour4);
                dependencyGraph.container.setVerticalDimensionBehaviour(dimensionBehaviour5);
                return z3;
            }
        }
        z2 = false;
        dependencyGraph.measureWidgets();
        it = dependencyGraph.mRuns.iterator();
        while (it.hasNext()) {
        }
        it2 = dependencyGraph.mRuns.iterator();
        while (true) {
            if (!it2.hasNext()) {
            }
        }
        z3 = false;
        dependencyGraph.container.setHorizontalDimensionBehaviour(dimensionBehaviour4);
        dependencyGraph.container.setVerticalDimensionBehaviour(dimensionBehaviour5);
        return z3;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.mNeedBuildGraph = true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x019a */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e8  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        boolean z;
        int size;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int max;
        int max2;
        ?? r4;
        Exception e;
        boolean z7;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        int i2 = 0;
        this.mX = 0;
        this.mY = 0;
        int max3 = Math.max(0, getWidth());
        int max4 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (!((this.mOptimizationLevel & 64) == 64)) {
            if (!((this.mOptimizationLevel & 128) == 128)) {
                z = false;
                LinearSystem linearSystem = this.mSystem;
                linearSystem.graphOptimizer = false;
                linearSystem.newgraphOptimizer = false;
                if (this.mOptimizationLevel != 0 && z) {
                    linearSystem.newgraphOptimizer = true;
                }
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
                ArrayList<ConstraintWidget> arrayList = this.mChildren;
                boolean z8 = getHorizontalDimensionBehaviour() != dimensionBehaviour2 || getVerticalDimensionBehaviour() == dimensionBehaviour2;
                this.mHorizontalChainsSize = 0;
                this.mVerticalChainsSize = 0;
                size = this.mChildren.size();
                for (i = 0; i < size; i++) {
                    ConstraintWidget constraintWidget = this.mChildren.get(i);
                    if (constraintWidget instanceof WidgetContainer) {
                        ((WidgetContainer) constraintWidget).layout();
                    }
                }
                int i3 = 0;
                z2 = false;
                z3 = true;
                boolean z9 = z8;
                while (z3) {
                    int i4 = i3 + 1;
                    try {
                        this.mSystem.reset();
                        this.mHorizontalChainsSize = i2;
                        this.mVerticalChainsSize = i2;
                        createObjectVariables(this.mSystem);
                        for (int i5 = i2; i5 < size; i5++) {
                            this.mChildren.get(i5).createObjectVariables(this.mSystem);
                        }
                        addChildrenToSolver(this.mSystem);
                        try {
                            LinearSystem linearSystem2 = this.mSystem;
                            if (!linearSystem2.graphOptimizer) {
                                if (!linearSystem2.newgraphOptimizer) {
                                    linearSystem2.minimizeGoal(linearSystem2.mGoal);
                                    z4 = true;
                                    if (!z4) {
                                        LinearSystem linearSystem3 = this.mSystem;
                                        Optimizer.flags[2] = false;
                                        updateFromSolver(linearSystem3);
                                        int size2 = this.mChildren.size();
                                        for (int i6 = 0; i6 < size2; i6++) {
                                            this.mChildren.get(i6).updateFromSolver(linearSystem3);
                                        }
                                    } else {
                                        updateFromSolver(this.mSystem);
                                        for (int i7 = 0; i7 < size; i7++) {
                                            this.mChildren.get(i7).updateFromSolver(this.mSystem);
                                        }
                                    }
                                    if (z9 || i4 >= 8 || !Optimizer.flags[2]) {
                                        z5 = z9;
                                        z6 = false;
                                    } else {
                                        int i8 = 0;
                                        int i9 = 0;
                                        int i10 = 0;
                                        boolean z10 = z9;
                                        while (i8 < size) {
                                            ConstraintWidget constraintWidget2 = this.mChildren.get(i8);
                                            i9 = Math.max(i9, constraintWidget2.getWidth() + constraintWidget2.mX);
                                            i10 = Math.max(i10, constraintWidget2.getHeight() + constraintWidget2.mY);
                                            i8++;
                                            z10 = z10;
                                        }
                                        z5 = z10;
                                        int max5 = Math.max(this.mMinWidth, i9);
                                        int max6 = Math.max(this.mMinHeight, i10);
                                        if (dimensionBehaviour4 != dimensionBehaviour2 || getWidth() >= max5) {
                                            z6 = false;
                                        } else {
                                            setWidth(max5);
                                            this.mListDimensionBehaviors[0] = dimensionBehaviour2;
                                            z6 = true;
                                            z2 = true;
                                        }
                                        if (dimensionBehaviour3 == dimensionBehaviour2 && getHeight() < max6) {
                                            setHeight(max6);
                                            this.mListDimensionBehaviors[1] = dimensionBehaviour2;
                                            z6 = true;
                                            z2 = true;
                                        }
                                    }
                                    max = Math.max(this.mMinWidth, getWidth());
                                    if (max > getWidth()) {
                                        setWidth(max);
                                        this.mListDimensionBehaviors[0] = dimensionBehaviour;
                                        z6 = true;
                                        z2 = true;
                                    }
                                    max2 = Math.max(this.mMinHeight, getHeight());
                                    if (max2 <= getHeight()) {
                                        setHeight(max2);
                                        r4 = 1;
                                        this.mListDimensionBehaviors[1] = dimensionBehaviour;
                                        z6 = true;
                                        z2 = true;
                                    } else {
                                        r4 = 1;
                                    }
                                    if (!z2) {
                                        if (this.mListDimensionBehaviors[0] == dimensionBehaviour2 && max3 > 0 && getWidth() > max3) {
                                            this.mWidthMeasuredTooSmall = r4;
                                            this.mListDimensionBehaviors[0] = dimensionBehaviour;
                                            setWidth(max3);
                                            boolean z11 = r4 == true ? 1 : 0;
                                            boolean z12 = r4 == true ? 1 : 0;
                                            boolean z13 = r4 == true ? 1 : 0;
                                            z6 = z11;
                                            z2 = z6;
                                        }
                                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                                        char c = r4 == true ? 1 : 0;
                                        char c2 = r4 == true ? 1 : 0;
                                        char c3 = r4 == true ? 1 : 0;
                                        if (dimensionBehaviourArr2[c] == dimensionBehaviour2 && max4 > 0 && getHeight() > max4) {
                                            this.mHeightMeasuredTooSmall = r4;
                                            this.mListDimensionBehaviors[r4] = dimensionBehaviour;
                                            setHeight(max4);
                                            z3 = true;
                                            z2 = true;
                                            i3 = i4;
                                            z9 = z5;
                                            i2 = 0;
                                        }
                                    }
                                    z3 = z6;
                                    i3 = i4;
                                    z9 = z5;
                                    i2 = 0;
                                }
                            }
                            int i11 = 0;
                            while (true) {
                                if (i11 >= linearSystem2.mNumRows) {
                                    z7 = true;
                                    break;
                                } else if (!linearSystem2.mRows[i11].isSimpleDefinition) {
                                    z7 = false;
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                            if (!z7) {
                                linearSystem2.minimizeGoal(linearSystem2.mGoal);
                            } else {
                                linearSystem2.computeValues();
                            }
                            z4 = true;
                        } catch (Exception e2) {
                            e = e2;
                            z3 = true;
                            e.printStackTrace();
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder();
                            z4 = z3;
                            sb.append("EXCEPTION : ");
                            sb.append(e);
                            printStream.println(sb.toString());
                            if (!z4) {
                            }
                            if (z9) {
                            }
                            z5 = z9;
                            z6 = false;
                            max = Math.max(this.mMinWidth, getWidth());
                            if (max > getWidth()) {
                            }
                            max2 = Math.max(this.mMinHeight, getHeight());
                            if (max2 <= getHeight()) {
                            }
                            if (!z2) {
                            }
                            z3 = z6;
                            i3 = i4;
                            z9 = z5;
                            i2 = 0;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        PrintStream printStream2 = System.out;
                        StringBuilder sb2 = new StringBuilder();
                        z4 = z3;
                        sb2.append("EXCEPTION : ");
                        sb2.append(e);
                        printStream2.println(sb2.toString());
                        if (!z4) {
                        }
                        if (z9) {
                        }
                        z5 = z9;
                        z6 = false;
                        max = Math.max(this.mMinWidth, getWidth());
                        if (max > getWidth()) {
                        }
                        max2 = Math.max(this.mMinHeight, getHeight());
                        if (max2 <= getHeight()) {
                        }
                        if (!z2) {
                        }
                        z3 = z6;
                        i3 = i4;
                        z9 = z5;
                        i2 = 0;
                    }
                    if (!z4) {
                    }
                    if (z9) {
                    }
                    z5 = z9;
                    z6 = false;
                    max = Math.max(this.mMinWidth, getWidth());
                    if (max > getWidth()) {
                    }
                    max2 = Math.max(this.mMinHeight, getHeight());
                    if (max2 <= getHeight()) {
                    }
                    if (!z2) {
                    }
                    z3 = z6;
                    i3 = i4;
                    z9 = z5;
                    i2 = 0;
                }
                this.mChildren = arrayList;
                if (z2) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                    dimensionBehaviourArr3[0] = dimensionBehaviour4;
                    dimensionBehaviourArr3[1] = dimensionBehaviour3;
                }
                resetSolverVariables(this.mSystem.mCache);
            }
        }
        z = true;
        LinearSystem linearSystem4 = this.mSystem;
        linearSystem4.graphOptimizer = false;
        linearSystem4.newgraphOptimizer = false;
        linearSystem4.newgraphOptimizer = true;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour32 = dimensionBehaviourArr4[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour42 = dimensionBehaviourArr4[0];
        ArrayList<ConstraintWidget> arrayList2 = this.mChildren;
        if (getHorizontalDimensionBehaviour() != dimensionBehaviour2) {
        }
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        size = this.mChildren.size();
        while (i < size) {
        }
        int i32 = 0;
        z2 = false;
        z3 = true;
        boolean z92 = z8;
        while (z3) {
        }
        this.mChildren = arrayList2;
        if (z2) {
        }
        resetSolverVariables(this.mSystem.mCache);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.WidgetContainer
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        super.reset();
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(i, 256);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromRuns(z, z2);
        }
    }
}
