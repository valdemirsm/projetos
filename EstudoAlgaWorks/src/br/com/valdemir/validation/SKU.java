package br.com.valdemir.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp="([a-zA-Z]{2}\\d{4,18})?")
//só aceita 2 caracteres de A a Z maiusculo e minuscolo
// ()? agrupa todas as mensagem, ou seja, só mostra uma mensagem
// de cadas vez, primeiro se estiver null							

public @interface SKU {
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{br.com.valdemir.validation.constraints.SKU.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
