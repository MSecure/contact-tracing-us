package f.b.a.f.a.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import f.b.a.f.a.c.b;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class a2 implements v3 {

    /* renamed from: g */
    public static final a f3183g = new a("FakeAssetPackService");
    public final String a;
    public final y b;
    public final Context c;

    /* renamed from: d */
    public final o2 f3184d;

    /* renamed from: e */
    public final r<Executor> f3185e;

    /* renamed from: f */
    public final Handler f3186f = new Handler(Looper.getMainLooper());

    static {
        new AtomicInteger(1);
    }

    public a2(File file, y yVar, d1 d1Var, Context context, o2 o2Var, r<Executor> rVar, m2 m2Var) {
        this.a = file.getAbsolutePath();
        this.b = yVar;
        this.c = context;
        this.f3184d = o2Var;
        this.f3185e = rVar;
    }

    public static long h(int i2, long j2) {
        if (i2 == 2) {
            return j2 / 2;
        }
        if (i2 == 3 || i2 == 4) {
            return j2;
        }
        return 0;
    }

    @Override // f.b.a.f.a.b.v3
    public final void a(int i2, String str, String str2, int i3) {
        f3183g.d("notifyChunkTransferred", new Object[0]);
    }

    @Override // f.b.a.f.a.b.v3
    public final void b(int i2) {
        f3183g.d("notifySessionFailed", new Object[0]);
    }

    @Override // f.b.a.f.a.b.v3
    public final void c() {
        f3183g.d("keepAlive", new Object[0]);
    }

    @Override // f.b.a.f.a.b.v3
    public final void d(List<String> list) {
        f3183g.d("cancelDownload(%s)", list);
    }

    @Override // f.b.a.f.a.b.v3
    public final void e(int i2, String str) {
        f3183g.d("notifyModuleCompleted", new Object[0]);
        this.f3185e.a().execute(new Runnable(i2, str) { // from class: f.b.a.f.a.b.y1
            public final /* synthetic */ int c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f3342d;

            {
                this.c = r2;
                this.f3342d = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a2 a2Var = a2.this;
                int i3 = this.c;
                String str2 = this.f3342d;
                Objects.requireNonNull(a2Var);
                try {
                    a2Var.i(i3, str2, 4);
                } catch (b e2) {
                    a2.f3183g.e("notifyModuleCompleted failed", e2);
                }
            }
        });
    }

    @Override // f.b.a.f.a.b.v3
    public final f.b.a.f.a.h.r<List<String>> f(Map<String, Long> map) {
        f3183g.d("syncPacks()", new Object[0]);
        ArrayList arrayList = new ArrayList();
        f.b.a.f.a.h.r<List<String>> rVar = new f.b.a.f.a.h.r<>();
        rVar.g(arrayList);
        return rVar;
    }

    @Override // f.b.a.f.a.b.v3
    public final f.b.a.f.a.h.r<ParcelFileDescriptor> g(int i2, String str, String str2, int i3) {
        File[] j2;
        int i4;
        f3183g.d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        f.b.a.f.a.h.r<ParcelFileDescriptor> rVar = new f.b.a.f.a.h.r<>();
        try {
            j2 = j(str);
        } catch (b e2) {
            f3183g.e("getChunkFileDescriptor failed", e2);
            rVar.f(e2);
        } catch (FileNotFoundException e3) {
            f3183g.e("getChunkFileDescriptor failed", e3);
            rVar.f(new b("Asset Slice file not found.", e3));
        }
        for (File file : j2) {
            if (f.b.a.c.b.o.b.F1(file).equals(str2)) {
                rVar.g(ParcelFileDescriptor.open(file, 268435456));
                return rVar;
            }
        }
        throw new b(String.format("Local testing slice for '%s' not found.", str2));
    }

    public final Bundle i(int i2, String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f3184d.a());
        bundle.putInt("session_id", i2);
        File[] j2 = j(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long j3 = 0;
        for (File file : j2) {
            j3 += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i3 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String F1 = f.b.a.c.b.o.b.F1(file);
            bundle.putParcelableArrayList(f.b.a.c.b.o.b.L1("chunk_intents", str, F1), arrayList2);
            try {
                bundle.putString(f.b.a.c.b.o.b.L1("uncompressed_hash_sha256", str, F1), f.b.a.c.b.o.b.I1(Arrays.asList(file)));
                bundle.putLong(f.b.a.c.b.o.b.L1("uncompressed_size", str, F1), file.length());
                arrayList.add(F1);
            } catch (IOException e2) {
                throw new b(String.format("Could not digest file: %s.", file), e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new b("SHA256 algorithm not supported.", e3);
            }
        }
        bundle.putStringArrayList(f.b.a.c.b.o.b.G1("slice_ids", str), arrayList);
        bundle.putLong(f.b.a.c.b.o.b.G1("pack_version", str), (long) this.f3184d.a());
        bundle.putInt(f.b.a.c.b.o.b.G1("status", str), i3);
        bundle.putInt(f.b.a.c.b.o.b.G1("error_code", str), 0);
        bundle.putLong(f.b.a.c.b.o.b.G1("bytes_downloaded", str), h(i3, j3));
        bundle.putLong(f.b.a.c.b.o.b.G1("total_bytes_to_download", str), j3);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", h(i3, j3));
        bundle.putLong("total_bytes_to_download", j3);
        this.f3186f.post(new Runnable(new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)) { // from class: f.b.a.f.a.b.z1
            public final /* synthetic */ Intent c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a2 a2Var = a2.this;
                a2Var.b.a(a2Var.c, this.c);
            }
        });
        return bundle;
    }

    public final File[] j(String str) {
        File file = new File(this.a);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter(str) { // from class: f.b.a.f.a.b.x1
                public final /* synthetic */ String a;

                {
                    this.a = r1;
                }

                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str2) {
                    return str2.startsWith(String.valueOf(this.a).concat("-")) && str2.endsWith(".apk");
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                if (length != 0) {
                    for (File file2 : listFiles) {
                        if (f.b.a.c.b.o.b.F1(file2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new b(String.format("No master slice available for pack '%s'.", str));
                }
                throw new b(String.format("No APKs available for pack '%s'.", str));
            }
            throw new b(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        throw new b(String.format("Local testing directory '%s' not found.", file));
    }
}
