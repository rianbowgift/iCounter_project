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
import java.util.Scanner;


@SpringBootApplication
public class Maven1stProjectApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Maven1stProjectApplication.class, args);
//        String Address;
//        URL url;
//        BufferedReader br;
//        String br2 = "";
//        HttpURLConnection conn;
//        String protocol = "GET";
//        Address = "http://ddragon.leagueoflegends.com/cdn/12.2.1/data/en_US/champion.json";
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

        String api_key = "RGAPI-78611ba4-8d04-4f18-8c4e-35d2860132de";
        String puuid = "ykf_FrhmicM1ksVlrEcSDlz12jGJCk3n4dV59U6xfNZBN1iweL0YNDams1UFvU3XFLpjmgMCGFl3Qg";
        int start = 0;
        int end = 30;
        //소환사 정보 가저오기,accountId puuid id 등
        Address = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ SummonerName + "?api_key=" + api_key;

        //로테이션 정보 가저오기 챔피언id
        String Address2 = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + api_key;

        //소환사 숙련도레벨, 숙련도포인트점수, 챔피언 플레이시간 가저오기
        String Address3 = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/c7lwgwuf4my_-k31xpjlVMLTbO2RhrqaGSxWfS7Xx4_xCQ?api_key=" + api_key;

        // 최근 매칭 정보 가저오기(매칭번호만 가저온다. puuid,index,index(max)를 입력한다. 반드시 address5와 연동되야한다
        String Address4 = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/ykf_FrhmicM1ksVlrEcSDlz12jGJCk3n4dV59U6xfNZBN1iweL0YNDams1UFvU3XFLpjmgMCGFl3Qg/ids?start=0&count=30&api_key=" + api_key;

        //모든챔피언 정보( id와 이름 능력치 등)
        String Address6 = "https://ddragon.leagueoflegends.com/cdn/12.2.1/data/en_US/champion.json";

        url = new URL(Address);
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));




        JSONParser jsonParser = new JSONParser();

////        // {로 받을때
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
       System.out.println(jsonObject);


//        // [ 로받을때
    //    JSONArray jsonArray = (JSONArray) jsonParser.parse(br);
//        System.out.println(jsonArray);
//        for(int i=0;i< jsonArray.size();i++){
//            System.out.println(jsonArray.get(i));
//        }

//        Object match_num = jsonArray.get(0);
//        //가저온 매치id를 바탕으로 경기 내용 분석
//        String Address5 = "https://asia.api.riotgames.com/lol/match/v5/matches/" + match_num +"?api_key=" + api_key;
//        url = new URL(Address5);
//        conn = (HttpURLConnection)url.openConnection();
//        conn.setRequestMethod(protocol);
//        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//        JSONParser jsonParser2 = new JSONParser();
//        JSONObject jsonObject = (JSONObject) jsonParser2.parse(br);
// //       System.out.println(jsonObject);
//
//        JSONParser jsonParser3= new JSONParser();
//        JSONObject jsonObject_info = (JSONObject)jsonObject.get("info");
//
//
////        System.out.println(jsonObject_info.get("participants"));
//
//        JSONArray jsonArray_participants = (JSONArray) jsonObject_info.get("participants");
//        for(int i=0;i< jsonArray_participants.size();i++){
//            System.out.println(jsonArray_participants.get(i));
//            System.out.println();
//        }
//
//
////        JSONObject jsonObject_participants = (JSONObject)jsonObject_info.get("participants");
//
////        System.out.println(jsonObject_participants);
//
//        System.out.println();



    }

}
