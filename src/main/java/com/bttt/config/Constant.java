package com.bttt.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sem Babenko.
 */
public class Constant {

    private static final Map<String, Integer> LOCATION_TABLE = new HashMap<>();

    static {
        for (int i = 1, d = 48, l = 1; i <= 3; d++, i++) {
            for (int s = 65, m = 97, c = 0; c < 3; l++, c++, s++, m++) {
                String loc1 = String.valueOf((char) m) + String.valueOf((char) d);
                String loc2 = String.valueOf((char) s) + String.valueOf((char) d);
                LOCATION_TABLE.put(loc1, l);
                LOCATION_TABLE.put(loc2, l);
                LOCATION_TABLE.put(new StringBuilder(loc1).reverse().toString(), l);
                LOCATION_TABLE.put(new StringBuilder(loc2).reverse().toString(), l);
            }
        }
    }


    public static Integer getLocation(String val) {
        return LOCATION_TABLE.get(val);
    }

}
