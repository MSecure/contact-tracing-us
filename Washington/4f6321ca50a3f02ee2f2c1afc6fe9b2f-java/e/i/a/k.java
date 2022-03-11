package e.i.a;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import e.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class k {
    public final Notification.Builder a;
    public final i b;
    public final List<Bundle> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1408d = new Bundle();

    public k(i iVar) {
        Notification.Builder builder;
        Notification.Action.Builder builder2;
        int i2 = Build.VERSION.SDK_INT;
        this.b = iVar;
        Context context = iVar.a;
        if (i2 >= 26) {
            String str = iVar.o;
        } else {
            builder = new Notification.Builder(context);
        }
        this.a = builder;
        Notification notification = iVar.q;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(iVar.f1400e).setContentText(iVar.f1401f).setContentInfo(null).setContentIntent(iVar.f1402g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(iVar.f1403h);
        Iterator<g> it = iVar.b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            IconCompat a2 = next.a();
            if (i2 >= 23) {
                builder2 = new Notification.Action.Builder(a2 != null ? a2.e() : null, next.f1397j, next.f1398k);
            } else {
                builder2 = new Notification.Action.Builder(a2 != null ? a2.c() : 0, next.f1397j, next.f1398k);
            }
            o[] oVarArr = next.c;
            if (oVarArr != null) {
                int length = oVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (oVarArr.length <= 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        builder2.addRemoteInput(remoteInputArr[i3]);
                    }
                } else {
                    o oVar = oVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.a != null ? new Bundle(next.a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f1392e);
            if (i2 >= 24) {
                builder2.setAllowGeneratedReplies(next.f1392e);
            }
            bundle.putInt("android.support.action.semanticAction", next.f1394g);
            if (i2 >= 28) {
                builder2.setSemanticAction(next.f1394g);
            }
            if (i2 >= 29) {
                builder2.setContextual(next.f1395h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f1393f);
            builder2.addExtras(bundle);
            this.a.addAction(builder2.build());
        }
        Bundle bundle2 = iVar.f1407l;
        if (bundle2 != null) {
            this.f1408d.putAll(bundle2);
        }
        this.a.setShowWhen(iVar.f1404i);
        this.a.setLocalOnly(iVar.f1406k).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.a.setCategory(null).setColor(iVar.m).setVisibility(iVar.n).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        List<String> a3 = i2 < 28 ? a(b(iVar.c), iVar.r) : iVar.r;
        if (a3 != null && !a3.isEmpty()) {
            for (String str2 : a3) {
                this.a.addPerson(str2);
            }
        }
        if (iVar.f1399d.size() > 0) {
            if (iVar.f1407l == null) {
                iVar.f1407l = new Bundle();
            }
            Bundle bundle3 = iVar.f1407l.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i4 = 0; i4 < iVar.f1399d.size(); i4++) {
                String num = Integer.toString(i4);
                g gVar = iVar.f1399d.get(i4);
                Object obj = l.a;
                Bundle bundle6 = new Bundle();
                IconCompat a4 = gVar.a();
                bundle6.putInt("icon", a4 != null ? a4.c() : 0);
                bundle6.putCharSequence("title", gVar.f1397j);
                bundle6.putParcelable("actionIntent", gVar.f1398k);
                Bundle bundle7 = gVar.a != null ? new Bundle(gVar.a) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", gVar.f1392e);
                bundle6.putBundle("extras", bundle7);
                bundle6.putParcelableArray("remoteInputs", l.a(gVar.c));
                bundle6.putBoolean("showsUserInterface", gVar.f1393f);
                bundle6.putInt("semanticAction", gVar.f1394g);
                bundle5.putBundle(num, bundle6);
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (iVar.f1407l == null) {
                iVar.f1407l = new Bundle();
            }
            iVar.f1407l.putBundle("android.car.EXTENSIONS", bundle3);
            this.f1408d.putBundle("android.car.EXTENSIONS", bundle4);
        }
        if (i2 >= 24) {
            this.a.setExtras(iVar.f1407l).setRemoteInputHistory(null);
        }
        if (i2 >= 26) {
            this.a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(iVar.o)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i2 >= 28) {
            Iterator<n> it2 = iVar.c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder3 = this.a;
                Objects.requireNonNull(it2.next());
                builder3.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (i2 >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(iVar.p);
            this.a.setBubbleMetadata(null);
        }
    }

    public static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        c cVar = new c(list2.size() + list.size());
        cVar.addAll(list);
        cVar.addAll(list2);
        return new ArrayList(cVar);
    }

    public static List<String> b(List<n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (n nVar : list) {
            Objects.requireNonNull(nVar);
            arrayList.add("");
        }
        return arrayList;
    }
}
