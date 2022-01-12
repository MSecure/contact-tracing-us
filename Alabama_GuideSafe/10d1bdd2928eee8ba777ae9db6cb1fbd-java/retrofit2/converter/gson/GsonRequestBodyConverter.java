package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

public final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    public static final Charset UTF_8 = Charset.forName(RNCWebViewManager.HTML_ENCODING);
    public final TypeAdapter<T> adapter;
    public final Gson gson;

    public GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // retrofit2.Converter
    public RequestBody convert(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  (r1v1 'newJsonWriter' com.google.gson.stream.JsonWriter) = 
              (wrap: com.google.gson.Gson : 0x0011: IGET  (r2v1 com.google.gson.Gson) = (r4v0 'this' retrofit2.converter.gson.GsonRequestBodyConverter<T> A[IMMUTABLE_TYPE, THIS]) retrofit2.converter.gson.GsonRequestBodyConverter.gson com.google.gson.Gson)
              (wrap: java.io.OutputStreamWriter : 0x000e: CONSTRUCTOR  (r1v0 java.io.OutputStreamWriter) = 
              (wrap: okio.Buffer$1 : 0x0009: CONSTRUCTOR  (r2v0 okio.Buffer$1) = (r0v0 'buffer' okio.Buffer) call: okio.Buffer.1.<init>(okio.Buffer):void type: CONSTRUCTOR)
              (wrap: java.nio.charset.Charset : 0x000c: SGET  (r3v0 java.nio.charset.Charset) =  retrofit2.converter.gson.GsonRequestBodyConverter.UTF_8 java.nio.charset.Charset)
             call: java.io.OutputStreamWriter.<init>(java.io.OutputStream, java.nio.charset.Charset):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.google.gson.Gson.newJsonWriter(java.io.Writer):com.google.gson.stream.JsonWriter in method: retrofit2.converter.gson.GsonRequestBodyConverter.convert(java.lang.Object):okhttp3.RequestBody, file: classes.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r1v0 java.io.OutputStreamWriter) = 
              (wrap: okio.Buffer$1 : 0x0009: CONSTRUCTOR  (r2v0 okio.Buffer$1) = (r0v0 'buffer' okio.Buffer) call: okio.Buffer.1.<init>(okio.Buffer):void type: CONSTRUCTOR)
              (wrap: java.nio.charset.Charset : 0x000c: SGET  (r3v0 java.nio.charset.Charset) =  retrofit2.converter.gson.GsonRequestBodyConverter.UTF_8 java.nio.charset.Charset)
             call: java.io.OutputStreamWriter.<init>(java.io.OutputStream, java.nio.charset.Charset):void type: CONSTRUCTOR in method: retrofit2.converter.gson.GsonRequestBodyConverter.convert(java.lang.Object):okhttp3.RequestBody, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: CONSTRUCTOR  (r2v0 okio.Buffer$1) = (r0v0 'buffer' okio.Buffer) call: okio.Buffer.1.<init>(okio.Buffer):void type: CONSTRUCTOR in method: retrofit2.converter.gson.GsonRequestBodyConverter.convert(java.lang.Object):okhttp3.RequestBody, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: okio.Buffer, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 26 more
            */
        /*
            this = this;
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
            okio.Buffer$1 r2 = new okio.Buffer$1
            r2.<init>()
            java.nio.charset.Charset r3 = retrofit2.converter.gson.GsonRequestBodyConverter.UTF_8
            r1.<init>(r2, r3)
            com.google.gson.Gson r2 = r4.gson
            com.google.gson.stream.JsonWriter r1 = r2.newJsonWriter(r1)
            com.google.gson.TypeAdapter<T> r2 = r4.adapter
            r2.write(r1, r5)
            r1.close()
            okhttp3.MediaType r5 = retrofit2.converter.gson.GsonRequestBodyConverter.MEDIA_TYPE
            okio.ByteString r0 = r0.readByteString()
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.converter.gson.GsonRequestBodyConverter.convert(java.lang.Object):java.lang.Object");
    }
}
