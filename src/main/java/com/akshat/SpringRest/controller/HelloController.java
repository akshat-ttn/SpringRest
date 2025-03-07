package com.akshat.SpringRest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MessageSource messageSource;

    @GetMapping("/hello")
    public String  getPersonName(@RequestParam String name){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", new Object[]{name}, "UYf",locale);
    }
}
