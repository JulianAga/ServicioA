package com.servicioA.servicioA.service;

import com.servicioA.servicioA.controllers.TicketController;
import com.servicioA.servicioA.models.Ticket;
import com.servicioA.servicioA.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TicketServiceTest {

    @Mock
    TicketRepository ticketRepository;

    TicketService ticketService;

    @BeforeEach
    public void initMocks() {
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    public void getTicketByIdOk() throws Exception {

        Ticket ticket = Ticket.builder().id(1).build();
        when(this.ticketRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(ticket));
        Ticket ticket1 = ticketService.getTicketById(1);

        assertEquals(ticket.getId(),ticket1.getId());
    }


}
