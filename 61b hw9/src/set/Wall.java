package set;
/* Wall.java */

import java.util.*;

import set.*;

public class Wall {
	
	public final static int HORIZONTAL = -1;
	public final static int VERTICAL = 1;
	public int wallType;
	public int[] coordinate;
        public int x;
        public int y;


    public Wall(int xcoord, int ycoord, int wallType) {
        int[] coordinate = {xcoord, ycoord};
        this.x = xcoord;
        this.y = ycoord;
	this.wallType = wallType;

	}
}

//DisjointSets maze = new DisjointSets(horiz * vert);
//int a = 0;
//Wall[] allWalls = new Wall[(horiz - 1)* vert + (vert - 1)* horiz];
////Adding the Horizontal Walls
//for (i = 0; i < horiz; i++){
//    for (j = 0; j < vert - 1; j++){
//        allWalls[a] = new Wall(i, j, Wall.HORIZONTAL);
//        a++;
//    }
//}
////Adding the Vertical Walls
//for (j = 0; j < vert; j++){
//    for (i = 0; i < horiz - 1 ; i++){
//        allWalls[a] = new Wall(i, j, Wall.VERTICAL);
//        a++;
//    }
//}
////Sorting the Walls in the Wall Array
//for (int w = allWalls.length; w > 1; w--){
//	int r = randInt(w-1);
//    Wall randomWall = allWalls[r];
//    allWalls[r] = allWalls[w - 1];
//    allWalls[w - 1] = randomWall;
//}
//
//for (int index = 0; index < allWalls.length; index++){
//    if (allWalls[index].wallType == Wall.VERTICAL){
//        int[] right = {allWalls[index].x+ 1, allWalls[index].y};
//        int[] left = {allWalls[index].x, allWalls[index].y};
//        int r = convertCoord(right, horiz);
//        int l = convertCoord(left, horiz);
//        int set1 = maze.find(r);
//        int set2 = maze.find(l);
//        if (set1 != set2){
//            maze.union(set1, set2);
//            vWalls[left[0]][left[1]] = false;
//        }
//    }
//    else{
//        int[] up = {allWalls[index].x, allWalls[index].y};
//        int[] down = {allWalls[index].x, allWalls[index].y + 1};
//        int u = convertCoord(up, horiz);
//        int d = convertCoord(down, horiz);
//        int set1 = maze.find(u);
//        int set2 = maze.find(d);
//        if (set1 != set2){
//            maze.union(set1, set2);
//            hWalls[up[0]][up[1]] = false;
//        }
//    }
//}
//
//public int convertCoord(int[] coord, int width){
//    int mapped = (width * coord[1]) + coord[0];
//    return mapped;
//}