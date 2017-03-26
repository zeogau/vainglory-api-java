package gg.zeogau.vg.api.query;


import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by zeogau on 3/8/17.
 */
public class MatchParam {
    private Integer pageOffset = 0;
    private Integer pageLimit  = 50;
    private String  sort = "createdAt";
    private Date  start = null;
    private Date end = null;
    private List<String> playerNames = new ArrayList<String>();
    private List<String> teamNames = new ArrayList<String>();

    private static final int MAX_PAGES = 50;

    private static final String VAR_PAGEOFFSET = "page[offset]";
    private static final String VAR_PAGELIMIT = "page[limit]";
    private static final String VAR_SORT = "sort";
    private static final String VAR_START = "filter[createdAt-start]";
    private static final String VAR_END = "filter[createdAt-end]";
    private static final String VAR_FILTERPLAYER = "filter[playerNames]";
    private static final String VAR_FILTERTEAM = "filter[teamNames]";
    private static final String VAR_ = "";

    public MatchParam() {

    }

    public MatchParam setPageOffset (final Integer pageOffset) {
        this.pageOffset = pageOffset;
        if (this.pageOffset >= MAX_PAGES) this.pageOffset = MAX_PAGES - 1;
        return this;
    }
    public MatchParam setPageLimit (final Integer pageLimit) {
        this.pageLimit = pageLimit;
        if (this.pageLimit > MAX_PAGES) this.pageLimit = MAX_PAGES;
        return this;
    }
    public MatchParam setSort (final String sort) {
        this.sort = sort.trim();
        return this;
    }
    public MatchParam setStart (final Date start) {
        this.start = start;
        return this;
    }
    public MatchParam setEnd (final Date end) {
        this.end = end;
        return this;
    }
    public MatchParam setPlayers (List<String> list) {
        this.playerNames.clear();
        this.playerNames.addAll(list);
        return this;
    }
    public MatchParam addPlayer (String player) {
        this.playerNames.add(player);
        return this;
    }
    public MatchParam setTeams (List<String> list) {
        this.teamNames.clear();;
        this.teamNames.addAll(list);
        return this;
    }
    public MatchParam addTeam (String teamName) {
        this.teamNames.add(teamName);
        return this;
    }

    private static final ISO8601DateFormat dateFormat = new ISO8601DateFormat();

    public String generateParam() {
        String ret = "";

        ret +=  VAR_PAGEOFFSET + "=" + pageOffset.toString();
        ret +=  "&" + VAR_PAGELIMIT + "=" + pageLimit.toString();
        if (!sort.equals("")) ret += "&" + VAR_SORT + "=" + sort.toString();
        if (start!=null) ret += "&" + VAR_START + "=" + dateFormat.format(start);
        if (end!=null) ret += "&" + VAR_END + "=" + dateFormat.format(end);
        if (playerNames.size() > 0) ret += "&" + VAR_FILTERPLAYER + "=" + delimited(playerNames);
        if (teamNames.size() > 0) ret += "&" + VAR_FILTERTEAM + "=" + delimited(teamNames);
        return ret;
    }

    public static String delimited (List<String> list) {
        if (list==null || list.size()==0) return "";
        String ret = list.get(0).trim();
        for (int k = 1; k < list.size() ; k++)
            ret += "," + list.get(k).trim();
        return ret;
    }
}
