// Time Complexity : O(1) constant time
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays of sets for row, column, and box validation
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Iterate over each cell in the 9x9 board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty cells
                if (val == '.') continue;
                
                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                
                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);
                
                // Check the 3x3 sub-box
                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex].contains(val)) {
                    return false;
                }
                boxes[boxIndex].add(val);
            }
        }
        
        // If all checks are passed, the board is valid
        return true;
    }
}
