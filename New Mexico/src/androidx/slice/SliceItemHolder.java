package androidx.slice;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import e.b0.d;
import e.j.i.b;
/* loaded from: classes.dex */
public class SliceItemHolder implements d {
    public d a;
    public Parcelable b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public int f295d;

    /* renamed from: e  reason: collision with root package name */
    public long f296e;

    public SliceItemHolder() {
    }

    public SliceItemHolder(String str, Object obj, boolean z) {
        String str2;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1422950858:
                if (str.equals("action")) {
                    c = 0;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c = 1;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 2;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c = 4;
                    break;
                }
                break;
            case 100358090:
                if (str.equals("input")) {
                    c = 5;
                    break;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                b bVar = (b) obj;
                F f2 = bVar.a;
                if (f2 instanceof PendingIntent) {
                    if (!z) {
                        this.b = (Parcelable) f2;
                    } else {
                        throw new IllegalArgumentException("Cannot write PendingIntent to stream");
                    }
                } else if (!z) {
                    throw new IllegalArgumentException("Cannot write callback to parcel");
                }
                this.a = (d) bVar.b;
                return;
            case 1:
                this.f295d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f296e = ((Long) obj).longValue();
                return;
            case 3:
                if (obj instanceof Spanned) {
                    Spanned spanned = (Spanned) obj;
                    str2 = Build.VERSION.SDK_INT >= 24 ? Html.toHtml(spanned, 0) : Html.toHtml(spanned);
                } else {
                    str2 = (String) obj;
                }
                this.c = str2;
                return;
            case 4:
            case 6:
                this.a = (d) obj;
                return;
            case 5:
                if (!z) {
                    this.b = (Parcelable) obj;
                    return;
                }
                throw new IllegalArgumentException("Cannot write RemoteInput to stream");
            default:
                return;
        }
    }
}
