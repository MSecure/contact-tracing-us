package f.b.a.f.a.b;

import android.os.Bundle;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: g */
    public static final a f3301g = new a("ExtractorSessionStoreView");
    public final d0 a;
    public final r<v3> b;
    public final d1 c;

    /* renamed from: d */
    public final r<Executor> f3302d;

    /* renamed from: e */
    public final Map<Integer, p1> f3303e = new HashMap();

    /* renamed from: f */
    public final ReentrantLock f3304f = new ReentrantLock();

    public s1(d0 d0Var, r<v3> rVar, d1 d1Var, r<Executor> rVar2) {
        this.a = d0Var;
        this.b = rVar;
        this.c = d1Var;
        this.f3302d = rVar2;
    }

    public static String c(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new z0("Session without pack received.");
    }

    public final p1 a(int i2) {
        Map<Integer, p1> map = this.f3303e;
        Integer valueOf = Integer.valueOf(i2);
        p1 p1Var = map.get(valueOf);
        if (p1Var != null) {
            return p1Var;
        }
        throw new z0(String.format("Could not find session %d while trying to get it", valueOf), i2);
    }

    public final <T> T b(r1<T> r1Var) {
        try {
            this.f3304f.lock();
            return r1Var.a();
        } finally {
            this.f3304f.unlock();
        }
    }
}
