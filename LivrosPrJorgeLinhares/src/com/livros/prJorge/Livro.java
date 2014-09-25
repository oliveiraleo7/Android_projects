package com.livros.prJorge;

public class Livro {
	
	private String nome;
	private int imagem;
	private String descricao;
	private Float valor;
	
	public Livro() {
	}
	
	public Livro(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getImagem() {
		return imagem;
	}
	public void setImagem(int imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Livro getLivro(){
		return this;
	}
	

}
