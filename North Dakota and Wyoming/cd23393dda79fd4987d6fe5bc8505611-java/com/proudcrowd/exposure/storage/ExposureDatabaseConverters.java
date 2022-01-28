package com.proudcrowd.exposure.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.proudcrowd.exposure.datamodel.InstructionDetail;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class ExposureDatabaseConverters {
    private static final Gson JSON_SERIALIZER = new GsonBuilder().disableHtmlEscaping().create();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    public static ZonedDateTime toOffsetDateTime(String str) {
        if (str != null) {
            return (ZonedDateTime) dateTimeFormatter.parse(str, ZonedDateTime.FROM);
        }
        return null;
    }

    public static String fromOffsetDateTime(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return zonedDateTime.format(dateTimeFormatter);
        }
        return null;
    }

    public static List<InstructionDetail> toInstructions(String str) {
        return str == null ? new ArrayList() : (List) JSON_SERIALIZER.fromJson(str, new TypeToken<List<InstructionDetail>>() {
            /* class com.proudcrowd.exposure.storage.ExposureDatabaseConverters.AnonymousClass1 */
        }.getType());
    }

    public static String fromInstructions(List<InstructionDetail> list) {
        Gson gson = JSON_SERIALIZER;
        if (list == null) {
            list = new ArrayList<>();
        }
        return gson.toJson(list);
    }
}
