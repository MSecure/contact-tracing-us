package f.b.c.f;

import f.b.c.j.c;
import f.b.c.j.d;
import f.b.c.m.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

public class k extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f3065e = 0;
    public final Map<d<?>, t<?>> a = new HashMap();
    public final Map<Class<?>, t<?>> b = new HashMap();
    public final Map<Class<?>, t<Set<?>>> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final s f3066d;

    public k(Executor executor, Iterable<g> iterable, d<?>... dVarArr) {
        Set<m> set;
        s sVar = new s(executor);
        this.f3066d = sVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.c(sVar, s.class, d.class, c.class));
        for (g gVar : iterable) {
            arrayList.addAll(gVar.getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            m mVar = new m(dVar2);
            Iterator<Class<? super T>> it2 = dVar2.a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class<? super T> next = it2.next();
                    n nVar = new n(next, !dVar2.b(), null);
                    if (!hashMap.containsKey(nVar)) {
                        hashMap.put(nVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(nVar);
                    if (set2.isEmpty() || nVar.b) {
                        set2.add(mVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", next));
                    }
                }
            }
        }
        for (Set<m> set3 : hashMap.values()) {
            for (m mVar2 : set3) {
                for (o oVar : mVar2.a.b) {
                    if ((oVar.c == 0) && (set = (Set) hashMap.get(new n(oVar.a, oVar.a(), null))) != null) {
                        for (m mVar3 : set) {
                            mVar2.b.add(mVar3);
                            mVar3.c.add(mVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            m mVar4 = (m) it3.next();
            if (mVar4.a()) {
                hashSet2.add(mVar4);
            }
        }
        int i2 = 0;
        while (!hashSet2.isEmpty()) {
            m mVar5 = (m) hashSet2.iterator().next();
            hashSet2.remove(mVar5);
            i2++;
            for (m mVar6 : mVar5.b) {
                mVar6.c.remove(mVar5);
                if (mVar6.a()) {
                    hashSet2.add(mVar6);
                }
            }
        }
        if (i2 == arrayList.size()) {
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                d<?> dVar3 = (d) it4.next();
                this.a.put(dVar3, new t<>(new h(this, dVar3)));
            }
            for (Map.Entry<d<?>, t<?>> entry : this.a.entrySet()) {
                d<?> key = entry.getKey();
                if (key.b()) {
                    t<?> value = entry.getValue();
                    for (Class<? super T> cls : key.a) {
                        this.b.put(cls, value);
                    }
                }
            }
            for (d<?> dVar4 : this.a.keySet()) {
                Iterator<o> it5 = dVar4.b.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        o next2 = it5.next();
                        if ((next2.b == 1) && !this.b.containsKey(next2.a)) {
                            throw new u(String.format("Unsatisfied dependency for component %s: %s", dVar4, next2.a));
                        }
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<d<?>, t<?>> entry2 : this.a.entrySet()) {
                d<?> key2 = entry2.getKey();
                if (!key2.b()) {
                    t<?> value2 = entry2.getValue();
                    for (Class<? super T> cls2 : key2.a) {
                        if (!hashMap2.containsKey(cls2)) {
                            hashMap2.put(cls2, new HashSet());
                        }
                        ((Set) hashMap2.get(cls2)).add(value2);
                    }
                }
            }
            for (Map.Entry entry3 : hashMap2.entrySet()) {
                this.c.put((Class) entry3.getKey(), new t<>(new i((Set) entry3.getValue())));
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it6 = hashSet.iterator();
        while (it6.hasNext()) {
            m mVar7 = (m) it6.next();
            if (!mVar7.a() && !mVar7.b.isEmpty()) {
                arrayList2.add(mVar7.a);
            }
        }
        throw new p(arrayList2);
    }

    @Override // f.b.c.f.e
    public <T> a<T> b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.b.get(cls);
    }

    @Override // f.b.c.f.e
    public <T> a<Set<T>> d(Class<T> cls) {
        t<Set<?>> tVar = this.c.get(cls);
        return tVar != null ? tVar : j.a;
    }
}
