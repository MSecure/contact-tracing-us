package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;

public class BasicMeasure {
    public ConstraintWidgetContainer constraintWidgetContainer;
    public Measure mMeasure = new Measure();
    public final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    public final boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.horizontalBehavior;
        boolean z2 = true;
        boolean z3 = dimensionBehaviour3 == dimensionBehaviour2;
        boolean z4 = this.mMeasure.verticalBehavior == dimensionBehaviour2;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        boolean z6 = z4 && constraintWidget.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        if (z5 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = dimensionBehaviour;
        }
        if (z6 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = dimensionBehaviour;
        }
        ((ConstraintLayout.Measurer) measurer).measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        Measure measure2 = this.mMeasure;
        constraintWidget.hasBaseline = measure2.measuredHasBaseline;
        int i = measure2.measuredBaseline;
        constraintWidget.mBaselineDistance = i;
        if (i <= 0) {
            z2 = false;
        }
        constraintWidget.hasBaseline = z2;
        Measure measure3 = this.mMeasure;
        measure3.useCurrentDimensions = false;
        return measure3.measuredNeedsSolverPass;
    }

    public final void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, int i, int i2) {
        int i3 = constraintWidgetContainer2.mMinWidth;
        int i4 = constraintWidgetContainer2.mMinHeight;
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.mWidth = i;
        int i5 = constraintWidgetContainer2.mMinWidth;
        if (i < i5) {
            constraintWidgetContainer2.mWidth = i5;
        }
        constraintWidgetContainer2.mHeight = i2;
        int i6 = constraintWidgetContainer2.mMinHeight;
        if (i2 < i6) {
            constraintWidgetContainer2.mHeight = i6;
        }
        constraintWidgetContainer2.setMinWidth(i3);
        constraintWidgetContainer2.setMinHeight(i4);
        this.constraintWidgetContainer.layout();
    }
}
