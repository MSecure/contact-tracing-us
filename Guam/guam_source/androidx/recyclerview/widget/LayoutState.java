package androidx.recyclerview.widget;

import com.android.tools.r8.GeneratedOutlineSupport;

public class LayoutState {
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("LayoutState{mAvailable=");
        outline15.append(this.mAvailable);
        outline15.append(", mCurrentPosition=");
        outline15.append(this.mCurrentPosition);
        outline15.append(", mItemDirection=");
        outline15.append(this.mItemDirection);
        outline15.append(", mLayoutDirection=");
        outline15.append(this.mLayoutDirection);
        outline15.append(", mStartLine=");
        outline15.append(this.mStartLine);
        outline15.append(", mEndLine=");
        outline15.append(this.mEndLine);
        outline15.append('}');
        return outline15.toString();
    }
}
