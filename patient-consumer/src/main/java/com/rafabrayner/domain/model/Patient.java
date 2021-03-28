package com.rafabrayner.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(includeFieldNames = true)
public class Patient implements Serializable {

    private Long id;
    private UUID code;
    private String name;
    private String status;
    private String note;
    private LocalDateTime hospitalizationDateTime;
    private UUID hospitalCode;
}
