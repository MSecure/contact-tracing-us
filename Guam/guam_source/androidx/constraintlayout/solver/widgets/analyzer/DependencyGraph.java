package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    public ConstraintWidgetContainer container;
    public ConstraintWidgetContainer mContainer;
    public ArrayList<RunGroup> mGroups;
    public BasicMeasure.Measure mMeasure;
    public BasicMeasure.Measurer mMeasurer;
    public boolean mNeedBuildGraph = true;
    public boolean mNeedRedoMeasures = true;
    public ArrayList<WidgetRun> mRuns = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList<>();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    public final void applyGroup(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (!(widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun)) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i2);
                    arrayList.add(runGroup);
                }
                widgetRun.runGroup = runGroup;
                runGroup.runs.add(widgetRun);
                for (Dependency dependency : widgetRun.start.dependencies) {
                    if (dependency instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup);
                    }
                }
                for (Dependency dependency2 : widgetRun.end.dependencies) {
                    if (dependency2 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup);
                    }
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                        if (dependency3 instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
                for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                    applyGroup(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup);
                }
                for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                    applyGroup(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup);
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).baseline.targets) {
                        applyGroup(dependencyNode5, i, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    public final boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        int i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[1];
            if (next.mVisibility == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour6 == dimensionBehaviour3) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour7 == dimensionBehaviour3) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.mDimensionRatio > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    if (dimensionBehaviour6 == dimensionBehaviour3 && (dimensionBehaviour7 == dimensionBehaviour4 || dimensionBehaviour7 == dimensionBehaviour5)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour3 && (dimensionBehaviour6 == dimensionBehaviour4 || dimensionBehaviour6 == dimensionBehaviour5)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour3 && dimensionBehaviour7 == dimensionBehaviour3) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                if (dimensionBehaviour6 == dimensionBehaviour3 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour6 = dimensionBehaviour4;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = (dimensionBehaviour7 == dimensionBehaviour3 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) ? dimensionBehaviour4 : dimensionBehaviour7;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour6;
                horizontalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultWidth;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour8;
                verticalWidgetRun.matchConstraintsType = next.mMatchConstraintDefaultHeight;
                if ((dimensionBehaviour6 == dimensionBehaviour2 || dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == dimensionBehaviour4) && (dimensionBehaviour8 == dimensionBehaviour2 || dimensionBehaviour8 == dimensionBehaviour5 || dimensionBehaviour8 == dimensionBehaviour4)) {
                    int width = next.getWidth();
                    if (dimensionBehaviour6 == dimensionBehaviour2) {
                        width = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour6 = dimensionBehaviour5;
                    }
                    int height = next.getHeight();
                    if (dimensionBehaviour8 == dimensionBehaviour2) {
                        i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour = dimensionBehaviour5;
                    } else {
                        i2 = height;
                        dimensionBehaviour = dimensionBehaviour8;
                    }
                    measure(next, dimensionBehaviour6, width, dimensionBehaviour, i2);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour6 == dimensionBehaviour3 && (dimensionBehaviour8 == dimensionBehaviour4 || dimensionBehaviour8 == dimensionBehaviour5)) {
                        int i3 = next.mMatchConstraintDefaultWidth;
                        if (i3 == 3) {
                            if (dimensionBehaviour8 == dimensionBehaviour4) {
                                measure(next, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int height2 = next.getHeight();
                            measure(next, dimensionBehaviour5, (int) ((((float) height2) * next.mDimensionRatio) + 0.5f), dimensionBehaviour5, height2);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            measure(next, dimensionBehaviour4, 0, dimensionBehaviour8, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else if (i3 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr2[0] == dimensionBehaviour5 || dimensionBehaviourArr2[0] == dimensionBehaviour2) {
                                measure(next, dimensionBehaviour5, (int) ((next.mMatchConstraintPercentWidth * ((float) constraintWidgetContainer.getWidth())) + 0.5f), dimensionBehaviour8, next.getHeight());
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, dimensionBehaviour4, 0, dimensionBehaviour8, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour8 == dimensionBehaviour3 && (dimensionBehaviour6 == dimensionBehaviour4 || dimensionBehaviour6 == dimensionBehaviour5)) {
                        int i4 = next.mMatchConstraintDefaultHeight;
                        if (i4 == 3) {
                            if (dimensionBehaviour6 == dimensionBehaviour4) {
                                measure(next, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int width2 = next.getWidth();
                            float f = next.mDimensionRatio;
                            if (next.mDimensionRatioSide == -1) {
                                f = 1.0f / f;
                            }
                            measure(next, dimensionBehaviour5, width2, dimensionBehaviour5, (int) ((((float) width2) * f) + 0.5f));
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i4 == 1) {
                            measure(next, dimensionBehaviour6, 0, dimensionBehaviour4, 0);
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i4 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr3[1] == dimensionBehaviour5 || dimensionBehaviourArr3[1] == dimensionBehaviour2) {
                                measure(next, dimensionBehaviour6, next.getWidth(), dimensionBehaviour5, (int) ((next.mMatchConstraintPercentHeight * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(next, dimensionBehaviour4, 0, dimensionBehaviour8, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour6 == dimensionBehaviour3 && dimensionBehaviour8 == dimensionBehaviour3) {
                        int i5 = next.mMatchConstraintDefaultWidth;
                        if (i5 == 1 || (i = next.mMatchConstraintDefaultHeight) == 1) {
                            measure(next, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i == 2 && i5 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                            if (dimensionBehaviourArr4[0] == dimensionBehaviour5 || dimensionBehaviourArr4[0] == dimensionBehaviour5) {
                                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr5 = constraintWidgetContainer.mListDimensionBehaviors;
                                if (dimensionBehaviourArr5[1] == dimensionBehaviour5 || dimensionBehaviourArr5[1] == dimensionBehaviour5) {
                                    measure(next, dimensionBehaviour5, (int) ((next.mMatchConstraintPercentWidth * ((float) constraintWidgetContainer.getWidth())) + 0.5f), dimensionBehaviour5, (int) ((next.mMatchConstraintPercentHeight * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void buildGraph() {
        ArrayList<WidgetRun> arrayList = this.mRuns;
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public final int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        float f;
        DependencyGraph dependencyGraph = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int size = dependencyGraph.mGroups.size();
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        while (i2 < size) {
            RunGroup runGroup = dependencyGraph.mGroups.get(i2);
            WidgetRun widgetRun = runGroup.firstRun;
            if (widgetRun instanceof ChainRun) {
                if (((ChainRun) widgetRun).orientation != i) {
                    continue;
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (i == 0) {
                if (!(widgetRun instanceof HorizontalWidgetRun)) {
                    continue;
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (!(widgetRun instanceof VerticalWidgetRun)) {
                continue;
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            }
            DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).start;
            DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).end;
            boolean contains = runGroup.firstRun.start.targets.contains(dependencyNode);
            boolean contains2 = runGroup.firstRun.end.targets.contains(dependencyNode2);
            long wrapDimension = runGroup.firstRun.getWrapDimension();
            if (!contains || !contains2) {
                if (contains) {
                    DependencyNode dependencyNode3 = runGroup.firstRun.start;
                    j2 = Math.max(runGroup.traverseStart(dependencyNode3, (long) dependencyNode3.margin), ((long) runGroup.firstRun.start.margin) + wrapDimension);
                } else if (contains2) {
                    DependencyNode dependencyNode4 = runGroup.firstRun.end;
                    j2 = Math.max(-runGroup.traverseEnd(dependencyNode4, (long) dependencyNode4.margin), ((long) (-runGroup.firstRun.end.margin)) + wrapDimension);
                } else {
                    WidgetRun widgetRun2 = runGroup.firstRun;
                    j2 = (widgetRun2.getWrapDimension() + ((long) widgetRun2.start.margin)) - ((long) runGroup.firstRun.end.margin);
                }
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            } else {
                long traverseStart = runGroup.traverseStart(runGroup.firstRun.start, j2);
                long traverseEnd = runGroup.traverseEnd(runGroup.firstRun.end, j2);
                long j3 = traverseStart - wrapDimension;
                int i3 = runGroup.firstRun.end.margin;
                if (j3 >= ((long) (-i3))) {
                    j3 += (long) i3;
                }
                long j4 = (long) runGroup.firstRun.start.margin;
                long j5 = ((-traverseEnd) - wrapDimension) - j4;
                if (j5 >= j4) {
                    j5 -= j4;
                }
                ConstraintWidget constraintWidget = runGroup.firstRun.widget;
                if (constraintWidget != null) {
                    if (i == 0) {
                        f = constraintWidget.mHorizontalBiasPercent;
                    } else {
                        f = i == 1 ? constraintWidget.mVerticalBiasPercent : -1.0f;
                    }
                    float f2 = (float) (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER ? (long) ((((float) j3) / (1.0f - f)) + (((float) j5) / f)) : 0);
                    long outline0 = ((long) ((f2 * f) + 0.5f)) + wrapDimension + ((long) GeneratedOutlineSupport.outline0(1.0f, f, f2, 0.5f));
                    WidgetRun widgetRun3 = runGroup.firstRun;
                    j2 = (((long) widgetRun3.start.margin) + outline0) - ((long) widgetRun3.end.margin);
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                } else {
                    throw null;
                }
            }
        }
        return (int) j;
    }

    public final void findGroup(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        ((ConstraintLayout.Measurer) this.mMeasurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        BasicMeasure.Measure measure2 = this.mMeasure;
        constraintWidget.hasBaseline = measure2.measuredHasBaseline;
        int i3 = measure2.measuredBaseline;
        constraintWidget.mBaselineDistance = i3;
        constraintWidget.hasBaseline = i3 > 0;
    }

    public void measureWidgets() {
        DimensionDependency dimensionDependency;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                boolean z2 = dimensionBehaviour4 == dimensionBehaviour3 || (dimensionBehaviour4 == dimensionBehaviour2 && i == 1);
                if (dimensionBehaviour5 == dimensionBehaviour3 || (dimensionBehaviour5 == dimensionBehaviour2 && i2 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                boolean z3 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                boolean z4 = dimensionDependency3.resolved;
                if (z3 && z4) {
                    measure(next, dimensionBehaviour, dimensionDependency2.value, dimensionBehaviour, dimensionDependency3.value);
                    next.measured = true;
                } else if (z3 && z) {
                    measure(next, dimensionBehaviour, next.horizontalRun.dimension.value, dimensionBehaviour3, next.verticalRun.dimension.value);
                    if (dimensionBehaviour5 == dimensionBehaviour2) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z2) {
                    measure(next, dimensionBehaviour3, next.horizontalRun.dimension.value, dimensionBehaviour, next.verticalRun.dimension.value);
                    if (dimensionBehaviour4 == dimensionBehaviour2) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(next.mBaselineDistance);
                }
            }
        }
    }
}
