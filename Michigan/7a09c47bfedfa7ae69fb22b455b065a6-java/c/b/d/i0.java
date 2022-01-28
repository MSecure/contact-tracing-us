package c.b.d;

import c.b.d.a;
import c.b.d.f1;
import c.b.d.s;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public abstract class i0 extends a implements Serializable {

    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b f5314a;

        public a(i0 i0Var, a.b bVar) {
            this.f5314a = bVar;
        }

        @Override // c.b.d.a.b
        public void a() {
            this.f5314a.a();
        }
    }

    public interface b extends a.b {
    }

    public i0() {
        q2 q2Var = q2.f5482d;
    }

    public abstract void a();

    public abstract f1.a b(b bVar);

    @Override // c.b.d.k1
    public Map<s.g, Object> getAllFields() {
        new TreeMap();
        a();
        throw null;
    }

    @Override // c.b.d.k1
    public s.b getDescriptorForType() {
        a();
        throw null;
    }

    @Override // c.b.d.k1
    public Object getField(s.g gVar) {
        a();
        throw null;
    }

    @Override // c.b.d.a
    public s.g getOneofFieldDescriptor(s.k kVar) {
        a();
        throw null;
    }

    @Override // c.b.d.i1
    public w1<? extends i0> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        new TreeMap();
        a();
        throw null;
    }

    @Override // c.b.d.k1
    public q2 getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // c.b.d.k1
    public boolean hasField(s.g gVar) {
        a();
        throw null;
    }

    @Override // c.b.d.a
    public boolean hasOneof(s.k kVar) {
        a();
        throw null;
    }

    @Override // c.b.d.a, c.b.d.j1
    public boolean isInitialized() {
        a();
        throw null;
    }

    @Override // c.b.d.a
    public f1.a newBuilderForType(a.b bVar) {
        return b(new a(this, bVar));
    }

    @Override // c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        new TreeMap();
        a();
        throw null;
    }
}
