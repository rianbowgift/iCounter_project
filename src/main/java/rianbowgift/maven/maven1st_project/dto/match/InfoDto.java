package rianbowgift.maven.maven1st_project.dto.match;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfoDto {

    private long gameCreation;
    private long gameDuration;
    private long gameEndTimestamp;
    private long gameId;
    private String gameMode;
    private String gameName;
    private long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private ParticipantDto[] participants;
    private String platformId;
    private int queueId;
    private TeamDto[] teams;
    private String tournamentCode;

}



