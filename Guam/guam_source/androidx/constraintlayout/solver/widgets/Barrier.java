package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.android.tools.r8.GeneratedOutlineSupport;

public class Barrier extends HelperWidget {
    public boolean mAllowsGoneWidget = true;
    public int mBarrierType = 0;
    public int mMargin = 0;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        Object[] objArr;
        boolean z;
        int i;
        int i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        constraintAnchorArr[0] = this.mLeft;
        constraintAnchorArr[2] = this.mTop;
        constraintAnchorArr[1] = this.mRight;
        constraintAnchorArr[3] = this.mBottom;
        int i3 = 0;
        while (true) {
            objArr = this.mListAnchors;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].mSolverVariable = linearSystem.createObjectVariable(objArr[i3]);
            i3++;
        }
        int i4 = this.mBarrierType;
        if (i4 >= 0 && i4 < 4) {
            ConstraintAnchor constraintAnchor = objArr[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= this.mWidgetsCount) {
                    z = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i5];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            z = true;
            boolean z2 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
            boolean z3 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
            boolean z4 = !z && ((this.mBarrierType == 0 && z2) || ((this.mBarrierType == 2 && z3) || ((this.mBarrierType == 1 && z2) || (this.mBarrierType == 3 && z3))));
            int i6 = 5;
            if (!z4) {
                i6 = 4;
            }
            for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i7];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                    int i8 = this.mBarrierType;
                    constraintAnchorArr2[i8].mSolverVariable = createObjectVariable;
                    int i9 = (constraintAnchorArr2[i8].mTarget == null || constraintAnchorArr2[i8].mTarget.mOwner != this) ? 0 : constraintAnchorArr2[i8].mMargin + 0;
                    int i10 = this.mBarrierType;
                    if (i10 == 0 || i10 == 2) {
                        ArrayRow createRow = linearSystem.createRow();
                        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
                        createSlackVariable.strength = 0;
                        createRow.createRowLowerThan(constraintAnchor.mSolverVariable, createObjectVariable, createSlackVariable, this.mMargin - i9);
                        linearSystem.addConstraint(createRow);
                    } else {
                        ArrayRow createRow2 = linearSystem.createRow();
                        SolverVariable createSlackVariable2 = linearSystem.createSlackVariable();
                        createSlackVariable2.strength = 0;
                        createRow2.createRowGreaterThan(constraintAnchor.mSolverVariable, createObjectVariable, createSlackVariable2, this.mMargin + i9);
                        linearSystem.addConstraint(createRow2);
                    }
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i9, i6);
                }
            }
            int i11 = this.mBarrierType;
            if (i11 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            } else if (i11 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (i11 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (i11 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String outline12 = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline15("[Barrier] "), this.mDebugName, " {");
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                outline12 = GeneratedOutlineSupport.outline8(outline12, ", ");
            }
            StringBuilder outline15 = GeneratedOutlineSupport.outline15(outline12);
            outline15.append(constraintWidget.mDebugName);
            outline12 = outline15.toString();
        }
        return GeneratedOutlineSupport.outline8(outline12, "}");
    }
}
