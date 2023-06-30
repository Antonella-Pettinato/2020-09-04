package it.polito.tdp.imdb.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	private ImdbDAO dao;
	private SimpleWeightedGraph<Movie, DefaultWeightedEdge> grafo;
	private Map<Integer, Movie> idMap;

	public Model() {
		dao = new ImdbDAO();

		idMap = new HashMap<>();
		List<Movie> movies = dao.listAllMovies();
		for (Movie m : movies) {
			idMap.put(m.id, m);
		}
	}

	public void creaGrafo(double rank) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		List<Movie> vertici = dao.listAllVertici(idMap);
		Graphs.addAllVertices(grafo, vertici);
		// archi
		List<Arco> archi = dao.listAllArchi(idMap, rank);
		for (Arco a : archi) {
			Graphs.addEdgeWithVertices(grafo, a.m1, a.m2, a.numAttori);
		}

	}

	public String descrizioneGrafo() {
		return "#VERTICI:  " + this.grafo.vertexSet().size() + "\n#ARCHI:  " + this.grafo.edgeSet().size();
	}

	public GradoMassimo GradoMassimo() {
		int sommaMax = 0;
		GradoMassimo gM = null;
		for (Movie m : grafo.vertexSet()) {
			int grado = grafo.degreeOf(m);
			if (grado > 0) {
				int somma = 0;
				for (DefaultWeightedEdge e : grafo.incomingEdgesOf(m)) {
					somma += grafo.getEdgeWeight(e);
				}
				if (somma > sommaMax) {
					gM = new GradoMassimo(m, somma);
					sommaMax = somma;
				}
			}
		}
		return gM;
	}

	public ImdbDAO getDao() {
		return dao;
	}

	
	
}
