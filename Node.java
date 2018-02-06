class Node {
	private int data,level;
	private Node linkleft,linkright;	
	public Node(int newData){
		data = newData;
		linkleft = null;
		linkright = null;
		level=0;
	}	
		
	public int getData(){	
		return data;	
	}	
	public Node getleft() {	
		return linkleft;	
	}
	public Node getright() {	
		return linkright;	
	}
	public  int getlevel(){
		return level;
	}
	
///////////
	public void setlevel(int key){
		level=key;
	}
	
	public void setData(int newData){	
		data = newData;	
}	
	public void setleft(Node newLink)	{	
		linkleft = newLink;	
	}
	public void setright(Node newLink)	{	
		linkright = newLink;	
	}

}	
