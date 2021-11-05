package androidx.work;

import android.net.Network;
import android.net.Uri;
import b.z.e;
import b.z.h;
import b.z.r;
import b.z.x;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    public UUID f311a;

    /* renamed from: b  reason: collision with root package name */
    public e f312b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f313c;

    /* renamed from: d  reason: collision with root package name */
    public a f314d;

    /* renamed from: e  reason: collision with root package name */
    public int f315e;
    public Executor f;
    public b.z.y.s.s.a g;
    public x h;
    public r i;
    public h j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f316a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f317b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f318c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i2, Executor executor, b.z.y.s.s.a aVar2, x xVar, r rVar, h hVar) {
        this.f311a = uuid;
        this.f312b = eVar;
        this.f313c = new HashSet(collection);
        this.f314d = aVar;
        this.f315e = i2;
        this.f = executor;
        this.g = aVar2;
        this.h = xVar;
        this.i = rVar;
        this.j = hVar;
    }
}
