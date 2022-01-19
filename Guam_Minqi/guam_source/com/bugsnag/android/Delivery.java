package com.bugsnag.android;

/* compiled from: Delivery.kt */
public interface Delivery {
    DeliveryStatus deliver(EventPayload eventPayload, DeliveryParams deliveryParams);

    DeliveryStatus deliver(Session session, DeliveryParams deliveryParams);
}
