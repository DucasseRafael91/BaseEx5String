package baseEx5String;

public class BaseEx5String {

    public static void main(String[] args) {
    	
        concat();
        
        String contains = "il fait beau aujourd'hui";
        contains(contains);
        
        String palindrome = "Elu par cette crapule";
        palindrome = palindrome.toLowerCase();
        String palindrome_without_blank = removeBlank(palindrome);
        System.out.println(palindrome_without_blank);
        String palindrome_blank_reverse = reverse(palindrome_without_blank);
        System.out.println(palindrome_blank_reverse);
        
        if(palindrome_without_blank.equals(palindrome_blank_reverse)) {
        	System.out.println("La phrase est un palindrome");
        }
        else {
        	System.out.println("La phrase n'est pas un palindrome");
        }
    }

	private static void concat() {
		String s1 = "Ceci est";
        String s2 = "un test";
        String resultat = s1 + " " + s2;
        System.out.println(resultat);
        
        String s3 = "Ceci est";
        String s4 = "un test 2";
        String resultat2 = s3.concat(" ").concat(s4);
        System.out.println(resultat2);
	}
	
	private static void contains(String contains) {
		if(contains.contains("beau") == true){
			System.out.println("Le mot beau est bien contenue");
		}
		else {
			System.out.println("Erreur");
		}
	}
	
	public static String removeBlank(String palindrome) {
	    return palindrome.replace(" ", "");
	}
	

	public static String reverse(String texte) {
	    String reverse = "";
	    for (int i = texte.length() - 1; i >= 0; i--) {
	    	reverse += texte.charAt(i);
	    }
	    return reverse;
	}


}
