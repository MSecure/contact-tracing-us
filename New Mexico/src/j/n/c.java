package j.n;

import g.b.a.c.c.d;
import j.k.b.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class c implements Serializable {
    public final Pattern b;

    public c(String str) {
        e.c(str, "pattern");
        Pattern compile = Pattern.compile(str);
        e.b(compile, "Pattern.compile(pattern)");
        e.c(compile, "nativePattern");
        this.b = compile;
    }

    public final List<String> a(CharSequence charSequence, int i2) {
        e.c(charSequence, "input");
        int i3 = 0;
        if (i2 >= 0) {
            Matcher matcher = this.b.matcher(charSequence);
            if (!matcher.find() || i2 == 1) {
                return d.p(charSequence.toString());
            }
            int i4 = 10;
            if (i2 > 0 && i2 <= 10) {
                i4 = i2;
            }
            ArrayList arrayList = new ArrayList(i4);
            int i5 = i2 - 1;
            do {
                arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
                if (i5 >= 0 && arrayList.size() == i5) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // java.lang.Object
    public String toString() {
        String pattern = this.b.toString();
        e.b(pattern, "nativePattern.toString()");
        return pattern;
    }
}
