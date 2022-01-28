package androidx.constraintlayout.solver.widgets;

public class VirtualLayout extends HelperWidget {
    public boolean mNeedsCallFromSolver = false;

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
        }
    }
}
