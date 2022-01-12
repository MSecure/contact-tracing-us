package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.pathcheck.covidsafepaths.BuildConfig;
import retrofit2.BuiltInConverters;
import retrofit2.CompletableFutureCallAdapterFactory;
import retrofit2.Converter;
import retrofit2.DefaultCallAdapterFactory;
import retrofit2.OptionalConverterFactory;
import retrofit2.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$retrofit$2 extends Lambda implements Function0<Retrofit> {
    public static final EscrowVerificationClient$retrofit$2 INSTANCE = new EscrowVerificationClient$retrofit$2();

    public EscrowVerificationClient$retrofit$2() {
        super(0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Retrofit invoke() {
        List list;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(EscrowVerificationClient$retrofit$2$okHttpClient$1$loggingInterceptor$1.INSTANCE);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        OkHttpClient build = builder.build();
        Platform platform = Platform.PLATFORM;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(BuildConfig.ESCROW_VERIFICATION_BASE_URL, "baseUrl == null");
        HttpUrl httpUrl = HttpUrl.get(BuildConfig.ESCROW_VERIFICATION_BASE_URL);
        Objects.requireNonNull(httpUrl, "baseUrl == null");
        List<String> pathSegments = httpUrl.pathSegments();
        if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
            arrayList.add((Converter.Factory) Objects.requireNonNull(new GsonConverterFactory(new Gson()), "factory == null"));
            Call.Factory factory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(build, "client == null"), "factory == null");
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Executor defaultCallbackExecutor = platform.defaultCallbackExecutor();
            ArrayList arrayList3 = new ArrayList(arrayList2);
            DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(defaultCallbackExecutor);
            if (platform.hasJava8Types) {
                list = Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory);
            } else {
                list = Collections.singletonList(defaultCallAdapterFactory);
            }
            arrayList3.addAll(list);
            ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (platform.hasJava8Types ? 1 : 0));
            arrayList4.add(new BuiltInConverters());
            arrayList4.addAll(arrayList);
            arrayList4.addAll(platform.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList());
            return new Retrofit(factory, httpUrl, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), defaultCallbackExecutor, false);
        }
        throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
    }
}
