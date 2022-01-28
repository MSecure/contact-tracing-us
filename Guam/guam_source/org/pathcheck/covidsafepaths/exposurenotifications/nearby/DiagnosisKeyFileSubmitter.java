package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.horcrux.svg.PathParser;
import io.realm.Realm;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$8EBZxwRqhB4agmxRa7jYn8PXErw;
import org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$mty3sf02DqzyBRsNokyNOt8XuWQ;
import org.pathcheck.covidsafepaths.exposurenotifications.ExposureNotificationClientWrapper;
import org.pathcheck.covidsafepaths.exposurenotifications.common.AppExecutors;
import org.pathcheck.covidsafepaths.exposurenotifications.network.AutoValue_KeyFileBatch;
import org.pathcheck.covidsafepaths.exposurenotifications.network.KeyFileBatch;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.RealmSecureStorageBte$upsertLastProcessedKeyZipFileName$$inlined$use$lambda$1;
import org.threeten.bp.Duration;

public class DiagnosisKeyFileSubmitter {
    public final ExposureNotificationClientWrapper client;

    static {
        Duration.ofMinutes(30);
    }

    public DiagnosisKeyFileSubmitter(Context context) {
        this.client = ExposureNotificationClientWrapper.get(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        com.horcrux.svg.PathParser.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        throw r3;
     */
    public static Void lambda$submitBatches$1(List list, Void r3) {
        if (!list.isEmpty()) {
            ImmutableList<Uri> immutableList = ((AutoValue_KeyFileBatch) ((KeyFileBatch) list.get(list.size() - 1))).uris;
            if (!immutableList.isEmpty()) {
                String replace = immutableList.get(immutableList.size() - 1).toString().replace("https://cdn.projectaurora.cloud/", "");
                RealmSecureStorageBte realmSecureStorageBte = RealmSecureStorageBte.INSTANCE;
                Intrinsics.checkNotNullParameter(replace, "name");
                Realm realmInstance = realmSecureStorageBte.getRealmInstance();
                realmInstance.executeTransaction(new RealmSecureStorageBte$upsertLastProcessedKeyZipFileName$$inlined$use$lambda$1(replace));
                PathParser.closeFinally(realmInstance, null);
            }
        }
        return r3;
    }

    public static void lambda$submitFiles$0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UnmodifiableListIterator<File> listIterator = ((AutoValue_KeyFileBatch) ((KeyFileBatch) it.next())).files.listIterator();
            while (listIterator.hasNext()) {
                ((File) listIterator.next()).delete();
            }
        }
    }

    public ListenableFuture<?> submitFiles(List<KeyFileBatch> list) {
        if (list.isEmpty()) {
            return ImmediateFuture.NULL;
        }
        list.size();
        list.size();
        ArrayList arrayList = new ArrayList();
        Iterator<KeyFileBatch> it = list.iterator();
        while (it.hasNext()) {
            AutoValue_KeyFileBatch autoValue_KeyFileBatch = (AutoValue_KeyFileBatch) it.next();
            arrayList.addAll(autoValue_KeyFileBatch.files);
            autoValue_KeyFileBatch.files.size();
        }
        ExposureNotificationClientWrapper exposureNotificationClientWrapper = this.client;
        ExposureConfigurations exposureConfigurations = exposureNotificationClientWrapper.config;
        if (exposureConfigurations != null) {
            ListenableFuture future = AppCompatDelegateImpl.ConfigurationImplApi17.getFuture(new ExposureConfigurations$refresh$1(exposureConfigurations));
            Intrinsics.checkNotNullExpressionValue(future, "CallbackToFutureAdapter.…        request\n        }");
            FluentFuture transform = FluentFuture.from(FluentFuture.from(future).catching(Exception.class, $$Lambda$ExposureNotificationClientWrapper$8EBZxwRqhB4agmxRa7jYn8PXErw.INSTANCE, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction() {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$vYFlH8smUSBb5SZgf5Zo2fAzIyw */

                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return ExposureNotificationClientWrapper.this.lambda$provideDiagnosisKeys$10$ExposureNotificationClientWrapper((Unit) obj);
                }
            }, AppExecutors.getBackgroundExecutor()).catching(Exception.class, $$Lambda$ExposureNotificationClientWrapper$mty3sf02DqzyBRsNokyNOt8XuWQ.INSTANCE, AppExecutors.getLightweightExecutor()).transformAsync(new AsyncFunction(arrayList) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.$$Lambda$ExposureNotificationClientWrapper$dDwG3alYRnXoioX7VWBWoOpxiDM */
                public final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return ExposureNotificationClientWrapper.this.lambda$provideDiagnosisKeys$12$ExposureNotificationClientWrapper(this.f$1, (Void) obj);
                }
            }, AppExecutors.getBackgroundExecutor())).transform(new Function(list) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$DiagnosisKeyFileSubmitter$uP_2z0Cbi_lOc5O0D0CE7YuYPgg */
                public final /* synthetic */ List f$0;

                {
                    this.f$0 = r1;
                }

                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return DiagnosisKeyFileSubmitter.lambda$submitBatches$1(this.f$0, (Void) obj);
                }
            }, AppExecutors.getBackgroundExecutor());
            transform.addListener(new Runnable(list) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.nearby.$$Lambda$DiagnosisKeyFileSubmitter$gOP4reL_gYUlv4ll36pwVCd9OaM */
                public final /* synthetic */ List f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    DiagnosisKeyFileSubmitter.lambda$submitFiles$0(this.f$0);
                }
            }, AppExecutors.getBackgroundExecutor());
            return transform;
        }
        throw null;
    }
}
