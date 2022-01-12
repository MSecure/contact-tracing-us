package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import com.android.tools.r8.GeneratedOutlineSupport;

public class HorizontalWidgetRun extends WidgetRun {
    public static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget constraintWidget4 = this.widget;
        if (constraintWidget4.measured) {
            this.dimension.resolve(constraintWidget4.getWidth());
        }
        if (!this.dimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != dimensionBehaviour) {
                if (horizontalDimensionBehaviour == dimensionBehaviour3 && (((constraintWidget3 = this.widget.mParent) != null && constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2) || constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                    int width = (constraintWidget3.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, constraintWidget3.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, constraintWidget3.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                } else if (this.dimensionBehavior == dimensionBehaviour2) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == dimensionBehaviour3 && (((constraintWidget2 = this.widget.mParent) != null && constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour2) || constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
            addTarget(this.start, constraintWidget2.horizontalRun.start, this.widget.mLeft.getMargin());
            addTarget(this.end, constraintWidget2.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        if (this.dimension.resolved) {
            ConstraintWidget constraintWidget5 = this.widget;
            if (constraintWidget5.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.mListAnchors;
                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                    ConstraintWidget constraintWidget6 = this.widget;
                    ConstraintAnchor[] constraintAnchorArr2 = constraintWidget6.mListAnchors;
                    if (constraintAnchorArr2[0].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr2[0]);
                        if (target != null) {
                            DependencyNode dependencyNode = this.start;
                            int margin = this.widget.mListAnchors[0].getMargin();
                            dependencyNode.targets.add(target);
                            dependencyNode.margin = margin;
                            target.dependencies.add(dependencyNode);
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr2[1].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr2[1]);
                        if (target2 != null) {
                            DependencyNode dependencyNode2 = this.end;
                            dependencyNode2.targets.add(target2);
                            dependencyNode2.margin = -this.widget.mListAnchors[1].getMargin();
                            target2.dependencies.add(dependencyNode2);
                            addTarget(this.start, this.end, -this.dimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget6 instanceof Helper) && constraintWidget6.mParent != null && constraintWidget6.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        ConstraintWidget constraintWidget7 = this.widget;
                        addTarget(this.start, constraintWidget7.mParent.horizontalRun.start, constraintWidget7.getX());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget5.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = getTarget(this.widget.mListAnchors[0]);
                    if (target3 != null) {
                        DependencyNode dependencyNode3 = this.start;
                        int margin2 = this.widget.mListAnchors[0].getMargin();
                        dependencyNode3.targets.add(target3);
                        dependencyNode3.margin = margin2;
                        target3.dependencies.add(dependencyNode3);
                    }
                    DependencyNode target4 = getTarget(this.widget.mListAnchors[1]);
                    if (target4 != null) {
                        DependencyNode dependencyNode4 = this.end;
                        dependencyNode4.targets.add(target4);
                        dependencyNode4.margin = -this.widget.mListAnchors[1].getMargin();
                        target4.dependencies.add(dependencyNode4);
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.dimensionBehavior == dimensionBehaviour) {
            ConstraintWidget constraintWidget8 = this.widget;
            int i = constraintWidget8.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget constraintWidget9 = constraintWidget8.mParent;
                if (constraintWidget9 != null) {
                    DimensionDependency dimensionDependency = constraintWidget9.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency);
                    dimensionDependency.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency2 = this.dimension;
                    dimensionDependency2.delegateToWidgetRun = true;
                    dimensionDependency2.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3) {
                if (constraintWidget8.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget8.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    this.dimension.updateDelegate = this;
                    if (constraintWidget8.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        this.dimension.targets.add(verticalWidgetRun2.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                    }
                } else {
                    DimensionDependency dimensionDependency3 = constraintWidget8.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency4 = this.dimension;
                    dimensionDependency4.delegateToWidgetRun = true;
                    dimensionDependency4.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    this.end.targets.add(this.dimension);
                }
            }
        }
        ConstraintWidget constraintWidget10 = this.widget;
        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget10.mListAnchors;
        if (constraintAnchorArr3[0].mTarget == null || constraintAnchorArr3[1].mTarget == null) {
            ConstraintWidget constraintWidget11 = this.widget;
            ConstraintAnchor[] constraintAnchorArr4 = constraintWidget11.mListAnchors;
            if (constraintAnchorArr4[0].mTarget != null) {
                DependencyNode target5 = getTarget(constraintAnchorArr4[0]);
                if (target5 != null) {
                    DependencyNode dependencyNode5 = this.start;
                    int margin3 = this.widget.mListAnchors[0].getMargin();
                    dependencyNode5.targets.add(target5);
                    dependencyNode5.margin = margin3;
                    target5.dependencies.add(dependencyNode5);
                    addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (constraintAnchorArr4[1].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr4[1]);
                if (target6 != null) {
                    DependencyNode dependencyNode6 = this.end;
                    dependencyNode6.targets.add(target6);
                    dependencyNode6.margin = -this.widget.mListAnchors[1].getMargin();
                    target6.dependencies.add(dependencyNode6);
                    addTarget(this.start, this.end, -1, this.dimension);
                }
            } else if (!(constraintWidget11 instanceof Helper) && (constraintWidget = constraintWidget11.mParent) != null) {
                addTarget(this.start, constraintWidget.horizontalRun.start, constraintWidget11.getX());
                addTarget(this.end, this.start, 1, this.dimension);
            }
        } else if (constraintWidget10.isInHorizontalChain()) {
            this.start.margin = this.widget.mListAnchors[0].getMargin();
            this.end.margin = -this.widget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.widget.mListAnchors[1]);
            target7.dependencies.add(this);
            if (target7.resolved) {
                update(this);
            }
            target8.dependencies.add(this);
            if (target8.resolved) {
                update(this);
            }
            this.mRunType = WidgetRun.RunType.CENTER;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mX = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public final void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("HorizontalRun ");
        outline17.append(this.widget.mDebugName);
        return outline17.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x029c, code lost:
        if (r15 != 1) goto L_0x02fb;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void update(Dependency dependency) {
        float f;
        DependencyNode dependencyNode;
        int i;
        float f2;
        float f3;
        float f4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        int ordinal = this.mRunType.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal != 3) {
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved && this.dimensionBehavior == dimensionBehaviour) {
                ConstraintWidget constraintWidget = this.widget;
                int i2 = constraintWidget.mMatchConstraintDefaultWidth;
                if (i2 == 2) {
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        DimensionDependency dimensionDependency2 = constraintWidget2.horizontalRun.dimension;
                        if (dimensionDependency2.resolved) {
                            dimensionDependency.resolve((int) ((((float) dimensionDependency2.value) * constraintWidget.mMatchConstraintPercentWidth) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    int i3 = constraintWidget.mMatchConstraintDefaultHeight;
                    if (i3 == 0 || i3 == 3) {
                        ConstraintWidget constraintWidget3 = this.widget;
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                        DependencyNode dependencyNode2 = verticalWidgetRun.start;
                        DependencyNode dependencyNode3 = verticalWidgetRun.end;
                        boolean z = constraintWidget3.mLeft.mTarget != null;
                        boolean z2 = this.widget.mTop.mTarget != null;
                        boolean z3 = this.widget.mRight.mTarget != null;
                        boolean z4 = this.widget.mBottom.mTarget != null;
                        ConstraintWidget constraintWidget4 = this.widget;
                        int i4 = constraintWidget4.mDimensionRatioSide;
                        if (z && z2 && z3 && z4) {
                            float f5 = constraintWidget4.mDimensionRatio;
                            if (!dependencyNode2.resolved || !dependencyNode3.resolved) {
                                DependencyNode dependencyNode4 = this.start;
                                if (dependencyNode4.resolved) {
                                    DependencyNode dependencyNode5 = this.end;
                                    if (dependencyNode5.resolved) {
                                        if (dependencyNode2.readyToSolve && dependencyNode3.readyToSolve) {
                                            f = f5;
                                            computeInsetRatio(tempDimensions, dependencyNode4.value + dependencyNode4.margin, dependencyNode5.value - dependencyNode5.margin, dependencyNode2.targets.get(0).value + dependencyNode2.margin, dependencyNode3.targets.get(0).value - dependencyNode3.margin, f5, i4);
                                            this.dimension.resolve(tempDimensions[0]);
                                            this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                            dependencyNode = this.start;
                                            if (dependencyNode.readyToSolve && this.end.readyToSolve && dependencyNode2.readyToSolve && dependencyNode3.readyToSolve) {
                                                computeInsetRatio(tempDimensions, dependencyNode.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode2.targets.get(0).value + dependencyNode2.margin, dependencyNode3.targets.get(0).value - dependencyNode3.margin, f, i4);
                                                this.dimension.resolve(tempDimensions[0]);
                                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                f = f5;
                                dependencyNode = this.start;
                                if (dependencyNode.readyToSolve) {
                                    return;
                                }
                                return;
                            }
                            DependencyNode dependencyNode6 = this.start;
                            if (dependencyNode6.readyToSolve && this.end.readyToSolve) {
                                computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode2.value + dependencyNode2.margin, dependencyNode3.value - dependencyNode3.margin, f5, i4);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                return;
                            }
                            return;
                        } else if (z && z3) {
                            DependencyNode dependencyNode7 = this.start;
                            if (dependencyNode7.readyToSolve && this.end.readyToSolve) {
                                float f6 = this.widget.mDimensionRatio;
                                int i5 = dependencyNode7.targets.get(0).value + this.start.margin;
                                int i6 = this.end.targets.get(0).value - this.end.margin;
                                if (i4 == -1 || i4 == 0) {
                                    int limitedDimension = getLimitedDimension(i6 - i5, 0);
                                    int i7 = (int) ((((float) limitedDimension) * f6) + 0.5f);
                                    int limitedDimension2 = getLimitedDimension(i7, 1);
                                    if (i7 != limitedDimension2) {
                                        limitedDimension = (int) ((((float) limitedDimension2) / f6) + 0.5f);
                                    }
                                    this.dimension.resolve(limitedDimension);
                                    this.widget.verticalRun.dimension.resolve(limitedDimension2);
                                } else if (i4 == 1) {
                                    int limitedDimension3 = getLimitedDimension(i6 - i5, 0);
                                    int i8 = (int) ((((float) limitedDimension3) / f6) + 0.5f);
                                    int limitedDimension4 = getLimitedDimension(i8, 1);
                                    if (i8 != limitedDimension4) {
                                        limitedDimension3 = (int) ((((float) limitedDimension4) * f6) + 0.5f);
                                    }
                                    this.dimension.resolve(limitedDimension3);
                                    this.widget.verticalRun.dimension.resolve(limitedDimension4);
                                }
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (dependencyNode2.readyToSolve && dependencyNode3.readyToSolve) {
                                float f7 = this.widget.mDimensionRatio;
                                int i9 = dependencyNode2.targets.get(0).value + dependencyNode2.margin;
                                int i10 = dependencyNode3.targets.get(0).value - dependencyNode3.margin;
                                if (i4 != -1) {
                                    if (i4 == 0) {
                                        int limitedDimension5 = getLimitedDimension(i10 - i9, 1);
                                        int i11 = (int) ((((float) limitedDimension5) * f7) + 0.5f);
                                        int limitedDimension6 = getLimitedDimension(i11, 0);
                                        if (i11 != limitedDimension6) {
                                            limitedDimension5 = (int) ((((float) limitedDimension6) / f7) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension6);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension5);
                                    }
                                }
                                int limitedDimension7 = getLimitedDimension(i10 - i9, 1);
                                int i12 = (int) ((((float) limitedDimension7) / f7) + 0.5f);
                                int limitedDimension8 = getLimitedDimension(i12, 0);
                                if (i12 != limitedDimension8) {
                                    limitedDimension7 = (int) ((((float) limitedDimension8) * f7) + 0.5f);
                                }
                                this.dimension.resolve(limitedDimension8);
                                this.widget.verticalRun.dimension.resolve(limitedDimension7);
                            } else {
                                return;
                            }
                        }
                    } else {
                        int i13 = constraintWidget.mDimensionRatioSide;
                        if (i13 == -1) {
                            f4 = (float) constraintWidget.verticalRun.dimension.value;
                            f3 = constraintWidget.mDimensionRatio;
                        } else if (i13 == 0) {
                            f2 = ((float) constraintWidget.verticalRun.dimension.value) / constraintWidget.mDimensionRatio;
                            i = (int) (f2 + 0.5f);
                            this.dimension.resolve(i);
                        } else if (i13 != 1) {
                            i = 0;
                            this.dimension.resolve(i);
                        } else {
                            f4 = (float) constraintWidget.verticalRun.dimension.value;
                            f3 = constraintWidget.mDimensionRatio;
                        }
                        f2 = f4 * f3;
                        i = (int) (f2 + 0.5f);
                        this.dimension.resolve(i);
                    }
                }
            }
            DependencyNode dependencyNode8 = this.start;
            if (dependencyNode8.readyToSolve) {
                DependencyNode dependencyNode9 = this.end;
                if (dependencyNode9.readyToSolve) {
                    if (!dependencyNode8.resolved || !dependencyNode9.resolved || !this.dimension.resolved) {
                        if (!this.dimension.resolved && this.dimensionBehavior == dimensionBehaviour) {
                            ConstraintWidget constraintWidget5 = this.widget;
                            if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInHorizontalChain()) {
                                int i14 = this.start.targets.get(0).value;
                                DependencyNode dependencyNode10 = this.start;
                                int i15 = i14 + dependencyNode10.margin;
                                int i16 = this.end.targets.get(0).value + this.end.margin;
                                dependencyNode10.resolve(i15);
                                this.end.resolve(i16);
                                this.dimension.resolve(i16 - i15);
                                return;
                            }
                        }
                        if (!this.dimension.resolved && this.dimensionBehavior == dimensionBehaviour && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                            int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                            ConstraintWidget constraintWidget6 = this.widget;
                            int i17 = constraintWidget6.mMatchConstraintMaxWidth;
                            int max = Math.max(constraintWidget6.mMatchConstraintMinWidth, min);
                            if (i17 > 0) {
                                max = Math.min(i17, max);
                            }
                            this.dimension.resolve(max);
                        }
                        if (this.dimension.resolved) {
                            DependencyNode dependencyNode11 = this.start.targets.get(0);
                            DependencyNode dependencyNode12 = this.end.targets.get(0);
                            int i18 = dependencyNode11.value;
                            int i19 = this.start.margin + i18;
                            int i20 = dependencyNode12.value;
                            int i21 = this.end.margin + i20;
                            float f8 = this.widget.mHorizontalBiasPercent;
                            if (dependencyNode11 == dependencyNode12) {
                                f8 = 0.5f;
                            } else {
                                i18 = i19;
                                i20 = i21;
                            }
                            this.start.resolve((int) ((((float) ((i20 - i18) - this.dimension.value)) * f8) + ((float) i18) + 0.5f));
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
        ConstraintWidget constraintWidget7 = this.widget;
        updateRunCenter(constraintWidget7.mLeft, constraintWidget7.mRight, 0);
    }
}
