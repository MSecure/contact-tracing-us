package gov.nc.dhhs.exposurenotification.network;

import gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor;

public final class AutoValue_DiagnosisAttestor_Overlay extends DiagnosisAttestor.Overlay {

    public static final class Builder extends DiagnosisAttestor.Overlay.Builder {
        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Overlay.Builder
        public DiagnosisAttestor.Overlay build() {
            return new AutoValue_DiagnosisAttestor_Overlay();
        }
    }

    public AutoValue_DiagnosisAttestor_Overlay() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof DiagnosisAttestor.Overlay);
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Overlay{}";
    }
}
