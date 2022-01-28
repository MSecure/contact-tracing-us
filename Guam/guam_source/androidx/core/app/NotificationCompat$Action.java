package androidx.core.app;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

public class NotificationCompat$Action {
    public PendingIntent actionIntent;
    @Deprecated
    public int icon;
    public boolean mAllowGeneratedReplies;
    public final RemoteInput[] mDataOnlyRemoteInputs;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mIsContextual;
    public final RemoteInput[] mRemoteInputs;
    public final int mSemanticAction;
    public boolean mShowsUserInterface;
    public CharSequence title;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    public NotificationCompat$Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        int i2;
        IconCompat createWithResource = i == 0 ? null : IconCompat.createWithResource(null, "", i);
        Bundle bundle = new Bundle();
        this.mShowsUserInterface = true;
        this.mIcon = createWithResource;
        if (createWithResource != null) {
            i2 = createWithResource.mType;
            if (i2 == -1) {
                int i3 = Build.VERSION.SDK_INT;
                Icon icon2 = (Icon) createWithResource.mObj1;
                if (i3 >= 28) {
                    i2 = icon2.getType();
                } else {
                    try {
                        i2 = ((Integer) icon2.getClass().getMethod("getType", new Class[0]).invoke(icon2, new Object[0])).intValue();
                    } catch (IllegalAccessException e) {
                        Log.e("IconCompat", "Unable to get icon type " + icon2, e);
                    } catch (InvocationTargetException e2) {
                        Log.e("IconCompat", "Unable to get icon type " + icon2, e2);
                    } catch (NoSuchMethodException e3) {
                        Log.e("IconCompat", "Unable to get icon type " + icon2, e3);
                    }
                }
            }
            if (i2 == 2) {
                this.icon = createWithResource.getResId();
            }
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mRemoteInputs = null;
        this.mDataOnlyRemoteInputs = null;
        this.mAllowGeneratedReplies = true;
        this.mSemanticAction = 0;
        this.mShowsUserInterface = true;
        this.mIsContextual = false;
        i2 = -1;
        if (i2 == 2) {
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mRemoteInputs = null;
        this.mDataOnlyRemoteInputs = null;
        this.mAllowGeneratedReplies = true;
        this.mSemanticAction = 0;
        this.mShowsUserInterface = true;
        this.mIsContextual = false;
    }

    public IconCompat getIconCompat() {
        int i;
        if (this.mIcon == null && (i = this.icon) != 0) {
            this.mIcon = IconCompat.createWithResource(null, "", i);
        }
        return this.mIcon;
    }
}
