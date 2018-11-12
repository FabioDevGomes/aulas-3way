package lab05;


public class CastingPrimitivos {

	public static void main(String[] args) {
	
		// casting long -> byte
		long numLong = 10;
		byte numByte = (byte)numLong;
		System.out.println("long " + numLong + " e implicitamente moldado para byte " + numByte);
		
		// casting float -> short
		float numFloat = 10;
		short numShort = (short)numFloat;
		System.out.println("float " + numFloat + " e implicitamente moldado para short " + numShort);
		
		// casting int -> char
		int numInt = 1;
		char numChar = (char)numInt;
		System.out.println("int " + numInt + " e implicitamente moldado para char " + numChar);
	}
}