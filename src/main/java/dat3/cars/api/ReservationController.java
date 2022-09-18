package dat3.cars.api;

import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController
{
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService)
    {
        this.reservationService = reservationService;
    }

    @GetMapping
    List<ReservationResponse> getReservations(){
        return reservationService.findReservations();
    }

    @GetMapping("/{id}")
    ReservationResponse getReservationById(@PathVariable int id) throws Exception{
        return reservationService.findReservationById(id);
    }

    @PostMapping("/{userName}/{carId}/{rentalDate}")
    void reserveCar(@PathVariable String userName, @PathVariable int carId, @PathVariable String rentalDate){
        LocalDate parsedDate = LocalDate.parse(rentalDate);
        reservationService.reserveCar(userName, carId,parsedDate);
    }
}
