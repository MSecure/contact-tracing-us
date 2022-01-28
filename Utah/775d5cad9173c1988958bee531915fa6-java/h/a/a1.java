package h.a;

import java.util.Comparator;

public class a1 implements Comparator<T> {
    public final /* synthetic */ b1 a;

    public a1(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        int a2 = this.a.a(t) - this.a.a(t2);
        return a2 != 0 ? a2 : t.getClass().getName().compareTo(t2.getClass().getName());
    }
}
