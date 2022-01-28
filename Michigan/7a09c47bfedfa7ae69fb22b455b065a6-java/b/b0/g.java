package b.b0;

import android.app.Notification;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f1035a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1036b;

    /* renamed from: c  reason: collision with root package name */
    public final Notification f1037c;

    public g(int i, Notification notification, int i2) {
        this.f1035a = i;
        this.f1037c = notification;
        this.f1036b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f1035a == gVar.f1035a && this.f1036b == gVar.f1036b) {
            return this.f1037c.equals(gVar.f1037c);
        }
        return false;
    }

    public int hashCode() {
        return this.f1037c.hashCode() + (((this.f1035a * 31) + this.f1036b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f1035a + ", mForegroundServiceType=" + this.f1036b + ", mNotification=" + this.f1037c + '}';
    }
}
