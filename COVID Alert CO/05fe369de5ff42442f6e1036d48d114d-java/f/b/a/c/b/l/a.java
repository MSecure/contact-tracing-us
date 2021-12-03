package f.b.a.c.b.l;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.l.a.c;
import f.b.a.c.b.l.l.j;
import f.b.a.c.b.m.b;
import f.b.a.c.b.m.h;
import java.util.Set;

public final class a<O extends c> {
    public final AbstractC0082a<?, O> a;
    public final String b;

    /* renamed from: f.b.a.c.b.l.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0082a<T extends e, O> extends d<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull f.b.a.c.b.m.c cVar, @RecentlyNonNull O o, @RecentlyNonNull d dVar, @RecentlyNonNull e eVar) {
            return b(context, looper, cVar, o, dVar, eVar);
        }

        @RecentlyNonNull
        public T b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull f.b.a.c.b.m.c cVar, @RecentlyNonNull O o, @RecentlyNonNull f.b.a.c.b.l.l.d dVar, @RecentlyNonNull j jVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public static class b<C> {
    }

    public interface c {

        /* renamed from: f.b.a.c.b.l.a$c$a  reason: collision with other inner class name */
        public interface AbstractC0083a extends c {
            @RecentlyNonNull
            Account a();
        }

        public interface b extends c {
            @RecentlyNonNull
            GoogleSignInAccount b();
        }

        /* renamed from: f.b.a.c.b.l.a$c$c  reason: collision with other inner class name */
        public static final class C0084c implements c {
        }
    }

    public static abstract class d<T, O> {
    }

    public interface e {
        void a(@RecentlyNonNull b.e eVar);

        @RecentlyNonNull
        boolean b();

        @RecentlyNonNull
        f.b.a.c.b.c[] c();

        @RecentlyNonNull
        boolean d();

        @RecentlyNonNull
        String e();

        @RecentlyNullable
        String f();

        Set<Scope> g();

        void h(h hVar, Set<Scope> set);

        void i(@RecentlyNonNull b.c cVar);

        void j();

        void k(@RecentlyNonNull String str);

        @RecentlyNonNull
        boolean l();

        @RecentlyNonNull
        boolean o();

        @RecentlyNonNull
        int p();
    }

    public static final class f<C extends e> extends b<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: f.b.a.c.b.l.a$a<C extends f.b.a.c.b.l.a$e, O extends f.b.a.c.b.l.a$c> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends e> a(@RecentlyNonNull String str, @RecentlyNonNull AbstractC0082a<C, O> aVar, @RecentlyNonNull f<C> fVar) {
        m.h.p(aVar, "Cannot construct an Api with a null ClientBuilder");
        m.h.p(fVar, "Cannot construct an Api with a null ClientKey");
        this.b = str;
        this.a = aVar;
    }
}
