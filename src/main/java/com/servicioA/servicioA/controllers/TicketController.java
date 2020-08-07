package com.servicioA.servicioA.controllers;

import com.servicioA.servicioA.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/ticket")
public class TicketController {


    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @ApiOperation(code = 200,value = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message ="ticket creado")
    })
    @PostMapping("/create")
    public ResponseEntity create(){
        ticketService.addTicket();
        return ResponseEntity.created(URI.create("asd")).build();
    }

    @GetMapping("/{id}")
    @ApiOperation(code = 200,value = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message ="ticket con su informacion")
    })
    public ResponseEntity getTicketById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(this.ticketService.getTicketById(id));
    }

}
