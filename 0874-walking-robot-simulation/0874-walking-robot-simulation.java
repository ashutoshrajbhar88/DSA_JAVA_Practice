class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Store obstacles in HashSet
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            String s = obstacles[i][0] + "," + obstacles[i][1];
            set.add(s);
        }

        // Directions: North, East, South, West
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0; // start facing North
        int x = 0;
        int y = 0;
        int maxDist = 0;

        for (int i = 0; i < commands.length; i++) {
            
            // Turn right
            if (commands[i] == -1) {
                dir = (dir + 1) % 4;
            } 
            // Turn left
            else if (commands[i] == -2) {
                dir = (dir + 3) % 4;
            } 
            // Move forward
            else {
                int steps = commands[i];
                
                for (int j = 0; j < steps; j++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];
                    
                    String nextPos = nextX + "," + nextY;
                    
                    // Stop if obstacle
                    if (set.contains(nextPos)) {
                        break;
                    }
                    
                    x = nextX;
                    y = nextY;
                    
                    int dist = x * x + y * y;
                    maxDist = Math.max(maxDist, dist);
                }
            }
        }

        return maxDist;
    }
}