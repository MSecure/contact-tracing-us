package com.bugsnag.android;

import android.content.SharedPreferences;
import com.bugsnag.android.StateEvent;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserState.kt */
public final class UserState extends BaseObservable {
    public User user;
    public final UserRepository userRepository;

    public UserState(UserRepository userRepository2) {
        User user2;
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        this.userRepository = userRepository2;
        String string = userRepository2.prefs.getString("install.iud", null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            userRepository2.prefs.edit().putString("install.iud", string).apply();
        }
        if (userRepository2.persist) {
            user2 = new User(userRepository2.prefs.getString("user.id", string), userRepository2.prefs.getString("user.email", null), userRepository2.prefs.getString("user.name", null));
        } else {
            user2 = new User(string, null, null);
        }
        this.user = user2;
    }

    public final void setUser(String str, String str2, String str3) {
        User user2 = new User(str, str2, str3);
        this.user = user2;
        UserRepository userRepository2 = this.userRepository;
        if (userRepository2 != null) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            SharedPreferences.Editor edit = userRepository2.prefs.edit();
            if (userRepository2.persist) {
                edit.putString("user.id", user2.id).putString("user.name", user2.name).putString("user.email", user2.email);
            } else {
                edit.remove("user.id").remove("user.name").remove("user.email");
            }
            edit.apply();
            notifyObservers(new StateEvent.UpdateUser(this.user));
            return;
        }
        throw null;
    }
}
