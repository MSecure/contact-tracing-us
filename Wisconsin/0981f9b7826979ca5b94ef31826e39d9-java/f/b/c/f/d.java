package f.b.c.f;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class d<T> {
    public final Set<Class<? super T>> a;
    public final Set<o> b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2964d;

    /* renamed from: e  reason: collision with root package name */
    public final f<T> f2965e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<Class<?>> f2966f;

    public static class b<T> {
        public final Set<Class<? super T>> a;
        public final Set<o> b = new HashSet();
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public f<T> f2967d;

        /* renamed from: e  reason: collision with root package name */
        public Set<Class<?>> f2968e;

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.c = 0;
            this.f2968e = new HashSet();
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
            if (this.f2967d != null) {
                return new d<>(new HashSet(this.a), new HashSet(this.b), 0, this.c, this.f2967d, this.f2968e, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(f<T> fVar) {
            this.f2967d = fVar;
            return this;
        }
    }

    public d(Set set, Set set2, int i2, int i3, f fVar, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i2;
        this.f2964d = i3;
        this.f2965e = fVar;
        this.f2966f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.c(new b(t));
        return bVar.b();
    }

    public boolean b() {
        return this.f2964d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.f2964d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
