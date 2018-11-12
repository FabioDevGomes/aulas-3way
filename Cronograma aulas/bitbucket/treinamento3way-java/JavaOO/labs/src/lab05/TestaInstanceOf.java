package lab05;


public class TestaInstanceOf {
	
	public static void main(String[] args) {
	
		// Criar objeto String
		String str1 = "Aprenda Java em Dez anos!";
		Long l1 = new Long(50);
		
		// Checa se str1 é do tipo String usando operador instanceof.
		// Checa também se é do tipo Object.
		boolean b1 = str1 instanceof String;
		System.out.println("str1 é String: " + b1);
		
		boolean b2 = str1 instanceof Object;
		System.out.println("str1 é Object: " + b2);
		
		// Checa se int1 é do tipo Integer usando operador instanceof.
		// Checa também se é do tipo Object.
		b1 = l1 instanceof Long;
		System.out.println("l1 é do tipo Long: " + b1);
		
		b2 = l1 instanceof Object;
		System.out.println("l1 é Object: " + b2);
		
		b2 = l1 instanceof Number;
		System.out.println("l1 é do tipo Number: " + b2);
	}
}