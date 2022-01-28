package androidx.slice;

import android.os.Build;
import android.text.Html;
import b.i.k.a;
import b.z.b;

public final class SliceItemParcelizer {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r1.equals("image") != false) goto L_0x0081;
     */
    public static SliceItem read(b bVar) {
        Object obj;
        SliceItem sliceItem = new SliceItem();
        char c2 = 1;
        sliceItem.f397a = (String[]) bVar.f(sliceItem.f397a, 1);
        sliceItem.f398b = bVar.n(sliceItem.f398b, 2);
        sliceItem.f399c = bVar.n(sliceItem.f399c, 3);
        SliceItemHolder sliceItemHolder = (SliceItemHolder) bVar.p(sliceItem.f401e, 4);
        sliceItem.f401e = sliceItemHolder;
        String str = sliceItem.f398b;
        if (sliceItemHolder != null) {
            switch (str.hashCode()) {
                case -1422950858:
                    if (str.equals("action")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104431:
                    if (str.equals("int")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3327612:
                    if (str.equals("long")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100313435:
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109526418:
                    if (str.equals("slice")) {
                        c2 = 2;
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
                    obj = new a(sliceItemHolder.f403b, (Slice) sliceItemHolder.f402a);
                    break;
                case 1:
                case 2:
                    obj = sliceItemHolder.f402a;
                    break;
                case 3:
                    obj = sliceItemHolder.f403b;
                    break;
                case 4:
                    String str2 = sliceItemHolder.f404c;
                    if (str2 != null && str2.length() != 0) {
                        String str3 = sliceItemHolder.f404c;
                        if (Build.VERSION.SDK_INT < 24) {
                            obj = Html.fromHtml(str3);
                            break;
                        } else {
                            obj = Html.fromHtml(str3, 0);
                            break;
                        }
                    } else {
                        obj = "";
                        break;
                    }
                    break;
                case 5:
                    obj = Integer.valueOf(sliceItemHolder.f405d);
                    break;
                case 6:
                    obj = Long.valueOf(sliceItemHolder.f406e);
                    break;
                default:
                    throw new IllegalArgumentException(c.a.a.a.a.q("Unrecognized format ", str));
            }
            sliceItem.f400d = obj;
            sliceItem.f401e = null;
            return sliceItem;
        }
        throw null;
    }

    public static void write(SliceItem sliceItem, b bVar) {
        if (bVar != null) {
            sliceItem.f401e = new SliceItemHolder(sliceItem.f398b, sliceItem.f400d, false);
            bVar.r(sliceItem.f397a, 1);
            bVar.v(sliceItem.f398b, 2);
            bVar.v(sliceItem.f399c, 3);
            SliceItemHolder sliceItemHolder = sliceItem.f401e;
            bVar.q(4);
            bVar.w(sliceItemHolder);
            return;
        }
        throw null;
    }
}
