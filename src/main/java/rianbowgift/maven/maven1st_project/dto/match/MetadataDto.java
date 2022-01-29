package rianbowgift.maven.maven1st_project.dto.match;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MetadataDto {

    private String dataVersion;
    private String matchId;
    private String[] participants;

}
