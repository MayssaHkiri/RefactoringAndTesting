package moving.features;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChampionsLeague {
  private final List<Team> teams;

  public String nextStageTable() {
    return teams.stream()
        .map(team -> team.getName() + " - " + team.getLeague().getCountry())
        .collect(Collectors.joining("%n"));
  }
}