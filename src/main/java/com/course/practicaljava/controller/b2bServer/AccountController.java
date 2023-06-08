package com.course.practicaljava.controller.b2bServer;

import com.course.practicaljava.model.request.LoginRequest;
import com.course.practicaljava.model.response.ResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/edi/v1/account")
@RestController
@Tag(name = "EDI Account", description = "")
public class AccountController {

    @Operation(summary = "login", description = "login")
    @PostMapping(path = "/login",produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "success") })
    public ResponseEntity<ResponseModel> login(
            LoginRequest login
    ){
        var entities = new ResponseModel();
        return new ResponseEntity<ResponseModel>(entities, HttpStatus.OK);
    }

    @Operation(summary = "logout", description = "logout")
    @PutMapping(path = "/logout",produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "success") })

    public ResponseEntity<ResponseModel> logout(){
        var entities = new ResponseModel();
        return new ResponseEntity<ResponseModel>(entities, HttpStatus.OK);
    }
}
