package com.elena;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ResourcePool<T> {
    private Stack<T> resource;
    private Integer size;

    public ResourcePool(List<T> resource, Integer size) {
        this.resource = new Stack<>();
        this.resource.addAll(resource);
        this.size = size;
    }

    public synchronized List<T> getResource(int count) {
        List<T> resource = new LinkedList<>();
        while (this.resource.size() < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < count; i++) resource.add(this.resource.pop());

        return resource;
    }

    public synchronized void freeResources(List<T> freeResource) {
        for (T u : freeResource) resource.push(u);
        notifyAll();
    }

    public Integer getSize() {
        return size;
    }
}
