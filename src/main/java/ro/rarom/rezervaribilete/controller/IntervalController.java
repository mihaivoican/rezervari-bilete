package ro.rarom.rezervaribilete.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rarom.rezervaribilete.model.IntervalOrar;
import ro.rarom.rezervaribilete.model.Rezervare;
import ro.rarom.rezervaribilete.service.IntervalService;

@RequiredArgsConstructor
@RequestMapping("intervale")
@RestController
public class IntervalController {
    //aici endpoint-uri pt intervale orare si rezervari

    private final IntervalService intervalService;


    //cautare interval dupa id
    @GetMapping("{id}")
    public IntervalOrar getById(@PathVariable long id){
        return intervalService.getByIdInterval(id);
    }

    //sterg interval
    @DeleteMapping("{id}")
    public IntervalOrar deleteById(@PathVariable long id){
        return intervalService.deleteByIdInterval(id);
    }

    //adaugare rezervare la interval orar
    @PostMapping("{id}/rezervari")
    public IntervalOrar addRezervareTointerval(@PathVariable long id, @RequestBody Rezervare rezervare){
        return intervalService.addRezervareToInterval(id,rezervare);
    }
}