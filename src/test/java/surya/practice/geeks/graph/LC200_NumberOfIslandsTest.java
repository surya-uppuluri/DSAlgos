package surya.practice.geeks.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC200_NumberOfIslandsTest {

  LC200_NumberOfIslands numberOfIslands = new LC200_NumberOfIslands();

  @Test
  void numIslands1() {

    int islands = numberOfIslands
        .numIslandsDFS(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});

    assertEquals(1, islands);
  }

  @Test
  void numIslandsBFS() {

    int islands = numberOfIslands
        .numIslandsBFS(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});

    assertEquals(1, islands);
  }
}