package alpacamida;

public interface GridInfo {
    // Return true if alpacamida.SharedCar succesfully claimed the location
    public boolean claim(SharedCar car, Coord loc);

    // Return true if alpacamida.SharedCar  successfully loaded rider
    public boolean riderLoaded(SharedCar car);
}
