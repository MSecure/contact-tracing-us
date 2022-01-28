package gov.michigan.MiCovidExposure.network;

import c.a.b.o;
import c.a.b.p;

public abstract class RequestQueueWrapper {
    public static RequestQueueWrapper wrapping(final p pVar) {
        return new RequestQueueWrapper() {
            /* class gov.michigan.MiCovidExposure.network.RequestQueueWrapper.AnonymousClass1 */

            @Override // gov.michigan.MiCovidExposure.network.RequestQueueWrapper
            public <T> o<T> add(o<T> oVar) {
                pVar.a(oVar);
                return oVar;
            }
        };
    }

    public abstract <T> o<T> add(o<T> oVar);
}
