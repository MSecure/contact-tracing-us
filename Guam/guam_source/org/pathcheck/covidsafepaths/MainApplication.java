package org.pathcheck.covidsafepaths;

import android.app.Application;
import android.content.Context;
import com.bugsnag.android.Bugsnag;
import com.bugsnag.android.Client;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.ManifestConfigLoader;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.soloader.SoLoader;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jakewharton.threetenabp.AssetsZoneRulesInitializer;
import io.realm.Realm;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.zone.ZoneRulesInitializer;

public class MainApplication extends Application implements ReactApplication {
    public static Context context;
    public final ReactNativeHost reactNativeHost = new ReactNativeHost(this, this) {
        /* class org.pathcheck.covidsafepaths.MainApplication.AnonymousClass1 */
    };

    @Override // com.facebook.react.ReactApplication
    public ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        if (!AndroidThreeTen.initialized.getAndSet(true)) {
            AssetsZoneRulesInitializer assetsZoneRulesInitializer = new AssetsZoneRulesInitializer(this, "org/threeten/bp/TZDB.dat");
            if (ZoneRulesInitializer.INITIALIZED.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!ZoneRulesInitializer.INITIALIZER.compareAndSet(null, assetsZoneRulesInitializer)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        SoLoader.init((Context) this, false);
        Realm.init(this);
        this.reactNativeHost.getReactInstanceManager();
        Intrinsics.checkParameterIsNotNull(this, "context");
        Intrinsics.checkParameterIsNotNull(this, "context");
        ManifestConfigLoader manifestConfigLoader = new ManifestConfigLoader();
        Intrinsics.checkParameterIsNotNull(this, "ctx");
        try {
            Configuration load$bugsnag_android_core_release = manifestConfigLoader.load$bugsnag_android_core_release(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData, null);
            load$bugsnag_android_core_release.impl.releaseStage = "production";
            HashSet hashSet = new HashSet();
            hashSet.add("development");
            load$bugsnag_android_core_release.impl.enabledReleaseStages = hashSet;
            synchronized (Bugsnag.lock) {
                if (Bugsnag.client == null) {
                    Bugsnag.client = new Client(this, load$bugsnag_android_core_release);
                } else {
                    Bugsnag.getClient().logger.w("Multiple Bugsnag.start calls detected. Ignoring.");
                }
            }
            Client client = Bugsnag.client;
        } catch (Exception e) {
            throw new IllegalStateException("Bugsnag is unable to read config from manifest.", e);
        }
    }
}
