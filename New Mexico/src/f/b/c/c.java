package f.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R$string;
import e.b.a.m;
import f.b.a.c.b.m.l;
import f.b.a.c.b.o.e;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3469d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3470e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3471f;

    /* renamed from: g  reason: collision with root package name */
    public final String f3472g;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i2 = e.a;
        m.e.t(true ^ (str == null || str.trim().isEmpty()), "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.f3469d = str4;
        this.f3470e = str5;
        this.f3471f = str6;
        this.f3472g = str7;
    }

    public static c a(Context context) {
        Objects.requireNonNull(context, "null reference");
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        String str = null;
        String string = identifier == 0 ? null : resources.getString(identifier);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int identifier2 = resources.getIdentifier("google_api_key", "string", resourcePackageName);
        String string2 = identifier2 == 0 ? null : resources.getString(identifier2);
        int identifier3 = resources.getIdentifier("firebase_database_url", "string", resourcePackageName);
        String string3 = identifier3 == 0 ? null : resources.getString(identifier3);
        int identifier4 = resources.getIdentifier("ga_trackingId", "string", resourcePackageName);
        String string4 = identifier4 == 0 ? null : resources.getString(identifier4);
        int identifier5 = resources.getIdentifier("gcm_defaultSenderId", "string", resourcePackageName);
        String string5 = identifier5 == 0 ? null : resources.getString(identifier5);
        int identifier6 = resources.getIdentifier("google_storage_bucket", "string", resourcePackageName);
        String string6 = identifier6 == 0 ? null : resources.getString(identifier6);
        int identifier7 = resources.getIdentifier("project_id", "string", resourcePackageName);
        if (identifier7 != 0) {
            str = resources.getString(identifier7);
        }
        return new c(string, string2, string3, string4, string5, string6, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return m.e.X(this.b, cVar.b) && m.e.X(this.a, cVar.a) && m.e.X(this.c, cVar.c) && m.e.X(this.f3469d, cVar.f3469d) && m.e.X(this.f3470e, cVar.f3470e) && m.e.X(this.f3471f, cVar.f3471f) && m.e.X(this.f3472g, cVar.f3472g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.a, this.c, this.f3469d, this.f3470e, this.f3471f, this.f3472g});
    }

    public String toString() {
        l lVar = new l(this, null);
        lVar.a("applicationId", this.b);
        lVar.a("apiKey", this.a);
        lVar.a("databaseUrl", this.c);
        lVar.a("gcmSenderId", this.f3470e);
        lVar.a("storageBucket", this.f3471f);
        lVar.a("projectId", this.f3472g);
        return lVar.toString();
    }
}
