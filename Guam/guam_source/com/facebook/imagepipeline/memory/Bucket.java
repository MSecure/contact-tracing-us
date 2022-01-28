package com.facebook.imagepipeline.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;

public class Bucket<V> {
    public final boolean mFixBucketsReinitialization;
    public final Queue mFreeList;
    public int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
        boolean z2 = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(i > 0);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(i2 >= 0);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(i3 < 0 ? false : z2);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public void addToFreeList(V v) {
        this.mFreeList.add(v);
    }

    public void decrementInUseCount() {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mInUseLength > 0);
        this.mInUseLength--;
    }

    public V pop() {
        return (V) this.mFreeList.poll();
    }

    public void release(V v) {
        boolean z = false;
        if (this.mFixBucketsReinitialization) {
            if (this.mInUseLength > 0) {
                z = true;
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(z);
            this.mInUseLength--;
            addToFreeList(v);
            return;
        }
        int i = this.mInUseLength;
        if (i > 0) {
            this.mInUseLength = i - 1;
            addToFreeList(v);
            return;
        }
        FLog.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
    }
}
