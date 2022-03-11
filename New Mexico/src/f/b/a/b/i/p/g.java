package f.b.a.b.i.p;
/* loaded from: classes.dex */
public abstract class g {

    /* loaded from: classes.dex */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static g a() {
        return new b(a.FATAL_ERROR, -1);
    }

    public abstract long b();

    public abstract a c();
}
