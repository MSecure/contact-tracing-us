package gov.nc.dhhs.exposurenotification.network;

import c.a.a.a.a;
import gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor;

public final class AutoValue_DiagnosisAttestor_Attestation extends DiagnosisAttestor.Attestation {
    public final DiagnosisAttestor.Overlay overlay;
    public final String token;

    public static final class Builder extends DiagnosisAttestor.Attestation.Builder {
        public DiagnosisAttestor.Overlay overlay;
        public String token;

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Attestation.Builder
        public DiagnosisAttestor.Attestation build() {
            String str = this.token == null ? " token" : "";
            if (this.overlay == null) {
                str = a.o(str, " overlay");
            }
            if (str.isEmpty()) {
                return new AutoValue_DiagnosisAttestor_Attestation(this.token, this.overlay);
            }
            throw new IllegalStateException(a.o("Missing required properties:", str));
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Attestation.Builder
        public DiagnosisAttestor.Attestation.Builder setOverlay(DiagnosisAttestor.Overlay overlay2) {
            if (overlay2 != null) {
                this.overlay = overlay2;
                return this;
            }
            throw new NullPointerException("Null overlay");
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Attestation.Builder
        public DiagnosisAttestor.Attestation.Builder setToken(String str) {
            if (str != null) {
                this.token = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }
    }

    public AutoValue_DiagnosisAttestor_Attestation(String str, DiagnosisAttestor.Overlay overlay2) {
        this.token = str;
        this.overlay = overlay2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiagnosisAttestor.Attestation)) {
            return false;
        }
        DiagnosisAttestor.Attestation attestation = (DiagnosisAttestor.Attestation) obj;
        return this.token.equals(attestation.token()) && this.overlay.equals(attestation.overlay());
    }

    public int hashCode() {
        return ((this.token.hashCode() ^ 1000003) * 1000003) ^ this.overlay.hashCode();
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Attestation
    public DiagnosisAttestor.Overlay overlay() {
        return this.overlay;
    }

    public String toString() {
        StringBuilder g = a.g("Attestation{token=");
        g.append(this.token);
        g.append(", overlay=");
        g.append(this.overlay);
        g.append("}");
        return g.toString();
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisAttestor.Attestation
    public String token() {
        return this.token;
    }
}
