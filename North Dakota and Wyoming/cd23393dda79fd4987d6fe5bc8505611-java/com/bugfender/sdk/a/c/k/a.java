package com.bugfender.sdk.a.c.k;

public class a<T> {
    public static final a<String> c = new a<>(EnumC0020a.NAME, "android.widget.Button");
    public static final a<String> d = new a<>(EnumC0020a.NAME, "androidx.appcompat.widget.AppCompatButton");
    public EnumC0020a a;
    public T b;

    /* renamed from: com.bugfender.sdk.a.c.k.a$a  reason: collision with other inner class name */
    public enum EnumC0020a {
        NONE,
        NAME
    }

    public a(EnumC0020a aVar, T t) {
        this.a = aVar;
        this.b = t;
    }

    public T a() {
        return this.b;
    }

    public EnumC0020a b() {
        return this.a;
    }
}
