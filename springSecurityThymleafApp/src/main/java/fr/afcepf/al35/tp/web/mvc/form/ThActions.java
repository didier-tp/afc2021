package fr.afcepf.al35.tp.web.mvc.form;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//ThymeleafAskedActions
@Getter @Setter @ToString
public class ThActions {
	ArrayList<Long> toDelete = new ArrayList<>(); //index of element(s) to delete
	Integer nbNew = 0; //number of new elements to add in sublist
}
