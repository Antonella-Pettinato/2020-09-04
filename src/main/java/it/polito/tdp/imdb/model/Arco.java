package it.polito.tdp.imdb.model;

public class Arco {
Movie m1;
Movie m2;
int numAttori;
public Arco(Movie m1, Movie m2, int numAttori) {
	super();
	this.m1 = m1;
	this.m2 = m2;
	this.numAttori = numAttori;
}
public Movie getM1() {
	return m1;
}
public void setM1(Movie m1) {
	this.m1 = m1;
}
public Movie getM2() {
	return m2;
}
public void setM2(Movie m2) {
	this.m2 = m2;
}
public int getNumAttori() {
	return numAttori;
}
public void setNumAttori(int numAttori) {
	this.numAttori = numAttori;
}

}
