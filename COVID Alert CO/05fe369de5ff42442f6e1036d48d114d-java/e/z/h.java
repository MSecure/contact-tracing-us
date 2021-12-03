package e.z;

import android.app.Notification;

public final class h {
    public final int a;
    public final int b;
    public final Notification c;

    public h(int i2, Notification notification, int i3) {
        this.a = i2;
        this.c = notification;
        this.b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a == hVar.a && this.b == hVar.b) {
            return this.c.equals(hVar.c);
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
