package f.b.c.k.t;

public final /* synthetic */ class v0 implements Runnable {
    public final a1 b;

    public v0(a1 a1Var) {
        this.b = a1Var;
    }

    public void run() {
        a1 a1Var = this.b;
        a1Var.a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        a1Var.a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        a1Var.a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }
}
