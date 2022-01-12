package retrofit2;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Headers;
import okhttp3.MediaType;
import retrofit2.ParameterHandler;
import retrofit2.RequestFactory;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public abstract class ServiceMethod<T> {
    /* JADX WARNING: Removed duplicated region for block: B:305:0x07b9  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x07bd A[SYNTHETIC] */
    public static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        Type type;
        boolean z;
        String str;
        int i;
        int i2;
        ParameterHandler<?> parameterHandler;
        Type type2;
        int i3;
        String str2;
        Type type3;
        ParameterHandler<?> parameterHandler2;
        ParameterHandler<?> parameterHandler3;
        ParameterHandler<?> parameterHandler4;
        ParameterHandler<?> body;
        ParameterHandler<?> parameterHandler5;
        ParameterHandler<?> r3;
        String str3;
        RequestFactory.Builder builder = new RequestFactory.Builder(retrofit, method);
        Annotation[] annotationArr = builder.methodAnnotations;
        int length = annotationArr.length;
        int i4 = 0;
        int i5 = 0;
        loop0:
        while (true) {
            String str4 = "HEAD";
            int i6 = 1;
            if (i5 < length) {
                Annotation annotation = annotationArr[i5];
                if (annotation instanceof DELETE) {
                    builder.parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
                } else if (annotation instanceof GET) {
                    builder.parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
                } else if (annotation instanceof HEAD) {
                    builder.parseHttpMethodAndPath(str4, ((HEAD) annotation).value(), false);
                } else if (annotation instanceof PATCH) {
                    builder.parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
                } else if (annotation instanceof POST) {
                    builder.parseHttpMethodAndPath(RNCWebViewManager.HTTP_METHOD_POST, ((POST) annotation).value(), true);
                } else if (annotation instanceof PUT) {
                    builder.parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
                } else if (annotation instanceof OPTIONS) {
                    builder.parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
                } else if (annotation instanceof HTTP) {
                    HTTP http = (HTTP) annotation;
                    builder.parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
                } else if (annotation instanceof Headers) {
                    String[] value = ((Headers) annotation).value();
                    if (value.length != 0) {
                        Headers.Builder builder2 = new Headers.Builder();
                        int length2 = value.length;
                        for (int i7 = 0; i7 < length2; i7++) {
                            str3 = value[i7];
                            int indexOf = str3.indexOf(58);
                            if (indexOf != -1 && indexOf != 0 && indexOf != str3.length() - 1) {
                                String substring = str3.substring(0, indexOf);
                                String trim = str3.substring(indexOf + 1).trim();
                                if ("Content-Type".equalsIgnoreCase(substring)) {
                                    try {
                                        builder.contentType = MediaType.get(trim);
                                    } catch (IllegalArgumentException e) {
                                        throw Utils.methodError(builder.method, e, "Malformed content type: %s", trim);
                                    }
                                } else {
                                    builder2.add(substring, trim);
                                }
                            }
                        }
                        builder.headers = builder2.build();
                    } else {
                        throw Utils.methodError(builder.method, "@Headers annotation is empty.", new Object[0]);
                    }
                } else if (!(annotation instanceof FormUrlEncoded)) {
                    continue;
                } else if (!builder.isMultipart) {
                    builder.isFormEncoded = true;
                } else {
                    throw Utils.methodError(builder.method, "Only one encoding annotation is allowed.", new Object[0]);
                }
                i5++;
            } else if (builder.httpMethod != null) {
                if (!builder.hasBody) {
                    if (builder.isMultipart) {
                        throw Utils.methodError(builder.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (builder.isFormEncoded) {
                        throw Utils.methodError(builder.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length3 = builder.parameterAnnotationsArray.length;
                builder.parameterHandlers = new ParameterHandler[length3];
                int i8 = length3 - 1;
                int i9 = 0;
                while (i4 < length3) {
                    ParameterHandler<?>[] parameterHandlerArr = builder.parameterHandlers;
                    Type type4 = builder.parameterTypes[i4];
                    Annotation[] annotationArr2 = builder.parameterAnnotationsArray[i4];
                    if (i4 != i8) {
                        i6 = i9;
                    }
                    if (annotationArr2 != null) {
                        int length4 = annotationArr2.length;
                        parameterHandler = null;
                        while (i9 < length4) {
                            Annotation annotation2 = annotationArr2[i9];
                            if (annotation2 instanceof Path) {
                                builder.validateResolvableType(i4, type4);
                                if (builder.gotQuery) {
                                    throw Utils.parameterError(builder.method, i4, "A @Path parameter must not come after a @Query.", new Object[0]);
                                } else if (builder.gotQueryName) {
                                    throw Utils.parameterError(builder.method, i4, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                                } else if (builder.gotQueryMap) {
                                    throw Utils.parameterError(builder.method, i4, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                                } else if (builder.gotUrl) {
                                    throw Utils.parameterError(builder.method, i4, "@Path parameters may not be used with @Url.", new Object[0]);
                                } else if (builder.relativeUrl != null) {
                                    builder.gotPath = true;
                                    Path path = (Path) annotation2;
                                    String value2 = path.value();
                                    if (!RequestFactory.Builder.PARAM_NAME_REGEX.matcher(value2).matches()) {
                                        throw Utils.parameterError(builder.method, i4, "@Path parameter name must match %s. Found: %s", RequestFactory.Builder.PARAM_URL_REGEX.pattern(), value2);
                                    } else if (builder.relativeUrlParamNames.contains(value2)) {
                                        i3 = length4;
                                        parameterHandler3 = new ParameterHandler.Path<>(builder.method, i4, value2, builder.retrofit.stringConverter(type4, annotationArr2), path.encoded());
                                        annotationArr2 = annotationArr2;
                                        type3 = type4;
                                        parameterHandler2 = parameterHandler3;
                                    } else {
                                        throw Utils.parameterError(builder.method, i4, "URL \"%s\" does not contain \"{%s}\".", builder.relativeUrl, value2);
                                    }
                                } else {
                                    throw Utils.parameterError(builder.method, i4, "@Path can only be used with relative url on @%s", builder.httpMethod);
                                }
                            } else {
                                i3 = length4;
                                type3 = type4;
                                if (annotation2 instanceof Query) {
                                    builder.validateResolvableType(i4, type3);
                                    Query query = (Query) annotation2;
                                    String value3 = query.value();
                                    boolean encoded = query.encoded();
                                    Class<?> rawType = Utils.getRawType(type3);
                                    builder.gotQuery = true;
                                    if (Iterable.class.isAssignableFrom(rawType)) {
                                        if (type3 instanceof ParameterizedType) {
                                            parameterHandler4 = 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x028c: CONSTRUCTOR  (r3v85 'parameterHandler4' retrofit2.ParameterHandler<?>) = 
                                                  (wrap: retrofit2.ParameterHandler$Query : 0x0287: CONSTRUCTOR  (r10v17 retrofit2.ParameterHandler$Query) = 
                                                  (r3v83 'value3' java.lang.String)
                                                  (wrap: retrofit2.Converter<T, java.lang.String> : 0x0281: INVOKE  (r4v74 retrofit2.Converter<T, java.lang.String>) = 
                                                  (wrap: retrofit2.Retrofit : 0x027f: IGET  (r10v16 retrofit2.Retrofit) = (r2v0 'builder' retrofit2.RequestFactory$Builder) retrofit2.RequestFactory.Builder.retrofit retrofit2.Retrofit)
                                                  (wrap: java.lang.reflect.Type : 0x027b: INVOKE  (r4v73 java.lang.reflect.Type) = 
                                                  (0 int)
                                                  (wrap: java.lang.reflect.ParameterizedType : 0x0278: CHECK_CAST (r14v15 java.lang.reflect.ParameterizedType) = (java.lang.reflect.ParameterizedType) (r12v9 'type3' java.lang.reflect.Type))
                                                 type: STATIC call: retrofit2.Utils.getParameterUpperBound(int, java.lang.reflect.ParameterizedType):java.lang.reflect.Type)
                                                  (r13v1 'annotationArr2' java.lang.annotation.Annotation[])
                                                 type: VIRTUAL call: retrofit2.Retrofit.stringConverter(java.lang.reflect.Type, java.lang.annotation.Annotation[]):retrofit2.Converter)
                                                  (r9v42 'encoded' boolean)
                                                 call: retrofit2.ParameterHandler.Query.<init>(java.lang.String, retrofit2.Converter, boolean):void type: CONSTRUCTOR)
                                                 call: retrofit2.ParameterHandler.1.<init>(retrofit2.ParameterHandler):void type: CONSTRUCTOR in method: retrofit2.ServiceMethod.parseAnnotations(retrofit2.Retrofit, java.lang.reflect.Method):retrofit2.ServiceMethod<T>, file: classes.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:194)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: retrofit2.ParameterHandler, state: GENERATED_AND_UNLOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 61 more
                                                */
                                            /* JADX WARNING: Removed duplicated region for block: B:305:0x07b9  */
                                            /* JADX WARNING: Removed duplicated region for block: B:471:0x07bd A[SYNTHETIC] */
                                            /*
                                            // Method dump skipped, instructions count: 2496
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.parseAnnotations(retrofit2.Retrofit, java.lang.reflect.Method):retrofit2.ServiceMethod");
                                        }
                                    }
