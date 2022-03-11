package h.a;

import java.util.Comparator;
/* loaded from: classes.dex */
public class a1 implements Comparator<T> {
    public final /* synthetic */ b1 a;

    public a1(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        int a = this.a.a(t) - this.a.a(t2);
        return a != 0 ? a : t.getClass().getName().compareTo(t2.getClass().getName());
    }
}
