package c.b.a.a.j;

import java.util.concurrent.Executor;

public final class x<TResult, TContinuationResult> implements c, e, f<TContinuationResult>, z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f4146a;

    /* renamed from: b  reason: collision with root package name */
    public final h<TResult, TContinuationResult> f4147b;

    /* renamed from: c  reason: collision with root package name */
    public final b0<TContinuationResult> f4148c;

    public x(Executor executor, h<TResult, TContinuationResult> hVar, b0<TContinuationResult> b0Var) {
        this.f4146a = executor;
        this.f4147b = hVar;
        this.f4148c = b0Var;
    }

    @Override // c.b.a.a.j.z
    public final void a(i<TResult> iVar) {
        this.f4146a.execute(new w(this, iVar));
    }

    @Override // c.b.a.a.j.c
    public final void b() {
        this.f4148c.j();
    }

    @Override // c.b.a.a.j.e
    public final void c(Exception exc) {
        this.f4148c.h(exc);
    }

    @Override // c.b.a.a.j.f
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f4148c.i(tcontinuationresult);
    }
}
