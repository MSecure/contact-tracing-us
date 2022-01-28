package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzcd implements Parcelable.Creator<SubscribeRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder3 = null;
        ClientAppContext clientAppContext = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 3:
                    strategy = (Strategy) i.j.O(parcel, readInt, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                case 5:
                    messageFilter = (MessageFilter) i.j.O(parcel, readInt, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) i.j.O(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 7:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 8:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 9:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 10:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 11:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 12:
                    iBinder3 = i.j.Q0(parcel, readInt);
                    break;
                case 13:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) i.j.O(parcel, readInt, ClientAppContext.CREATOR);
                    break;
                case 15:
                    z3 = i.j.N0(parcel, readInt);
                    break;
                case 16:
                    i3 = i.j.R0(parcel, readInt);
                    break;
                case 17:
                    i4 = i.j.R0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new SubscribeRequest(i, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i2, str, str2, bArr, z, iBinder3, z2, clientAppContext, z3, i3, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
