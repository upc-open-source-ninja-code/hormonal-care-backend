package com.acme.hormonalcare.backend.calendar.interfaces.rest;

import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.CalendarResource;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.CreateCalendarResource;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.UpdateCalendarResource;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.transform.UpdateCalendarCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.transform.CreateCalendarCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.transform.CalendarResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.calendar.domain.model.queries.GetCalendarByIdQuery;
import com.acme.hormonalcare.backend.calendar.domain.services.CalendarCommandService;
import com.acme.hormonalcare.backend.calendar.domain.services.CalendarQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/calendar", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalendarController {
    private final CalendarCommandService calendarCommandService;
    private final CalendarQueryService calendarQueryService;

    public CalendarController(CalendarCommandService calendarCommandService, CalendarQueryService calendarQueryService) {
        this.calendarCommandService = calendarCommandService;
        this.calendarQueryService = calendarQueryService;
    }

    @PostMapping
    public ResponseEntity<CalendarResource> createCalendar(@RequestBody CreateCalendarResource resource) {
        var createCalendarCommand = CreateCalendarCommandFromResourceAssembler.toCommandFromResource(resource);
        var calendar = calendarCommandService.handle(createCalendarCommand);
        if (calendar.isEmpty()) return ResponseEntity.badRequest().build();
        var calendarResource = CalendarResourceFromEntityAssembler.toResourceFromEntity(calendar.get());
        return new ResponseEntity<>(calendarResource, HttpStatus.CREATED);
    }

    @GetMapping("/{calendarId}")
    public ResponseEntity<CalendarResource> getCalendarById(@PathVariable Long calendarId) {
        var getCalendarByIdQuery = new GetCalendarByIdQuery(calendarId);
        var calendar = calendarQueryService.handle(getCalendarByIdQuery);
        if (calendar.isEmpty()) return ResponseEntity.notFound().build();
        var calendarResource = CalendarResourceFromEntityAssembler.toResourceFromEntity(calendar.get());
        return ResponseEntity.ok(calendarResource);
    }

    @PutMapping("/{calendarId}")
    public ResponseEntity<CalendarResource> updateCalendar(@PathVariable Long calendarId, @RequestBody UpdateCalendarResource updateCalendarResource) {
        var updateCalendarCommand = UpdateCalendarCommandFromResourceAssembler.toCommandFromResource(calendarId, updateCalendarResource);
        var updatedCalendar = calendarCommandService.handle(updateCalendarCommand);
        if (updatedCalendar.isEmpty()) return ResponseEntity.badRequest().build();
        var calendarResource = CalendarResourceFromEntityAssembler.toResourceFromEntity(updatedCalendar.get());
        return ResponseEntity.ok(calendarResource);
    }
}