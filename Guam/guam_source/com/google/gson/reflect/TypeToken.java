package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {
    public final int hashCode;
    public final Class<? super T> rawType;
    public final Type type;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type canonicalize = C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.type = canonicalize;
            this.rawType = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
            this.hashCode = this.type.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj).type);
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public TypeToken(Type type2) {
        if (type2 != null) {
            Type canonicalize = C$Gson$Types.canonicalize(type2);
            this.type = canonicalize;
            this.rawType = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
            this.hashCode = this.type.hashCode();
            return;
        }
        throw null;
    }
}
