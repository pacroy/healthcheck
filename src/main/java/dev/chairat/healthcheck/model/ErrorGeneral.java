package dev.chairat.healthcheck.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorGeneral {

    private String type;
    private String description;
    private List<ErrorDetail> errorDetails = new ArrayList<>();

}
