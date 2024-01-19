package com.example.demo.model;

public class BookingHistory {
	
	private int id;
	private String title;
	private int bookedTickets;
	private int availableTickets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookedTickets() {
		return bookedTickets;
	}
	public void setBookedTickets(int bookedTickets) {
		this.bookedTickets = bookedTickets;
	}
	public int getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
