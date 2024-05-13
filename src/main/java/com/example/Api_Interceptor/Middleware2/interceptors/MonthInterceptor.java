package com.example.Api_Interceptor.Middleware2.interceptors;

import com.example.Api_Interceptor.Middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private final List<Month> months = Arrays.asList(
            new Month(15, "January", "Gennaio", "Januar"),
            new Month(28, "February", "Febbraio", "Februar"),
            new Month(17, "March", "Marzo", "März"),
            new Month(10, "April", "Aprile", "April"),
            new Month(4, "May", "Maggio", "Mai"),
            new Month(12, "June", "Giugno", "Juni")
    );
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber header is missing");
            return false;
        }

        try {
            int monthNumber = Integer.parseInt(monthNumberHeader);
            Month selectedMonth = findMonth(monthNumber);

            if (selectedMonth != null) {
                request.setAttribute("selectedMonth", selectedMonth);
            } else {
                request.setAttribute("selectedMonth", new Month());
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid monthNumber format");
            return false;
        }

        return true;
    }

    private Month findMonth(int monthNumber) {
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        return null;
    }
}