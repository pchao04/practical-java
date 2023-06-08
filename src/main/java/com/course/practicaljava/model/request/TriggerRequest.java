package com.course.practicaljava.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//@Data
public class TriggerRequest {
    @Schema( name = "S3PathKeyName", example = "attachments/2021-11-02/03-58-28.824.914a001d-3d19-496e-97ba-628d546cfcff.pdf", description = "aaa", required = true)
    public String S3PathKeyName;


    @Schema( name = "partner", example ="BERLIN_310",  required = true)
    public String partner;

    @Schema( name = "doc_type", example ="HBL_NO",  required = true)
    public String doc_type;

    @Schema( name = "HBL_NO", example ="OERT215718K01005",  required = false)
    public String HBL_NO;

    @Schema( name = "INVOICE_NO", example ="4255476-D",  required = false)

    public String INVOICE_NO;
}
