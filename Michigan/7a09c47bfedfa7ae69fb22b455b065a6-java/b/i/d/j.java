package b.i.d;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Notification.Builder f1682a;

    /* renamed from: b  reason: collision with root package name */
    public final h f1683b;

    /* renamed from: c  reason: collision with root package name */
    public RemoteViews f1684c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f1685d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Bundle> f1686e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Bundle f1687f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    public int f1688g;
    public RemoteViews h;

    public j(h hVar) {
        this.f1683b = hVar;
        Notification.Builder builder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(hVar.f1673a, hVar.o) : new Notification.Builder(hVar.f1673a);
        this.f1682a = builder;
        Notification notification = hVar.s;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(hVar.f1676d).setContentText(hVar.f1677e).setContentInfo(null).setContentIntent(hVar.f1678f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & RecyclerView.a0.FLAG_IGNORE) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        this.f1682a.setSubText(null).setUsesChronometer(false).setPriority(hVar.f1679g);
        Iterator<f> it = hVar.f1674b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            IconCompat a2 = next.a();
            Notification.Action.Builder builder2 = new Notification.Action.Builder(a2 != null ? a2.f() : null, next.j, next.k);
            m[] mVarArr = next.f1667c;
            if (mVarArr != null) {
                int length = mVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (mVarArr.length <= 0) {
                    for (int i = 0; i < length; i++) {
                        builder2.addRemoteInput(remoteInputArr[i]);
                    }
                } else {
                    m mVar = mVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.f1665a != null ? new Bundle(next.f1665a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f1669e);
            if (Build.VERSION.SDK_INT >= 24) {
                builder2.setAllowGeneratedReplies(next.f1669e);
            }
            bundle.putInt("android.support.action.semanticAction", next.f1671g);
            if (Build.VERSION.SDK_INT >= 28) {
                builder2.setSemanticAction(next.f1671g);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder2.setContextual(next.h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f1670f);
            builder2.addExtras(bundle);
            this.f1682a.addAction(builder2.build());
        }
        Bundle bundle2 = hVar.k;
        if (bundle2 != null) {
            this.f1687f.putAll(bundle2);
        }
        this.f1684c = null;
        this.f1685d = null;
        this.f1682a.setShowWhen(hVar.h);
        this.f1682a.setLocalOnly(hVar.j).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.f1688g = hVar.q;
        this.f1682a.setCategory(null).setColor(hVar.l).setVisibility(hVar.m).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        Iterator<String> it2 = hVar.t.iterator();
        while (it2.hasNext()) {
            this.f1682a.addPerson(it2.next());
        }
        this.h = null;
        if (hVar.f1675c.size() > 0) {
            if (hVar.k == null) {
                hVar.k = new Bundle();
            }
            Bundle bundle3 = hVar.k.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle();
            for (int i2 = 0; i2 < hVar.f1675c.size(); i2++) {
                bundle4.putBundle(Integer.toString(i2), k.a(hVar.f1675c.get(i2)));
            }
            bundle3.putBundle("invisible_actions", bundle4);
            if (hVar.k == null) {
                hVar.k = new Bundle();
            }
            hVar.k.putBundle("android.car.EXTENSIONS", bundle3);
            this.f1687f.putBundle("android.car.EXTENSIONS", bundle3);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1682a.setExtras(hVar.k).setRemoteInputHistory(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1682a.setBadgeIconType(hVar.p).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(hVar.q);
            if (!TextUtils.isEmpty(hVar.o)) {
                this.f1682a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1682a.setAllowSystemGeneratedContextualActions(hVar.r);
            this.f1682a.setBubbleMetadata(null);
        }
    }

    public final void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }
}
