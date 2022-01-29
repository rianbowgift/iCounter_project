package rianbowgift.maven.maven1st_project.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("data","홈 화면");
        String SummonerName = "reimei"; //입력받아다 친다
        String api_key = "RGAPI-2cc0374f-4c93-47e5-9896-3bcb53653a3d"; //서버에 저장되있다 친다

        return "homemain";
    }

}
