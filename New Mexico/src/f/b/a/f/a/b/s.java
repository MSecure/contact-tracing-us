package f.b.a.f.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.f0;
import f.b.a.f.a.e.l;
import f.b.a.f.a.e.n;
import f.b.a.f.a.h.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class s implements v3 {

    /* renamed from: g */
    public static final a f3287g = new a("AssetPackServiceImpl");

    /* renamed from: h */
    public static final Intent f3288h = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    public final String a;
    public final d1 b;
    public final m2 c;

    /* renamed from: d */
    public l<f0> f3289d;

    /* renamed from: e */
    public l<f0> f3290e;

    /* renamed from: f */
    public final AtomicBoolean f3291f = new AtomicBoolean();

    public s(Context context, d1 d1Var, m2 m2Var) {
        this.a = context.getPackageName();
        this.b = d1Var;
        this.c = m2Var;
        if (n.b(context)) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = applicationContext != null ? applicationContext : context;
            a aVar = f3287g;
            Intent intent = f3288h;
            w3 w3Var = w3.a;
            this.f3289d = new l<>(context2, aVar, "AssetPackService", intent, w3Var, null);
            Context applicationContext2 = context.getApplicationContext();
            this.f3290e = new l<>(applicationContext2 != null ? applicationContext2 : context, aVar, "AssetPackService-keepAlive", intent, w3Var, null);
        }
        f3287g.a("AssetPackService initiated.", new Object[0]);
    }

    public static Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11002);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        bundle.putIntegerArrayList("supported_patch_formats", arrayList2);
        return bundle;
    }

    public static <T> r<T> i() {
        f3287g.b("onError(%d)", -11);
        a aVar = new a(-11);
        r<T> rVar = new r<>();
        rVar.f(aVar);
        return rVar;
    }

    public static Bundle k(int i2, String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i2);
        bundle.putString("module_name", str);
        bundle.putString("slice_id", str2);
        bundle.putInt("chunk_number", i3);
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle l(Map map) {
        Bundle h2 = h();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        h2.putParcelableArrayList("installed_asset_module", arrayList);
        return h2;
    }

    @Override // f.b.a.f.a.b.v3
    public final void a(int i2, String str, String str2, int i3) {
        if (this.f3289d != null) {
            f3287g.d("notifyChunkTransferred", new Object[0]);
            f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
            this.f3289d.b(new f(this, nVar, i2, str, str2, i3, nVar), nVar);
            return;
        }
        throw new z0("The Play Store app is not installed or is an unofficial version.", i2);
    }

    @Override // f.b.a.f.a.b.v3
    public final void b(int i2) {
        if (this.f3289d != null) {
            f3287g.d("notifySessionFailed", new Object[0]);
            f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
            this.f3289d.b(new h(this, nVar, i2, nVar), nVar);
            return;
        }
        throw new z0("The Play Store app is not installed or is an unofficial version.", i2);
    }

    @Override // f.b.a.f.a.b.v3
    public final synchronized void c() {
        if (this.f3290e == null) {
            f3287g.e("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        a aVar = f3287g;
        aVar.d("keepAlive", new Object[0]);
        if (!this.f3291f.compareAndSet(false, true)) {
            aVar.d("Service is already kept alive.", new Object[0]);
            return;
        }
        f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
        this.f3290e.b(new j(this, nVar, nVar), nVar);
    }

    @Override // f.b.a.f.a.b.v3
    public final void d(List<String> list) {
        if (this.f3289d != null) {
            f3287g.d("cancelDownloads(%s)", list);
            f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
            this.f3289d.b(new d(this, nVar, list, nVar), nVar);
        }
    }

    @Override // f.b.a.f.a.b.v3
    public final void e(int i2, String str) {
        j(i2, str, 10);
    }

    @Override // f.b.a.f.a.b.v3
    public final r<List<String>> f(Map<String, Long> map) {
        if (this.f3289d == null) {
            return i();
        }
        f3287g.d("syncPacks", new Object[0]);
        f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
        this.f3289d.b(new e(this, nVar, map, nVar), nVar);
        return nVar.a;
    }

    @Override // f.b.a.f.a.b.v3
    public final r<ParcelFileDescriptor> g(int i2, String str, String str2, int i3) {
        if (this.f3289d == null) {
            return i();
        }
        f3287g.d("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i3), Integer.valueOf(i2));
        f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
        this.f3289d.b(new i(this, nVar, i2, str, str2, i3, nVar), nVar);
        return nVar.a;
    }

    public final void j(int i2, String str, int i3) {
        if (this.f3289d != null) {
            f3287g.d("notifyModuleCompleted", new Object[0]);
            f.b.a.f.a.h.n<?> nVar = new f.b.a.f.a.h.n<>();
            this.f3289d.b(new g(this, nVar, i2, str, nVar, i3), nVar);
            return;
        }
        throw new z0("The Play Store app is not installed or is an unofficial version.", i2);
    }
}
