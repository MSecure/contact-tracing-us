package f.b.a.f.a.e;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.play.core.assetpacks.ExtractionForegroundService;
import f.b.a.f.a.b.d0;
import f.b.a.f.a.b.w;
import f.b.a.f.a.b.x0;
/* loaded from: classes.dex */
public abstract class i0 extends w implements IInterface {
    public i0() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    @Override // f.b.a.f.a.e.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        Bundle bundle;
        j0 j0Var = null;
        if (i2 == 2) {
            Bundle bundle2 = (Bundle) x.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                j0Var = queryLocalInterface instanceof j0 ? (j0) queryLocalInterface : new j0(readStrongBinder);
            }
            w wVar = (w) this;
            synchronized (wVar) {
                wVar.a.a("updateServiceState AIDL call", new Object[0]);
                if (n.b(wVar.b) && n.a(wVar.b)) {
                    int i4 = bundle2.getInt("action_type");
                    x0 x0Var = wVar.f3329e;
                    synchronized (x0Var.b) {
                        x0Var.b.add(j0Var);
                    }
                    if (i4 == 1) {
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 26) {
                            String string = bundle2.getString("notification_channel_name");
                            synchronized (wVar) {
                                if (string == null) {
                                    string = "File downloads by Play";
                                }
                                wVar.f3330f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", string, 2));
                            }
                        }
                        wVar.f3328d.a(true);
                        x0 x0Var2 = wVar.f3329e;
                        String string2 = bundle2.getString("notification_title");
                        String string3 = bundle2.getString("notification_subtext");
                        long j2 = bundle2.getLong("notification_timeout", 600000);
                        Parcelable parcelable = bundle2.getParcelable("notification_on_click_intent");
                        Notification.Builder timeoutAfter = i5 >= 26 ? new Notification.Builder(wVar.b, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j2) : new Notification.Builder(wVar.b).setPriority(-2);
                        if (parcelable instanceof PendingIntent) {
                            timeoutAfter.setContentIntent((PendingIntent) parcelable);
                        }
                        Notification.Builder ongoing = timeoutAfter.setSmallIcon(17301633).setOngoing(false);
                        if (string2 == null) {
                            string2 = "Downloading additional file";
                        }
                        Notification.Builder contentTitle = ongoing.setContentTitle(string2);
                        if (string3 == null) {
                            string3 = "Transferring";
                        }
                        contentTitle.setSubText(string3);
                        int i6 = bundle2.getInt("notification_color");
                        if (i6 != 0) {
                            timeoutAfter.setColor(i6).setVisibility(-1);
                        }
                        x0Var2.f3335e = timeoutAfter.build();
                        wVar.b.bindService(new Intent(wVar.b, ExtractionForegroundService.class), wVar.f3329e, 1);
                    } else if (i4 == 2) {
                        wVar.f3328d.a(false);
                        x0 x0Var3 = wVar.f3329e;
                        x0Var3.a.a("Stopping foreground installation service.", new Object[0]);
                        x0Var3.c.unbindService(x0Var3);
                        ExtractionForegroundService extractionForegroundService = x0Var3.f3334d;
                        if (extractionForegroundService != null) {
                            synchronized (extractionForegroundService) {
                                extractionForegroundService.stopForeground(true);
                                extractionForegroundService.stopSelf();
                            }
                        }
                        x0Var3.a();
                    } else {
                        wVar.a.b("Unknown action type received: %d", Integer.valueOf(i4));
                        bundle = new Bundle();
                        j0Var.B(bundle);
                    }
                }
                bundle = new Bundle();
                j0Var.B(bundle);
            }
        } else if (i2 != 3) {
            return false;
        } else {
            Bundle bundle3 = (Bundle) x.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                j0Var = queryLocalInterface2 instanceof j0 ? (j0) queryLocalInterface2 : new j0(readStrongBinder2);
            }
            w wVar2 = (w) this;
            wVar2.a.a("clearAssetPackStorage AIDL call", new Object[0]);
            if (!n.b(wVar2.b) || !n.a(wVar2.b)) {
                j0Var.B(new Bundle());
            } else {
                d0.j(wVar2.c.g());
                Bundle bundle4 = new Bundle();
                Parcel p = j0Var.p();
                int i7 = x.a;
                p.writeInt(1);
                bundle4.writeToParcel(p, 0);
                j0Var.z(4, p);
            }
        }
        return true;
    }
}
