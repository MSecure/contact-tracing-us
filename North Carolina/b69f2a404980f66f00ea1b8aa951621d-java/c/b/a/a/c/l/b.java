package c.b.a.a.c.l;

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
import b.b.k.i;
import c.b.a.a.c.k.o.c0;
import c.b.a.a.c.k.o.d0;
import c.b.a.a.c.l.h;
import c.b.a.a.c.l.l;
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
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    public static final c.b.a.a.c.c[] zzce = new c.b.a.a.c.c[0];
    public final Context mContext;
    public final Handler mHandler;
    public final Object mLock;
    public int zzcf;
    public long zzcg;
    public long zzch;
    public int zzci;
    public long zzcj;
    public f0 zzck;
    public final Looper zzcl;
    public final h zzcm;
    public final c.b.a.a.c.e zzcn;
    public final Object zzco;
    public n zzcp;
    public c zzcq;
    public T zzcr;
    public final ArrayList<h<?>> zzcs;
    public i zzct;
    public int zzcu;
    public final a zzcv;
    public final AbstractC0059b zzcw;
    public final int zzcx;
    public final String zzcy;
    public c.b.a.a.c.a zzcz;
    public boolean zzda;
    public volatile a0 zzdb;
    public AtomicInteger zzdc;

    public interface a {
        void d(int i);

        void e(Bundle bundle);
    }

    /* renamed from: c.b.a.a.c.l.b$b  reason: collision with other inner class name */
    public interface AbstractC0059b {
        void c(c.b.a.a.c.a aVar);
    }

    public interface c {
        void a(c.b.a.a.c.a aVar);
    }

    public class d implements c {
        public d() {
        }

        @Override // c.b.a.a.c.l.b.c
        public void a(c.b.a.a.c.a aVar) {
            if (aVar.q()) {
                b bVar = b.this;
                bVar.getRemoteService(null, bVar.getScopes());
            } else if (b.this.zzcw != null) {
                b.this.zzcw.c(aVar);
            }
        }
    }

    public interface e {
    }

    public abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public final int f2421d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f2422e;

        public f(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.f2421d = i;
            this.f2422e = bundle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.b.a.a.c.l.b.h
        public final /* synthetic */ void b(Boolean bool) {
            c.b.a.a.c.a aVar;
            int i = this.f2421d;
            PendingIntent pendingIntent = null;
            if (i != 0) {
                if (i != 10) {
                    b.this.zza((b) 1, (int) null);
                    Bundle bundle = this.f2422e;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable(b.KEY_PENDING_INTENT);
                    }
                    aVar = new c.b.a.a.c.a(this.f2421d, pendingIntent);
                } else {
                    b.this.zza((b) 1, (int) null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), b.this.getStartServiceAction(), b.this.getServiceDescriptor()));
                }
            } else if (!d()) {
                b.this.zza((b) 1, (int) null);
                aVar = new c.b.a.a.c.a(8, null);
            } else {
                return;
            }
            c(aVar);
        }

        public abstract void c(c.b.a.a.c.a aVar);

        public abstract boolean d();
    }

    public final class g extends c.b.a.a.e.b.d {
        public g(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            h hVar = (h) message.obj;
            if (((f) hVar) != null) {
                hVar.a();
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
            if (b.this.zzdc.get() == message.arg1) {
                int i = message.what;
                if ((i == 1 || i == 7 || ((i == 4 && !b.this.enableLocalFallback()) || message.what == 5)) && !b.this.isConnecting()) {
                    a(message);
                    return;
                }
                int i2 = message.what;
                PendingIntent pendingIntent = null;
                if (i2 == 4) {
                    b.this.zzcz = new c.b.a.a.c.a(message.arg2);
                    if (!b.this.zzl() || b.this.zzda) {
                        c.b.a.a.c.a aVar = b.this.zzcz != null ? b.this.zzcz : new c.b.a.a.c.a(8);
                        b.this.zzcq.a(aVar);
                        b.this.onConnectionFailed(aVar);
                        return;
                    }
                    b.this.zza((b) 3, (int) null);
                } else if (i2 == 5) {
                    c.b.a.a.c.a aVar2 = b.this.zzcz != null ? b.this.zzcz : new c.b.a.a.c.a(8);
                    b.this.zzcq.a(aVar2);
                    b.this.onConnectionFailed(aVar2);
                } else if (i2 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    c.b.a.a.c.a aVar3 = new c.b.a.a.c.a(message.arg2, pendingIntent);
                    b.this.zzcq.a(aVar3);
                    b.this.onConnectionFailed(aVar3);
                } else if (i2 == 6) {
                    b.this.zza((b) 5, (int) null);
                    if (b.this.zzcv != null) {
                        b.this.zzcv.d(message.arg2);
                    }
                    b.this.onConnectionSuspended(message.arg2);
                    b.this.zza((b) 5, 1, (int) null);
                } else if (i2 == 2 && !b.this.isConnected()) {
                    a(message);
                } else if (b(message)) {
                    h hVar = (h) message.obj;
                    synchronized (hVar) {
                        tlistener = hVar.f2424a;
                        if (hVar.f2425b) {
                            String.valueOf(hVar).length();
                        }
                    }
                    if (tlistener != null) {
                        try {
                            hVar.b(tlistener);
                        } catch (RuntimeException e2) {
                            throw e2;
                        }
                    }
                    synchronized (hVar) {
                        hVar.f2425b = true;
                    }
                    hVar.a();
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
        public TListener f2424a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2425b = false;

        public h(TListener tlistener) {
            this.f2424a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f2424a = null;
            }
            synchronized (b.this.zzcs) {
                b.this.zzcs.remove(this);
            }
        }

        public abstract void b(TListener tlistener);
    }

    public final class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final int f2427a;

        public i(int i) {
            this.f2427a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b bVar = b.this;
            if (iBinder == null) {
                bVar.zzb((b) 16);
                return;
            }
            synchronized (bVar.zzco) {
                b bVar2 = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                bVar2.zzcp = (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new m(iBinder) : (n) queryLocalInterface;
            }
            b.this.zza(0, (Bundle) null, this.f2427a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.zzco) {
                b.this.zzcp = null;
            }
            Handler handler = b.this.mHandler;
            handler.sendMessage(handler.obtainMessage(6, this.f2427a, 1));
        }
    }

    public static final class j extends l.a {

        /* renamed from: a  reason: collision with root package name */
        public b f2429a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2430b;

        public j(b bVar, int i) {
            this.f2429a = bVar;
            this.f2430b = i;
        }
    }

    public final class k extends f {
        public final IBinder g;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        @Override // c.b.a.a.c.l.b.f
        public final void c(c.b.a.a.c.a aVar) {
            if (b.this.zzcw != null) {
                b.this.zzcw.c(aVar);
            }
            b.this.onConnectionFailed(aVar);
        }

        @Override // c.b.a.a.c.l.b.f
        public final boolean d() {
            try {
                String interfaceDescriptor = this.g.getInterfaceDescriptor();
                if (!b.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String.valueOf(b.this.getServiceDescriptor()).length();
                    String.valueOf(interfaceDescriptor).length();
                    return false;
                }
                IInterface createServiceInterface = b.this.createServiceInterface(this.g);
                if (createServiceInterface == null) {
                    return false;
                }
                if (!b.this.zza((b) 2, 4, (int) createServiceInterface) && !b.this.zza((b) 3, 4, (int) createServiceInterface)) {
                    return false;
                }
                b.this.zzcz = null;
                Bundle connectionHint = b.this.getConnectionHint();
                if (b.this.zzcv != null) {
                    b.this.zzcv.e(connectionHint);
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

        @Override // c.b.a.a.c.l.b.f
        public final void c(c.b.a.a.c.a aVar) {
            if (!b.this.enableLocalFallback() || !b.this.zzl()) {
                b.this.zzcq.a(aVar);
                b.this.onConnectionFailed(aVar);
                return;
            }
            b.this.zzb((b) 16);
        }

        @Override // c.b.a.a.c.l.b.f
        public final boolean d() {
            b.this.zzcq.a(c.b.a.a.c.a.f);
            return true;
        }
    }

    public b(Context context, Handler handler, h hVar, c.b.a.a.c.e eVar, int i2, a aVar, AbstractC0059b bVar) {
        this.mLock = new Object();
        this.zzco = new Object();
        this.zzcs = new ArrayList<>();
        this.zzcu = 1;
        this.zzcz = null;
        this.zzda = false;
        this.zzdb = null;
        this.zzdc = new AtomicInteger(0);
        i.j.t(context, "Context must not be null");
        this.mContext = context;
        i.j.t(handler, "Handler must not be null");
        this.mHandler = handler;
        this.zzcl = handler.getLooper();
        i.j.t(hVar, "Supervisor must not be null");
        this.zzcm = hVar;
        i.j.t(eVar, "API availability must not be null");
        this.zzcn = eVar;
        this.zzcx = i2;
        this.zzcv = aVar;
        this.zzcw = bVar;
        this.zzcy = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context, Looper looper, int i2, a aVar, AbstractC0059b bVar, String str) {
        this(context, looper, r3, r4, i2, aVar, bVar, str);
        h b2 = h.b(context);
        c.b.a.a.c.e eVar = c.b.a.a.c.e.f2294b;
        i.j.s(aVar);
        i.j.s(bVar);
    }

    public b(Context context, Looper looper, h hVar, c.b.a.a.c.e eVar, int i2, a aVar, AbstractC0059b bVar, String str) {
        this.mLock = new Object();
        this.zzco = new Object();
        this.zzcs = new ArrayList<>();
        this.zzcu = 1;
        this.zzcz = null;
        this.zzda = false;
        this.zzdb = null;
        this.zzdc = new AtomicInteger(0);
        i.j.t(context, "Context must not be null");
        this.mContext = context;
        i.j.t(looper, "Looper must not be null");
        this.zzcl = looper;
        i.j.t(hVar, "Supervisor must not be null");
        this.zzcm = hVar;
        i.j.t(eVar, "API availability must not be null");
        this.zzcn = eVar;
        this.mHandler = new g(looper);
        this.zzcx = i2;
        this.zzcv = aVar;
        this.zzcw = bVar;
        this.zzcy = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i2, T t) {
        f0 f0Var;
        boolean z = false;
        if ((i2 == 4) == (t != null)) {
            z = true;
        }
        i.j.i(z);
        synchronized (this.mLock) {
            this.zzcu = i2;
            this.zzcr = t;
            onSetConnectState(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (!(this.zzct == null || this.zzck == null)) {
                        String str = this.zzck.f2455a;
                        String str2 = this.zzck.f2456b;
                        String.valueOf(str).length();
                        String.valueOf(str2).length();
                        this.zzcm.c(this.zzck.f2455a, this.zzck.f2456b, this.zzck.f2457c, this.zzct, zzj(), this.zzck.f2458d);
                        this.zzdc.incrementAndGet();
                    }
                    this.zzct = new i(this.zzdc.get());
                    if (this.zzcu != 3 || getLocalStartServiceAction() == null) {
                        String startServicePackage = getStartServicePackage();
                        String startServiceAction = getStartServiceAction();
                        h.a();
                        f0Var = new f0(startServicePackage, startServiceAction, false, 129, getUseDynamicLookup());
                    } else {
                        String packageName = getContext().getPackageName();
                        String localStartServiceAction = getLocalStartServiceAction();
                        h.a();
                        f0Var = new f0(packageName, localStartServiceAction, true, 129, false);
                    }
                    this.zzck = f0Var;
                    if (!f0Var.f2458d || getMinApkVersion() >= 17895000) {
                        if (!this.zzcm.d(new h.a(this.zzck.f2455a, this.zzck.f2456b, this.zzck.f2457c, this.zzck.f2458d), this.zzct, zzj())) {
                            String str3 = this.zzck.f2455a;
                            String str4 = this.zzck.f2456b;
                            String.valueOf(str3).length();
                            String.valueOf(str4).length();
                            zza(16, (Bundle) null, this.zzdc.get());
                        }
                    } else {
                        String valueOf = String.valueOf(this.zzck.f2455a);
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                } else if (i2 == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzct != null) {
                this.zzcm.c(this.zzck.f2455a, this.zzck.f2456b, this.zzck.f2457c, this.zzct, zzj(), this.zzck.f2458d);
                this.zzct = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(a0 a0Var) {
        this.zzdb = a0Var;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(int i2, int i3, T t) {
        synchronized (this.mLock) {
            if (this.zzcu != i2) {
                return false;
            }
            zza(i3, t);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzb(int i2) {
        int i3;
        if (zzk()) {
            i3 = 5;
            this.zzda = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i3, this.zzdc.get(), 16));
    }

    private final String zzj() {
        String str = this.zzcy;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    private final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcu == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzl() {
        if (this.zzda || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
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
        int b2 = this.zzcn.b(this.mContext, getMinApkVersion());
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

    public void connect(c cVar) {
        i.j.t(cVar, "Connection progress callbacks cannot be null.");
        this.zzcq = cVar;
        zza(2, (IInterface) null);
    }

    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzdc.incrementAndGet();
        synchronized (this.zzcs) {
            int size = this.zzcs.size();
            for (int i2 = 0; i2 < size; i2++) {
                h<?> hVar = this.zzcs.get(i2);
                synchronized (hVar) {
                    hVar.f2424a = null;
                }
            }
            this.zzcs.clear();
        }
        synchronized (this.zzco) {
            this.zzcp = null;
        }
        zza(1, (IInterface) null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t;
        n nVar;
        synchronized (this.mLock) {
            i2 = this.zzcu;
            t = this.zzcr;
        }
        synchronized (this.zzco) {
            nVar = this.zzcp;
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
        if (nVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(nVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzch > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.zzch;
            String format = simpleDateFormat.format(new Date(this.zzch));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzcg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.zzcf;
            printWriter.append((CharSequence) (i3 != 1 ? i3 != 2 ? String.valueOf(i3) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzcg;
            String format2 = simpleDateFormat.format(new Date(this.zzcg));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzcj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) c.b.a.a.c.k.c.getStatusCodeString(this.zzci));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzcj;
            String format3 = simpleDateFormat.format(new Date(this.zzcj));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public abstract Account getAccount();

    public c.b.a.a.c.c[] getApiFeatures() {
        return zzce;
    }

    public final c.b.a.a.c.c[] getAvailableFeatures() {
        a0 a0Var = this.zzdb;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f2418c;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getEndpointPackageName() {
        f0 f0Var;
        if (isConnected() && (f0Var = this.zzck) != null) {
            return f0Var.f2456b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzcl;
    }

    public int getMinApkVersion() {
        return c.b.a.a.c.e.f2293a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        onPostInitHandler(8, null, null, r3.zzdc.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        return;
     */
    public void getRemoteService(j jVar, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        f fVar = new f(this.zzcx);
        fVar.f2454e = this.mContext.getPackageName();
        fVar.h = getServiceRequestExtraArgs;
        if (set != null) {
            fVar.g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            fVar.i = getAccount() != null ? getAccount() : new Account(DEFAULT_ACCOUNT, "com.google");
            if (jVar != null) {
                fVar.f = jVar.asBinder();
            }
        } else if (requiresAccount()) {
            fVar.i = getAccount();
        }
        fVar.j = zzce;
        fVar.k = getApiFeatures();
        try {
            synchronized (this.zzco) {
                if (this.zzcp != null) {
                    this.zzcp.X(new j(this, this.zzdc.get()), fVar);
                }
            }
        } catch (DeadObjectException unused) {
            triggerConnectionSuspended(1);
        } catch (SecurityException e2) {
            throw e2;
        }
    }

    public abstract Set<Scope> getScopes();

    public final T getService() {
        T t;
        synchronized (this.mLock) {
            if (this.zzcu != 5) {
                checkConnected();
                i.j.v(this.zzcr != null, "Client is connected but service is null");
                t = this.zzcr;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzco) {
            if (this.zzcp == null) {
                return null;
            }
            return this.zzcp.asBinder();
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public boolean getUseDynamicLookup() {
        return false;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcu == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzcu != 2) {
                if (this.zzcu != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void onConnectedLocked(T t) {
        this.zzch = System.currentTimeMillis();
    }

    public void onConnectionFailed(c.b.a.a.c.a aVar) {
        this.zzci = aVar.f2281c;
        this.zzcj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i2) {
        this.zzcf = i2;
        this.zzcg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    public void onSetConnectState(int i2, T t) {
    }

    public void onUserSignOut(e eVar) {
        c0 c0Var = (c0) eVar;
        c.b.a.a.c.k.o.g.this.m.post(new d0(c0Var));
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void triggerConnectionSuspended(int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.zzdc.get(), i2));
    }

    public void triggerNotAvailable(c cVar, int i2, PendingIntent pendingIntent) {
        i.j.t(cVar, "Connection progress callbacks cannot be null.");
        this.zzcq = cVar;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.zzdc.get(), i2, pendingIntent));
    }

    public final void zza(int i2, Bundle bundle, int i3) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2)));
    }
}
