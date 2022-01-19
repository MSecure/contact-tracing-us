package androidx.core.app;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.react.modules.dialog.DialogModule;

public class NotificationCompatJellybean {
    public static final Object sExtrasLock = new Object();

    public static Bundle getBundleForAction(NotificationCompat$Action notificationCompat$Action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = notificationCompat$Action.getIconCompat();
        bundle2.putInt("icon", iconCompat != null ? iconCompat.getResId() : 0);
        bundle2.putCharSequence(DialogModule.KEY_TITLE, notificationCompat$Action.title);
        bundle2.putParcelable("actionIntent", notificationCompat$Action.actionIntent);
        if (notificationCompat$Action.mExtras != null) {
            bundle = new Bundle(notificationCompat$Action.mExtras);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action.mAllowGeneratedReplies);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", toBundleArray(notificationCompat$Action.mRemoteInputs));
        bundle2.putBoolean("showsUserInterface", notificationCompat$Action.mShowsUserInterface);
        bundle2.putInt("semanticAction", notificationCompat$Action.mSemanticAction);
        return bundle2;
    }

    public static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        if (remoteInputArr.length <= 0) {
            return bundleArr;
        }
        RemoteInput remoteInput = remoteInputArr[0];
        new Bundle();
        throw null;
    }
}
