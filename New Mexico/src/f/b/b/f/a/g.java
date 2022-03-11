package f.b.b.f.a;

import f.b.b.b.b;
import f.b.b.b.k;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class g<InputT, OutputT> extends h<OutputT> {
    public static final Logger p = Logger.getLogger(g.class.getName());
    public b<? extends u<? extends InputT>> m;
    public final boolean n;
    public final boolean o;

    /* loaded from: classes.dex */
    public enum a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public g(b<? extends u<? extends InputT>> bVar, boolean z, boolean z2) {
        super(bVar.size());
        this.m = bVar;
        this.n = z;
        this.o = z2;
    }

    public static void D(g gVar, b bVar) {
        Objects.requireNonNull(gVar);
        int b = h.f3453k.b(gVar);
        int i2 = 0;
        f.b.a.c.b.o.b.G(b >= 0, "Less than 0 remaining futures");
        if (b == 0) {
            if (bVar != null) {
                k n = bVar.iterator();
                while (n.hasNext()) {
                    Future<? extends InputT> future = (Future) n.next();
                    if (!future.isCancelled()) {
                        gVar.G(i2, future);
                    }
                    i2++;
                }
            }
            gVar.B();
            gVar.H();
            gVar.J(a.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    public static boolean E(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // f.b.b.f.a.h
    public final void A(Set<Throwable> set) {
        Objects.requireNonNull(set);
        if (!isCancelled()) {
            E(set, b());
        }
    }

    public abstract void F(int i2, InputT inputt);

    /* JADX WARN: Multi-variable type inference failed */
    public final void G(int i2, Future<? extends InputT> future) {
        Throwable th;
        try {
            F(i2, f.b.a.c.b.o.b.D0(future));
        } catch (ExecutionException e2) {
            th = e2.getCause();
            I(th);
        } catch (Throwable th2) {
            th = th2;
            I(th);
        }
    }

    public abstract void H();

    public final void I(Throwable th) {
        Objects.requireNonNull(th);
        String str = "Input Future failed with Error";
        if (!this.n || u(th) || !E(C(), th)) {
            boolean z = th instanceof Error;
            if (z) {
                if (!z) {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                p.log(Level.SEVERE, str, th);
                return;
            }
            return;
        }
        if (!(th instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        }
        p.log(Level.SEVERE, str, th);
    }

    public void J(a aVar) {
        Objects.requireNonNull(aVar);
        this.m = null;
    }

    @Override // f.b.b.f.a.b
    public final void j() {
        b<? extends u<? extends InputT>> bVar = this.m;
        J(a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (bVar != null)) {
            boolean w = w();
            k<? extends u<? extends InputT>> n = bVar.iterator();
            while (n.hasNext()) {
                ((Future) n.next()).cancel(w);
            }
        }
    }

    @Override // f.b.b.f.a.b
    public final String r() {
        b<? extends u<? extends InputT>> bVar = this.m;
        if (bVar == null) {
            return super.r();
        }
        return "futures=" + bVar;
    }
}
