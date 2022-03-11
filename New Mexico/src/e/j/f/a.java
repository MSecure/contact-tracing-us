package e.j.f;

import android.os.CancellationSignal;
/* loaded from: classes.dex */
public final class a {
    public boolean a;
    public AbstractC0038a b;
    public Object c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1590d;

    /* renamed from: e.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0038a {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (!this.a) {
                    this.a = true;
                    this.f1590d = true;
                    AbstractC0038a aVar = this.b;
                    Object obj = this.c;
                    if (aVar != null) {
                        try {
                            aVar.a();
                        } catch (Throwable th) {
                            synchronized (this) {
                                try {
                                    this.f1590d = false;
                                    notifyAll();
                                    throw th;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    }
                    if (obj != null) {
                        ((CancellationSignal) obj).cancel();
                    }
                    synchronized (this) {
                        try {
                            this.f1590d = false;
                            notifyAll();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public void b(AbstractC0038a aVar) {
        synchronized (this) {
            while (this.f1590d) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.b != aVar) {
                this.b = aVar;
                if (this.a) {
                    aVar.a();
                }
            }
        }
    }
}
