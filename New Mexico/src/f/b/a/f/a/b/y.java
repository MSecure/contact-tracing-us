package f.b.a.f.a.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import f.b.a.f.a.f.c;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class y extends c<AssetPackState> {

    /* renamed from: g */
    public final s1 f3336g;

    /* renamed from: h */
    public final a1 f3337h;

    /* renamed from: i */
    public final r<v3> f3338i;

    /* renamed from: j */
    public final o0 f3339j;

    /* renamed from: k */
    public final d1 f3340k;

    /* renamed from: l */
    public final r<Executor> f3341l;
    public final r<Executor> m;
    public final m2 n;
    public final Handler o = new Handler(Looper.getMainLooper());

    public y(Context context, s1 s1Var, a1 a1Var, r<v3> rVar, d1 d1Var, o0 o0Var, r<Executor> rVar2, r<Executor> rVar3, m2 m2Var) {
        super(new a("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f3336g = s1Var;
        this.f3337h = a1Var;
        this.f3338i = rVar;
        this.f3340k = d1Var;
        this.f3339j = o0Var;
        this.f3341l = rVar2;
        this.m = rVar3;
        this.n = m2Var;
    }

    @Override // f.b.a.f.a.f.c
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.a.b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            AssetPackState i2 = AssetPackState.i(bundleExtra, stringArrayList.get(0), this.f3340k, this.n, a0.a);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", i2);
            if (((PendingIntent) bundleExtra.getParcelable("confirmation_intent")) != null) {
                Objects.requireNonNull(this.f3339j);
            }
            this.m.a().execute(new Runnable(bundleExtra, i2) { // from class: f.b.a.f.a.b.v
                public final /* synthetic */ Bundle c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ AssetPackState f3321d;

                {
                    this.c = r2;
                    this.f3321d = r3;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.f.a.b.i1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:305)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:111)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    */
                @Override // java.lang.Runnable
                public final void run() {
                    /*
                        r5 = this;
                        f.b.a.f.a.b.y r0 = f.b.a.f.a.b.y.this
                        android.os.Bundle r1 = r5.c
                        com.google.android.play.core.assetpacks.AssetPackState r2 = r5.f3321d
                        f.b.a.f.a.b.s1 r3 = r0.f3336g
                        f.b.a.f.a.b.i1 r4 = new f.b.a.f.a.b.i1
                        r4.<init>(r3, r1)
                        java.lang.Object r1 = r3.b(r4)
                        java.lang.Boolean r1 = (java.lang.Boolean) r1
                        boolean r1 = r1.booleanValue()
                        if (r1 == 0) goto L_0x002e
                        android.os.Handler r1 = r0.o
                        f.b.a.f.a.b.x r3 = new f.b.a.f.a.b.x
                        r3.<init>(r0, r2)
                        r1.post(r3)
                        f.b.a.f.a.e.r<f.b.a.f.a.b.v3> r0 = r0.f3338i
                        java.lang.Object r0 = r0.a()
                        f.b.a.f.a.b.v3 r0 = (f.b.a.f.a.b.v3) r0
                        r0.c()
                    L_0x002e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.f.a.b.v.run():void");
                }
            });
            this.f3341l.a().execute(new Runnable(bundleExtra) { // from class: f.b.a.f.a.b.u
                public final /* synthetic */ Bundle c;

                {
                    this.c = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.f.a.b.j1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:305)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:115)
                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                    	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:111)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    */
                @Override // java.lang.Runnable
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 244
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.f.a.b.u.run():void");
                }
            });
            return;
        }
        this.a.b("Empty bundle received from broadcast.", new Object[0]);
    }
}
