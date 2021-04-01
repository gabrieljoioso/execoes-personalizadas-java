package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
	
	public long duration() { //long para implementar a diferen�a entre datas.
		long diff = checkOut.getTime() - checkIn.getTime(); // diferen�a das duas datas em milisegundos.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converter o diff(milisegundos) para dias.
	}

	public String updateDates(Date checkIn, Date checkOut) { //atualiza��o nas datas
		Date now = new Date(); // SOLU��O RUIM
		if (checkIn.before(now) || checkOut.before(now)) { // Se check-in for anterior a agora ou check-out for anterior a agora
				return "Reservation dates for update must be future dates.";
		}
		if (!checkOut.after(checkIn)) { // Se check-out n�o � depois do check-in
			return "Check-out date must be after check-in date.";
		}
		
		this.checkIn = checkIn; // recebe o novo argumento e substitui
		this.checkOut = checkOut; // recebe o novo argumento e substitui
		return null; // Se retorna null, n�o deu erro.
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
