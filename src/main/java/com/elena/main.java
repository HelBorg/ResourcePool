package com.elena;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> resList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ResourcePool<Integer> resource = new ResourcePool<>(resList, resList.size());
        for (int i = 0; i < 20; i++) {
            new ResPoolThread(resource, 16).start();
        }
    }
}
