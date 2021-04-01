package model.exceptions;

public class DomainException extends RuntimeException { //Runtime: signifca que você não é obrigado a tratar a exceção, sem ele, sim.
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { 
		super(msg); // Repassa a mensagem para o construtor da superclasse. --> permitir instanciar exceção personalizada passando uma mensagem. 
	}
	
}
