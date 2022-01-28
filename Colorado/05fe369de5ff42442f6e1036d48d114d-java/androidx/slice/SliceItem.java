package androidx.slice;

import android.graphics.Color;
import android.text.format.DateUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import e.i.h.a;
import java.util.Calendar;

public final class SliceItem extends CustomVersionedParcelable {
    public String[] a = new String[0];
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public Object f292d;

    /* renamed from: e  reason: collision with root package name */
    public SliceItemHolder f293e;

    public int a() {
        return ((Integer) this.f292d).intValue();
    }

    public long b() {
        return ((Long) this.f292d).longValue();
    }

    public Slice c() {
        return "action".equals(this.b) ? ((a) this.f292d).b : (S) this.f292d;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public String d(String str) {
        char c2;
        String str2;
        char c3;
        char c4;
        StringBuilder i2 = f.a.a.a.a.i(str);
        i2.append(this.b);
        if (this.c != null) {
            i2.append('<');
            i2.append(this.c);
            i2.append('>');
        }
        i2.append(' ');
        String[] strArr = this.a;
        if (strArr.length > 0) {
            Slice.a(i2, strArr);
            i2.append(' ');
        }
        String c5 = f.a.a.a.a.c(str, "  ");
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
                F f2 = ((a) this.f292d).a;
                i2.append('[');
                i2.append((Object) f2);
                i2.append("] ");
                i2.append("{\n");
                i2.append(c().b(c5));
                i2.append('\n');
                i2.append(str);
                i2.append('}');
                break;
            case 1:
                if (!"color".equals(this.c)) {
                    if (!"layout_direction".equals(this.c)) {
                        i2.append(a());
                        break;
                    } else {
                        int a2 = a();
                        str2 = a2 != 0 ? a2 != 1 ? a2 != 2 ? a2 != 3 ? Integer.toString(a2) : "LOCALE" : "INHERIT" : "RTL" : "LTR";
                    }
                } else {
                    int a3 = a();
                    str2 = String.format("a=0x%02x r=0x%02x g=0x%02x b=0x%02x", Integer.valueOf(Color.alpha(a3)), Integer.valueOf(Color.red(a3)), Integer.valueOf(Color.green(a3)), Integer.valueOf(Color.blue(a3)));
                }
                i2.append(str2);
                break;
            case 2:
                boolean equals = "millis".equals(this.c);
                long b2 = b();
                if (equals) {
                    if (b2 != -1) {
                        i2.append(DateUtils.getRelativeTimeSpanString(b(), Calendar.getInstance().getTimeInMillis(), 1000, 262144));
                        break;
                    } else {
                        str2 = "INFINITY";
                        i2.append(str2);
                        break;
                    }
                } else {
                    i2.append(b2);
                    c3 = 'L';
                    i2.append(c3);
                    break;
                }
            case 3:
                c3 = '\"';
                i2.append('\"');
                i2.append((CharSequence) this.f292d);
                i2.append(c3);
                break;
            case 4:
                i2.append((IconCompat) this.f292d);
                break;
            case 5:
                i2.append("{\n");
                i2.append(c().b(c5));
                i2.append('\n');
                i2.append(str);
                i2.append('}');
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
                        str2 = f.a.a.a.a.c("Unrecognized format: ", str4);
                        break;
                }
                i2.append(str2);
                break;
        }
        i2.append("\n");
        return i2.toString();
    }

    public String toString() {
        return d("");
    }
}
