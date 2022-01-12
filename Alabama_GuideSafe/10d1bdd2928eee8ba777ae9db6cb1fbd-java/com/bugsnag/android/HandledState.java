package com.bugsnag.android;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.JsonStream;
import java.io.IOException;

public final class HandledState implements JsonStream.Streamable {
    public final String attributeValue;
    public Severity currentSeverity;
    public final Severity defaultSeverity;
    public final String severityReasonType;
    public boolean unhandled;

    public HandledState(String str, Severity severity, boolean z, String str2) {
        this.severityReasonType = str;
        this.defaultSeverity = severity;
        this.unhandled = z;
        this.attributeValue = str2;
        this.currentSeverity = severity;
    }

    public static HandledState newInstance(String str) {
        return newInstance(str, null, null);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("type");
        jsonStream.value(this.defaultSeverity == this.currentSeverity ? this.severityReasonType : "userCallbackSetSeverity");
        if (this.attributeValue != null) {
            String str = null;
            String str2 = this.severityReasonType;
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1876197364) {
                if (hashCode == 107332 && str2.equals("log")) {
                    c = 0;
                }
            } else if (str2.equals("strictMode")) {
                c = 1;
            }
            if (c == 0) {
                str = "level";
            } else if (c == 1) {
                str = "violationType";
            }
            if (str != null) {
                jsonStream.name("attributes");
                jsonStream.beginObject();
                jsonStream.name(str);
                jsonStream.value(this.attributeValue).endObject();
            }
        }
        jsonStream.endObject();
    }

    public static HandledState newInstance(String str, Severity severity, String str2) {
        if (str.equals("strictMode") && AppCompatDelegateImpl.ConfigurationImplApi17.isEmpty(str2)) {
            throw new IllegalArgumentException("No reason supplied for strictmode");
        } else if (str.equals("strictMode") || str.equals("log") || AppCompatDelegateImpl.ConfigurationImplApi17.isEmpty(str2)) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1876197364:
                    if (str.equals("strictMode")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1773746641:
                    if (str.equals("userCallbackSetSeverity")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1591166708:
                    if (str.equals("unhandledException")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1107031998:
                    if (str.equals("userSpecifiedSeverity")) {
                        c = 5;
                        break;
                    }
                    break;
                case -573976797:
                    if (str.equals("anrError")) {
                        c = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (str.equals("log")) {
                        c = 7;
                        break;
                    }
                    break;
                case 87505361:
                    if (str.equals("unhandledPromiseRejection")) {
                        c = 1;
                        break;
                    }
                    break;
                case 561970291:
                    if (str.equals("handledException")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    return new HandledState(str, Severity.ERROR, true, null);
                case 3:
                    return new HandledState(str, Severity.WARNING, true, str2);
                case 4:
                    return new HandledState(str, Severity.WARNING, false, null);
                case 5:
                case 6:
                    return new HandledState(str, severity, false, null);
                case 7:
                    return new HandledState(str, severity, false, str2);
                default:
                    throw new IllegalArgumentException(String.format("Invalid argument '%s' for severityReason", str));
            }
        } else {
            throw new IllegalArgumentException("attributeValue should not be supplied");
        }
    }
}
