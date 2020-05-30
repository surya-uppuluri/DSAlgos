package surya.practice.geeks.graph;

import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LC200_NumberOfIslands {

  public int numIslandsDFS(char[][] grid) {
    /**
     ALGORITHM 1 -DFS approach
     ---------
     Preconditions
     -------------
     1. If number of rows are zero, it indicates grid is empty. Return 0.
     2. Else extract the row size as grid size
     3. Extract the column size as the size of 0th grid.
     --------------------------------------
     1. Visit from beginning 0x0. Initiate 2 for loops one over the row, another over the column for this
     2. If the current island has a value == 1, call mark current island function that does the foll -
     i) While taking care of the boundary conditions, if the current cell is !=1, do nothing, just return
     ii) Mark the current cell as 2 (obviously the else case since it hasn't returned yet)
     iii)  Recursively call the same function for all the 4 possible neighbours
     **/
    int numIslands = 0;
    int rows = grid.length;

    if (rows == 0) {
      return 0;
    }

    int cols = grid[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          markCurrentIsland(grid, rows, cols, r, c);
          numIslands++;
        }
      }
    }
    return numIslands;


  }

  private void markCurrentIsland(char[][] grid, int row, int col, int rp, int cp) {

    if (rp >= row || cp >= col || rp < 0 || cp < 0 || grid[rp][cp] != '1') {
      return;
    } else {
      grid[rp][cp] = '2';
      markCurrentIsland(grid, row, col, rp - 1, cp);
      markCurrentIsland(grid, row, col, rp + 1, cp);
      markCurrentIsland(grid, row, col, rp, cp - 1);
      markCurrentIsland(grid, row, col, rp, cp + 1);
    }
  }


  public int numIslandsBFS(char[][] grid) {
    // every time there is a zero OR non existent add 1 -- let's also replace the 1s with 2s to track the places we have already visited

    int islands = 0;
    int rows = grid.length;
    if (rows == 0) {
      return 0;
    }
    int cols = grid[0].length;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          islands++;
          Queue<int[]> q = new LinkedList<>();
          log.info("adding {}x{} to the queue", r, c);
          q.offer(new int[]{r, c});
          while (q.size() != 0) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
              int[] curr = q.poll();
              assert curr != null;
              int row = curr[0];
              int col = curr[1];
              log.info("Polled items are at: {}x{}", row, col);
              log.info("Marking {}x{} as 2 and calling neighbours", row, col);
              grid[row][col] = '2';
              helper(q, row - 1, col, grid);
              helper(q, row + 1, col, grid);
              helper(q, row, col - 1, grid);
              helper(q, row, col + 1, grid);
            }
          }
        }
      }
    }

    return islands;
  }

  private void helper(Queue<int[]> q, int row, int col, char[][] grid) {
    if (row < 0 || row == grid.length || col < 0 || col == grid[row].length) {
      return;
    }

    if (grid[row][col] == '1') {
      grid[row][col] = '2';
      log.info("Marking as 2 and pushing {}x{} int queue", row, col);
      q.offer(new int[]{row, col});
    }

    // if we already visited -- and the value on grid is 2!
  }
}

