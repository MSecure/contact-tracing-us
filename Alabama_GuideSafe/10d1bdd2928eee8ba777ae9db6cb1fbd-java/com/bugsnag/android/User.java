package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: User.kt */
public final class User implements JsonStream.Streamable {
    public final String email;
    public final String id;
    public final String name;

    public User() {
        this(null, null, null, 7);
    }

    public User(String str, String str2, String str3) {
        this.id = str;
        this.email = str2;
        this.name = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(User.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            User user = (User) obj;
            return !(Intrinsics.areEqual(this.id, user.id) ^ true) && !(Intrinsics.areEqual(this.email, user.email) ^ true) && !(Intrinsics.areEqual(this.name, user.name) ^ true);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bugsnag.android.User");
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("id");
        jsonStream.value(this.id);
        jsonStream.name("email");
        jsonStream.value(this.email);
        jsonStream.name("name");
        jsonStream.value(this.name);
        jsonStream.endObject();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ User(String str, String str2, String str3, int i) {
        this(null, null, null);
        int i2 = i & 1;
        int i3 = i & 2;
        int i4 = i & 4;
    }
}
