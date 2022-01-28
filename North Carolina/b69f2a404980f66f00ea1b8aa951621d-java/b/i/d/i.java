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

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Notification.Builder f991a;

    /* renamed from: b  reason: collision with root package name */
    public final g f992b;

    /* renamed from: c  reason: collision with root package name */
    public RemoteViews f993c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f994d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Bundle> f995e = new ArrayList();
    public final Bundle f = new Bundle();
    public int g;
    public RemoteViews h;

    public i(g gVar) {
        this.f992b = gVar;
        Notification.Builder builder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(gVar.f984a, gVar.o) : new Notification.Builder(gVar.f984a);
        this.f991a = builder;
        Notification notification = gVar.s;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(gVar.f987d).setContentText(gVar.f988e).setContentInfo(null).setContentIntent(gVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & RecyclerView.d0.FLAG_IGNORE) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        this.f991a.setSubText(null).setUsesChronometer(false).setPriority(gVar.g);
        Iterator<e> it = gVar.f985b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            IconCompat a2 = next.a();
            Notification.Action.Builder builder2 = new Notification.Action.Builder(a2 != null ? a2.f() : null, next.j, next.k);
            l[] lVarArr = next.f980c;
            if (lVarArr != null) {
                int length = lVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (lVarArr.length <= 0) {
                    for (int i = 0; i < length; i++) {
                        builder2.addRemoteInput(remoteInputArr[i]);
                    }
                } else {
                    l lVar = lVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.f978a != null ? new Bundle(next.f978a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f982e);
            if (Build.VERSION.SDK_INT >= 24) {
                builder2.setAllowGeneratedReplies(next.f982e);
            }
            bundle.putInt("android.support.action.semanticAction", next.g);
            if (Build.VERSION.SDK_INT >= 28) {
                builder2.setSemanticAction(next.g);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder2.setContextual(next.h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f);
            builder2.addExtras(bundle);
            this.f991a.addAction(builder2.build());
        }
        Bundle bundle2 = gVar.k;
        if (bundle2 != null) {
            this.f.putAll(bundle2);
        }
        this.f993c = null;
        this.f994d = null;
        this.f991a.setShowWhen(gVar.h);
        this.f991a.setLocalOnly(gVar.j).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.g = gVar.q;
        this.f991a.setCategory(null).setColor(gVar.l).setVisibility(gVar.m).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        Iterator<String> it2 = gVar.t.iterator();
        while (it2.hasNext()) {
            this.f991a.addPerson(it2.next());
        }
        this.h = null;
        if (gVar.f986c.size() > 0) {
            if (gVar.k == null) {
                gVar.k = new Bundle();
            }
            Bundle bundle3 = gVar.k.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle();
            for (int i2 = 0; i2 < gVar.f986c.size(); i2++) {
                bundle4.putBundle(Integer.toString(i2), j.a(gVar.f986c.get(i2)));
            }
            bundle3.putBundle("invisible_actions", bundle4);
            if (gVar.k == null) {
                gVar.k = new Bundle();
            }
            gVar.k.putBundle("android.car.EXTENSIONS", bundle3);
            this.f.putBundle("android.car.EXTENSIONS", bundle3);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f991a.setExtras(gVar.k).setRemoteInputHistory(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f991a.setBadgeIconType(gVar.p).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(gVar.q);
            if (!TextUtils.isEmpty(gVar.o)) {
                this.f991a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f991a.setAllowSystemGeneratedContextualActions(gVar.r);
            this.f991a.setBubbleMetadata(null);
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
