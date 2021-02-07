package com.rivigo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Validated
public class ErrorResponseDto {

    @JsonProperty(value = "message")
    private String errorMessage = null;


    @ApiModelProperty(required = true ,value = "Error Message")
    @NotNull
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponseDto errorMessage(final String errorMessage){
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponseDto)) return false;
        ErrorResponseDto that = (ErrorResponseDto) o;
        return Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessage);
    }

    @Override
    public String toString() {
        return "ErrorResponseDto{" +
                "errorMessage: '" + errorMessage + '\'' +
                '}';
    }


}
