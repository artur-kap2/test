package com.example.test.controller;

import com.example.test.dto.ApiDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    @GetMapping(path = "/div/{val1}/{val2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiDto> divide(@PathVariable(value = "val1") Double val1, @PathVariable(value = "val2") Double val2) {

        ApiDto out = new ApiDto();
        if (val2 == 0) {
            return ResponseEntity.status(400).body(null);
        } else {
            out.setValue(val1 / val2);

            return ResponseEntity.ok().body(out);
        }
    }

    @PostMapping(path = "/add/{val1}/{val2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiDto> sum(@PathVariable(value = "val1") Double val1, @PathVariable(value = "val2") Double val2) {

        ApiDto out = new ApiDto();

        out.setValue(val1 + val2);

        return ResponseEntity.ok().body(out);

    }

}
