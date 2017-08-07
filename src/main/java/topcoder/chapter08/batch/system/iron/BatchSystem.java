package topcoder.chapter08.batch.system.iron;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 8. 6.
 * Time: 오후 9:30
 */
public class BatchSystem {


    public static void main(String[] args) {
        BatchSystem b = new BatchSystem();

        int[] duration = {200, 200, 200};
        String[] user = {"Gil", "Sarah", "Warrick"};
        int[] sort = b.schedule(duration, user);

        System.out.println(sort.toString());
    }

    // user 별 작업 시간 계산 후 낮은순으로 정렬
    public int[] schedule(int[] duration, String[] user) {
    Map<String, Long> batch = Maps.newLinkedHashMap();

        //map initialize
        for(int i = 0; i < duration.length; i++) {
            Long durationOfUser =  batch.getOrDefault(user[i], 0L);
            batch.put(user[i], durationOfUser + duration[i]);
        }

        Map sortedBatch = BatchSystem.sortByValue(batch);


        int[] aa = new int[user.length];
        int count = 0;
        for(Object a : sortedBatch.keySet()) {
            for(int i = 0; i < user.length; i++) {
                if(a.equals(user[i])) {
                    aa[count++] = i;
                }
            }
        }

        return aa;
    }



    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }
}
