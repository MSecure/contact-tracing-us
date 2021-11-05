package b.i.d;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f984a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f985b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<e> f986c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f987d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f988e;
    public PendingIntent f;
    public int g;
    public boolean h = true;
    public h i;
    public boolean j = false;
    public Bundle k;
    public int l = 0;
    public int m = 0;
    public RemoteViews n;
    public String o;
    public int p = 0;
    public int q = 0;
    public boolean r;
    public Notification s;
    @Deprecated
    public ArrayList<String> t;

    public g(Context context, String str) {
        Notification notification = new Notification();
        this.s = notification;
        this.f984a = context;
        this.o = str;
        notification.when = System.currentTimeMillis();
        this.s.audioStreamType = -1;
        this.g = 0;
        this.t = new ArrayList<>();
        this.r = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r0.g == 1) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
        if (r0.g == 1) goto L_0x00af;
     */
    public Notification a() {
        Notification notification;
        i iVar = new i(this);
        h hVar = iVar.f992b.i;
        if (hVar != null) {
            f fVar = (f) hVar;
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(iVar.f991a).setBigContentTitle(null).bigText(fVar.f983c);
            if (fVar.f990b) {
                bigText.setSummaryText(null);
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            notification = iVar.f991a.build();
        } else {
            if (i2 >= 24) {
                notification = iVar.f991a.build();
                if (iVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || iVar.g != 2)) {
                        iVar.a(notification);
                    }
                    if (notification.getGroup() != null) {
                        if ((notification.flags & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                        }
                    }
                }
            } else {
                iVar.f991a.setExtras(iVar.f);
                notification = iVar.f991a.build();
                RemoteViews remoteViews = iVar.f993c;
                if (remoteViews != null) {
                    notification.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = iVar.f994d;
                if (remoteViews2 != null) {
                    notification.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = iVar.h;
                if (remoteViews3 != null) {
                    notification.headsUpContentView = remoteViews3;
                }
                if (iVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || iVar.g != 2)) {
                        iVar.a(notification);
                    }
                    if (notification.getGroup() != null) {
                        if ((notification.flags & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                        }
                    }
                }
            }
            iVar.a(notification);
        }
        RemoteViews remoteViews4 = iVar.f992b.n;
        if (remoteViews4 != null) {
            notification.contentView = remoteViews4;
        }
        if (hVar == null || iVar.f992b.i != null) {
            if (hVar != null) {
                Bundle bundle = notification.extras;
            }
            return notification;
        }
        throw null;
    }

    public g c(CharSequence charSequence) {
        this.f988e = b(charSequence);
        return this;
    }

    public final void d(int i2, boolean z) {
        Notification notification;
        int i3;
        if (z) {
            notification = this.s;
            i3 = i2 | notification.flags;
        } else {
            notification = this.s;
            i3 = (~i2) & notification.flags;
        }
        notification.flags = i3;
    }

    public g e(h hVar) {
        if (this.i != hVar) {
            this.i = hVar;
            if (hVar.f989a != this) {
                hVar.f989a = this;
                e(hVar);
            }
        }
        return this;
    }
}
