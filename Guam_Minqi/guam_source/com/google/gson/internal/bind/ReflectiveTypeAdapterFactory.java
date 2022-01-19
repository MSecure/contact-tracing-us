package com.google.gson.internal.bind;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final ReflectionAccessor accessor = ReflectionAccessor.instance;
    public final ConstructorConstructor constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingStrategy fieldNamingPolicy;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public static final class Adapter<T> extends TypeAdapter<T> {
        public final Map<String, BoundField> boundFields;
        public final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null) {
                        if (boundField.deserialized) {
                            AnonymousClass1 r1 = (AnonymousClass1) boundField;
                            Object read = r0.read(jsonReader);
                            if (read != null || !r25) {
                                r26.set(construct, read);
                            }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.google.gson.TypeAdapter] */
        /* JADX WARN: Type inference failed for: r1v8, types: [com.google.gson.TypeAdapter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper;
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    AnonymousClass1 r2 = (AnonymousClass1) boundField;
                    boolean z = false;
                    if (r2.serialized) {
                        if (r26.get(t) != t) {
                            z = true;
                        }
                    }
                    if (z) {
                        jsonWriter.name(boundField.name);
                        AnonymousClass1 r1 = (AnonymousClass1) boundField;
                        Object obj = r26.get(t);
                        if (r27) {
                            typeAdapterRuntimeTypeWrapper = r0;
                        } else {
                            typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(r35, r0, r9.type);
                        }
                        typeAdapterRuntimeTypeWrapper.write(jsonWriter, obj);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static abstract class BoundField {
        public final boolean deserialized;
        public final String name;
        public final boolean serialized;

        public BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x019f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0184 A[SYNTHETIC] */
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, TypeToken<T> typeToken) {
        Adapter adapter;
        Class<? super T> cls;
        Adapter adapter2;
        TypeToken<T> typeToken2;
        Field[] fieldArr;
        boolean z;
        ObjectConstructor<T> objectConstructor;
        Class<? super T> cls2;
        int i;
        int i2;
        Type type;
        LinkedHashMap linkedHashMap;
        boolean z2;
        ArrayList arrayList;
        int size;
        BoundField boundField;
        int i3;
        final Field field;
        final TypeAdapter<?> typeAdapter;
        List list;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Gson gson2 = gson;
        Class<? super T> cls3 = Object.class;
        Class<? super T> cls4 = typeToken.rawType;
        if (!cls3.isAssignableFrom(cls4)) {
            return null;
        }
        ObjectConstructor<T> objectConstructor2 = reflectiveTypeAdapterFactory.constructorConstructor.get(typeToken);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (!cls4.isInterface()) {
            Type type2 = typeToken.type;
            TypeToken<T> typeToken3 = typeToken;
            Class<? super T> cls5 = cls4;
            while (cls5 != cls3) {
                Field[] declaredFields = cls5.getDeclaredFields();
                int length = declaredFields.length;
                boolean z3 = false;
                int i4 = 0;
                while (i4 < length) {
                    Field field2 = declaredFields[i4];
                    boolean excludeField = reflectiveTypeAdapterFactory.excludeField(field2, true);
                    boolean excludeField2 = reflectiveTypeAdapterFactory.excludeField(field2, z3);
                    if (excludeField || excludeField2) {
                        reflectiveTypeAdapterFactory.accessor.makeAccessible(field2);
                        Type resolve = C$Gson$Types.resolve(typeToken3.type, cls5, field2.getGenericType());
                        SerializedName serializedName = (SerializedName) field2.getAnnotation(SerializedName.class);
                        if (serializedName == null) {
                            list = Collections.singletonList(reflectiveTypeAdapterFactory.fieldNamingPolicy.translateName(field2));
                            i2 = i4;
                        } else {
                            String value = serializedName.value();
                            String[] alternate = serializedName.alternate();
                            i2 = i4;
                            if (alternate.length == 0) {
                                list = Collections.singletonList(value);
                            } else {
                                i = length;
                                z2 = true;
                                ArrayList arrayList2 = new ArrayList(alternate.length + 1);
                                arrayList2.add(value);
                                int i5 = 0;
                                for (int length2 = alternate.length; i5 < length2; length2 = length2) {
                                    arrayList2.add(alternate[i5]);
                                    i5++;
                                }
                                arrayList = arrayList2;
                                size = arrayList.size();
                                boundField = null;
                                i3 = 0;
                                while (i3 < size) {
                                    String str = (String) arrayList.get(i3);
                                    if (i3 != 0) {
                                        excludeField = false;
                                    }
                                    final TypeToken<T> typeToken4 = new TypeToken<>(resolve);
                                    Class<? super T> cls6 = typeToken4.rawType;
                                    final boolean z4 = (!(cls6 instanceof Class) || !cls6.isPrimitive()) ? false : z2;
                                    JsonAdapter jsonAdapter = (JsonAdapter) field2.getAnnotation(JsonAdapter.class);
                                    if (jsonAdapter != null) {
                                        field = field2;
                                        typeAdapter = reflectiveTypeAdapterFactory.jsonAdapterFactory.getTypeAdapter(reflectiveTypeAdapterFactory.constructorConstructor, gson2, typeToken4, jsonAdapter);
                                    } else {
                                        field = field2;
                                        typeAdapter = null;
                                    }
                                    final boolean z5 = typeAdapter != null ? z2 : false;
                                    if (typeAdapter == null) {
                                        typeAdapter = gson2.getAdapter(typeToken4);
                                    }
                                    boundField = (BoundField) linkedHashMap2.put(str, new BoundField(this, str, excludeField, excludeField2) {
                                        /* class com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.AnonymousClass1 */
                                    });
                                    if (boundField != null) {
                                        boundField = boundField;
                                    }
                                    i3++;
                                    reflectiveTypeAdapterFactory = this;
                                    gson2 = gson;
                                    cls5 = cls5;
                                    linkedHashMap2 = linkedHashMap2;
                                    type2 = type2;
                                    cls3 = cls3;
                                    field2 = field;
                                    size = size;
                                    resolve = resolve;
                                    objectConstructor2 = objectConstructor2;
                                    arrayList = arrayList;
                                    declaredFields = declaredFields;
                                    typeToken3 = typeToken3;
                                    adapter = adapter;
                                }
                                fieldArr = declaredFields;
                                cls = cls5;
                                typeToken2 = typeToken3;
                                linkedHashMap = linkedHashMap2;
                                adapter2 = adapter;
                                cls2 = cls3;
                                objectConstructor = objectConstructor2;
                                z = false;
                                type = type2;
                                if (boundField == null) {
                                    throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                                }
                            }
                        }
                        i = length;
                        z2 = true;
                        arrayList = list;
                        size = arrayList.size();
                        boundField = null;
                        i3 = 0;
                        while (i3 < size) {
                        }
                        fieldArr = declaredFields;
                        cls = cls5;
                        typeToken2 = typeToken3;
                        linkedHashMap = linkedHashMap2;
                        adapter2 = adapter;
                        cls2 = cls3;
                        objectConstructor = objectConstructor2;
                        z = false;
                        type = type2;
                        if (boundField == null) {
                        }
                    } else {
                        i2 = i4;
                        z = z3;
                        i = length;
                        fieldArr = declaredFields;
                        cls = cls5;
                        typeToken2 = typeToken3;
                        linkedHashMap = linkedHashMap2;
                        adapter2 = adapter;
                        cls2 = cls3;
                        objectConstructor = objectConstructor2;
                        type = type2;
                    }
                    i4 = i2 + 1;
                    reflectiveTypeAdapterFactory = this;
                    gson2 = gson;
                    cls5 = cls;
                    linkedHashMap2 = linkedHashMap;
                    type2 = type;
                    length = i;
                    cls3 = cls2;
                    objectConstructor2 = objectConstructor;
                    z3 = z;
                    declaredFields = fieldArr;
                    typeToken3 = typeToken2;
                    adapter = adapter2;
                }
                typeToken3 = new TypeToken<>(C$Gson$Types.resolve(typeToken3.type, cls5, cls5.getGenericSuperclass()));
                cls5 = typeToken3.rawType;
                reflectiveTypeAdapterFactory = this;
                gson2 = gson;
                objectConstructor2 = objectConstructor2;
            }
        }
        return new Adapter(objectConstructor2, linkedHashMap2);
    }

    public boolean excludeField(Field field, boolean z) {
        boolean z2;
        Excluder excluder2 = this.excluder;
        Class<?> type = field.getType();
        if (excluder2.excludeClassChecks(type) || excluder2.excludeClassInStrategy(type, z)) {
            return false;
        }
        if ((excluder2.modifiers & field.getModifiers()) == 0 && ((excluder2.version == -1.0d || excluder2.isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic() && ((excluder2.serializeInnerClasses || !excluder2.isInnerClass(field.getType())) && !excluder2.isAnonymousOrLocal(field.getType())))) {
            List<ExclusionStrategy> list = z ? excluder2.serializationStrategies : excluder2.deserializationStrategies;
            if (!list.isEmpty()) {
                FieldAttributes fieldAttributes = new FieldAttributes(field);
                Iterator<ExclusionStrategy> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().shouldSkipField(fieldAttributes)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        return !z2;
    }
}
