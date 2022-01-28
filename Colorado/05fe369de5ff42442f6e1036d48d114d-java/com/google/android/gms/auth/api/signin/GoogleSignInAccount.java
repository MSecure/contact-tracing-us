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
    public String f443d;

    /* renamed from: e  reason: collision with root package name */
    public String f444e;

    /* renamed from: f  reason: collision with root package name */
    public String f445f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f446g;

    /* renamed from: h  reason: collision with root package name */
    public String f447h;

    /* renamed from: i  reason: collision with root package name */
    public long f448i;

    /* renamed from: j  reason: collision with root package name */
    public String f449j;

    /* renamed from: k  reason: collision with root package name */
    public List<Scope> f450k;

    /* renamed from: l  reason: collision with root package name */
    public String f451l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.b = i2;
        this.c = str;
        this.f443d = str2;
        this.f444e = str3;
        this.f445f = str4;
        this.f446g = uri;
        this.f447h = str5;
        this.f448i = j2;
        this.f449j = str6;
        this.f450k = list;
        this.f451l = str7;
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
        googleSignInAccount.f447h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public Set<Scope> d() {
        HashSet hashSet = new HashSet(this.f450k);
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
        return googleSignInAccount.f449j.equals(this.f449j) && googleSignInAccount.d().equals(d());
    }

    @RecentlyNonNull
    public int hashCode() {
        return d().hashCode() + ((this.f449j.hashCode() + 527) * 31);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int O1 = m.h.O1(parcel, 20293);
        int i3 = this.b;
        m.h.S1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.L1(parcel, 2, this.c, false);
        m.h.L1(parcel, 3, this.f443d, false);
        m.h.L1(parcel, 4, this.f444e, false);
        m.h.L1(parcel, 5, this.f445f, false);
        m.h.K1(parcel, 6, this.f446g, i2, false);
        m.h.L1(parcel, 7, this.f447h, false);
        long j2 = this.f448i;
        m.h.S1(parcel, 8, 8);
        parcel.writeLong(j2);
        m.h.L1(parcel, 9, this.f449j, false);
        m.h.N1(parcel, 10, this.f450k, false);
        m.h.L1(parcel, 11, this.f451l, false);
        m.h.L1(parcel, 12, this.m, false);
        m.h.T1(parcel, O1);
    }
}
