package c.b.a.a.c.k.o;

import android.os.Looper;
import android.os.Message;
import c.b.a.a.c.k.f;
import c.b.a.a.c.k.i;
import c.b.a.a.e.a.d;
import com.google.android.gms.common.api.Status;

public final class t0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r0 f2403a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t0(r0 r0Var, Looper looper) {
        super(looper);
        this.f2403a = r0Var;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            f<R> fVar = (f) message.obj;
            synchronized (this.f2403a.f2397e) {
                if (fVar == null) {
                    this.f2403a.f2394b.b(new Status(13, "Transform returned null"));
                } else if (fVar instanceof k0) {
                    k0 k0Var = (k0) fVar;
                    this.f2403a.f2394b.b(null);
                } else {
                    r0<? extends i> r0Var = this.f2403a.f2394b;
                    synchronized (r0Var.f2397e) {
                        r0Var.f2396d = fVar;
                    }
                }
            }
        } else if (i == 1) {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            if (valueOf.length() != 0) {
                "Runtime exception on the transformation worker thread: ".concat(valueOf);
            } else {
                new String("Runtime exception on the transformation worker thread: ");
            }
            throw runtimeException;
        }
    }
}
