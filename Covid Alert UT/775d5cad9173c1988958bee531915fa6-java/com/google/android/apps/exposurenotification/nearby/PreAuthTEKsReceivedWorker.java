package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.b0.a0;
import f.b.a.a.a.b0.b0;
import f.b.a.a.a.b0.b1;
import f.b.a.a.a.b0.c0;
import f.b.a.a.a.b0.q;
import f.b.a.a.a.b0.r;
import f.b.a.a.a.b0.s;
import f.b.a.a.a.b0.t;
import f.b.a.a.a.b0.v;
import f.b.a.a.a.b0.w;
import f.b.a.a.a.c0.d;
import f.b.a.a.a.g0.k;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.y.f0;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.u;
import f.b.g.d0;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class PreAuthTEKsReceivedWorker extends ListenableWorker {

    /* renamed from: g  reason: collision with root package name */
    public final i0 f370g;

    /* renamed from: h  reason: collision with root package name */
    public final f0 f371h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f372i;

    /* renamed from: j  reason: collision with root package name */
    public final ExecutorService f373j;

    /* renamed from: k  reason: collision with root package name */
    public final SecureRandom f374k;

    /* renamed from: l  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f375l;
    public final v0 m;

    public static class a extends Exception {
    }

    public PreAuthTEKsReceivedWorker(Context context, WorkerParameters workerParameters, v0 v0Var, i0 i0Var, f0 f0Var, ExecutorService executorService, ExecutorService executorService2, SecureRandom secureRandom, f.b.a.a.a.s.e0.a aVar) {
        super(context, workerParameters);
        this.m = v0Var;
        this.f370g = i0Var;
        this.f371h = f0Var;
        this.f372i = executorService;
        this.f373j = executorService2;
        this.f374k = secureRandom;
        this.f375l = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        byte[] bArr;
        l lVar;
        Object obj = this.c.b.a.get("PreAuthTEKsReceivedWorker.KEYS_BYTES");
        int i2 = 0;
        if (obj instanceof Byte[]) {
            Byte[] bArr2 = (Byte[]) obj;
            bArr = new byte[bArr2.length];
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                bArr[i3] = bArr2[i3].byteValue();
            }
        } else {
            bArr = null;
        }
        if (bArr == null || bArr.length == 0) {
            return b.Q0(new ListenableWorker.a.C0003a());
        }
        try {
            List<k> keysList = f.b.a.a.a.g0.l.parseFrom(bArr).getKeysList();
            b.y(4, "initialCapacity");
            Object[] objArr = new Object[4];
            for (k kVar : keysList) {
                d.a f2 = d.f();
                f2.c(kVar.getKeyData().z());
                f2.b(kVar.getRollingStartIntervalNumber());
                f2.d(kVar.getRollingPeriod());
                f2.e(kVar.getTransmissionRiskLevel());
                d a2 = f2.a();
                int i4 = i2 + 1;
                if (objArr.length < i4) {
                    objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i4));
                }
                objArr[i2] = a2;
                i2 = i4;
            }
            lVar = l.c(c.p(objArr, i2));
        } catch (d0 unused) {
            lVar = f.b.b.a.a.b;
        }
        if (!lVar.b()) {
            return f.b.a.c.b.o.b.Q0(new ListenableWorker.a.C0003a());
        }
        f.b.b.f.a.l z = f.b.b.f.a.l.x(this.f370g.e()).z(new c0(this, (List) lVar.a()), this.f373j).z(new s(this), this.f372i).z(new f.b.a.a.a.b0.u(this), this.f373j);
        f0 f0Var = this.f371h;
        Objects.requireNonNull(f0Var);
        f.b.b.f.a.l y = z.z(new b1(f0Var), this.f372i).z(new t(this), this.f372i).z(b0.a, this.f373j).y(q.a, this.f373j);
        r rVar = r.a;
        ExecutorService executorService = this.f373j;
        a.b bVar = new a.b(y, a.class, rVar);
        y.a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
        v vVar = v.a;
        ExecutorService executorService2 = this.f373j;
        a.b bVar2 = new a.b(bVar, f0.c.class, vVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.j1(executorService2, bVar2));
        a0 a0Var = a0.a;
        ExecutorService executorService3 = this.f373j;
        a.b bVar3 = new a.b(bVar2, f0.d.class, a0Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.j1(executorService3, bVar3));
        w wVar = w.a;
        ExecutorService executorService4 = this.f373j;
        a.b bVar4 = new a.b(bVar3, Exception.class, wVar);
        bVar3.a(bVar4, f.b.a.c.b.o.b.j1(executorService4, bVar4));
        return bVar4;
    }
}
