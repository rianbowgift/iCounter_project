package rianbowgift.maven.maven1st_project.controller;



import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rianbowgift.maven.maven1st_project.domain.User;
import rianbowgift.maven.maven1st_project.dto.summoner.SummonerDTO;
import rianbowgift.maven.maven1st_project.service.SummonerService;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


@Controller
public class HomeController {

    private SummonerService summonerService;

    @Autowired
    public HomeController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }




    @GetMapping("/")        //홈화면. 아이디를 입력받는다
    public String home(){

        //
        return "search";
    }

    @PostMapping(value = "/search")
    public String create(User id,Model model) throws IOException, ParseException {
        User user = new User();
        user = summonerService.Summoner(id.getName());  //유저의 id로 유저 정보를 가저옴
        JSONArray arrays = summonerService.MatchId_Call(user.getPuuid());       //최근 30경기 데이터 json타입 array로 받아옴
        Map<String,double[]> keys = summonerService.MatchData(arrays);      //받아온 array를 넘겨주고 서비스 내부에서 분석하여 결과를 받아온다
        model.addAttribute("keys",keys);
        return "user";
    }



}