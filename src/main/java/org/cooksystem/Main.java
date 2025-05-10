package org.cooksystem;

import org.cooksystem.models.*;
import org.cooksystem.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public boolean isStringEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public String sanitizeInput(String input, String defaultValue) {
    if (input == null || input.trim().isEmpty()) {
        return defaultValue;
    }
    return input.trim();
}

    public void debugLog(String tag, Object data) {
    if (data != null) {
        System.out.println("[DEBUG][" + tag + "] " + data.toString());
    } else {
        System.out.println("[DEBUG][" + tag + "] (null)");
    }
}

    
}
