package gov.michigan.MiCovidExposure.proto;

import c.b.d.l0;
import c.b.d.s;
import c.b.d.x;
import c.b.d.z;

public final class KeyFile {
    public static s.h descriptor = s.h.r(new String[]{"\n\u000ekey_file.proto\u0012\u001cgov.michigan.MiCovidExposure\"\u0002\n\u001aTemporaryExposureKeyExport\u0012\u0017\n\u000fstart_timestamp\u0018\u0001 \u0001(\u0006\u0012\u0015\n\rend_timestamp\u0018\u0002 \u0001(\u0006\u0012\u000e\n\u0006region\u0018\u0003 \u0001(\t\u0012\u0011\n\tbatch_num\u0018\u0004 \u0001(\u0005\u0012\u0012\n\nbatch_size\u0018\u0005 \u0001(\u0005\u0012D\n\u000fsignature_infos\u0018\u0006 \u0003(\u000b2+.gov.michigan.MiCovidExposure.SignatureInfo\u0012@\n\u0004keys\u0018\u0007 \u0003(\u000b22.gov.michigan.MiCovidExposure.TemporaryExposureKey\"\u0001\n\rSignatureInfo\u0012\u0015\n\rapp_bundle_id\u0018\u0001 \u0001(\t\u0012\u0017\n\u000fandroid_package\u0018\u0002 \u0001(\t\u0012 \n\u0018verification_key_version\u0018\u0003 \u0001(\t\u0012\u001b\n\u0013verification_key_id\u0018\u0004 \u0001(\t\u0012\u001b\n\u0013signature_algorithm\u0018\u0005 \u0001(\t\"\u0001\n\u0014TemporaryExposureKey\u0012\u0010\n\bkey_data\u0018\u0001 \u0001(\f\u0012\u001f\n\u0017transmission_risk_level\u0018\u0002 \u0001(\u0005\u0012%\n\u001drolling_start_interval_number\u0018\u0003 \u0001(\u0005\u0012\u001b\n\u000erolling_period\u0018\u0004 \u0001(\u0005:\u0003144\"R\n\u0010TEKSignatureList\u0012>\n\nsignatures\u0018\u0001 \u0003(\u000b2*.gov.michigan.MiCovidExposure.TEKSignature\"\u0001\n\fTEKSignature\u0012C\n\u000esignature_info\u0018\u0001 \u0001(\u000b2+.gov.michigan.MiCovidExposure.SignatureInfo\u0012\u0011\n\tbatch_num\u0018\u0002 \u0001(\u0005\u0012\u0012\n\nbatch_size\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tsignature\u0018\u0004 \u0001(\fB&\n\"gov.michigan.MiCovidExposure.protoP\u0001"}, new s.h[0]);
    public static final s.b internal_static_gov_michigan_MiCovidExposure_SignatureInfo_descriptor;
    public static final l0.f internal_static_gov_michigan_MiCovidExposure_SignatureInfo_fieldAccessorTable;
    public static final s.b internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_descriptor;
    public static final l0.f internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_fieldAccessorTable;
    public static final s.b internal_static_gov_michigan_MiCovidExposure_TEKSignature_descriptor;
    public static final l0.f internal_static_gov_michigan_MiCovidExposure_TEKSignature_fieldAccessorTable;
    public static final s.b internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKeyExport_descriptor;
    public static final l0.f internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKeyExport_fieldAccessorTable;
    public static final s.b internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_descriptor;
    public static final l0.f internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_fieldAccessorTable;

    static {
        s.b bVar = getDescriptor().m().get(0);
        internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKeyExport_descriptor = bVar;
        internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKeyExport_fieldAccessorTable = new l0.f(bVar, new String[]{"StartTimestamp", "EndTimestamp", "Region", "BatchNum", "BatchSize", "SignatureInfos", "Keys"});
        s.b bVar2 = getDescriptor().m().get(1);
        internal_static_gov_michigan_MiCovidExposure_SignatureInfo_descriptor = bVar2;
        internal_static_gov_michigan_MiCovidExposure_SignatureInfo_fieldAccessorTable = new l0.f(bVar2, new String[]{"AppBundleId", "AndroidPackage", "VerificationKeyVersion", "VerificationKeyId", "SignatureAlgorithm"});
        s.b bVar3 = getDescriptor().m().get(2);
        internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_descriptor = bVar3;
        internal_static_gov_michigan_MiCovidExposure_TemporaryExposureKey_fieldAccessorTable = new l0.f(bVar3, new String[]{"KeyData", "TransmissionRiskLevel", "RollingStartIntervalNumber", "RollingPeriod"});
        s.b bVar4 = getDescriptor().m().get(3);
        internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_descriptor = bVar4;
        internal_static_gov_michigan_MiCovidExposure_TEKSignatureList_fieldAccessorTable = new l0.f(bVar4, new String[]{"Signatures"});
        s.b bVar5 = getDescriptor().m().get(4);
        internal_static_gov_michigan_MiCovidExposure_TEKSignature_descriptor = bVar5;
        internal_static_gov_michigan_MiCovidExposure_TEKSignature_fieldAccessorTable = new l0.f(bVar5, new String[]{"SignatureInfo", "BatchNum", "BatchSize", "Signature"});
    }

    public static s.h getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(x xVar) {
        registerAllExtensions((z) xVar);
    }

    public static void registerAllExtensions(z zVar) {
    }
}
