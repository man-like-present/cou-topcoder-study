package topcoder.chapter05.party.corelle;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

public class SRM494InterstingPartySelector {

    public static void main(String[] args) {
//        String[] first = {"va", "div", "lo", "co"};
//        String[] second = {"ta", "sp", "dis", "me"};
//        System.out.println("1 -> Answer");
        String[] first = {"sn", "pr", "co", "mo"};
        String[] second = {"py", "py", "an", "py"};
        System.out.println("3 -> Answer");
        bestInvitation(first, second);
        bestInvitation2(first, second);
        bestInvitation3(first, second);
    }

    private static void bestInvitation(String[] first, String[] second) {
        int count = 1;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first.length; j++) {
                if (i == j) {
                    break;
                }
                boolean isInvitation = first[i].equals(first[j]) || first[i].equals(second[j]) || second[i].equals(first[j]) || second[i].equals(second[j]);
                if (isInvitation) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count + " -> bestInvitation");
    }

    private static void bestInvitation2(String[] first, String[] second) {
        int count = 0;
        for (int i = 0; i < first.length; i++) {
            int f = 0;
            int s = 0;
            for (int j = 0; j < first.length; j++) {
                if (first[i].equals(first[j])) f++;
                if (first[i].equals(second[j])) f++;
                if (second[i].equals(first[j])) s++;
                if (second[i].equals(second[j])) s++;
            }
            count = Math.max(f, count);
            count = Math.max(s, count);
        }
        System.out.println(count + " -> bestInvitation2");
    }

    private static void bestInvitation3(String[] first, String[] second) {
        HashMap<String, Integer> hashMap = Maps.newHashMap();

        for (int i = 0; i < first.length; i++) {
            String firstString = first[i];
            String secondString = second[i];
            hashMap.put(firstString, hashMap.get(firstString) == null ? 1 : hashMap.get(firstString) + 1);
            hashMap.put(secondString, hashMap.get(secondString) == null ? 1 : hashMap.get(secondString) + 1);
        }


        int count = 0;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            count = Math.max(count, entry.getValue());
        }

        System.out.println(count + " -> bestInvitation3");
    }
}
