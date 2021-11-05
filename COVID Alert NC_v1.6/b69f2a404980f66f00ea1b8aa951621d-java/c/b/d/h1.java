package c.b.d;

public interface h1 extends i1 {

    public interface a extends i1, Cloneable {
        h1 build();

        h1 buildPartial();

        a mergeFrom(h1 h1Var);

        a mergeFrom(k kVar, z zVar);
    }

    v1<? extends h1> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    j toByteString();

    void writeTo(m mVar);
}
