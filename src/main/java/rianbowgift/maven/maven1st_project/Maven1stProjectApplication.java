package rianbowgift.maven.maven1st_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.util.Iterator;


@SpringBootApplication
public class Maven1stProjectApplication {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Maven1stProjectApplication.class, args);
//        String Address;
//        URL url;
//        BufferedReader br;
//        String br2 = "";
//        HttpURLConnection conn;
//        String protocol = "GET";
//        Address = "http://ddragon.leagueoflegends.com/cdn/10.6.1/data/en_US/champion.json";
//
//        url = new URL(Address);
//        conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod(protocol);
//        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"MS949"));
//
////        JSONParser jsonParse = new JSONParser();
////        JSONObject jsonObj = (JSONObject) jsonParse.parse(br);
////
//
//        JSONParser jsonParser = new JSONParser();
//
//        //JSON데이터를 넣어 JSON Object 로 만들어 준다.
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
//
//        JSONObject bookObject = (JSONObject) jsonObject.get("data");
//        JSONObject bookObject2 = (JSONObject) bookObject.get("Jax");
//        JSONObject bookObject3 = (JSONObject) bookObject2.get("stats");
//        Object bookObject4 = bookObject2.get("key");
//
//        Iterator<String> keys = bookObject.keySet().iterator();
//        String[] champion = new String[bookObject.size()];
//
//        int champion_temp = 0;
//        while (keys.hasNext()) {
//            String key = keys.next();
//
//            champion[champion_temp] = key;
//            System.out.print("KEY : " + key + "  ");
//            System.out.println(champion[champion_temp]);
//            champion_temp++;
//        }
//




        String SummonerName = "reimei";
        String Address;
        URL url;
        BufferedReader br;
        String br2 = "";
        HttpURLConnection conn;
        String protocol = "GET";
        //소환사 정보 가저오기,accountId puuid id 등
        Address = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ SummonerName + "?api_key=" + "RGAPI-cf5af048-ff21-42c1-ac0e-b13a942247f2";

        //로테이션 정보 가저오기 챔피언id
        String Address2 = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + "RGAPI-5c090740-1a7a-4c22-aceb-2af3fdf19517";


        String Address3 = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/Ks8A_CiiYjA8pfnjRtjGZN-mPv2jh_lS_lk-iBOQYdMOjKs";

        url = new URL(Address);
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"MS949"));




        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);


        System.out.println(jsonObject);





    }

}
