package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.ElementOrder;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
public final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    private final Map<N, Object> adjacentNodeValues;
    @NullableDecl
    private final List<NodeConnection<N>> orderedNodeConnections;
    private int predecessorCount;
    private int successorCount;

    /* access modifiers changed from: private */
    public static final class PredAndSucc {
        private final Object successorValue;

        PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    /* access modifiers changed from: private */
    public static abstract class NodeConnection<N> {
        final N node;

        NodeConnection(N n) {
            this.node = (N) Preconditions.checkNotNull(n);
        }

        /* access modifiers changed from: package-private */
        public static final class Pred<N> extends NodeConnection<N> {
            Pred(N n) {
                super(n);
            }

            public boolean equals(Object obj) {
                if (obj instanceof Pred) {
                    return this.node.equals(((Pred) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.node.hashCode();
            }
        }

        /* access modifiers changed from: package-private */
        public static final class Succ<N> extends NodeConnection<N> {
            Succ(N n) {
                super(n);
            }

            public boolean equals(Object obj) {
                if (obj instanceof Succ) {
                    return this.node.equals(((Succ) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.node.hashCode();
            }
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, @NullableDecl List<NodeConnection<N>> list, int i, int i2) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.orderedNodeConnections = list;
        this.predecessorCount = Graphs.checkNonNegative(i);
        this.successorCount = Graphs.checkNonNegative(i2);
        Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    /* renamed from: com.google.common.graph.DirectedGraphConnections$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = iArr;
            iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            $SwitchMap$com$google$common$graph$ElementOrder$Type[ElementOrder.Type.STABLE.ordinal()] = 2;
        }
    }

    static <N, V> DirectedGraphConnections<N, V> of(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i = AnonymousClass8.$SwitchMap$com$google$common$graph$ElementOrder$Type[elementOrder.type().ordinal()];
        if (i == 1) {
            arrayList = null;
        } else if (i == 2) {
            arrayList = new ArrayList();
        } else {
            throw new AssertionError(elementOrder.type());
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    static <N, V> DirectedGraphConnections<N, V> ofImmutable(N n, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        int i2 = 0;
        for (EndpointPair<N> endpointPair : iterable) {
            if (endpointPair.nodeU().equals(n) && endpointPair.nodeV().equals(n)) {
                hashMap.put(n, new PredAndSucc(function.apply(n)));
                builder.add((Object) new NodeConnection.Pred(n));
                builder.add((Object) new NodeConnection.Succ(n));
                i++;
            } else if (endpointPair.nodeV().equals(n)) {
                N nodeU = endpointPair.nodeU();
                Object put = hashMap.put(nodeU, PRED);
                if (put != null) {
                    hashMap.put(nodeU, new PredAndSucc(put));
                }
                builder.add((Object) new NodeConnection.Pred(nodeU));
                i++;
            } else {
                Preconditions.checkArgument(endpointPair.nodeU().equals(n));
                N nodeV = endpointPair.nodeV();
                V apply = function.apply(nodeV);
                Object put2 = hashMap.put(nodeV, apply);
                if (put2 != null) {
                    Preconditions.checkArgument(put2 == PRED);
                    hashMap.put(nodeV, new PredAndSucc(apply));
                }
                builder.add((Object) new NodeConnection.Succ(nodeV));
            }
            i2++;
        }
        return new DirectedGraphConnections<>(hashMap, builder.build(), i, i2);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        if (this.orderedNodeConnections == null) {
            return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
        }
        return new AbstractSet<N>() {
            /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass1 */

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>() {
                    /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass1.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it.next();
                            if (hashSet.add(nodeConnection.node)) {
                                return nodeConnection.node;
                            }
                        }
                        return (N) endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.adjacentNodeValues.size();
            }

            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.this.adjacentNodeValues.containsKey(obj);
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AbstractSet<N>() {
            /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass2 */

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>() {
                        /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass2.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return (N) endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>() {
                    /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass2.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.node;
                            }
                        }
                        return (N) endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }

            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AbstractSet<N>() {
            /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass3 */

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>() {
                        /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass3.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return (N) endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>() {
                    /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass3.AnonymousClass2 */

                    /* access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.node;
                            }
                        }
                        return (N) endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }

            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> incidentEdgeIterator(final N n) {
        final Iterator it;
        Preconditions.checkNotNull(n);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        if (list == null) {
            it = Iterators.concat(Iterators.transform(predecessors().iterator(), new Function<N, EndpointPair<N>>() {
                /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass4 */

                @Override // com.google.common.base.Function
                public EndpointPair<N> apply(N n) {
                    return EndpointPair.ordered(n, n);
                }
            }), Iterators.transform(successors().iterator(), new Function<N, EndpointPair<N>>() {
                /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass5 */

                @Override // com.google.common.base.Function
                public EndpointPair<N> apply(N n) {
                    return EndpointPair.ordered(n, n);
                }
            }));
        } else {
            it = Iterators.transform(list.iterator(), new Function<NodeConnection<N>, EndpointPair<N>>() {
                /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass6 */

                @Override // com.google.common.base.Function
                public /* bridge */ /* synthetic */ Object apply(Object obj) {
                    return apply((NodeConnection) ((NodeConnection) obj));
                }

                public EndpointPair<N> apply(NodeConnection<N> nodeConnection) {
                    if (nodeConnection instanceof NodeConnection.Succ) {
                        return EndpointPair.ordered(n, nodeConnection.node);
                    }
                    return EndpointPair.ordered(nodeConnection.node, n);
                }
            });
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>() {
            /* class com.google.common.graph.DirectedGraphConnections.AnonymousClass7 */

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
            @Override // com.google.common.collect.AbstractIterator
            public EndpointPair<N> computeNext() {
                while (it.hasNext()) {
                    EndpointPair<N> endpointPair = (EndpointPair) it.next();
                    if (!endpointPair.nodeU().equals(endpointPair.nodeV()) || !atomicBoolean.getAndSet(true)) {
                        return endpointPair;
                    }
                    while (it.hasNext()) {
                    }
                }
                return (EndpointPair) endOfData();
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public V value(N n) {
        Preconditions.checkNotNull(n);
        V v = (V) this.adjacentNodeValues.get(n);
        if (v == PRED) {
            return null;
        }
        return v instanceof PredAndSucc ? (V) ((PredAndSucc) v).successorValue : v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N n) {
        boolean z;
        Preconditions.checkNotNull(n);
        Object obj = this.adjacentNodeValues.get(n);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(n);
        } else if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n, ((PredAndSucc) obj).successorValue);
        } else {
            z = false;
            if (!z) {
                int i = this.predecessorCount - 1;
                this.predecessorCount = i;
                Graphs.checkNonNegative(i);
                List<NodeConnection<N>> list = this.orderedNodeConnections;
                if (list != null) {
                    list.remove(new NodeConnection.Pred(n));
                    return;
                }
                return;
            }
            return;
        }
        z = true;
        if (!z) {
        }
    }

    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        V v = (V) this.adjacentNodeValues.get(obj);
        if (v == null || v == (obj2 = PRED)) {
            v = null;
        } else if (v instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, obj2);
            v = (V) ((PredAndSucc) v).successorValue;
        } else {
            this.adjacentNodeValues.remove(obj);
        }
        if (v != null) {
            int i = this.successorCount - 1;
            this.successorCount = i;
            Graphs.checkNonNegative(i);
            List<NodeConnection<N>> list = this.orderedNodeConnections;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        return v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N n, V v) {
        Map<N, Object> map = this.adjacentNodeValues;
        Object obj = PRED;
        Object put = map.put(n, obj);
        boolean z = false;
        if (put != null) {
            if (put instanceof PredAndSucc) {
                this.adjacentNodeValues.put(n, put);
            } else if (put != obj) {
                this.adjacentNodeValues.put(n, new PredAndSucc(put));
            }
            if (!z) {
                int i = this.predecessorCount + 1;
                this.predecessorCount = i;
                Graphs.checkPositive(i);
                List<NodeConnection<N>> list = this.orderedNodeConnections;
                if (list != null) {
                    list.add(new NodeConnection.Pred(n));
                    return;
                }
                return;
            }
            return;
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N n, V v) {
        V v2 = (V) this.adjacentNodeValues.put(n, v);
        if (v2 != null) {
            if (v2 instanceof PredAndSucc) {
                this.adjacentNodeValues.put(n, new PredAndSucc(v));
                v2 = (V) ((PredAndSucc) v2).successorValue;
            } else if (v2 == PRED) {
                this.adjacentNodeValues.put(n, new PredAndSucc(v));
            }
            if (v2 == null) {
                int i = this.successorCount + 1;
                this.successorCount = i;
                Graphs.checkPositive(i);
                List<NodeConnection<N>> list = this.orderedNodeConnections;
                if (list != null) {
                    list.add(new NodeConnection.Succ(n));
                }
            }
            return v2;
        }
        v2 = null;
        if (v2 == null) {
        }
        return v2;
    }

    /* access modifiers changed from: private */
    public static boolean isPredecessor(@NullableDecl Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* access modifiers changed from: private */
    public static boolean isSuccessor(@NullableDecl Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }
}
