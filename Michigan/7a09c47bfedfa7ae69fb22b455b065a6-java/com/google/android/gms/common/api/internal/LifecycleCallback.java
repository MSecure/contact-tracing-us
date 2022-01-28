package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.k.o.i;
import c.b.a.a.d.k.o.j;

public class LifecycleCallback {
    @RecentlyNonNull

    /* renamed from: b  reason: collision with root package name */
    public final j f5986b;

    public LifecycleCallback(@RecentlyNonNull j jVar) {
        this.f5986b = jVar;
    }

    @Keep
    public static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a() {
    }

    @RecentlyNonNull
    public Activity b() {
        return this.f5986b.c();
    }

    public void c(@RecentlyNonNull int i, @RecentlyNonNull int i2, @RecentlyNonNull Intent intent) {
    }

    public void d(Bundle bundle) {
    }

    public void e() {
    }

    public void f(@RecentlyNonNull Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }
}
