package com.course.practicaljava.controller.b2b;

import com.course.practicaljava.model.response.ResponseModel;
import com.course.practicaljava.service.ParntnerConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/b2b_management/v1/management")
@RestController
@Tag(name = "B2B in Portal",
    description =
    """
     1. 船公司(Sea Shipping Line)透過SFTP的方式將Container Tracking Event的資料傳送給OEC，透過B2B系統將資料寫入Central Database
     2. Railinc透過SFTP的方式將Rail Tracking and Tracing的資料傳送給OEC，透過B2B系統將資料寫入Central Database
     3. 與OEC配合的Agent利用API、Web Service或SFTP的方式，透過B2B系統將資料寫入Central Database
     4. Customer Portal的使用者登入系統並使用B2B Management所提供之功能
     5 & 6. Customer Portal透過B2B系統上的API或是Web Service讀取或寫入Central Database相關的資料
     7. 透過系統的排程作業或是使用者手動發送EDI資料給Customer  \s
            """)
public class ManagementController {

    private ParntnerConfigService parnerConfigService;

    public ManagementController(ParntnerConfigService parnerConfigService) {
        this.parnerConfigService = parnerConfigService;
    }
    @GetMapping("/message_types")
    @Operation(
            summary = "B2B management get message types",description = "B2B management get message types",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> getMessageTypes() {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping("/summary")
    @Operation(
            summary = "B2B management summary",description = "B2B management summary",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> summary(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
                   @ExampleObject(name = "result",
                           summary = "result",
                           description = "result",
                           value =  summary ) }))
                   Object data
    ) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping("/detail")
    @Operation(
            summary = "B2B management detail",description = "B2B management detail",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> detail(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
                    @ExampleObject(name = "result",
                            summary = "result",
                            description = "result",
                            value =  detail ) }))
            Object data
    ) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping("/resend")
    @Operation(
            summary = "B2B management resend messages",description = "B2B management resend messages, message type固定, 客戶可多選",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> resend(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
                    @ExampleObject(name = "result",
                            summary = "result",
                            description = "result",
                            value =  customer ) }))
            Object data
    ) {
        var entities = parnerConfigService.findAll();
        Object result = entities;
        return new ResponseEntity<Object>(result, HttpStatus.OK);

    }

    @PostMapping( path = "/customers",produces= MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "B2B management get customers",description = "B2B management get customers",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<ResponseModel> getCustomers(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
                    @ExampleObject(name = "result",
                            summary = "result",
                            description = "result",
                            value =  customer ) }))
            Object data
    ) {
        var entities = parnerConfigService.getCustomers();
        ResponseModel result = new ResponseModel();
        result.code=0;
        result.data = entities;
        return new ResponseEntity<ResponseModel>(result, HttpStatus.OK);

    }

    @PostMapping("/action")
    @Operation(
            summary = "delete/ignore messages",description = "刪除/忽略 messages, message type固定, 客戶可多選",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(examples = {
                            @ExampleObject(name = "result",
                                    summary = "result",
                                    description = "result",
                                    value = "{\"status\":0 , \"data\": {}}"
                            )
                    }, mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<Object> action(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
                    @ExampleObject(name = "result",
                            summary = "result",
                            description = "result",
                            value =  action ) }))
            Object data
    ) {
        var entities = new Object();

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    final String action= """
            {\
              "message_id": [\
                "102665619SHURTAPEOERT101741L00095OOLU2692409480CCLU69038704TWKHH"\
              ],\
              "message_type": "310",\
              "action": "delete/update"\
            }\
            """;
    final String customer= "message_type: { type: 'array', example: ['310', '110'] }";
    final String summary= """
            {\
                customer: { type: 'array', example: ['ACER', 'BERLIN'] },\
                message_type: { type: 'array', example: ['110', '310', '315', '315_GTNXML', '856'] },\
                etd: { type: 'array', example: DEFAULT_DATE_RANGE },\
                eta: { type: 'array', example: DEFAULT_DATE_RANGE },\
                sort_column: { type: 'string', example: 'customer' },\
                sort_order: { type: 'string', example: 'desc' },\
                offset: { type: 'number', example: 0 },\
                limit: { type: 'number', example: 10 },\
                is_etd_eta_null: { type: 'boolean', example: true }\
              }\
            """;

    final String detail= """
            {\
                customer: { type: 'array', example: ['BERLIN'] },\
                message_type: { type: 'string', required: true, example: '310' },\
                status: { type: 'array', example: ['New', 'Processing', 'Success', 'Failed', 'Ignored'] },\
                etd: { type: 'array', example: DEFAULT_DATE_RANGE },\
                eta: { type: 'array', example: DEFAULT_DATE_RANGE },\
                sort_column: { type: 'string', example: 'customer' },\
                sort_order: { type: 'string', example: 'desc' },\
                offset: { type: 'number', example: 0 },\
                limit: { type: 'number', example: 10 },\
                hbl_no: { type: 'array' },\
                hbl_no_option: { type: 'string' },\
                mbl_no: { type: 'array' },\
                mbl_no_option: { type: 'string' },\
                cntr_no: { type: 'array' },\
                cntr_no_option: { type: 'string' },\
                invoice_no: { type: 'array' },\
                invoice_no_option: { type: 'string' },\
                is_etd_eta_null: { type: 'boolean', example: true },\
                container_event_value: { type: 'number' }\
              }\
            """;
}
