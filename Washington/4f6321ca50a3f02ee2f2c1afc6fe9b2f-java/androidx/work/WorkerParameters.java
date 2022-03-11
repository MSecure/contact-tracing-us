package androidx.work;

import android.net.Uri;
import e.b0.e;
import e.b0.q;
import e.b0.w;
import e.b0.x.t.m;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    public UUID a;
    public e b;
    public Executor c;

    /* renamed from: d  reason: collision with root package name */
    public w f304d;

    public static class a {
        public List<String> a = Collections.emptyList();
        public List<Uri> b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i2, Executor executor, e.b0.x.t.q.a aVar2, w wVar, q qVar, m mVar) {
        this.a = uuid;
        this.b = eVar;
        new HashSet(collection);
        this.c = executor;
        this.f304d = wVar;
    }
}
