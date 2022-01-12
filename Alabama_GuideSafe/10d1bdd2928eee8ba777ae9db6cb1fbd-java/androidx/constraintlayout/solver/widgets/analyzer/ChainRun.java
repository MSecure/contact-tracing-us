package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    public int chainStyle;
    public ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        WidgetRun widgetRun;
        int i2;
        WidgetRun widgetRun2;
        this.orientation = i;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(i);
        while (true) {
            constraintWidget2 = previousChainMember;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget2;
        ArrayList<WidgetRun> arrayList = this.widgets;
        int i3 = this.orientation;
        if (i3 == 0) {
            widgetRun = constraintWidget2.horizontalRun;
        } else {
            widgetRun = i3 == 1 ? constraintWidget2.verticalRun : null;
        }
        arrayList.add(widgetRun);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            ArrayList<WidgetRun> arrayList2 = this.widgets;
            int i4 = this.orientation;
            if (i4 == 0) {
                widgetRun2 = nextChainMember.horizontalRun;
            } else {
                widgetRun2 = i4 == 1 ? nextChainMember.verticalRun : null;
            }
            arrayList2.add(widgetRun2);
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i5 = this.orientation;
            if (i5 == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i5 == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.mParent).mIsRtl) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList3 = this.widgets;
            this.widget = arrayList3.get(arrayList3.size() - 1).widget;
        }
        if (this.orientation == 0) {
            i2 = this.widget.mHorizontalChainStyle;
        } else {
            i2 = this.widget.mVerticalChainStyle;
        }
        this.chainStyle = i2;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    DependencyNode dependencyNode = this.start;
                    dependencyNode.targets.add(target);
                    dependencyNode.margin = margin;
                    target.dependencies.add(dependencyNode);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    DependencyNode dependencyNode2 = this.end;
                    dependencyNode2.targets.add(target2);
                    dependencyNode2.margin = -margin2;
                    target2.dependencies.add(dependencyNode2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    DependencyNode dependencyNode3 = this.start;
                    dependencyNode3.targets.add(target3);
                    dependencyNode3.margin = margin3;
                    target3.dependencies.add(dependencyNode3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    DependencyNode dependencyNode4 = this.end;
                    dependencyNode4.targets.add(target4);
                    dependencyNode4.margin = -margin4;
                    target4.dependencies.add(dependencyNode4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public final ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            ConstraintWidget constraintWidget = this.widgets.get(i).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public final ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = this.widgets.get(size).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            j = ((long) widgetRun.end.margin) + widgetRun.getWrapDimension() + j + ((long) widgetRun.start.margin);
        }
        return j;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("ChainRun ");
        outline17.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String sb = outline17.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            String outline10 = GeneratedOutlineSupport.outline10(sb, "<");
            sb = GeneratedOutlineSupport.outline10(outline10 + it.next(), "> ");
        }
        return sb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0192, code lost:
        if (r1 != r14) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01b8, code lost:
        if (r1 != r14) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c6, code lost:
        if (r3.dimension.resolved != false) goto L_0x00c8;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        float f3;
        int i10;
        int i11;
        int i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget constraintWidget = this.widget.mParent;
            boolean z = (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) constraintWidget).mIsRtl;
            int i13 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i14 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i14 >= size) {
                    i14 = -1;
                    break;
                }
                if (this.widgets.get(i14).widget.mVisibility != 8) {
                    break;
                }
                i14++;
            }
            int i15 = size - 1;
            int i16 = i15;
            while (true) {
                if (i16 < 0) {
                    break;
                }
                if (this.widgets.get(i16).widget.mVisibility != 8) {
                    i = i16;
                    break;
                }
                i16--;
            }
            int i17 = 0;
            while (true) {
                if (i17 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                    break;
                }
                int i18 = 0;
                i5 = 0;
                i11 = 0;
                i12 = 0;
                f = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                while (i18 < size) {
                    WidgetRun widgetRun = this.widgets.get(i18);
                    if (widgetRun.widget.mVisibility != i2) {
                        i12++;
                        if (i18 > 0 && i18 >= i14) {
                            i5 += widgetRun.start.margin;
                        }
                        int i19 = widgetRun.dimension.value;
                        boolean z2 = widgetRun.dimensionBehavior != dimensionBehaviour4;
                        if (!z2) {
                            if (widgetRun.matchConstraintsType == 1 && i17 == 0) {
                                i19 = widgetRun.dimension.wrapValue;
                                i11++;
                            }
                            z2 = true;
                        } else if (this.orientation != 0 || widgetRun.widget.horizontalRun.dimension.resolved) {
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            return;
                        }
                        if (!z2) {
                            i11++;
                            float f4 = widgetRun.widget.mWeight[this.orientation];
                            if (f4 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                                f += f4;
                            }
                        } else {
                            i5 += i19;
                        }
                        if (i18 < i15 && i18 < i) {
                            i5 += -widgetRun.end.margin;
                        }
                    }
                    i18++;
                    i2 = 8;
                }
                if (i5 < i13 || i11 == 0) {
                    i3 = i11;
                    i4 = i12;
                } else {
                    i17++;
                    i2 = 8;
                }
            }
            i3 = i11;
            i4 = i12;
            int i20 = this.start.value;
            if (z) {
                i20 = this.end.value;
            }
            if (i5 > i13) {
                i20 = z ? i20 + ((int) ((((float) (i5 - i13)) / 2.0f) + 0.5f)) : i20 - ((int) ((((float) (i5 - i13)) / 2.0f) + 0.5f));
            }
            if (i3 > 0) {
                float f5 = (float) (i13 - i5);
                int i21 = (int) ((f5 / ((float) i3)) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i22);
                    ConstraintWidget constraintWidget2 = widgetRun2.widget;
                    if (constraintWidget2.mVisibility != 8 && widgetRun2.dimensionBehavior == dimensionBehaviour4 && !widgetRun2.dimension.resolved) {
                        int i24 = f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? (int) (((constraintWidget2.mWeight[this.orientation] * f5) / f) + 0.5f) : i21;
                        if (this.orientation == 0) {
                            ConstraintWidget constraintWidget3 = widgetRun2.widget;
                            int i25 = constraintWidget3.mMatchConstraintMaxWidth;
                            f3 = f5;
                            dimensionBehaviour3 = dimensionBehaviour4;
                            i10 = Math.max(constraintWidget3.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i25 > 0) {
                                i10 = Math.min(i25, i10);
                            }
                        } else {
                            dimensionBehaviour3 = dimensionBehaviour4;
                            f3 = f5;
                            ConstraintWidget constraintWidget4 = widgetRun2.widget;
                            int i26 = constraintWidget4.mMatchConstraintMaxHeight;
                            i10 = Math.max(constraintWidget4.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i24, widgetRun2.dimension.wrapValue) : i24);
                            if (i26 > 0) {
                                i10 = Math.min(i26, i10);
                            }
                        }
                        i23++;
                        i24 = i10;
                        widgetRun2.dimension.resolve(i24);
                    } else {
                        dimensionBehaviour3 = dimensionBehaviour4;
                        f3 = f5;
                    }
                    i22++;
                    i21 = i21;
                    i5 = i5;
                    i20 = i20;
                    f5 = f3;
                    dimensionBehaviour4 = dimensionBehaviour3;
                }
                dimensionBehaviour = dimensionBehaviour4;
                i6 = i20;
                if (i23 > 0) {
                    i3 -= i23;
                    int i27 = 0;
                    for (int i28 = 0; i28 < size; i28++) {
                        WidgetRun widgetRun3 = this.widgets.get(i28);
                        if (widgetRun3.widget.mVisibility != 8) {
                            if (i28 > 0 && i28 >= i14) {
                                i27 += widgetRun3.start.margin;
                            }
                            i27 += widgetRun3.dimension.value;
                            if (i28 < i15 && i28 < i) {
                                i27 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i5 = i27;
                } else {
                    i5 = i5;
                }
                i7 = 2;
                if (this.chainStyle == 2 && i23 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                dimensionBehaviour = dimensionBehaviour4;
                i6 = i20;
                i8 = 0;
                i7 = 2;
            }
            if (i5 > i13) {
                this.chainStyle = i7;
            }
            if (i4 > 0 && i3 == 0 && i14 == i) {
                this.chainStyle = i7;
            }
            int i29 = this.chainStyle;
            if (i29 == 1) {
                if (i4 > 1) {
                    i9 = (i13 - i5) / (i4 - 1);
                } else {
                    i9 = i4 == 1 ? (i13 - i5) / 2 : i8;
                }
                if (i3 > 0) {
                    i9 = i8;
                }
                int i30 = i8;
                int i31 = i6;
                while (i30 < size) {
                    WidgetRun widgetRun4 = this.widgets.get(z ? size - (i30 + 1) : i30);
                    if (widgetRun4.widget.mVisibility == 8) {
                        widgetRun4.start.resolve(i31);
                        widgetRun4.end.resolve(i31);
                        dimensionBehaviour2 = dimensionBehaviour;
                    } else {
                        if (i30 > 0) {
                            i31 = z ? i31 - i9 : i31 + i9;
                        }
                        if (i30 > 0 && i30 >= i14) {
                            if (z) {
                                i31 -= widgetRun4.start.margin;
                            } else {
                                i31 += widgetRun4.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun4.end.resolve(i31);
                        } else {
                            widgetRun4.start.resolve(i31);
                        }
                        DimensionDependency dimensionDependency = widgetRun4.dimension;
                        int i32 = dimensionDependency.value;
                        dimensionBehaviour2 = dimensionBehaviour;
                        if (widgetRun4.dimensionBehavior == dimensionBehaviour2 && widgetRun4.matchConstraintsType == 1) {
                            i32 = dimensionDependency.wrapValue;
                        }
                        i31 = z ? i31 - i32 : i31 + i32;
                        if (z) {
                            widgetRun4.start.resolve(i31);
                        } else {
                            widgetRun4.end.resolve(i31);
                        }
                        widgetRun4.resolved = true;
                        if (i30 < i15 && i30 < i) {
                            i31 = z ? i31 - (-widgetRun4.end.margin) : i31 + (-widgetRun4.end.margin);
                        }
                    }
                    i30++;
                    dimensionBehaviour = dimensionBehaviour2;
                }
            } else if (i29 == 0) {
                int i33 = (i13 - i5) / (i4 + 1);
                if (i3 > 0) {
                    i33 = i8;
                }
                int i34 = i6;
                for (int i35 = i8; i35 < size; i35++) {
                    WidgetRun widgetRun5 = this.widgets.get(z ? size - (i35 + 1) : i35);
                    if (widgetRun5.widget.mVisibility == 8) {
                        widgetRun5.start.resolve(i34);
                        widgetRun5.end.resolve(i34);
                    } else {
                        int i36 = z ? i34 - i33 : i34 + i33;
                        if (i35 > 0 && i35 >= i14) {
                            i36 = z ? i36 - widgetRun5.start.margin : i36 + widgetRun5.start.margin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i36);
                        } else {
                            widgetRun5.start.resolve(i36);
                        }
                        DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                        int i37 = dimensionDependency2.value;
                        if (widgetRun5.dimensionBehavior == dimensionBehaviour && widgetRun5.matchConstraintsType == 1) {
                            i37 = Math.min(i37, dimensionDependency2.wrapValue);
                        }
                        i34 = z ? i36 - i37 : i36 + i37;
                        if (z) {
                            widgetRun5.start.resolve(i34);
                        } else {
                            widgetRun5.end.resolve(i34);
                        }
                        if (i35 < i15 && i35 < i) {
                            i34 = z ? i34 - (-widgetRun5.end.margin) : i34 + (-widgetRun5.end.margin);
                        }
                    }
                }
            } else if (i29 == 2) {
                if (this.orientation == 0) {
                    f2 = this.widget.mHorizontalBiasPercent;
                } else {
                    f2 = this.widget.mVerticalBiasPercent;
                }
                if (z) {
                    f2 = 1.0f - f2;
                }
                int i38 = (int) ((((float) (i13 - i5)) * f2) + 0.5f);
                if (i38 < 0 || i3 > 0) {
                    i38 = i8;
                }
                int i39 = z ? i6 - i38 : i6 + i38;
                for (int i40 = i8; i40 < size; i40++) {
                    WidgetRun widgetRun6 = this.widgets.get(z ? size - (i40 + 1) : i40);
                    if (widgetRun6.widget.mVisibility == 8) {
                        widgetRun6.start.resolve(i39);
                        widgetRun6.end.resolve(i39);
                    } else {
                        if (i40 > 0 && i40 >= i14) {
                            if (z) {
                                i39 -= widgetRun6.start.margin;
                            } else {
                                i39 += widgetRun6.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun6.end.resolve(i39);
                        } else {
                            widgetRun6.start.resolve(i39);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                        int i41 = dimensionDependency3.value;
                        if (widgetRun6.dimensionBehavior == dimensionBehaviour) {
                            if (widgetRun6.matchConstraintsType == 1) {
                                i41 = dimensionDependency3.wrapValue;
                            }
                        }
                        i39 = z ? i39 - i41 : i39 + i41;
                        if (z) {
                            widgetRun6.start.resolve(i39);
                        } else {
                            widgetRun6.end.resolve(i39);
                        }
                        if (i40 < i15 && i40 < i) {
                            i39 = z ? i39 - (-widgetRun6.end.margin) : i39 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }
}
