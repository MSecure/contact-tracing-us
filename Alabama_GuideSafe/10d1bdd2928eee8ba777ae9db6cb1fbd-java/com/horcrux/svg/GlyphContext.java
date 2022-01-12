package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;

public class GlyphContext {
    public double mDX;
    public int mDXIndex;
    public final ArrayList<Integer> mDXIndices = new ArrayList<>();
    public SVGLength[] mDXs;
    public final ArrayList<SVGLength[]> mDXsContext = new ArrayList<>();
    public int mDXsIndex;
    public final ArrayList<Integer> mDXsIndices = new ArrayList<>();
    public double mDY;
    public int mDYIndex;
    public final ArrayList<Integer> mDYIndices = new ArrayList<>();
    public SVGLength[] mDYs;
    public final ArrayList<SVGLength[]> mDYsContext = new ArrayList<>();
    public int mDYsIndex;
    public final ArrayList<Integer> mDYsIndices = new ArrayList<>();
    public final ArrayList<FontData> mFontContext = new ArrayList<>();
    public double mFontSize = 12.0d;
    public final float mHeight;
    public int mRIndex;
    public final ArrayList<Integer> mRIndices = new ArrayList<>();
    public double[] mRs;
    public final ArrayList<double[]> mRsContext = new ArrayList<>();
    public int mRsIndex;
    public final ArrayList<Integer> mRsIndices = new ArrayList<>();
    public final float mScale;
    public int mTop;
    public final float mWidth;
    public double mX;
    public int mXIndex;
    public final ArrayList<Integer> mXIndices = new ArrayList<>();
    public SVGLength[] mXs;
    public final ArrayList<SVGLength[]> mXsContext = new ArrayList<>();
    public int mXsIndex;
    public final ArrayList<Integer> mXsIndices = new ArrayList<>();
    public double mY;
    public int mYIndex;
    public final ArrayList<Integer> mYIndices = new ArrayList<>();
    public SVGLength[] mYs;
    public final ArrayList<SVGLength[]> mYsContext = new ArrayList<>();
    public int mYsIndex;
    public final ArrayList<Integer> mYsIndices = new ArrayList<>();
    public FontData topFont = FontData.Defaults;

    public GlyphContext(float f, float f2, float f3) {
        SVGLength[] sVGLengthArr = new SVGLength[0];
        this.mXs = sVGLengthArr;
        this.mYs = new SVGLength[0];
        this.mDXs = new SVGLength[0];
        this.mDYs = new SVGLength[0];
        this.mRs = new double[]{0.0d};
        this.mXIndex = -1;
        this.mYIndex = -1;
        this.mDXIndex = -1;
        this.mDYIndex = -1;
        this.mRIndex = -1;
        this.mScale = f;
        this.mWidth = f2;
        this.mHeight = f3;
        this.mXsContext.add(sVGLengthArr);
        this.mYsContext.add(this.mYs);
        this.mDXsContext.add(this.mDXs);
        this.mDYsContext.add(this.mDYs);
        this.mRsContext.add(this.mRs);
        this.mXIndices.add(Integer.valueOf(this.mXIndex));
        this.mYIndices.add(Integer.valueOf(this.mYIndex));
        this.mDXIndices.add(Integer.valueOf(this.mDXIndex));
        this.mDYIndices.add(Integer.valueOf(this.mDYIndex));
        this.mRIndices.add(Integer.valueOf(this.mRIndex));
        this.mFontContext.add(this.topFont);
        pushIndices();
    }

    public static void incrementIndices(ArrayList<Integer> arrayList, int i) {
        while (i >= 0) {
            arrayList.set(i, Integer.valueOf(arrayList.get(i).intValue() + 1));
            i--;
        }
    }

    public final SVGLength[] getStringArrayFromReadableArray(ArrayList<SVGLength> arrayList) {
        int size = arrayList.size();
        SVGLength[] sVGLengthArr = new SVGLength[size];
        for (int i = 0; i < size; i++) {
            sVGLengthArr[i] = arrayList.get(i);
        }
        return sVGLengthArr;
    }

    public double nextX(double d) {
        incrementIndices(this.mXIndices, this.mXsIndex);
        int i = this.mXIndex + 1;
        SVGLength[] sVGLengthArr = this.mXs;
        if (i < sVGLengthArr.length) {
            this.mDX = 0.0d;
            this.mXIndex = i;
            this.mX = MoreExecutors.fromRelative(sVGLengthArr[i], (double) this.mWidth, 0.0d, (double) this.mScale, this.mFontSize);
        }
        double d2 = this.mX + d;
        this.mX = d2;
        return d2;
    }

    public double nextY() {
        incrementIndices(this.mYIndices, this.mYsIndex);
        int i = this.mYIndex + 1;
        SVGLength[] sVGLengthArr = this.mYs;
        if (i < sVGLengthArr.length) {
            this.mDY = 0.0d;
            this.mYIndex = i;
            this.mY = MoreExecutors.fromRelative(sVGLengthArr[i], (double) this.mHeight, 0.0d, (double) this.mScale, this.mFontSize);
        }
        return this.mY;
    }

    public final void pushIndices() {
        this.mXsIndices.add(Integer.valueOf(this.mXsIndex));
        this.mYsIndices.add(Integer.valueOf(this.mYsIndex));
        this.mDXsIndices.add(Integer.valueOf(this.mDXsIndex));
        this.mDYsIndices.add(Integer.valueOf(this.mDYsIndex));
        this.mRsIndices.add(Integer.valueOf(this.mRsIndex));
    }

    public final void pushNodeAndFont(GroupView groupView, ReadableMap readableMap) {
        FontData fontData;
        if (this.mTop > 0) {
            fontData = this.topFont;
        } else {
            GroupView parentTextRoot = groupView.getParentTextRoot();
            while (true) {
                if (parentTextRoot == null) {
                    fontData = FontData.Defaults;
                    break;
                }
                FontData fontData2 = parentTextRoot.mGlyphContext.topFont;
                if (fontData2 != FontData.Defaults) {
                    fontData = fontData2;
                    break;
                }
                parentTextRoot = parentTextRoot.getParentTextRoot();
            }
        }
        this.mTop++;
        if (readableMap == null) {
            this.mFontContext.add(fontData);
            return;
        }
        FontData fontData3 = new FontData(readableMap, fontData, (double) this.mScale);
        this.mFontSize = fontData3.fontSize;
        this.mFontContext.add(fontData3);
        this.topFont = fontData3;
    }
}
