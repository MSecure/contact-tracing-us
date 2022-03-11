package f.b.f.a.k;

import f.b.f.a.i;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public final class a {
    public final b a = new b(100);

    public boolean a(CharSequence charSequence, i iVar, boolean z) {
        String str = iVar.c;
        if (str.length() == 0) {
            return false;
        }
        Matcher matcher = this.a.a(str).matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        if (matcher.matches()) {
            z = true;
        }
        return z;
    }
}
