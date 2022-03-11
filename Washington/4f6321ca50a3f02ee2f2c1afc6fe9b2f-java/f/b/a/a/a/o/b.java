package f.b.a.a.a.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class b {
    public final ConnectivityManager a;

    public b(Context context) {
        this.a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = this.a;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities != null && !networkCapabilities.hasCapability(17) && networkCapabilities.hasCapability(16);
        }
        NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
