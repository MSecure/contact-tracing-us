package com.google.gson.internal.bind;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    public final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.rawType.getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor2, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> typeAdapter;
        Object construct = constructorConstructor2.get(new TypeToken(jsonAdapter.value())).construct();
        if (construct instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            typeAdapter = ((TypeAdapterFactory) construct).create(gson, typeToken);
        } else {
            boolean z = construct instanceof JsonSerializer;
            if (z || (construct instanceof JsonDeserializer)) {
                JsonDeserializer jsonDeserializer = null;
                JsonSerializer jsonSerializer = z ? (JsonSerializer) construct : null;
                if (construct instanceof JsonDeserializer) {
                    jsonDeserializer = (JsonDeserializer) construct;
                }
                typeAdapter = new TreeTypeAdapter<>(jsonSerializer, jsonDeserializer, gson, typeToken, null);
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Invalid attempt to bind an instance of ");
                outline17.append(construct.getClass().getName());
                outline17.append(" as a @JsonAdapter for ");
                outline17.append(typeToken.toString());
                outline17.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        return (typeAdapter == null || !jsonAdapter.nullSafe()) ? typeAdapter : 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: RETURN  
              (wrap: com.google.gson.TypeAdapter<?> : ?: TERNARYnull = (((r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) == (null com.google.gson.TypeAdapter<?>) || (wrap: boolean : 0x0074: INVOKE  (r10v1 boolean) = (r12v0 'jsonAdapter' com.google.gson.annotations.JsonAdapter) type: INTERFACE call: com.google.gson.annotations.JsonAdapter.nullSafe():boolean) == false)) ? (r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) : (wrap: com.google.gson.TypeAdapter$1 : 0x007c: CONSTRUCTOR  (r10v2 com.google.gson.TypeAdapter$1) = (r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR))
             in method: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken<?>, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter<?>, file: classes.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: TERNARYnull = (((r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) == (null com.google.gson.TypeAdapter<?>) || (wrap: boolean : 0x0074: INVOKE  (r10v1 boolean) = (r12v0 'jsonAdapter' com.google.gson.annotations.JsonAdapter) type: INTERFACE call: com.google.gson.annotations.JsonAdapter.nullSafe():boolean) == false)) ? (r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) : (wrap: com.google.gson.TypeAdapter$1 : 0x007c: CONSTRUCTOR  (r10v2 com.google.gson.TypeAdapter$1) = (r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR) in method: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken<?>, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter<?>, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:313)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007c: CONSTRUCTOR  (r10v2 com.google.gson.TypeAdapter$1) = (r9v3 'typeAdapter' com.google.gson.TypeAdapter<?>) call: com.google.gson.TypeAdapter.1.<init>(com.google.gson.TypeAdapter):void type: CONSTRUCTOR in method: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken<?>, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter<?>, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:854)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:477)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.gson.TypeAdapter, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 23 more
            */
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter");
    }
}
