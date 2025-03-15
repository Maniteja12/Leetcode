package org.example.blind75.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            if (numSet.contains(n)) return true;
            numSet.add(n);
        }

        return false;
    }
}