package com.progetto.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.progetto.siw.service.ResponsabileUfficialeService;

@Controller
public class ResponsabileUfficialeController {
	
	@Autowired
	private ResponsabileUfficialeService responsabileUfficialeService;
	
	
}
