package part2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import part2.model.Ticket;
import part2.model.input.TicketCreateInput;
import part2.service.TicketService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket/{id}")
    public Mono<Ticket> ticketById(@PathVariable long id) {
        return this.ticketService.getTicketById(id);
    }

    @GetMapping("/tickets")
    public Flux<Ticket> tickets() {
        return this.ticketService.getTickets();
    }

    @PostMapping(value = "/ticket", consumes = "application/json")
    public Mono<Ticket> createTicket(@RequestBody TicketCreateInput input) {
        return ticketService.createTicket(
            Ticket.builder()
                .price(input.getPrice())
                .build()
        );
    }

}
