package c.b.a.a.d.m;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Account f3086a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Scope> f3087b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Scope> f3088c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c.b.a.a.d.k.a<?>, b> f3089d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3090e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3091f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.a.a.i.a f3092g;
    public Integer h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Account f3093a;

        /* renamed from: b  reason: collision with root package name */
        public b.e.c<Scope> f3094b;

        /* renamed from: c  reason: collision with root package name */
        public String f3095c;

        /* renamed from: d  reason: collision with root package name */
        public String f3096d;

        /* renamed from: e  reason: collision with root package name */
        public c.b.a.a.i.a f3097e = c.b.a.a.i.a.f4082a;

        @RecentlyNonNull
        public final c a() {
            return new c(this.f3093a, this.f3094b, null, 0, null, this.f3095c, this.f3096d, this.f3097e);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f3098a;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/accounts/Account;Ljava/util/Set<Lcom/google/android/gms/common/api/Scope;>;Ljava/util/Map<Lc/b/a/a/d/k/a<*>;Lc/b/a/a/d/m/c$b;>;ILandroid/view/View;Ljava/lang/String;Ljava/lang/String;Lc/b/a/a/i/a;Z)V */
    public c(Account account, @RecentlyNonNull Set set, @RecentlyNonNull Map map, @RecentlyNonNull int i, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull c.b.a.a.i.a aVar) {
        this.f3086a = account;
        this.f3087b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f3089d = Collections.emptyMap();
        this.f3090e = str;
        this.f3091f = str2;
        this.f3092g = aVar;
        HashSet hashSet = new HashSet(this.f3087b);
        for (b bVar : this.f3089d.values()) {
            hashSet.addAll(bVar.f3098a);
        }
        this.f3088c = Collections.unmodifiableSet(hashSet);
    }
}
