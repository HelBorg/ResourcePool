package com.elena;

import java.util.List;

public class ResPoolThread extends Thread {
    private ResourcePool<Integer> resource;
    private Integer resNum;

    public ResPoolThread(ResourcePool<Integer> resource, Integer resNum) {
        this.resource = resource;
        this.resNum = resNum;
    }

    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        if (resNum > resource.getSize()) {
            System.out.println("There aren't so many resources\n");
            return;
        }
        List<Integer> freeResource = this.resource.getResource(this.resNum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.resource.freeResources(freeResource);
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}