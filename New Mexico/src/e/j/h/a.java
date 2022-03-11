package e.j.h;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import e.j.h.d;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final c f1599d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1600e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    public static final String f1601f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    public static final a f1602g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f1603h;
    public final boolean a;
    public final int b;
    public final c c;

    /* renamed from: e.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0039a {

        /* renamed from: e  reason: collision with root package name */
        public static final byte[] f1604e = new byte[1792];
        public final CharSequence a;
        public final int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public char f1605d;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f1604e[i2] = Character.getDirectionality(i2);
            }
        }

        public C0039a(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = charSequence.length();
        }

        public byte a() {
            char charAt = this.a.charAt(this.c - 1);
            this.f1605d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.c);
                this.c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.c--;
            char c = this.f1605d;
            return c < 1792 ? f1604e[c] : Character.getDirectionality(c);
        }
    }

    static {
        c cVar = d.c;
        f1599d = cVar;
        f1602g = new a(false, 2, cVar);
        f1603h = new a(true, 2, cVar);
    }

    public a(boolean z, int i2, c cVar) {
        this.a = z;
        this.b = i2;
        this.c = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r3 != 0) goto L_0x0073;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r4 == 0) goto L_0x0077;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r0.c <= 0) goto L_0x0091;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        switch(r0.a()) {
            case 14: goto L_0x008a;
            case 15: goto L_0x008a;
            case 16: goto L_0x0086;
            case 17: goto L_0x0086;
            case 18: goto L_0x0083;
            default: goto L_0x0082;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int a(CharSequence charSequence) {
        byte b;
        C0039a aVar = new C0039a(charSequence, false);
        aVar.c = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = aVar.c;
            if (i5 < aVar.b && i2 == 0) {
                char charAt = aVar.a.charAt(i5);
                aVar.f1605d = charAt;
                if (Character.isHighSurrogate(charAt)) {
                    int codePointAt = Character.codePointAt(aVar.a, aVar.c);
                    aVar.c = Character.charCount(codePointAt) + aVar.c;
                    b = Character.getDirectionality(codePointAt);
                } else {
                    aVar.c++;
                    char c = aVar.f1605d;
                    b = c < 1792 ? C0039a.f1604e[c] : Character.getDirectionality(c);
                }
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i4 == 0) {
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                break;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                break;
                            case 18:
                                i4--;
                                i3 = 0;
                                break;
                        }
                    }
                } else if (i4 == 0) {
                }
                i2 = i4;
            }
        }
        return -1;
    }

    public static int b(CharSequence charSequence) {
        C0039a aVar = new C0039a(charSequence, false);
        aVar.c = aVar.b;
        int i2 = 0;
        int i3 = 0;
        while (aVar.c > 0) {
            byte a = aVar.a();
            if (a != 0) {
                if (a == 1 || a == 2) {
                    if (i2 == 0) {
                        return 1;
                    }
                    if (i3 == 0) {
                        i3 = i2;
                    }
                } else if (a != 9) {
                    switch (a) {
                        case 14:
                        case 15:
                            if (i3 == i2) {
                                return -1;
                            }
                            i2--;
                            break;
                        case 16:
                        case 17:
                            if (i3 == i2) {
                                return 1;
                            }
                            i2--;
                            break;
                        case 18:
                            i2++;
                            break;
                        default:
                            if (i3 != 0) {
                                break;
                            } else {
                                i3 = i2;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else if (i2 == 0) {
                return -1;
            } else {
                if (i3 == 0) {
                    i3 = i2;
                }
            }
        }
        return 0;
    }

    public static a c() {
        Locale locale = Locale.getDefault();
        Locale locale2 = e.a;
        boolean z = true;
        if (TextUtils.getLayoutDirectionFromLocale(locale) != 1) {
            z = false;
        }
        c cVar = f1599d;
        if (cVar == f1599d) {
            return z ? f1603h : f1602g;
        }
        return new a(z, 2, cVar);
    }

    public CharSequence d(CharSequence charSequence, c cVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean b = ((d.c) cVar).b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = "";
        if (((this.b & 2) != 0) && z) {
            boolean b2 = ((d.c) (b ? d.b : d.a)).b(charSequence, 0, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.a || (!b2 && a(charSequence) != 1)) ? (!this.a || (b2 && a(charSequence) != -1)) ? str : f1601f : f1600e));
        }
        if (b != this.a) {
            spannableStringBuilder.append(b ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean b3 = ((d.c) (b ? d.b : d.a)).b(charSequence, 0, charSequence.length());
            if (!this.a && (b3 || b(charSequence) == 1)) {
                str = f1600e;
            } else if (this.a && (!b3 || b(charSequence) == -1)) {
                str = f1601f;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public String e(String str) {
        c cVar = this.c;
        if (str == null) {
            return null;
        }
        return d(str, cVar, true).toString();
    }
}
