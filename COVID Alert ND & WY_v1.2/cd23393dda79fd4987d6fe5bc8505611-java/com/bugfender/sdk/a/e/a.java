package com.bugfender.sdk.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bugfender.android.BuildConfig;
import com.bugfender.sdk.a.a.j.b;
import com.bugfender.sdk.a.c.d;
import com.bugfender.sdk.a.c.e;
import com.bugfender.sdk.a.c.f;
import com.bugfender.sdk.a.c.g;

public class a {
    public b a(Context context, com.bugfender.sdk.a.a.c.e.b bVar, com.bugfender.sdk.a.a.c.e.a aVar, com.bugfender.sdk.a.a.c.f.b bVar2, com.bugfender.sdk.a.a.c.f.a aVar2, com.bugfender.sdk.a.a.c.d.b bVar3, com.bugfender.sdk.a.a.c.d.a aVar3) {
        return new com.bugfender.sdk.a.d.a(context, bVar2, aVar2, bVar, aVar, bVar3, aVar3);
    }

    public com.bugfender.sdk.a.a.c.e.b b() {
        return new com.bugfender.sdk.a.a.c.e.b();
    }

    public com.bugfender.sdk.a.a.e.h.a c(Context context) {
        return new f(context);
    }

    public com.bugfender.sdk.a.a.c.f.b d() {
        return new com.bugfender.sdk.a.a.c.f.b();
    }

    public com.bugfender.sdk.a.a.c.f.a a(com.bugfender.sdk.a.a.c.f.b bVar) {
        return new com.bugfender.sdk.a.a.c.f.a(bVar);
    }

    public com.bugfender.sdk.a.c.i.a b(Context context) {
        return new com.bugfender.sdk.a.c.i.a(context);
    }

    public d c() {
        return new e();
    }

    public SharedPreferences d(Context context) {
        return context.getSharedPreferences("bugfender.preferences", 0);
    }

    public com.bugfender.sdk.a.a.c.e.a a(com.bugfender.sdk.a.a.c.e.b bVar) {
        return new com.bugfender.sdk.a.a.c.e.a(bVar);
    }

    public com.bugfender.sdk.a.a.c.d.b a() {
        return new com.bugfender.sdk.a.a.c.d.b();
    }

    public com.bugfender.sdk.a.a.c.d.a a(com.bugfender.sdk.a.a.c.d.b bVar) {
        return new com.bugfender.sdk.a.a.c.d.a(bVar);
    }

    public com.bugfender.sdk.a.a.e.f.a a(Context context, com.bugfender.sdk.a.c.i.a aVar, SharedPreferences sharedPreferences) {
        return new g(context, aVar, sharedPreferences);
    }

    public com.bugfender.sdk.a.a.g.a<String> a(Context context) {
        return new com.bugfender.sdk.a.a.g.b(context);
    }

    public com.bugfender.sdk.a.c.j.a a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = BuildConfig.BUGFENDER_BASE_URL;
        }
        return new com.bugfender.sdk.a.c.j.a(str, str2);
    }
}
