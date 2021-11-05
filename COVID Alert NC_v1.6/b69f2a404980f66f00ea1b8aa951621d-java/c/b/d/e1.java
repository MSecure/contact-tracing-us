package c.b.d;

import c.b.d.h1;
import c.b.d.s;

public interface e1 extends h1, j1 {

    public interface a extends h1.a, j1 {
        a addRepeatedField(s.g gVar, Object obj);

        @Override // c.b.d.h1.a
        e1 build();

        @Override // c.b.d.h1.a
        e1 buildPartial();

        a clearField(s.g gVar);

        @Override // c.b.d.j1
        s.b getDescriptorForType();

        a mergeFrom(e1 e1Var);

        a mergeFrom(j jVar, z zVar);

        a newBuilderForField(s.g gVar);

        a setField(s.g gVar, Object obj);

        a setUnknownFields(p2 p2Var);
    }

    @Override // c.b.d.h1
    a newBuilderForType();

    @Override // c.b.d.h1
    a toBuilder();
}
