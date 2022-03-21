package f.b.c.k.x;

import f.b.c.k.c;
import f.b.c.k.d;
import f.b.c.k.e;
import f.b.c.k.k;
import f.b.c.k.l;
import f.b.c.k.m;
import f.b.c.k.n;
import f.b.c.k.p;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class h {
    public static final ConcurrentMap<Class<?>, a<?>> a = new ConcurrentHashMap();

    public static class a<T> {
        public final Class<T> a;
        public final Map<String, String> b = new HashMap();
        public final Map<String, Method> c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final Map<String, Method> f3185d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, Field> f3186e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public final HashSet<String> f3187f = new HashSet<>();

        /* renamed from: g  reason: collision with root package name */
        public final HashSet<String> f3188g = new HashSet<>();

        /* JADX WARNING: Removed duplicated region for block: B:112:0x031a  */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x02bd A[SYNTHETIC] */
        public a(Class<T> cls) {
            char c2;
            boolean z;
            this.a = cls;
            cls.isAnnotationPresent(p.class);
            cls.isAnnotationPresent(l.class);
            char c3 = 0;
            try {
                cls.getDeclaredConstructor(new Class[0]).setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(d.class)) {
                    String f2 = f(method);
                    a(f2);
                    method.setAccessible(true);
                    if (!this.c.containsKey(f2)) {
                        this.c.put(f2, method);
                        if (method.isAnnotationPresent(n.class)) {
                            Class<?> returnType = method.getReturnType();
                            if (returnType == Date.class || returnType == f.b.c.d.class) {
                                this.f3187f.add(f(method));
                            } else {
                                StringBuilder h2 = f.a.a.a.a.h("Method ");
                                h2.append(method.getName());
                                h2.append(" is annotated with @ServerTimestamp but returns ");
                                h2.append(returnType);
                                h2.append(" instead of Date or Timestamp.");
                                throw new IllegalArgumentException(h2.toString());
                            }
                        }
                        if (method.isAnnotationPresent(f.b.c.k.b.class)) {
                            d("Method", "returns", method.getReturnType());
                            this.f3188g.add(f(method));
                        }
                    } else {
                        StringBuilder h3 = f.a.a.a.a.h("Found conflicting getters for name ");
                        h3.append(method.getName());
                        h3.append(" on class ");
                        h3.append(cls.getName());
                        throw new RuntimeException(h3.toString());
                    }
                }
            }
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                if (!field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(d.class)) {
                    a(e(field));
                    c(field);
                }
            }
            Class<? super T> cls2 = cls;
            do {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                for (Method method2 : declaredMethods) {
                    if (method2.getName().startsWith("set") && !method2.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method2.getModifiers()) && method2.getReturnType().equals(Void.TYPE) && method2.getParameterTypes().length == 1 && !method2.isAnnotationPresent(d.class)) {
                        String f3 = f(method2);
                        String str = this.b.get(f3.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else if (str.equals(f3)) {
                            Method method3 = this.f3185d.get(f3);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.f3185d.put(f3, method2);
                                if (method2.isAnnotationPresent(n.class)) {
                                    StringBuilder h4 = f.a.a.a.a.h("Method ");
                                    h4.append(method2.getName());
                                    h4.append(" is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
                                    throw new IllegalArgumentException(h4.toString());
                                } else if (method2.isAnnotationPresent(f.b.c.k.b.class)) {
                                    d("Method", "accepts", method2.getParameterTypes()[c3]);
                                    this.f3188g.add(f(method2));
                                }
                            } else {
                                h.a(method2.getDeclaringClass().isAssignableFrom(method3.getDeclaringClass()), "Expected override from a base class");
                                h.a(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
                                h.a(method3.getReturnType().equals(Void.TYPE), "Expected void return type");
                                Class<?>[] parameterTypes = method2.getParameterTypes();
                                Class<?>[] parameterTypes2 = method3.getParameterTypes();
                                h.a(parameterTypes.length == 1, "Expected exactly one parameter");
                                h.a(parameterTypes2.length == 1, "Expected exactly one parameter");
                                if (method2.getName().equals(method3.getName())) {
                                    c2 = 0;
                                    if (parameterTypes[0].equals(parameterTypes2[0])) {
                                        z = true;
                                        if (!z) {
                                            c3 = c2;
                                        } else if (cls2 == cls) {
                                            StringBuilder h5 = f.a.a.a.a.h("Class ");
                                            h5.append(cls.getName());
                                            h5.append(" has multiple setter overloads with name ");
                                            h5.append(method2.getName());
                                            throw new RuntimeException(h5.toString());
                                        } else {
                                            StringBuilder h6 = f.a.a.a.a.h("Found conflicting setters with name: ");
                                            h6.append(method2.getName());
                                            h6.append(" (conflicts with ");
                                            h6.append(method3.getName());
                                            h6.append(" defined on ");
                                            h6.append(method3.getDeclaringClass().getName());
                                            h6.append(")");
                                            throw new RuntimeException(h6.toString());
                                        }
                                    }
                                } else {
                                    c2 = 0;
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                        } else {
                            StringBuilder h7 = f.a.a.a.a.h("Found setter on ");
                            h7.append(cls2.getName());
                            h7.append(" with invalid case-sensitive name: ");
                            h7.append(method2.getName());
                            throw new RuntimeException(h7.toString());
                        }
                    }
                }
                Field[] declaredFields = cls2.getDeclaredFields();
                for (Field field2 : declaredFields) {
                    String e2 = e(field2);
                    if (this.b.containsKey(e2.toLowerCase(Locale.US)) && !this.f3186e.containsKey(e2)) {
                        field2.setAccessible(true);
                        this.f3186e.put(e2, field2);
                        c(field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (!this.b.isEmpty()) {
                Iterator<String> it = this.f3188g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!(this.f3185d.containsKey(next) || this.f3186e.containsKey(next))) {
                        StringBuilder j2 = f.a.a.a.a.j("@DocumentId is annotated on property ", next, " of class ");
                        j2.append(cls.getName());
                        j2.append(" but no field or public setter was found");
                        throw new RuntimeException(j2.toString());
                    }
                }
                return;
            }
            StringBuilder h8 = f.a.a.a.a.h("No properties to serialize found on class ");
            h8.append(cls.getName());
            throw new RuntimeException(h8.toString());
        }

        public static String b(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(m.class)) {
                return ((m) accessibleObject.getAnnotation(m.class)).value();
            }
            return null;
        }

        public static String e(Field field) {
            String b2 = b(field);
            return b2 != null ? b2 : field.getName();
        }

        public static String f(Method method) {
            String b2 = b(method);
            if (b2 != null) {
                return b2;
            }
            String name = method.getName();
            String[] strArr = {"get", "set", "is"};
            String str = null;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                String str2 = strArr[i3];
                if (name.startsWith(str2)) {
                    str = str2;
                }
            }
            if (str != null) {
                char[] charArray = name.substring(str.length()).toCharArray();
                while (i2 < charArray.length && Character.isUpperCase(charArray[i2])) {
                    charArray[i2] = Character.toLowerCase(charArray[i2]);
                    i2++;
                }
                return new String(charArray);
            }
            throw new IllegalArgumentException(f.a.a.a.a.t("Unknown Bean prefix for method: ", name));
        }

        public final void a(String str) {
            Map<String, String> map = this.b;
            Locale locale = Locale.US;
            String put = map.put(str.toLowerCase(locale), str);
            if (put != null && !str.equals(put)) {
                StringBuilder h2 = f.a.a.a.a.h("Found two getters or fields with conflicting case sensitivity for property: ");
                h2.append(str.toLowerCase(locale));
                throw new RuntimeException(h2.toString());
            }
        }

        public final void c(Field field) {
            if (field.isAnnotationPresent(n.class)) {
                Class<?> type = field.getType();
                if (type == Date.class || type == f.b.c.d.class) {
                    this.f3187f.add(e(field));
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("Field ");
                    h2.append(field.getName());
                    h2.append(" is annotated with @ServerTimestamp but is ");
                    h2.append(type);
                    h2.append(" instead of Date or Timestamp.");
                    throw new IllegalArgumentException(h2.toString());
                }
            }
            if (field.isAnnotationPresent(f.b.c.k.b.class)) {
                d("Field", "is", field.getType());
                this.f3188g.add(e(field));
            }
        }

        public final void d(String str, String str2, Type type) {
            if (type != String.class && type != c.class) {
                throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + " " + type + " instead of String or DocumentReference.");
            }
        }
    }

    public static class b {

        /* renamed from: d  reason: collision with root package name */
        public static final b f3189d = new b(null, null, 0);
        public final int a;
        public final b b;
        public final String c;

        public b(b bVar, String str, int i2) {
            this.b = bVar;
            this.c = str;
            this.a = i2;
        }

        public b a(String str) {
            return new b(this, str, this.a + 1);
        }

        public String toString() {
            int i2 = this.a;
            if (i2 == 0) {
                return "";
            }
            if (i2 == 1) {
                return this.c;
            }
            return this.b.toString() + "." + this.c;
        }
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new RuntimeException(f.a.a.a.a.t("Hard assert failed: ", str));
        }
    }

    public static <T> Object b(T t, b bVar) {
        Object obj;
        Object obj2;
        if (bVar.a > 500) {
            throw c(bVar, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
        } else if (t == null) {
            return null;
        } else {
            if (t instanceof Number) {
                if ((t instanceof Long) || (t instanceof Integer) || (t instanceof Double) || (t instanceof Float)) {
                    return t;
                }
                throw c(bVar, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
            } else if ((t instanceof String) || (t instanceof Boolean)) {
                return t;
            } else {
                if (t instanceof Character) {
                    throw c(bVar, "Characters are not supported, please use Strings");
                } else if (t instanceof Map) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : t.entrySet()) {
                        Object key = entry.getKey();
                        if (key instanceof String) {
                            String str = (String) key;
                            hashMap.put(str, b(entry.getValue(), bVar.a(str)));
                        } else {
                            throw c(bVar, "Maps with non-string keys are not supported");
                        }
                    }
                    return hashMap;
                } else if (t instanceof Collection) {
                    if (t instanceof List) {
                        T t2 = t;
                        ArrayList arrayList = new ArrayList(t2.size());
                        for (int i2 = 0; i2 < t2.size(); i2++) {
                            Object obj3 = t2.get(i2);
                            arrayList.add(b(obj3, bVar.a("[" + i2 + "]")));
                        }
                        return arrayList;
                    }
                    throw c(bVar, "Serializing Collections is not supported, please use Lists instead");
                } else if (t.getClass().isArray()) {
                    throw c(bVar, "Serializing Arrays is not supported, please use Lists instead");
                } else if (t instanceof Enum) {
                    String name = t.name();
                    try {
                        return a.e(t.getClass().getField(name));
                    } catch (NoSuchFieldException unused) {
                        return name;
                    }
                } else if ((t instanceof Date) || (t instanceof f.b.c.d) || (t instanceof k) || (t instanceof f.b.c.k.a) || (t instanceof c) || (t instanceof e)) {
                    return t;
                } else {
                    Class<?> cls = t.getClass();
                    ConcurrentMap<Class<?>, a<?>> concurrentMap = a;
                    a<?> aVar = concurrentMap.get(cls);
                    if (aVar == null) {
                        aVar = new a<>(cls);
                        concurrentMap.put(cls, aVar);
                    }
                    if (aVar.a.isAssignableFrom(t.getClass())) {
                        HashMap hashMap2 = new HashMap();
                        for (String str2 : aVar.b.values()) {
                            if (!aVar.f3188g.contains(str2)) {
                                if (aVar.c.containsKey(str2)) {
                                    try {
                                        obj = aVar.c.get(str2).invoke(t, new Object[0]);
                                    } catch (IllegalAccessException e2) {
                                        throw new RuntimeException(e2);
                                    } catch (InvocationTargetException e3) {
                                        throw new RuntimeException(e3);
                                    }
                                } else {
                                    Field field = aVar.f3186e.get(str2);
                                    if (field != null) {
                                        try {
                                            obj = field.get(t);
                                        } catch (IllegalAccessException e4) {
                                            throw new RuntimeException(e4);
                                        }
                                    } else {
                                        throw new IllegalStateException(f.a.a.a.a.t("Bean property without field or getter: ", str2));
                                    }
                                }
                                if (!aVar.f3187f.contains(str2) || obj != null) {
                                    obj2 = b(obj, bVar.a(str2));
                                } else {
                                    obj2 = e.a;
                                }
                                hashMap2.put(str2, obj2);
                            }
                        }
                        return hashMap2;
                    }
                    StringBuilder h2 = f.a.a.a.a.h("Can't serialize object of class ");
                    h2.append(t.getClass());
                    h2.append(" with BeanMapper for class ");
                    h2.append(aVar.a);
                    throw new IllegalArgumentException(h2.toString());
                }
            }
        }
    }

    public static IllegalArgumentException c(b bVar, String str) {
        String t = f.a.a.a.a.t("Could not serialize object. ", str);
        if (bVar.a > 0) {
            StringBuilder i2 = f.a.a.a.a.i(t, " (found in field '");
            i2.append(bVar.toString());
            i2.append("')");
            t = i2.toString();
        }
        return new IllegalArgumentException(t);
    }
}
