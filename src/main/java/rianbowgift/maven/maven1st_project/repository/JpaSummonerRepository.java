package rianbowgift.maven.maven1st_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rianbowgift.maven.maven1st_project.domain.User;

public interface JpaSummonerRepository extends JpaRepository<User,Long>,SummonerRepository {

}
