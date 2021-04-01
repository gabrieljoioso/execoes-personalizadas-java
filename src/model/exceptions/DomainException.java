package model.exceptions;

public class DomainException extends RuntimeException { //Runtime: signifca que voc� n�o � obrigado a tratar a exce��o, sem ele, sim.
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { 
		super(msg); // Repassa a mensagem para o construtor da superclasse. --> permitir instanciar exce��o personalizada passando uma mensagem. 
	}
	
}
