package c.b.d;

public interface i1 extends j1 {

    public interface a extends j1, Cloneable {
        i1 build();

        i1 buildPartial();

        a mergeFrom(i1 i1Var);

        a mergeFrom(k kVar, z zVar);
    }

    w1<? extends i1> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    j toByteString();

    void writeTo(m mVar);
}
