import java.util.Scanner;
class Tree
{private Node left,right;
private static Node befor,be;
char last='s';
	private static Node head;
	private static int num,max,count;
	private int key=1;

	private static int level;

		public Tree(){
		 head = null;
		num=0;
		 level=0;
		 max=0;
		 count=0;
		 
	}	

////////////////////////////////////////////////////////////////////////////////////////////////////////
/*int newEntry that parameter that recive value of the the new entery item 
 *
 *Node tmp use as temporary pointer that travel through the tree  
 */
	public void add(int newEntry,Node temp) {
			Node newNode = new Node(newEntry);
		key++;
			if(		(temp.getData()>newEntry) 	&& 	(temp.getleft()==null) )
			{	temp.setleft(newNode);
			System.out.println("left secand :"+newEntry);
				newNode.setlevel(key);
				}
			else if(	(temp.getData()<newEntry) && 	(temp.getright()==null ))
			{		temp.setright(newNode);
				System.out.println("right secand :"+newEntry);
				newNode.setlevel(key);
			}
			else if(	temp.getData()==newEntry)
							System.out.println("newEntry is exist");
else{

			Node curent =temp;
			if (curent.getData()<newEntry)
			curent=curent.getright();
			else if (curent.getData()>newEntry)
			curent=curent.getleft(); 
			
			add(newEntry,curent);
}	 

}




////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*int newEntry that parameter that recive value of the the new entery item 
 *
 *int num the value that have the number of item in the tree that through the increace 
 *them num++ when every item is insert
 */  
	public void add(int newEntry) {
		Node newNode = new Node(newEntry);
key=1;		//key is variable that count the number of the levels for the new entry
if (isEmpty())
{head=newNode;
			System.out.println("is a root :"+newEntry);
			newNode.setlevel(key);
}		//new entry will inserted in the root

	else if((head.getData()>newEntry) && (head.getleft()==null) )
			{head.setleft(newNode);
			System.out.println("left  :"+newEntry);
		newNode.setlevel(key+1);	}		//new entry will added to the left
	
	else if((head.getData()<newEntry) && (head.getright()==null) )
			{head.setright(newNode);
			System.out.println("right  :"+newEntry);
			newNode.setlevel(key+1);	}		//new entry will added to the right
	else if(head.getData()==newEntry)
			System.out.println("newEntry is exist");		//do nothing (ignor duplicat)
	else{						// if there are root's left and root's right 
			key++;
			Node current =head;
			if (newEntry>current.getData())
			current=current.getright();
			else if (current.getData()>newEntry)
			current=current.getleft(); 
				add(newEntry,current);			//call add with two paramiters(newEntry,current)
			}	
	num++;		
	}//end add
	
	

	public int size(){
		return num;
	}		
		
	public static boolean isEmpty(){
		return (head==null);
	}
///////////////////////////////////////////////////

/*int newEntry that parameter that recive value of the item we want make search for them
 *
 *Node tmp use as temporary pointer that travel through the tree  
 */  
	public  void binarySearch(int target,Node tmp){
level++;
	if(head==null)
			System.out.println(target+" is not found (empty)");
	else{
		if (tmp.getData()==target)
		{			System.out.println(target+" is found\n number of level :"+level);
		}//////target

		else if (tmp.getData()>target)		
		{if (tmp.getleft()!=null)
			binarySearch(target,tmp.getleft());
				else 
				{System.out.println(target+" is not found");
			}
				}//////left
		else if (tmp.getData()<target)
		{if (tmp.getright()!=null)
			binarySearch(target,tmp.getright());
			else 
			{System.out.println(target+" is not found");
							}
				}//////right

		}
} 


//////////////////////////////////////////////////	
	public  void SearchMax(int target,Node tmp){
level++;
	if(head==null)
			System.out.println(target+" is not found (empty)");
	else{
		if (tmp.getData()==target)	;
								

		else if (tmp.getData()>target)		
		{if (tmp.getleft()!=null)
		SearchMax(target,tmp.getleft());
		}
		else if (tmp.getData()<target)
		{if (tmp.getright()!=null)
		SearchMax(target,tmp.getright());
		}
	//////there are no else becuse it's must that data are vailable
	}
if(max<level)
max=level;	
	}


