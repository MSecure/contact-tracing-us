package gov.michigan.MiCovidExposure;

import c.b.b.e.a.v;
import d.a;
import gov.michigan.MiCovidExposure.network.WorkScheduler;
import gov.michigan.MiCovidExposure.slices.SlicePermissionManager;
import java.util.Optional;

public final class ExposureNotificationApplication_MembersInjector implements a<ExposureNotificationApplication> {
    public final f.a.a<v> lightweightExecutorProvider;
    public final f.a.a<Optional<SlicePermissionManager>> slicePermissionManagerProvider;
    public final f.a.a<b.b0.v> workManagerProvider;
    public final f.a.a<WorkScheduler> workSchedulerProvider;
    public final f.a.a<b.m.a.a> workerFactoryProvider;

    public ExposureNotificationApplication_MembersInjector(f.a.a<b.m.a.a> aVar, f.a.a<b.b0.v> aVar2, f.a.a<v> aVar3, f.a.a<WorkScheduler> aVar4, f.a.a<Optional<SlicePermissionManager>> aVar5) {
        this.workerFactoryProvider = aVar;
        this.workManagerProvider = aVar2;
        this.lightweightExecutorProvider = aVar3;
        this.workSchedulerProvider = aVar4;
        this.slicePermissionManagerProvider = aVar5;
    }

    public static a<ExposureNotificationApplication> create(f.a.a<b.m.a.a> aVar, f.a.a<b.b0.v> aVar2, f.a.a<v> aVar3, f.a.a<WorkScheduler> aVar4, f.a.a<Optional<SlicePermissionManager>> aVar5) {
        return new ExposureNotificationApplication_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static void injectLightweightExecutor(ExposureNotificationApplication exposureNotificationApplication, v vVar) {
        exposureNotificationApplication.lightweightExecutor = vVar;
    }

    public static void injectSlicePermissionManager(ExposureNotificationApplication exposureNotificationApplication, Optional<SlicePermissionManager> optional) {
        exposureNotificationApplication.slicePermissionManager = optional;
    }

    public static void injectWorkManager(ExposureNotificationApplication exposureNotificationApplication, b.b0.v vVar) {
        exposureNotificationApplication.workManager = vVar;
    }

    public static void injectWorkScheduler(ExposureNotificationApplication exposureNotificationApplication, WorkScheduler workScheduler) {
        exposureNotificationApplication.workScheduler = workScheduler;
    }

    public static void injectWorkerFactory(ExposureNotificationApplication exposureNotificationApplication, b.m.a.a aVar) {
        exposureNotificationApplication.workerFactory = aVar;
    }

    public void injectMembers(ExposureNotificationApplication exposureNotificationApplication) {
        injectWorkerFactory(exposureNotificationApplication, this.workerFactoryProvider.get());
        injectWorkManager(exposureNotificationApplication, this.workManagerProvider.get());
        injectLightweightExecutor(exposureNotificationApplication, this.lightweightExecutorProvider.get());
        injectWorkScheduler(exposureNotificationApplication, this.workSchedulerProvider.get());
        injectSlicePermissionManager(exposureNotificationApplication, this.slicePermissionManagerProvider.get());
    }
}
