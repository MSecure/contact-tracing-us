package b.i.d;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f1673a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<f> f1674b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<f> f1675c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f1676d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1677e;

    /* renamed from: f  reason: collision with root package name */
    public PendingIntent f1678f;

    /* renamed from: g  reason: collision with root package name */
    public int f1679g;
    public boolean h = true;
    public i i;
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

    public h(Context context, String str) {
        Notification notification = new Notification();
        this.s = notification;
        this.f1673a = context;
        this.o = str;
        notification.when = System.currentTimeMillis();
        this.s.audioStreamType = -1;
        this.f1679g = 0;
        this.t = new ArrayList<>();
        this.r = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r0.f1688g == 1) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
        if (r0.f1688g == 1) goto L_0x00af;
     */
    public Notification a() {
        Notification notification;
        j jVar = new j(this);
        i iVar = jVar.f1683b.i;
        if (iVar != null) {
            g gVar = (g) iVar;
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(jVar.f1682a).setBigContentTitle(null).bigText(gVar.f1672c);
            if (gVar.f1681b) {
                bigText.setSummaryText(null);
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            notification = jVar.f1682a.build();
        } else {
            if (i2 >= 24) {
                notification = jVar.f1682a.build();
                if (jVar.f1688g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || jVar.f1688g != 2)) {
                        jVar.a(notification);
                    }
                    if (notification.getGroup() != null) {
                        if ((notification.flags & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                        }
                    }
                }
            } else {
                jVar.f1682a.setExtras(jVar.f1687f);
                notification = jVar.f1682a.build();
                RemoteViews remoteViews = jVar.f1684c;
                if (remoteViews != null) {
                    notification.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = jVar.f1685d;
                if (remoteViews2 != null) {
                    notification.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = jVar.h;
                if (remoteViews3 != null) {
                    notification.headsUpContentView = remoteViews3;
                }
                if (jVar.f1688g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || jVar.f1688g != 2)) {
                        jVar.a(notification);
                    }
                    if (notification.getGroup() != null) {
                        if ((notification.flags & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                        }
                    }
                }
            }
            jVar.a(notification);
        }
        RemoteViews remoteViews4 = jVar.f1683b.n;
        if (remoteViews4 != null) {
            notification.contentView = remoteViews4;
        }
        if (iVar == null || jVar.f1683b.i != null) {
            if (iVar != null) {
                Bundle bundle = notification.extras;
            }
            return notification;
        }
        throw null;
    }

    public final void c(int i2, boolean z) {
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

    public h d(i iVar) {
        if (this.i != iVar) {
            this.i = iVar;
            if (iVar.f1680a != this) {
                iVar.f1680a = this;
                d(iVar);
            }
        }
        return this;
    }
}
