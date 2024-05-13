package com.example.Api_Interceptor.Middleware2.controller;

import com.example.Api_Interceptor.Middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {
    @GetMapping("")
    public Month getMonth(HttpServletRequest request){
    Month month = (Month) request.getAttribute("selectedMonth");
    return month;
    }
}