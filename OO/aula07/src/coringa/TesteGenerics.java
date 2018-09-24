package coringa;

import java.util.List;

public class TesteGenerics {	
	
	public void addAnimal(List<? extends Felino> animais){
		
		for(Felino bicho : animais){
			bicho.fazerRuido();
		}
	}

}
