package rianbowgift.maven.maven1st_project.repository;

import rianbowgift.maven.maven1st_project.domain.User;

import java.util.HashMap;
import java.util.Map;

public class RealSummonerRepository implements SummonerRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setNums(++sequence);
        return user;
    }
}
