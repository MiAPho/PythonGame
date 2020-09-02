import java.util.*;
public class ch{
		static int MAZE_W;
		static int MAZE_H;
		static int[][] maze;
		static int DUNGEON_W=MAZE_W*3;
		static int DUNGEON_H=MAZE_H*3;
		static int dungeon[][];
	public static void main(String[] args){
		MAZE_W=11;
		MAZE_H=9;
		maze=new int[MAZE_H][MAZE_W];
		/*for(int i=0;i<MAZE_H;i++){
			for(int j=0;j<MAZE_W;j++){
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}*/
		DUNGEON_W=MAZE_W*3;
		DUNGEON_H=MAZE_H*3;
		dungeon=new int[DUNGEON_H][DUNGEON_W];
		make_dungeon();
		for(int y=0;y<MAZE_H;y++){
			for(int x=0;x<MAZE_W;x++){
				if(maze[y][x]==0){
					System.out.print("□ ");
				}
				if(maze[y][x]==1){
					System.out.print("■ ");
				}
			}
			System.out.println();
		}
		for(int y=0;y<DUNGEON_H;y++){
			for(int x=0;x<DUNGEON_W;x++){
				if(dungeon[y][x]==0){
					System.out.print("□ ");
				}
				if(dungeon[y][x]==9){
					System.out.print("■ ");
				}
			}
			System.out.println();
		}
	}
	static void make_dungeon(){
		int[] XP={0,1,0,-1};
		int[] YP={-1,0,1,0};
		//System.out.println(Arrays.toString(XP));
		for(int i=0;i<MAZE_W;i++){
			maze[0][i]=1;
			maze[MAZE_H-1][i]=1;
		}
		for(int i=1;i<MAZE_H-1;i++){
			maze[i][0]=1;
			maze[i][MAZE_W-1]=1;
		}
		for(int i=1;i<MAZE_H-1;i++){
			for(int j=1;j<MAZE_W-1;j++){
				maze[i][j]=0;
			}
		}
		for(int y=2;y<MAZE_H-2;y+=2){
			for(int x=2;x<MAZE_W-2;x+=2){
				maze[y][x]=1;
			}
		}
		for(int y=2;y<MAZE_H-2;y+=2){
			for(int x=2;x<MAZE_W-2;x+=2){
				int d=new Random().nextInt(4);
				if(x>2){
					d=new Random().nextInt(3);
				maze[y+YP[d]][x+XP[d]]=1;
				}
			}
		}
		for(int y=0;y<DUNGEON_H;y++){
			for(int x=0;x<DUNGEON_W;x++){
				dungeon[y][x]=9;
			}
		}
		for(int y=1;y<MAZE_H-1;y++){
			for(int x=1;x<MAZE_W-1;x++){
				int dx=x*3+1;
				int dy=y*3+1;
				if(maze[y][x]==0){
					if(new Random().nextInt(100)<20){
						for(int ry=-1;ry<2;ry++){
							for(int rx=-1;rx<2;rx++){
								dungeon[dy+ry][dx+rx]=0;
							}
						}
					}else{
						dungeon[dy][dx]=0;
						if(maze[y-1][x]==0){
							dungeon[dy-1][dx]=0;
						}
						if(maze[y+1][x]==0){
							dungeon[dy+1][dx]=0;
						}
						if(maze[y][x-1]==0){
							dungeon[dy][dx-1]=0;
						}
						if(maze[y][x+1]==0){
							dungeon[dy][dx+1]=0;
						}
					}
				}
			}
		}
	}
}
