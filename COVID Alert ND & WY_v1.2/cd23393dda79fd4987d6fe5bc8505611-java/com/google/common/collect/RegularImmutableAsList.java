package com.google.common.collect;

class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr, int i) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr, i));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.common.collect.UnmodifiableListIterator<? extends E>, com.google.common.collect.UnmodifiableListIterator<E> */
    @Override // java.util.List, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableList
    public UnmodifiableListIterator<E> listIterator(int i) {
        return (UnmodifiableListIterator<? extends E>) this.delegateList.listIterator(i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        return this.delegateList.copyIntoArray(objArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // java.util.List
    public E get(int i) {
        return (E) this.delegateList.get(i);
    }
}
