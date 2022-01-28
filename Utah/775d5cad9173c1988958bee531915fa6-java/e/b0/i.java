package e.b0;

import android.app.Notification;

public final class i {
    public final int a;
    public final int b;
    public final Notification c;

    public i(int i2, Notification notification, int i3) {
        this.a = i2;
        this.c = notification;
        this.b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.a == iVar.a && this.b == iVar.b) {
            return this.c.equals(iVar.c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
