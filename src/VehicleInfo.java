public class VehicleInfo {
    private int VIN;
    private double odometer;
    private double consumption;
    private double odometerReading;
    private double engineSize;

    public VehicleInfo() {
        this.VIN = VIN;
        this.odometer = odometer;
        this.consumption = consumption;
        this.odometerReading = odometerReading;
        this.engineSize = engineSize;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
