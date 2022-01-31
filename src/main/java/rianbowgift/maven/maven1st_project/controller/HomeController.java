package rianbowgift.maven.maven1st_project.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rianbowgift.maven.maven1st_project.dto.summoner.SummonerDTO;


@Controller
public class HomeController {


    @GetMapping("/")        //홈화면. 아이디를 입력받는다
    public String home(){
        String SummonerName = "reimei"; //입력받아다 친다
        String api_key = "RGAPI-2cc0374f-4c93-47e5-9896-3bcb53653a3d"; //서버에 저장되있다 친다
        //
        return "search";
    }

    @PostMapping(value = "/search")
    public String create(SummonerDTO summonerDTO) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/board?id=" + member.getName();
    }


}
