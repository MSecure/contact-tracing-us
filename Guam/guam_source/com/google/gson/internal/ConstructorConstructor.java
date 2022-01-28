package com.google.gson.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
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
                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Failed to invoke ");
                        outline15.append(declaredConstructor);
                        outline15.append(" with no args");
                        throw new RuntimeException(outline15.toString(), e);
                    } catch (InvocationTargetException e2) {
                        StringBuilder outline152 = GeneratedOutlineSupport.outline15("Failed to invoke ");
                        outline152.append(declaredConstructor);
                        outline152.append(" with no args");
                        throw new RuntimeException(outline152.toString(), e2.getTargetException());
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
                            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Invalid EnumSet type: ");
                            outline15.append(type.toString());
                            throw new JsonIOException(outline15.toString());
                        }
                        StringBuilder outline152 = GeneratedOutlineSupport.outline15("Invalid EnumSet type: ");
                        outline152.append(type.toString());
                        throw new JsonIOException(outline152.toString());
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
                        unsafeAllocator2 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: CONSTRUCTOR  (r3v6 'unsafeAllocator2' com.google.gson.internal.UnsafeAllocator) = (r2v4 'declaredMethod2' java.lang.reflect.Method), (r8v5 'intValue' int) call: com.google.gson.internal.UnsafeAllocator.2.<init>(java.lang.reflect.Method, int):void type: CONSTRUCTOR in method: com.google.gson.internal.ConstructorConstructor.14.<init>(com.google.gson.internal.ConstructorConstructor, java.lang.Class, java.lang.reflect.Type):void, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:362)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.gson.internal.UnsafeAllocator, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 25 more
                            */
                        /*
                        // Method dump skipped, instructions count: 141
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.AnonymousClass14.<init>(com.google.gson.internal.ConstructorConstructor, java.lang.Class, java.lang.reflect.Type):void");
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        try {
                            return (T) this.unsafeAllocator.newInstance(cls);
                        } catch (Exception e) {
                            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unable to invoke no-args constructor for ");
                            outline15.append(type);
                            outline15.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
                            throw new RuntimeException(outline15.toString(), e);
                        }
                    }
                };
            }

            public String toString() {
                return this.instanceCreators.toString();
            }
        }
