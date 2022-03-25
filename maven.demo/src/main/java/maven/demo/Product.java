package maven.demo;

public class Product {
	private int id_prod;
	private String nome_prod;
	private String cor_prod;
	private char tamanho_prod;
	
	public Product()
	{
		this.id_prod = 0;
		this.nome_prod = "";
		this.cor_prod = "";
		this.tamanho_prod = 'M';
	}
	
	public Product(int id, String nome, String cor, char tam)
	{
		this.id_prod = id;
		this.nome_prod = nome;
		this.cor_prod = cor;
		this.tamanho_prod = tam;
	}
	
	public int getProdId()
	{
		return this.id_prod;
	}
	
	public String getProdName()
	{
		return this.nome_prod;
	}
	
	public String getProdColor()
	{
		return this.cor_prod;
	}
	
	public char getProdLength()
	{
		return this.tamanho_prod;
	}
	
	private void setProdId(int id)
	{
		this.id_prod = id;
	}
	
	private void setProdName(String nome)
	{
		this.nome_prod = nome;
	}
	
	private void setProdColor(String cor)
	{
		this.cor_prod = cor;
	}
	
	private void setProdLength(char tamanho)
	{
		this.tamanho_prod = tamanho;
	}
	
	public void productToString()
	{
		System.out.println("[ ");
		System.out.println("Id do produto -> " + this.id_prod);
		System.out.println("Nome do produto -> " + this.nome_prod);
		System.out.println("Cor do produto -> " + this.cor_prod);
		System.out.println("Tamanho do produto -> " + this.tamanho_prod);
		System.out.println("] ");
		System.out.println("\n");
		
		return;
	}
	
}
