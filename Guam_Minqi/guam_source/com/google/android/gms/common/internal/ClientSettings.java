package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class ClientSettings {
    public final Account zaa;
    public final Set<Scope> zab;
    public final Set<Scope> zac;
    public final Map<Api<?>, zaa> zad;
    public final String zag;
    public final String zah;
    public final SignInOptions zai;
    public Integer zak;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static final class Builder {
        public Account zaa;
        public ArraySet<Scope> zab;
        public String zad;
        public String zae;
        public SignInOptions zaf = SignInOptions.zaa;

        @RecentlyNonNull
        public final ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, null, 0, null, this.zad, this.zae, this.zaf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static final class zaa {
        public final Set<Scope> zaa;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/accounts/Account;Ljava/util/Set<Lcom/google/android/gms/common/api/Scope;>;Ljava/util/Map<Lcom/google/android/gms/common/api/Api<*>;Lcom/google/android/gms/common/internal/ClientSettings$zaa;>;ILandroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/signin/SignInOptions;Z)V */
    public ClientSettings(Account account, @RecentlyNonNull Set set, @RecentlyNonNull Map map, @RecentlyNonNull int i, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull SignInOptions signInOptions) {
        this.zaa = account;
        this.zab = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zad = Collections.emptyMap();
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions;
        HashSet hashSet = new HashSet(this.zab);
        for (zaa zaa2 : this.zad.values()) {
            hashSet.addAll(zaa2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
