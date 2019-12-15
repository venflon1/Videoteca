package it.robertoamato.videoteca;

public class Film {
	private String nome;
	private String genere;
	private int anno;
	
	public Film() {
		super();
	}

	public Film(String nome, String genere, int anno) {
		this();
		this.nome = nome;
		this.genere = genere;
		this.anno = anno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (this.anno != other.anno)
			return false;
		if (genere == null) {
			if (other.genere != null)
				return false;
		} 
		else if (!this.genere.equals(other.genere))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		}
		else if (!this.nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [nome=" + nome + ", genere=" + genere + ", anno=" + anno + "]";
	}
}
