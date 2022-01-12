package com.google.gson.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    public final ReflectionAccessor accessor = ReflectionAccessor.instance;
    public final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        AnonymousClass3 r4;
        final Type type = typeToken.type;
        final Class<? super T> cls = typeToken.rawType;
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>(this) {
                /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass1 */

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(cls);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>(this) {
                /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass2 */

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> objectConstructor = null;
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            r4 = new ObjectConstructor<T>(this) {
                /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass3 */

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (InstantiationException e) {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to invoke ");
                        outline17.append(declaredConstructor);
                        outline17.append(" with no args");
                        throw new RuntimeException(outline17.toString(), e);
                    } catch (InvocationTargetException e2) {
                        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Failed to invoke ");
                        outline172.append(declaredConstructor);
                        outline172.append(" with no args");
                        throw new RuntimeException(outline172.toString(), e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            r4 = null;
        }
        if (r4 != null) {
            return r4;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass4 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeSet();
                    }
                };
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass5 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        Type type = type;
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type2);
                            }
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Invalid EnumSet type: ");
                            outline17.append(type.toString());
                            throw new JsonIOException(outline17.toString());
                        }
                        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Invalid EnumSet type: ");
                        outline172.append(type.toString());
                        throw new JsonIOException(outline172.toString());
                    }
                };
            } else if (Set.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass6 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashSet();
                    }
                };
            } else if (Queue.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass7 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayDeque();
                    }
                };
            } else {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass8 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayList();
                    }
                };
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass9 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ConcurrentSkipListMap();
                    }
                };
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass10 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ConcurrentHashMap();
                    }
                };
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass11 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeMap();
                    }
                };
            } else {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 != null) {
                        Type canonicalize = C$Gson$Types.canonicalize(type2);
                        Class<?> rawType = C$Gson$Types.getRawType(canonicalize);
                        canonicalize.hashCode();
                        if (!String.class.isAssignableFrom(rawType)) {
                            objectConstructor = new ObjectConstructor<T>(this) {
                                /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass12 */

                                @Override // com.google.gson.internal.ObjectConstructor
                                public T construct() {
                                    return (T) new LinkedHashMap();
                                }
                            };
                        }
                    } else {
                        throw null;
                    }
                }
                objectConstructor = new ObjectConstructor<T>(this) {
                    /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass13 */

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedTreeMap();
                    }
                };
            }
        }
        if (objectConstructor != null) {
            return objectConstructor;
        }
        return new ObjectConstructor<T>(this) {
            /* class com.google.gson.internal.ConstructorConstructor.AnonymousClass14 */
            public final UnsafeAllocator unsafeAllocator;

            {
                UnsafeAllocator unsafeAllocator2;
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    unsafeAllocator2 = new UnsafeAllocator(cls.getMethod("allocateInstance", Class.class), declaredField.get(null)) {
                        /* class com.google.gson.internal.UnsafeAllocator.AnonymousClass1 */
                        public final /* synthetic */ Method val$allocateInstance;
                        public final /* synthetic */ Object val$unsafe;

                        {
                            this.val$allocateInstance = r1;
                            this.val$unsafe = r2;
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls) throws Exception {
                            UnsafeAllocator.assertInstantiable(cls);
                            return (T) this.val$allocateInstance.invoke(this.val$unsafe, cls);
                        }
                    };
                } catch (Exception unused) {
                    try {
                        Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod.setAccessible(true);
                        int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                        declaredMethod2.setAccessible(true);
                        unsafeAllocator2 = new UnsafeAllocator(declaredMethod2, intValue) {
                            /* class com.google.gson.internal.UnsafeAllocator.AnonymousClass2 */
                            public final /* synthetic */ int val$constructorId;
                            public final /* synthetic */ Method val$newInstance;

                            {
                                this.val$newInstance = r1;
                                this.val$constructorId = r2;
                            }

                            @Override // com.google.gson.internal.UnsafeAllocator
                            public <T> T newInstance(Class<T> cls) throws Exception {
                                UnsafeAllocator.assertInstantiable(cls);
                                return (T) this.val$newInstance.invoke(null, cls, Integer.valueOf(this.val$constructorId));
                            }
                        };
                    } catch (Exception unused2) {
                        try {
                            Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                            declaredMethod3.setAccessible(true);
                            unsafeAllocator2 = new UnsafeAllocator(declaredMethod3) {
                                /* class com.google.gson.internal.UnsafeAllocator.AnonymousClass3 */
                                public final /* synthetic */ Method val$newInstance;

                                {
                                    this.val$newInstance = r1;
                                }

                                @Override // com.google.gson.internal.UnsafeAllocator
                                public <T> T newInstance(Class<T> cls) throws Exception {
                                    UnsafeAllocator.assertInstantiable(cls);
                                    return (T) this.val$newInstance.invoke(null, cls, Object.class);
                                }
                            };
                        } catch (Exception unused3) {
                            unsafeAllocator2 = new UnsafeAllocator() {
                                /* class com.google.gson.internal.UnsafeAllocator.AnonymousClass4 */

                                @Override // com.google.gson.internal.UnsafeAllocator
                                public <T> T newInstance(Class<T> cls) {
                                    throw new UnsupportedOperationException("Cannot allocate " + cls);
                                }
                            };
                        }
                    }
                }
                this.unsafeAllocator = unsafeAllocator2;
            }

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                try {
                    return (T) this.unsafeAllocator.newInstance(cls);
                } catch (Exception e) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unable to invoke no-args constructor for ");
                    outline17.append(type);
                    outline17.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(outline17.toString(), e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
