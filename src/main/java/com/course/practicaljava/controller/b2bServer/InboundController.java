package com.course.practicaljava.controller.b2bServer;

import com.course.practicaljava.model.request.InboundRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/edi/v1/inbound")
@RestController
@Tag(name = "EDI Inbound", description = "EDI Inbound")
public class InboundController {

    @GetMapping(path = "/edi_inbound", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get Railinc in schedules", description = "Railinc in執行完畢的排程列表")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> getList(
            @Parameter(description = "search query", example = "") @RequestParam String search,
            @Parameter(name = "timeRange", description = "time range") @RequestParam String[] timeRange,
            @Parameter(description = "sort field", example = "") @RequestParam String sort ,
            @Parameter(description = "sort order", example = "") @RequestParam String order,
            @Parameter(description = "soffset", example = "") @RequestParam Integer offset) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }


    @GetMapping(path = "/edi_inbound/{partner}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "trigger inbound", description = "trigger inbound")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> triggerInbound(
            @Parameter(description = "partner name", example = "") @PathVariable String partner) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping(path = "/edi_inbound", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "write inbound", description = "write inbound")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> writeInbound(
            @Parameter(description = "partner name", example = "") @RequestBody InboundRequest partner) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

}
