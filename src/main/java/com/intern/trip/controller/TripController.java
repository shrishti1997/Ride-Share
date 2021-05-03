package com.intern.trip.controller;

import com.intern.trip.model.Trip;
import com.intern.trip.repo.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" ,"http://192.168.0.134:3000"})
@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripRepo tripRepo;

    //create trip
    @PostMapping("/createtrip")
    @ResponseStatus(HttpStatus.CREATED)
    public Trip createTrip(@RequestBody Trip trip)
    {

            tripRepo.save(trip);
            return trip;

    }

    //delete trip
    @DeleteMapping(value = "/deletetrips")
    String deleteTrips(@RequestParam("id") String id)
    {
        Optional<Trip> to_delete = tripRepo.findById(id);
        //System.out.println(to_delete);
        tripRepo.deleteById(id);
        //tripRepo.delete(to_delete);
        return "this trip is deleted!";
    }


    //show all trips
    @GetMapping(value = "/viewalltrips")
    @ResponseStatus(HttpStatus.OK)
    public List<Trip> showAllTrip(@RequestParam("id") String id){

        //status == planning in progress
        return tripRepo.findAll();
    }

    //show only user's trips
    @GetMapping(value = "/viewtrips")
    @ResponseStatus(HttpStatus.OK)
    public List<Trip> showUsersTrip(@RequestParam("id") String id)
    {
        ArrayList<Trip> user_trips = new ArrayList<>();
        for (Trip current_user : tripRepo.findAll()) {
            //do not show users their own trip
            //delete or status == all

            if(current_user.getTrip_org_email().equals(id))
                user_trips.add(current_user);
        }
        return user_trips;
    }

}
