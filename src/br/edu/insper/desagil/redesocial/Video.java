package br.edu.insper.desagil.redesocial;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<String, Integer>();
		
	}
	
	public void adicionaAvaliacao(Usuario usuario1, int nota) {
		if (this.usuario.getNome() == usuario1.getNome()) {
			return;
		}
		
		if (nota < 1 || nota > 5) {
			return;
		}		
		this.avaliacoes.put(usuario1.getNome(), nota);
	}
	
	public int mediaAvaliacoes() {
		double total = 0;
		for (int v: avaliacoes.values()) {
			total += v;
		}
		total /= avaliacoes.size();
		return (int) Math.round(total);
	}
	
	public int getId() {
		return this.id;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
}
