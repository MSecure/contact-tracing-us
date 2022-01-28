package b.n;

import b.n.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f1380c = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, a> f1381a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, Boolean> f1382b = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<f.a, List<C0032b>> f1383a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<C0032b, f.a> f1384b;

        public a(Map<C0032b, f.a> map) {
            this.f1384b = map;
            for (Map.Entry<C0032b, f.a> entry : map.entrySet()) {
                f.a value = entry.getValue();
                List<C0032b> list = this.f1383a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f1383a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void a(List<C0032b> list, i iVar, f.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    C0032b bVar = list.get(size);
                    if (bVar != null) {
                        try {
                            int i = bVar.f1385a;
                            if (i == 0) {
                                bVar.f1386b.invoke(obj, new Object[0]);
                            } else if (i == 1) {
                                bVar.f1386b.invoke(obj, iVar);
                            } else if (i == 2) {
                                bVar.f1386b.invoke(obj, iVar, aVar);
                            }
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException("Failed to call observer method", e2.getCause());
                        } catch (IllegalAccessException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    /* renamed from: b.n.b$b  reason: collision with other inner class name */
    public static class C0032b {

        /* renamed from: a  reason: collision with root package name */
        public final int f1385a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f1386b;

        public C0032b(int i, Method method) {
            this.f1385a = i;
            this.f1386b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0032b.class != obj.getClass()) {
                return false;
            }
            C0032b bVar = (C0032b) obj;
            return this.f1385a == bVar.f1385a && this.f1386b.getName().equals(bVar.f1386b.getName());
        }

        public int hashCode() {
            return this.f1386b.getName().hashCode() + (this.f1385a * 31);
        }
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i;
        a b2;
        Class<?> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b2 = b(superclass)) == null)) {
            hashMap.putAll(b2.f1384b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0032b, f.a> entry : b(cls2).f1384b.entrySet()) {
                c(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(i.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                f.a value = rVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(f.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == f.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    c(hashMap, new C0032b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f1381a.put(cls, aVar);
        this.f1382b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    public a b(Class<?> cls) {
        a aVar = this.f1381a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public final void c(Map<C0032b, f.a> map, C0032b bVar, f.a aVar, Class<?> cls) {
        f.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f1386b;
            StringBuilder g = c.a.a.a.a.g("Method ");
            g.append(method.getName());
            g.append(" in ");
            g.append(cls.getName());
            g.append(" already declared with different @OnLifecycleEvent value: previous value ");
            g.append(aVar2);
            g.append(", new value ");
            g.append(aVar);
            throw new IllegalArgumentException(g.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }
}
