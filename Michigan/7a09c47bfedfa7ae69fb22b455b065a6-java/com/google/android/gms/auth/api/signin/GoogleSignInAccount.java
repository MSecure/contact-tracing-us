package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.a.a.a.b;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public static c.b.a.a.d.o.a o = c.b.a.a.d.o.b.f3172a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5970b;

    /* renamed from: c  reason: collision with root package name */
    public String f5971c;

    /* renamed from: d  reason: collision with root package name */
    public String f5972d;

    /* renamed from: e  reason: collision with root package name */
    public String f5973e;

    /* renamed from: f  reason: collision with root package name */
    public String f5974f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f5975g;
    public String h;
    public long i;
    public String j;
    public List<Scope> k;
    public String l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f5970b = i2;
        this.f5971c = str;
        this.f5972d = str2;
        this.f5973e = str3;
        this.f5974f = str4;
        this.f5975g = uri;
        this.h = str5;
        this.i = j2;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        long longValue = valueOf.longValue();
        t.z(string);
        t.C(hashSet);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.j.equals(this.j)) {
            if (((AbstractSet) googleSignInAccount.t()).equals(t())) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    public int hashCode() {
        return ((AbstractSet) t()).hashCode() + ((this.j.hashCode() + 527) * 31);
    }

    public Set<Scope> t() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int m2 = t.m(parcel);
        t.q3(parcel, 1, this.f5970b);
        t.w3(parcel, 2, this.f5971c, false);
        t.w3(parcel, 3, this.f5972d, false);
        t.w3(parcel, 4, this.f5973e, false);
        t.w3(parcel, 5, this.f5974f, false);
        t.v3(parcel, 6, this.f5975g, i2, false);
        t.w3(parcel, 7, this.h, false);
        t.t3(parcel, 8, this.i);
        t.w3(parcel, 9, this.j, false);
        t.z3(parcel, 10, this.k, false);
        t.w3(parcel, 11, this.l, false);
        t.w3(parcel, 12, this.m, false);
        t.w4(parcel, m2);
    }
}
