package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class ValueAnimatedNode extends AnimatedNode {
    public Object mAnimatedObject = null;
    public double mOffset = 0.0d;
    public double mValue = Double.NaN;
    public AnimatedNodeValueListener mValueListener;

    public ValueAnimatedNode() {
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble("value");
        this.mOffset = readableMap.getDouble("offset");
    }
}
