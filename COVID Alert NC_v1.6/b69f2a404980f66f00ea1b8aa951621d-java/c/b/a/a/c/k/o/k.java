package c.b.a.a.c.k.o;

import android.os.Looper;
import android.os.Message;
import b.b.k.i;
import c.b.a.a.e.a.d;

public final class k<L> {

    /* renamed from: a  reason: collision with root package name */
    public final c f2375a;

    /* renamed from: b  reason: collision with root package name */
    public volatile L f2376b;

    /* renamed from: c  reason: collision with root package name */
    public volatile a<L> f2377c;

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        public final L f2378a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2379b;

        public a(L l, String str) {
            this.f2378a = l;
            this.f2379b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2378a == aVar.f2378a && this.f2379b.equals(aVar.f2379b);
        }

        public final int hashCode() {
            return this.f2379b.hashCode() + (System.identityHashCode(this.f2378a) * 31);
        }
    }

    public interface b<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    public final class c extends d {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            i.j.i(z);
            b bVar = (b) message.obj;
            L l = k.this.f2376b;
            if (l == null) {
                bVar.onNotifyListenerFailed();
                return;
            }
            try {
                bVar.notifyListener(l);
            } catch (RuntimeException e2) {
                bVar.onNotifyListenerFailed();
                throw e2;
            }
        }
    }

    public k(Looper looper, L l, String str) {
        this.f2375a = new c(looper);
        i.j.t(l, "Listener must not be null");
        this.f2376b = l;
        i.j.n(str);
        this.f2377c = new a<>(l, str);
    }

    public final void a(b<? super L> bVar) {
        i.j.t(bVar, "Notifier must not be null");
        this.f2375a.sendMessage(this.f2375a.obtainMessage(1, bVar));
    }
}
