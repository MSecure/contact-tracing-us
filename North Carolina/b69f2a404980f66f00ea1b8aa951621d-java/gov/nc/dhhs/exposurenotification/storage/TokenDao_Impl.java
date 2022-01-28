package gov.nc.dhhs.exposurenotification.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import b.b.k.i;
import b.r.b;
import b.r.h;
import b.r.j;
import b.r.o.d;
import b.r.q.c;
import b.u.a.f;
import b.u.a.g.e;
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
            /* class gov.nc.dhhs.exposurenotification.storage.TokenDao_Impl.AnonymousClass1 */

            public void bind(f fVar, TokenEntity tokenEntity) {
                if (tokenEntity.getToken() == null) {
                    ((e) fVar).f1754b.bindNull(1);
                } else {
                    ((e) fVar).f1754b.bindString(1, tokenEntity.getToken());
                }
                ((e) fVar).f1754b.bindLong(2, tokenEntity.getLastUpdatedTimestampMs());
                ((e) fVar).f1754b.bindLong(3, tokenEntity.isResponded() ? 1 : 0);
            }

            @Override // b.r.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TokenEntity` (`token`,`last_updated_timestamp_ms`,`responded`) VALUES (?,?,?)";
            }
        };
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.TokenDao
    public u<Void> deleteByTokensAsync(final String... strArr) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.TokenDao_Impl.AnonymousClass4 */

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
                        ((e) compileStatement).f1754b.bindNull(i);
                    } else {
                        ((e) compileStatement).f1754b.bindString(i, str);
                    }
                    i++;
                }
                TokenDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.u.a.g.f) compileStatement).b();
                    TokenDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    TokenDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.TokenDao
    public u<List<TokenEntity>> getAllAsync() {
        final j d2 = j.d("SELECT * FROM TokenEntity", 0);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(this.__db, false, new Callable<List<TokenEntity>>() {
            /* class gov.nc.dhhs.exposurenotification.storage.TokenDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public List<TokenEntity> call() {
                Cursor b2 = b.r.q.b.b(TokenDao_Impl.this.__db, d2, false, cancellationSignal);
                try {
                    int a0 = i.j.a0(b2, "token");
                    int a02 = i.j.a0(b2, "last_updated_timestamp_ms");
                    int a03 = i.j.a0(b2, "responded");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        TokenEntity tokenEntity = new TokenEntity(b2.getString(a0), b2.getInt(a03) != 0);
                        tokenEntity.setLastUpdatedTimestampMs(b2.getLong(a02));
                        arrayList.add(tokenEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        }, d2, true, cancellationSignal);
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.TokenDao
    public u<Void> upsertAsync(final TokenEntity tokenEntity) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.TokenDao_Impl.AnonymousClass2 */

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
