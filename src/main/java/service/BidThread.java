package service;

import model.Bid;

public class BidThread extends Thread {

    private Bid bid;

    public BidThread(Bid bid) {
        this.bid = bid;
    }

    public void run() {
        System.out.println("Thread running for " + bid.getId());
    }
}
