class ParkingSystem {
    private int[] parkingLot = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.parkingLot[0] = big;
        this.parkingLot[1] = medium;
        this.parkingLot[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (parkingLot[carType-1]-- > 0) return true;
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */