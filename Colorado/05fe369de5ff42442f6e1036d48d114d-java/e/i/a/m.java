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

public class m {
    public final Notification.Builder a;
    public final k b;
    public final List<Bundle> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f1233d = new Bundle();

    public m(k kVar) {
        Notification.Action.Builder builder;
        this.b = kVar;
        Notification.Builder builder2 = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(kVar.a, kVar.p) : new Notification.Builder(kVar.a);
        this.a = builder2;
        Notification notification = kVar.r;
        builder2.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(kVar.f1225e).setContentText(kVar.f1226f).setContentInfo(null).setContentIntent(kVar.f1227g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        builder2.setSubText(kVar.f1231k).setUsesChronometer(false).setPriority(kVar.f1228h);
        Iterator<i> it = kVar.b.iterator();
        while (it.hasNext()) {
            i next = it.next();
            int i2 = Build.VERSION.SDK_INT;
            IconCompat a2 = next.a();
            if (i2 >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.e() : null, next.f1222j, next.f1223k);
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.c() : 0, next.f1222j, next.f1223k);
            }
            q[] qVarArr = next.c;
            if (qVarArr != null) {
                int length = qVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (qVarArr.length <= 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        builder.addRemoteInput(remoteInputArr[i3]);
                    }
                } else {
                    q qVar = qVarArr[0];
                    throw null;
                }
            }
            Bundle bundle = next.a != null ? new Bundle(next.a) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", next.f1217e);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                builder.setAllowGeneratedReplies(next.f1217e);
            }
            bundle.putInt("android.support.action.semanticAction", next.f1219g);
            if (i4 >= 28) {
                builder.setSemanticAction(next.f1219g);
            }
            if (i4 >= 29) {
                builder.setContextual(next.f1220h);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.f1218f);
            builder.addExtras(bundle);
            this.a.addAction(builder.build());
        }
        Bundle bundle2 = kVar.m;
        if (bundle2 != null) {
            this.f1233d.putAll(bundle2);
        }
        int i5 = Build.VERSION.SDK_INT;
        this.a.setShowWhen(kVar.f1229i);
        this.a.setLocalOnly(kVar.f1232l).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.a.setCategory(null).setColor(kVar.n).setVisibility(kVar.o).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        List<String> a3 = i5 < 28 ? a(b(kVar.c), kVar.s) : kVar.s;
        if (a3 != null && !a3.isEmpty()) {
            for (String str : a3) {
                this.a.addPerson(str);
            }
        }
        if (kVar.f1224d.size() > 0) {
            if (kVar.m == null) {
                kVar.m = new Bundle();
            }
            Bundle bundle3 = kVar.m.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i6 = 0; i6 < kVar.f1224d.size(); i6++) {
                String num = Integer.toString(i6);
                i iVar = kVar.f1224d.get(i6);
                Object obj = n.a;
                Bundle bundle6 = new Bundle();
                IconCompat a4 = iVar.a();
                bundle6.putInt("icon", a4 != null ? a4.c() : 0);
                bundle6.putCharSequence("title", iVar.f1222j);
                bundle6.putParcelable("actionIntent", iVar.f1223k);
                Bundle bundle7 = iVar.a != null ? new Bundle(iVar.a) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", iVar.f1217e);
                bundle6.putBundle("extras", bundle7);
                bundle6.putParcelableArray("remoteInputs", n.a(iVar.c));
                bundle6.putBoolean("showsUserInterface", iVar.f1218f);
                bundle6.putInt("semanticAction", iVar.f1219g);
                bundle5.putBundle(num, bundle6);
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (kVar.m == null) {
                kVar.m = new Bundle();
            }
            kVar.m.putBundle("android.car.EXTENSIONS", bundle3);
            this.f1233d.putBundle("android.car.EXTENSIONS", bundle4);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            this.a.setExtras(kVar.m).setRemoteInputHistory(null);
        }
        if (i7 >= 26) {
            this.a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(kVar.p)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator<p> it2 = kVar.c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder3 = this.a;
                Objects.requireNonNull(it2.next());
                builder3.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(kVar.q);
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
