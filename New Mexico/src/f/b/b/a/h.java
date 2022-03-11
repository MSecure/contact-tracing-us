package f.b.b.a;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class h extends f implements Serializable {
    public final Pattern b;

    /* loaded from: classes.dex */
    public static final class a extends e {
        public final Matcher a;

        public a(Matcher matcher) {
            Objects.requireNonNull(matcher);
            this.a = matcher;
        }
    }

    public h(Pattern pattern) {
        Objects.requireNonNull(pattern);
        this.b = pattern;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.b.toString();
    }
}
