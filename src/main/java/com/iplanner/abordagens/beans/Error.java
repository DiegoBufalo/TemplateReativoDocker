package com.iplanner.abordagens.beans;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error implements Serializable{

	private static final long serialVersionUID = 1897635338170593755L;

	private String message;
	
	private List<String> errors;
}
