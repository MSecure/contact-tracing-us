package b.i.j;

import android.text.SpannableStringBuilder;
import b.i.j.d;
import java.util.Locale;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final c f1109d = d.f1125c;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1110e = Character.toString(8206);
    public static final String f = Character.toString(8207);
    public static final a g = new a(false, 2, f1109d);
    public static final a h = new a(true, 2, f1109d);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1111a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1112b;

    /* renamed from: c  reason: collision with root package name */
    public final c f1113c;

    /* renamed from: b.i.j.a$a  reason: collision with other inner class name */
    public static class C0023a {
        public static final byte[] f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f1114a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1115b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1116c;

        /* renamed from: d  reason: collision with root package name */
        public int f1117d;

        /* renamed from: e  reason: collision with root package name */
        public char f1118e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        public C0023a(CharSequence charSequence, boolean z) {
            this.f1114a = charSequence;
            this.f1115b = z;
            this.f1116c = charSequence.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
            r7.f1117d = r0;
            r7.f1118e = '>';
         */
        public byte a() {
            char charAt;
            char charAt2;
            char charAt3 = this.f1114a.charAt(this.f1117d - 1);
            this.f1118e = charAt3;
            if (Character.isLowSurrogate(charAt3)) {
                int codePointBefore = Character.codePointBefore(this.f1114a, this.f1117d);
                this.f1117d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1117d--;
            char c2 = this.f1118e;
            byte directionality = c2 < 1792 ? f[c2] : Character.getDirectionality(c2);
            if (!this.f1115b) {
                return directionality;
            }
            char c3 = this.f1118e;
            if (c3 == '>') {
                int i = this.f1117d;
                while (true) {
                    int i2 = this.f1117d;
                    if (i2 <= 0) {
                        break;
                    }
                    CharSequence charSequence = this.f1114a;
                    int i3 = i2 - 1;
                    this.f1117d = i3;
                    char charAt4 = charSequence.charAt(i3);
                    this.f1118e = charAt4;
                    if (charAt4 == '<') {
                        break;
                    } else if (charAt4 == '>') {
                        break;
                    } else if (charAt4 == '\"' || charAt4 == '\'') {
                        char c4 = this.f1118e;
                        do {
                            int i4 = this.f1117d;
                            if (i4 <= 0) {
                                break;
                            }
                            CharSequence charSequence2 = this.f1114a;
                            int i5 = i4 - 1;
                            this.f1117d = i5;
                            charAt2 = charSequence2.charAt(i5);
                            this.f1118e = charAt2;
                        } while (charAt2 != c4);
                    }
                }
            } else if (c3 != ';') {
                return directionality;
            } else {
                int i6 = this.f1117d;
                do {
                    int i7 = this.f1117d;
                    if (i7 <= 0) {
                        break;
                    }
                    CharSequence charSequence3 = this.f1114a;
                    int i8 = i7 - 1;
                    this.f1117d = i8;
                    charAt = charSequence3.charAt(i8);
                    this.f1118e = charAt;
                    if (charAt == '&') {
                    }
                } while (charAt != ';');
                this.f1117d = i6;
                this.f1118e = ';';
                return 13;
            }
            return 12;
        }
    }

    public a(boolean z, int i, c cVar) {
        this.f1111a = z;
        this.f1112b = i;
        this.f1113c = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return 1;
     */
    public static int a(CharSequence charSequence) {
        byte b2;
        char charAt;
        char charAt2;
        C0023a aVar = new C0023a(charSequence, false);
        aVar.f1117d = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = aVar.f1117d;
            if (i4 < aVar.f1116c && i == 0) {
                char charAt3 = aVar.f1114a.charAt(i4);
                aVar.f1118e = charAt3;
                if (Character.isHighSurrogate(charAt3)) {
                    int codePointAt = Character.codePointAt(aVar.f1114a, aVar.f1117d);
                    aVar.f1117d = Character.charCount(codePointAt) + aVar.f1117d;
                    b2 = Character.getDirectionality(codePointAt);
                } else {
                    aVar.f1117d++;
                    char c2 = aVar.f1118e;
                    b2 = c2 < 1792 ? C0023a.f[c2] : Character.getDirectionality(c2);
                    if (aVar.f1115b) {
                        char c3 = aVar.f1118e;
                        if (c3 == '<') {
                            int i5 = aVar.f1117d;
                            while (true) {
                                int i6 = aVar.f1117d;
                                if (i6 < aVar.f1116c) {
                                    CharSequence charSequence2 = aVar.f1114a;
                                    aVar.f1117d = i6 + 1;
                                    char charAt4 = charSequence2.charAt(i6);
                                    aVar.f1118e = charAt4;
                                    if (charAt4 != '>') {
                                        if (charAt4 == '\"' || charAt4 == '\'') {
                                            char c4 = aVar.f1118e;
                                            do {
                                                int i7 = aVar.f1117d;
                                                if (i7 < aVar.f1116c) {
                                                    CharSequence charSequence3 = aVar.f1114a;
                                                    aVar.f1117d = i7 + 1;
                                                    charAt2 = charSequence3.charAt(i7);
                                                    aVar.f1118e = charAt2;
                                                }
                                            } while (charAt2 != c4);
                                        }
                                    }
                                } else {
                                    aVar.f1117d = i5;
                                    aVar.f1118e = '<';
                                    b2 = 13;
                                }
                            }
                        } else if (c3 == '&') {
                            do {
                                int i8 = aVar.f1117d;
                                if (i8 < aVar.f1116c) {
                                    CharSequence charSequence4 = aVar.f1114a;
                                    aVar.f1117d = i8 + 1;
                                    charAt = charSequence4.charAt(i8);
                                    aVar.f1118e = charAt;
                                }
                            } while (charAt != ';');
                        }
                        b2 = 12;
                    }
                }
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                }
                i = i3;
            } else if (i == 0) {
                return 0;
            } else {
                if (i2 != 0) {
                    return i2;
                }
                while (aVar.f1117d > 0) {
                    switch (aVar.a()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                break;
                            }
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                break;
                            }
                            break;
                        case 18:
                            i3++;
                            continue;
                    }
                    i3--;
                }
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return 1;
     */
    public static int b(CharSequence charSequence) {
        C0023a aVar = new C0023a(charSequence, false);
        aVar.f1117d = aVar.f1116c;
        int i = 0;
        while (true) {
            int i2 = i;
            while (aVar.f1117d > 0) {
                byte a2 = aVar.a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 != 0) {
                            if (i == 0) {
                                i = i2;
                            }
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i == i2) {
                                    break;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i == i2) {
                                    break;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i != 0) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                        i = i2;
                    } else {
                        continue;
                    }
                } else if (i2 != 0) {
                    if (i == 0) {
                        i = i2;
                    }
                }
            }
            return 0;
        }
        return -1;
    }

    public static a c() {
        boolean z = true;
        if (e.a(Locale.getDefault()) != 1) {
            z = false;
        }
        c cVar = f1109d;
        if (cVar == f1109d) {
            return z ? h : g;
        }
        return new a(z, 2, cVar);
    }

    public CharSequence d(CharSequence charSequence, c cVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean b2 = ((d.c) cVar).b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = "";
        if (((this.f1112b & 2) != 0) && z) {
            boolean b3 = ((d.c) (b2 ? d.f1124b : d.f1123a)).b(charSequence, 0, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.f1111a || (!b3 && a(charSequence) != 1)) ? (!this.f1111a || (b3 && a(charSequence) != -1)) ? str : f : f1110e));
        }
        if (b2 != this.f1111a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean b4 = ((d.c) (b2 ? d.f1124b : d.f1123a)).b(charSequence, 0, charSequence.length());
            if (!this.f1111a && (b4 || b(charSequence) == 1)) {
                str = f1110e;
            } else if (this.f1111a && (!b4 || b(charSequence) == -1)) {
                str = f;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }
}
