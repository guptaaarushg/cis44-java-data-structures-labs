public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (char[] row : maze) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public boolean solve() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') return solve(i, j);
            }
        }
        return false;
    }

    private boolean solve(int r, int c) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length) return false;
        if (maze[r][c] == '#' || maze[r][c] == '.') return false;
        if (maze[r][c] == 'F') return true;

        if (maze[r][c] != 'S') maze[r][c] = '.';

        if (solve(r - 1, c) || solve(r, c + 1) || solve(r + 1, c) || solve(r, c - 1))
            return true;

        if (maze[r][c] != 'S') maze[r][c] = ' ';
        return false;
    }

    public static void main(String[] args) {
        char[][] maze1 = {
                {'#','#','#','#','#','#','#'},
                {'#','S',' ','#',' ',' ','#'},
                {'#',' ',' ','#',' ','#','#'},
                {'#',' ','#',' ',' ',' ','#'},
                {'#',' ',' ',' ','#','F','#'},
                {'#','#','#','#','#','#','#'}
        };

        char[][] maze2 = {
                {'#','#','#','#','#','#','#'},
                {'#','S',' ','#',' ',' ','#'},
                {'#','#','#','#',' ','#','#'},
                {'#',' ','#',' ',' ',' ','#'},
                {'#',' ',' ',' ','#','F','#'},
                {'#','#','#','#','#','#','#'}
        };

        MazeSolver s1 = new MazeSolver(maze1);
        System.out.println("Original Maze 1:");
        s1.printMaze();
        System.out.println(s1.solve() ? "Solution Found:" : "No Solution Found:");
        s1.printMaze();

        MazeSolver s2 = new MazeSolver(maze2);
        System.out.println("Original Maze 2:");
        s2.printMaze();
        System.out.println(s2.solve() ? "Solution Found:" : "No Solution Found:");
        s2.printMaze();
    }
}
