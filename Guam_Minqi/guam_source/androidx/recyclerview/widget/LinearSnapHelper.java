package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.BaseViewManager;

public class LinearSnapHelper extends SnapHelper {
    public OrientationHelper mHorizontalHelper;
    public OrientationHelper mVerticalHelper;

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    public final int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int max;
        this.mGravityScroller.fling(0, 0, i, i2, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        int[] iArr = {this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
        int childCount = layoutManager.getChildCount();
        float f = 1.0f;
        if (childCount != 0) {
            View view = null;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = layoutManager.getChildAt(i5);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i4) {
                        view = childAt;
                        i4 = position;
                    }
                    if (position > i3) {
                        view2 = childAt;
                        i3 = position;
                    }
                }
            }
            if (!(view == null || view2 == null || (max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2))) == 0)) {
                f = (((float) max) * 1.0f) / ((float) ((i3 - i4) + 1));
            }
        }
        if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            return 0;
        }
        return Math.round(((float) (Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1])) / f);
    }

    public final View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: IPUT  
                  (wrap: androidx.recyclerview.widget.OrientationHelper$1 : 0x000a: CONSTRUCTOR  (r0v1 androidx.recyclerview.widget.OrientationHelper$1) = (r2v0 'layoutManager' androidx.recyclerview.widget.RecyclerView$LayoutManager) call: androidx.recyclerview.widget.OrientationHelper.1.<init>(androidx.recyclerview.widget.RecyclerView$LayoutManager):void type: CONSTRUCTOR)
                  (r1v0 'this' androidx.recyclerview.widget.LinearSnapHelper A[IMMUTABLE_TYPE, THIS])
                 androidx.recyclerview.widget.LinearSnapHelper.mHorizontalHelper androidx.recyclerview.widget.OrientationHelper in method: androidx.recyclerview.widget.LinearSnapHelper.getHorizontalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v1 androidx.recyclerview.widget.OrientationHelper$1) = (r2v0 'layoutManager' androidx.recyclerview.widget.RecyclerView$LayoutManager) call: androidx.recyclerview.widget.OrientationHelper.1.<init>(androidx.recyclerview.widget.RecyclerView$LayoutManager):void type: CONSTRUCTOR in method: androidx.recyclerview.widget.LinearSnapHelper.getHorizontalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.recyclerview.widget.OrientationHelper, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 23 more
                */
            /*
                this = this;
                androidx.recyclerview.widget.OrientationHelper r0 = r1.mHorizontalHelper
                if (r0 == 0) goto L_0x0008
                androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.mLayoutManager
                if (r0 == r2) goto L_0x000f
            L_0x0008:
                androidx.recyclerview.widget.OrientationHelper$1 r0 = new androidx.recyclerview.widget.OrientationHelper$1
                r0.<init>(r2)
                r1.mHorizontalHelper = r0
            L_0x000f:
                androidx.recyclerview.widget.OrientationHelper r2 = r1.mHorizontalHelper
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearSnapHelper.getHorizontalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper");
        }

        public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
            OrientationHelper orientationHelper = this.mVerticalHelper;
            if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
                this.mVerticalHelper = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: IPUT  
                      (wrap: androidx.recyclerview.widget.OrientationHelper$2 : 0x000a: CONSTRUCTOR  (r0v1 androidx.recyclerview.widget.OrientationHelper$2) = (r2v0 'layoutManager' androidx.recyclerview.widget.RecyclerView$LayoutManager) call: androidx.recyclerview.widget.OrientationHelper.2.<init>(androidx.recyclerview.widget.RecyclerView$LayoutManager):void type: CONSTRUCTOR)
                      (r1v0 'this' androidx.recyclerview.widget.LinearSnapHelper A[IMMUTABLE_TYPE, THIS])
                     androidx.recyclerview.widget.LinearSnapHelper.mVerticalHelper androidx.recyclerview.widget.OrientationHelper in method: androidx.recyclerview.widget.LinearSnapHelper.getVerticalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v1 androidx.recyclerview.widget.OrientationHelper$2) = (r2v0 'layoutManager' androidx.recyclerview.widget.RecyclerView$LayoutManager) call: androidx.recyclerview.widget.OrientationHelper.2.<init>(androidx.recyclerview.widget.RecyclerView$LayoutManager):void type: CONSTRUCTOR in method: androidx.recyclerview.widget.LinearSnapHelper.getVerticalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.recyclerview.widget.OrientationHelper, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 23 more
                    */
                /*
                    this = this;
                    androidx.recyclerview.widget.OrientationHelper r0 = r1.mVerticalHelper
                    if (r0 == 0) goto L_0x0008
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.mLayoutManager
                    if (r0 == r2) goto L_0x000f
                L_0x0008:
                    androidx.recyclerview.widget.OrientationHelper$2 r0 = new androidx.recyclerview.widget.OrientationHelper$2
                    r0.<init>(r2)
                    r1.mVerticalHelper = r0
                L_0x000f:
                    androidx.recyclerview.widget.OrientationHelper r2 = r1.mVerticalHelper
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearSnapHelper.getVerticalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper");
            }
        }
