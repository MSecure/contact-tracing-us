package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    public static Clock zaa = DefaultClock.zza;
    public final int zab;
    public String zac;
    public String zad;
    public String zae;
    public String zaf;
    public Uri zag;
    public String zah;
    public long zai;
    public String zaj;
    public List<Scope> zak;
    public String zal;
    public String zam;
    public Set<Scope> zan = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.zab = i;
        this.zac = str;
        this.zad = str2;
        this.zae = str3;
        this.zaf = str4;
        this.zag = uri;
        this.zah = str5;
        this.zai = j;
        this.zaj = str6;
        this.zak = list;
        this.zal = str7;
        this.zam = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount zaa(String str) throws JSONException {
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
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
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
        ReactYogaConfigProvider.checkNotEmpty(string);
        ReactYogaConfigProvider.checkNotNull(hashSet);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.zah = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
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
        if (googleSignInAccount.zaj.equals(this.zaj)) {
            if (((AbstractSet) googleSignInAccount.getRequestedScopes()).equals(getRequestedScopes())) {
                return true;
            }
        }
        return false;
    }

    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zak);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    @RecentlyNonNull
    public int hashCode() {
        return ((AbstractSet) getRequestedScopes()).hashCode() + ((this.zaj.hashCode() + 527) * 31);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zab);
        ReactYogaConfigProvider.writeString(parcel, 2, this.zac, false);
        ReactYogaConfigProvider.writeString(parcel, 3, this.zad, false);
        ReactYogaConfigProvider.writeString(parcel, 4, this.zae, false);
        ReactYogaConfigProvider.writeString(parcel, 5, this.zaf, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 6, this.zag, i, false);
        ReactYogaConfigProvider.writeString(parcel, 7, this.zah, false);
        ReactYogaConfigProvider.writeLong(parcel, 8, this.zai);
        ReactYogaConfigProvider.writeString(parcel, 9, this.zaj, false);
        ReactYogaConfigProvider.writeTypedList(parcel, 10, this.zak, false);
        ReactYogaConfigProvider.writeString(parcel, 11, this.zal, false);
        ReactYogaConfigProvider.writeString(parcel, 12, this.zam, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
