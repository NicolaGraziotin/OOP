
public class Train {
    
    int nTotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build(int nTotSeats, int nFirstClassSeats, int nSecondClassSeats) {
        this.nTotSeats = nTotSeats;
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }

    void reserveFirstClassSeats(int reserve) {
        this.nFirstClassReservedSeats = reserve;
    }

    void reserveSecondClassSeats(int reserve) {
        this.nSecondClassReservedSeats = reserve;
    }

    double getTotOccupancyRatio() {
        return this.nFirstClassReservedSeats + this.nSecondClassReservedSeats * 100 / this.nTotSeats;
    }

    double getFirstClassOccupancyRatio() {
        return this.nFirstClassReservedSeats * 100 / this.nFirstClassSeats;
    }

    double getSecondClassOccupancyRatio() {
        return this.nSecondClassReservedSeats * 100 / this.nSecondClassSeats;
    }

    void deleteAllReservations() {
        this.build(nTotSeats, nFirstClassSeats, nSecondClassSeats);
    }

}
