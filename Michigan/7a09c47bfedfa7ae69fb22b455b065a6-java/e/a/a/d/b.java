package e.a.a.d;

import c.b.a.a.j.h;
import c.b.a.a.j.i;
import gov.michigan.MiCovidExposure.nearby.ExposureNotificationClientWrapper;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExposureNotificationClientWrapper f6255a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f6256b;

    public /* synthetic */ b(ExposureNotificationClientWrapper exposureNotificationClientWrapper, List list) {
        this.f6255a = exposureNotificationClientWrapper;
        this.f6256b = list;
    }

    @Override // c.b.a.a.j.h
    public final i a(Object obj) {
        return this.f6255a.b(this.f6256b, (Boolean) obj);
    }
}
