package f.b.b.a;

public final class a<T> extends l<T> {
    public static final a<Object> b = new a<>();

    @Override // f.b.b.a.l
    public T a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // f.b.b.a.l
    public boolean b() {
        return false;
    }

    @Override // f.b.b.a.l
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // f.b.b.a.l
    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
