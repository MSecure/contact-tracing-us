package androidx.slice;

import android.graphics.Color;
import android.text.format.DateUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import e.i.h.b;
import f.a.a.a.a;
import java.util.Calendar;

public final class SliceItem extends CustomVersionedParcelable {
    public String[] a = new String[0];
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public Object f293d;

    /* renamed from: e  reason: collision with root package name */
    public SliceItemHolder f294e;

    public int a() {
        return ((Integer) this.f293d).intValue();
    }

    public long b() {
        return ((Long) this.f293d).longValue();
    }

    public Slice c() {
        return "action".equals(this.b) ? ((b) this.f293d).b : (S) this.f293d;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public String d(String str) {
        char c2;
        String str2;
        char c3;
        char c4;
        StringBuilder h2 = a.h(str);
        h2.append(this.b);
        if (this.c != null) {
            h2.append('<');
            h2.append(this.c);
            h2.append('>');
        }
        h2.append(' ');
        String[] strArr = this.a;
        if (strArr.length > 0) {
            Slice.a(h2, strArr);
            h2.append(' ');
        }
        String w = a.w(str, "  ");
        String str3 = this.b;
        str3.hashCode();
        switch (str3.hashCode()) {
            case -1422950858:
                if (str3.equals("action")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 104431:
                if (str3.equals("int")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3327612:
                if (str3.equals("long")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3556653:
                if (str3.equals("text")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 100313435:
                if (str3.equals("image")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 109526418:
                if (str3.equals("slice")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                F f2 = ((b) this.f293d).a;
                h2.append('[');
                h2.append((Object) f2);
                h2.append("] ");
                h2.append("{\n");
                h2.append(c().b(w));
                h2.append('\n');
                h2.append(str);
                h2.append('}');
                break;
            case 1:
                if (!"color".equals(this.c)) {
                    if (!"layout_direction".equals(this.c)) {
                        h2.append(a());
                        break;
                    } else {
                        int a2 = a();
                        str2 = a2 != 0 ? a2 != 1 ? a2 != 2 ? a2 != 3 ? Integer.toString(a2) : "LOCALE" : "INHERIT" : "RTL" : "LTR";
                    }
                } else {
                    int a3 = a();
                    str2 = String.format("a=0x%02x r=0x%02x g=0x%02x b=0x%02x", Integer.valueOf(Color.alpha(a3)), Integer.valueOf(Color.red(a3)), Integer.valueOf(Color.green(a3)), Integer.valueOf(Color.blue(a3)));
                }
                h2.append(str2);
                break;
            case 2:
                boolean equals = "millis".equals(this.c);
                long b2 = b();
                if (equals) {
                    if (b2 != -1) {
                        h2.append(DateUtils.getRelativeTimeSpanString(b(), Calendar.getInstance().getTimeInMillis(), 1000, 262144));
                        break;
                    } else {
                        str2 = "INFINITY";
                        h2.append(str2);
                        break;
                    }
                } else {
                    h2.append(b2);
                    c3 = 'L';
                    h2.append(c3);
                    break;
                }
            case 3:
                c3 = '\"';
                h2.append('\"');
                h2.append((CharSequence) this.f293d);
                h2.append(c3);
                break;
            case 4:
                h2.append((IconCompat) this.f293d);
                break;
            case 5:
                h2.append("{\n");
                h2.append(c().b(w));
                h2.append('\n');
                h2.append(str);
                h2.append('}');
                break;
            default:
                String str4 = this.b;
                str4.hashCode();
                switch (str4.hashCode()) {
                    case -1422950858:
                        if (str4.equals("action")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 104431:
                        if (str4.equals("int")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 3327612:
                        if (str4.equals("long")) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 3556653:
                        if (str4.equals("text")) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 100313435:
                        if (str4.equals("image")) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 100358090:
                        if (str4.equals("input")) {
                            c4 = 5;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 109526418:
                        if (str4.equals("slice")) {
                            c4 = 6;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                switch (c4) {
                    case 0:
                        str2 = "Action";
                        break;
                    case 1:
                        str2 = "Int";
                        break;
                    case 2:
                        str2 = "Long";
                        break;
                    case 3:
                        str2 = "Text";
                        break;
                    case 4:
                        str2 = "Image";
                        break;
                    case 5:
                        str2 = "RemoteInput";
                        break;
                    case 6:
                        str2 = "Slice";
                        break;
                    default:
                        str2 = a.w("Unrecognized format: ", str4);
                        break;
                }
                h2.append(str2);
                break;
        }
        h2.append("\n");
        return h2.toString();
    }

    public String toString() {
        return d("");
    }
}
