package e.i.a;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
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

public class l {
    public final Notification.Builder a;
    public final j b;
    public final List<Bundle> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1472d = new Bundle();

    public l(j jVar) {
        Notification.Action.Builder builder;
        this.b = jVar;
        Notification.Builder builder2 = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(jVar.a, jVar.p) : new Notification.Builder(jVar.a);
        this.a = builder2;
        Notification notification = jVar.r;
        builder2.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(jVar.f1464e).setContentText(jVar.f1465f).setContentInfo(null).setContentIntent(jVar.f1466g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder2.setSubText(jVar.f1470k).setUsesChronometer(false).setPriority(jVar.f1467h);
        Iterator<h> it = jVar.b.iterator();
        while (it.hasNext()) {
            h next = it.next();
            int i2 = Build.VERSION.SDK_INT;
            IconCompat a2 = next.a();
            if (i2 >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.e() : null, next.f1461j, next.f1462k);
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.c() : 0, next.f1461j, next.f1462k);
            }
            p[] pVarArr = next.c;
            if (pVarArr != null) {
                int length = pVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (pVarArr.length <= 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        builder.addRemoteInput(remoteInputArr[i3]);
                    }
                } else {
                    p pVar = pVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.a != null ? new Bundle(next.a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f1456e);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                builder.setAllowGeneratedReplies(next.f1456e);
            }
            bundle.putInt("android.support.action.semanticAction", next.f1458g);
            if (i4 >= 28) {
                builder.setSemanticAction(next.f1458g);
            }
            if (i4 >= 29) {
                builder.setContextual(next.f1459h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f1457f);
            builder.addExtras(bundle);
            this.a.addAction(builder.build());
        }
        Bundle bundle2 = jVar.m;
        if (bundle2 != null) {
            this.f1472d.putAll(bundle2);
        }
        int i5 = Build.VERSION.SDK_INT;
        this.a.setShowWhen(jVar.f1468i);
        this.a.setLocalOnly(jVar.f1471l).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.a.setCategory(null).setColor(jVar.n).setVisibility(jVar.o).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        List<String> a3 = i5 < 28 ? a(b(jVar.c), jVar.s) : jVar.s;
        if (a3 != null && !a3.isEmpty()) {
            for (String str : a3) {
                this.a.addPerson(str);
            }
        }
        if (jVar.f1463d.size() > 0) {
            if (jVar.m == null) {
                jVar.m = new Bundle();
            }
            Bundle bundle3 = jVar.m.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i6 = 0; i6 < jVar.f1463d.size(); i6++) {
                String num = Integer.toString(i6);
                h hVar = jVar.f1463d.get(i6);
                Object obj = m.a;
                Bundle bundle6 = new Bundle();
                IconCompat a4 = hVar.a();
                bundle6.putInt("icon", a4 != null ? a4.c() : 0);
                bundle6.putCharSequence("title", hVar.f1461j);
                bundle6.putParcelable("actionIntent", hVar.f1462k);
                Bundle bundle7 = hVar.a != null ? new Bundle(hVar.a) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", hVar.f1456e);
                bundle6.putBundle("extras", bundle7);
                bundle6.putParcelableArray("remoteInputs", m.a(hVar.c));
                bundle6.putBoolean("showsUserInterface", hVar.f1457f);
                bundle6.putInt("semanticAction", hVar.f1458g);
                bundle5.putBundle(num, bundle6);
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (jVar.m == null) {
                jVar.m = new Bundle();
            }
            jVar.m.putBundle("android.car.EXTENSIONS", bundle3);
            this.f1472d.putBundle("android.car.EXTENSIONS", bundle4);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            this.a.setExtras(jVar.m).setRemoteInputHistory(null);
        }
        if (i7 >= 26) {
            this.a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(jVar.p)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator<o> it2 = jVar.c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder3 = this.a;
                Objects.requireNonNull(it2.next());
                builder3.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(jVar.q);
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

    public static List<String> b(List<o> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (o oVar : list) {
            Objects.requireNonNull(oVar);
            arrayList.add("");
        }
        return arrayList;
    }
}
