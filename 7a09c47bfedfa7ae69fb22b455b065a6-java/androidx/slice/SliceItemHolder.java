package androidx.slice;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import b.i.k.a;
import b.z.d;

public class SliceItemHolder implements d {

    /* renamed from: a  reason: collision with root package name */
    public d f402a;

    /* renamed from: b  reason: collision with root package name */
    public Parcelable f403b;

    /* renamed from: c  reason: collision with root package name */
    public String f404c;

    /* renamed from: d  reason: collision with root package name */
    public int f405d;

    /* renamed from: e  reason: collision with root package name */
    public long f406e;

    public SliceItemHolder() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public SliceItemHolder(String str, Object obj, boolean z) {
        char c2;
        String str2;
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
                if (str.equals("image")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
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
                a aVar = (a) obj;
                F f2 = aVar.f1841a;
                if (f2 instanceof PendingIntent) {
                    if (!z) {
                        this.f403b = f2;
                    } else {
                        throw new IllegalArgumentException("Cannot write PendingIntent to stream");
                    }
                } else if (!z) {
                    throw new IllegalArgumentException("Cannot write callback to parcel");
                }
                this.f402a = aVar.f1842b;
                return;
            case 1:
            case 2:
                this.f402a = (d) obj;
                return;
            case 3:
                if (!z) {
                    this.f403b = (Parcelable) obj;
                    return;
                }
                throw new IllegalArgumentException("Cannot write RemoteInput to stream");
            case 4:
                if (obj instanceof Spanned) {
                    Spanned spanned = (Spanned) obj;
                    str2 = Build.VERSION.SDK_INT >= 24 ? Html.toHtml(spanned, 0) : Html.toHtml(spanned);
                } else {
                    str2 = (String) obj;
                }
                this.f404c = str2;
                return;
            case 5:
                this.f405d = ((Integer) obj).intValue();
                return;
            case 6:
                this.f406e = ((Long) obj).longValue();
                return;
            default:
                return;
        }
    }
}
