package f.b.a.a.a.o;

import android.content.res.Resources;
import gov.co.cdphe.exposurenotifications.R;

public enum h0 {
    UNKNOWN,
    CODE_INVALID,
    CODE_EXPIRED,
    UNSUPPORTED_TEST_TYPE,
    APP_ERROR,
    SERVER_ERROR,
    RATE_LIMITED;

    public String a(Resources resources, boolean z) {
        int ordinal = ordinal();
        if (ordinal == 1) {
            return resources.getString(z ? R.string.self_report_bad_code : R.string.network_error_code_invalid);
        } else if (ordinal != 2) {
            return ordinal != 3 ? ordinal != 5 ? resources.getString(R.string.generic_error_message) : resources.getString(R.string.network_error_server_error) : resources.getString(R.string.network_error_unsupported_test_type);
        } else {
            return resources.getString(R.string.network_error_code_expired, resources.getString(R.string.error_agency_name));
        }
    }
}
