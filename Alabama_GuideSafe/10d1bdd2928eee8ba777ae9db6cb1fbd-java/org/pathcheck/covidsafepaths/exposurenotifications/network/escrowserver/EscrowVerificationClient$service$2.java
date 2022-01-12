package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.Collections;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import retrofit2.Platform;
import retrofit2.Retrofit;

/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$service$2 extends Lambda implements Function0<IBackendService> {
    public static final EscrowVerificationClient$service$2 INSTANCE = new EscrowVerificationClient$service$2();

    public EscrowVerificationClient$service$2() {
        super(0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public IBackendService invoke() {
        EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
        Retrofit retrofit = (Retrofit) EscrowVerificationClient.retrofit$delegate.getValue();
        if (retrofit == null) {
            throw null;
        } else if (IBackendService.class.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(IBackendService.class);
            while (!arrayDeque.isEmpty()) {
                Class cls = (Class) arrayDeque.removeFirst();
                if (cls.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls.getName());
                    if (cls != IBackendService.class) {
                        sb.append(" which is an interface of ");
                        sb.append(IBackendService.class.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls.getInterfaces());
            }
            if (retrofit.validateEagerly) {
                Platform platform = Platform.PLATFORM;
                Method[] declaredMethods = IBackendService.class.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (!(platform.hasJava8Types && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                        retrofit.loadServiceMethod(method);
                    }
                }
            }
            return (IBackendService) Proxy.newProxyInstance(IBackendService.class.getClassLoader(), new Class[]{IBackendService.class}, new InvocationHandler(IBackendService.class) {
                /* class retrofit2.Retrofit.AnonymousClass1 */
                public final Object[] emptyArgs = new Object[0];
                public final Platform platform = Platform.PLATFORM;
                public final /* synthetic */ Class val$service;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.val$service = r2;
                }

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (method.getDeclaringClass() == Object.class) {
                        return method.invoke(this, objArr);
                    }
                    if (objArr == null) {
                        objArr = this.emptyArgs;
                    }
                    if (this.platform.hasJava8Types && method.isDefault()) {
                        return this.platform.invokeDefaultMethod(method, this.val$service, obj, objArr);
                    }
                    HttpServiceMethod httpServiceMethod = (HttpServiceMethod) Retrofit.this.loadServiceMethod(method);
                    return httpServiceMethod.adapt(new OkHttpCall(httpServiceMethod.requestFactory, objArr, httpServiceMethod.callFactory, httpServiceMethod.responseConverter), objArr);
                }
            });
        } else {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
    }
}
