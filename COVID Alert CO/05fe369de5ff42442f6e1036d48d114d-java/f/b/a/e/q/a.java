package f.b.a.e.q;

import android.content.ContentResolver;
import android.provider.Settings;

public class a {
    public float a(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
