package androidx.slice;

import android.os.Build;
import android.text.Html;
import e.b0.b;
import f.a.a.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public final class SliceItemParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r1.equals("int") == false) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static SliceItem read(b bVar) {
        Object obj;
        SliceItem sliceItem = new SliceItem();
        char c = 1;
        sliceItem.a = (String[]) bVar.f(sliceItem.a, 1);
        sliceItem.b = bVar.q(sliceItem.b, 2);
        sliceItem.c = bVar.q(sliceItem.c, 3);
        SliceItemHolder sliceItemHolder = (SliceItemHolder) bVar.t(sliceItem.f294e, 4);
        sliceItem.f294e = sliceItemHolder;
        String str = sliceItem.b;
        Objects.requireNonNull(sliceItemHolder);
        str.hashCode();
        switch (str.hashCode()) {
            case -1422950858:
                if (str.equals("action")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 104431:
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100313435:
                if (str.equals("image")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 100358090:
                if (str.equals("input")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                obj = new e.j.i.b(sliceItemHolder.b, (Slice) sliceItemHolder.a);
                break;
            case 1:
                obj = Integer.valueOf(sliceItemHolder.f295d);
                break;
            case 2:
                obj = Long.valueOf(sliceItemHolder.f296e);
                break;
            case 3:
                String str2 = sliceItemHolder.c;
                if (str2 != null && str2.length() != 0) {
                    String str3 = sliceItemHolder.c;
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
            case 4:
            case 6:
                obj = sliceItemHolder.a;
                break;
            case 5:
                obj = sliceItemHolder.b;
                break;
            default:
                throw new IllegalArgumentException(a.x("Unrecognized format ", str));
        }
        sliceItem.f293d = obj;
        sliceItem.f294e = null;
        return sliceItem;
    }

    public static void write(SliceItem sliceItem, b bVar) {
        Objects.requireNonNull(bVar);
        sliceItem.f294e = new SliceItemHolder(sliceItem.b, sliceItem.f293d, false);
        bVar.v(sliceItem.a, 1);
        String str = sliceItem.b;
        bVar.u(2);
        bVar.C(str);
        String str2 = sliceItem.c;
        bVar.u(3);
        bVar.C(str2);
        SliceItemHolder sliceItemHolder = sliceItem.f294e;
        bVar.u(4);
        bVar.E(sliceItemHolder);
    }
}
