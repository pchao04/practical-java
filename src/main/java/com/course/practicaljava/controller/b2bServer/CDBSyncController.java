package com.course.practicaljava.controller.b2bServer;

import com.course.practicaljava.model.request.JsonRequest;
import com.course.practicaljava.model.request.SyncCDBRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/edi/v1/cdb")
@RestController
@Tag(name = "EDI CDB SYNC", description = "")
public class CDBSyncController {
    @PutMapping(path = "/edi_cdb_sync/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "switch CDB sync scheduler", description = "開關CDB檔案同步排程")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> update(
            @Parameter(description = "id", example = "1234") @PathVariable String id,

            @Parameter(name = "data", description = "data") @RequestBody SyncCDBRequest data) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @GetMapping(value = "/edi_cdb_sync", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get job list", description = "檢索CDB資料傳輸job")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Everything is OK"),
            @ApiResponse(responseCode = "400", description = "Bad input parameter")})
    public ResponseEntity<Object> get(
            @RequestParam Integer offset) {
        var entities = new Object();
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping(value = "/edi_cdb_sync/sync/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "sync data manually", description = "手動同步檔案")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "fail")})
    public ResponseEntity<Object> trigger(
            @PathVariable String id,
         @Parameter(example = "{}")   @RequestBody(required = false) Object data) {
        var entities = new Object();
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }
}