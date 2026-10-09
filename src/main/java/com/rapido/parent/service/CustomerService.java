package com.rapido.parent.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapido.parent.dto.BookingDetailsForAllRidersDto;
import com.rapido.parent.dto.Coordinatesdto;
import com.rapido.parent.dto.Customerdto;
import com.rapido.parent.dto.ResponseStructure;
import com.rapido.parent.dto.SearchDestLocResponseDto;
import com.rapido.parent.dto.SelectRidedto;
import com.rapido.parent.entity.Booking;
import com.rapido.parent.entity.Coordinates;
import com.rapido.parent.entity.Customer;
import com.rapido.parent.exception.CustomerNotFoundException;
import com.rapido.parent.repositry.BookingRep;
import com.rapido.parent.repositry.CoordinatesRep;
import com.rapido.parent.repositry.CustomerRep;

@Service
public class CustomerService {
	@Autowired
	private CustomerRep cr;
    @Autowired
    private CoordinatesRep cor;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisService redisservice;
    @Autowired
    private BookingRep br;
    
	public void CustomerDet(Customer c) {
	
		System.out.println("this sis service layer");
	
		cr.save(c);
		
	}

	public void getvehiclefare(SelectRidedto srt) {
		
		Coordinates c1 = new Coordinates();
        c1.setLatitude(srt.getSourceCoord().getLatitude());;
        c1.setLongitude(srt.getSourceCoord().getLongitude());
        cor.save(c1);
		Coordinates c2 = new Coordinates();
		c2.setLatitude(srt.getDestinationCoord().getLatitude());
		c2.setLongitude(srt.getDestinationCoord().getLongitude());
		cor.save(c2);
		
	}

	public  void Searchlocation() {
		String url = "https://us1.locationiq.com/v1/reverse?key=Your_API_Access_Token&lat=51.50344025&lon=-0.12770820958562096&format=json&";
		System.out.println(url);
		
	}

	public void createaccservice(Customerdto cd) {
		Customer c = new Customer();
		c.setName(cd.getName());
		c.setMobno(cd.getMobno());
		c.setEmail(cd.getEmail());
		c.setGender(cd.getGender());
		cr.save(c);
		int id = c.getId();
		String otp = String.format("%04d", id % 10000);
		c.setOtp(otp);
		cr.save(c);

		
	}

	public ResponseStructure<Customer> deleteaccservice(int id) {
		Customer customer = cr.findById(id).orElseThrow(() -> new CustomerNotFoundException());
		cr.delete(customer);
		ResponseStructure<Customer> response = new ResponseStructure<Customer>();
		response.setData(customer);
		response.setMessage("customer withbid is deleted");
		response.setStatuscode(HttpStatus.FOUND.value());
		return response;
	}

	

	public ResponseStructure<Customer> findbyidservice(int id) {
		Customer customer = cr.findById(id).orElseThrow(() -> new CustomerNotFoundException());
		ResponseStructure<Customer> response = new ResponseStructure<Customer>();
		response.setData(customer);
		response.setMessage("customer with id is found");
		response.setStatuscode(HttpStatus.FOUND.value());

		return response;
	}
	

	public List<SearchDestLocResponseDto> searchDropLocation(String searchkey) {

		String token = "pk.ed0ebe59f7a6d7e4937a2d6c6c0e697e";

		String url = "https://us1.locationiq.com/v1/search" + "?key=" + token + "&q=" + searchkey + "&format=json";

		SearchDestLocResponseDto[] response = restTemplate.getForObject(url, SearchDestLocResponseDto[].class);

		return Arrays.asList(response);
	}

	public BookingDetailsForAllRidersDto confirmRideService(int id, String vehicletype, Coordinatesdto cordinatesdto) {
		// 1. Check customer
				Customer customer = cr.findById(id).orElseThrow(() -> new CustomerNotFoundException());

				// 2. Get ride data from Redis
				Map<Object, Object> data = redisservice.getData(id);

				if (data == null || data.isEmpty()) {
					throw new RuntimeException("Ride details not found in Redis");
				}

				// 3. Get fare according to vehicle type
				String fareString;

				switch (vehicletype.toLowerCase()) {

				case "bike":
					fareString = data.get("bike").toString();
					break;

				case "auto":
					fareString = data.get("auto").toString();
					break;

				case "cab":
					fareString = data.get("cab").toString();
					break;

				default:
					throw new IllegalArgumentException("Invalid vehicle type. Use bike, auto or cab");
				}

				double fare = Double.parseDouble(fareString);

				// 4. Create Booking
				Booking booking = new Booking();

				booking.setCust(customer);

				// Pickup and drop
				// See note below about Address vs String
				booking.setPaymenttype("pending");

				booking.setFare(fare);

				booking.setVehicletype(vehicletype);

				LocalDate today = LocalDate.now();
				LocalTime now = LocalTime.now();

				booking.setBookingdate(today.toString());
				booking.setBookingtime(now.toString());

				booking.setPickuptime(null);
				booking.setDroptime(null);

				booking.setPaymentstatus("pending");

				// 5. Save booking
				Booking savedBooking = br.save(booking);
				List<String> nearbyriders = redisservice.findNearbyRiders(vehicletype, cordinatesdto.getLatitude(),
						cordinatesdto.getLongitude());
				BookingDetailsForAllRidersDto response = new BookingDetailsForAllRidersDto();

				response.setId(id);
				response.setFare(fare);
				response.setDistance(Double.parseDouble(data.get("distance").toString()));
				response.setBid(savedBooking.getBid());

				redisservice.deleteData(id);
//				return savedBooking;
				return response;
	}

}
