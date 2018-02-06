import java.util.Scanner;

class TestTree{

private Node left,right;
private static Node befor,be;
char last='s';
	private static Node head;
	private static int num,max,count;
	private int key=1;

	private static int level;
	
	
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
	 	if (os.isEmpty())
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