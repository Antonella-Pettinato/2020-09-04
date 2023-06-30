package it.polito.tdp.imdb.model;

public class GradoMassimo {
Movie movie;
int sommaMax;
public GradoMassimo(Movie movie, int sommaMax) {
	super();
	this.movie = movie;
	this.sommaMax = sommaMax;
}
@Override
public String toString() {
	return "\nGradoMassimo [movie=" + movie + ", sommaMax=" + sommaMax + "]";
}


}
