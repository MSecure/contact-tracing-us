package j.j.b;

import java.io.Serializable;
import java.util.Objects;

public abstract class f<R> implements d<R>, Serializable {
    public final int b;

    public f(int i2) {
        this.b = i2;
    }

    @Override // j.j.b.d
    public int b() {
        return this.b;
    }

    public String toString() {
        Objects.requireNonNull(g.a);
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        e.b(obj, "Reflection.renderLambdaToString(this)");
        return obj;
    }
}
