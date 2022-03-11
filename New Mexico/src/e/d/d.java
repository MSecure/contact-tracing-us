package e.d;

import java.util.Arrays;
/* loaded from: classes.dex */
public class d {
    public final int a;
    public final CharSequence b;

    public d(int i2, CharSequence charSequence) {
        this.a = i2;
        this.b = charSequence;
    }

    public static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a != dVar.a) {
            return false;
        }
        CharSequence charSequence = dVar.b;
        String a = a(this.b);
        String a2 = a(charSequence);
        return (a == null && a2 == null) || (a != null && a.equals(a2));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), a(this.b)});
    }
}
