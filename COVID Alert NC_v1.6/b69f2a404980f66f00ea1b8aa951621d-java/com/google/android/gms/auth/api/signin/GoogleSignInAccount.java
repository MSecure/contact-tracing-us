package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.b.k.i;
import c.b.a.a.a.a.a.b;
import c.b.a.a.c.l.s.a;
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
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public static c.b.a.a.c.n.a o = c.b.a.a.c.n.b.f2492a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4424b;

    /* renamed from: c  reason: collision with root package name */
    public String f4425c;

    /* renamed from: d  reason: collision with root package name */
    public String f4426d;

    /* renamed from: e  reason: collision with root package name */
    public String f4427e;
    public String f;
    public Uri g;
    public String h;
    public long i;
    public String j;
    public List<Scope> k;
    public String l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f4424b = i2;
        this.f4425c = str;
        this.f4426d = str2;
        this.f4427e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j2;
        this.j = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString("email", null);
        String optString5 = jSONObject.optString("displayName", null);
        String optString6 = jSONObject.optString("givenName", null);
        String optString7 = jSONObject.optString("familyName", null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        long longValue = valueOf.longValue();
        i.j.n(string);
        i.j.s(hashSet);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.h = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.j.equals(this.j)) {
            if (((AbstractSet) googleSignInAccount.p()).equals(p())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((AbstractSet) p()).hashCode() + ((this.j.hashCode() + 527) * 31);
    }

    public Set<Scope> p() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f4424b);
        i.j.z1(parcel, 2, this.f4425c, false);
        i.j.z1(parcel, 3, this.f4426d, false);
        i.j.z1(parcel, 4, this.f4427e, false);
        i.j.z1(parcel, 5, this.f, false);
        i.j.y1(parcel, 6, this.g, i2, false);
        i.j.z1(parcel, 7, this.h, false);
        i.j.x1(parcel, 8, this.i);
        i.j.z1(parcel, 9, this.j, false);
        i.j.B1(parcel, 10, this.k, false);
        i.j.z1(parcel, 11, this.l, false);
        i.j.z1(parcel, 12, this.m, false);
        i.j.F1(parcel, e2);
    }
}
