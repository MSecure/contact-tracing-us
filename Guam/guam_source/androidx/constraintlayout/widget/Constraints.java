package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.react.uimanager.BaseViewManager;

public class Constraints extends ViewGroup {
    public ConstraintSet myConstraintSet;

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new ConstraintSet();
        }
        ConstraintSet constraintSet = this.myConstraintSet;
        if (constraintSet != null) {
            int childCount = getChildCount();
            constraintSet.mConstraints.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (!constraintSet.mForceId || id != -1) {
                    if (!constraintSet.mConstraints.containsKey(Integer.valueOf(id))) {
                        constraintSet.mConstraints.put(Integer.valueOf(id), new ConstraintSet.Constraint());
                    }
                    ConstraintSet.Constraint constraint = constraintSet.mConstraints.get(Integer.valueOf(id));
                    if (childAt instanceof ConstraintHelper) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                        constraint.fillFromConstraints(id, layoutParams);
                        if (constraintHelper instanceof Barrier) {
                            ConstraintSet.Layout layout = constraint.layout;
                            layout.mHelperType = 1;
                            Barrier barrier = (Barrier) constraintHelper;
                            layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mReferenceIds = barrier.getReferencedIds();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.fillFromConstraints(id, layoutParams);
                } else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }
            return this.myConstraintSet;
        }
        throw null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotation = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotationX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotationY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.transformPivotY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationZ = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotation = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotationX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.rotationY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.transformPivotY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            this.translationZ = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintSet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R$styleable.ConstraintSet_android_elevation) {
                    this.elevation = obtainStyledAttributes.getFloat(index, this.elevation);
                    this.applyElevation = true;
                } else if (index == R$styleable.ConstraintSet_android_rotationX) {
                    this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                } else if (index == R$styleable.ConstraintSet_android_rotationY) {
                    this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                } else if (index == R$styleable.ConstraintSet_android_rotation) {
                    this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == R$styleable.ConstraintSet_android_scaleX) {
                    this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == R$styleable.ConstraintSet_android_scaleY) {
                    this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotX) {
                    this.transformPivotX = obtainStyledAttributes.getFloat(index, this.transformPivotX);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotY) {
                    this.transformPivotY = obtainStyledAttributes.getFloat(index, this.transformPivotY);
                } else if (index == R$styleable.ConstraintSet_android_translationX) {
                    this.translationX = obtainStyledAttributes.getFloat(index, this.translationX);
                } else if (index == R$styleable.ConstraintSet_android_translationY) {
                    this.translationY = obtainStyledAttributes.getFloat(index, this.translationY);
                } else if (index == R$styleable.ConstraintSet_android_translationZ) {
                    this.translationZ = obtainStyledAttributes.getFloat(index, this.translationZ);
                }
            }
        }
    }
}
