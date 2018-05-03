package testpoint;

public class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void affiche() {
		System.out.println("les coordonées de Point x = " + x + " y = " + y);
	}
	
	public static void main (String[] args) {
		Point a = new Point(2,5);
		PointCouleur b = new PointCouleur(8,1,"Rouge");
		Point c = new PointCouleur(8,1,"Vert");
		a.affiche();   		//les coordonées de Point x = 2 y = 5
		b.affiche();  		//les coordonées de Point x = 8 y = 1
					   		//Et ma couleur est Rouge
		c.affiche();		// les coordonées de Point x = 8 y = 1
							// Et ma couleur est Vert
		
		a = b;				// l'objet a de type Point prends la référence de l'objet b de type PointCouleur
		b.affiche();		// les coordonées de Point x = 8 y = 1
							// Et ma couleur est Rouge
		
		b = (PointCouleur)c;
		a = new Point(1,9);
		b.affiche();  		// les coordonées de Point x = 8 y = 1
							// Et ma couleur est Vert
		c.affiche();  		// les coordonées de Point x = 8 y = 1
							// Et ma couleur est Vert
		
		// b = a; ATTENTION Il y aura une erreur lors de la compilation car b est de type PointCouleur et a est de type Point 
	
		b.affiche();  		// les coordonées de Point x = 8 y = 1
					  		// Et ma couleur est Vert
		
		}

	
			
			
			
			
			
	
	
}

class PointCouleur extends Point {

	String color;

	public PointCouleur(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void affiche() {
		super.affiche();
		System.out.println("Et ma couleur est " + color);
	}
	
}


