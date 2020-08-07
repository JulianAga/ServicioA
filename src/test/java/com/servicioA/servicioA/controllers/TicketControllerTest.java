package com.servicioA.servicioA.controllers;

import com.servicioA.servicioA.models.Ticket;
import com.servicioA.servicioA.service.TicketService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

    @Mock
    TicketService ticketService;

    TicketController ticketController;

    @BeforeEach
    public void initMocks() {
        ticketController = new TicketController(ticketService);
    }

    @Test
    public void testGetTicketById() throws Exception {

        Ticket ticket = Ticket.builder().id(1).build();
        when(this.ticketService.getTicketById(1)).thenReturn(ticket);
        ResponseEntity<Ticket> ticket1 = ticketController.getTicketById(1);

        assertEquals(ticket.getId(),ticket1.getBody().getId());

    }

}
