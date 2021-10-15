package c.b.d;

import c.b.d.a;
import c.b.d.f1;
import c.b.d.i1;
import c.b.d.s;
import c.b.d.y0;
import java.util.Map;
import java.util.TreeMap;

public final class x0<K, V> extends a {

    /* renamed from: b  reason: collision with root package name */
    public final K f5912b;

    /* renamed from: c  reason: collision with root package name */
    public final V f5913c;

    /* renamed from: d  reason: collision with root package name */
    public final c<K, V> f5914d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f5915e = -1;

    public static class b<K, V> extends a.AbstractC0106a<b<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final c<K, V> f5916b = null;

        /* renamed from: c  reason: collision with root package name */
        public K f5917c;

        /* renamed from: d  reason: collision with root package name */
        public V f5918d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5919e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5920f;

        /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/x0$c<TK;TV;>;TK;TV;ZZ)V */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj, Object obj2, boolean z, boolean z2) {
            this.f5917c = obj;
            this.f5918d = obj2;
            this.f5919e = z;
            this.f5920f = z2;
        }

        /* renamed from: a */
        public x0<K, V> buildPartial() {
            return new x0<>(null, this.f5917c, this.f5918d, null);
        }

        @Override // c.b.d.f1.a
        public f1.a addRepeatedField(s.g gVar, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* renamed from: b */
        public b<K, V> clone() {
            return new b<>(this.f5917c, this.f5918d, this.f5919e, this.f5920f);
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
        public f1 build() {
            buildPartial();
            throw null;
        }

        @Override // c.b.d.f1.a
        public f1.a clearField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.k1
        public Map<s.g, Object> getAllFields() {
            new TreeMap();
            throw null;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            throw null;
        }

        @Override // c.b.d.k1, c.b.d.f1.a
        public s.b getDescriptorForType() {
            throw null;
        }

        @Override // c.b.d.k1
        public Object getField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.k1
        public q2 getUnknownFields() {
            return q2.f5482d;
        }

        @Override // c.b.d.k1
        public boolean hasField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.j1
        public boolean isInitialized() {
            throw null;
        }

        @Override // c.b.d.f1.a
        public f1.a newBuilderForField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.f1.a
        public f1.a setField(s.g gVar, Object obj) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.f1.a
        public f1.a setUnknownFields(q2 q2Var) {
            return this;
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m347getDefaultInstanceForType() {
            throw null;
        }

        @Override // c.b.d.i1.a, c.b.d.f1.a
        /* renamed from: build  reason: collision with other method in class */
        public i1 m346build() {
            buildPartial();
            throw null;
        }
    }

    public static final class c<K, V> extends y0.a<K, V> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public x0(c cVar, Object obj, Object obj2, a aVar) {
        this.f5912b = obj;
        this.f5913c = obj2;
        this.f5914d = null;
    }

    @Override // c.b.d.k1
    public Map<s.g, Object> getAllFields() {
        new TreeMap();
        throw null;
    }

    @Override // c.b.d.k1, c.b.d.j1
    public f1 getDefaultInstanceForType() {
        throw null;
    }

    @Override // c.b.d.k1
    public s.b getDescriptorForType() {
        throw null;
    }

    @Override // c.b.d.k1
    public Object getField(s.g gVar) {
        s.b bVar = gVar.h;
        throw null;
    }

    @Override // c.b.d.i1
    public w1<x0<K, V>> getParserForType() {
        throw null;
    }

    @Override // c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        if (this.f5915e != -1) {
            return this.f5915e;
        }
        int a2 = y0.a(this.f5912b, this.f5913c);
        this.f5915e = a2;
        return a2;
    }

    @Override // c.b.d.k1
    public q2 getUnknownFields() {
        return q2.f5482d;
    }

    @Override // c.b.d.k1
    public boolean hasField(s.g gVar) {
        s.b bVar = gVar.h;
        throw null;
    }

    @Override // c.b.d.a, c.b.d.j1
    public boolean isInitialized() {
        throw null;
    }

    @Override // c.b.d.f1, c.b.d.i1
    public f1.a newBuilderForType() {
        throw null;
    }

    @Override // c.b.d.f1, c.b.d.i1
    public f1.a toBuilder() {
        return new b(this.f5912b, this.f5913c, true, true);
    }

    @Override // c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        y0.b(mVar, this.f5912b, this.f5913c);
    }

    @Override // c.b.d.k1, c.b.d.j1
    /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
    public i1 m343getDefaultInstanceForType() {
        throw null;
    }

    @Override // c.b.d.f1, c.b.d.i1
    /* renamed from: newBuilderForType  reason: collision with other method in class */
    public i1.a m344newBuilderForType() {
        throw null;
    }

    @Override // c.b.d.f1, c.b.d.i1
    /* renamed from: toBuilder  reason: collision with other method in class */
    public i1.a m345toBuilder() {
        return new b(this.f5912b, this.f5913c, true, true);
    }
}
