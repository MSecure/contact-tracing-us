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
/* loaded from: classes.dex */
public final class c {
    public final Account a;
    public final Set<Scope> b;
    public final Set<Scope> c;

    /* renamed from: d */
    public final Map<f.b.a.c.b.l.a<?>, b> f2720d;

    /* renamed from: e */
    public final String f2721e;

    /* renamed from: f */
    public final String f2722f;

    /* renamed from: g */
    public final f.b.a.c.h.a f2723g;

    /* renamed from: h */
    public Integer f2724h;

    /* loaded from: classes.dex */
    public static final class a {
        public Account a;
        public e.f.c<Scope> b;
        public String c;

        /* renamed from: d */
        public String f2725d;

        @RecentlyNonNull
        public final c a() {
            return new c(this.a, this.b, null, 0, null, this.c, this.f2725d, f.b.a.c.h.a.a);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
    }

    public c(Account account, @RecentlyNonNull Set set, @RecentlyNonNull Map map, @RecentlyNonNull int i2, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull f.b.a.c.h.a aVar) {
        this.a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = emptySet;
        Map<f.b.a.c.b.l.a<?>, b> emptyMap = Collections.emptyMap();
        this.f2720d = emptyMap;
        this.f2721e = str;
        this.f2722f = str2;
        this.f2723g = aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (b bVar : emptyMap.values()) {
            Objects.requireNonNull(bVar);
            hashSet.addAll(null);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }
}