	public int MaxLevel(Node display){
	level=0;
	if (isEmpty())
	System.out.println("is empty");

else {	
			SearchMax(display.getData(),head);
		if(display.getleft()!=null)
				MaxLevel(display.getleft());
				if (display.getright()!=null)
					MaxLevel(display.getright());			
}
	return max;
}
/////////////////////////////////////////////////////////

/*boolean  key1 use when we searching for the removed item if its find being remov that
 * through open the door or the condation of the remove funcation 
 *if not found then send massage that item not found and still false whit any change
 * 
 *int reitem that parameter that recive value of the the remove item 
 *
 *Node tmp use as temporary pointer that travel through the tree  
 *
 *Node befor that represent the parent for the removed item  
 *
 *char last that tell us what the last link (left or right) from the parent to the child 
 */ 

public void  Remove(int reitem,Node tmp){

boolean  key1=false;

/*frist will search for the removed item if its find being remov
 *if not found then send massage that item not found
 */
 		if (tmp.getData()==reitem)
		{
			key1= true;
				}
		else if (tmp.getData()>reitem)		
		{if (tmp.getleft()!=null)
		{ befor=tmp;
			last='l';
			Remove(reitem,tmp.getleft());
			}
			else 
				System.out.println(reitem+" is not found");
				}
		else if (tmp.getData()<reitem)
		{if (tmp.getright()!=null)
		{befor=tmp;
		last='r';
		Remove(reitem,tmp.getright());
		
		}else 
				System.out.println(reitem+" is not found");
				}			
if (key1==true)
	{
		System.out.println("befor :"+befor.getData() +"    last : "+last);
		if (tmp.getright()==null && tmp.getleft()==null )
		{if(last =='r' )
			befor.setright(null);
				else if(last=='l')
					befor.setleft(null);
						System.out.println("if it's left && right ==  null ");
	}
//^^^^ if the remove item have not child


else if (tmp.getleft()==null)
		{if(last =='r' )
			befor.setright(tmp.getright());
			else if(last=='l')
				befor.setleft(tmp.getright());
				System.out.println("the left is  null ");
		}
//^^^^ if the remove item have not left child (left child==null)
	
	
	else if (tmp.getleft()!=null)
	{ //tow way for if the remove item have  left child (left child!=null)
		Node current=tmp;
		current=current.getleft();
			if (current.getright()!=null)
				{	System.out.println("if it's left is not null >>> && current.getright()!=null");
						Node befor2=current;
						while (current.getright()!=null)
							{	befor2=current;
								current=current.getright();
									}
					tmp.setData(current.getData());
					if (current.getleft()==null)
					befor2.setright(null);
						else
							befor2.setright(current.getleft());
				}
				//^^^if it's left is not null	>>> && current.getright()!=null
			
			
			else // that mean (current.getright()==null)
			{	tmp.setData(current.getData());		
				System.out.println("if it's left is not null >>> && current.getright()==null");
								tmp.setleft(current.getleft());
		
			}// ^^^ if it's left is not null>>> && current.getright()==null
			
	
	}

}
}




//////////////////////////////////////////////
// Node display use as temporary pointer that travel through the tree  	
public void  displayPre(Node display){	
if (isEmpty())
	System.out.println("is empty");

else {

			System.out.println( display.getData()+"     level#"+display.getlevel());
		if(display.getleft()!=null)
			displayPre(display.getleft());
				if (display.getright()!=null)
						displayPre(display.getright());
	
}}


///////////////////////////////////////////
public void  displayLevel(Node display){	
if (isEmpty())
	System.out.println("is empty");

else {

	if(display.getlevel()==level)
			System.out.println( display.getData()+"     level#"+display.getlevel());
	
		if(display.getleft()!=null)
			displayLevel(display.getleft());
				if (display.getright()!=null)
						displayLevel(display.getright());
	
}}

public void  displayLevel(){
int f=MaxLevel(head);
level=0;
	while(level<=f){
	
		displayLevel(head);
		level++;	}	
}




///////////////////////////////////////////
// Node display use as temporary pointer that travel through the tree  
public void  displayPost(Node display){	
if (isEmpty())
	System.out.println("is empty");
	else {
		if (display.getleft()!=null )
			displayPost(display.getleft());
			if (display.getright()!=null)
				displayPost(display.getright());
		
					System.out.println( display.getData()+"  ");
	}
}



////////////////////////////////////////
// Node display use as temporary pointer that travel through the tree  
public void  displayIN(Node display){
if (isEmpty())
	System.out.println("is empty");
	else {
		if (display.getleft()!=null )
			displayIN(display.getleft());
	
					System.out.println( display.getData()+"  ");	
			
		if (display.getright()!=null)
			displayIN(display.getright());
}
	}










































































public static void main (String[] args) {

Tree os=new Tree();
Scanner scan=new Scanner(System.in);
int u,end=1,s; String a;
////////------while-while-while-while-while-while-
while(end==1)
{level=0;
befor=head;
max=0;
	System.out.println("-------------------------------------------------------------------------------------");
System.out.println("press one of them: \n1-ADD\n2-search\n3-Size\n4-Remove  ");
 System.out.println("5-display\n6-max-level\n7-Exit");
 s=scan.nextInt();
 	System.out.println("-------------------------------------------------------------------------------------");
if (s==1)
{System.out.println("ADD :\ninsert the number :");
 u=scan.nextInt();
	System.out.println( "---------------");
	os.add(u);
}
else if (s==2)
{System.out.println("search :\ninsert the number :");
		 u=scan.nextInt();
		System.out.println( "---------------");
		os.binarySearch(u,head);
}
else if (s==3)
 System.out.println("size of this Tree :"+os.size()); 		

else if (s==4){
	System.out.println("Remove :");
	os.displayPre(head);
		System.out.println();
	System.out.println("insert the number :");
		 u=scan.nextInt();
		 	System.out.println( "---------------");
		os.Remove(u,head);
os.displayPre(head);
	System.out.println();
}
else if (s==5){
	System.out.println("1-display pre-order\n2-display post-order\n3-display IN-order\n4-display Level-order");
  s=scan.nextInt();
  	System.out.println( "---------------");
 switch (s){


	case 1:
		os.displayPre(head);	
		System.out.println();
	break;
//	pre-order	

	case 2:
		os.displayPost(head);	
		System.out.println();
	 	 break;	 	 
//	display post-order

	case 3:
os.displayIN(head);
		System.out.println();
	 	 break;	 	 
//	display IN-order	 	

	 case 4:
	 	if (isEmpty())
		System.out.println("is empty");	
		else{
		os.displayLevel();	
		System.out.println();
	 	}
	 	 break;	 	 
//	display Levelt-order   
    
         default:
            System.out.println ("plase enter one of the given Number.");

 
 }}
else if (s==6)
System.out.println("bigger value of level : "+os.MaxLevel(head));	

else if (s==7)
end =3;
 else 
 	 System.out.println("plase enter one of the given Number."); 			
}	
 	}
    

}
