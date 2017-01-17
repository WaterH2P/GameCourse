package pullBox;

public class MapFactory {
	static byte map[][][]={
			{
				{0,0,1,1,1,0,0,0},
				{0,0,1,4,1,0,0,0},
				{0,0,1,9,1,1,1,1},
				{1,1,1,2,9,2,4,1},
				{1,4,9,2,5,1,1,1},
				{1,1,1,1,2,1,0,0},
				{0,0,0,1,4,1,0,0},
				{0,0,0,1,1,1,0,0},
			},
			{
				{1,1,1,1,1,0,0,0,0},
				{1,9,9,5,1,0,0,0,0},
				{1,9,2,2,1,0,1,1,1},
				{1,9,2,9,1,0,1,4,1},
				{1,1,1,9,1,1,1,4,1},
				{0,1,1,9,9,9,9,4,1},
				{0,1,9,9,9,1,9,9,1},
				{0,1,9,9,9,1,1,1,1},
				{0,1,1,1,1,1,0,0,0},
			} 
	};
	static int count=map.length;
	public static byte[][] getMap(int grade){
		byte temp[][];
		if(grade>=0&&grade<count)
			temp=map[grade];
		else
			temp=map[0];
		byte result[][]=new byte[temp.length][temp[0].length];
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				result[i][j]=temp[i][j];
			}
		}
		return result;
	}
	public static int getCount(){
		return count;
	}
}
