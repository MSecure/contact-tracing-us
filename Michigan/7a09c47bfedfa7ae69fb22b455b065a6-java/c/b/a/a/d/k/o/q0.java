package c.b.a.a.d.k.o;

import android.os.Looper;
import android.os.Message;
import b.x.t;
import c.b.a.a.d.k.f;
import c.b.a.a.d.k.i;
import c.b.a.a.g.a.d;
import com.google.android.gms.common.api.Status;

public final class q0 extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f3042a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(p0 p0Var, Looper looper) {
        super(looper);
        this.f3042a = p0Var;
    }

    public final void handleMessage(Message message) {
        Status status;
        int i = message.what;
        if (i == 0) {
            f<R> fVar = (f) message.obj;
            synchronized (this.f3042a.f3039e) {
                p0<? extends i> p0Var = this.f3042a.f3036b;
                t.C(p0Var);
                if (fVar == null) {
                    status = new Status(13, "Transform returned null");
                } else if (fVar instanceof f0) {
                    f0 f0Var = (f0) fVar;
                    status = null;
                } else {
                    synchronized (p0Var.f3039e) {
                        p0Var.f3038d = fVar;
                        p0Var.e();
                    }
                }
                p0Var.c(status);
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
