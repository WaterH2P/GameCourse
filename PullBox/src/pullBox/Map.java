package pullBox;

public class Map {
	int manX=0;
	int manY=0;
	byte map[][];
	int grade=0;
	//�˹��췽�����ڳ�������
	//��������ֻ��Ҫ�˵�λ�ú͵�ͼ�ĵ�ǰ״̬
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
	//�˹��췽�����ڱ������
	//�ָ���ͼʱ��Ҫ�˵�λ�á���ͼ�ĵ�ǰ״̬�͹ؿ������ؿ��л�ʱ�Դ�Ϊ������
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
