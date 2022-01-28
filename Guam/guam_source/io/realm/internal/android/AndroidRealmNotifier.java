package io.realm.internal.android;

import android.os.Handler;
import android.os.Looper;
import io.realm.internal.Capabilities;
import io.realm.internal.Keep;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.RealmNotifier;

@Keep
public class AndroidRealmNotifier extends RealmNotifier {
    public Handler handler;

    public AndroidRealmNotifier(OsSharedRealm osSharedRealm, Capabilities capabilities) {
        super(osSharedRealm);
        if (((AndroidCapabilities) capabilities).canDeliverNotification()) {
            this.handler = new Handler(Looper.myLooper());
        } else {
            this.handler = null;
        }
    }

    @Override // io.realm.internal.RealmNotifier
    public boolean post(Runnable runnable) {
        Handler handler2 = this.handler;
        return handler2 != null && handler2.post(runnable);
    }
}
