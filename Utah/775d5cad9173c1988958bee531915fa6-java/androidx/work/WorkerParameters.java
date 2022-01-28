package androidx.work;

import android.net.Uri;
import e.b0.f;
import e.b0.j;
import e.b0.t;
import e.b0.z;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    public UUID a;
    public f b;
    public Executor c;

    /* renamed from: d  reason: collision with root package name */
    public z f303d;

    /* renamed from: e  reason: collision with root package name */
    public j f304e;

    public static class a {
        public List<String> a = Collections.emptyList();
        public List<Uri> b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, f fVar, Collection<String> collection, a aVar, int i2, Executor executor, e.b0.a0.t.t.a aVar2, z zVar, t tVar, j jVar) {
        this.a = uuid;
        this.b = fVar;
        new HashSet(collection);
        this.c = executor;
        this.f303d = zVar;
        this.f304e = jVar;
    }
}
