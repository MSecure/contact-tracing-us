package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {
    public DimensionDependency dimension = new DimensionDependency(this);
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end = new DependencyNode(this);
    public RunType mRunType = RunType.NONE;
    public int matchConstraintsType;
    public int orientation = 0;
    public boolean resolved = false;
    public RunGroup runGroup;
    public DependencyNode start = new DependencyNode(this);
    public ConstraintWidget widget;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        int i3;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i4 = constraintWidget.mMatchConstraintMaxWidth;
            i3 = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i4 > 0) {
                i3 = Math.min(i4, i);
            }
            if (i3 == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i5 = constraintWidget2.mMatchConstraintMaxHeight;
            i3 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i5 > 0) {
                i3 = Math.min(i5, i);
            }
            if (i3 == i) {
                return i;
            }
        }
        return i3;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int ordinal = constraintAnchor2.mType.ordinal();
        if (ordinal == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (ordinal == 2) {
            return constraintWidget.verticalRun.start;
        }
        if (ordinal == 3) {
            return constraintWidget.horizontalRun.end;
        }
        if (ordinal == 4) {
            return constraintWidget.verticalRun.end;
        }
        if (ordinal != 5) {
            return null;
        }
        return constraintWidget.verticalRun.baseline;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return (long) dimensionDependency.value;
        }
        return 0;
    }

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r4.matchConstraintsType == 3) goto L_0x00c4;
     */
    public void updateRunCenter(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        float f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i2;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i3 = margin2 - margin;
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved && this.dimensionBehavior == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                int i4 = this.matchConstraintsType;
                if (i4 == 0) {
                    dimensionDependency.resolve(getLimitedDimension(i3, i));
                } else if (i4 == 1) {
                    this.dimension.resolve(Math.min(getLimitedDimension(dimensionDependency.wrapValue, i), i3));
                } else if (i4 == 2) {
                    ConstraintWidget constraintWidget = this.widget.mParent;
                    if (constraintWidget != null) {
                        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
                        if (widgetRun.dimension.resolved) {
                            ConstraintWidget constraintWidget2 = this.widget;
                            this.dimension.resolve(getLimitedDimension((int) ((((float) widgetRun.dimension.value) * (i == 0 ? constraintWidget2.mMatchConstraintPercentWidth : constraintWidget2.mMatchConstraintPercentHeight)) + 0.5f), i));
                        }
                    }
                } else if (i4 == 3) {
                    ConstraintWidget constraintWidget3 = this.widget;
                    HorizontalWidgetRun horizontalWidgetRun = constraintWidget3.horizontalRun;
                    if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour && horizontalWidgetRun.matchConstraintsType == 3) {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                        if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour) {
                        }
                    }
                    ConstraintWidget constraintWidget4 = this.widget;
                    DimensionDependency dimensionDependency2 = (i == 0 ? constraintWidget4.verticalRun : constraintWidget4.horizontalRun).dimension;
                    if (dimensionDependency2.resolved) {
                        float f2 = this.widget.mDimensionRatio;
                        if (i == 1) {
                            i2 = (int) ((((float) dimensionDependency2.value) / f2) + 0.5f);
                        } else {
                            i2 = (int) ((f2 * ((float) dimensionDependency2.value)) + 0.5f);
                        }
                        this.dimension.resolve(i2);
                    }
                }
            }
            DimensionDependency dimensionDependency3 = this.dimension;
            if (dimensionDependency3.resolved) {
                if (dimensionDependency3.value == i3) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget5 = this.widget;
                if (i == 0) {
                    f = constraintWidget5.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget5.mVerticalBiasPercent;
                }
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    f = 0.5f;
                }
                this.start.resolve((int) ((((float) ((margin2 - margin) - this.dimension.value)) * f) + ((float) margin) + 0.5f));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int ordinal = constraintAnchor.mTarget.mType.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return widgetRun.start;
        }
        if (ordinal == 3 || ordinal == 4) {
            return widgetRun.end;
        }
        return null;
    }
}
