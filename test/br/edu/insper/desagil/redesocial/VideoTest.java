package br.edu.insper.desagil.redesocial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoTest {
	private Video a;
	private Usuario usuario1;
	private Produto produto1;
	
	@BeforeEach
	public void setUp() {
		produto1 = new Produto("Mesa", 599.99);
		usuario1 = new Usuario("Pedro");
		a = usuario1.postaVideo(5, produto1);
	}

	@Test
	public void testaFalhas() {
		a.adicionaAvaliacao(usuario1, 3);
		a.adicionaAvaliacao(new Usuario("Joao"), 6);
		a.adicionaAvaliacao(new Usuario("Maria"), 0);
		
		assertEquals(0, usuario1.totalAvaliacoes());
	}
	
	@Test
	public void umVidUmaAval() {
//		a.adicionaAvaliacao(new Usuario("Pedro"), 4);
//		
//		assertEquals(4, usuario1.totalAvaliacoes());
		assertEquals(1, a.adicionaAvaliacao(new Usuario("Pedro"), 4));
	}

}
