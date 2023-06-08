package com.course.practicaljava.controller.b2bServer;

import com.course.practicaljava.model.request.EdiConfigRequest;
import com.course.practicaljava.model.request.SyncCDBRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/edi/v1/outbound")
@RestController
@Tag(name = "EDI Configs", description = "EDI Configs")
public class OutboundController {

    @PostMapping(path = "/edi_partner_configs", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "create edi config",description = "創建edi配置",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = updatedExample2
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> create(
            @Parameter(name = "data", description = "data") @RequestBody EdiConfigRequest data) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PutMapping(path = "/edi_partner_configs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "update config", description = "update config")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> update(
            @Parameter(description = "id", example = "1234") @PathVariable String id,
            @Parameter(name = "data", description = "data") @RequestBody EdiConfigRequest data) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }


    @GetMapping(path = "/edi_partner_configs", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get edi configs", description = "get edi configs")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> getList(
            @Parameter(description = "offset", example = "1") @RequestParam Integer offset,
            @Parameter(name = "search", description = "search query") @RequestParam String search) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/edi_partner_configs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get edi config by id", description = "獲取單個edi配置")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "success")})
    public ResponseEntity<Object> get(
            @Parameter(description = "id", example = "1") @PathVariable String id) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }
    private final String updatedExample2=
            "{" +
            "  \"code\": 0," +
            "  data: {" +
            "    _index: ELASTICSEARCH.INDEX.EDI_PARTNER_CONFIGS," +
            "    _type: 'doc'," +
            "    _id: '113291769_310'," +
            "    _version: 110," +
            "    result: 'updated'," +
            "    _shards: {" +
            "      total: 2," +
            "      successful: 1," +
            "      failed: 0" +
            "    }," +
            "    _seq_no: 134," +
            "    _primary_term: 1" +
            "  }" +
            "}";
    private final String updatedExample=
        """
          {code: 0,\
          data: { \
            _index: ELASTICSEARCH.INDEX.EDI_PARTNER_CONFIGS,\
            _type: 'doc',\
            _id: '113291769_310',\
            _version: 110,\
            result: 'updated',\
            _shards: {\
          total: 2,\
          successful: 1,\
          failed: 0\
        },\
        _seq_no: 134,\
        _primary_term: 1}""";
}
