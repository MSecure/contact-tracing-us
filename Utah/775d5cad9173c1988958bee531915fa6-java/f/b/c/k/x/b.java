package f.b.c.k.x;

public final /* synthetic */ class b implements Runnable {
    public final Throwable b;

    public b(Throwable th) {
        this.b = th;
    }

    public void run() {
        Throwable th = this.b;
        if (th instanceof OutOfMemoryError) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (21.6.0) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
            outOfMemoryError.initCause(th);
            throw outOfMemoryError;
        }
        throw new RuntimeException("Internal error in Cloud Firestore (21.6.0).", th);
    }
}
