package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) { //Lança exceção no construtor, trate as exceções no começo do metodo --> programação defensiva.
		if (!checkOut.after(checkIn)) { // Se check-out não é depois do check-in
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() { //long para implementar a diferença entre datas.
		long diff = checkOut.getTime() - checkIn.getTime(); // diferença das duas datas em milisegundos.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converter o diff(milisegundos) para dias.
	}

	public void updateDates(Date checkIn, Date checkOut) { //atualização nas datas //lança uma exceção dependendo do que acontecer dentro.
		Date now = new Date(); // (SOLUÇÃO BOA)
		if (checkIn.before(now) || checkOut.before(now)) { // Se check-in for anterior a agora ou check-out for anterior a agora
			throw new DomainException("Reservation dates for update must be future dates."); //IllegalArgumentException --> Argumentos que passamos são invalidos.
		}
		if (!checkOut.after(checkIn)) { // Se check-out não é depois do check-in
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
		this.checkIn = checkIn; // recebe o novo argumento e substitui
		this.checkOut = checkOut; // recebe o novo argumento e substitui
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights.";
	}
}
