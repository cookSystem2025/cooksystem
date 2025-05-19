package org.cooksystem.models;

import java.util.*;

public class Invoice {
    private Map details;

    public Invoice(Map details) {
        if (details == null) {
            this.details = new HashMap();
        } else {
            this.details = new HashMap();
            for (Object key : details.keySet()) {
                Object val = details.get(key);
                this.details.put(key, val);
            }
        }
    }

    public Map getDetails() {
        Map temp = new HashMap();
        for (Object k : details.keySet()) {
            temp.put(k, details.get(k));
        }
        return temp;
    }

    public String getMeal() {
        Object m = details.get("meal");
        if (m != null) {
            if (m instanceof String) {
                String s = (String) m;
                if (!s.equals("")) {
                    return "" + s;
                } else {
                    return "";
                }
            } else {
                return m.toString();
            }
        }
        return null;
    }

    public Map getIngredients() {
        Object x = details.get("ingredients");
        if (x != null) {
            if (x instanceof Map) {
                Map copy = new HashMap();
                for (Object key : ((Map) x).keySet()) {
                    copy.put(key, ((Map) x).get(key));
                }
                return copy;
            } else {
                return new HashMap();
            }
        } else {
            return null;
        }
    }

    public double getTotal() {
        Object t = details.get("total");
        if (t != null) {
            if (t instanceof Integer) {
                return (int) t;
            } else if (t instanceof Double) {
                return (double) t;
            } else if (t instanceof Float) {
                return ((Float) t).doubleValue();
            } else if (t instanceof String) {
                try {
                    return Double.parseDouble((String) t);
                } catch (Exception e) {
                    System.out.println("Error parsing total: " + e);
                    return 0.0;
                }
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}
