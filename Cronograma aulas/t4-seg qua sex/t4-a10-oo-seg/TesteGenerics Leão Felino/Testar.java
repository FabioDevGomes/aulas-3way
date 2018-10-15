package aula10;

import java.util.ArrayList;
import java.util.List;

public class Testar {

	public static void main(String[] args) {
		
		List<Leao> animais = new ArrayList<Leao>();
		animais.add(new Leao());
		
		List<Felino> animais2 = new ArrayList<Felino>();
		animais2.add(new Felino());
		
		List<Felino> animais3 = new ArrayList<Felino>();
		animais3.add(new Leao());
		
		TesteGenerics generics = new TesteGenerics();
		generics.addAnimal(animais);
		
	}
	
}
