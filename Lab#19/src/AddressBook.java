import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddressBook extends Application{
	
	protected lab19 pane = new lab19();
	
	final int NAME = 32;
	final int STREET = 32;
	final int CITY = 20;
	final int STATE = 2;
	final int ZIP = 5;
	
	protected int count = 0;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@Override
	public void start(Stage primaryStage) {
		pane.btNew.setOnAction(e -> newRecord());
		pane.btAdd.setOnAction(e -> add());
		pane.btUpdate.setOnAction(e -> update());
		
		pane.btFirst.setOnAction(e -> first());
		pane.btNext.setOnAction(e -> next());
		pane.btPrevious.setOnAction(e -> previous());
		pane.btLast.setOnAction(e -> last());
		
		//CREATE SCENE
		Scene scene = new Scene(pane, 360, 180);
		primaryStage.setTitle("Address Book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void first() {
		try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");){
			
			if(inout.length() > 0) {
				inout.seek(0);				
				read(inout);
				System.out.println("Reading Address 1");
				count=1;
			} else {
				System.out.println("Address Book is empty!");
			}
			inout.seek(count * 91 - 91); 
			write(inout);
		}
		catch(IOException ex) {}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void next() {
		try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");){
			
			if(count * 91 < inout.length()) {
				inout.seek(count * 91);				
				read(inout);
				count++;;
				System.out.println("Reading Address # " + count);
				
			} else {
				System.out.println("Address Book is empty!");
			}
		}
		catch(IOException ex) {}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void previous() {
		try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");){
			
			if(count > 1) {
				count--;			
			} else {
				count =1;
			}
			inout.seek((count * 91) -91);
			read(inout);
			count++;;
			System.out.println("Reading Address #" + count);
		}
		catch(IOException ex) {}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void last() {
		try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");){
			
			count = ((int)inout.length())/91;
			inout.seek(count*91 - 91);				
				read(inout);
				System.out.println("Reading Last Record");
		}
		catch(IOException ex) {}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void read(RandomAccessFile inout) throws IOException{
		byte[] name = new byte[NAME];
		inout.read(name);
		pane.tfName.setText(new String(name));
		
		byte[] street = new byte[STREET];
		inout.read(street);
		pane.tfStreet.setText(new String(street));
		
		byte[] city = new byte[CITY];
		inout.read(city);
		pane.tfCity.setText(new String(city));
		
		byte[] state = new byte[STATE];
		inout.read(name);
		pane.tfState.setText(new String(state));
		
		byte[] zip = new byte[ZIP];
		inout.read(zip);
		pane.tfZip.setText(new String(zip));
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	private void newRecord() {
		pane.tfName.setText(new String(""));
		pane.tfStreet.setText(new String(""));
		pane.tfCity.setText(new String(""));
		pane.tfState.setText(new String(""));
		pane.tfZip.setText(new String(""));
		
		System.out.println("Clearing Form");
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void add() {
        try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");) {
            inout.seek(inout.length());
            write(inout);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
        catch (IndexOutOfBoundsException ex) {}
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void update() {
		try(RandomAccessFile inout = new RandomAccessFile("AddressBook.dat", "rw");){
			inout.seek(count * 91 - 91); 
			write(inout);
		}
		catch(FileNotFoundException ex) {}
		catch(IOException ex) {}
		catch(IndexOutOfBoundsException ex) {}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void write(RandomAccessFile inout) throws IOException {
		inout.write(fixedLength(pane.tfName.getText().getBytes(), NAME));
		inout.write(fixedLength(pane.tfStreet.getText().getBytes(), STREET));
		inout.write(fixedLength(pane.tfCity.getText().getBytes(), CITY));
		inout.write(fixedLength(pane.tfState.getText().getBytes(), STATE));
		inout.write(fixedLength(pane.tfZip.getText().getBytes(), ZIP));
		
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		
		for(int i=0; i<x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
