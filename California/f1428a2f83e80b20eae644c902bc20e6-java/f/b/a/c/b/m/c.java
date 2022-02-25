package f.b.a.c.b.m;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class c {
    public final Account a;
    public final Set<Scope> b;
    public final Set<Scope> c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<f.b.a.c.b.l.a<?>, b> f2448d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2449e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2450f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.c.h.a f2451g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f2452h;

    public static final class a {
        public Account a;
        public e.e.c<Scope> b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f2453d;

        @RecentlyNonNull
        public final c a() {
            return new c(this.a, this.b, null, 0, null, this.c, this.f2453d, f.b.a.c.h.a.a);
        }
    }

    public static final class b {
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/accounts/Account;Ljava/util/Set<Lcom/google/android/gms/common/api/Scope;>;Ljava/util/Map<Lf/b/a/c/b/l/a<*>;Lf/b/a/c/b/m/c$b;>;ILandroid/view/View;Ljava/lang/String;Ljava/lang/String;Lf/b/a/c/h/a;Z)V */
    public c(Account account, @RecentlyNonNull Set set, @RecentlyNonNull Map map, @RecentlyNonNull int i2, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull f.b.a.c.h.a aVar) {
        this.a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = emptySet;
        Map<f.b.a.c.b.l.a<?>, b> emptyMap = Collections.emptyMap();
        this.f2448d = emptyMap;
        this.f2449e = str;
        this.f2450f = str2;
        this.f2451g = aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (b bVar : emptyMap.values()) {
            Objects.requireNonNull(bVar);
            hashSet.addAll(null);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }
}
