package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.a.a.a.b;
import f.b.a.c.b.m.n.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public final int b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f415d;

    /* renamed from: e  reason: collision with root package name */
    public String f416e;

    /* renamed from: f  reason: collision with root package name */
    public String f417f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f418g;

    /* renamed from: h  reason: collision with root package name */
    public String f419h;

    /* renamed from: i  reason: collision with root package name */
    public long f420i;

    /* renamed from: j  reason: collision with root package name */
    public String f421j;

    /* renamed from: k  reason: collision with root package name */
    public List<Scope> f422k;

    /* renamed from: l  reason: collision with root package name */
    public String f423l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.b = i2;
        this.c = str;
        this.f415d = str2;
        this.f416e = str3;
        this.f417f = str4;
        this.f418g = uri;
        this.f419h = str5;
        this.f420i = j2;
        this.f421j = str6;
        this.f422k = list;
        this.f423l = str7;
        this.m = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount g(String str) {
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
        m.h.m(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.f419h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public Set<Scope> d() {
        HashSet hashSet = new HashSet(this.f422k);
        hashSet.addAll(this.n);
        return hashSet;
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
        return googleSignInAccount.f421j.equals(this.f421j) && googleSignInAccount.d().equals(d());
    }

    @RecentlyNonNull
    public int hashCode() {
        return d().hashCode() + ((this.f421j.hashCode() + 527) * 31);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.F1(parcel, 2, this.c, false);
        m.h.F1(parcel, 3, this.f415d, false);
        m.h.F1(parcel, 4, this.f416e, false);
        m.h.F1(parcel, 5, this.f417f, false);
        m.h.E1(parcel, 6, this.f418g, i2, false);
        m.h.F1(parcel, 7, this.f419h, false);
        long j2 = this.f420i;
        m.h.M1(parcel, 8, 8);
        parcel.writeLong(j2);
        m.h.F1(parcel, 9, this.f421j, false);
        m.h.H1(parcel, 10, this.f422k, false);
        m.h.F1(parcel, 11, this.f423l, false);
        m.h.F1(parcel, 12, this.m, false);
        m.h.N1(parcel, I1);
    }
}
