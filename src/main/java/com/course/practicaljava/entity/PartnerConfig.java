package com.course.practicaljava.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Accessors(chain = false)
@ToString
@Document(indexName = "edi_partner_configs", createIndex = false)
public class PartnerConfig {
    @Id
    @ReadOnlyProperty
    String id;

//    @Field("data")
//    String data;data
    @Field(name = "_source", type = FieldType.Nested)
    private Object source;
}
