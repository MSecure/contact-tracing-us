package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;

public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    public DimensionDependency baselineDimension = null;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        dependencyNode.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget constraintWidget4 = this.widget;
        if (constraintWidget4.measured) {
            this.dimension.resolve(constraintWidget4.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline) {
                this.baselineDimension = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
            if (dimensionBehaviour4 != dimensionBehaviour3) {
                if (dimensionBehaviour4 == dimensionBehaviour && (constraintWidget3 = this.widget.mParent) != null && constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2) {
                    int height = (constraintWidget3.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    addTarget(this.start, constraintWidget3.verticalRun.start, this.widget.mTop.getMargin());
                    addTarget(this.end, constraintWidget3.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(height);
                    return;
                } else if (this.dimensionBehavior == dimensionBehaviour2) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == dimensionBehaviour && (constraintWidget2 = this.widget.mParent) != null && constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour2) {
            addTarget(this.start, constraintWidget2.verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, constraintWidget2.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        if (this.dimension.resolved) {
            ConstraintWidget constraintWidget5 = this.widget;
            if (constraintWidget5.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.mListAnchors;
                if (constraintAnchorArr[2].mTarget == null || constraintAnchorArr[3].mTarget == null) {
                    ConstraintWidget constraintWidget6 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget6.mListAnchors;
                    if (constraintAnchorArr2[2].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr2[2]);
                        if (target != null) {
                            DependencyNode dependencyNode = this.start;
                            int margin = this.widget.mListAnchors[2].getMargin();
                            dependencyNode.targets.add(target);
                            dependencyNode.margin = margin;
                            target.dependencies.add(dependencyNode);
                            addTarget(this.end, this.start, this.dimension.value);
                            ConstraintWidget constraintWidget7 = this.widget;
                            if (constraintWidget7.hasBaseline) {
                                addTarget(this.baseline, this.start, constraintWidget7.mBaselineDistance);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[3].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr2[3]);
                        if (target2 != null) {
                            DependencyNode dependencyNode2 = this.end;
                            dependencyNode2.targets.add(target2);
                            dependencyNode2.margin = -this.widget.mListAnchors[3].getMargin();
                            target2.dependencies.add(dependencyNode2);
                            addTarget(this.start, this.end, -this.dimension.value);
                        }
                        ConstraintWidget constraintWidget8 = this.widget;
                        if (constraintWidget8.hasBaseline) {
                            addTarget(this.baseline, this.start, constraintWidget8.mBaselineDistance);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[4].mTarget != null) {
                        DependencyNode target3 = getTarget(constraintAnchorArr2[4]);
                        if (target3 != null) {
                            DependencyNode dependencyNode3 = this.baseline;
                            dependencyNode3.targets.add(target3);
                            dependencyNode3.margin = 0;
                            target3.dependencies.add(dependencyNode3);
                            addTarget(this.start, this.baseline, -this.widget.mBaselineDistance);
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget6 instanceof Helper) && constraintWidget6.mParent != null && constraintWidget6.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        ConstraintWidget constraintWidget9 = this.widget;
                        addTarget(this.start, constraintWidget9.mParent.verticalRun.start, constraintWidget9.getY());
                        addTarget(this.end, this.start, this.dimension.value);
                        ConstraintWidget constraintWidget10 = this.widget;
                        if (constraintWidget10.hasBaseline) {
                            addTarget(this.baseline, this.start, constraintWidget10.mBaselineDistance);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (constraintWidget5.isInVerticalChain()) {
                        this.start.margin = this.widget.mListAnchors[2].getMargin();
                        this.end.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target4 = getTarget(this.widget.mListAnchors[2]);
                        if (target4 != null) {
                            DependencyNode dependencyNode4 = this.start;
                            int margin2 = this.widget.mListAnchors[2].getMargin();
                            dependencyNode4.targets.add(target4);
                            dependencyNode4.margin = margin2;
                            target4.dependencies.add(dependencyNode4);
                        }
                        DependencyNode target5 = getTarget(this.widget.mListAnchors[3]);
                        if (target5 != null) {
                            DependencyNode dependencyNode5 = this.end;
                            dependencyNode5.targets.add(target5);
                            dependencyNode5.margin = -this.widget.mListAnchors[3].getMargin();
                            target5.dependencies.add(dependencyNode5);
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    ConstraintWidget constraintWidget11 = this.widget;
                    if (constraintWidget11.hasBaseline) {
                        addTarget(this.baseline, this.start, constraintWidget11.mBaselineDistance);
                        return;
                    }
                    return;
                }
            }
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved || this.dimensionBehavior != dimensionBehaviour3) {
            DimensionDependency dimensionDependency2 = this.dimension;
            dimensionDependency2.dependencies.add(this);
            if (dimensionDependency2.resolved) {
                update(this);
            }
        } else {
            ConstraintWidget constraintWidget12 = this.widget;
            int i = constraintWidget12.mMatchConstraintDefaultHeight;
            if (i == 2) {
                ConstraintWidget constraintWidget13 = constraintWidget12.mParent;
                if (constraintWidget13 != null) {
                    DimensionDependency dimensionDependency3 = constraintWidget13.verticalRun.dimension;
                    dimensionDependency.targets.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency4 = this.dimension;
                    dimensionDependency4.delegateToWidgetRun = true;
                    dimensionDependency4.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3 && !constraintWidget12.isInVerticalChain()) {
                ConstraintWidget constraintWidget14 = this.widget;
                if (constraintWidget14.mMatchConstraintDefaultWidth != 3) {
                    DimensionDependency dimensionDependency5 = constraintWidget14.horizontalRun.dimension;
                    this.dimension.targets.add(dimensionDependency5);
                    dimensionDependency5.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency6 = this.dimension;
                    dimensionDependency6.delegateToWidgetRun = true;
                    dimensionDependency6.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget15 = this.widget;
        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget15.mListAnchors;
        if (constraintAnchorArr3[2].mTarget == null || constraintAnchorArr3[3].mTarget == null) {
            ConstraintWidget constraintWidget16 = this.widget;
            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget16.mListAnchors;
            if (constraintAnchorArr4[2].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr4[2]);
                if (target6 != null) {
                    DependencyNode dependencyNode6 = this.start;
                    int margin3 = this.widget.mListAnchors[2].getMargin();
                    dependencyNode6.targets.add(target6);
                    dependencyNode6.margin = margin3;
                    target6.dependencies.add(dependencyNode6);
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    if (this.dimensionBehavior == dimensionBehaviour3) {
                        ConstraintWidget constraintWidget17 = this.widget;
                        if (constraintWidget17.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            HorizontalWidgetRun horizontalWidgetRun = constraintWidget17.horizontalRun;
                            if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                                horizontalWidgetRun.dimension.dependencies.add(this.dimension);
                                this.dimension.targets.add(this.widget.horizontalRun.dimension);
                                this.dimension.updateDelegate = this;
                            }
                        }
                    }
                }
            } else if (constraintAnchorArr4[3].mTarget != null) {
                DependencyNode target7 = getTarget(constraintAnchorArr4[3]);
                if (target7 != null) {
                    DependencyNode dependencyNode7 = this.end;
                    dependencyNode7.targets.add(target7);
                    dependencyNode7.margin = -this.widget.mListAnchors[3].getMargin();
                    target7.dependencies.add(dependencyNode7);
                    addTarget(this.start, this.end, -1, this.dimension);
                    if (this.widget.hasBaseline) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                }
            } else if (constraintAnchorArr4[4].mTarget != null) {
                DependencyNode target8 = getTarget(constraintAnchorArr4[4]);
                if (target8 != null) {
                    DependencyNode dependencyNode8 = this.baseline;
                    dependencyNode8.targets.add(target8);
                    dependencyNode8.margin = 0;
                    target8.dependencies.add(dependencyNode8);
                    addTarget(this.start, this.baseline, -1, this.baselineDimension);
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (!(constraintWidget16 instanceof Helper) && (constraintWidget = constraintWidget16.mParent) != null) {
                addTarget(this.start, constraintWidget.verticalRun.start, constraintWidget16.getY());
                addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                if (this.dimensionBehavior == dimensionBehaviour3) {
                    ConstraintWidget constraintWidget18 = this.widget;
                    if (constraintWidget18.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget18.horizontalRun;
                        if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour3) {
                            horizontalWidgetRun2.dimension.dependencies.add(this.dimension);
                            this.dimension.targets.add(this.widget.horizontalRun.dimension);
                            this.dimension.updateDelegate = this;
                        }
                    }
                }
            }
        } else {
            if (constraintWidget15.isInVerticalChain()) {
                this.start.margin = this.widget.mListAnchors[2].getMargin();
                this.end.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target9 = getTarget(this.widget.mListAnchors[2]);
                DependencyNode target10 = getTarget(this.widget.mListAnchors[3]);
                target9.dependencies.add(this);
                if (target9.resolved) {
                    update(this);
                }
                target10.dependencies.add(this);
                if (target10.resolved) {
                    update(this);
                }
                this.mRunType = WidgetRun.RunType.CENTER;
            }
            if (this.widget.hasBaseline) {
                addTarget(this.baseline, this.start, 1, this.baselineDimension);
            }
        }
        if (this.dimension.targets.size() == 0) {
            this.dimension.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("VerticalRun ");
        outline17.append(this.widget.mDebugName);
        return outline17.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void update(Dependency dependency) {
        int i;
        float f;
        float f2;
        float f3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        int ordinal = this.mRunType.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            DimensionDependency dimensionDependency = this.dimension;
            if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == dimensionBehaviour) {
                ConstraintWidget constraintWidget = this.widget;
                int i2 = constraintWidget.mMatchConstraintDefaultHeight;
                if (i2 == 2) {
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        DimensionDependency dimensionDependency2 = constraintWidget2.verticalRun.dimension;
                        if (dimensionDependency2.resolved) {
                            dimensionDependency.resolve((int) ((((float) dimensionDependency2.value) * constraintWidget.mMatchConstraintPercentHeight) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    DimensionDependency dimensionDependency3 = constraintWidget.horizontalRun.dimension;
                    if (dimensionDependency3.resolved) {
                        int i3 = constraintWidget.mDimensionRatioSide;
                        if (i3 == -1) {
                            f3 = (float) dimensionDependency3.value;
                            f2 = constraintWidget.mDimensionRatio;
                        } else if (i3 == 0) {
                            f = ((float) dimensionDependency3.value) * constraintWidget.mDimensionRatio;
                            i = (int) (f + 0.5f);
                            this.dimension.resolve(i);
                        } else if (i3 != 1) {
                            i = 0;
                            this.dimension.resolve(i);
                        } else {
                            f3 = (float) dimensionDependency3.value;
                            f2 = constraintWidget.mDimensionRatio;
                        }
                        f = f3 / f2;
                        i = (int) (f + 0.5f);
                        this.dimension.resolve(i);
                    }
                }
            }
            DependencyNode dependencyNode = this.start;
            if (dependencyNode.readyToSolve) {
                DependencyNode dependencyNode2 = this.end;
                if (dependencyNode2.readyToSolve) {
                    if (!dependencyNode.resolved || !dependencyNode2.resolved || !this.dimension.resolved) {
                        if (!this.dimension.resolved && this.dimensionBehavior == dimensionBehaviour) {
                            ConstraintWidget constraintWidget3 = this.widget;
                            if (constraintWidget3.mMatchConstraintDefaultWidth == 0 && !constraintWidget3.isInVerticalChain()) {
                                int i4 = this.start.targets.get(0).value;
                                DependencyNode dependencyNode3 = this.start;
                                int i5 = i4 + dependencyNode3.margin;
                                int i6 = this.end.targets.get(0).value + this.end.margin;
                                dependencyNode3.resolve(i5);
                                this.end.resolve(i6);
                                this.dimension.resolve(i6 - i5);
                                return;
                            }
                        }
                        if (!this.dimension.resolved && this.dimensionBehavior == dimensionBehaviour && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                            int i7 = (this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin);
                            DimensionDependency dimensionDependency4 = this.dimension;
                            int i8 = dimensionDependency4.wrapValue;
                            if (i7 < i8) {
                                dimensionDependency4.resolve(i7);
                            } else {
                                dimensionDependency4.resolve(i8);
                            }
                        }
                        if (this.dimension.resolved && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                            DependencyNode dependencyNode4 = this.start.targets.get(0);
                            DependencyNode dependencyNode5 = this.end.targets.get(0);
                            int i9 = dependencyNode4.value;
                            int i10 = this.start.margin + i9;
                            int i11 = dependencyNode5.value;
                            int i12 = this.end.margin + i11;
                            float f4 = this.widget.mVerticalBiasPercent;
                            if (dependencyNode4 == dependencyNode5) {
                                f4 = 0.5f;
                            } else {
                                i9 = i10;
                                i11 = i12;
                            }
                            this.start.resolve((int) ((((float) ((i11 - i9) - this.dimension.value)) * f4) + ((float) i9) + 0.5f));
                            this.end.resolve(this.start.value + this.dimension.value);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        ConstraintWidget constraintWidget4 = this.widget;
        updateRunCenter(constraintWidget4.mTop, constraintWidget4.mBottom, 1);
    }
}
