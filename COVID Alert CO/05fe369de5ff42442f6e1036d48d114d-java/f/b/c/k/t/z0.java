package f.b.c.k.t;

public final /* synthetic */ class z0 implements Runnable {
    public final a1 b;

    public z0(a1 a1Var) {
        this.b = a1Var;
    }

    public void run() {
        this.b.a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }
}
