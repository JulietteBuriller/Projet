/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author buril
 */

    public class UniteDeDeminage extends Outil{
    
     private Direction directionCourante;

    public void setDirectionCourante (Direction d){
        this.directionCourante=d;
        
    public Direction getDirectionCourante(){
        return this.directionCourante;
    
    @Override
    public void interaction(Joueur j){
     System.out.println("Cette salle contient une unite de deminage");
     j.recupere(this);
    }
    
    public UniteDeDeminage()
    {
        super
        (
                "(*)",
                "Unite de deminage",
                "une unite de deminage, qui desactive moyennant 2 unites d'energie une mine situee dans\n" +
                "une salle contigue accessible (le mur entre les salles doit deja avoir ete detruit).",
                8//coût énergétique de la détection des mines
        );
    }    

  
    
    @Override
    public void activation(Joueur j)
    {
        this.setDirectionCourante(this.directionCourante.getDirectionQuelconque());
        Salle salle = j.getPosition().getPlateau().getSalle(j.getPosition().getSuivante(this.directionCourante));

        if(!j.getSalle().isPossible(this.directionCourante)){
            System.out.println("Il y a un mur !");
        }
        else
        {
            if(new Mine().equals(salle.getContenu())){
                salle.setObjet(null);
                System.out.println("la mine a ete desactivee");
            }
            else{
                System.out.println("Il n'y a pas de mine dans cette salle vous avez perdu votre unite de deminage");}
                j.getOutils().enlève(this);}
        
        }
        
        
    }