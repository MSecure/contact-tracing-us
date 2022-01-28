package b.n;

import b.c.a.b.b;
import b.n.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class j extends f {

    /* renamed from: a  reason: collision with root package name */
    public b.c.a.b.a<h, a> f1391a = new b.c.a.b.a<>();

    /* renamed from: b  reason: collision with root package name */
    public f.b f1392b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<i> f1393c;

    /* renamed from: d  reason: collision with root package name */
    public int f1394d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1395e = false;
    public boolean f = false;
    public ArrayList<f.b> g = new ArrayList<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f.b f1396a;

        /* renamed from: b  reason: collision with root package name */
        public g f1397b;

        public a(h hVar, f.b bVar) {
            this.f1397b = m.d(hVar);
            this.f1396a = bVar;
        }

        public void a(i iVar, f.a aVar) {
            f.b c2 = j.c(aVar);
            this.f1396a = j.e(this.f1396a, c2);
            this.f1397b.d(iVar, aVar);
            this.f1396a = c2;
        }
    }

    public j(i iVar) {
        this.f1393c = new WeakReference<>(iVar);
        this.f1392b = f.b.INITIALIZED;
    }

    public static f.b c(f.a aVar) {
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return f.b.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return f.b.DESTROYED;
                        }
                        throw new IllegalArgumentException("Unexpected event value " + aVar);
                    }
                }
            }
            return f.b.STARTED;
        }
        return f.b.CREATED;
    }

    public static f.b e(f.b bVar, f.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    public static f.a i(f.b bVar) {
        int ordinal = bVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return f.a.ON_CREATE;
        }
        if (ordinal == 2) {
            return f.a.ON_START;
        }
        if (ordinal == 3) {
            return f.a.ON_RESUME;
        }
        if (ordinal != 4) {
            throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
        throw new IllegalArgumentException();
    }

    @Override // b.n.f
    public void a(h hVar) {
        i iVar;
        f.b bVar = this.f1392b;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        a aVar = new a(hVar, bVar2);
        if (this.f1391a.h(hVar, aVar) == null && (iVar = this.f1393c.get()) != null) {
            boolean z = this.f1394d != 0 || this.f1395e;
            f.b b2 = b(hVar);
            this.f1394d++;
            while (aVar.f1396a.compareTo((Enum) b2) < 0 && this.f1391a.f.containsKey(hVar)) {
                this.g.add(aVar.f1396a);
                aVar.a(iVar, i(aVar.f1396a));
                g();
                b2 = b(hVar);
            }
            if (!z) {
                h();
            }
            this.f1394d--;
        }
    }

    public final f.b b(h hVar) {
        b.c.a.b.a<h, a> aVar = this.f1391a;
        f.b bVar = null;
        b.c<K, V> cVar = aVar.f.containsKey(hVar) ? aVar.f.get(hVar).f782e : null;
        f.b bVar2 = cVar != null ? ((a) cVar.getValue()).f1396a : null;
        if (!this.g.isEmpty()) {
            ArrayList<f.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return e(e(this.f1392b, bVar2), bVar);
    }

    public void d(f.a aVar) {
        f(c(aVar));
    }

    public final void f(f.b bVar) {
        if (this.f1392b != bVar) {
            this.f1392b = bVar;
            if (this.f1395e || this.f1394d != 0) {
                this.f = true;
                return;
            }
            this.f1395e = true;
            h();
            this.f1395e = false;
        }
    }

    public final void g() {
        ArrayList<f.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: b.c.a.b.a<b.n.h, b.n.j$a> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: b.c.a.b.a<b.n.h, b.n.j$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        f.a aVar;
        f.b bVar;
        i iVar = this.f1393c.get();
        if (iVar != null) {
            while (true) {
                b.c.a.b.a<h, a> aVar2 = this.f1391a;
                boolean z = aVar2.f778e == 0 || (aVar2.f775b.f780c.f1396a == (bVar = aVar2.f776c.f780c.f1396a) && this.f1392b == bVar);
                this.f = false;
                if (!z) {
                    if (this.f1392b.compareTo((Enum) this.f1391a.f775b.f780c.f1396a) < 0) {
                        b.c.a.b.a<h, a> aVar3 = this.f1391a;
                        b.C0014b bVar2 = new b.C0014b(aVar3.f776c, aVar3.f775b);
                        aVar3.f777d.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.f) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar4 = (a) entry.getValue();
                            while (aVar4.f1396a.compareTo((Enum) this.f1392b) > 0 && !this.f && this.f1391a.contains(entry.getKey())) {
                                f.b bVar3 = aVar4.f1396a;
                                int ordinal = bVar3.ordinal();
                                if (ordinal == 0) {
                                    throw new IllegalArgumentException();
                                } else if (ordinal != 1) {
                                    if (ordinal == 2) {
                                        aVar = f.a.ON_DESTROY;
                                    } else if (ordinal == 3) {
                                        aVar = f.a.ON_STOP;
                                    } else if (ordinal == 4) {
                                        aVar = f.a.ON_PAUSE;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected state value " + bVar3);
                                    }
                                    this.g.add(c(aVar));
                                    aVar4.a(iVar, aVar);
                                    g();
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                    b.c<K, V> cVar = this.f1391a.f776c;
                    if (!this.f && cVar != null && this.f1392b.compareTo((Enum) cVar.f780c.f1396a) > 0) {
                        b<K, V>.d c2 = this.f1391a.c();
                        while (c2.hasNext() && !this.f) {
                            Map.Entry entry2 = (Map.Entry) c2.next();
                            a aVar5 = (a) entry2.getValue();
                            while (aVar5.f1396a.compareTo((Enum) this.f1392b) < 0 && !this.f && this.f1391a.contains(entry2.getKey())) {
                                this.g.add(aVar5.f1396a);
                                aVar5.a(iVar, i(aVar5.f1396a));
                                g();
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
