package com.ramostear.spring.boot.exception.handing.exception;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:16
 * @modify by :
 * @since:
 */
@Data
@JsonTypeIdResolver(LowerCaseClassNameResolver.class)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT,use = JsonTypeInfo.Id.CUSTOM,property = "error",visible = true)
public class RestApiError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    private List<RestApiSubError> subErrors;

    private RestApiError(){
        timestamp = LocalDateTime.now();
    }

    RestApiError(HttpStatus status){
        this();
        this.status = status;
    }

    RestApiError(HttpStatus status,Throwable ex){
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    RestApiError(HttpStatus status,String message,Throwable ex){
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    private void addRestApiSubError(RestApiSubError subError){
        if(subErrors == null){
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    private  void addRestApiValidationError(String object,String field,Object rejectedValue,String message){
        addRestApiSubError(new RestApiValidationError(object,field,rejectedValue,message));
    }

    private void addRestApiValidationError(String object,String message){
        addRestApiSubError(new RestApiValidationError(object,message));
    }

    private void addRestApiValidationError(FieldError fieldError){
        this.addRestApiValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage()
        );
    }

    private void addRestApiValidationError(ObjectError objectError){
        this.addRestApiValidationError(objectError.getObjectName(),objectError.getDefaultMessage());
    }

    private void addRestApiValidationError(ConstraintViolation<?> cv){
        this.addRestApiValidationError(
                cv.getRootBeanClass().getSimpleName(),
                ((PathImpl)cv.getPropertyPath()).getLeafNode().asString(),
                cv.getInvalidValue(),
                cv.getMessage()
        );
    }

    void addRestApiValidationErrors(List<FieldError> fieldErrors){
        fieldErrors.forEach(this::addRestApiValidationError);
    }

    void addRestApiValidationError(List<ObjectError> globalErrors){
        globalErrors.forEach(this::addRestApiValidationError);
    }

    void addRestApiValidationErrors(Set<ConstraintViolation<?>> cvs){
        cvs.forEach(this::addRestApiValidationError);
    }


    abstract class RestApiSubError{}

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    class RestApiValidationError extends RestApiSubError{
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;

        RestApiValidationError(String object,String message){
            this.object = object;
            this.message = message;
        }
    }

}

class LowerCaseClassNameResolver extends TypeIdResolverBase{

    @Override
    public String idFromValue(Object value) {
        return value.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        return idFromValue(value);
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}