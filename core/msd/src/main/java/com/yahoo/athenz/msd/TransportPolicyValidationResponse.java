//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.msd;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import com.yahoo.rdl.*;

//
// TransportPolicyValidationResponse - Response object of transport policy rule
// validation
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportPolicyValidationResponse {
    public TransportPolicyValidationStatus status;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> errors;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Timestamp updateTime;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long id;

    public TransportPolicyValidationResponse setStatus(TransportPolicyValidationStatus status) {
        this.status = status;
        return this;
    }
    public TransportPolicyValidationStatus getStatus() {
        return status;
    }
    public TransportPolicyValidationResponse setErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }
    public List<String> getErrors() {
        return errors;
    }
    public TransportPolicyValidationResponse setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Timestamp getUpdateTime() {
        return updateTime;
    }
    public TransportPolicyValidationResponse setId(Long id) {
        this.id = id;
        return this;
    }
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != TransportPolicyValidationResponse.class) {
                return false;
            }
            TransportPolicyValidationResponse a = (TransportPolicyValidationResponse) another;
            if (status == null ? a.status != null : !status.equals(a.status)) {
                return false;
            }
            if (errors == null ? a.errors != null : !errors.equals(a.errors)) {
                return false;
            }
            if (updateTime == null ? a.updateTime != null : !updateTime.equals(a.updateTime)) {
                return false;
            }
            if (id == null ? a.id != null : !id.equals(a.id)) {
                return false;
            }
        }
        return true;
    }
}
