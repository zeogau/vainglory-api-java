package gg.zeogau.vg.api.model.common;


/**
 * Created by zeogau on 3/8/17.
 */
public class Relationship {
    private WrapperMultiple assets;
    private WrapperMultiple rosters;
    private WrapperMultiple rounds;
    private WrapperSingle player;
    private WrapperMultiple participants;
    private WrapperSingle team;

    @Override
    public String toString() {
        return "Relationship{" +
                "assets=" + assets +
                ", rosters=" + rosters +
                ", rounds=" + rounds +
                ", player=" + player +
                ", participants=" + participants +
                ", team=" + team +
                '}';
    }

    public WrapperMultiple getAssets() {
        return assets;
    }

    public void setAssets(WrapperMultiple assets) {
        this.assets = assets;
    }

    public WrapperMultiple getRosters() {
        return rosters;
    }

    public void setRosters(WrapperMultiple rosters) {
        this.rosters = rosters;
    }

    public WrapperMultiple getRounds() {
        return rounds;
    }

    public void setRounds(WrapperMultiple rounds) {
        this.rounds = rounds;
    }

    public WrapperSingle getPlayer() {
        return player;
    }

    public void setPlayer(WrapperSingle player) {
        this.player = player;
    }

    public WrapperMultiple getParticipants() {
        return participants;
    }

    public void setParticipants(WrapperMultiple participants) {
        this.participants = participants;
    }

    public WrapperSingle getTeam() {
        return team;
    }

    public void setTeam(WrapperSingle team) {
        this.team = team;
    }
}
