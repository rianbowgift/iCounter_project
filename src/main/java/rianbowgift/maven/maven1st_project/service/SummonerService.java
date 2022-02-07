package rianbowgift.maven.maven1st_project.service;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import rianbowgift.maven.maven1st_project.domain.User;
import rianbowgift.maven.maven1st_project.dto.match.MatchDto;
import rianbowgift.maven.maven1st_project.dto.match.ParticipantDto;
import rianbowgift.maven.maven1st_project.dto.summoner.SummonerDTO;
import rianbowgift.maven.maven1st_project.repository.SummonerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Transactional
public class SummonerService {


    private final SummonerRepository summonerRepository;
    String api_key = "RGAPI-a0d83073-f856-4c38-bf36-0afbd5c41a9b";

    @Autowired
    public SummonerService(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    public String join(User user){
        summonerRepository.save(user);
        return user.getId();

    }



    public User Summoner(String name) throws IOException, ParseException {
        //미리 입력된 api와 사용자에게 입력받은 id를 조합하여 RESTAPI로 사용자의 정보를 가저온다.
        //이떄, json형식으로 받아오기때문에 dto파일에 저장한다
        //System.out.println("id = " + name);
        String Address = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ name + "?api_key=" + api_key;
        String protocol = "GET";
        URL url = new URL(Address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
        //System.out.println(jsonObject);

        Gson gson = new Gson();
        User vo = gson.fromJson(jsonObject.toString(), User.class);
        return vo;
    }


    public JSONArray MatchId_Call(String id) throws IOException, ParseException {

        String Address = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + id + "/ids?start=0&count=15&api_key=" + api_key;
        String protocol = "GET";
        URL url = new URL(Address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(br);
//        System.out.println(jsonArray);
//        for(int i=0;i< jsonArray.size();i++){
//            System.out.println(jsonArray.get(i));
//        }
        return jsonArray;
    }

    public Map<String,double[]> MatchData(JSONArray array) throws IOException, ParseException {

        Map<String,int[][]> champions =  ChampionData();        //시작전에 챔피언관련 map을 받아온다

        // i반복은 판수반복, j반복은 플레이어반복(반드시 10번실행됨)

        for(int i=0;i< array.size();i++){
            //System.out.println(array.get(i));
            Object match_num = array.get(i);

            //가저온 매치id를 바탕으로 경기 내용 분석
            String Address = "https://asia.api.riotgames.com/lol/match/v5/matches/" + match_num +"?api_key=" + api_key;
            URL url = new URL(Address);
            String protocol = "GET";
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(protocol);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(br);

            Gson gson = new Gson();
            MatchDto vo = gson.fromJson(jsonObject.toString(), MatchDto.class);


            for(int j=0; j<10; j++){
                String name = vo.getInfo().getParticipants()[j].getChampionName();

                int[][] temp_nums= champions.get(name);
                //System.out.println(temp_nums + " " + temp_nums[0][0] + " " + temp_nums[0][1]);

                //int[][] a = champions.get(name).clone();

            //    int a = champions.get(name);
                boolean gamewins = vo.getInfo().getParticipants()[j].isWin();
                if(gamewins==true){ //이겼으면 판수 + 승리사실 저장
                    temp_nums[0][0] +=1;
                    temp_nums[0][1] +=1;
                }else{      //젔으면 판수만 저장
                    temp_nums[0][0] +=1;
                }

                //champions.put(name,temp_nums);  //결과저장
                //champions.replace(name,temp_nums);

            }

        }

        return Statistics(champions);   //30판에대한 데이터통계 전송


    }


    public Map<String, double[]> Statistics(Map Data){       //데이터 통계 처리

        // 실제 사용된 챔피언들만 뽑아서 key=챔피언 value=나온횟수,승률 방식의 map 데이터로 정리
        Iterator<String> keys = Data.keySet().iterator();
        Map<String,double[]> champions_real = new HashMap<>();

        while (keys.hasNext()) {
            String key = keys.next();
            int[][] temp = new int[][]{{0,0}};      // [0][0]판수 / [0][1]승리수
            temp = (int[][]) Data.get(key);



            if(temp[0][0]!=0){
                double num = Math.floor( ( (((double)temp[0][1]/(double)temp[0][0]) *100) *10) /10 );
                double[] num2 = new double[]{temp[0][0],num};
                champions_real.put(key,num2);
            }
        }


        Iterator<String> keys2 = champions_real.keySet().iterator();

        return champions_real;
//        while (keys2.hasNext()) {
//            String key = keys2.next();
//            System.out.println("챔피언 : " + key + " 만난횟수 : " + (int)champions_real.get(key)[0] + " 승률 : " + champions_real.get(key)[1]);
//
//        }



//        // 맵 데이터를 나온횟수 순으로 정렬하여 출력
//        for(int i=0;i<champions_real.size();i++){
//            for(int j=0; j<champions_real.size();j++){
//
//            }
//        }


    }




    public Map ChampionData() throws IOException, ParseException {  //챔피언 이름에대한 map을 만들어준다
        String Address = "https://ddragon.leagueoflegends.com/cdn/12.2.1/data/en_US/champion.json";
        String protocol = "GET";
        URL url = new URL(Address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"MS949"));

//        JSONParser jsonParse = new JSONParser();
//        JSONObject jsonObj = (JSONObject) jsonParse.parse(br);
//

        JSONParser jsonParser = new JSONParser();

        //JSON데이터를 넣어 JSON Object 로 만들어 준다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);

        JSONObject bookObject = (JSONObject) jsonObject.get("data");
        Iterator<String> keys = bookObject.keySet().iterator();
        Map<String,int[][]> champions = new HashMap<>();

        while (keys.hasNext()) {
            String key = keys.next();
            int[][] temp = new int[][]{{0,0}};      // [0][0]판수 / [0][1]승리수
            champions.put(key,temp);
        }


        return champions;

    }






}
