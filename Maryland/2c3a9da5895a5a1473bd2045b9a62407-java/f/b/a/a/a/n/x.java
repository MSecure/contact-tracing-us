package f.b.a.a.a.n;

import android.content.res.Resources;
import gov.md.covid19.exposurenotifications.R;

public enum x {
    UNKNOWN,
    CODE_INVALID,
    CODE_EXPIRED,
    UNSUPPORTED_TEST_TYPE,
    APP_ERROR,
    SERVER_ERROR,
    RATE_LIMITED;

    public String a(Resources resources) {
        int ordinal = ordinal();
        if (ordinal == 1) {
            return resources.getString(R.string.network_error_code_invalid);
        }
        if (ordinal != 2) {
            return ordinal != 3 ? ordinal != 5 ? resources.getString(R.string.generic_error_message) : resources.getString(R.string.network_error_server_error) : resources.getString(R.string.network_error_unsupported_test_type);
        }
        return resources.getString(R.string.network_error_code_expired, resources.getString(R.string.error_agency_name));
    }
}
