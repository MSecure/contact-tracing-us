package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
public class TextPathView extends TextView {
    public String mHref;
    public TextProperties$TextPathMidLine mMidLine;
    public TextProperties$TextPathSide mSide;
    public SVGLength mStartOffset;

    public TextPathView(ReactContext reactContext) {
        super(reactContext);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public void draw(Canvas canvas, Paint paint, float f) {
        drawGroup(canvas, paint, f);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView, com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public Path getPath(Canvas canvas, Paint paint) {
        return getGroupPath(canvas, paint);
    }

    @Override // com.horcrux.svg.GroupView
    public void popGlyphContext() {
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public void pushGlyphContext() {
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    @Override // com.horcrux.svg.TextView
    @ReactProp(name = "method")
    public void setMethod(String str) {
        TextProperties$TextPathMethod.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "midLine")
    public void setSharp(String str) {
        this.mMidLine = TextProperties$TextPathMidLine.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "side")
    public void setSide(String str) {
        this.mSide = TextProperties$TextPathSide.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "spacing")
    public void setSpacing(String str) {
        TextProperties$TextPathSpacing.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "startOffset")
    public void setStartOffset(Dynamic dynamic) {
        this.mStartOffset = SVGLength.from(dynamic);
        invalidate();
    }
}
