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
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("LayoutState{mAvailable=");
        outline17.append(this.mAvailable);
        outline17.append(", mCurrentPosition=");
        outline17.append(this.mCurrentPosition);
        outline17.append(", mItemDirection=");
        outline17.append(this.mItemDirection);
        outline17.append(", mLayoutDirection=");
        outline17.append(this.mLayoutDirection);
        outline17.append(", mStartLine=");
        outline17.append(this.mStartLine);
        outline17.append(", mEndLine=");
        outline17.append(this.mEndLine);
        outline17.append('}');
        return outline17.toString();
    }
}
