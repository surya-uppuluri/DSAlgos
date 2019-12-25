## MATRIX


> Still to do


1. Spiral traversal
2. Determinant of matrix
3. Make matrix Boolean

 |S.No| Problem | Difficulty | Solved | NeedRevision?  | Comments  |
 |---|---|---|---|---|---|
  |1| [AddMatrices](AddMatrices.java) |  Easy |Yes | No
  |2|Spiral traversal|  Hard | No | Yes
  |3|Determinant of matrix| Hard|No|Yes
  |4|Make matrix Boolean| Medium|No|Yes| First approach failed, tried with 2 while loops. AIOBs noticed. Needs revisit.|
  |5|Rotate ACW Without Extra Space| Medium| Yes| No | Solved in one go. Transpose and swap rows. Intuitive with an example|
  |6|SearchInLinearTime|Medium|Yes|Yes| Start from right first corner. Not very striking or intuitive. Initial confusion exists whether to traverse row first through right on bottom columns. But. if we start with right most top element, such confusion doesn't exist. Once that's clear, it's easy to solve. If curr < expected, move down. Else move left. Simple. Once any end is reached, report false.