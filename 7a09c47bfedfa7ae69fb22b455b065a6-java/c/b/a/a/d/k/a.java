package c.b.a.a.d.k;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.d.k.a.d;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.l;
import c.b.a.a.d.m.b;
import c.b.a.a.d.m.h;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0062a<?, O> f2938a;

    /* renamed from: b  reason: collision with root package name */
    public final g<?> f2939b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2940c;

    /* renamed from: c.b.a.a.d.k.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0062a<T extends f, O> extends e<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull c.b.a.a.d.m.c cVar, @RecentlyNonNull O o, @RecentlyNonNull e.a aVar, @RecentlyNonNull e.b bVar) {
            return buildClient(context, looper, cVar, (Object) o, (c.b.a.a.d.k.o.f) aVar, (l) bVar);
        }

        @RecentlyNonNull
        public T buildClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull c.b.a.a.d.m.c cVar, @RecentlyNonNull O o, @RecentlyNonNull c.b.a.a.d.k.o.f fVar, @RecentlyNonNull l lVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: c.b.a.a.d.k.a$d$a  reason: collision with other inner class name */
        public interface AbstractC0063a extends d {
            @RecentlyNonNull
            Account a();
        }

        public interface b extends d {
            @RecentlyNonNull
            GoogleSignInAccount b();
        }

        public static final class c implements d {
        }
    }

    public static abstract class e<T extends b, O> {
        @RecentlyNonNull
        public static final int API_PRIORITY_GAMES = 1;
        @RecentlyNonNull
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        @RecentlyNonNull
        public static final int API_PRIORITY_PLUS = 2;

        @RecentlyNonNull
        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }

        @RecentlyNonNull
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface f extends b {
        void connect(@RecentlyNonNull b.c cVar);

        void disconnect();

        void disconnect(@RecentlyNonNull String str);

        @RecentlyNonNull
        c.b.a.a.d.c[] getAvailableFeatures();

        @RecentlyNonNull
        String getEndpointPackageName();

        @RecentlyNullable
        String getLastDisconnectMessage();

        @RecentlyNonNull
        int getMinApkVersion();

        void getRemoteService(h hVar, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        @RecentlyNonNull
        boolean isConnected();

        @RecentlyNonNull
        boolean isConnecting();

        void onUserSignOut(@RecentlyNonNull b.e eVar);

        @RecentlyNonNull
        boolean requiresGooglePlayServices();

        @RecentlyNonNull
        boolean requiresSignIn();
    }

    public static final class g<C extends f> extends c<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: c.b.a.a.d.k.a$a<C extends c.b.a.a.d.k.a$f, O extends c.b.a.a.d.k.a$d> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: c.b.a.a.d.k.a$g<C extends c.b.a.a.d.k.a$f> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(@RecentlyNonNull String str, @RecentlyNonNull AbstractC0062a<C, O> aVar, @RecentlyNonNull g<C> gVar) {
        t.D(aVar, "Cannot construct an Api with a null ClientBuilder");
        t.D(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2940c = str;
        this.f2938a = aVar;
        this.f2939b = gVar;
    }
}
