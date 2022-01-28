package b.z;

import android.app.Notification;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f1919a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1920b;

    /* renamed from: c  reason: collision with root package name */
    public final Notification f1921c;

    public g(int i, Notification notification, int i2) {
        this.f1919a = i;
        this.f1921c = notification;
        this.f1920b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f1919a == gVar.f1919a && this.f1920b == gVar.f1920b) {
            return this.f1921c.equals(gVar.f1921c);
        }
        return false;
    }

    public int hashCode() {
        return this.f1921c.hashCode() + (((this.f1919a * 31) + this.f1920b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f1919a + ", mForegroundServiceType=" + this.f1920b + ", mNotification=" + this.f1921c + '}';
    }
}
