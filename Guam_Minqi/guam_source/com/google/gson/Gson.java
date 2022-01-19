package com.google.gson;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class Gson {
    public static final TypeToken<?> NULL_KEY_SURROGATE = new TypeToken<>(Object.class);
    public final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls = new ThreadLocal<>();
    public final ConstructorConstructor constructorConstructor;
    public final Excluder excluder;
    public final List<TypeAdapterFactory> factories;
    public final boolean generateNonExecutableJson;
    public final boolean htmlSafe;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final boolean lenient;
    public final boolean prettyPrinting;
    public final boolean serializeNulls;
    public final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache = new ConcurrentHashMap();

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        public TypeAdapter<T> delegate;

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                typeAdapter.write(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public Gson() {
        final TypeAdapter typeAdapter;
        Excluder excluder2 = Excluder.DEFAULT;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        Map emptyMap = Collections.emptyMap();
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        Collections.emptyList();
        Collections.emptyList();
        List emptyList = Collections.emptyList();
        this.excluder = excluder2;
        this.constructorConstructor = new ConstructorConstructor(emptyMap);
        this.serializeNulls = false;
        this.generateNonExecutableJson = false;
        this.htmlSafe = true;
        this.prettyPrinting = false;
        this.lenient = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder2);
        arrayList.addAll(emptyList);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            typeAdapter = TypeAdapters.LONG;
        } else {
            typeAdapter = new TypeAdapter<Number>() {
                /* class com.google.gson.Gson.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.google.gson.TypeAdapter
                public Number read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.peek() != JsonToken.NULL) {
                        return Long.valueOf(jsonReader.nextLong());
                    }
                    jsonReader.nextNull();
                    return null;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.nullValue();
                    } else {
                        jsonWriter.value(number2.toString());
                    }
                }
            };
        }
        arrayList.add(new TypeAdapterFactory(Long.TYPE, Long.class, typeAdapter) {
            /* class com.google.gson.internal.bind.TypeAdapters.AnonymousClass33 */

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> cls = typeToken.rawType;
                if (cls == r0 || cls == Character.class) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Factory[type=");
                outline15.append(Character.class.getName());
                outline15.append("+");
                outline15.append(r0.getName());
                outline15.append(",adapter=");
                outline15.append(r2);
                outline15.append("]");
                return outline15.toString();
            }
        });
        arrayList.add(new TypeAdapterFactory(Double.TYPE, Double.class, new TypeAdapter<Number>(this) {
            /* class com.google.gson.Gson.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    jsonWriter.nullValue();
                    return;
                }
                Gson.checkValidFloatingPoint(number2.doubleValue());
                jsonWriter.value(number2);
            }
        }) {
            /* class com.google.gson.internal.bind.TypeAdapters.AnonymousClass33 */

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> cls = typeToken.rawType;
                if (cls == r0 || cls == Character.class) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Factory[type=");
                outline15.append(Character.class.getName());
                outline15.append("+");
                outline15.append(r0.getName());
                outline15.append(",adapter=");
                outline15.append(r2);
                outline15.append("]");
                return outline15.toString();
            }
        });
        arrayList.add(new TypeAdapterFactory(Float.TYPE, Float.class, new TypeAdapter<Number>(this) {
            /* class com.google.gson.Gson.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                Number number2 = number;
                if (number2 == null) {
                    jsonWriter.nullValue();
                    return;
                }
                Gson.checkValidFloatingPoint((double) number2.floatValue());
                jsonWriter.value(number2);
            }
        }) {
            /* class com.google.gson.internal.bind.TypeAdapters.AnonymousClass33 */

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> cls = typeToken.rawType;
                if (cls == r0 || cls == Character.class) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Factory[type=");
                outline15.append(Character.class.getName());
                outline15.append("+");
                outline15.append(r0.getName());
                outline15.append(",adapter=");
                outline15.append(r2);
                outline15.append("]");
                return outline15.toString();
            }
        });
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(new TypeAdapterFactory(AtomicLong.class, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c2: INVOKE  
              (r5v4 'arrayList' java.util.ArrayList)
              (wrap: com.google.gson.internal.bind.TypeAdapters$32 : 0x00bf: CONSTRUCTOR  (r6v6 com.google.gson.internal.bind.TypeAdapters$32) = 
              (wrap: java.lang.Class : 0x00b1: CONST_CLASS   java.util.concurrent.atomic.AtomicLong.class)
              (wrap: com.google.gson.TypeAdapter$1 : 0x00ba: CONSTRUCTOR  (r7v3 com.google.gson.TypeAdapter$1) = 
              (wrap: com.google.gson.Gson$4 : 0x00b5: CONSTRUCTOR  (r6v5 com.google.gson.Gson$4) = (r3v1 'typeAdapter' com.google.gson.TypeAdapter A[SKIP_ARG]) call: com.google.gson.Gson.4.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             call: com.google.gson.internal.bind.TypeAdapters.32.<init>(java.lang.Class, com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             type: VIRTUAL call: java.util.ArrayList.add(java.lang.Object):boolean in method: com.google.gson.Gson.<init>():void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bf: CONSTRUCTOR  (r6v6 com.google.gson.internal.bind.TypeAdapters$32) = 
              (wrap: java.lang.Class : 0x00b1: CONST_CLASS   java.util.concurrent.atomic.AtomicLong.class)
              (wrap: com.google.gson.TypeAdapter$1 : 0x00ba: CONSTRUCTOR  (r7v3 com.google.gson.TypeAdapter$1) = 
              (wrap: com.google.gson.Gson$4 : 0x00b5: CONSTRUCTOR  (r6v5 com.google.gson.Gson$4) = (r3v1 'typeAdapter' com.google.gson.TypeAdapter A[SKIP_ARG]) call: com.google.gson.Gson.4.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             call: com.google.gson.internal.bind.TypeAdapters.32.<init>(java.lang.Class, com.google.gson.TypeAdapter):void type: CONSTRUCTOR in method: com.google.gson.Gson.<init>():void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ba: CONSTRUCTOR  (r7v3 com.google.gson.TypeAdapter$1) = 
              (wrap: com.google.gson.Gson$4 : 0x00b5: CONSTRUCTOR  (r6v5 com.google.gson.Gson$4) = (r3v1 'typeAdapter' com.google.gson.TypeAdapter A[SKIP_ARG]) call: com.google.gson.Gson.4.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR)
             call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR in method: com.google.gson.Gson.<init>():void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:697)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:631)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.gson.TypeAdapter, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 27 more
            */
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.<init>():void");
    }

    public static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        T t;
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        boolean z = this.lenient;
        jsonReader.lenient = z;
        boolean z2 = true;
        jsonReader.lenient = true;
        try {
            jsonReader.peek();
            z2 = false;
            t = getAdapter(new TypeToken<>(type)).read(jsonReader);
        } catch (EOFException e) {
            if (z2) {
                t = null;
            } else {
                throw new JsonSyntaxException(e);
            }
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonSyntaxException(e3);
        } catch (AssertionError e4) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e4.getMessage());
            assertionError.initCause(e4);
            throw assertionError;
        } catch (Throwable th) {
            jsonReader.lenient = z;
            throw th;
        }
        jsonReader.lenient = z;
        if (t != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e5) {
                throw new JsonSyntaxException(e5);
            } catch (IOException e6) {
                throw new JsonIOException(e6);
            }
        }
        return t;
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.typeTokenCache.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.calls.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.calls.set(map);
            z = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            for (TypeAdapterFactory typeAdapterFactory : this.factories) {
                TypeAdapter<T> create = typeAdapterFactory.create(this, typeToken);
                if (create != null) {
                    if (futureTypeAdapter2.delegate == null) {
                        futureTypeAdapter2.delegate = create;
                        this.typeTokenCache.put(typeToken, create);
                        return create;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z) {
                this.calls.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.indent = "  ";
            jsonWriter.separator = ": ";
        }
        jsonWriter.serializeNulls = this.serializeNulls;
        return jsonWriter;
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = this.serializeNulls;
        try {
            TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (AssertionError e2) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
            assertionError.initCause(e2);
            throw assertionError;
        } catch (Throwable th) {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = getAdapter(new TypeToken(type));
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = this.serializeNulls;
        try {
            adapter.write(jsonWriter, obj);
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
        } catch (IOException e) {
            throw new JsonIOException(e);
        } catch (AssertionError e2) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
            assertionError.initCause(e2);
            throw assertionError;
        } catch (Throwable th) {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
            throw th;
        }
    }

    public String toJson(Object obj) {
        if (obj == null) {
            JsonElement jsonElement = JsonNull.INSTANCE;
            StringWriter stringWriter = new StringWriter();
            try {
                toJson(jsonElement, newJsonWriter(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } else {
            Type type = obj.getClass();
            StringWriter stringWriter2 = new StringWriter();
            try {
                toJson(obj, type, newJsonWriter(stringWriter2));
                return stringWriter2.toString();
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }
}
