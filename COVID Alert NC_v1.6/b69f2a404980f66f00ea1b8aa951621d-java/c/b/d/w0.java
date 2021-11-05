package c.b.d;

import c.b.d.a;
import c.b.d.e1;
import c.b.d.h1;
import c.b.d.s;
import c.b.d.x0;
import java.util.Map;
import java.util.TreeMap;

public final class w0<K, V> extends a {

    /* renamed from: b  reason: collision with root package name */
    public final K f4363b;

    /* renamed from: c  reason: collision with root package name */
    public final V f4364c;

    /* renamed from: d  reason: collision with root package name */
    public final c<K, V> f4365d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4366e = -1;

    public static class b<K, V> extends a.AbstractC0097a<b<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final c<K, V> f4367b = null;

        /* renamed from: c  reason: collision with root package name */
        public K f4368c;

        /* renamed from: d  reason: collision with root package name */
        public V f4369d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4370e;
        public boolean f;

        /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/w0$c<TK;TV;>;TK;TV;ZZ)V */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj, Object obj2, boolean z, boolean z2) {
            this.f4368c = obj;
            this.f4369d = obj2;
            this.f4370e = z;
            this.f = z2;
        }

        /* renamed from: a */
        public w0<K, V> buildPartial() {
            return new w0<>(null, this.f4368c, this.f4369d, null);
        }

        @Override // c.b.d.e1.a
        public e1.a addRepeatedField(s.g gVar, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* renamed from: b */
        public b<K, V> clone() {
            return new b<>(this.f4368c, this.f4369d, this.f4370e, this.f);
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        public e1 build() {
            buildPartial();
            throw null;
        }

        @Override // c.b.d.e1.a
        public e1.a clearField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.j1
        public Map<s.g, Object> getAllFields() {
            new TreeMap();
            throw null;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            throw null;
        }

        @Override // c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            throw null;
        }

        @Override // c.b.d.j1
        public Object getField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.j1
        public p2 getUnknownFields() {
            return p2.f4026d;
        }

        @Override // c.b.d.j1
        public boolean hasField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.i1
        public boolean isInitialized() {
            throw null;
        }

        @Override // c.b.d.e1.a
        public e1.a newBuilderForField(s.g gVar) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.e1.a
        public e1.a setField(s.g gVar, Object obj) {
            s.b bVar = gVar.h;
            throw null;
        }

        @Override // c.b.d.e1.a
        public e1.a setUnknownFields(p2 p2Var) {
            return this;
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m347getDefaultInstanceForType() {
            throw null;
        }

        @Override // c.b.d.h1.a, c.b.d.e1.a
        /* renamed from: build  reason: collision with other method in class */
        public h1 m346build() {
            buildPartial();
            throw null;
        }
    }

    public static final class c<K, V> extends x0.a<K, V> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public w0(c cVar, Object obj, Object obj2, a aVar) {
        this.f4363b = obj;
        this.f4364c = obj2;
        this.f4365d = null;
    }

    @Override // c.b.d.j1
    public Map<s.g, Object> getAllFields() {
        new TreeMap();
        throw null;
    }

    @Override // c.b.d.j1, c.b.d.i1
    public e1 getDefaultInstanceForType() {
        throw null;
    }

    @Override // c.b.d.j1
    public s.b getDescriptorForType() {
        throw null;
    }

    @Override // c.b.d.j1
    public Object getField(s.g gVar) {
        s.b bVar = gVar.h;
        throw null;
    }

    @Override // c.b.d.h1
    public v1<w0<K, V>> getParserForType() {
        throw null;
    }

    @Override // c.b.d.a, c.b.d.h1
    public int getSerializedSize() {
        if (this.f4366e != -1) {
            return this.f4366e;
        }
        int a2 = x0.a(this.f4363b, this.f4364c);
        this.f4366e = a2;
        return a2;
    }

    @Override // c.b.d.j1
    public p2 getUnknownFields() {
        return p2.f4026d;
    }

    @Override // c.b.d.j1
    public boolean hasField(s.g gVar) {
        s.b bVar = gVar.h;
        throw null;
    }

    @Override // c.b.d.a, c.b.d.i1
    public boolean isInitialized() {
        throw null;
    }

    @Override // c.b.d.e1, c.b.d.h1
    public e1.a newBuilderForType() {
        throw null;
    }

    @Override // c.b.d.e1, c.b.d.h1
    public e1.a toBuilder() {
        return new b(this.f4363b, this.f4364c, true, true);
    }

    @Override // c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        x0.b(mVar, this.f4363b, this.f4364c);
    }

    @Override // c.b.d.j1, c.b.d.i1
    /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
    public h1 m343getDefaultInstanceForType() {
        throw null;
    }

    @Override // c.b.d.e1, c.b.d.h1
    /* renamed from: newBuilderForType  reason: collision with other method in class */
    public h1.a m344newBuilderForType() {
        throw null;
    }

    @Override // c.b.d.e1, c.b.d.h1
    /* renamed from: toBuilder  reason: collision with other method in class */
    public h1.a m345toBuilder() {
        return new b(this.f4363b, this.f4364c, true, true);
    }
}
