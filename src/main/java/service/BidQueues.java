package service;

import model.Bid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class BidQueues {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidQueues.class);

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
        queues.forEach((k, v) -> LOGGER.info("type: {}, size: {}", k, v.size()));
    }

}
