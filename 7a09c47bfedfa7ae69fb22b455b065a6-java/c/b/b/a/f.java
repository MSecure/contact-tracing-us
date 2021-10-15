package c.b.b.a;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f extends d implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f4657b;

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Matcher f4658a;

        public a(Matcher matcher) {
            if (matcher != null) {
                this.f4658a = matcher;
                return;
            }
            throw null;
        }
    }

    public f(Pattern pattern) {
        if (pattern != null) {
            this.f4657b = pattern;
            return;
        }
        throw null;
    }

    public String toString() {
        return this.f4657b.toString();
    }
}
