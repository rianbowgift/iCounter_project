package rianbowgift.maven.maven1st_project.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import rianbowgift.maven.maven1st_project.domain.User;
import rianbowgift.maven.maven1st_project.dto.summoner.SummonerDTO;
import rianbowgift.maven.maven1st_project.repository.SummonerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@Transactional
public class SummonerService {


    private final SummonerRepository summonerRepository;

    @Autowired
    public SummonerService(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    public String join(User user){
        summonerRepository.save(user);
        return user.getId();

    }



    public JSONObject Summoner(String name) throws IOException, ParseException {
        //미리 입력된 api와 사용자에게 입력받은 id를 조합하여 RESTAPI로 사용자의 정보를 가저온다.
        //이떄, json형식으로 받아오기때문에 dto파일에 저장한다

        String Address = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ name + "?api_key=" + api_key;
        String protocol = "GET";
        URL url = new URL(Address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br);
        System.out.println(jsonObject);

        return jsonObject;
    }

}
