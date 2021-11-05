package c.b.d;

import c.b.d.i1;
import c.b.d.s;

public interface f1 extends i1, k1 {

    public interface a extends i1.a, k1 {
        a addRepeatedField(s.g gVar, Object obj);

        @Override // c.b.d.i1.a
        f1 build();

        @Override // c.b.d.i1.a
        f1 buildPartial();

        a clearField(s.g gVar);

        @Override // c.b.d.k1
        s.b getDescriptorForType();

        a mergeFrom(f1 f1Var);

        a mergeFrom(j jVar, z zVar);

        a newBuilderForField(s.g gVar);

        a setField(s.g gVar, Object obj);

        a setUnknownFields(q2 q2Var);
    }

    @Override // c.b.d.i1
    a newBuilderForType();

    @Override // c.b.d.i1
    a toBuilder();
}
