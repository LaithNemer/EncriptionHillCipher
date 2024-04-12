 package Package1;
import java.util.*;
public class Driver {
	static String [] charcter=new String [26];
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
	
		int j=0;
		for(char i='A';i<='Z';i++,j++) {
			charcter[j]=i+"";
		}
	
		int k=0;
		
		

		System.out.println("please enter the key and must equal 9 character\n");
		String key=input.nextLine();
		key=key.toUpperCase();
		while(k==0) {
			if(key.length()!=9) {
				System.out.println("Error key does not equal 9 ...try again\n");
				key=key.trim();
				System.out.println("please enter the key and must equal 9 character\n");
				 key=input.nextLine();
				
			}else {
				int [][]array=MatrexOFKey(key);
				int determent=getDeterment(array);
				System.out.println("Determent is : " + determent);
				int CheckGcd=gcd(determent,26);
				int Kinverse=findInvers(determent);
				System.out.println("K's inverse "+Kinverse);
				if(CheckGcd==1) {
					System.out.println("KEY is accepted");
					break;
				}
				else {
					System.out.println("Key does not accepted...try again\n");
					System.out.println("Note:\nif u went to see accepted keys click 1\nif u are know already key click 2 ");
					int choice=input.nextInt();
					input.nextLine();
					if(choice==1) {
						AcceptedKeys();
						
					
					}else {
						key=key.trim();
						System.out.println("please enter your key \n");
						 key=input.nextLine();
					}
				}
				
			}
			
			
		}
		
		
		
		System.out.println("Encription : ");
		
	
		
			System.out.println("Please enter plan text");
			String planText=input.nextLine();
			planText=planText.toUpperCase();
			
			Encription enc=new Encription(charcter, key, planText);
		String cipher=	enc.cipherText();
	System.out.println("Encription is done\nthe Cipher text : " + cipher+"\n\n");
	

	
	System.out.println("Decription : ");	
	System.out.println("Hi Please enter Key to see the massage\n");
	key=input.nextLine();
	
		Decription dec=new Decription(key, cipher, charcter);
		
		
		System.out.println("the plan text is : " + dec.getPlanText());
	}
	
	public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
	public static int getDeterment(int[] [] array) {
		int sum=array[0][0]*(array[1][1]*array[2][2]-array[2][1]*array[1][2] )-array[0][1]*(array[1][0]*array[2][2]-array[2][0]*array[1][2]) +array[0][2]*(array[1][0]*array[2][1]-array[2][0]*array[1][1]);
		return sum;
	}	
	
	
	public static int [][]MatrexOFKey(String StringKey){
		
		
		
		int [][]key=new int[3][3];
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				key[i][j]=getIndex(StringKey.charAt(k)+"");
				k++;
			}
		}
		return key;
	}
	
	public static int getIndex(String indexForKey) {
		for(int i=0;i<charcter.length;i++) {
			if(charcter[i].equals(indexForKey)) {
				return i;
			}
		}
		return -1;
	}
	public static void AcceptedKeys() {
		System.out.println("1.RIPIXEWJG\n2.nemer lai\n");
	}
	
	
	
	public static int findInvers(int d ) {
		int i=1;
		
		if(d>0) {
			while(true) {
				int f=(i*d)%26;
				System.out.println(i+" * " + d);
				if(f==1) {
					return i;
				}
				
				i++;
				
				
				
			}
		}
		else {
			d=Math.abs(d);
			while(true) {
				
				int f=(i*d)%26;
				System.out.println(i+" * " + d+" = " + f);

				if(f==25) {
					return i;
				}
				
				i++;
				
				
				
			}
		}
	
		
	}
	


}
