package com.example.lab5q3.Controller;

import com.example.lab5q3.ApiResponse.ApiResponse;
import com.example.lab5q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event>events=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Event> getEvents (){

        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event){
        events.add(event);

        return new ApiResponse("event added",200);
    }
    @PutMapping("update/{index}")
    public ApiResponse updateEvent(@PathVariable int index,@RequestBody Event event){

        events.set(index,event);

        return new ApiResponse("event updated",200);
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){

        events.remove(index);

        return new ApiResponse("event deleted",200);

    }

    @PutMapping("/change-capacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index,@PathVariable int capacity){
        events.get(index).setCapacity(capacity);

        return new ApiResponse("capacity changed",200);
    }


    @GetMapping("get-events/{ID}")
    public Event getEvents(@PathVariable String ID){

        for(Event e : events){
            if(e.getID().equals(ID)){
                return e;
            }
        }

        return null;
    }
}
