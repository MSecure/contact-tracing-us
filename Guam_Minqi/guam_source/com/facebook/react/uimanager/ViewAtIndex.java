package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Comparator;

public class ViewAtIndex {
    public static Comparator<ViewAtIndex> COMPARATOR = new Comparator<ViewAtIndex>() {
        /* class com.facebook.react.uimanager.ViewAtIndex.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(ViewAtIndex viewAtIndex, ViewAtIndex viewAtIndex2) {
            return viewAtIndex.mIndex - viewAtIndex2.mIndex;
        }
    };
    public final int mIndex;
    public final int mTag;

    public ViewAtIndex(int i, int i2) {
        this.mTag = i;
        this.mIndex = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != ViewAtIndex.class) {
            return false;
        }
        ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
        if (this.mIndex == viewAtIndex.mIndex && this.mTag == viewAtIndex.mTag) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("[");
        outline15.append(this.mTag);
        outline15.append(", ");
        return GeneratedOutlineSupport.outline11(outline15, this.mIndex, "]");
    }
}
