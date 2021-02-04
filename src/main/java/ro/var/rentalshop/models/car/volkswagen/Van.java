package ro.var.rentalshop.models.car.volkswagen;

import ro.var.rentalshop.models.car.FuelType;
import ro.var.rentalshop.models.car.RentCategory;

public class Van extends Volkswagen {
    private String model;

    public Van(int id, String color, long vin, int rentPricePerDay, int depositRequired, int seatNumber, FuelType fuelType, RentCategory rentCategory) {
        super(id, color, vin, rentPricePerDay, depositRequired, seatNumber, fuelType, rentCategory);
        this.model = "Van";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
