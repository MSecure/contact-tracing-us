package c.b.a.a.g.e;

import android.os.ParcelFileDescriptor;
import b.x.t;
import c.b.a.a.d.k.o.o;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatusCodes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class h implements o {

    /* renamed from: a  reason: collision with root package name */
    public final bb f3582a;

    /* renamed from: b  reason: collision with root package name */
    public final List f3583b;

    /* renamed from: c  reason: collision with root package name */
    public final ExposureConfiguration f3584c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3585d;

    public h(bb bbVar, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.f3582a = bbVar;
        this.f3583b = list;
        this.f3584c = exposureConfiguration;
        this.f3585d = str;
    }

    @Override // c.b.a.a.d.k.o.o
    public final void a(Object obj, Object obj2) {
        List<File> list = this.f3583b;
        ExposureConfiguration exposureConfiguration = this.f3584c;
        String str = this.f3585d;
        cb cbVar = (cb) obj;
        j jVar = (j) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            a3 a3Var = new a3(null);
            a3Var.f3496d = arrayList;
            a3Var.f3497e = exposureConfiguration;
            a3Var.f3495c = new v(arrayList, jVar);
            a3Var.f3498f = str;
            ((n2) cbVar.getService()).k(a3Var);
        } catch (FileNotFoundException e2) {
            t.L2(new Status(ExposureNotificationStatusCodes.FAILED_DISK_IO, e2.getMessage()), null, jVar);
        }
    }
}
