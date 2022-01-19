package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.lang.ref.SoftReference;
import java.util.LinkedList;

public class OOMSoftReferenceBucket<V> extends Bucket<V> {
    public LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList<>();

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3, false);
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public void addToFreeList(V v) {
        OOMSoftReference<V> poll = this.mSpareReferences.poll();
        if (poll == null) {
            poll = new OOMSoftReference<>();
        }
        poll.softRef1 = new SoftReference<>(v);
        poll.softRef2 = new SoftReference<>(v);
        poll.softRef3 = new SoftReference<>(v);
        this.mFreeList.add(poll);
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public V pop() {
        OOMSoftReference<V> oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
        SoftReference<T> softReference = oOMSoftReference.softRef1;
        T t = softReference == null ? (V) null : softReference.get();
        SoftReference<T> softReference2 = oOMSoftReference.softRef1;
        if (softReference2 != null) {
            softReference2.clear();
            oOMSoftReference.softRef1 = null;
        }
        SoftReference<T> softReference3 = oOMSoftReference.softRef2;
        if (softReference3 != null) {
            softReference3.clear();
            oOMSoftReference.softRef2 = null;
        }
        SoftReference<T> softReference4 = oOMSoftReference.softRef3;
        if (softReference4 != null) {
            softReference4.clear();
            oOMSoftReference.softRef3 = null;
        }
        this.mSpareReferences.add(oOMSoftReference);
        return (V) t;
    }
}
