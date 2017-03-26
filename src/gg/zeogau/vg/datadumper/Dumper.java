package gg.zeogau.vg.datadumper;


import gg.zeogau.vg.api.ApiReader;
import gg.zeogau.vg.api.model.Shard;
import gg.zeogau.vg.api.model.asset.AssetModel;
import gg.zeogau.vg.api.model.common.BaseModel;
import gg.zeogau.vg.api.model.common.ContainerPlural;
import gg.zeogau.vg.api.model.match.MatchModel;
import gg.zeogau.vg.api.model.participant.ParticipantModel;
import gg.zeogau.vg.api.model.player.PlayerModel;
import gg.zeogau.vg.api.model.roster.RosterModel;
import gg.zeogau.vg.api.model.team.TeamModel;
import gg.zeogau.vg.api.query.MatchParam;
import gg.zeogau.vg.datadumper.model.*;
import gg.zeogau.vg.datadumper.service.Creator;
import gg.zeogau.vg.datadumper.service.EntityManagement;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * Created by zeogau on 3/9/17.
 */
public class Dumper {

    public static void main2(String[] args) {
        final ApiReader api = new ApiReader("");
        api.checkStatus();
//        String [] list = { "IllesT", "Exhail", "BestChuckNa", "VONC"};
//        String [] list = {   "AltPlusF4", "Maximalist", "Ghassan666", "BlueStacks"};
        String [] list = {  "Sciamachy"};
        for (String name : list) {
            try {
                mainHelper(api, name);
            } catch (Exception ex) {
                System.out.println("Error:" + name + " : " + ex.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        final ApiReader api = new ApiReader("");
        api.checkStatus();
        EntityManager em = EntityManagement.getTheManager();
        List<Player> list = Creator.executeQuery(em, Player.class, Player.FINDALL, null);
        System.out.println(list.size());
        Collections.shuffle(list);
        for (int i = 0 ; i < list.size(); i++) {
            String name = list.get(i).getIgn();
            try {
                System.out.println("Start processing: " + name);
                mainHelper(api, name);
            } catch (Exception ex) {
                System.out.println("Error:" + name);
            }
        }
    }

    public static void mainHelper(ApiReader api, String playername) throws Exception{
        Calendar cal =  Calendar.getInstance();
        cal.set(2017, Calendar.MARCH,10);
        ContainerPlural m = api.getMatches(Shard.NA,
                new MatchParam().addPlayer(playername).setStart(cal.getTime()).setPageOffset(0)
            );
        if (m==null || m.getData()==null) {
            if (m.getErrors()==null || m.getErrors().size()<1) return;
            for (Map<String, String> map : m.getErrors()){
                for (String key : map.keySet()) {
                    String content = map.get(key);
                    System.out.println(key + ":" + content);
                }
            }
            return;
        }


        List<Match> matches = new ArrayList<Match>();
        List<Player> players = new ArrayList<Player>();
        List<Roster> rosters = new ArrayList<Roster>();
        List<Participant> participants = new ArrayList<Participant>();
        List<Team> teams = new ArrayList<Team>();
        List<Asset> assets = new ArrayList<Asset>();

        Creator c = new Creator();
        for (BaseModel b : m.getData()) {
            MatchModel model = (MatchModel)b;
            matches.add(c.prepareMatch(model));

//            System.out.println(model.getId());
//            c.createMatch(model);
        }

        if (m.getIncluded()!=null)
        for (BaseModel b : m.getIncluded()) {
            if (b instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) b;
                players.add(c.preparePlayer(model));
//                System.out.println(model.getId());
//                c.createPlayer(model);
            } else if (b instanceof RosterModel) {
                RosterModel model = (RosterModel) b;
                rosters.add(c.prepareRoster(model));
//                System.out.println(model.getId());
//                c.createRoster(model);
            } else if (b instanceof ParticipantModel) {
                ParticipantModel model = (ParticipantModel) b;
                participants.add(c.prepareParticipant(model));
//                System.out.println(model.getId());
//                c.createParticipant(model);
            } else if (b instanceof TeamModel) {
                TeamModel model = (TeamModel) b;
                teams.add(c.prepareTeam(model));
//                System.out.println(model);
//                c.createTeam(model);
            } else if (b instanceof AssetModel) {
                AssetModel model = (AssetModel) b;
                assets.add(c.prepareAsset(model));
            }
        }


        for (Player x : players) c.savePlayer(x);
        for (Team x : teams) c.saveTeam(x);


        //link participant to roster
        for (Roster x : rosters) {
            for (String id : x.getParticipantIds()) {
                for (Participant p : participants) {
                    if (p.getVgParticipantId().equals(id) && p.getRoster()==null) p.setRoster(x);
                }
                System.out.println(id);
            }
        }

        for (Participant x : participants) {
            if (x.getPlayer()==null && x.getVgPlayerId()!=null) {
                for (Player p : players) {
                    if (p.getVgPlayerId().equals(x.getVgPlayerId())){
                        x.setPlayer(p);
                        break;
                    }
                }
            }
            c.saveParticipant(x);
        }
        for (Match x : matches) {
            c.saveMatch(x);
            for (String id : x.getRosterIds()) {
                for (Roster r : rosters) {
                    if (r.getVgRosterId().equals(id) && r.getMatch()==null) r.setMatch(x);
                }
            }
            for (String id : x.getAssetIds()) {
                for (Asset a : assets) {
                    if (a.getVgAssetId().equals(id) && a.getMatch()==null) a.setMatch(x);
                }
            }
            System.out.println(x.getVgMatchId());
        }

        for (Roster x : rosters) {
            if (x.getTeam()==null && x.getVgTeamId()!=null) {
                for (Team t : teams) {
                    if (t.getVgTeamId().equals(x.getVgTeamId())) {
                        x.setTeam(t);
//                        if (t.getShardId()==null || t.getShardId().trim().equals("")) {
//                            t.setShardId(x.getMatch().getShardId());
//                            System.out.println(x.getMatch().getShardId());
//                        } else {
//                            System.out.println("shard = " + t.getShardId());
//                        }
                        break;
                    }
                }
            }
            c.saveRoster(x);
        }

        for (Asset x : assets) c.saveAsset(x);

        System.out.println("Done");
    }
}
