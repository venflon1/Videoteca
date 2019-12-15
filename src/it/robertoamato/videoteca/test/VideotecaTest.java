package it.robertoamato.videoteca.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import it.robertoamato.videoteca.Film;
import it.robertoamato.videoteca.Videoteca;

public class VideotecaTest {
	
	@Test
	public void testExistFile() {
		File file = new File("resource/file.txt");
		assertNotNull(file);
	}
	
	@Test
	public void testUploadFilm() throws FileNotFoundException, IOException {
		Videoteca videoteca = new Videoteca();
		videoteca.uploadFilmByFile(new File("resource/file.txt"));
		ArrayList<Film> films = videoteca.getFilms();
		System.out.println(films);
		assertNotNull(films);
	}
}
