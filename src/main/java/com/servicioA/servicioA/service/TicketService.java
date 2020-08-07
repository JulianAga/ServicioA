package com.servicioA.servicioA.service;

import com.servicioA.servicioA.models.Ticket;
import com.servicioA.servicioA.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class TicketService {

    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket addTicket(){
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        Ticket ticket = Ticket.builder().discount(randomInt).number(UUID.randomUUID()).build();

       return this.ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Integer id) throws Exception {
        return this.ticketRepository.findById(id).orElseThrow(Exception::new);
    }

}
