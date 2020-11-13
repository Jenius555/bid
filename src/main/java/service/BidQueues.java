package service;

import model.Bid;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class BidQueues {

    private Map<String, LinkedBlockingQueue<BidThread>> queues;

    public BidQueues() {
        queues = new HashMap<>();
    }

    public boolean add(Bid bid) {
        LinkedBlockingQueue<BidThread> q = queues.computeIfAbsent(bid.getTy(), k -> new LinkedBlockingQueue<>());
        BidThread thread = new BidThread(bid);
        return q.add(thread);
    }

    public BidThread get(String type) {
        LinkedBlockingQueue<BidThread> q = queues.computeIfAbsent(type, k -> new LinkedBlockingQueue<>());
        return q.poll();
    }

    public void printStatus() {
        queues.forEach((k, v) -> System.out.println("type: " + k + ", size:" + v.size()));
    }

}
