package baseEx5String;

public class BaseEx5String {

    public static void main(String[] args) {
    	
        concat();
        String contains = "il fait beau aujourd'hui";
        contains(contains);
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
}
