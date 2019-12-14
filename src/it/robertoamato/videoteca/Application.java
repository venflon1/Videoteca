package it.robertoamato.videoteca;

import java.awt.Choice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.ViewportLayout;

public class Application {
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		Videoteca videoteca = new Videoteca();
		
		
		while(true) {
			System.out.print(menu());
			System.out.print(getUserChoice());
			char userInput = stdin.next().charAt(0);
			
			switch(userInput) {
				case '1':{
						try {
							videoteca.uploadFilmByFile( new File("file.txt"));
						} 
						catch (FileNotFoundException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					} 
				case '2':{
							videoteca.getFilmByFilter(film -> film.getGenere().equalsIgnoreCase("azione"));
							break;
						} 
				case '3':{ 
							videoteca.getFilmByFilter(film -> film.getGenere().equalsIgnoreCase("horror"));
							break;
						} 
				case '4':{  break;} 
				case '5':{  break;} 
				case '6':{  break;} 
				case '7':{ 
							System.out.println("Digita nome film da cercare :\n\t>");
							String nomeFilm = stdin.nextLine();
							videoteca.getFilmByFilter(film -> film.getNome().equalsIgnoreCase(nomeFilm));
							break;
						}
				case 'E':{ System.out.println("Exit"); System.exit(0); }
				default:{ System.out.println("\tdigitata opzione sbagliata");}
			}
		}
				
	
	
	}
	
	private static String menu() {
		String menu = "\t***VIDEOTECA***" + 
				  "\n\t 1) carica film" +
				  "\n\t 2) cerca film azione" +
				  "\n\t 3) cerca film horror" +
				  "\n\t 4) ................." +
				  "\n\t 5) ................." +
				  "\n\t 6) cerca film per nome" +
				  "\n\t 7) ..................." +
				  "\n\t 8) ................." +
				  "\n\t 9) ................." +
				  "\n\t E) Esci" +
				  "\n\n";
	
		return menu;
	}
	
	private static String getUserChoice() {
		String choiceAsk = "\tscegli una opzione dal menu:\n\t>";
		
		return choiceAsk;
	}
}
