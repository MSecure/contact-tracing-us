package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import c.b.b.e.a.u;
import java.util.List;

public class TokenRepository {
    public final TokenDao tokenDao;

    public TokenRepository(Context context) {
        this.tokenDao = ExposureNotificationDatabase.getInstance(context).tokenDao();
    }

    public u<Void> deleteByTokensAsync(String... strArr) {
        return this.tokenDao.deleteByTokensAsync(strArr);
    }

    public u<List<TokenEntity>> getAllAsync() {
        return this.tokenDao.getAllAsync();
    }

    public u<Void> upsertAsync(TokenEntity tokenEntity) {
        return this.tokenDao.upsertAsync(tokenEntity);
    }
}
