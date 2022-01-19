package com.google.common.util.concurrent;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    public List<Present<V>> values;

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            DirectExecutor directExecutor = DirectExecutor.INSTANCE;
            if (this.futures.isEmpty()) {
                handleAllCompleted();
            } else if (this.allMustSucceed) {
                int i = 0;
                UnmodifiableListIterator listIterator = ((ImmutableList) this.futures).listIterator();
                while (listIterator.hasNext()) {
                    ListenableFuture listenableFuture = (ListenableFuture) listIterator.next();
                    listenableFuture.addListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
                          (r1v5 'listenableFuture' com.google.common.util.concurrent.ListenableFuture)
                          (wrap: com.google.common.util.concurrent.AggregateFuture$1 : 0x002e: CONSTRUCTOR  (r3v0 com.google.common.util.concurrent.AggregateFuture$1) = 
                          (r4v0 'this' com.google.common.util.concurrent.CollectionFuture$ListFuture<V> A[IMMUTABLE_TYPE, THIS])
                          (r1v5 'listenableFuture' com.google.common.util.concurrent.ListenableFuture)
                          (r6v12 'i' int)
                         call: com.google.common.util.concurrent.AggregateFuture.1.<init>(com.google.common.util.concurrent.AggregateFuture, com.google.common.util.concurrent.ListenableFuture, int):void type: CONSTRUCTOR)
                          (r5v1 'directExecutor' com.google.common.util.concurrent.DirectExecutor)
                         type: INTERFACE call: com.google.common.util.concurrent.ListenableFuture.addListener(java.lang.Runnable, java.util.concurrent.Executor):void in method: com.google.common.util.concurrent.CollectionFuture.ListFuture.<init>(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>>, boolean):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: CONSTRUCTOR  (r3v0 com.google.common.util.concurrent.AggregateFuture$1) = 
                          (r4v0 'this' com.google.common.util.concurrent.CollectionFuture$ListFuture<V> A[IMMUTABLE_TYPE, THIS])
                          (r1v5 'listenableFuture' com.google.common.util.concurrent.ListenableFuture)
                          (r6v12 'i' int)
                         call: com.google.common.util.concurrent.AggregateFuture.1.<init>(com.google.common.util.concurrent.AggregateFuture, com.google.common.util.concurrent.ListenableFuture, int):void type: CONSTRUCTOR in method: com.google.common.util.concurrent.CollectionFuture.ListFuture.<init>(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends V>>, boolean):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 26 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.common.util.concurrent.AggregateFuture, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 32 more
                        */
                    /*
                        this = this;
                        r4.<init>(r5, r6)
                        com.google.common.util.concurrent.DirectExecutor r5 = com.google.common.util.concurrent.DirectExecutor.INSTANCE
                        com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> r6 = r4.futures
                        boolean r6 = r6.isEmpty()
                        if (r6 == 0) goto L_0x0011
                        r4.handleAllCompleted()
                        goto L_0x005b
                    L_0x0011:
                        boolean r6 = r4.allMustSucceed
                        if (r6 == 0) goto L_0x0036
                        r6 = 0
                        com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> r0 = r4.futures
                        com.google.common.collect.ImmutableList r0 = (com.google.common.collect.ImmutableList) r0
                        com.google.common.collect.UnmodifiableListIterator r0 = r0.listIterator()
                    L_0x001e:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x005b
                        java.lang.Object r1 = r0.next()
                        com.google.common.util.concurrent.ListenableFuture r1 = (com.google.common.util.concurrent.ListenableFuture) r1
                        int r2 = r6 + 1
                        com.google.common.util.concurrent.AggregateFuture$1 r3 = new com.google.common.util.concurrent.AggregateFuture$1
                        r3.<init>(r1, r6)
                        r1.addListener(r3, r5)
                        r6 = r2
                        goto L_0x001e
                    L_0x0036:
                        boolean r6 = r4.collectsValues
                        if (r6 == 0) goto L_0x003d
                        com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> r6 = r4.futures
                        goto L_0x003e
                    L_0x003d:
                        r6 = 0
                    L_0x003e:
                        com.google.common.util.concurrent.AggregateFuture$2 r0 = new com.google.common.util.concurrent.AggregateFuture$2
                        r0.<init>(r6)
                        com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> r6 = r4.futures
                        com.google.common.collect.ImmutableList r6 = (com.google.common.collect.ImmutableList) r6
                        com.google.common.collect.UnmodifiableListIterator r6 = r6.listIterator()
                    L_0x004b:
                        boolean r1 = r6.hasNext()
                        if (r1 == 0) goto L_0x005b
                        java.lang.Object r1 = r6.next()
                        com.google.common.util.concurrent.ListenableFuture r1 = (com.google.common.util.concurrent.ListenableFuture) r1
                        r1.addListener(r0, r5)
                        goto L_0x004b
                    L_0x005b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.CollectionFuture.ListFuture.<init>(com.google.common.collect.ImmutableCollection, boolean):void");
                }
            }

            public static final class Present<V> {
                public V value;

                public Present(V v) {
                    this.value = v;
                }
            }

            public CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
                super(immutableCollection, z, true);
                List<Present<V>> list;
                if (immutableCollection.isEmpty()) {
                    list = ImmutableList.of();
                } else {
                    int size = immutableCollection.size();
                    ReactYogaConfigProvider.checkNonnegative(size, "initialArraySize");
                    list = new ArrayList(size);
                }
                for (int i = 0; i < immutableCollection.size(); i++) {
                    list.add(null);
                }
                this.values = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.util.concurrent.CollectionFuture<V, C> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.AggregateFuture
            public final void handleAllCompleted() {
                List<Present<V>> list = this.values;
                if (list != null) {
                    int size = list.size();
                    ReactYogaConfigProvider.checkNonnegative(size, "initialArraySize");
                    ArrayList arrayList = new ArrayList(size);
                    Iterator<Present<V>> it = list.iterator();
                    while (it.hasNext()) {
                        Present<V> next = it.next();
                        arrayList.add(next != null ? next.value : null);
                    }
                    set(Collections.unmodifiableList(arrayList));
                }
            }
        }
