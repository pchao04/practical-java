package com.course.practicaljava.controller.b2b;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/b2b_management/v1/system")
@RestController
@Tag(name = "System", description = "System")
public class MgmSystemController {

    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "system live check",description = "服務健康狀態",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": \"ok\"}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> health() {
        var entities = new Object();
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }
}
