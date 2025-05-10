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
    
}
