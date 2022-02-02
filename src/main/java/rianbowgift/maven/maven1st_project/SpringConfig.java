package rianbowgift.maven.maven1st_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rianbowgift.maven.maven1st_project.repository.SummonerRepository;
import rianbowgift.maven.maven1st_project.service.SummonerService;

@Configuration
public class SpringConfig {

    private final SummonerRepository summonerRepository;

    @Autowired
    public SpringConfig(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    @Bean
    public SummonerService summonerService(){
    return new SummonerService(summonerRepository);
    }
}
