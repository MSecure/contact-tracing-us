package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;

public abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final Method method;
        public final int p;

        public Body(Method method2, int i, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = i;
            this.converter = converter2;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.body = this.converter.convert(t);
                } catch (IOException e) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, e, i, "Unable to convert " + ((Object) t) + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                String str = this.name;
                if (this.encoded) {
                    requestBuilder.formBuilder.addEncoded(str, convert);
                } else {
                    requestBuilder.formBuilder.add(str, convert);
                }
            }
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;
        public final Converter<T, String> valueConverter;

        public FieldMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: retrofit2.Converter<T, java.lang.String> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.valueConverter.convert(value);
                            if (str2 == null) {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            } else if (this.encoded) {
                                requestBuilder.formBuilder.addEncoded(str, str2);
                            } else {
                                requestBuilder.formBuilder.add(str, str2);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline11("Field map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        public final String name;
        public final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                requestBuilder.addHeader(this.name, convert);
            }
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final Headers headers;
        public final Method method;
        public final int p;

        public Part(Method method2, int i, Headers headers2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.p = i;
            this.headers = headers2;
            this.converter = converter2;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    RequestBody convert = this.converter.convert(t);
                    requestBuilder.multipartBuilder.addPart(this.headers, convert);
                } catch (IOException e) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, i, "Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;
        public final int p;
        public final String transferEncoding;
        public final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method2, int i, Converter<T, RequestBody> converter, String str) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: retrofit2.Converter<T, okhttp3.RequestBody> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String[] strArr = {"Content-Disposition", GeneratedOutlineSupport.outline11("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.transferEncoding};
                            requestBuilder.multipartBuilder.addPart(Headers.of(strArr), (RequestBody) this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline11("Part map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Method method;
        public final String name;
        public final int p;
        public final Converter<T, String> valueConverter;

        public Path(Method method2, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String str;
            int i;
            if (t != null) {
                String str2 = this.name;
                String convert = this.valueConverter.convert(t);
                boolean z = this.encoded;
                if (requestBuilder.relativeUrl != null) {
                    int length = convert.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str = convert;
                            break;
                        }
                        int codePointAt = convert.codePointAt(i2);
                        i = 47;
                        if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                            Buffer buffer = new Buffer();
                            buffer.writeUtf8(convert, 0, i2);
                            Buffer buffer2 = null;
                        } else {
                            i2 += Character.charCount(codePointAt);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    buffer3.writeUtf8(convert, 0, i2);
                    Buffer buffer22 = null;
                    while (i2 < length) {
                        int codePointAt2 = convert.codePointAt(i2);
                        if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                            if (codePointAt2 < 32 || codePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt2) != -1 || (!z && (codePointAt2 == i || codePointAt2 == 37))) {
                                if (buffer22 == null) {
                                    buffer22 = new Buffer();
                                }
                                buffer22.writeUtf8CodePoint(codePointAt2);
                                while (!buffer22.exhausted()) {
                                    int readByte = buffer22.readByte() & 255;
                                    buffer3.writeByte(37);
                                    buffer3.writeByte((int) RequestBuilder.HEX_DIGITS[(readByte >> 4) & 15]);
                                    buffer3.writeByte((int) RequestBuilder.HEX_DIGITS[readByte & 15]);
                                }
                            } else {
                                buffer3.writeUtf8CodePoint(codePointAt2);
                            }
                        }
                        i2 += Character.charCount(codePointAt2);
                        i = 47;
                    }
                    str = buffer3.readUtf8();
                    String replace = requestBuilder.relativeUrl.replace("{" + str2 + "}", str);
                    if (!RequestBuilder.PATH_TRAVERSAL.matcher(replace).matches()) {
                        requestBuilder.relativeUrl = replace;
                        return;
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("@Path parameters shouldn't perform path traversal ('.' or '..'): ", convert));
                }
                throw new AssertionError();
            }
            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline14(GeneratedOutlineSupport.outline17("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;
        public final Converter<T, String> valueConverter;

        public QueryMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: retrofit2.Converter<T, java.lang.String> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str2 = (String) this.valueConverter.convert(value);
                            if (str2 != null) {
                                requestBuilder.addQueryParam(str, str2, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, GeneratedOutlineSupport.outline11("Query map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
            }
        }
    }

    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        public static final RawPart INSTANCE = new RawPart();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [retrofit2.RequestBuilder, java.lang.Object] */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                requestBuilder.multipartBuilder.addPart(part2);
            }
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;
}
