package androidx.slice;

import android.graphics.Color;
import android.text.format.DateUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import b.i.k.a;
import java.util.Calendar;

public final class SliceItem extends CustomVersionedParcelable {

    /* renamed from: a  reason: collision with root package name */
    public String[] f397a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public String f398b;

    /* renamed from: c  reason: collision with root package name */
    public String f399c;

    /* renamed from: d  reason: collision with root package name */
    public Object f400d;

    /* renamed from: e  reason: collision with root package name */
    public SliceItemHolder f401e;

    public int a() {
        return ((Integer) this.f400d).intValue();
    }

    public long b() {
        return ((Long) this.f400d).longValue();
    }

    public Slice c() {
        return "action".equals(this.f398b) ? ((a) this.f400d).f1842b : (S) this.f400d;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c4, code lost:
        if (r1.equals("int") != false) goto L_0x00d0;
     */
    public String d(String str) {
        char c2;
        char c3;
        String str2;
        StringBuilder h = c.a.a.a.a.h(str);
        h.append(this.f398b);
        if (this.f399c != null) {
            h.append('<');
            h.append(this.f399c);
            h.append('>');
        }
        h.append(' ');
        String[] strArr = this.f397a;
        if (strArr.length > 0) {
            Slice.a(h, strArr);
            h.append(' ');
        }
        String q = c.a.a.a.a.q(str, "  ");
        String str3 = this.f398b;
        char c4 = 4;
        switch (str3.hashCode()) {
            case -1422950858:
                if (str3.equals("action")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 104431:
                if (str3.equals("int")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3327612:
                if (str3.equals("long")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3556653:
                if (str3.equals("text")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 100313435:
                if (str3.equals("image")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 109526418:
                if (str3.equals("slice")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            h.append("{\n");
            h.append(c().b(q));
            h.append('\n');
            h.append(str);
            c3 = '}';
        } else if (c2 == 1) {
            F f2 = ((a) this.f400d).f1841a;
            h.append('[');
            h.append((Object) f2);
            h.append("] ");
            h.append("{\n");
            h.append(c().b(q));
            h.append('\n');
            h.append(str);
            c3 = '}';
        } else if (c2 != 2) {
            if (c2 != 3) {
                if (c2 != 4) {
                    if (c2 != 5) {
                        String str4 = this.f398b;
                        switch (str4.hashCode()) {
                            case -1422950858:
                                if (str4.equals("action")) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 104431:
                                break;
                            case 3327612:
                                if (str4.equals("long")) {
                                    c4 = 5;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 3556653:
                                if (str4.equals("text")) {
                                    c4 = 1;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 100313435:
                                if (str4.equals("image")) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 100358090:
                                if (str4.equals("input")) {
                                    c4 = 6;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 109526418:
                                if (str4.equals("slice")) {
                                    c4 = 0;
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
                                str2 = "Slice";
                                break;
                            case 1:
                                str2 = "Text";
                                break;
                            case 2:
                                str2 = "Image";
                                break;
                            case 3:
                                str2 = "Action";
                                break;
                            case 4:
                                str2 = "Int";
                                break;
                            case 5:
                                str2 = "Long";
                                break;
                            case 6:
                                str2 = "RemoteInput";
                                break;
                            default:
                                str2 = c.a.a.a.a.q("Unrecognized format: ", str4);
                                break;
                        }
                    } else {
                        boolean equals = "millis".equals(this.f399c);
                        long b2 = b();
                        if (!equals) {
                            h.append(b2);
                            c3 = 'L';
                        } else if (b2 == -1) {
                            str2 = "INFINITY";
                        } else {
                            h.append(DateUtils.getRelativeTimeSpanString(b(), Calendar.getInstance().getTimeInMillis(), 1000, 262144));
                        }
                    }
                } else if ("color".equals(this.f399c)) {
                    int a2 = a();
                    str2 = String.format("a=0x%02x r=0x%02x g=0x%02x b=0x%02x", Integer.valueOf(Color.alpha(a2)), Integer.valueOf(Color.red(a2)), Integer.valueOf(Color.green(a2)), Integer.valueOf(Color.blue(a2)));
                } else if ("layout_direction".equals(this.f399c)) {
                    int a3 = a();
                    str2 = a3 != 0 ? a3 != 1 ? a3 != 2 ? a3 != 3 ? Integer.toString(a3) : "LOCALE" : "INHERIT" : "RTL" : "LTR";
                } else {
                    h.append(a());
                }
                h.append(str2);
            } else {
                h.append((IconCompat) this.f400d);
            }
            h.append("\n");
            return h.toString();
        } else {
            c3 = '\"';
            h.append('\"');
            h.append((CharSequence) this.f400d);
        }
        h.append(c3);
        h.append("\n");
        return h.toString();
    }

    public String toString() {
        return d("");
    }
}
