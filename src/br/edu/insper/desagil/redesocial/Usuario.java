package br.edu.insper.desagil.redesocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private List<Video> videos; 
	
	public Usuario(String nome) {
		this.nome = nome;
		this.videos = new ArrayList<>(); 
	}
	
	public Video postaVideo(int id, Produto produto) {
		Video a = new Video(id, this, produto);
		this.videos.add(a);
		return a;
	}
	
	public int totalAvaliacoes() {
		int soma = 0;
		for (Video x: videos) {
			soma += x.mediaAvaliacoes();
		}
		return soma;
	}
	
	public String getNome() {
		return nome;
	}
}
