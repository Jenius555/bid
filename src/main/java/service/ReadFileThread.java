package service;

import model.Bid;
import model.BidWrap;

public class ReadFileThread extends Thread {

    private BidQueues queues;

    public ReadFileThread(BidQueues queues) {
        this.queues = queues;
    }

    public void run() {

        BidWrap[] bids = BidFileReader.readFile();

        if (bids == null) {
            return;
        }

        for (BidWrap bidWrap : bids) {
            Bid bid = bidWrap.getBid();
            if (queues.add(bid)) {
                LogBid.print(bid);
            }
        }
    }
}
