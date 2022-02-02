package rianbowgift.maven.maven1st_project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rianbowgift.maven.maven1st_project.domain.User;
import rianbowgift.maven.maven1st_project.dto.summoner.SummonerDTO;
import rianbowgift.maven.maven1st_project.service.SummonerService;


@Controller
public class HomeController {

    private SummonerService summonerService;

    @Autowired
    public HomeController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }




    @GetMapping("/")        //홈화면. 아이디를 입력받는다
    public String home(){
        String SummonerName = "reimei"; //입력받아다 친다
        String api_key = "RGAPI-78611ba4-8d04-4f18-8c4e-35d2860132de"; //서버에 저장되있다 친다
        //
        return "search";
    }

    @PostMapping(value = "/search")
    public String create(String id) {
        User user = new User();

        String searchId = SummonerService.join(user);
        return "redirect:/" + searchId;
    }


}
}