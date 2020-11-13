package model;

public class BidWrap {

    private Bid bid;

    public BidWrap() {
    }

    public BidWrap(Bid bid) {
        this.bid = bid;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "BidWrap{" +
                "bid=" + bid +
                '}';
    }
}
