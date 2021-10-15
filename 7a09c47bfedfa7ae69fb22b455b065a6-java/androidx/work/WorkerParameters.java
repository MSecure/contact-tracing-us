package androidx.work;

import android.net.Network;
import android.net.Uri;
import b.b0.e;
import b.b0.h;
import b.b0.r;
import b.b0.x;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    public UUID f441a;

    /* renamed from: b  reason: collision with root package name */
    public e f442b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f443c;

    /* renamed from: d  reason: collision with root package name */
    public a f444d;

    /* renamed from: e  reason: collision with root package name */
    public int f445e;

    /* renamed from: f  reason: collision with root package name */
    public Executor f446f;

    /* renamed from: g  reason: collision with root package name */
    public b.b0.y.s.s.a f447g;
    public x h;
    public r i;
    public h j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f448a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f449b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f450c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i2, Executor executor, b.b0.y.s.s.a aVar2, x xVar, r rVar, h hVar) {
        this.f441a = uuid;
        this.f442b = eVar;
        this.f443c = new HashSet(collection);
        this.f444d = aVar;
        this.f445e = i2;
        this.f446f = executor;
        this.f447g = aVar2;
        this.h = xVar;
        this.i = rVar;
        this.j = hVar;
    }
}
