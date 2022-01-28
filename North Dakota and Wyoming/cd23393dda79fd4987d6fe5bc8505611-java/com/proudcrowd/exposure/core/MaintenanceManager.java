package com.proudcrowd.exposure.core;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.datamodel.PartyDetail;
import com.proudcrowd.exposure.datasource.PartiesDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.storage.ExposureRepository;
import com.proudcrowd.exposure.storage.KeyScanRepository;
import com.proudcrowd.exposure.storage.PartyEntity;
import com.proudcrowd.exposure.storage.PartyRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class MaintenanceManager {
    private static final int EXPOSURE_EXPIRATION_DAYS = -14;
    private static final int SCAN_EXPIRATION_DAYS = -5;

    public static ListenableFuture<Void> execute(ExposureApplication exposureApplication) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Calendar instance = Calendar.getInstance(timeZone);
        instance.add(5, EXPOSURE_EXPIRATION_DAYS);
        long timeInMillis = instance.getTimeInMillis();
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.add(5, SCAN_EXPIRATION_DAYS);
        long timeInMillis2 = instance2.getTimeInMillis();
        PartyRepository partyRepository = new PartyRepository(exposureApplication);
        KeyScanRepository keyScanRepository = new KeyScanRepository(exposureApplication);
        return FluentFuture.from(new PartiesDataSource(exposureApplication.mDeviceGuid, exposureApplication.mStudy.id, null).ExecuteFutureRequest()).transform($$Lambda$MaintenanceManager$LNO_uJeclGnAH0AkFnIqTbQHON4.INSTANCE, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction() {
            /* class com.proudcrowd.exposure.core.$$Lambda$MaintenanceManager$kktnQKKJaacp6MgJrrQwoPrLkz8 */

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return PartyRepository.this.mergeAsync((List) obj);
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction(timeInMillis) {
            /* class com.proudcrowd.exposure.core.$$Lambda$MaintenanceManager$zbLNFVlBxa6NiCXpa59cY2UGs1U */
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                Void r4 = (Void) obj;
                return ExposureRepository.this.deleteRecentAsync(this.f$1);
            }
        }, AppExecutors.getBackgroundExecutor()).transformAsync(new AsyncFunction(timeInMillis2) {
            /* class com.proudcrowd.exposure.core.$$Lambda$MaintenanceManager$dEIFP_41KCCujO2JV0FDot8er1Q */
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                Void r4 = (Void) obj;
                return KeyScanRepository.this.deleteRecentAsync(this.f$1);
            }
        }, AppExecutors.getBackgroundExecutor());
    }

    /* access modifiers changed from: private */
    public static List<PartyEntity> toPartyEntities(ArrayList<PartyDetail> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<PartyDetail> it = arrayList.iterator();
        while (it.hasNext()) {
            PartyDetail next = it.next();
            arrayList2.add(PartyEntity.create(next.id, next.name, next.constituentName, next.imageUrl, next.instructions));
        }
        return arrayList2;
    }
}
