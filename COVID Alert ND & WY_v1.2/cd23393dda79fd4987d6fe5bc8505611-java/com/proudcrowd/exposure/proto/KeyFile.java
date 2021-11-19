package com.proudcrowd.exposure.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;

public final class KeyFile {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000ekey_file.proto\u0012\u001dcom.proudcrowd.exposure.debug\"\u0002\n\u001aTemporaryExposureKeyExport\u0012\u0017\n\u000fstart_timestamp\u0018\u0001 \u0001(\u0006\u0012\u0015\n\rend_timestamp\u0018\u0002 \u0001(\u0006\u0012\u000e\n\u0006region\u0018\u0003 \u0001(\t\u0012\u0011\n\tbatch_num\u0018\u0004 \u0001(\u0005\u0012\u0012\n\nbatch_size\u0018\u0005 \u0001(\u0005\u0012E\n\u000fsignature_infos\u0018\u0006 \u0003(\u000b2,.com.proudcrowd.exposure.debug.SignatureInfo\u0012A\n\u0004keys\u0018\u0007 \u0003(\u000b23.com.proudcrowd.exposure.debug.TemporaryExposureKey\"\u0001\n\rSignatureInfo\u0012 \n\u0018verification_key_version\u0018\u0003 \u0001(\t\u0012\u001b\n\u0013verification_key_id\u0018\u0004 \u0001(\t\u0012\u001b\n\u0013signature_algorithm\u0018\u0005 \u0001(\tJ\u0004\b\u0001\u0010\u0002J\u0004\b\u0002\u0010\u0003R\rapp_bundle_idR\u000fandroid_package\"\u0001\n\u0014TemporaryExposureKey\u0012\u0010\n\bkey_data\u0018\u0001 \u0001(\f\u0012\u001f\n\u0017transmission_risk_level\u0018\u0002 \u0001(\u0005\u0012%\n\u001drolling_start_interval_number\u0018\u0003 \u0001(\u0005\u0012\u001b\n\u000erolling_period\u0018\u0004 \u0001(\u0005:\u0003144\"S\n\u0010TEKSignatureList\u0012?\n\nsignatures\u0018\u0001 \u0003(\u000b2+.com.proudcrowd.exposure.debug.TEKSignature\"\u0001\n\fTEKSignature\u0012D\n\u000esignature_info\u0018\u0001 \u0001(\u000b2,.com.proudcrowd.exposure.debug.SignatureInfo\u0012\u0011\n\tbatch_num\u0018\u0002 \u0001(\u0005\u0012\u0012\n\nbatch_size\u0018\u0003 \u0001(\u0005\u0012\u0011\n\tsignature\u0018\u0004 \u0001(\fB!\n\u001dcom.proudcrowd.exposure.protoP\u0001"}, new Descriptors.FileDescriptor[0]);
    static final Descriptors.Descriptor internal_static_com_proudcrowd_exposure_debug_SignatureInfo_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_proudcrowd_exposure_debug_SignatureInfo_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_com_proudcrowd_exposure_debug_TEKSignature_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_proudcrowd_exposure_debug_TEKSignature_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_fieldAccessorTable;
    static final Descriptors.Descriptor internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_fieldAccessorTable;

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private KeyFile() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_descriptor = descriptor2;
        internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKeyExport_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"StartTimestamp", "EndTimestamp", "Region", "BatchNum", "BatchSize", "SignatureInfos", "Keys"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_proudcrowd_exposure_debug_SignatureInfo_descriptor = descriptor3;
        internal_static_com_proudcrowd_exposure_debug_SignatureInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"VerificationKeyVersion", "VerificationKeyId", "SignatureAlgorithm"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_descriptor = descriptor4;
        internal_static_com_proudcrowd_exposure_debug_TemporaryExposureKey_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"KeyData", "TransmissionRiskLevel", "RollingStartIntervalNumber", "RollingPeriod"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_descriptor = descriptor5;
        internal_static_com_proudcrowd_exposure_debug_TEKSignatureList_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Signatures"});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_proudcrowd_exposure_debug_TEKSignature_descriptor = descriptor6;
        internal_static_com_proudcrowd_exposure_debug_TEKSignature_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"SignatureInfo", "BatchNum", "BatchSize", "Signature"});
    }
}
