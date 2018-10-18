package project;

/*
You will make your own Traveling Denizen that could a type of warrior in a dungeon/forest/city or could be savior of lives in a dungeon/forest/city. This program will
grow throughout the year.
 
Part 1: We are just creating a humanoid creature of your devising, that will do battle (or restore health) of other creatures it encounters. Your critter will need:
 
Name
Type
Energy level/life points
Strength for a fighter/Knowledge/power for a healer (used in encounters with others)
Home town/place of origination: inserted into text used for encounters
You will need methods :
 
greet: which uses name and origination in a greeting
attack/save: which determines random number of hit points of damage/healing done, based on the strength or knowledge level
constructors: what constructors should it have?
You will need a tester class: DenizenTester_XLastna that will test out the methods of the Denizen.
*/
 
import java.util.Scanner;
 
public class PenguinTester_7LaiRodricks {
   public static void main(String[] args) {
      Denizen d1 = new Denizen();
   }
}
 
//DENIZEN
class Denizen{
   private String name;
   private String type;
   private String hometown;
   private String action;
   private int maxLifePoints;
   private int lifePoints;
   private int abilityPower; //AKA knowledge
   private int attackDamage; //AKA strength
   private int healing;
   private int maxMana;
   private int mana;
   private int maxStamina;
   private int stamina;
   private boolean inCombat;
   
   public Denizen(){
      userInput();
      baseStats();
      while (true){
         nextAction();
      }
   }
   
   //NAME, CLASS, ORIGINS
   public void userInput(){
      Scanner characterCreation = new Scanner(System.in);
      System.out.println("What is your name?");
      name = characterCreation.nextLine();
      System.out.println("Please select your class.\n1) Mage \n2) Warrior\n3) Healer");
      type = characterCreation.nextLine();
      while ((!type.equals("Mage")) && (!type.equals("Warrior")) && (!type.equals("Healer"))){
         System.out.println(type + " is not a valid class.");
         type = characterCreation.nextLine();
      }
      System.out.println("Where are you from?");
      hometown = characterCreation.nextLine();
   }
   //BASE STATS
   public void baseStats(){
      if (type.equals("Warrior")){
         maxLifePoints = 100;
         lifePoints = 100;
         attackDamage = 50;
         abilityPower = 5;
         healing = 10;
         maxMana = 100;
         mana = 100;
         maxStamina = 50;
         stamina = 50;
      }
      if (type.equals("Mage")){
         maxLifePoints = 75;
         lifePoints = 75;
         attackDamage = 20;
         abilityPower = 75;
         healing = 20;
         maxMana = 200;
         mana = 200;
         maxStamina = 25;
         stamina = 25;
      }
      if (type.equals("Healer")){
         maxLifePoints = 75;
         lifePoints = 75;
         attackDamage = 20;
         abilityPower = 50;
         healing = 40;
         maxMana = 200;
         mana = 200;
         maxStamina = 20;
         stamina = 20;
      }
   }
   public int getLifePoints(){
      return lifePoints;
   }
   public int getAttackDamage(){
      return attackDamage;
   }
   public int getAbilityPower(){
      return abilityPower;
   }
   
   //DECISIONS
   public void nextAction(){
      Scanner nextAction = new Scanner(System.in);
      System.out.println("What would you like to do next?\n1) Rest\n2) Fight\n3) Physical Attack \n4) Magic Attack \n5) Run \n6) Heal\n7) Greet");
      action = nextAction.nextLine();
      while ((!action.equals("Rest")) && (!action.equals("Fight")) && (!action.equals("Physical Attack")) && (!action.equals("Magic Attack"))
      && (!action.equals("Run")) && (!action.equals("Heal")) && (!action.equals("Greet"))){
         System.out.println(action + " is not a valid action.");
         action = nextAction.nextLine();  
      }
     
      if (action.equals("Rest")){
         rest();
      }
      if (action.equals("Fight")){
         fight();      
      }
      if (action.equals("Physical Attack")){
         physicalAttack();
      }
      if (action.equals("Magic Attack")){
         magicAttack();
      }
      if (action.equals("Run")){
         run();
      }
      if (action.equals("Heal")){
         heal();
      }
      if (action.equals("Greet")){
         greet();
      }
   }
   
   //GREET
   public void greet(){
      System.out.println("Hello! I am " + name + " from " + hometown + " and I am a " + type.toLowerCase() + ".");
   }
   
   //COMBAT
   public void fight(){
      if (inCombat == true){
         System.out.println("You are already in battle!");
      }
      if (inCombat == false){
         System.out.println("A new enemy has appeared!");
         Enemy e1 = new Enemy();
         while (e1.getLifePoints() > 0){
            inCombat = true;
            }
         while (e1.getLifePoints() <= 0){
            inCombat = false;
         }
      }    
   }
   
   //HEAL
   public void heal(){      
      if (lifePoints == maxLifePoints){
         System.out.println("You are already at full HP!");
      }
      if (mana >= 25){
         if ((maxLifePoints - lifePoints) >= maxLifePoints){
            lifePoints += healing;
            mana -= 25;
         }
         if ((maxLifePoints - lifePoints) < maxLifePoints){
            lifePoints = maxLifePoints;
            mana -= 25;
         }
      }
      if (mana < 25){
         System.out.println("You do not have enough mana for this action.");
      }
   }
   
   //COMBAT MOVES
   public void physicalAttack(){
     if (inCombat == true){
     
     }
     if (inCombat == false){
         System.out.println("What are you attacking? A tree?");
      }        
   }
   public void magicAttack(){
     if (inCombat == true){
     
     }
     if (inCombat == false){
         System.out.println("Stop it. You'll kill a civilian.");
     }
   }
   
   public void run(){
      if (inCombat == false){
         System.out.println("What are you running from?");
      }
      double escapeChance = Math.random();
      if (inCombat == true){
         if (escapeChance <= .75){
            inCombat = false;
         }
      }
   }
   
   public void rest(){
      if (inCombat == false){
         lifePoints = maxLifePoints;
         mana = maxMana;
         stamina = maxStamina;
      }
      if (inCombat == true){
         System.out.println("You cannot rest while in combat!");
      }
   }
}  
 
//ENEMY
class Enemy{
   private int attackDamage;
   private int lifePoints;
   
   public Enemy(){
      baseStats();
   }
   //BASE STATS
   public void baseStats(){
      attackDamage = (int)Math.random()*(25-20) + 20;
      lifePoints = (int)Math.random()*(75-5) + 50;
   }
   public int getLifePoints(){
      return lifePoints;
   }
   public int getAttackDamage(){
      return attackDamage;
   }
   public void takeDamage(int damage){
      lifePoints -= damage;
   }
}