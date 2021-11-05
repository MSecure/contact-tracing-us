package c.b.a.a.d.m;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.d.k.o.y;
import c.b.a.a.d.k.o.z;
import c.b.a.a.d.m.g;
import c.b.a.a.d.m.j;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<T extends IInterface> {
    @RecentlyNonNull
    public static final int CONNECT_STATE_CONNECTED = 4;
    @RecentlyNonNull
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @RecentlyNonNull
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @RecentlyNonNull
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @RecentlyNonNull
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @RecentlyNonNull
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    public static final c.b.a.a.d.c[] zzd = new c.b.a.a.d.c[0];
    public final Handler zza;
    public c.b.a.a.d.a zzaa;
    public boolean zzab;
    public volatile b0 zzac;
    @RecentlyNonNull
    public c zzb;
    @RecentlyNonNull
    public AtomicInteger zzc;
    public int zze;
    public long zzf;
    public long zzg;
    public int zzh;
    public long zzi;
    public volatile String zzj;
    public j0 zzk;
    public final Context zzl;
    public final Looper zzm;
    public final g zzn;
    public final c.b.a.a.d.e zzo;
    public final Object zzp;
    public final Object zzq;
    public l zzr;
    public T zzs;
    public final ArrayList<h<?>> zzt;
    public i zzu;
    public int zzv;
    public final a zzw;
    public final AbstractC0066b zzx;
    public final int zzy;
    public final String zzz;

    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(@RecentlyNonNull int i);
    }

    /* renamed from: c.b.a.a.d.m.b$b  reason: collision with other inner class name */
    public interface AbstractC0066b {
        void onConnectionFailed(@RecentlyNonNull c.b.a.a.d.a aVar);
    }

    public interface c {
        void a(@RecentlyNonNull c.b.a.a.d.a aVar);
    }

    public class d implements c {
        public d() {
        }

        @Override // c.b.a.a.d.m.b.c
        public void a(@RecentlyNonNull c.b.a.a.d.a aVar) {
            if (aVar.x()) {
                b bVar = b.this;
                bVar.getRemoteService(null, bVar.getScopes());
            } else if (b.this.zzx != null) {
                b.this.zzx.onConnectionFailed(aVar);
            }
        }
    }

    public interface e {
    }

    public abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public final int f3070d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f3071e;

        public f(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.f3070d = i;
            this.f3071e = bundle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.a.a.d.m.b.h
        public final /* synthetic */ void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (this.f3070d != 0) {
                b.this.zza((b) 1, (int) null);
                Bundle bundle = this.f3071e;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable(b.KEY_PENDING_INTENT);
                }
                c(new c.b.a.a.d.a(this.f3070d, pendingIntent));
            } else if (!d()) {
                b.this.zza((b) 1, (int) null);
                c(new c.b.a.a.d.a(8, null));
            }
        }

        public abstract void c(c.b.a.a.d.a aVar);

        public abstract boolean d();
    }

    public final class g extends c.b.a.a.g.c.d {
        public g(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            h hVar = (h) message.obj;
            if (((f) hVar) != null) {
                hVar.b();
                return;
            }
            throw null;
        }

        public static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        public final void handleMessage(Message message) {
            TListener tlistener;
            if (b.this.zzc.get() == message.arg1) {
                int i = message.what;
                if ((i == 1 || i == 7 || ((i == 4 && !b.this.enableLocalFallback()) || message.what == 5)) && !b.this.isConnecting()) {
                    a(message);
                    return;
                }
                int i2 = message.what;
                PendingIntent pendingIntent = null;
                if (i2 == 4) {
                    b.this.zzaa = new c.b.a.a.d.a(message.arg2);
                    if (!b.this.zzc() || b.this.zzab) {
                        c.b.a.a.d.a aVar = b.this.zzaa != null ? b.this.zzaa : new c.b.a.a.d.a(8);
                        b.this.zzb.a(aVar);
                        b.this.onConnectionFailed(aVar);
                        return;
                    }
                    b.this.zza((b) 3, (int) null);
                } else if (i2 == 5) {
                    c.b.a.a.d.a aVar2 = b.this.zzaa != null ? b.this.zzaa : new c.b.a.a.d.a(8);
                    b.this.zzb.a(aVar2);
                    b.this.onConnectionFailed(aVar2);
                } else if (i2 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    c.b.a.a.d.a aVar3 = new c.b.a.a.d.a(message.arg2, pendingIntent);
                    b.this.zzb.a(aVar3);
                    b.this.onConnectionFailed(aVar3);
                } else if (i2 == 6) {
                    b.this.zza((b) 5, (int) null);
                    if (b.this.zzw != null) {
                        b.this.zzw.onConnectionSuspended(message.arg2);
                    }
                    b.this.onConnectionSuspended(message.arg2);
                    b.this.zza((b) 5, 1, (int) null);
                } else if (i2 == 2 && !b.this.isConnected()) {
                    a(message);
                } else if (b(message)) {
                    h hVar = (h) message.obj;
                    synchronized (hVar) {
                        tlistener = hVar.f3074a;
                        if (hVar.f3075b) {
                            String.valueOf(hVar).length();
                        }
                    }
                    if (tlistener != null) {
                        try {
                            hVar.a(tlistener);
                        } catch (RuntimeException e2) {
                            throw e2;
                        }
                    }
                    synchronized (hVar) {
                        hVar.f3075b = true;
                    }
                    hVar.b();
                } else {
                    int i3 = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i3);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            } else if (b(message)) {
                a(message);
            }
        }
    }

    public abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        public TListener f3074a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3075b = false;

        public h(TListener tlistener) {
            this.f3074a = tlistener;
        }

        public abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.f3074a = null;
            }
            synchronized (b.this.zzt) {
                b.this.zzt.remove(this);
            }
        }
    }

    public final class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final int f3077a;

        public i(int i) {
            this.f3077a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                bVar.zza((b) 16);
                return;
            }
            synchronized (bVar.zzq) {
                b bVar2 = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.zzr = (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new k(iBinder) : (l) queryLocalInterface;
            }
            b.this.zza(0, (Bundle) null, this.f3077a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.zzq) {
                b.this.zzr = null;
            }
            Handler handler = b.this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.f3077a, 1));
        }
    }

    public static final class j extends j.a {

        /* renamed from: a  reason: collision with root package name */
        public b f3079a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3080b;

        public j(b bVar, int i) {
            this.f3079a = bVar;
            this.f3080b = i;
        }
    }

    public final class k extends f {

        /* renamed from: g  reason: collision with root package name */
        public final IBinder f3081g;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f3081g = iBinder;
        }

        @Override // c.b.a.a.d.m.b.f
        public final void c(c.b.a.a.d.a aVar) {
            if (b.this.zzx != null) {
                b.this.zzx.onConnectionFailed(aVar);
            }
            b.this.onConnectionFailed(aVar);
        }

        @Override // c.b.a.a.d.m.b.f
        public final boolean d() {
            try {
                IBinder iBinder = this.f3081g;
                t.C(iBinder);
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if (!b.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String.valueOf(b.this.getServiceDescriptor()).length();
                    String.valueOf(interfaceDescriptor).length();
                    return false;
                }
                IInterface createServiceInterface = b.this.createServiceInterface(this.f3081g);
                if (createServiceInterface == null) {
                    return false;
                }
                if (!b.this.zza((b) 2, 4, (int) createServiceInterface) && !b.this.zza((b) 3, 4, (int) createServiceInterface)) {
                    return false;
                }
                b.this.zzaa = null;
                Bundle connectionHint = b.this.getConnectionHint();
                if (b.this.zzw != null) {
                    b.this.zzw.onConnected(connectionHint);
                }
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public final class l extends f {
        public l(int i) {
            super(i, null);
        }

        @Override // c.b.a.a.d.m.b.f
        public final void c(c.b.a.a.d.a aVar) {
            if (!b.this.enableLocalFallback() || !b.this.zzc()) {
                b.this.zzb.a(aVar);
                b.this.onConnectionFailed(aVar);
                return;
            }
            b.this.zza((b) 16);
        }

        @Override // c.b.a.a.d.m.b.f
        public final boolean d() {
            b.this.zzb.a(c.b.a.a.d.a.f2916f);
            return true;
        }
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull Handler handler, @RecentlyNonNull g gVar, @RecentlyNonNull c.b.a.a.d.e eVar, @RecentlyNonNull int i2, a aVar, AbstractC0066b bVar) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        t.D(context, "Context must not be null");
        this.zzl = context;
        t.D(handler, "Handler must not be null");
        this.zza = handler;
        this.zzm = handler.getLooper();
        t.D(gVar, "Supervisor must not be null");
        this.zzn = gVar;
        t.D(eVar, "API availability must not be null");
        this.zzo = eVar;
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i2, @RecentlyNonNull a aVar, @RecentlyNonNull AbstractC0066b bVar, @RecentlyNonNull String str) {
        this(context, looper, r3, r4, i2, aVar, bVar, str);
        g b2 = g.b(context);
        c.b.a.a.d.e eVar = c.b.a.a.d.e.f2931b;
        t.C(aVar);
        t.C(bVar);
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull g gVar, @RecentlyNonNull c.b.a.a.d.e eVar, @RecentlyNonNull int i2, a aVar, AbstractC0066b bVar, String str) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        t.D(context, "Context must not be null");
        this.zzl = context;
        t.D(looper, "Looper must not be null");
        this.zzm = looper;
        t.D(gVar, "Supervisor must not be null");
        this.zzn = gVar;
        t.D(eVar, "API availability must not be null");
        this.zzo = eVar;
        this.zza = new g(looper);
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    private final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i2) {
        int i3;
        if (zzb()) {
            i3 = 5;
            this.zzab = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(i3, this.zzc.get(), 16));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i2, T t) {
        j0 j0Var;
        boolean z = false;
        if ((i2 == 4) == (t != null)) {
            z = true;
        }
        t.q(z);
        synchronized (this.zzp) {
            this.zzv = i2;
            this.zzs = t;
            if (i2 == 1) {
                i iVar = this.zzu;
                if (iVar != null) {
                    g gVar = this.zzn;
                    String str = this.zzk.f3133a;
                    t.C(str);
                    gVar.c(str, this.zzk.f3134b, this.zzk.f3135c, iVar, zza(), this.zzk.f3136d);
                    this.zzu = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                i iVar2 = this.zzu;
                if (!(iVar2 == null || this.zzk == null)) {
                    String str2 = this.zzk.f3133a;
                    String str3 = this.zzk.f3134b;
                    String.valueOf(str2).length();
                    String.valueOf(str3).length();
                    g gVar2 = this.zzn;
                    String str4 = this.zzk.f3133a;
                    t.C(str4);
                    gVar2.c(str4, this.zzk.f3134b, this.zzk.f3135c, iVar2, zza(), this.zzk.f3136d);
                    this.zzc.incrementAndGet();
                }
                i iVar3 = new i(this.zzc.get());
                this.zzu = iVar3;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    String startServicePackage = getStartServicePackage();
                    String startServiceAction = getStartServiceAction();
                    g.a();
                    j0Var = new j0(startServicePackage, startServiceAction, false, 4225, getUseDynamicLookup());
                } else {
                    String packageName = getContext().getPackageName();
                    String localStartServiceAction = getLocalStartServiceAction();
                    g.a();
                    j0Var = new j0(packageName, localStartServiceAction, true, 4225, false);
                }
                this.zzk = j0Var;
                if (!j0Var.f3136d || getMinApkVersion() >= 17895000) {
                    g gVar3 = this.zzn;
                    String str5 = this.zzk.f3133a;
                    t.C(str5);
                    if (!gVar3.d(new g.a(str5, this.zzk.f3134b, this.zzk.f3135c, this.zzk.f3136d), iVar3, zza())) {
                        String str6 = this.zzk.f3133a;
                        String str7 = this.zzk.f3134b;
                        String.valueOf(str6).length();
                        String.valueOf(str7).length();
                        zza(16, (Bundle) null, this.zzc.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zzk.f3133a);
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i2 == 4) {
                t.C(t);
                onConnectedLocked(t);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(b0 b0Var) {
        this.zzac = b0Var;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(int i2, int i3, T t) {
        synchronized (this.zzp) {
            if (this.zzv != i2) {
                return false;
            }
            zza(i3, t);
            return true;
        }
    }

    private final boolean zzb() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzc() {
        if (this.zzab || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void checkAvailabilityAndConnect() {
        int b2 = this.zzo.b(this.zzl, getMinApkVersion());
        if (b2 != 0) {
            zza(1, (IInterface) null);
            triggerNotAvailable(new d(), b2, null);
            return;
        }
        connect(new d());
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(@RecentlyNonNull c cVar) {
        t.D(cVar, "Connection progress callbacks cannot be null.");
        this.zzb = cVar;
        zza(2, (IInterface) null);
    }

    @RecentlyNullable
    public abstract T createServiceInterface(@RecentlyNonNull IBinder iBinder);

    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i2 = 0; i2 < size; i2++) {
                h<?> hVar = this.zzt.get(i2);
                synchronized (hVar) {
                    hVar.f3074a = null;
                }
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, (IInterface) null);
    }

    public void disconnect(@RecentlyNonNull String str) {
        this.zzj = str;
        disconnect();
    }

    public void dump(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
        int i2;
        T t;
        l lVar;
        synchronized (this.zzp) {
            i2 = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            lVar = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (lVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(lVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.zzg;
            String format = simpleDateFormat.format(new Date(this.zzg));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzf > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.zze;
            printWriter.append((CharSequence) (i3 != 1 ? i3 != 2 ? i3 != 3 ? String.valueOf(i3) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzf;
            String format2 = simpleDateFormat.format(new Date(this.zzf));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzi > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) c.b.a.a.d.k.c.getStatusCodeString(this.zzh));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzi;
            String format3 = simpleDateFormat.format(new Date(this.zzi));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @RecentlyNonNull
    public boolean enableLocalFallback() {
        return false;
    }

    @RecentlyNullable
    public abstract Account getAccount();

    @RecentlyNonNull
    public c.b.a.a.d.c[] getApiFeatures() {
        return zzd;
    }

    @RecentlyNullable
    public final c.b.a.a.d.c[] getAvailableFeatures() {
        b0 b0Var = this.zzac;
        if (b0Var == null) {
            return null;
        }
        return b0Var.f3084c;
    }

    @RecentlyNullable
    public Bundle getConnectionHint() {
        return null;
    }

    @RecentlyNonNull
    public final Context getContext() {
        return this.zzl;
    }

    @RecentlyNonNull
    public String getEndpointPackageName() {
        j0 j0Var;
        if (isConnected() && (j0Var = this.zzk) != null) {
            return j0Var.f3134b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @RecentlyNullable
    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    @RecentlyNullable
    public String getLocalStartServiceAction() {
        return null;
    }

    @RecentlyNonNull
    public final Looper getLooper() {
        return this.zzm;
    }

    @RecentlyNonNull
    public abstract int getMinApkVersion();

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
        onPostInitHandler(8, null, null, r3.zzc.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        return;
     */
    public void getRemoteService(h hVar, @RecentlyNonNull Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        e eVar = new e(this.zzy);
        eVar.f3107e = this.zzl.getPackageName();
        eVar.h = getServiceRequestExtraArgs;
        if (set != null) {
            eVar.f3109g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            eVar.i = account;
            if (hVar != null) {
                eVar.f3108f = hVar.asBinder();
            }
        } else if (requiresAccount()) {
            eVar.i = getAccount();
        }
        eVar.j = zzd;
        eVar.k = getApiFeatures();
        if (usesClientTelemetry()) {
            eVar.n = true;
        }
        try {
            synchronized (this.zzq) {
                if (this.zzr != null) {
                    this.zzr.U(new j(this, this.zzc.get()), eVar);
                }
            }
        } catch (DeadObjectException unused) {
            triggerConnectionSuspended(3);
        } catch (SecurityException e2) {
            throw e2;
        }
    }

    @RecentlyNonNull
    public abstract Set<Scope> getScopes();

    @RecentlyNonNull
    public final T getService() {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                T t2 = this.zzs;
                t.D(t2, "Client is connected but service is null");
                t = t2;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @RecentlyNullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            if (this.zzr == null) {
                return null;
            }
            return this.zzr.asBinder();
        }
    }

    public abstract String getServiceDescriptor();

    @RecentlyNonNull
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    @RecentlyNonNull
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @RecentlyNullable
    public d getTelemetryConfiguration() {
        b0 b0Var = this.zzac;
        return null;
    }

    @RecentlyNonNull
    public boolean getUseDynamicLookup() {
        return false;
    }

    @RecentlyNonNull
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @RecentlyNonNull
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            if (this.zzv != 2) {
                if (this.zzv != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void onConnectedLocked(@RecentlyNonNull T t) {
        this.zzg = System.currentTimeMillis();
    }

    public void onConnectionFailed(@RecentlyNonNull c.b.a.a.d.a aVar) {
        this.zzh = aVar.f2918c;
        this.zzi = System.currentTimeMillis();
    }

    public void onConnectionSuspended(@RecentlyNonNull int i2) {
        this.zze = i2;
        this.zzf = System.currentTimeMillis();
    }

    public void onPostInitHandler(@RecentlyNonNull int i2, IBinder iBinder, Bundle bundle, @RecentlyNonNull int i3) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    public void onUserSignOut(@RecentlyNonNull e eVar) {
        y yVar = (y) eVar;
        c.b.a.a.d.k.o.g.this.m.post(new z(yVar));
    }

    @RecentlyNonNull
    public boolean providesSignIn() {
        return false;
    }

    @RecentlyNonNull
    public boolean requiresAccount() {
        return false;
    }

    @RecentlyNonNull
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @RecentlyNonNull
    public boolean requiresSignIn() {
        return false;
    }

    public void triggerConnectionSuspended(@RecentlyNonNull int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i2));
    }

    public void triggerNotAvailable(@RecentlyNonNull c cVar, @RecentlyNonNull int i2, PendingIntent pendingIntent) {
        t.D(cVar, "Connection progress callbacks cannot be null.");
        this.zzb = cVar;
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i2, pendingIntent));
    }

    @RecentlyNonNull
    public boolean usesClientTelemetry() {
        return false;
    }

    public final void zza(@RecentlyNonNull int i2, Bundle bundle, @RecentlyNonNull int i3) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2)));
    }
}
