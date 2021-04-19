package br.edu.insper.desagil.redesocial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoTest {
	private Video a;
	private Usuario user;
	private Produto produto1;
	private Video b;
	
	@BeforeEach
	public void setUp() {
		produto1 = new Produto("Mesa", 599.99);
		user = new Usuario("Pedro");
		a = user.postaVideo(5, produto1);
		b = user.postaVideo(2, produto1);
	}

	@Test
	public void testaFalhas() {
		a.adicionaAvaliacao(user, 3);
		a.adicionaAvaliacao(new Usuario("Joao"), 6);
		a.adicionaAvaliacao(new Usuario("Maria"), 0);
		
		assertEquals(0, user.totalAvaliacoes());
	}
	
	@Test
	public void umVidUmaAval() {
		a.adicionaAvaliacao(new Usuario("Joao"), 4);
		
		assertEquals(4, user.totalAvaliacoes());
	}
	
	@Test
	public void umVidDuasAval() {
		a.adicionaAvaliacao(new Usuario("Joao"), 4);
		a.adicionaAvaliacao(new Usuario("Maria"), 5);
		
		assertEquals(5, user.totalAvaliacoes());
	}
	
	@Test
	public void umVidTresAval() {
		a.adicionaAvaliacao(new Usuario("Joao"), 4);
		a.adicionaAvaliacao(new Usuario("Maria"), 5);
		a.adicionaAvaliacao(new Usuario("Mariana"), 1);
		
		assertEquals(3, user.totalAvaliacoes());
	}
	
	@Test
	public void doisVidTresAval() {
		a.adicionaAvaliacao(new Usuario("Joao"), 4);
		a.adicionaAvaliacao(new Usuario("Maria"), 5);
		b.adicionaAvaliacao(new Usuario("Mariana"), 1);
		
		assertEquals(6, user.totalAvaliacoes());
	}

}
