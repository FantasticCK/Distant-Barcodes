package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i2[1] - i1[1]);
        for (int barcode : map.keySet()) {
            pq.offer(new int[]{barcode, map.get(barcode)});
        }
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (i == 0 || res[i - 1] != first[0]) {
                res[i] = first[0];
                if (--first[1] > 0)
                    pq.offer(first);
            } else {
                int[] second = pq.poll();
                res[i] = second[0];
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
            i++;
        }
        return res;
    }
}

