package e.r;

import android.content.Intent;
import android.net.Uri;
import f.a.a.a.a;

public class i {
    public final Uri a;
    public final String b;
    public final String c;

    public i(Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.a = data;
        this.b = action;
        this.c = type;
    }

    public String toString() {
        StringBuilder i2 = a.i("NavDeepLinkRequest", "{");
        if (this.a != null) {
            i2.append(" uri=");
            i2.append(this.a.toString());
        }
        if (this.b != null) {
            i2.append(" action=");
            i2.append(this.b);
        }
        if (this.c != null) {
            i2.append(" mimetype=");
            i2.append(this.c);
        }
        i2.append(" }");
        return i2.toString();
    }
}
