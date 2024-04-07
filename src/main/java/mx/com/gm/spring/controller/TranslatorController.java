package mx.com.gm.spring.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static mx.com.gm.spring.util.Translator.getMessage;

@RestController
@RequestMapping(path="/api/translator")
public class TranslatorController {
	@GetMapping("/{key}/{locale}")
	public String get	(@PathVariable String key, @PathVariable Locale locale) {
		return getMessage(key, locale); 
	}
}
