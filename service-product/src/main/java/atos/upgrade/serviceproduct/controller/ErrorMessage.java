package atos.upgrade.serviceproduct.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@Builder
public class ErrorMessage {
    private String errorCode;
    private List<Map<String, String>> messages;

}
