package com.course.practicaljava.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class InboundRequest {

    @Schema( name = "edi_format", example = "310",  required = true)
    public String edi_format;

    @Schema( name = "partner", example = "SMLU",  required = true)
    public String partner;

    @Schema( name = "start_time", example = "2022-07-29T16:13:13+08:00",  required = true)
    public String start_time;

    @Schema( name = "end_time", example = "2022-07-29T16:13:13+08:00",  required = true)
    public String end_time;

    @Schema( name = "filename", example = "OECGROUP-315-072722-000004.txt",  required = true)
    public String filename;

    @Schema( name = "e", example = "ISA*00*          *00*          *ZZ*SMLU           *ZZ*OECGROUP       *220728*1341*U*00401*000000004*0*T*>~",  required = true)
    public String content;

    @Schema( name = "transactions", example = "2022-07-29T16:13:13+08:00",  required = false)

    public String[] transactions;

    @Schema( name = "successes", example = "1",  required = false)
    public Integer successes;

    @Schema( name = "failures", example = "1",  required = false)
    public Integer failures;

    @Schema( name = "error", example = "something wrong",  required = false)
    public String error;

}
