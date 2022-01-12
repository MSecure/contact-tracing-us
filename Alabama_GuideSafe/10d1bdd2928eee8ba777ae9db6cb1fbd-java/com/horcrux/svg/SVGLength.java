package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

public class SVGLength {
    public final UnitType unit;
    public final double value;

    public enum UnitType {
        UNKNOWN,
        NUMBER,
        PERCENTAGE,
        EMS,
        EXS,
        PX,
        CM,
        MM,
        IN,
        PT,
        PC
    }

    public SVGLength() {
        this.value = 0.0d;
        this.unit = UnitType.UNKNOWN;
    }

    public static ArrayList<SVGLength> arrayFrom(Dynamic dynamic) {
        int ordinal = dynamic.getType().ordinal();
        if (ordinal == 2) {
            ArrayList<SVGLength> arrayList = new ArrayList<>(1);
            arrayList.add(new SVGLength(dynamic.asDouble()));
            return arrayList;
        } else if (ordinal == 3) {
            ArrayList<SVGLength> arrayList2 = new ArrayList<>(1);
            arrayList2.add(new SVGLength(dynamic.asString()));
            return arrayList2;
        } else if (ordinal != 5) {
            return null;
        } else {
            ReadableArray asArray = dynamic.asArray();
            int size = asArray.size();
            ArrayList<SVGLength> arrayList3 = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                arrayList3.add(from(asArray.getDynamic(i)));
            }
            return arrayList3;
        }
    }

    public static SVGLength from(Dynamic dynamic) {
        int ordinal = dynamic.getType().ordinal();
        if (ordinal == 2) {
            return new SVGLength(dynamic.asDouble());
        }
        if (ordinal != 3) {
            return new SVGLength();
        }
        return new SVGLength(dynamic.asString());
    }

    public SVGLength(double d) {
        this.value = d;
        this.unit = UnitType.NUMBER;
    }

    public SVGLength(String str) {
        String trim = str.trim();
        int length = trim.length();
        int i = length - 1;
        if (length == 0 || trim.equals("normal")) {
            this.unit = UnitType.UNKNOWN;
            this.value = 0.0d;
        } else if (trim.codePointAt(i) == 37) {
            this.unit = UnitType.PERCENTAGE;
            this.value = Double.valueOf(trim.substring(0, i)).doubleValue();
        } else {
            int i2 = length - 2;
            if (i2 > 0) {
                String substring = trim.substring(i2);
                char c = 65535;
                int hashCode = substring.hashCode();
                if (hashCode != 3178) {
                    if (hashCode != 3240) {
                        if (hashCode != 3251) {
                            if (hashCode != 3365) {
                                if (hashCode != 3488) {
                                    if (hashCode != 3571) {
                                        if (hashCode != 3588) {
                                            if (hashCode == 3592 && substring.equals("px")) {
                                                c = 0;
                                            }
                                        } else if (substring.equals("pt")) {
                                            c = 3;
                                        }
                                    } else if (substring.equals("pc")) {
                                        c = 4;
                                    }
                                } else if (substring.equals("mm")) {
                                    c = 5;
                                }
                            } else if (substring.equals("in")) {
                                c = 7;
                            }
                        } else if (substring.equals("ex")) {
                            c = 2;
                        }
                    } else if (substring.equals("em")) {
                        c = 1;
                    }
                } else if (substring.equals("cm")) {
                    c = 6;
                }
                switch (c) {
                    case 0:
                        this.unit = UnitType.NUMBER;
                        length = i2;
                        break;
                    case 1:
                        this.unit = UnitType.EMS;
                        length = i2;
                        break;
                    case 2:
                        this.unit = UnitType.EXS;
                        length = i2;
                        break;
                    case 3:
                        this.unit = UnitType.PT;
                        length = i2;
                        break;
                    case 4:
                        this.unit = UnitType.PC;
                        length = i2;
                        break;
                    case 5:
                        this.unit = UnitType.MM;
                        length = i2;
                        break;
                    case 6:
                        this.unit = UnitType.CM;
                        length = i2;
                        break;
                    case 7:
                        this.unit = UnitType.IN;
                        length = i2;
                        break;
                    default:
                        this.unit = UnitType.NUMBER;
                        break;
                }
                this.value = Double.valueOf(trim.substring(0, length)).doubleValue();
                return;
            }
            this.unit = UnitType.NUMBER;
            this.value = Double.valueOf(trim).doubleValue();
        }
    }
}
