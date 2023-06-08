package com.course.practicaljava.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class EdiConfigRequest {

    @Schema( name = "partner", example = "ACER",  required = true)
    public String partner;
    public String edi_format;
    public Boolean status;
}
