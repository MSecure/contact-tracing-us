package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
public final class ImmutableValueGraph<N, V> extends StandardValueGraph<N, V> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, @NullableDecl Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, @NullableDecl Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.AbstractValueGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.AbstractValueGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.AbstractValueGraph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.StandardValueGraph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.StandardValueGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.from(valueGraph), getNodeConnections(valueGraph), (long) valueGraph.edges().size());
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.ValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.AbstractValueGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.stable();
    }

    @Override // com.google.common.graph.ValueGraph, com.google.common.graph.AbstractValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : valueGraph.nodes()) {
            builder.put(n, connectionsOf(valueGraph, n));
        }
        return builder.build();
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> valueGraph, final N n) {
        AnonymousClass1 r0 = new Function<N, V>() {
            /* class com.google.common.graph.ImmutableValueGraph.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.graph.ValueGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.base.Function
            public V apply(N n) {
                return (V) valueGraph.edgeValueOrDefault(n, n, null);
            }
        };
        if (valueGraph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(n, valueGraph.incidentEdges(n), r0);
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(valueGraph.adjacentNodes(n), r0));
    }

    public static class Builder<N, V> {
        private final MutableValueGraph<N, V> mutableValueGraph;

        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: com.google.common.graph.MutableValueGraph<N1 extends N, V1 extends V>, com.google.common.graph.MutableValueGraph<N, V> */
        Builder(ValueGraphBuilder<N, V> valueGraphBuilder) {
            this.mutableValueGraph = (MutableValueGraph<N1, V1>) valueGraphBuilder.copy().incidentEdgeOrder(ElementOrder.stable()).build();
        }

        public Builder<N, V> addNode(N n) {
            this.mutableValueGraph.addNode(n);
            return this;
        }

        public Builder<N, V> putEdgeValue(N n, N n2, V v) {
            this.mutableValueGraph.putEdgeValue(n, n2, v);
            return this;
        }

        public Builder<N, V> putEdgeValue(EndpointPair<N> endpointPair, V v) {
            this.mutableValueGraph.putEdgeValue(endpointPair, v);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.mutableValueGraph);
        }
    }
}
