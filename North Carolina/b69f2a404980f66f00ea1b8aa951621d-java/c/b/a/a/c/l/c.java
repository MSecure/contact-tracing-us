package c.b.a.a.c.l;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Account f2431a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Scope> f2432b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Scope> f2433c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c.b.a.a.c.k.a<?>, b> f2434d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2435e;
    public final String f;
    public final c.b.a.a.f.a g;
    public Integer h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Account f2436a;

        /* renamed from: b  reason: collision with root package name */
        public b.e.c<Scope> f2437b;

        /* renamed from: c  reason: collision with root package name */
        public int f2438c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f2439d;

        /* renamed from: e  reason: collision with root package name */
        public String f2440e;
        public c.b.a.a.f.a f = c.b.a.a.f.a.j;

        public final c a() {
            return new c(this.f2436a, this.f2437b, null, this.f2438c, null, this.f2439d, this.f2440e, this.f, false);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f2441a;
    }

    public c(Account account, Set<Scope> set, Map<c.b.a.a.c.k.a<?>, b> map, int i, View view, String str, String str2, c.b.a.a.f.a aVar, boolean z) {
        this.f2431a = account;
        this.f2432b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f2434d = Collections.emptyMap();
        this.f2435e = str;
        this.f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(this.f2432b);
        for (b bVar : this.f2434d.values()) {
            hashSet.addAll(bVar.f2441a);
        }
        this.f2433c = Collections.unmodifiableSet(hashSet);
    }
}
