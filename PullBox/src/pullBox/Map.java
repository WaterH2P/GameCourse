package pullBox;

public class Map {
	int manX=0;
	int manY=0;
	byte map[][];
	int grade=0;
	//此构造方法用于撤消操作
	//撤消操作只需要人的位置和地图的当前状态
	public Map(int manX,int manY,byte map[][]){
		this.manX=manX;
		this.manY=manY;
		byte temp[][]=new byte[map.length][map[0].length];
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[0].length;j++){
				temp[i][j]=map[i][j];
			}
		}
		this.map=temp;
	}
	//此构造方法用于保存操作
	//恢复地图时需要人的位置、地图的当前状态和关卡数（关卡切换时以此为基数）
	public Map(int manX,int manY,byte map[][],int grade){
		this(manX,manY,map);
		this.grade=grade;
	}
	
	public int getManX(){
		return manX;
	}
	
	public int getManY(){
		return manY;
	}
	
	public byte[][] getMap(){
		return map;
	}
	
	public int getGrade(){
		return grade;
	}
}
