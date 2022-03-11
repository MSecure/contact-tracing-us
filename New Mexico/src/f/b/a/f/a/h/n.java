package f.b.a.f.a.h;
/* loaded from: classes.dex */
public final class n<ResultT> {
    public final r<ResultT> a = new r<>();

    public final boolean a(Exception exc) {
        r<ResultT> rVar = this.a;
        synchronized (rVar.a) {
            if (rVar.c) {
                return false;
            }
            rVar.c = true;
            rVar.f3372e = exc;
            rVar.b.b(rVar);
            return true;
        }
    }

    public final boolean b(ResultT resultt) {
        r<ResultT> rVar = this.a;
        synchronized (rVar.a) {
            if (rVar.c) {
                return false;
            }
            rVar.c = true;
            rVar.f3371d = resultt;
            rVar.b.b(rVar);
            return true;
        }
    }
}
