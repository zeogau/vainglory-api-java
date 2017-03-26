package gg.zeogau.vg.datadumper.service;

import gg.zeogau.vg.api.model.asset.AssetModel;
import gg.zeogau.vg.api.model.match.MatchModel;
import gg.zeogau.vg.api.model.participant.ParticipantModel;
import gg.zeogau.vg.api.model.player.PlayerModel;
import gg.zeogau.vg.api.model.roster.RosterModel;
import gg.zeogau.vg.api.model.team.TeamModel;
import gg.zeogau.vg.datadumper.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zeogau on 3/11/17.
 */
public class Creator {

    public static <T> List<T> executeQuery (final EntityManager em, final Class<T> classOfT, final String queryName, final Map<String, Object> map) {
        Query q = em.createNamedQuery(queryName, classOfT);
        if (map!=null && map.size() > 0) {
            for (String key : map.keySet()) {
                Object obj = map.get(key);
                q.setParameter(key, obj);
            }
        }
        return q.getResultList();
    }

    public static <T> T executeQuerySingle (final EntityManager em, final Class<T> classOfT, final String queryName, final Map<String, Object> map) {
        Query q = em.createNamedQuery(queryName, classOfT);
        if (map!=null && map.size() > 0) {
            for (String key : map.keySet()) {
                Object obj = map.get(key);
                q.setParameter(key, obj);
            }
        }
        try {
            return (T) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public void createHero(final String heroName) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Hero.FINDBYNAME_PARAM, heroName);
        List<Hero> list = executeQuery(em, Hero.class, Hero.FINDBYNAME, map);
        if (list.size()==1) return;


        Hero h = new Hero(heroName);

        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();;
    }

    public void createItem(final String itemName) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Item.FINDBYNAME_PARAM, itemName);
        List<Item> list = executeQuery(em, Item.class, Item.FINDBYNAME, map);
        if (list.size()==1) return;


        Item h = new Item(itemName);

        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();;
    }

    public void createMatch (final MatchModel model) {
        Match x = prepareMatch(model);
        saveMatch(x);
    }

    public Match prepareMatch (final MatchModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Match.FINDBYVGID_PARAM, model.getId());
        Match x = executeQuerySingle(em, Match.class, Match.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Match.importFromModel(model);

        return x;
    }

    public void saveMatch (final Match x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getMatchId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();;
    }

    public void createPlayer (final PlayerModel model) {
        Player x = preparePlayer(model);
        savePlayer(x);
    }

    public Player preparePlayer (final PlayerModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Player.FINDBYVGID_PARAM, model.getId());
        Player x = executeQuerySingle(em, Player.class, Player.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Player.importFromModel(model);
        return x;
    }

    public void savePlayer (final Player x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getPlayerId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();
    }


    public void createRoster (final RosterModel model) {
        Roster x = prepareRoster(model);
        saveRoster(x);
    }

    public Roster prepareRoster (final RosterModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Roster.FINDBYVGID_PARAM, model.getId());
        Roster x = executeQuerySingle(em, Roster.class, Roster.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Roster.importFromModel(model);
        return x;
    }

    public void saveRoster (final Roster x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getRosterId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();
    }

    public void createParticipant (final ParticipantModel model) {
        Participant x = prepareParticipant(model);
        saveParticipant(x);
    }

    public Participant prepareParticipant (final ParticipantModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Participant.FINDBYVGID_PARAM, model.getId());
        Participant x = executeQuerySingle(em, Participant.class, Participant.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Participant.importFromModel(model);

        //find hero
        map = new HashMap<String, Object>();
        map.put(Hero.FINDBYALIAS_PARAM, x.getHeroName());
        Hero h = executeQuerySingle(em, Hero.class, Hero.FINDBYALIAS, map);
        if (h!=null) {
//            x.setHeroId(h.getHeroId());
            x.setHero(h);
        }
        return x;
    }

    public void saveParticipant (final Participant x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getParticipantId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();
    }

    public void createTeam (final TeamModel model) {
        Team x = prepareTeam(model);
        saveTeam(x);
    }

    public Team prepareTeam (final TeamModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Team.FINDBYVGID_PARAM, model.getId());
        Team x = executeQuerySingle(em, Team.class, Team.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Team.importFromModel(model);
        return x;
    }

    public void saveTeam (Team x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getTeamId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();
    }




    public void createAsset (final AssetModel model) {
        Asset x = prepareAsset(model);
        saveAsset(x);
    }

    public Asset prepareAsset (final AssetModel model) {
        EntityManager em = EntityManagement.getTheManager();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Asset.FINDBYVGID_PARAM, model.getId());
        Asset x = executeQuerySingle(em, Asset.class, Asset.FINDBYVGID, map);
        if (x!=null) x.updateFromModel(model);
        else x = Asset.importFromModel(model);
        return x;
    }

    public void saveAsset (Asset x) {
        EntityManager em = EntityManagement.getTheManager();
        em.getTransaction().begin();
        if (x.getAssetId()!=null) em.merge(x);
        else  em.persist(x);
        em.getTransaction().commit();
    }







    public static void main(String[] args) {
        Creator c = new Creator();
//        c.createHero("Koshka");

//        c.createItem("Blade");

        EntityManager em = EntityManagement.getTheManager();
        Roster r = em.find(Roster.class, (long)139);
        r.setAcesEarned((short)9);

        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();;
    }
}
