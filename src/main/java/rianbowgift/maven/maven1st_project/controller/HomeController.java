package rianbowgift.maven.maven1st_project.controller;



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
    public String create(User id) throws IOException, ParseException {
        User user = new User();
        System.out.println("입력받은값 = " + id.getName());
//        String searchId = summonerService.join(user);
        user = summonerService.Summoner(id.getName());
        System.out.println("돌아옴");
        System.out.println(user.getName());
        System.out.println(user.getPuuid());
        return "redirect:/";
    }



}