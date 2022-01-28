package gov.michigan.MiCovidExposure.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import b.b.k.i;
import b.s.b;
import b.s.h;
import b.s.j;
import b.s.o.d;
import b.s.q.c;
import b.w.a.f;
import b.w.a.g.e;
import c.b.b.e.a.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class TokenDao_Impl extends TokenDao {
    public final h __db;
    public final b<TokenEntity> __insertionAdapterOfTokenEntity;

    public TokenDao_Impl(h hVar) {
        this.__db = hVar;
        this.__insertionAdapterOfTokenEntity = new b<TokenEntity>(hVar) {
            /* class gov.michigan.MiCovidExposure.storage.TokenDao_Impl.AnonymousClass1 */

            public void bind(f fVar, TokenEntity tokenEntity) {
                if (tokenEntity.getToken() == null) {
                    ((e) fVar).f2630b.bindNull(1);
                } else {
                    ((e) fVar).f2630b.bindString(1, tokenEntity.getToken());
                }
                ((e) fVar).f2630b.bindLong(2, tokenEntity.getLastUpdatedTimestampMs());
                ((e) fVar).f2630b.bindLong(3, tokenEntity.isResponded() ? 1 : 0);
            }

            @Override // b.s.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TokenEntity` (`token`,`last_updated_timestamp_ms`,`responded`) VALUES (?,?,?)";
            }
        };
    }

    @Override // gov.michigan.MiCovidExposure.storage.TokenDao
    public u<Void> deleteByTokensAsync(final String... strArr) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.TokenDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                StringBuilder sb = new StringBuilder();
                sb.append("DELETE FROM TokenEntity WHERE token IN (");
                c.a(sb, strArr.length);
                sb.append(")");
                f compileStatement = TokenDao_Impl.this.__db.compileStatement(sb.toString());
                String[] strArr = strArr;
                int i = 1;
                for (String str : strArr) {
                    if (str == null) {
                        ((e) compileStatement).f2630b.bindNull(i);
                    } else {
                        ((e) compileStatement).f2630b.bindString(i, str);
                    }
                    i++;
                }
                TokenDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.w.a.g.f) compileStatement).b();
                    TokenDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    TokenDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    @Override // gov.michigan.MiCovidExposure.storage.TokenDao
    public u<List<TokenEntity>> getAllAsync() {
        final j c2 = j.c("SELECT * FROM TokenEntity", 0);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(this.__db, false, new Callable<List<TokenEntity>>() {
            /* class gov.michigan.MiCovidExposure.storage.TokenDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public List<TokenEntity> call() {
                Cursor b2 = b.s.q.b.b(TokenDao_Impl.this.__db, c2, false, cancellationSignal);
                try {
                    int y = i.j.y(b2, "token");
                    int y2 = i.j.y(b2, "last_updated_timestamp_ms");
                    int y3 = i.j.y(b2, "responded");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        TokenEntity tokenEntity = new TokenEntity(b2.getString(y), b2.getInt(y3) != 0);
                        tokenEntity.setLastUpdatedTimestampMs(b2.getLong(y2));
                        arrayList.add(tokenEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        }, c2, true, cancellationSignal);
    }

    @Override // gov.michigan.MiCovidExposure.storage.TokenDao
    public u<Void> upsertAsync(final TokenEntity tokenEntity) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.TokenDao_Impl.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                TokenDao_Impl.this.__db.beginTransaction();
                try {
                    TokenDao_Impl.this.__insertionAdapterOfTokenEntity.insert(tokenEntity);
                    TokenDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    TokenDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }
}
