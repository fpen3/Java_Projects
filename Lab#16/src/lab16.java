/*Frank Pena
COMP-269-001RL
CLASS LAB #16*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class lab16 {

	public static void main(String[] args) throws IOException {
		try(FileOutputStream output = new FileOutputStream("temp.dat")){
			//Output values to the file
			for(int i=1; i<=10; i++) {
				output.write(i);
			}
			
		}
		
		//Read the values back
		try(FileInputStream input = new FileInputStream("temp.dat")){
			int[] values = new int[10];
			
			for(int i=0; i<10; i++) {
				values[i] = input.read();
			}
		
			for(int i= values.length-1; i>=0; i--) {
				System.out.print(values[i] + " ");
			
		}			
	}		
	}
}
