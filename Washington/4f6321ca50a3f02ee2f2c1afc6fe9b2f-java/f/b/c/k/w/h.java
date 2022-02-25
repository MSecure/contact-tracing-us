package f.b.c.k.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import f.b.c.k.w.i;
import f.b.c.k.x.g;
import java.util.ArrayList;
import java.util.List;

public final class h implements i {
    public final Context a;
    public final ConnectivityManager b;
    public final List<g<i.a>> c = new ArrayList();

    public class a extends ConnectivityManager.NetworkCallback {
        public a(g gVar) {
        }

        public void onAvailable(Network network) {
            synchronized (h.this.c) {
                for (g<i.a> gVar : h.this.c) {
                    gVar.a(i.a.REACHABLE);
                }
            }
        }

        public void onLost(Network network) {
            synchronized (h.this.c) {
                for (g<i.a> gVar : h.this.c) {
                    gVar.a(i.a.UNREACHABLE);
                }
            }
        }
    }

    public class b extends BroadcastReceiver {
        public boolean a = false;

        public b(g gVar) {
        }

        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = this.a;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            this.a = z2;
            if (z2 && !z) {
                synchronized (h.this.c) {
                    for (g<i.a> gVar : h.this.c) {
                        gVar.a(i.a.REACHABLE);
                    }
                }
            } else if (!z2 && z) {
                synchronized (h.this.c) {
                    for (g<i.a> gVar2 : h.this.c) {
                        gVar2.a(i.a.UNREACHABLE);
                    }
                }
            }
        }
    }

    public h(Context context) {
        f.b.a.c.b.o.b.a1(context != null, "Context must be non-null", new Object[0]);
        this.a = context;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.b = connectivityManager;
        if (Build.VERSION.SDK_INT < 24 || connectivityManager == null) {
            context.registerReceiver(new b(null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            connectivityManager.registerDefaultNetworkCallback(new a(null));
        }
    }
}
