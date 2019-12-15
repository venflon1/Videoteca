package it.robertoamato.videoteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Videoteca {
	private ArrayList<Film> films;
	
	public Videoteca() {
		super();
	}
	
	public ArrayList<Film> getFilms(){
		return this.films;
	}
	
	public void uploadFilm(Film film) {
		if(this.films == null)
			this.films = new ArrayList<>();
		if(!this.films.contains(film))
			this.films.add(film);
	}
	
	public void uploadFilm(Film... films) {
		for(Film f : films) {
			uploadFilm(f);
		}
	}
	
	public void uploadFilmByFile(File file) throws IOException, FileNotFoundException{
		if(!file.exists())
			return ;
		if(this.films == null)
			this.films = new ArrayList<Film>();
		
		BufferedReader inFile = new BufferedReader(new FileReader(file));
		String films = "";
		String line = "";
		
		while( (line  = inFile.readLine()) != null) {
			films+= line;
		}		
		final String delimiter = ";;";
		String[] film = films.split(delimiter);
		
		for(int i=0; i<film.length; i++) {
			String[] attributesFilm = film[i].split(" ");
			String nome = attributesFilm[0];
			String genere = attributesFilm[1];
			int anno = Integer.parseInt(attributesFilm[2]);
			Film f = new Film(nome, genere, anno);
			uploadFilm(f);
		}
	}

	
	public ArrayList<Film> getFilmByFilter(Predicate<Film> filmFilter){
		ArrayList<Film> ret = new ArrayList<Film>();
		for(Film film : this.films) {
			if(filmFilter.test(film))
				ret.add(film);
		}
		
		return ret;
	}
}
