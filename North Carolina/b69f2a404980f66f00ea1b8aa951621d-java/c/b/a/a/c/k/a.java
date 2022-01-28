package c.b.a.a.c.k;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import b.b.k.i;
import c.b.a.a.c.k.a.d;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.l;
import c.b.a.a.c.l.b;
import c.b.a.a.c.l.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0055a<?, O> f2301a;

    /* renamed from: b  reason: collision with root package name */
    public final g<?> f2302b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2303c;

    /* renamed from: c.b.a.a.c.k.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0055a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T buildClient(Context context, Looper looper, c.b.a.a.c.l.c cVar, O o, e.a aVar, e.b bVar) {
            return buildClient(context, looper, cVar, (Object) o, (c.b.a.a.c.k.o.f) aVar, (l) bVar);
        }

        public T buildClient(Context context, Looper looper, c.b.a.a.c.l.c cVar, O o, c.b.a.a.c.k.o.f fVar, l lVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: c.b.a.a.c.k.a$d$a  reason: collision with other inner class name */
        public interface AbstractC0056a extends d {
            Account b();
        }

        public interface b extends d {
            GoogleSignInAccount a();
        }

        public static final class c implements d {
        }
    }

    public static abstract class e<T extends b, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface f extends b {
        void connect(b.c cVar);

        void disconnect();

        c.b.a.a.c.c[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(j jVar, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(b.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g<C extends f> extends c<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: c.b.a.a.c.k.a$a<C extends c.b.a.a.c.k.a$f, O extends c.b.a.a.c.k.a$d> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.b.a.a.c.k.a$g<C extends c.b.a.a.c.k.a$f> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0055a<C, O> aVar, g<C> gVar) {
        i.j.t(aVar, "Cannot construct an Api with a null ClientBuilder");
        i.j.t(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2303c = str;
        this.f2301a = aVar;
        this.f2302b = gVar;
    }
}
