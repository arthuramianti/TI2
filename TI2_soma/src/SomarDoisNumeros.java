import java.util.*;

class SomarDoisNumeros {
	public static Scanner sc = new Scanner(System.in);
	
	private int firstNumber;
	private int secondNumber;
	
	public void construct()
	{
		this.firstNumber = 0;
		this.secondNumber = 0;
	}
	
	private void setFirstNumber(int parameter)
	{
		this.firstNumber = parameter;
	}
	
	private void setSecondNumber(int parameter)
	{
		this.secondNumber = parameter;
	}
	
	public int getFirstNumber()
	{
		return this.firstNumber;
	}
	
	public int getSecondNumber()
	{
		return this.secondNumber;
	}
	
	public int somaDoisNumeros()
	{
		int soma = this.firstNumber + this.secondNumber;
		
		return soma;
	}
	
	public static void main(String args[])
	{
		SomarDoisNumeros SomarDoisNumeros = new SomarDoisNumeros();
		
		System.out.println("Digite o primeiro número da soma: ");
		SomarDoisNumeros.setFirstNumber(sc.nextInt());
		System.out.println("Digite o segundo número da soma: ");
		SomarDoisNumeros.setSecondNumber(sc.nextInt());
		
		System.out.println("O resultado da soma dos dois números digitados é: " + SomarDoisNumeros.somaDoisNumeros());
		main(args);
	}
	
}
