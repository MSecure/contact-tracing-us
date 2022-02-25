package e.i.g;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import e.i.g.d;
import java.util.Locale;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final c f1455d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1456e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    public static final String f1457f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    public static final a f1458g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f1459h;
    public final boolean a;
    public final int b;
    public final c c;

    /* renamed from: e.i.g.a$a  reason: collision with other inner class name */
    public static class C0032a {

        /* renamed from: e  reason: collision with root package name */
        public static final byte[] f1460e = new byte[1792];
        public final CharSequence a;
        public final int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public char f1461d;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f1460e[i2] = Character.getDirectionality(i2);
            }
        }

        public C0032a(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = charSequence.length();
        }

        public byte a() {
            char charAt = this.a.charAt(this.c - 1);
            this.f1461d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.c);
                this.c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.c--;
            char c2 = this.f1461d;
            return c2 < 1792 ? f1460e[c2] : Character.getDirectionality(c2);
        }
    }

    static {
        c cVar = d.c;
        f1455d = cVar;
        f1458g = new a(false, 2, cVar);
        f1459h = new a(true, 2, cVar);
    }

    public a(boolean z, int i2, c cVar) {
        this.a = z;
        this.b = i2;
        this.c = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        return 1;
     */
    public static int a(CharSequence charSequence) {
        byte b2;
        C0032a aVar = new C0032a(charSequence, false);
        aVar.c = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = aVar.c;
            if (i5 < aVar.b && i2 == 0) {
                char charAt = aVar.a.charAt(i5);
                aVar.f1461d = charAt;
                if (Character.isHighSurrogate(charAt)) {
                    int codePointAt = Character.codePointAt(aVar.a, aVar.c);
                    aVar.c = Character.charCount(codePointAt) + aVar.c;
                    b2 = Character.getDirectionality(codePointAt);
                } else {
                    aVar.c++;
                    char c2 = aVar.f1461d;
                    b2 = c2 < 1792 ? C0032a.f1460e[c2] : Character.getDirectionality(c2);
                }
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
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
            } else if (i2 == 0) {
                return 0;
            } else {
                if (i3 != 0) {
                    return i3;
                }
                while (aVar.c > 0) {
                    switch (aVar.a()) {
                        case 14:
                        case 15:
                            if (i2 == i4) {
                                break;
                            }
                            break;
                        case 16:
                        case 17:
                            if (i2 == i4) {
                                break;
                            }
                            break;
                        case 18:
                            i4++;
                            continue;
                    }
                    i4--;
                }
                return 0;
            }
        }
        return -1;
    }

    public static int b(CharSequence charSequence) {
        C0032a aVar = new C0032a(charSequence, false);
        aVar.c = aVar.b;
        int i2 = 0;
        int i3 = 0;
        while (aVar.c > 0) {
            byte a2 = aVar.a();
            if (a2 != 0) {
                if (a2 == 1 || a2 == 2) {
                    if (i2 != 0) {
                        if (i3 != 0) {
                        }
                        i3 = i2;
                    }
                } else if (a2 != 9) {
                    switch (a2) {
                        case 14:
                        case 15:
                            if (i3 == i2) {
                                break;
                            }
                            i2--;
                            break;
                        case 16:
                        case 17:
                            if (i3 == i2) {
                                break;
                            }
                            i2--;
                            break;
                        case 18:
                            i2++;
                            break;
                        default:
                            if (i3 != 0) {
                                break;
                            }
                            i3 = i2;
                            break;
                    }
                } else {
                    continue;
                }
                return 1;
            } else if (i2 != 0) {
                if (i3 != 0) {
                }
                i3 = i2;
            }
            return -1;
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
        c cVar = f1455d;
        if (cVar == f1455d) {
            return z ? f1459h : f1458g;
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
        if (((this.b & 2) != 0) && z) {
            boolean b3 = ((d.c) (b2 ? d.b : d.a)).b(charSequence, 0, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.a || (!b3 && a(charSequence) != 1)) ? (!this.a || (b3 && a(charSequence) != -1)) ? str : f1457f : f1456e));
        }
        if (b2 != this.a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean b4 = ((d.c) (b2 ? d.b : d.a)).b(charSequence, 0, charSequence.length());
            if (!this.a && (b4 || b(charSequence) == 1)) {
                str = f1456e;
            } else if (this.a && (!b4 || b(charSequence) == -1)) {
                str = f1457f;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }
}
