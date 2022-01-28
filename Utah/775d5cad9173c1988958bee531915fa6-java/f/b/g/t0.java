package f.b.g;

import java.io.OutputStream;

public interface t0 extends u0 {

    public interface a extends u0, Cloneable {
        t0 build();

        t0 buildPartial();

        a mergeFrom(t0 t0Var);
    }

    b1<? extends t0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    j toByteString();

    void writeTo(m mVar);

    void writeTo(OutputStream outputStream);
}
