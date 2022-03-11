package l.b.a.u;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.w.c;
import l.b.a.w.j;
import l.b.a.w.m;

public final class o extends i {
    public static final Comparator<Map.Entry<String, Long>> c = new a();
    public final ConcurrentMap<Map.Entry<j, Locale>, Object> b = new ConcurrentHashMap(16, 0.75f, 2);

    public class a implements Comparator<Map.Entry<String, Long>> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }
    }

    public static final class b {
        public final Map<p, Map<Long, String>> a;
        public final Map<p, List<Map.Entry<String, Long>>> b;

        public b(Map<p, Map<Long, String>> map) {
            this.a = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (p pVar : map.keySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<Long, String> entry : map.get(pVar).entrySet()) {
                    String value = entry.getValue();
                    String value2 = entry.getValue();
                    Long key = entry.getKey();
                    Comparator<Map.Entry<String, Long>> comparator = o.c;
                    hashMap2.put(value, new AbstractMap.SimpleImmutableEntry(value2, key));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Comparator<Map.Entry<String, Long>> comparator2 = o.c;
                Collections.sort(arrayList2, o.c);
                hashMap.put(pVar, arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Comparator<Map.Entry<String, Long>> comparator3 = o.c;
            Collections.sort(arrayList, o.c);
            this.b = hashMap;
        }

        public String a(long j2, p pVar) {
            Map<Long, String> map = this.a.get(pVar);
            if (map != null) {
                return map.get(Long.valueOf(j2));
            }
            return null;
        }
    }

    public static b c(Map<p, Map<Long, String>> map) {
        map.put(p.FULL_STANDALONE, map.get(p.FULL));
        map.put(p.SHORT_STANDALONE, map.get(p.SHORT));
        p pVar = p.NARROW;
        if (map.containsKey(pVar)) {
            p pVar2 = p.NARROW_STANDALONE;
            if (!map.containsKey(pVar2)) {
                map.put(pVar2, map.get(pVar));
            }
        }
        return new b(map);
    }

    @Override // l.b.a.u.i
    public String a(j jVar, long j2, p pVar, Locale locale) {
        Object d2 = d(jVar, locale);
        if (d2 instanceof b) {
            return ((b) d2).a(j2, pVar);
        }
        return null;
    }

    @Override // l.b.a.u.i
    public Iterator<Map.Entry<String, Long>> b(j jVar, p pVar, Locale locale) {
        List<Map.Entry<String, Long>> list;
        Object d2 = d(jVar, locale);
        if (!(d2 instanceof b) || (list = ((b) d2).b.get(pVar)) == null) {
            return null;
        }
        return list.iterator();
    }

    public final Object d(j jVar, Locale locale) {
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry;
        Object obj;
        HashMap hashMap;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(jVar, locale);
        Object obj2 = this.b.get(simpleImmutableEntry2);
        if (obj2 != null) {
            return obj2;
        }
        p pVar = p.NARROW;
        p pVar2 = p.SHORT;
        p pVar3 = p.FULL;
        if (jVar == l.b.a.w.a.MONTH_OF_YEAR) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            hashMap = new HashMap();
            simpleImmutableEntry = simpleImmutableEntry2;
            String[] months = instance.getMonths();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, months[0]);
            hashMap2.put(2L, months[1]);
            hashMap2.put(3L, months[2]);
            hashMap2.put(4L, months[3]);
            hashMap2.put(5L, months[4]);
            hashMap2.put(6L, months[5]);
            hashMap2.put(7L, months[6]);
            hashMap2.put(8L, months[7]);
            hashMap2.put(9L, months[8]);
            hashMap2.put(10L, months[9]);
            hashMap2.put(11L, months[10]);
            hashMap2.put(12L, months[11]);
            hashMap.put(pVar3, hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(1L, months[0].substring(0, 1));
            hashMap3.put(2L, months[1].substring(0, 1));
            hashMap3.put(3L, months[2].substring(0, 1));
            hashMap3.put(4L, months[3].substring(0, 1));
            hashMap3.put(5L, months[4].substring(0, 1));
            hashMap3.put(6L, months[5].substring(0, 1));
            hashMap3.put(7L, months[6].substring(0, 1));
            hashMap3.put(8L, months[7].substring(0, 1));
            hashMap3.put(9L, months[8].substring(0, 1));
            hashMap3.put(10L, months[9].substring(0, 1));
            hashMap3.put(11L, months[10].substring(0, 1));
            hashMap3.put(12L, months[11].substring(0, 1));
            hashMap.put(pVar, hashMap3);
            String[] shortMonths = instance.getShortMonths();
            HashMap hashMap4 = new HashMap();
            hashMap4.put(1L, shortMonths[0]);
            hashMap4.put(2L, shortMonths[1]);
            hashMap4.put(3L, shortMonths[2]);
            hashMap4.put(4L, shortMonths[3]);
            hashMap4.put(5L, shortMonths[4]);
            hashMap4.put(6L, shortMonths[5]);
            hashMap4.put(7L, shortMonths[6]);
            hashMap4.put(8L, shortMonths[7]);
            hashMap4.put(9L, shortMonths[8]);
            hashMap4.put(10L, shortMonths[9]);
            hashMap4.put(11L, shortMonths[10]);
            hashMap4.put(12L, shortMonths[11]);
            hashMap.put(pVar2, hashMap4);
        } else {
            simpleImmutableEntry = simpleImmutableEntry2;
            if (jVar == l.b.a.w.a.DAY_OF_WEEK) {
                DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale);
                hashMap = new HashMap();
                String[] weekdays = instance2.getWeekdays();
                HashMap hashMap5 = new HashMap();
                hashMap5.put(1L, weekdays[2]);
                hashMap5.put(2L, weekdays[3]);
                hashMap5.put(3L, weekdays[4]);
                hashMap5.put(4L, weekdays[5]);
                hashMap5.put(5L, weekdays[6]);
                hashMap5.put(6L, weekdays[7]);
                hashMap5.put(7L, weekdays[1]);
                hashMap.put(pVar3, hashMap5);
                HashMap hashMap6 = new HashMap();
                hashMap6.put(1L, weekdays[2].substring(0, 1));
                hashMap6.put(2L, weekdays[3].substring(0, 1));
                hashMap6.put(3L, weekdays[4].substring(0, 1));
                hashMap6.put(4L, weekdays[5].substring(0, 1));
                hashMap6.put(5L, weekdays[6].substring(0, 1));
                hashMap6.put(6L, weekdays[7].substring(0, 1));
                hashMap6.put(7L, weekdays[1].substring(0, 1));
                hashMap.put(pVar, hashMap6);
                String[] shortWeekdays = instance2.getShortWeekdays();
                HashMap hashMap7 = new HashMap();
                hashMap7.put(1L, shortWeekdays[2]);
                hashMap7.put(2L, shortWeekdays[3]);
                hashMap7.put(3L, shortWeekdays[4]);
                hashMap7.put(4L, shortWeekdays[5]);
                hashMap7.put(5L, shortWeekdays[6]);
                hashMap7.put(6L, shortWeekdays[7]);
                hashMap7.put(7L, shortWeekdays[1]);
                hashMap.put(pVar2, hashMap7);
            } else if (jVar == l.b.a.w.a.AMPM_OF_DAY) {
                DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale);
                hashMap = new HashMap();
                String[] amPmStrings = instance3.getAmPmStrings();
                HashMap hashMap8 = new HashMap();
                hashMap8.put(0L, amPmStrings[0]);
                hashMap8.put(1L, amPmStrings[1]);
                hashMap.put(pVar3, hashMap8);
                hashMap.put(pVar2, hashMap8);
            } else {
                if (jVar == l.b.a.w.a.ERA) {
                    DateFormatSymbols instance4 = DateFormatSymbols.getInstance(locale);
                    HashMap hashMap9 = new HashMap();
                    String[] eras = instance4.getEras();
                    HashMap hashMap10 = new HashMap();
                    hashMap10.put(0L, eras[0]);
                    hashMap10.put(1L, eras[1]);
                    hashMap9.put(pVar2, hashMap10);
                    if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                        hashMap10 = new HashMap();
                        hashMap10.put(0L, "Before Christ");
                        hashMap10.put(1L, "Anno Domini");
                    }
                    hashMap9.put(pVar3, hashMap10);
                    HashMap hashMap11 = new HashMap();
                    hashMap11.put(0L, eras[0].substring(0, 1));
                    hashMap11.put(1L, eras[1].substring(0, 1));
                    hashMap9.put(pVar, hashMap11);
                    obj = c(hashMap9);
                } else {
                    m mVar = c.a;
                    if (jVar == c.b.QUARTER_OF_YEAR) {
                        HashMap hashMap12 = new HashMap();
                        HashMap hashMap13 = new HashMap();
                        hashMap13.put(1L, "Q1");
                        hashMap13.put(2L, "Q2");
                        hashMap13.put(3L, "Q3");
                        hashMap13.put(4L, "Q4");
                        hashMap12.put(pVar2, hashMap13);
                        HashMap hashMap14 = new HashMap();
                        hashMap14.put(1L, "1st quarter");
                        hashMap14.put(2L, "2nd quarter");
                        hashMap14.put(3L, "3rd quarter");
                        hashMap14.put(4L, "4th quarter");
                        hashMap12.put(pVar3, hashMap14);
                        obj = c(hashMap12);
                    } else {
                        obj = "";
                    }
                }
                this.b.putIfAbsent(simpleImmutableEntry, obj);
                return this.b.get(simpleImmutableEntry);
            }
        }
        obj = c(hashMap);
        this.b.putIfAbsent(simpleImmutableEntry, obj);
        return this.b.get(simpleImmutableEntry);
    }
}
