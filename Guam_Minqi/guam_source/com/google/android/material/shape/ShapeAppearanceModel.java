package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$styleable;

public class ShapeAppearanceModel {
    public EdgeTreatment bottomEdge;
    public CornerTreatment bottomLeftCorner;
    public CornerSize bottomLeftCornerSize;
    public CornerTreatment bottomRightCorner;
    public CornerSize bottomRightCornerSize;
    public EdgeTreatment leftEdge;
    public EdgeTreatment rightEdge;
    public EdgeTreatment topEdge;
    public CornerTreatment topLeftCorner;
    public CornerSize topLeftCornerSize;
    public CornerTreatment topRightCorner;
    public CornerSize topRightCornerSize;

    public ShapeAppearanceModel(Builder builder, AnonymousClass1 r2) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize((float) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, absoluteCornerSize);
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cornerSize;
        }
        int i2 = peekValue.type;
        if (i2 == 5) {
            return new AbsoluteCornerSize((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    public boolean isRoundRect(RectF rectF) {
        boolean z = this.leftEdge.getClass().equals(EdgeTreatment.class) && this.rightEdge.getClass().equals(EdgeTreatment.class) && this.topEdge.getClass().equals(EdgeTreatment.class) && this.bottomEdge.getClass().equals(EdgeTreatment.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment));
    }

    public ShapeAppearanceModel withCornerSize(float f) {
        Builder builder = new Builder(this);
        builder.topLeftCornerSize = new AbsoluteCornerSize(f);
        builder.topRightCornerSize = new AbsoluteCornerSize(f);
        builder.bottomRightCornerSize = new AbsoluteCornerSize(f);
        builder.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        return builder.build();
    }

    public static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            CornerSize cornerSize6 = getCornerSize(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2);
            Builder builder = new Builder();
            CornerTreatment createCornerTreatment = ReactYogaConfigProvider.createCornerTreatment(i4);
            builder.topLeftCorner = createCornerTreatment;
            float compatCornerTreatmentSize = Builder.compatCornerTreatmentSize(createCornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                builder.setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            builder.topLeftCornerSize = cornerSize3;
            CornerTreatment createCornerTreatment2 = ReactYogaConfigProvider.createCornerTreatment(i5);
            builder.topRightCorner = createCornerTreatment2;
            float compatCornerTreatmentSize2 = Builder.compatCornerTreatmentSize(createCornerTreatment2);
            if (compatCornerTreatmentSize2 != -1.0f) {
                builder.setTopRightCornerSize(compatCornerTreatmentSize2);
            }
            builder.topRightCornerSize = cornerSize4;
            CornerTreatment createCornerTreatment3 = ReactYogaConfigProvider.createCornerTreatment(i6);
            builder.bottomRightCorner = createCornerTreatment3;
            float compatCornerTreatmentSize3 = Builder.compatCornerTreatmentSize(createCornerTreatment3);
            if (compatCornerTreatmentSize3 != -1.0f) {
                builder.setBottomRightCornerSize(compatCornerTreatmentSize3);
            }
            builder.bottomRightCornerSize = cornerSize5;
            CornerTreatment createCornerTreatment4 = ReactYogaConfigProvider.createCornerTreatment(i7);
            builder.bottomLeftCorner = createCornerTreatment4;
            float compatCornerTreatmentSize4 = Builder.compatCornerTreatmentSize(createCornerTreatment4);
            if (compatCornerTreatmentSize4 != -1.0f) {
                builder.setBottomLeftCornerSize(compatCornerTreatmentSize4);
            }
            builder.bottomLeftCornerSize = cornerSize6;
            return builder;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static final class Builder {
        public EdgeTreatment bottomEdge = new EdgeTreatment();
        public CornerTreatment bottomLeftCorner = new RoundedCornerTreatment();
        public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        public CornerTreatment bottomRightCorner = new RoundedCornerTreatment();
        public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        public EdgeTreatment leftEdge = new EdgeTreatment();
        public EdgeTreatment rightEdge = new EdgeTreatment();
        public EdgeTreatment topEdge = new EdgeTreatment();
        public CornerTreatment topLeftCorner = new RoundedCornerTreatment();
        public CornerSize topLeftCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        public CornerTreatment topRightCorner = new RoundedCornerTreatment();
        public CornerSize topRightCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);

        public Builder() {
        }

        public static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }

        public Builder setBottomLeftCornerSize(float f) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        public Builder setBottomRightCornerSize(float f) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        public Builder setTopLeftCornerSize(float f) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        public Builder setTopRightCornerSize(float f) {
            this.topRightCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = new RoundedCornerTreatment();
        this.topRightCorner = new RoundedCornerTreatment();
        this.bottomRightCorner = new RoundedCornerTreatment();
        this.bottomLeftCorner = new RoundedCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.topRightCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.bottomRightCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        this.topEdge = new EdgeTreatment();
        this.rightEdge = new EdgeTreatment();
        this.bottomEdge = new EdgeTreatment();
        this.leftEdge = new EdgeTreatment();
    }
}
