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
        StringBuilder j2 = a.j("NavDeepLinkRequest", "{");
        if (this.a != null) {
            j2.append(" uri=");
            j2.append(this.a.toString());
        }
        if (this.b != null) {
            j2.append(" action=");
            j2.append(this.b);
        }
        if (this.c != null) {
            j2.append(" mimetype=");
            j2.append(this.c);
        }
        j2.append(" }");
        return j2.toString();
    }
}
