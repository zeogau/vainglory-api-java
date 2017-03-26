package gg.zeogau.vg.api;

import gg.zeogau.vg.api.model.Shard;
import gg.zeogau.vg.api.model.common.ContainerSingular;
import gg.zeogau.vg.api.model.common.ContainerPlural;
import gg.zeogau.vg.api.model.other.Status;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;


import com.fasterxml.jackson.databind.ObjectMapper;
import gg.zeogau.vg.api.query.MatchParam;


/**
 * Created by zeogau on 3/4/17.
 */
public  class ApiReader {

    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_ENCODING_GZIP = "gzip";

    private static final String X_TITLE_ID_HEADER = "X-TITLE-ID";
    private static final String X_TITLE_ID_VALUE = "semc-vainglory";

    private static final String ACCEPT_HEADER = "Accept";
    private static final String ACCEPT_VALUE = "application/json";

    private static final String AUTH_HEADER = "Authorization";
    private static final String AUTH_PREFIX = "Bearer ";

    private static final String STATUS_API_URL = "https://api.dc01.gamelockerapp.com/status";
    private static final String BASE_API_URL = "https://api.dc01.gamelockerapp.com/shards";

    private static final String MATCH_ENDPOINT = "/matches";
    private static final String PLAYER_ENDPOINT = "/players";


    private final String apiKey;

    public ApiReader (final String apiKey) {
        this.apiKey = apiKey;

    }

    private boolean serverChecked = false;
    public void checkStatus() {
        if (serverChecked) return;
        final Status s = makeTheCall(STATUS_API_URL,  Status.class);
        if (s!=null) {
            System.out.println(s.getData().getAttributes().getVersion());
        }
    }



    private <T> T makeTheCall(final String urlString, final Class<T> classOfT) {

        try {
            URL url = new URL(urlString);
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty(CONTENT_ENCODING_HEADER, CONTENT_ENCODING_GZIP);
            conn.setRequestProperty(ACCEPT_HEADER, ACCEPT_VALUE);
            conn.setRequestProperty(X_TITLE_ID_HEADER, X_TITLE_ID_VALUE);
            conn.setRequestProperty(AUTH_HEADER, AUTH_PREFIX + apiKey);

            BufferedReader br;
            if (conn.getResponseCode() != 200) {
                try {
                    br = new BufferedReader(new InputStreamReader(
                            (conn.getErrorStream())));
                }catch (Exception ex) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
            }
            else {
                br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
            }


            String alloutput = new String("");
            String output;
            while ((output = br.readLine()) != null) {
                alloutput += output;
            }
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            return (T)mapper.readValue(alloutput, classOfT);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



    private <T> T getData(final Class<T> classOfT, final String endPoint) {
        final T t = (T)makeTheCall(BASE_API_URL + endPoint,  classOfT);
        return t;
    }

    public ContainerSingular getMatchById(final Shard shard, final String matchId) {
        final String endPoint = "/" + shard.getShortCode() + MATCH_ENDPOINT + "/" + matchId;
        final ContainerSingular m = getData(ContainerSingular.class, endPoint);
        return m;
    }

    public ContainerPlural getMatches (final Shard shard, final MatchParam param) {
        final String strParam = param.generateParam();
        final String endPoint = "/" + shard.getShortCode() + MATCH_ENDPOINT + "?" + param.generateParam();

        final ContainerPlural m = getData(ContainerPlural.class, endPoint);
        return m;
    }

    public ContainerSingular getPlayerById(final Shard shard, final String playerId) {
        final String endPoint = "/" + shard.getShortCode() + PLAYER_ENDPOINT + "/" + playerId;
        final ContainerSingular m = getData(ContainerSingular.class, endPoint);
        return m;
    }




    public static void main(String[] args) {
        final ApiReader api = new ApiReader("");
        api.checkStatus();
//        Match m = api.getMatchById(Shard.NA, "0a3d8eb8-fd4f-11e6-bc8d-06bea641826e");
//        ContainerSingular m = api.getPlayerById(Shard.NA, "655f9206-6ee9-11e4-8f5c-06641bcbf424");
        Calendar cal =  Calendar.getInstance();
        cal.set(2017, Calendar.MARCH,12);
        ContainerPlural m = api.getMatches(Shard.NA, new MatchParam().addPlayer("dumbstep").setStart(cal.getTime()));
        System.out.println(m);
    }


}
