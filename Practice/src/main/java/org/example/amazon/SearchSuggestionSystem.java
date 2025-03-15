package org.example.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l = 0, r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c))
                l++;
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c))
                r--;

            List<String> suggestions = new ArrayList<>();
            int len = r - l + 1;
            for (int j = 0; j < Math.min(3, len); j++) {
                suggestions.add(products[l + j]);
            }
            res.add(suggestions);
        }
        return res;
    }
}
