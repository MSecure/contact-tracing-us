package c.b.b.a;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f extends d implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f3320b;

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Matcher f3321a;

        public a(Matcher matcher) {
            if (matcher != null) {
                this.f3321a = matcher;
                return;
            }
            throw null;
        }
    }

    public f(Pattern pattern) {
        if (pattern != null) {
            this.f3320b = pattern;
            return;
        }
        throw null;
    }

    public String toString() {
        return this.f3320b.toString();
    }
}
