package f.b.c.k.t;

public final /* synthetic */ class x0 implements Runnable {
    public final a1 b;

    public x0(a1 a1Var) {
        this.b = a1Var;
    }

    public void run() {
        a1 a1Var = this.b;
        a1Var.a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        a1Var.a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        a1Var.a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        a1Var.a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        a1Var.a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }
}
