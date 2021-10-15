package b.s;

import b.w.a.f;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class m {
    public final h mDatabase;
    public final AtomicBoolean mLock = new AtomicBoolean(false);
    public volatile f mStmt;

    public m(h hVar) {
        this.mDatabase = hVar;
    }

    private f createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private f getStmt(boolean z) {
        if (!z) {
            return createNewStatement();
        }
        if (this.mStmt == null) {
            this.mStmt = createNewStatement();
        }
        return this.mStmt;
    }

    public f acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(f fVar) {
        if (fVar == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
