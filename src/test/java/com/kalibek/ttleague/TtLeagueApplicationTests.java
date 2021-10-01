package com.kalibek.ttleague;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import org.junit.jupiter.api.Test;

class TtLeagueApplicationTests {

  @Data
  class Match<T> {

    private final int round;
    private final T p1;
    private final T p2;

  }

  record Player(
      int id
  ) {

  }

  <T> List<Match<T>> calculateMatches(List<T> players, T dummy) {
    if (players.isEmpty()) {
      return Collections.emptyList();
    }

    List<Match<T>> matches = new ArrayList<>();

    List<T> adjusted = new ArrayList<>(players);

    if (players.size() % 2 == 1) {
      adjusted.add(dummy);
    }

    int n = adjusted.size();
    List<List<T>> partition = Lists.partition(adjusted, n / 2);
    List<T> top = new ArrayList<>(partition.get(0));
    List<T> bottom = new ArrayList<>(Lists.reverse(partition.get(1)));

    for (int r = 0; r < n; r++) {
      for (int i = 0; i < top.size(); i++) {
        if (!top.get(i).equals(dummy) && !bottom.get(i).equals(dummy)) {
          matches.add(new Match<>(r + 1, top.get(i), bottom.get(i)));
        }
      }
      top.add(1, bottom.get(0));
      bottom.remove(0);
      bottom.add(top.get(top.size() - 1));
      top.remove(top.size() - 1);

    }

    return matches;

  }


  @Test
  void test() {

    var players = List.of(
        new Player(1),
        new Player(2),
        new Player(3),
        new Player(4),
        new Player(5),
        new Player(6),
        new Player(7)
    );

    List<Match<Player>> matches = calculateMatches(players, new Player(-1));

    matches.forEach(System.out::println);
  }
}
