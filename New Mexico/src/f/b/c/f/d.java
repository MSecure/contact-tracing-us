package f.b.c.f;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public final class d<T> {
    public final Set<Class<? super T>> a;
    public final Set<o> b;
    public final int c;

    /* renamed from: d */
    public final int f3473d;

    /* renamed from: e */
    public final f<T> f3474e;

    /* renamed from: f */
    public final Set<Class<?>> f3475f;

    /* loaded from: classes.dex */
    public static class b<T> {
        public final Set<Class<? super T>> a;

        /* renamed from: d */
        public f<T> f3476d;
        public final Set<o> b = new HashSet();
        public int c = 0;

        /* renamed from: e */
        public Set<Class<?>> f3477e = new HashSet();

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        public b<T> a(o oVar) {
            if (!this.a.contains(oVar.a)) {
                this.b.add(oVar);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public d<T> b() {
            if (this.f3476d != null) {
                return new d<>(new HashSet(this.a), new HashSet(this.b), 0, this.c, this.f3476d, this.f3477e, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(f<T> fVar) {
            this.f3476d = fVar;
            return this;
        }
    }

    public d(Set set, Set set2, int i2, int i3, f fVar, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i2;
        this.f3473d = i3;
        this.f3474e = fVar;
        this.f3475f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.c(new f(t) { // from class: f.b.c.f.b
            public final Object a;

            {
                this.a = r1;
            }

            @Override // f.b.c.f.f
            public Object a(e eVar) {
                return this.a;
            }
        });
        return bVar.b();
    }

    public boolean b() {
        return this.f3473d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.f3473d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
