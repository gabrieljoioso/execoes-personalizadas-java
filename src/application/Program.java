/* Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o em
dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa n�o deve aceitar dados
inv�lidos para a reserva, conforme as seguintes regras:
- Altera��es de reserva s� podem ocorrer para datas futuras
- A data de sa�da deve ser maior que a data de entrada
*/

// SOLU��O 3 (BOA)

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // Reaproveitando no update
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next()); // Reaproveitando no update
			
			reservation.updateDates(checkIn, checkOut); // lan�ar uma exce��o caso ocorra erro.
			System.out.println("Reservation: " + reservation);					
		}
		catch (ParseException e) { //Tratando a exce��o
			System.out.println("Invalid date format.");
		}
		catch (DomainException e) { //Tratando a exce��o
			System.out.println("Error in resevation: " + e.getMessage());
		}
		catch (RuntimeException e) { // Generico: Para qualquer outra exce��o n�o esperada, gere essa exce��o.
			System.out.println("Unexpected error!");
		}
		
		sc.close();
	}

}
