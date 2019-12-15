package it.robertoamato.videoteca;

import java.awt.Choice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ViewportLayout;

public class Application {
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		Videoteca videoteca = new Videoteca();
		
		
		System.out.print(menu());
		while(true) {
			System.out.print(getUserChoice());
			char userInput = stdin.nextLine().charAt(0);
			
			switch(userInput) {
				case '0':{
						try {
							videoteca.uploadFilmByFile( new File("resource/file.txt"));
							System.out.println("\tfilm uploaded");
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
				case '1':{
							break;
						}
				case '2':{
							ArrayList<Film> films = videoteca.getFilmByFilter(film -> film.getGenere().equalsIgnoreCase("azione"));
							System.out.println("\n\tlist:");
							films.forEach( (film) -> System.out.println("\t"+film.getNome()) );
							break;
						} 
				case '3':{ 
							ArrayList<Film> films = videoteca.getFilmByFilter(film -> film.getGenere().equalsIgnoreCase("horror"));
							System.out.println("\n\tlist:");
							films.forEach( (film) -> System.out.println("\t"+film.getNome()) );
							break;
						} 
				case '4':{  break;} 
				case '5':{  break;} 
				case '6':{  break;} 
				case '7':{ 
							System.out.print("\tDigita nome film da cercare :\n\t>");
							String nomeFilm = stdin.nextLine();
							ArrayList<Film> films = videoteca.getFilmByFilter(film -> film.getNome().equalsIgnoreCase(nomeFilm));
							System.out.println("\n\tlist:");
							films.forEach( (film) -> System.out.println("\t"+film.getNome()) );
							break;
						}
				case '8':{  break;} 
				case '9':{  
							ArrayList<Film> films = videoteca.getFilms();
							System.out.println("\n\tlist:");
							films.forEach( (film) -> System.out.println("\t"+film.getNome()) );
							break;
						} 
				case 'E':{ System.out.println("Exit"); System.exit(0); }
				default:{ System.out.println("\tdigitata opzione sbagliata");}
			}
			System.out.println("\t----------------------------------------------------------------\n");
		}
				
	
	
	}
	
	private static String menu() {
		String menu = "\t*********VIDEOTECA*********\n" + 
				  "\n\t 0) carica film da file" +
				  "\n\t 1) carica film manualmente" +				
				  "\n\t 2) cerca film azione" +
				  "\n\t 3) cerca film horror" +
				  "\n\t 4) ................." +
				  "\n\t 5) ................." +
				  "\n\t 6) ................." +
				  "\n\t 7) cerca film per nome" +
				  "\n\t 8) ................." +
				  "\n\t 9) cerca tutti i film" +
				  "\n\t E) Esci" +
				  "\n\n";
	
		return menu;
	}
	
	private static String getUserChoice() {
		String choiceAsk = "\tscegli una opzione dal menu:\n\t>";
		
		return choiceAsk;
	}
}
