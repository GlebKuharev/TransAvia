package com.epam.bean;

/**
 * Created by PC on 03.03.2017.
 */
public class BusinessObject {
    private String airportDep;
    private String airporyArriv;
    private String bookingNo;
    private String lastName;
    private String flightDate;

    public BusinessObject(){
    }

    public String getAirportDep() {
        return airportDep;
    }

    public void setAirportDep(String airportDep) {
        this.airportDep = airportDep;
    }

    public String getAirporyArriv() {
        return airporyArriv;
    }

    public void setAirporyArriv(String airporyArriv) {
        this.airporyArriv = airporyArriv;
    }

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
}
