package f.b.c.k.t;

import android.database.Cursor;
import f.b.a.c.b.o.b;
import f.b.c.k.u.f;
import f.b.c.k.x.g;

public final /* synthetic */ class m0 implements g {
    public final n0 a;
    public final int[] b;

    public m0(n0 n0Var, int[] iArr) {
        this.a = n0Var;
        this.b = iArr;
    }

    @Override // f.b.c.k.x.g
    public void a(Object obj) {
        boolean z;
        n0 n0Var = this.a;
        int[] iArr = this.b;
        f fVar = new f(b.b0(((Cursor) obj).getString(0)));
        if (n0Var.f3285e.c(fVar)) {
            z = true;
        } else {
            Cursor cursor = null;
            try {
                cursor = n0Var.a.f3301i.rawQueryWithFactory(new s0(new Object[]{b.l0(fVar.b)}), "SELECT 1 FROM document_mutations WHERE path = ?", null, null);
                boolean z2 = !cursor.moveToFirst();
                cursor.close();
                z = !z2;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        if (!z) {
            iArr[0] = iArr[0] + 1;
            n0Var.a.f3298f.c(fVar);
            n0Var.a.f3301i.execSQL("DELETE FROM target_documents WHERE path = ? AND target_id = 0", new Object[]{b.l0(fVar.b)});
        }
    }
}
