package f.b.a.b.i.t;

public interface b {

    public interface a<T> {
        T a();
    }

    <T> T c(a<T> aVar);
}
