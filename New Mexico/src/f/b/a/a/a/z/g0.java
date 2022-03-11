package f.b.a.a.a.z;

import android.content.res.Resources;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public enum g0 {
    UNKNOWN,
    CODE_INVALID,
    CODE_EXPIRED,
    UNSUPPORTED_TEST_TYPE,
    APP_ERROR,
    SERVER_ERROR,
    RATE_LIMITED,
    UNAUTHORIZED_CLIENT;

    public String a(Resources resources, boolean z) {
        int ordinal = ordinal();
        if (ordinal != 1) {
            return ordinal != 2 ? ordinal != 3 ? ordinal != 5 ? ordinal != 7 ? resources.getString(R.string.generic_error_message) : resources.getString(R.string.try_again_later_error_message) : resources.getString(R.string.network_error_server_error) : resources.getString(R.string.network_error_unsupported_test_type) : resources.getString(R.string.network_error_code_expired, resources.getString(R.string.error_agency_name));
        }
        return resources.getString(z ? R.string.self_report_bad_code : R.string.network_error_code_invalid);
    }
}
