package c.b.a.a.e.c;

import android.os.ParcelFileDescriptor;
import b.b.k.i;
import c.b.a.a.c.k.o.o;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatusCodes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class h implements o {

    /* renamed from: a  reason: collision with root package name */
    public final bb f2597a;

    /* renamed from: b  reason: collision with root package name */
    public final List f2598b;

    /* renamed from: c  reason: collision with root package name */
    public final ExposureConfiguration f2599c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2600d;

    public h(bb bbVar, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.f2597a = bbVar;
        this.f2598b = list;
        this.f2599c = exposureConfiguration;
        this.f2600d = str;
    }

    @Override // c.b.a.a.c.k.o.o
    public final void a(Object obj, Object obj2) {
        List<File> list = this.f2598b;
        ExposureConfiguration exposureConfiguration = this.f2599c;
        String str = this.f2600d;
        cb cbVar = (cb) obj;
        i iVar = (i) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            a3 a3Var = new a3(null);
            a3Var.f2515d = arrayList;
            a3Var.f2516e = exposureConfiguration;
            a3Var.f2514c = new v(arrayList, iVar);
            a3Var.f = str;
            ((n2) cbVar.getService()).n(a3Var);
        } catch (FileNotFoundException e2) {
            i.j.a1(new Status(ExposureNotificationStatusCodes.FAILED_DISK_IO, e2.getMessage()), null, iVar);
        }
    }
}
