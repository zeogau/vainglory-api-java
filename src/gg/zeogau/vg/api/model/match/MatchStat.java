package gg.zeogau.vg.api.model.match;

/**
 * Created by zeogau on 3/7/17.
 */
public class MatchStat {
    private String endGameReason;
    private String queue;


    @Override
    public String toString() {
        return "MatchStat{" +
                "endGameReason='" + endGameReason + '\'' +
                ", queue='" + queue + '\'' +
                '}';
    }

    public String getEndGameReason() {
        return endGameReason;
    }

    public void setEndGameReason(String endGameReason) {
        this.endGameReason = endGameReason;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
