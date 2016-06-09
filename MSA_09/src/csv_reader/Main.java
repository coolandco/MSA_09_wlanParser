package csv_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {
	
//	public final static File quellpfad = new File("C:\\Users\\Allgemein\\Desktop\\Dropbox\\"
//			+ "LeoStudium\\Semester4\\Mob Sys Anw\\Seminar_Aufgaben\\9_Seminar_MSA\\Data\\Gio_csvUmbenannt");
//	
//	public final static File zieldatei = new File("C:\\Users\\Allgemein\\Desktop\\Dropbox\\"
//			+ "LeoStudium\\Semester4\\Mob Sys Anw\\Seminar_Aufgaben\\9_Seminar_MSA\\Data\\Gio_ErgebnisseTmp.csv");
	
	public final static File quellpfad = new File("C:\\Users\\Allgemein\\Desktop\\Dropbox\\"
			+ "LeoStudium\\Semester4\\Mob Sys Anw\\Seminar_Aufgaben\\9_Seminar_MSA\\Data\\Dan_csvUmbenannt");
	
	public final static File zieldatei = new File("C:\\Users\\Allgemein\\Desktop\\Dropbox\\"
			+ "LeoStudium\\Semester4\\Mob Sys Anw\\Seminar_Aufgaben\\9_Seminar_MSA\\Data\\Dan_ErgebnisseTmp.csv");
	
	static ArrayList<String> MACs = new ArrayList<String>();
	static int werte[][]; //dieses array muss noch mit 23 * 4 nach y und
					 //anzahl MACs nach x Initialisiert werden
	static List<List<String[]>> ad = new ArrayList<List<String[]>>();//Hier kommen alle daten rein

	
	
	public static void main(String[] args) throws IOException {
		//zuerst fülle ich alle Metadaten in verschachtelte listen
		fülleAlleDaten(quellpfad);
		
		//zuerst Finde ich die Anzahl der Unterschiedlichen Macs raus 
		//und schreibe sie in das MACs Array
		fülleMacArray();
		
		
		//Jetzt wird die Werte Matrix initialisiert:
		werte = new int[MACs.size()][23*4];
		
		
		//nun müssen die werte in die Tabelle geschrieben werden
		fülleWerteArray();
		
		

		//nun schreibt man die wertetabelle wieder in eine CSV datei
		schreibeWerteInDatei(zieldatei);
		
	}
	

	private static void schreibeWerteInDatei(File zieldatei) throws IOException {
	     CSVWriter writer = new CSVWriter(new FileWriter(zieldatei), ';');//öffnet datei
	     
	     writer.writeNext(MACs.toArray(new String[1]));//die mac adressen
	     
	     
	     for(int i = 0; i<23*4 ; i++){//siehe werte[][]	 
	    	 String zeile[] = new String[MACs.size()];
	    	 
	    	 for(int j = 0; j<MACs.size();j++){
	    		 zeile[j] = String.valueOf(werte[j][i]);
	    	 }
	    	 
	    	 writer.writeNext(zeile);
	     }
	     
		 writer.close();
		
	}

	private static void fülleWerteArray() {
		for(int i = 0; i<MACs.size() ; i++){//für jede mac werden alle dateien überprüft
			String mac = MACs.get(i);
			
			for(int j = 0; j<ad.size() ; j++){//für jede datei
				List<String[]> datei = ad.get(j);
				
				
				werte[i][j] = getSignalstärkeVonMac(datei,mac);
			}
			
		}
		
	}

	private static int getSignalstärkeVonMac(List<String[]> datei, String mac) {
		for(String[] zeile : datei){//für jede Zeile von der Datei
			if(zeile[1].compareTo(mac) == 0){//mac vorhanden?
				return getintOutOfString( zeile[5]);
			}
		}
		return 0;//mac nicht vorhanden
	}

	private static int getintOutOfString(String string) {
		
		char c_string[] = string.toCharArray();
		
		//ArrayList<Character> int_string = new ArrayList<Character>();
		StringBuilder sBuilder = new StringBuilder();
		
		for(char c : c_string){
			if(c == 45 || (c >= 48 && c <=57)){//filtert "-" oder alle zahlen
				sBuilder.append(c);
			}
		}
		
		String s = sBuilder.toString();//in den string um in int zu parsen
		
		
		return Integer.parseInt(s);//gibt signalstärke in int zurück
	}

	private static void fülleMacArray() {
		MACs.add(ad.get(0).get(0)[1]);//für den start muss mindestens ein eintrag in den MACs sein
		
		for(List<String[]> datei : ad){//für jede datei
			
			for(String[] zeile :datei){//für jede Zeile
				
				boolean hinzufügen = true;
				for(String mac : MACs){
					if(zeile[1]//wenn die Mac in der Zeile
							.compareTo(mac) == 0){//gleich ist miteinem der macs aus der liste
						hinzufügen =false;
						break;
					}
						
				}
				
				if(hinzufügen)
					MACs.add(zeile[1]);
				
				
			}
		}
		
	}

	private static void fülleAlleDaten(File quellpfad) throws IOException {
		
		File[] files = quellpfad.listFiles();
		
		for(int i = 0; i<files.length; i++){//für jede Datei in diesem verzeichniss
			CSVReader reader = new CSVReader(new FileReader(files[i]));
		    ad.add(reader.readAll());
		}
		
		
		
	}

}
