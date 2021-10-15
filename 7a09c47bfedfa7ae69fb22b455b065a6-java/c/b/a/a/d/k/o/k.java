package c.b.a.a.d.k.o;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.g.a.d;

public final class k<L> {

    /* renamed from: a  reason: collision with root package name */
    public final c f3018a;

    /* renamed from: b  reason: collision with root package name */
    public volatile L f3019b;

    /* renamed from: c  reason: collision with root package name */
    public volatile a<L> f3020c;

    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        public final L f3021a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3022b;

        public a(L l, String str) {
            this.f3021a = l;
            this.f3022b = str;
        }

        @RecentlyNonNull
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3021a == aVar.f3021a && this.f3022b.equals(aVar.f3022b);
        }

        @RecentlyNonNull
        public final int hashCode() {
            return this.f3022b.hashCode() + (System.identityHashCode(this.f3021a) * 31);
        }
    }

    public interface b<L> {
        void notifyListener(@RecentlyNonNull L l);

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
            t.q(z);
            b bVar = (b) message.obj;
            L l = k.this.f3019b;
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
        this.f3018a = new c(looper);
        t.D(l, "Listener must not be null");
        this.f3019b = l;
        t.z(str);
        this.f3020c = new a<>(l, str);
    }

    public final void a(@RecentlyNonNull b<? super L> bVar) {
        t.D(bVar, "Notifier must not be null");
        this.f3018a.sendMessage(this.f3018a.obtainMessage(1, bVar));
    }
}
