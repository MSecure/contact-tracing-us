package gov.nc.dhhs.exposurenotification.storage;

import c.b.b.e.a.u;
import java.util.List;

public abstract class TokenDao {
    public abstract u<Void> deleteByTokensAsync(String... strArr);

    public abstract u<List<TokenEntity>> getAllAsync();

    public abstract u<Void> upsertAsync(TokenEntity tokenEntity);
}
