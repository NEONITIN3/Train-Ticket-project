package com.abhi.TrainReservation.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

public class Ticket {

	private int counter;
	private String pnr;
	private Date travelDate;
	private Train train;

	private double totalFare;

	private TreeMap<Passenger, Integer> passangers;

	public Ticket(Date travelDate, Train train) {

		this.passangers = new TreeMap<Passenger, Integer>();

		this.train = train;
		this.travelDate = travelDate;
		this.counter = 100;

		this.pnr = generatePNR();

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public double getTotalFare() {
		this.totalFare = calculateTotalTicketPrice();
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public TreeMap<Passenger, Integer> getPassangers() {
		return passangers;
	}

	public void setPassangers(TreeMap<Passenger, Integer> passangers) {
		this.passangers = passangers;
	}

	private String generatePNR() {
		char ch1 = train.getSource().charAt(0);
		char ch2 = train.getDestination().charAt(0);

		int date = travelDate.getDate();
		int month = travelDate.getMonth();
		int year = travelDate.getYear();

		String dateStr = year + "" + month + "" + date;

		String pnr = ch1 + "" + ch2 + "_" + dateStr + "_" + counter;

		counter++;

		return pnr;
	}

	private double calcPassengerFare(Passenger passenger) {

		double exactFare = train.getTicketPrice();

		double effectivePrice = exactFare;

		int age = passenger.getAge();
		char gender = passenger.getGender();

		if (age < 12) {
			effectivePrice = exactFare - ((exactFare * 50) / 100);
		} else if (age > 60) {
			effectivePrice = exactFare - ((exactFare * 60) / 100);
		} else if (gender == 'F') {
			effectivePrice = exactFare - ((exactFare * 25) / 100);
		}

		passangers.put(passenger, (int) effectivePrice);

		return effectivePrice;
	}

	public void addPassenger(String name, int age, char gender) {

		Passenger passenger = new Passenger(name, age, gender);
		passangers.put(passenger, counter);

	}

	private double calculateTotalTicketPrice() {

		double totolFare = 0;

		Set<Passenger> allPassangers = passangers.keySet();

		for (Passenger passenger : allPassangers) {
			totolFare = totolFare + calcPassengerFare(passenger);
		}

		return totolFare;
	}

	private StringBuilder generateTicket() {
		throw new RuntimeException("This method is not useful in Web Application");
	}

	public void writeTicket() {
		throw new RuntimeException("This method is not useful in Web Application");
	}

}