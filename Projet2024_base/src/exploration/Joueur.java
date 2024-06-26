/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 * À compléter
 * @author jo
 */
public class Joueur
{    
    private String nom;
    private LesOutils outils;
    private boolean perdant;
    private boolean gagnant=false;
    private Position position;
    private int nbgrenades=15;
    private int uEnergie =15;
    /**
     * Position du joueur
     * @return une référence à une position
     */
    
    public int getNbgrenades(){
        return this.nbgrenades;
    }
    public void setNbgrenades(int nbgrenades){
        this.nbgrenades=nbgrenades;
    }

    public int getUEnergie(){
        return this.uEnergie;
    }
    public void setUEnergie(int uenergie){
        this.uEnergie=uenergie;
    }
    
    
    public String getNom(){
        return this.nom;
    }
    public LesOutils getOutils(){
        return this.outils;
    }
    public boolean isPerdant(){
        return this.perdant;
    }
    public boolean isGagnant(){
        return this.gagnant;
    }
    public Position getPosition(){
         return this.position;
     }    
    public boolean possede(Outil o){
        return this.getOutils().isInList(o);
    /**
     * Salle où se situe le joueur
     * @return une référence à une salle
     */
    }
     public Salle getSalle(){
        return this.position.getPlateau().getSalle(this.position);
    }
     
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setNom()
    {
        setNom(Lire.S("Nom du joueur"));
    }

    private void setOutils(LesOutils outils){
        this.outils = outils;
    }
    /**
     * Récupération d'un outil trouvé dans une salle
     * @param perdant
     */
    public void setPerdant(boolean perdant){
        this.perdant = perdant;
    }
    protected void setGagnant(boolean gagnant){
        this.gagnant = gagnant;
    }
    private void setPosition(Position position)
    {
        
        this.position = position ;
        this.getSalle().entree(this);
        // affectation de la position en déclenchant la méthode d'entrée de la salle
    }  
    /**
     * Avance dans une direction donnée à condition que le mur soit ouvert dans cette direction
     * @param nom
     * @param position
     */
    
    
    public Joueur(String nom,Position position)
    {
        this.setNom(nom);
        this.setPosition(position);
        this.setOutils(new LesOutils(this));
    }
    public Joueur(Position position)
    {
        this.setNom();
        this.setOutils(new LesOutils(this));
        this.setPosition(position);
    }
    
    
   public void avance(Direction d)
    {
        if (this.getPosition().getSuivante(d).isValide() && this.getSalle().isPossible(d)){
            
            this.setPosition (this.getPosition().getSuivante(d));
        }
        else System.out.println("Vous ne pouvez pas avancer dans cette direction");
        /*
            code : il faut gérer la sortie du plateau, le fait qu'un mur soit ou non ouvert et remettre à jour la position du joueur
        */
    }

  public void recupere(Outil o)
    {
        this.outils.ajoute(o);
        
        //Cette méthode est déclenchée par l'interaction avec l'outil
    }    
    
  public void lanceGrenade(Direction d)
    {
        if (this.getNbgrenades()>0) {
            if (this.getSalle().isPossible(d)==true)
            {
                System.out.println("Un mur est deja ouvert dans cette direction. Vous avez perdu votre grenade.");
            }
            else
            { 
                this.getSalle().setAcces(d);
                this.avance (d);
                this.nbgrenades--;
            }
        } else System.out.println("Vous n'avez plus de grenades");
    }    

  
    public String NomtoString() {
        return " " + nom ;
    }

    @Override
    public String toString() {
        return   "nombre de grenades :" + nbgrenades + "; nombre d'Energie :" + uEnergie ;
    }
}
