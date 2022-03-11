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
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public final int b;
    public String c;

    /* renamed from: d */
    public String f449d;

    /* renamed from: e */
    public String f450e;

    /* renamed from: f */
    public String f451f;

    /* renamed from: g */
    public Uri f452g;

    /* renamed from: h */
    public String f453h;

    /* renamed from: i */
    public long f454i;

    /* renamed from: j */
    public String f455j;

    /* renamed from: k */
    public List<Scope> f456k;

    /* renamed from: l */
    public String f457l;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.b = i2;
        this.c = str;
        this.f449d = str2;
        this.f450e = str3;
        this.f451f = str4;
        this.f452g = uri;
        this.f453h = str5;
        this.f454i = j2;
        this.f455j = str6;
        this.f456k = list;
        this.f457l = str7;
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
        m.e.o(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.f453h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public Set<Scope> d() {
        HashSet hashSet = new HashSet(this.f456k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    @Override // java.lang.Object
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
        return googleSignInAccount.f455j.equals(this.f455j) && googleSignInAccount.d().equals(d());
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public int hashCode() {
        return d().hashCode() + ((this.f455j.hashCode() + 527) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.g2(parcel, 2, this.c, false);
        m.e.g2(parcel, 3, this.f449d, false);
        m.e.g2(parcel, 4, this.f450e, false);
        m.e.g2(parcel, 5, this.f451f, false);
        m.e.f2(parcel, 6, this.f452g, i2, false);
        m.e.g2(parcel, 7, this.f453h, false);
        long j3 = this.f454i;
        m.e.n2(parcel, 8, 8);
        parcel.writeLong(j3);
        m.e.g2(parcel, 9, this.f455j, false);
        m.e.i2(parcel, 10, this.f456k, false);
        m.e.g2(parcel, 11, this.f457l, false);
        m.e.g2(parcel, 12, this.m, false);
        m.e.o2(parcel, j2);
    }
}
