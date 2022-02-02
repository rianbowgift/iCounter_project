package rianbowgift.maven.maven1st_project.domain;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//db가 알아서 생성
    private Long nums;
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private int summonerLevel;

}
