package generics1;

import java.util.List;

public class TesteGenerics {
	
	//não deixa add sub tipos
	//	public void addAnimal(List<Felino> animais){
	
	
	public void addAnimal(List<? extends Felino> animais){
		
		for(Felino bicho : animais){
			bicho.fazerRuido();
			
		}
	}

}
