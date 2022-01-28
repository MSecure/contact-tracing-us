package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public int hashCode() {
        return this.members.hashCode();
    }
}
