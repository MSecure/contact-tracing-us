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

public class m {
    public final Notification.Builder a;
    public final k b;
    public final List<Bundle> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1422d = new Bundle();

    public m(k kVar) {
        Notification.Builder builder;
        Notification.Action.Builder builder2;
        int i2 = Build.VERSION.SDK_INT;
        this.b = kVar;
        Context context = kVar.a;
        if (i2 >= 26) {
            String str = kVar.o;
        } else {
            builder = new Notification.Builder(context);
        }
        this.a = builder;
        Notification notification = kVar.q;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(kVar.f1414e).setContentText(kVar.f1415f).setContentInfo(null).setContentIntent(kVar.f1416g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(kVar.f1417h);
        Iterator<i> it = kVar.b.iterator();
        while (it.hasNext()) {
            i next = it.next();
            IconCompat a2 = next.a();
            if (i2 >= 23) {
                builder2 = new Notification.Action.Builder(a2 != null ? a2.e() : null, next.f1411j, next.f1412k);
            } else {
                builder2 = new Notification.Action.Builder(a2 != null ? a2.c() : 0, next.f1411j, next.f1412k);
            }
            q[] qVarArr = next.c;
            if (qVarArr != null) {
                int length = qVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (qVarArr.length <= 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        builder2.addRemoteInput(remoteInputArr[i3]);
                    }
                } else {
                    q qVar = qVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.a != null ? new Bundle(next.a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f1406e);
            if (i2 >= 24) {
                builder2.setAllowGeneratedReplies(next.f1406e);
            }
            bundle.putInt("android.support.action.semanticAction", next.f1408g);
            if (i2 >= 28) {
                builder2.setSemanticAction(next.f1408g);
            }
            if (i2 >= 29) {
                builder2.setContextual(next.f1409h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f1407f);
            builder2.addExtras(bundle);
            this.a.addAction(builder2.build());
        }
        Bundle bundle2 = kVar.f1421l;
        if (bundle2 != null) {
            this.f1422d.putAll(bundle2);
        }
        this.a.setShowWhen(kVar.f1418i);
        this.a.setLocalOnly(kVar.f1420k).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.a.setCategory(null).setColor(kVar.m).setVisibility(kVar.n).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        List<String> a3 = i2 < 28 ? a(b(kVar.c), kVar.r) : kVar.r;
        if (a3 != null && !a3.isEmpty()) {
            for (String str2 : a3) {
                this.a.addPerson(str2);
            }
        }
        if (kVar.f1413d.size() > 0) {
            if (kVar.f1421l == null) {
                kVar.f1421l = new Bundle();
            }
            Bundle bundle3 = kVar.f1421l.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i4 = 0; i4 < kVar.f1413d.size(); i4++) {
                String num = Integer.toString(i4);
                i iVar = kVar.f1413d.get(i4);
                Object obj = n.a;
                Bundle bundle6 = new Bundle();
                IconCompat a4 = iVar.a();
                bundle6.putInt("icon", a4 != null ? a4.c() : 0);
                bundle6.putCharSequence("title", iVar.f1411j);
                bundle6.putParcelable("actionIntent", iVar.f1412k);
                Bundle bundle7 = iVar.a != null ? new Bundle(iVar.a) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", iVar.f1406e);
                bundle6.putBundle("extras", bundle7);
                bundle6.putParcelableArray("remoteInputs", n.a(iVar.c));
                bundle6.putBoolean("showsUserInterface", iVar.f1407f);
                bundle6.putInt("semanticAction", iVar.f1408g);
                bundle5.putBundle(num, bundle6);
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (kVar.f1421l == null) {
                kVar.f1421l = new Bundle();
            }
            kVar.f1421l.putBundle("android.car.EXTENSIONS", bundle3);
            this.f1422d.putBundle("android.car.EXTENSIONS", bundle4);
        }
        if (i2 >= 24) {
            this.a.setExtras(kVar.f1421l).setRemoteInputHistory(null);
        }
        if (i2 >= 26) {
            this.a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(kVar.o)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i2 >= 28) {
            Iterator<p> it2 = kVar.c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder3 = this.a;
                Objects.requireNonNull(it2.next());
                builder3.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (i2 >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(kVar.p);
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

    public static List<String> b(List<p> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (p pVar : list) {
            Objects.requireNonNull(pVar);
            arrayList.add("");
        }
        return arrayList;
    }
}
