package ro.var.rentalshop.models.car;

import java.util.Objects;

public class Car {

    private int id;
    private String color;
    private long vin;
    private int rentPricePerDay;
    private int depositRequired;
    private int seatNumber;
    private FuelType fuelType;
    private RentCategory rentCategory;

    public Car(int id, String color, long vin, int rentPricePerDay, int depositRequired, int seatNumber, FuelType fuelType, RentCategory rentCategory) {
        this.id = id;
        this.color = color;
        this.vin = vin;
        this.rentPricePerDay = rentPricePerDay;
        this.depositRequired = depositRequired;
        this.seatNumber = seatNumber;
        this.fuelType = fuelType;
        this.rentCategory = rentCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    public int getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setRentPricePerDay(int rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public int getDepositRequired() {
        return depositRequired;
    }

    public void setDepositRequired(int depositRequired) {
        this.depositRequired = depositRequired;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public RentCategory getRentCategory() {
        return rentCategory;
    }

    public void setRentCategory(RentCategory rentCategory) {
        this.rentCategory = rentCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && vin == car.vin && rentPricePerDay == car.rentPricePerDay && depositRequired == car.depositRequired && seatNumber == car.seatNumber && Objects.equals(color, car.color) && fuelType == car.fuelType && rentCategory == car.rentCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, vin, rentPricePerDay, depositRequired, seatNumber, fuelType, rentCategory);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", rentPricePerDay=" + rentPricePerDay +
                ", depositRequired=" + depositRequired +
                ", seatNumber=" + seatNumber +
                ", fuelType=" + fuelType +
                ", rentCategory=" + rentCategory +
                '}';
    }
}
