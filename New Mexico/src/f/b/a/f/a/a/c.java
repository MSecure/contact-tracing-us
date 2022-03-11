package f.b.a.f.a.a;

import f.a.a.a.a;
/* loaded from: classes.dex */
public abstract class c {
    public static c c(int i2) {
        Integer valueOf = Integer.valueOf(i2);
        Boolean bool = Boolean.FALSE;
        if (valueOf != null && bool != null) {
            return new s(valueOf.intValue(), bool.booleanValue());
        }
        StringBuilder sb = new StringBuilder();
        if (valueOf == null) {
            sb.append(" appUpdateType");
        }
        if (bool == null) {
            sb.append(" allowAssetPackDeletion");
        }
        String valueOf2 = String.valueOf(sb);
        throw new IllegalStateException(a.e(new StringBuilder(valueOf2.length() + 28), "Missing required properties:", valueOf2));
    }

    public abstract boolean a();

    public abstract int b();
}
