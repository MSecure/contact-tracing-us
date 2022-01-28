package f.b.c.k.t;

public final /* synthetic */ class y0 implements Runnable {
    public final a1 b;

    public y0(a1 a1Var) {
        this.b = a1Var;
    }

    public void run() {
        this.b.a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }
}
