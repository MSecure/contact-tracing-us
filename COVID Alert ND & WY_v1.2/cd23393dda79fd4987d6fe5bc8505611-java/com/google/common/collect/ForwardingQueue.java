package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingCollection
    public abstract Queue<E> delegate();

    protected ForwardingQueue() {
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return delegate().offer(e);
    }

    @Override // java.util.Queue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return delegate().remove();
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    /* access modifiers changed from: protected */
    public boolean standardOffer(E e) {
        try {
            return add(e);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
