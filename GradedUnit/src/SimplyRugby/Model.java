package SimplyRugby;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class Model {

	/**
	 * Model is used for the handling of data - this is also where the programs pre-populated data is created and set
	 */
	public Model() {
		
		/**
		 * tries to create coaches file - if already exists it won't be created
		 */
		try {
		      File myObj = new File("coaches.ser");
		      myObj.createNewFile();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		/**
		 * tries to create squads file - if already exists it won't be created
		 */
		try {
		      File myObj = new File("squads.ser");
		      myObj.createNewFile();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		prePopulate();
		
	}
	
	/**
	 * readCoaches is a method which reads in all coaches from the coaches file
	 * @return coaches
	 */
		@SuppressWarnings("unchecked")
		public static ArrayList<Coach> readCoaches() {
			
			ArrayList<Coach> coaches = new ArrayList<Coach>();
			
			try
		       {
		    	   /**
		    	    * FileInputStream is initialised - reading in from stock.ser
		    	    */
		           FileInputStream fis = new FileInputStream("coaches.ser");
		           
		           /**
		            * while there is data available to read in form the file the following will happen
		            */
		           while(fis.available() > 0) {
		        	   
		        	   /**
		        	    * Object input stream is initialised and it reads in the data from the file
		        	    */
			           ObjectInputStream ois = new ObjectInputStream(fis);
			           
			           /**
			            * stock is set to the arrayList which is stored inside of the file
			            */
			           coaches = (ArrayList<Coach>) ois.readObject();
		           }
		           
		           /**
		            * Input stream is closed
		            */
		           fis.close();
		           
		       } 
		       catch (IOException ioe) {
		           ioe.printStackTrace();
		       } 
		       catch (ClassNotFoundException c) {
		           System.out.println("Class not found");
		           c.printStackTrace();
		       }
				
		    /**
		     * Returns the data which has been read in
		     */
			return coaches;
		}
		
		/**
		 * saveCoaches is a method which will save a passed in arrayList of coaches to the coaches file
		 * @param coaches list of coaches to be saved
		 */
		public static void saveCoaches(ArrayList<Coach> coaches) {
			
			/**
			 * saves coaches arrayList that has been passed in to the coaches.ser file
			 */
			try
	        {
	           FileOutputStream fos = new FileOutputStream("coaches.ser");
	           ObjectOutputStream oos = new ObjectOutputStream(fos);
	           oos.writeObject(coaches);
	           oos.close();
	           fos.close();
	        } 
	        catch (IOException ioe) 
	        {
	           ioe.printStackTrace();
	        }
			
		}
		
		/**
		 * this method is for reading in squads from the squads file
		 * @return squads
		 */
		@SuppressWarnings("unchecked")
		public static ArrayList<Squad> readSquads() {
				
			/**
			 * ArrayList squads is initialised to hold Squad objects 
			 */
				ArrayList<Squad> squads = new ArrayList<Squad>();
				
				try
			       {
			    	   /**
			    	    * FileInputStream is initialised - reading in from stock.ser
			    	    */
			           FileInputStream fis = new FileInputStream("squads.ser");
			           
			           /**
			            * while there is data available to read in form the file the following will happen
			            */
			           while(fis.available() > 0) {
			        	   
			        	   /**
			        	    * Object input stream is initialised and it reads in the data from the file
			        	    */
				           ObjectInputStream ois = new ObjectInputStream(fis);
				           
				           /**
				            * stock is set to the arrayList which is stored inside of the file
				            */
				           squads = (ArrayList<Squad>) ois.readObject();
			           }
			           
			           /**
			            * Input stream is closed
			            */
			           fis.close();
			           
			       } 
			       catch (IOException ioe) {
			           ioe.printStackTrace();
			       } 
			       catch (ClassNotFoundException c) {
			           System.out.println("Class not found");
			           c.printStackTrace();
			       }
					
			    /**
			     * Returns the data which has been read in
			     */
				return squads;
			}
		
		/**
		 * saveSquads is used to save squads to file
		 * @param squads passed in arrayList of squads will be saved to file
		 */
		public static void saveSquads(ArrayList<Squad> squads) {
			
			/**
			 * saves squads arrayList that has been passed in to the squads.ser file
			 */
			try
	        {
	           FileOutputStream fos = new FileOutputStream("squads.ser");
	           ObjectOutputStream oos = new ObjectOutputStream(fos);
	           oos.writeObject(squads);
	           oos.close();
	           fos.close();
	        } 
	        catch (IOException ioe) 
	        {
	           ioe.printStackTrace();
	        }
			
		}
	
	/**
	 * this method will pre-populate data for this prototype application 
	 */
	public static void prePopulate() {
		
		/**
		 * Creates ArrayList which will contain coach objects
		 */
		ArrayList<Coach> coaches = new ArrayList<Coach>();
		
		/**
		 * boolean is created to check if this is the applications first time running - sets to false
		 */
		boolean startUpExist = false;
		
		/**
		 * reads in coaches which are stored in file - stores results in coaches ArrayList
		 */
		coaches = readCoaches();
		
		/**
		 * loops for each coach inside of the coaches ArrayList
		 */
		for(Coach c: coaches){
			
			/**
			 * if any of the members first name begins with Bruce i will know that the application has started before
			 */
			if(c.getFirstName().equals("Bruce")) {
				
				/**
				 * since we know the application has started once before i set the boolean to true
				 */
				startUpExist = true;
				
				/**
				 * the loop is broken as we know the application has started before
				 */
				break;
			}
		}
		
		
		/**
		 * if the application has never started before (startUpExist = false) this chunk of code will run
		 */
		if(!startUpExist) {
			
			/**
			 * initialises date as null
			 */
			Date date = null;
			
			/**
			 * initialises dateOfBirth as 5th April 2000 - String
			 */
			String dateOfBirth = "05/04/2000";
			
			/**
			 * initialises date format
			 */
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			/**
			 * Try parsing the string into a date
			 */
			try {
				//Parsing the String
				date = dateFormat.parse(dateOfBirth);
			} catch (ParseException e) {										  
				e.printStackTrace();									 
			}
			
			/*
			 * 
			 * Pre-populated data will be used as this application is a prototype
			 * 
			 */
			
			/**
			 * creates coaches
			 */
			coaches.add(new Coach("Bruce", "McKenzie", "Bruce@coach.com", date , "1 coach lane, Cupar, Fife", "01234567891", "BruceMC", BCrypt.hashpw("skyIsTheLimit", BCrypt.gensalt()), "Senior Squad A"));
			coaches.add(new Coach("Kyle", "Anderson", "Kyle@coach.com", date , "2 coach Street, Glenrothes, Fife", "01234567891", "kyleA", BCrypt.hashpw("Kanderson", BCrypt.gensalt()), "Senior Squad B"));
			coaches.add(new Coach("Harry", "Potter", "Harry@coach.com", date , "3 coach Way, Tayport, Fife", "01234567891", "HPotter", BCrypt.hashpw("Ginnyftw", BCrypt.gensalt()), "Junior"));
			
			/**
			 * Initialises running skills ArrayList for each player (60 players total)
			 */
			ArrayList<Skill> BobRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JohnRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> GinnyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MariannaFigueroaRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MichaelaOconnorRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> ValentinaHowellRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> EstebanGibsonRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdisonChandlerRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlbertChandlerRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> DixieGreenRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoelleCoffeyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> DaytonClarkRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JonahBradshawRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JessicaWeeksRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdelynDorseyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> BrendonHardinRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> ElleCollierRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> TylerWeeksRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MiaDavilaRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> BaronRichardsonRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> GideonTerrellRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdysonPachecoRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> EmmaleeGlassRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> IsaiasMckayRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> RogerWagnerRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdriannaFernandezRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> KoltonKaiserRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AllisonHaleyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> NatalieNormanRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JadonCharlesRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> CohenMckinneyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AnabelVargasRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AriaKiddRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> RolandPettyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> RobertoOdomRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> CamrynWattsRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarioMortonRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> SethSpencerRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> HamzaEsparzaRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> BrandonBrockRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlannaLucasRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> CraigShawRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JaidenCarneyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> ShylaHuangRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> KasenLeRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoemiStoutRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> IbrahimDaviesRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> FranklinWhitneyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> ManuelCobbRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarkKentRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> EmilyRyanRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> KeonWernerRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> JaydonRuizRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MakaylaHarrellRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> KendallCarneyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> MichaelWallRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> WinstonHudsonRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> AntoineMelendezRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> ElisabethCareyRunningSkills = new ArrayList<Skill>();
			ArrayList<Skill> EdwardGrayRunningSkills = new ArrayList<Skill>();
			
			/**
			 * Initialises Contact skills ArrayList for each player (60 players total)
			 */
			ArrayList<Skill> BobContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> JohnContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> GinnyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> MariannaFigueroaContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> MichaelaOconnorContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> ValentinaHowellContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> EstebanGibsonContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdisonChandlerContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlbertChandlerContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> DixieGreenContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoelleCoffeyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> DaytonClarkContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> JonahBradshawContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> JessicaWeeksContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdelynDorseyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> BrendonHardinContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> ElleCollierContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> TylerWeeksContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> MiaDavilaContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> BaronRichardsonContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> GideonTerrellContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdysonPachecoContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> EmmaleeGlassContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> IsaiasMckayContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> RogerWagnerContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdriannaFernandezContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> KoltonKaiserContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AllisonHaleyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> NatalieNormanContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> JadonCharlesContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> CohenMckinneyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AnabelVargasContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AriaKiddContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> RolandPettyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> RobertoOdomContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> CamrynWattsContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarioMortonContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> SethSpencerContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> HamzaEsparzaContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> BrandonBrockContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlannaLucasContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> CraigShawContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> JaidenCarneyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> ShylaHuangContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> KasenLeContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoemiStoutContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> IbrahimDaviesContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> FranklinWhitneyContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> ManuelCobbContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarkKentContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> EmilyRyanContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> KeonWernerContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> JaydonRuizContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> MakaylaHarrellContactSkills = new ArrayList<Skill>();
			ArrayList<Skill> KendallCarneyContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> MichaelWallContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> WinstonHudsonContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> AntoineMelendezContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> ElisabethCareyContactSkills= new ArrayList<Skill>();
			ArrayList<Skill> EdwardGrayContactSkills = new ArrayList<Skill>();	
			
			/**
			 * Initialises Passing skills ArrayList for each player (60 players total)
			 */
			ArrayList<Skill> BobPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JohnPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> GinnyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MariannaFigueroaPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MichaelaOconnorPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> ValentinaHowellPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> EstebanGibsonPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdisonChandlerPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlbertChandlerPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> DixieGreenPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoelleCoffeyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> DaytonClarkPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JonahBradshawPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JessicaWeeksPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdelynDorseyPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> BrendonHardinPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> ElleCollierPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> TylerWeeksPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MiaDavilaPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> BaronRichardsonPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> GideonTerrellPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AdysonPachecoPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> EmmaleeGlassPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> IsaiasMckayPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> RogerWagnerPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> AdriannaFernandezPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> KoltonKaiserPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AllisonHaleyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> NatalieNormanPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JadonCharlesPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> CohenMckinneyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AnabelVargasPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AriaKiddPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> RolandPettyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> RobertoOdomPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> CamrynWattsPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarioMortonPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> SethSpencerPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> HamzaEsparzaPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> BrandonBrockPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AlannaLucasPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> CraigShawPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JaidenCarneyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> ShylaHuangPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> KasenLePassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> NoemiStoutPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> IbrahimDaviesPassingSkills= new ArrayList<Skill>();
			ArrayList<Skill> FranklinWhitneyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> ManuelCobbPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MarkKentPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> EmilyRyanPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> KeonWernerPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> JaydonRuizPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MakaylaHarrellPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> KendallCarneyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> MichaelWallPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> WinstonHudsonPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> AntoineMelendezPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> ElisabethCareyPassingSkills = new ArrayList<Skill>();
			ArrayList<Skill> EdwardGrayPassingSkills = new ArrayList<Skill>();	
			
			
			/**
			 * running skills arrayList for each player has skills added to them
			 */
			BobRunningSkills.add(new Skill("Speed", "3"));
			BobRunningSkills.add(new Skill("Swerving", "2"));
			BobRunningSkills.add(new Skill("Posture", "5"));
			
			MariannaFigueroaRunningSkills.add(new Skill("Speed", "3"));
			MariannaFigueroaRunningSkills.add(new Skill("Swerving", "2"));
			MariannaFigueroaRunningSkills.add(new Skill("Posture", "2"));
			
			MichaelaOconnorRunningSkills.add(new Skill("Speed", "3"));
			MichaelaOconnorRunningSkills.add(new Skill("Swerving", "2"));
			MichaelaOconnorRunningSkills.add(new Skill("Posture", "5"));
			
			ValentinaHowellRunningSkills.add(new Skill("Speed", "2"));
			ValentinaHowellRunningSkills.add(new Skill("Swerving", "2")); 
			ValentinaHowellRunningSkills.add(new Skill("Posture", "3")); 
			
			EstebanGibsonRunningSkills.add(new Skill("Speed", "1"));
			EstebanGibsonRunningSkills.add(new Skill("Swerving", "2"));
			EstebanGibsonRunningSkills.add(new Skill("Posture", "5"));
			
			AdisonChandlerRunningSkills.add(new Skill("Speed", "2")); 
			AdisonChandlerRunningSkills.add(new Skill("Swerving", "2")); 
			AdisonChandlerRunningSkills.add(new Skill("Posture", "5"));
			
			AlbertChandlerRunningSkills.add(new Skill("Speed", "3"));
			AlbertChandlerRunningSkills.add(new Skill("Swerving", "2")); 
			AlbertChandlerRunningSkills.add(new Skill("Posture", "5")); 
			
			DixieGreenRunningSkills.add(new Skill("Speed", "4"));
			DixieGreenRunningSkills.add(new Skill("Swerving", "3")); 
			DixieGreenRunningSkills.add(new Skill("Posture", "3")); 
			
			NoelleCoffeyRunningSkills.add(new Skill("Speed", "5")); 
			NoelleCoffeyRunningSkills.add(new Skill("Swerving", "2")); 
			NoelleCoffeyRunningSkills.add(new Skill("Posture", "2")); 
			
			DaytonClarkRunningSkills.add(new Skill("Speed", "1")); 
			DaytonClarkRunningSkills.add(new Skill("Swerving", "2")); 
			DaytonClarkRunningSkills.add(new Skill("Posture", "5")); 
			
			JonahBradshawRunningSkills.add(new Skill("Speed", "3")); 
			JonahBradshawRunningSkills.add(new Skill("Swerving", "5")); 
			JonahBradshawRunningSkills.add(new Skill("Posture", "5")); 
			
			JessicaWeeksRunningSkills.add(new Skill("Speed", "2")); 
			JessicaWeeksRunningSkills.add(new Skill("Swerving", "2")); 
			JessicaWeeksRunningSkills.add(new Skill("Posture", "5")); 
			
			AdelynDorseyRunningSkills.add(new Skill("Speed", "1")); 
			AdelynDorseyRunningSkills.add(new Skill("Swerving", "2")); 
			AdelynDorseyRunningSkills.add(new Skill("Posture", "5")); 
			
			BrendonHardinRunningSkills.add(new Skill("Speed", "4")); 
			BrendonHardinRunningSkills.add(new Skill("Swerving", "1")); 
			BrendonHardinRunningSkills.add(new Skill("Posture", "5")); 
			
			ElleCollierRunningSkills.add(new Skill("Speed", "3")); 
			ElleCollierRunningSkills.add(new Skill("Swerving", "2")); 
			ElleCollierRunningSkills.add(new Skill("Posture", "5")); 
			
			TylerWeeksRunningSkills.add(new Skill("Speed", "1")); 
			TylerWeeksRunningSkills.add(new Skill("Swerving", "2")); 
			TylerWeeksRunningSkills.add(new Skill("Posture", "5")); 
			
			MiaDavilaRunningSkills.add(new Skill("Speed", "2")); 
			MiaDavilaRunningSkills.add(new Skill("Swerving", "3")); 
			MiaDavilaRunningSkills.add(new Skill("Posture", "3")); 
			
			BaronRichardsonRunningSkills.add(new Skill("Speed", "3")); 
			BaronRichardsonRunningSkills.add(new Skill("Swerving", "2")); 
			BaronRichardsonRunningSkills.add(new Skill("Posture", "2"));
			
			GideonTerrellRunningSkills.add(new Skill("Speed", "4")); 
			GideonTerrellRunningSkills.add(new Skill("Swerving", "2")); 
			GideonTerrellRunningSkills.add(new Skill("Posture", "5")); 
			
			AdysonPachecoRunningSkills.add(new Skill("Speed", "5")); 
			AdysonPachecoRunningSkills.add(new Skill("Swerving", "4")); 
			AdysonPachecoRunningSkills.add(new Skill("Posture", "2")); 
			
			EmmaleeGlassRunningSkills.add(new Skill("Speed", "2")); 
			EmmaleeGlassRunningSkills.add(new Skill("Swerving", "2")); 
			EmmaleeGlassRunningSkills.add(new Skill("Posture", "1")); 
			
			IsaiasMckayRunningSkills.add(new Skill("Speed", "1")); 
			IsaiasMckayRunningSkills.add(new Skill("Swerving", "2")); 
			IsaiasMckayRunningSkills.add(new Skill("Posture", "5")); 
			
			RogerWagnerRunningSkills.add(new Skill("Speed", "1")); 
			RogerWagnerRunningSkills.add(new Skill("Swerving", "2")); 
			RogerWagnerRunningSkills.add(new Skill("Posture", "2")); 
			
			AdriannaFernandezRunningSkills.add(new Skill("Speed", "3")); 
			AdriannaFernandezRunningSkills.add(new Skill("Swerving", "1")); 
			AdriannaFernandezRunningSkills.add(new Skill("Posture", "3")); 
			
			KoltonKaiserRunningSkills.add(new Skill("Speed", "5")); 
			KoltonKaiserRunningSkills.add(new Skill("Swerving", "2")); 
			KoltonKaiserRunningSkills.add(new Skill("Posture", "5")); 
			
			AllisonHaleyRunningSkills.add(new Skill("Speed", "4")); 
			AllisonHaleyRunningSkills.add(new Skill("Swerving", "2")); 
			AllisonHaleyRunningSkills.add(new Skill("Posture", "5")); 
			
			NatalieNormanRunningSkills.add(new Skill("Speed", "3")); 
			NatalieNormanRunningSkills.add(new Skill("Swerving", "2")); 
			NatalieNormanRunningSkills.add(new Skill("Posture", "5")); 
			
			JadonCharlesRunningSkills.add(new Skill("Speed", "3")); 
			JadonCharlesRunningSkills.add(new Skill("Swerving", "2")); 
			JadonCharlesRunningSkills.add(new Skill("Posture", "5")); 
			
			CohenMckinneyRunningSkills.add(new Skill("Speed", "1")); 
			CohenMckinneyRunningSkills.add(new Skill("Swerving", "3")); 
			CohenMckinneyRunningSkills.add(new Skill("Posture", "5")); 
			
			AnabelVargasRunningSkills.add(new Skill("Speed", "1")); 
			AnabelVargasRunningSkills.add(new Skill("Swerving", "2")); 
			AnabelVargasRunningSkills.add(new Skill("Posture", "2")); 
			
			AriaKiddRunningSkills.add(new Skill("Speed", "2")); 
			AriaKiddRunningSkills.add(new Skill("Swerving", "2")); 
			AriaKiddRunningSkills.add(new Skill("Posture", "3")); 
			
			RolandPettyRunningSkills.add(new Skill("Speed", "2")); 
			RolandPettyRunningSkills.add(new Skill("Swerving", "4")); 
			RolandPettyRunningSkills.add(new Skill("Posture", "5")); 
			
			RobertoOdomRunningSkills.add(new Skill("Speed", "4")); 
			RobertoOdomRunningSkills.add(new Skill("Swerving", "2")); 
			RobertoOdomRunningSkills.add(new Skill("Posture", "5")); 
			
			CamrynWattsRunningSkills.add(new Skill("Speed", "4")); 
			CamrynWattsRunningSkills.add(new Skill("Swerving", "1")); 
			CamrynWattsRunningSkills.add(new Skill("Posture", "5")); 
			
			MarioMortonRunningSkills.add(new Skill("Speed", "5")); 
			MarioMortonRunningSkills.add(new Skill("Swerving", "2")); 
			MarioMortonRunningSkills.add(new Skill("Posture", "5")); 
			
			SethSpencerRunningSkills.add(new Skill("Speed", "3")); 
			SethSpencerRunningSkills.add(new Skill("Swerving", "2")); 
			SethSpencerRunningSkills.add(new Skill("Posture", "5")); 
			
			HamzaEsparzaRunningSkills.add(new Skill("Speed", "1")); 
			HamzaEsparzaRunningSkills.add(new Skill("Swerving", "1")); 
			HamzaEsparzaRunningSkills.add(new Skill("Posture", "5")); 
			
			BrandonBrockRunningSkills.add(new Skill("Speed", "3")); 
			BrandonBrockRunningSkills.add(new Skill("Swerving", "2")); 
			BrandonBrockRunningSkills.add(new Skill("Posture", "3")); 
			
			AlannaLucasRunningSkills.add(new Skill("Speed", "3")); 
			AlannaLucasRunningSkills.add(new Skill("Swerving", "2")); 
			AlannaLucasRunningSkills.add(new Skill("Posture", "5")); 
			
			CraigShawRunningSkills.add(new Skill("Speed", "2")); 
			CraigShawRunningSkills.add(new Skill("Swerving", "3")); 
			CraigShawRunningSkills.add(new Skill("Posture", "5")); 
			
			JaidenCarneyRunningSkills.add(new Skill("Speed", "5")); 
			JaidenCarneyRunningSkills.add(new Skill("Swerving", "2")); 
			JaidenCarneyRunningSkills.add(new Skill("Posture", "5")); 
			
			ShylaHuangRunningSkills.add(new Skill("Speed", "2")); 
			ShylaHuangRunningSkills.add(new Skill("Swerving", "2")); 
			ShylaHuangRunningSkills.add(new Skill("Posture", "5")); 
			
			KasenLeRunningSkills.add(new Skill("Speed", "1")); 
			KasenLeRunningSkills.add(new Skill("Swerving", "2")); 
			KasenLeRunningSkills.add(new Skill("Posture", "5")); 
			
			NoemiStoutRunningSkills.add(new Skill("Speed", "3")); 
			NoemiStoutRunningSkills.add(new Skill("Swerving", "4")); 
			NoemiStoutRunningSkills.add(new Skill("Posture", "3")); 
			
			IbrahimDaviesRunningSkills.add(new Skill("Speed", "4")); 
			IbrahimDaviesRunningSkills.add(new Skill("Swerving", "2")); 
			IbrahimDaviesRunningSkills.add(new Skill("Posture", "5")); 
			
			FranklinWhitneyRunningSkills.add(new Skill("Speed", "3")); 
			FranklinWhitneyRunningSkills.add(new Skill("Swerving", "2")); 
			FranklinWhitneyRunningSkills.add(new Skill("Posture", "5")); 
			
			ManuelCobbRunningSkills.add(new Skill("Speed", "2")); 
			ManuelCobbRunningSkills.add(new Skill("Swerving", "2")); 
			ManuelCobbRunningSkills.add(new Skill("Posture", "5")); 
			
			MarkKentRunningSkills.add(new Skill("Speed", "3")); 
			MarkKentRunningSkills.add(new Skill("Swerving", "5")); 
			MarkKentRunningSkills.add(new Skill("Posture", "5")); 
			
			EmilyRyanRunningSkills.add(new Skill("Speed", "1"));
			EmilyRyanRunningSkills.add(new Skill("Swerving", "2")); 
			EmilyRyanRunningSkills.add(new Skill("Posture", "5")); 
			
			KeonWernerRunningSkills.add(new Skill("Speed", "2"));
			KeonWernerRunningSkills.add(new Skill("Swerving", "2")); 
			KeonWernerRunningSkills.add(new Skill("Posture", "5")); 
			
			JaydonRuizRunningSkills.add(new Skill("Speed", "3")); 
			JaydonRuizRunningSkills.add(new Skill("Swerving", "2")); 
			JaydonRuizRunningSkills.add(new Skill("Posture", "5")); 
			
			MakaylaHarrellRunningSkills.add(new Skill("Speed", "5"));
			MakaylaHarrellRunningSkills.add(new Skill("Swerving", "5"));
			MakaylaHarrellRunningSkills.add(new Skill("Posture", "3"));
			
			KendallCarneyRunningSkills.add(new Skill("Speed", "3")); 
			KendallCarneyRunningSkills.add(new Skill("Swerving", "2")); 
			KendallCarneyRunningSkills.add(new Skill("Posture", "5")); 
			
			MichaelWallRunningSkills.add(new Skill("Speed", "4")); 
			MichaelWallRunningSkills.add(new Skill("Swerving", "2")); 
			MichaelWallRunningSkills.add(new Skill("Posture", "5")); 
			
			WinstonHudsonRunningSkills.add(new Skill("Speed", "3")); 
			WinstonHudsonRunningSkills.add(new Skill("Swerving", "2")); 
			WinstonHudsonRunningSkills.add(new Skill("Posture", "5")); 
			
			AntoineMelendezRunningSkills.add(new Skill("Speed", "5")); 
			AntoineMelendezRunningSkills.add(new Skill("Swerving", "2")); 
			AntoineMelendezRunningSkills.add(new Skill("Posture", "5")); 
			
			ElisabethCareyRunningSkills.add(new Skill("Speed", "3")); 
			ElisabethCareyRunningSkills.add(new Skill("Swerving", "1")); 
			ElisabethCareyRunningSkills.add(new Skill("Posture", "5")); 
			
			EdwardGrayRunningSkills.add(new Skill("Speed", "1")); 
			EdwardGrayRunningSkills.add(new Skill("Swerving", "4")); 
			EdwardGrayRunningSkills.add(new Skill("Posture", "3")); 
			
			JohnRunningSkills.add(new Skill("Speed", "2"));
			JohnRunningSkills.add(new Skill("Swerving", "2"));
			JohnRunningSkills.add(new Skill("Posture", "5"));
			
			GinnyRunningSkills.add(new Skill("Speed", "5"));
			GinnyRunningSkills.add(new Skill("Swerving", "2"));
			GinnyRunningSkills.add(new Skill("Posture", "5"));
			

			/**
			 * Contact skills arrayList for each player has skills added to them
			 */
			MariannaFigueroaContactSkills.add(new Skill("Grip", "2"));
			MariannaFigueroaContactSkills.add(new Skill("strength", "4"));
			MariannaFigueroaContactSkills.add(new Skill("Aim", "1"));
			
			MichaelaOconnorContactSkills.add(new Skill("Grip", "2"));
			MichaelaOconnorContactSkills.add(new Skill("strength", "4"));
			MichaelaOconnorContactSkills.add(new Skill("Aim", "4"));
			
			ValentinaHowellContactSkills.add(new Skill("Grip", "5"));
			ValentinaHowellContactSkills.add(new Skill("strength", "3"));
			ValentinaHowellContactSkills.add(new Skill("Aim", "1"));
			
			EstebanGibsonContactSkills.add(new Skill("Grip", "2"));
			EstebanGibsonContactSkills.add(new Skill("strength", "4"));
			EstebanGibsonContactSkills.add(new Skill("Aim", "4"));
			
			AdisonChandlerContactSkills.add(new Skill("Grip", "4"));
			AdisonChandlerContactSkills.add(new Skill("strength", "2"));
			AdisonChandlerContactSkills.add(new Skill("Aim", "4"));
			
			AlbertChandlerContactSkills.add(new Skill("Grip", "2"));
			AlbertChandlerContactSkills.add(new Skill("strength", "4"));
			AlbertChandlerContactSkills.add(new Skill("Aim", "3"));
			
			DixieGreenContactSkills.add(new Skill("Grip", "5"));
			DixieGreenContactSkills.add(new Skill("strength", "4"));
			DixieGreenContactSkills.add(new Skill("Aim", "4"));
			
			NoelleCoffeyContactSkills.add(new Skill("Grip", "2"));
			NoelleCoffeyContactSkills.add(new Skill("strength", "4"));
			NoelleCoffeyContactSkills.add(new Skill("Aim", "4"));
			
			DaytonClarkContactSkills.add(new Skill("Grip", "2"));
			DaytonClarkContactSkills.add(new Skill("strength", "3"));
			DaytonClarkContactSkills.add(new Skill("Aim", "4"));
			
			JonahBradshawContactSkills.add(new Skill("Grip", "2"));
			JonahBradshawContactSkills.add(new Skill("strength", "5"));
			JonahBradshawContactSkills.add(new Skill("Aim", "1"));
			
			JessicaWeeksContactSkills.add(new Skill("Grip", "2"));
			JessicaWeeksContactSkills.add(new Skill("strength", "4"));
			JessicaWeeksContactSkills.add(new Skill("Aim", "4"));
			
			AdelynDorseyContactSkills.add(new Skill("Grip", "2"));
			AdelynDorseyContactSkills.add(new Skill("strength", "4"));
			AdelynDorseyContactSkills.add(new Skill("Aim", "2"));
			
			BrendonHardinContactSkills.add(new Skill("Grip", "1"));
			BrendonHardinContactSkills.add(new Skill("strength", "4"));
			BrendonHardinContactSkills.add(new Skill("Aim", "4"));
			
			ElleCollierContactSkills.add(new Skill("Grip", "2"));
			ElleCollierContactSkills.add(new Skill("strength", "3"));
			ElleCollierContactSkills.add(new Skill("Aim", "4"));
			
			TylerWeeksContactSkills.add(new Skill("Grip", "2"));
			TylerWeeksContactSkills.add(new Skill("strength", "3"));
			TylerWeeksContactSkills.add(new Skill("Aim", "4"));
			
			MiaDavilaContactSkills.add(new Skill("Grip", "2"));
			MiaDavilaContactSkills.add(new Skill("strength", "4"));
			MiaDavilaContactSkills.add(new Skill("Aim", "2"));
			
			BaronRichardsonContactSkills.add(new Skill("Grip", "2"));
			BaronRichardsonContactSkills.add(new Skill("strength", "4"));
			BaronRichardsonContactSkills.add(new Skill("Aim", "4"));
			
			GideonTerrellContactSkills.add(new Skill("Grip", "2"));
			GideonTerrellContactSkills.add(new Skill("strength", "4"));
			GideonTerrellContactSkills.add(new Skill("Aim", "4"));
			
			AdysonPachecoContactSkills.add(new Skill("Grip", "2"));
			AdysonPachecoContactSkills.add(new Skill("strength", "4"));
			AdysonPachecoContactSkills.add(new Skill("Aim", "4"));
			
			EmmaleeGlassContactSkills.add(new Skill("Grip", "4"));
			EmmaleeGlassContactSkills.add(new Skill("strength", "5"));
			EmmaleeGlassContactSkills.add(new Skill("Aim", "5"));
			
			IsaiasMckayContactSkills.add(new Skill("Grip", "2"));
			IsaiasMckayContactSkills.add(new Skill("strength", "3"));
			IsaiasMckayContactSkills.add(new Skill("Aim", "4"));
			
			RogerWagnerContactSkills.add(new Skill("Grip", "1"));
			RogerWagnerContactSkills.add(new Skill("strength", "4"));
			RogerWagnerContactSkills.add(new Skill("Aim", "4"));
			
			AdriannaFernandezContactSkills.add(new Skill("Grip", "2"));
			AdriannaFernandezContactSkills.add(new Skill("strength", "4"));
			AdriannaFernandezContactSkills.add(new Skill("Aim", "4"));
			
			KoltonKaiserContactSkills.add(new Skill("Grip", "2"));
			KoltonKaiserContactSkills.add(new Skill("strength", "4"));
			KoltonKaiserContactSkills.add(new Skill("Aim", "4"));
			
			AllisonHaleyContactSkills.add(new Skill("Grip", "2"));
			AllisonHaleyContactSkills.add(new Skill("strength", "3"));
			AllisonHaleyContactSkills.add(new Skill("Aim", "2"));
			
			NatalieNormanContactSkills.add(new Skill("Grip", "2"));
			NatalieNormanContactSkills.add(new Skill("strength", "4"));
			NatalieNormanContactSkills.add(new Skill("Aim", "1"));
			
			JadonCharlesContactSkills.add(new Skill("Grip", "2"));
			JadonCharlesContactSkills.add(new Skill("strength", "2"));
			JadonCharlesContactSkills.add(new Skill("Aim", "1"));
			
			CohenMckinneyContactSkills.add(new Skill("Grip", "3"));
			CohenMckinneyContactSkills.add(new Skill("strength", "4"));
			CohenMckinneyContactSkills.add(new Skill("Aim", "4"));
			
			AnabelVargasContactSkills.add(new Skill("Grip", "2"));
			AnabelVargasContactSkills.add(new Skill("strength", "3"));
			AnabelVargasContactSkills.add(new Skill("Aim", "4"));
			
			AriaKiddContactSkills.add(new Skill("Grip", "2"));
			AriaKiddContactSkills.add(new Skill("strength", "4"));
			AriaKiddContactSkills.add(new Skill("Aim", "5"));
			
			RolandPettyContactSkills.add(new Skill("Grip", "2"));
			RolandPettyContactSkills.add(new Skill("strength", "4"));
			RolandPettyContactSkills.add(new Skill("Aim", "4"));
			
			RobertoOdomContactSkills.add(new Skill("Grip", "2"));
			RobertoOdomContactSkills.add(new Skill("strength", "5"));
			RobertoOdomContactSkills.add(new Skill("Aim", "4"));
			
			CamrynWattsContactSkills.add(new Skill("Grip", "2"));
			CamrynWattsContactSkills.add(new Skill("strength", "4"));
			CamrynWattsContactSkills.add(new Skill("Aim", "4"));
			
			MarioMortonContactSkills.add(new Skill("Grip", "2"));
			MarioMortonContactSkills.add(new Skill("strength", "4"));
			MarioMortonContactSkills.add(new Skill("Aim", "4"));
			
			SethSpencerContactSkills.add(new Skill("Grip", "2"));
			SethSpencerContactSkills.add(new Skill("strength", "3"));
			SethSpencerContactSkills.add(new Skill("Aim", "4"));
			
			HamzaEsparzaContactSkills.add(new Skill("Grip", "2"));
			HamzaEsparzaContactSkills.add(new Skill("strength", "4"));
			HamzaEsparzaContactSkills.add(new Skill("Aim", "4"));
			
			BrandonBrockContactSkills.add(new Skill("Grip", "1"));
			BrandonBrockContactSkills.add(new Skill("strength", "2"));
			BrandonBrockContactSkills.add(new Skill("Aim", "1"));
			
			AlannaLucasContactSkills.add(new Skill("Grip", "2"));
			AlannaLucasContactSkills.add(new Skill("strength", "4"));
			AlannaLucasContactSkills.add(new Skill("Aim", "4"));
			
			CraigShawContactSkills.add(new Skill("Grip", "2"));
			CraigShawContactSkills.add(new Skill("strength", "4"));
			CraigShawContactSkills.add(new Skill("Aim", "4"));
			
			JaidenCarneyContactSkills.add(new Skill("Grip", "2"));
			JaidenCarneyContactSkills.add(new Skill("strength", "4"));
			JaidenCarneyContactSkills.add(new Skill("Aim", "4"));
			
			ShylaHuangContactSkills.add(new Skill("Grip", "2"));
			ShylaHuangContactSkills.add(new Skill("strength", "3"));
			ShylaHuangContactSkills.add(new Skill("Aim", "3"));
			
			KasenLeContactSkills.add(new Skill("Grip", "2"));
			KasenLeContactSkills.add(new Skill("strength", "4"));
			KasenLeContactSkills.add(new Skill("Aim", "4"));
			
			NoemiStoutContactSkills.add(new Skill("Grip", "2"));
			NoemiStoutContactSkills.add(new Skill("strength", "4"));
			NoemiStoutContactSkills.add(new Skill("Aim", "5"));
			
			IbrahimDaviesContactSkills.add(new Skill("Grip", "3"));
			IbrahimDaviesContactSkills.add(new Skill("strength", "3"));
			IbrahimDaviesContactSkills.add(new Skill("Aim", "4"));
			
			FranklinWhitneyContactSkills.add(new Skill("Grip", "2"));
			FranklinWhitneyContactSkills.add(new Skill("strength", "4"));
			FranklinWhitneyContactSkills.add(new Skill("Aim", "4"));
			
			ManuelCobbContactSkills.add(new Skill("Grip", "2"));
			ManuelCobbContactSkills.add(new Skill("strength", "3"));
			ManuelCobbContactSkills.add(new Skill("Aim", "4"));
			
			MarkKentContactSkills.add(new Skill("Grip", "2"));
			MarkKentContactSkills.add(new Skill("strength", "2"));
			MarkKentContactSkills.add(new Skill("Aim", "4"));
			
			EmilyRyanContactSkills.add(new Skill("Grip", "1"));
			EmilyRyanContactSkills.add(new Skill("strength", "4"));
			EmilyRyanContactSkills.add(new Skill("Aim", "5"));
			
			KeonWernerContactSkills.add(new Skill("Grip", "2"));
			KeonWernerContactSkills.add(new Skill("strength", "4"));
			KeonWernerContactSkills.add(new Skill("Aim", "4"));
			
			JaydonRuizContactSkills.add(new Skill("Grip", "2"));
			JaydonRuizContactSkills.add(new Skill("strength", "4"));
			JaydonRuizContactSkills.add(new Skill("Aim", "4"));
			
			MakaylaHarrellContactSkills.add(new Skill("Grip", "2"));
			MakaylaHarrellContactSkills.add(new Skill("strength", "3"));
			MakaylaHarrellContactSkills.add(new Skill("Aim", "4"));
			
			KendallCarneyContactSkills.add(new Skill("Grip", "2"));
			KendallCarneyContactSkills.add(new Skill("strength", "4"));
			KendallCarneyContactSkills.add(new Skill("Aim", "4"));
			
			MichaelWallContactSkills.add(new Skill("Grip", "2"));
			MichaelWallContactSkills.add(new Skill("strength", "3"));
			MichaelWallContactSkills.add(new Skill("Aim", "3"));
			
			WinstonHudsonContactSkills.add(new Skill("Grip", "2"));
			WinstonHudsonContactSkills.add(new Skill("strength", "1"));
			WinstonHudsonContactSkills.add(new Skill("Aim", "4"));
			
			AntoineMelendezContactSkills.add(new Skill("Grip", "2"));
			AntoineMelendezContactSkills.add(new Skill("strength", "4"));
			AntoineMelendezContactSkills.add(new Skill("Aim", "4"));
			
			ElisabethCareyContactSkills.add(new Skill("Grip", "4"));
			ElisabethCareyContactSkills.add(new Skill("strength", "1"));
			ElisabethCareyContactSkills.add(new Skill("Aim", "4"));
			
			EdwardGrayContactSkills.add(new Skill("Grip", "2"));
			EdwardGrayContactSkills.add(new Skill("strength", "3"));
			EdwardGrayContactSkills.add(new Skill("Aim", "2"));

			BobContactSkills.add(new Skill("Grip", "2"));
			BobContactSkills.add(new Skill("strength", "4"));
			BobContactSkills.add(new Skill("Aim", "4"));
			
			JohnContactSkills.add(new Skill("Grip", "2"));
			JohnContactSkills.add(new Skill("strength", "4"));
			JohnContactSkills.add(new Skill("Aim", "4"));
			
			GinnyContactSkills.add(new Skill("Grip", "2"));
			GinnyContactSkills.add(new Skill("strength", "4"));
			GinnyContactSkills.add(new Skill("Aim", "3"));
			
			/**
			 * Passing skills arrayList for each player has skills added to them (3 skills per player - 180 total)
			 */
			BobPassingSkills.add(new Skill("Accuracy", "2"));
			JohnPassingSkills.add(new Skill("Spin Pass", "2"));
			GinnyPassingSkills.add(new Skill("Basic Pass", "2"));
			
			MariannaFigueroaPassingSkills.add(new Skill("Accuracy", "3"));
			MichaelaOconnorPassingSkills.add(new Skill("Accuracy", "5"));
			ValentinaHowellPassingSkills.add(new Skill("Accuracy", "4"));
			EstebanGibsonPassingSkills.add(new Skill("Accuracy", "1"));
			AdisonChandlerPassingSkills.add(new Skill("Accuracy", "2"));
			AlbertChandlerPassingSkills.add(new Skill("Accuracy", "3"));
			DixieGreenPassingSkills.add(new Skill("Accuracy", "2"));
			NoelleCoffeyPassingSkills.add(new Skill("Accuracy", "2"));
			DaytonClarkPassingSkills.add(new Skill("Accuracy", "4"));
			JonahBradshawPassingSkills.add(new Skill("Accuracy", "2"));
			JessicaWeeksPassingSkills.add(new Skill("Accuracy", "1"));
			AdelynDorseyPassingSkills.add(new Skill("Accuracy", "5"));
			BrendonHardinPassingSkills.add(new Skill("Accuracy", "2"));
			ElleCollierPassingSkills.add(new Skill("Accuracy", "2"));
			TylerWeeksPassingSkills.add(new Skill("Accuracy", "1"));
			MiaDavilaPassingSkills.add(new Skill("Accuracy", "3"));
			BaronRichardsonPassingSkills.add(new Skill("Accuracy", "2"));
			GideonTerrellPassingSkills.add(new Skill("Accuracy", "2"));
			AdysonPachecoPassingSkills.add(new Skill("Accuracy", "5"));
			EmmaleeGlassPassingSkills.add(new Skill("Accuracy", "4"));
			IsaiasMckayPassingSkills.add(new Skill("Accuracy", "1"));
			RogerWagnerPassingSkills.add(new Skill("Accuracy", "2"));
			AdriannaFernandezPassingSkills.add(new Skill("Accuracy", "2"));
			KoltonKaiserPassingSkills.add(new Skill("Accuracy", "3"));
			AllisonHaleyPassingSkills.add(new Skill("Accuracy", "3"));
			NatalieNormanPassingSkills.add(new Skill("Accuracy", "2"));
			JadonCharlesPassingSkills.add(new Skill("Accuracy", "1"));
			CohenMckinneyPassingSkills.add(new Skill("Accuracy", "2"));
			AnabelVargasPassingSkills.add(new Skill("Accuracy", "2"));
			AriaKiddPassingSkills.add(new Skill("Accuracy", "2"));
			RolandPettyPassingSkills.add(new Skill("Accuracy", "2"));
			RobertoOdomPassingSkills.add(new Skill("Accuracy", "1"));
			CamrynWattsPassingSkills.add(new Skill("Accuracy", "3"));
			MarioMortonPassingSkills.add(new Skill("Accuracy", "5"));
			SethSpencerPassingSkills.add(new Skill("Accuracy", "2"));
			HamzaEsparzaPassingSkills.add(new Skill("Accuracy", "1"));
			BrandonBrockPassingSkills.add(new Skill("Accuracy", "2"));
			AlannaLucasPassingSkills.add(new Skill("Accuracy", "3"));
			CraigShawPassingSkills.add(new Skill("Accuracy", "4"));
			JaidenCarneyPassingSkills.add(new Skill("Accuracy", "2"));
			ShylaHuangPassingSkills.add(new Skill("Accuracy", "1"));
			KasenLePassingSkills.add(new Skill("Accuracy", "2"));
			NoemiStoutPassingSkills.add(new Skill("Accuracy", "2"));
			IbrahimDaviesPassingSkills.add(new Skill("Accuracy", "2"));
			FranklinWhitneyPassingSkills.add(new Skill("Accuracy", "4"));
			ManuelCobbPassingSkills.add(new Skill("Accuracy", "5"));
			MarkKentPassingSkills.add(new Skill("Accuracy", "4"));
			EmilyRyanPassingSkills.add(new Skill("Accuracy", "2"));
			KeonWernerPassingSkills.add(new Skill("Accuracy", "5"));
			JaydonRuizPassingSkills.add(new Skill("Accuracy", "2"));
			MakaylaHarrellPassingSkills.add(new Skill("Accuracy", "2"));
			KendallCarneyPassingSkills.add(new Skill("Accuracy", "1"));
			MichaelWallPassingSkills.add(new Skill("Accuracy", "4"));
			WinstonHudsonPassingSkills.add(new Skill("Accuracy", "2"));
			AntoineMelendezPassingSkills.add(new Skill("Accuracy", "2"));
			ElisabethCareyPassingSkills.add(new Skill("Accuracy", "1"));
			EdwardGrayPassingSkills.add(new Skill("Accuracy", "4"));
			
			
			BobPassingSkills.add(new Skill("Spin Pass", "2"));
			JohnPassingSkills.add(new Skill("Spin Pass", "2"));
			GinnyPassingSkills.add(new Skill("Spin Pass", "2"));
			MariannaFigueroaPassingSkills.add(new Skill("Spin Pass", "4"));
			MichaelaOconnorPassingSkills.add(new Skill("Spin Pass", "5"));
			ValentinaHowellPassingSkills.add(new Skill("Spin Pass", "2"));
			EstebanGibsonPassingSkills.add(new Skill("Spin Pass", "4"));
			AdisonChandlerPassingSkills.add(new Skill("Spin Pass", "3"));
			AlbertChandlerPassingSkills.add(new Skill("Spin Pass", "2"));
			DixieGreenPassingSkills.add(new Skill("Spin Pass", "5"));
			NoelleCoffeyPassingSkills.add(new Skill("Spin Pass", "3"));
			DaytonClarkPassingSkills.add(new Skill("Spin Pass", "2"));
			JonahBradshawPassingSkills.add(new Skill("Spin Pass", "4"));
			JessicaWeeksPassingSkills.add(new Skill("Spin Pass", "2"));
			AdelynDorseyPassingSkills.add(new Skill("Spin Pass", "4"));
			BrendonHardinPassingSkills.add(new Skill("Spin Pass", "2"));
			ElleCollierPassingSkills.add(new Skill("Spin Pass", "5"));
			TylerWeeksPassingSkills.add(new Skill("Spin Pass", "2"));
			MiaDavilaPassingSkills.add(new Skill("Spin Pass", "4"));
			BaronRichardsonPassingSkills.add(new Skill("Spin Pass", "2"));
			GideonTerrellPassingSkills.add(new Skill("Spin Pass", "2"));
			AdysonPachecoPassingSkills.add(new Skill("Spin Pass", "2"));
			EmmaleeGlassPassingSkills.add(new Skill("Spin Pass", "2"));
			IsaiasMckayPassingSkills.add(new Skill("Spin Pass", "2"));
			RogerWagnerPassingSkills.add(new Skill("Spin Pass", "4"));
			AdriannaFernandezPassingSkills.add(new Skill("Spin Pass", "2"));
			KoltonKaiserPassingSkills.add(new Skill("Spin Pass", "2"));
			AllisonHaleyPassingSkills.add(new Skill("Spin Pass", "5"));
			NatalieNormanPassingSkills.add(new Skill("Spin Pass", "2"));
			JadonCharlesPassingSkills.add(new Skill("Spin Pass", "3"));
			CohenMckinneyPassingSkills.add(new Skill("Spin Pass", "2"));
			AnabelVargasPassingSkills.add(new Skill("Spin Pass", "4"));
			AriaKiddPassingSkills.add(new Skill("Spin Pass", "2"));
			RolandPettyPassingSkills.add(new Skill("Spin Pass", "2"));
			RobertoOdomPassingSkills.add(new Skill("Spin Pass", "4"));
			CamrynWattsPassingSkills.add(new Skill("Spin Pass", "4"));
			MarioMortonPassingSkills.add(new Skill("Spin Pass", "1"));
			SethSpencerPassingSkills.add(new Skill("Spin Pass", "1"));
			HamzaEsparzaPassingSkills.add(new Skill("Spin Pass", "2"));
			BrandonBrockPassingSkills.add(new Skill("Spin Pass", "5"));
			AlannaLucasPassingSkills.add(new Skill("Spin Pass", "2"));
			CraigShawPassingSkills.add(new Skill("Spin Pass", "2"));
			JaidenCarneyPassingSkills.add(new Skill("Spin Pass", "4"));
			ShylaHuangPassingSkills.add(new Skill("Spin Pass", "4"));
			KasenLePassingSkills.add(new Skill("Spin Pass", "5"));
			NoemiStoutPassingSkills.add(new Skill("Spin Pass", "2"));
			IbrahimDaviesPassingSkills.add(new Skill("Spin Pass", "2"));
			FranklinWhitneyPassingSkills.add(new Skill("Spin Pass", "5"));
			ManuelCobbPassingSkills.add(new Skill("Spin Pass", "2"));
			MarkKentPassingSkills.add(new Skill("Spin Pass", "2"));
			EmilyRyanPassingSkills.add(new Skill("Spin Pass", "5"));
			KeonWernerPassingSkills.add(new Skill("Spin Pass", "4"));
			JaydonRuizPassingSkills.add(new Skill("Spin Pass", "2"));
			MakaylaHarrellPassingSkills.add(new Skill("Spin Pass", "2"));
			KendallCarneyPassingSkills.add(new Skill("Spin Pass", "2"));
			MichaelWallPassingSkills.add(new Skill("Spin Pass", "3"));
			WinstonHudsonPassingSkills.add(new Skill("Spin Pass", "2"));
			AntoineMelendezPassingSkills.add(new Skill("Spin Pass", "4"));
			ElisabethCareyPassingSkills.add(new Skill("Spin Pass", "5"));
			EdwardGrayPassingSkills.add(new Skill("Spin Pass", "4"));
			
			BobPassingSkills.add(new Skill("Basic Pass", "2"));
			JohnPassingSkills.add(new Skill("Basic Pass", "5"));
			GinnyPassingSkills.add(new Skill("Basic Pass", "2"));
			MariannaFigueroaPassingSkills.add(new Skill("Basic Pass", "2"));
			MichaelaOconnorPassingSkills.add(new Skill("Basic Pass", "2"));
			ValentinaHowellPassingSkills.add(new Skill("Basic Pass", "2"));
			EstebanGibsonPassingSkills.add(new Skill("Basic Pass", "1"));
			AdisonChandlerPassingSkills.add(new Skill("Basic Pass", "2"));
			AlbertChandlerPassingSkills.add(new Skill("Basic Pass", "2"));
			DixieGreenPassingSkills.add(new Skill("Basic Pass", "2"));
			NoelleCoffeyPassingSkills.add(new Skill("Basic Pass", "2"));
			DaytonClarkPassingSkills.add(new Skill("Basic Pass", "3"));
			JonahBradshawPassingSkills.add(new Skill("Basic Pass", "5"));
			JessicaWeeksPassingSkills.add(new Skill("Basic Pass", "2"));
			AdelynDorseyPassingSkills.add(new Skill("Basic Pass", "1"));
			BrendonHardinPassingSkills.add(new Skill("Basic Pass", "2"));
			ElleCollierPassingSkills.add(new Skill("Basic Pass", "2"));
			TylerWeeksPassingSkills.add(new Skill("Basic Pass", "2"));
			MiaDavilaPassingSkills.add(new Skill("Basic Pass", "2"));
			BaronRichardsonPassingSkills.add(new Skill("Basic Pass", "2"));
			GideonTerrellPassingSkills.add(new Skill("Basic Pass", "2"));
			AdysonPachecoPassingSkills.add(new Skill("Basic Pass", "4"));
			EmmaleeGlassPassingSkills.add(new Skill("Basic Pass", "5"));
			IsaiasMckayPassingSkills.add(new Skill("Basic Pass", "2"));
			RogerWagnerPassingSkills.add(new Skill("Basic Pass", "3"));
			AdriannaFernandezPassingSkills.add(new Skill("Basic Pass", "2"));
			KoltonKaiserPassingSkills.add(new Skill("Basic Pass", "2"));
			AllisonHaleyPassingSkills.add(new Skill("Basic Pass", "5"));
			NatalieNormanPassingSkills.add(new Skill("Basic Pass", "2"));
			JadonCharlesPassingSkills.add(new Skill("Basic Pass", "1"));
			CohenMckinneyPassingSkills.add(new Skill("Basic Pass", "2"));
			AnabelVargasPassingSkills.add(new Skill("Basic Pass", "2"));
			AriaKiddPassingSkills.add(new Skill("Basic Pass", "2"));
			RolandPettyPassingSkills.add(new Skill("Basic Pass", "2"));
			RobertoOdomPassingSkills.add(new Skill("Basic Pass", "4"));
			CamrynWattsPassingSkills.add(new Skill("Basic Pass", "5"));
			MarioMortonPassingSkills.add(new Skill("Basic Pass", "2"));
			SethSpencerPassingSkills.add(new Skill("Basic Pass", "3"));
			HamzaEsparzaPassingSkills.add(new Skill("Basic Pass", "2"));
			BrandonBrockPassingSkills.add(new Skill("Basic Pass", "4"));
			AlannaLucasPassingSkills.add(new Skill("Basic Pass", "2"));
			CraigShawPassingSkills.add(new Skill("Basic Pass", "2"));
			JaidenCarneyPassingSkills.add(new Skill("Basic Pass", "2"));
			ShylaHuangPassingSkills.add(new Skill("Basic Pass", "5"));
			KasenLePassingSkills.add(new Skill("Basic Pass", "2"));
			NoemiStoutPassingSkills.add(new Skill("Basic Pass", "2"));
			IbrahimDaviesPassingSkills.add(new Skill("Basic Pass", "2"));
			FranklinWhitneyPassingSkills.add(new Skill("Basic Pass", "3"));
			ManuelCobbPassingSkills.add(new Skill("Basic Pass", "2"));
			MarkKentPassingSkills.add(new Skill("Basic Pass", "5"));
			EmilyRyanPassingSkills.add(new Skill("Basic Pass", "4"));
			KeonWernerPassingSkills.add(new Skill("Basic Pass", "2"));
			JaydonRuizPassingSkills.add(new Skill("Basic Pass", "2"));
			MakaylaHarrellPassingSkills.add(new Skill("Basic Pass", "2"));
			KendallCarneyPassingSkills.add(new Skill("Basic Pass", "3"));
			MichaelWallPassingSkills.add(new Skill("Basic Pass", "2"));
			WinstonHudsonPassingSkills.add(new Skill("Basic Pass", "5"));
			AntoineMelendezPassingSkills.add(new Skill("Basic Pass", "2"));
			ElisabethCareyPassingSkills.add(new Skill("Basic Pass", "4"));
			EdwardGrayPassingSkills.add(new Skill("Basic Pass", "5"));
			
			
			/**
			 * SkillCategories are initialised for each player (60 players)
			 */
			ArrayList<SkillCategory> MariannaFigueroaSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MichaelaOconnorSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> ValentinaHowellSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> EstebanGibsonSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AdisonChandlerSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AlbertChandlerSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> DixieGreenSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> NoelleCoffeySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> DaytonClarkSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> JonahBradshawSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> JessicaWeeksSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AdelynDorseySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> BrendonHardinSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> ElleCollierSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> TylerWeeksSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MiaDavilaSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> BaronRichardsonSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> GideonTerrellSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AdysonPachecoSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> EmmaleeGlassSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> IsaiasMckaySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> RogerWagnerSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AdriannaFernandezSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> KoltonKaiserSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AllisonHaleySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> NatalieNormanSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> JadonCharlesSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> CohenMckinneySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AnabelVargasSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AriaKiddSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> RolandPettySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> RobertoOdomSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> CamrynWattsSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MarioMortonSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> SethSpencerSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> HamzaEsparzaSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> BrandonBrockSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AlannaLucasSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> CraigShawSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> JaidenCarneySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> ShylaHuangSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> KasenLeSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> NoemiStoutSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> IbrahimDaviesSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> FranklinWhitneySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> ManuelCobbSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MarkKentSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> EmilyRyanSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> KeonWernerSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> JaydonRuizSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MakaylaHarrellSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> KendallCarneySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> MichaelWallSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> WinstonHudsonSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> AntoineMelendezSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> ElisabethCareySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> EdwardGraySkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> johnSmithSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> BobDylanSkillCategory = new ArrayList<SkillCategory>();
			ArrayList<SkillCategory> GinnyPotterSkillCategory = new ArrayList<SkillCategory>();
			
			
			/**
			 * Skill categories are added to each player (3 categories per player - 180 total)
			 */
			MariannaFigueroaSkillCategory.add(new SkillCategory("Running", "", MariannaFigueroaRunningSkills));
			MichaelaOconnorSkillCategory.add(new SkillCategory("Running", "", MichaelaOconnorRunningSkills));
			ValentinaHowellSkillCategory.add(new SkillCategory("Running", "", ValentinaHowellRunningSkills));
			EstebanGibsonSkillCategory.add(new SkillCategory("Running", "", EstebanGibsonRunningSkills));
			AdisonChandlerSkillCategory.add(new SkillCategory("Running", "", AdisonChandlerRunningSkills));
			AlbertChandlerSkillCategory.add(new SkillCategory("Running", "", AlbertChandlerRunningSkills));
			DixieGreenSkillCategory.add(new SkillCategory("Running", "", DixieGreenRunningSkills));
			NoelleCoffeySkillCategory.add(new SkillCategory("Running", "", NoelleCoffeyRunningSkills));
			DaytonClarkSkillCategory.add(new SkillCategory("Running", "", DaytonClarkRunningSkills));
			JonahBradshawSkillCategory.add(new SkillCategory("Running", "", JonahBradshawRunningSkills));
			JessicaWeeksSkillCategory.add(new SkillCategory("Running", "", JessicaWeeksRunningSkills));
			AdelynDorseySkillCategory.add(new SkillCategory("Running", "", AdelynDorseyRunningSkills));
			BrendonHardinSkillCategory.add(new SkillCategory("Running", "", BrendonHardinRunningSkills));
			ElleCollierSkillCategory.add(new SkillCategory("Running", "", ElleCollierRunningSkills));
			TylerWeeksSkillCategory.add(new SkillCategory("Running", "", TylerWeeksRunningSkills));
			MiaDavilaSkillCategory.add(new SkillCategory("Running", "", MiaDavilaRunningSkills));
			BaronRichardsonSkillCategory.add(new SkillCategory("Running", "", BaronRichardsonRunningSkills));
			GideonTerrellSkillCategory.add(new SkillCategory("Running", "", GideonTerrellRunningSkills));
			AdysonPachecoSkillCategory.add(new SkillCategory("Running", "", AdysonPachecoRunningSkills));
			EmmaleeGlassSkillCategory.add(new SkillCategory("Running", "", EmmaleeGlassRunningSkills));
			IsaiasMckaySkillCategory.add(new SkillCategory("Running", "", IsaiasMckayRunningSkills));
			RogerWagnerSkillCategory.add(new SkillCategory("Running", "", RogerWagnerRunningSkills));
			AdriannaFernandezSkillCategory.add(new SkillCategory("Running", "", AdriannaFernandezRunningSkills));
			KoltonKaiserSkillCategory.add(new SkillCategory("Running", "", KoltonKaiserRunningSkills));
			AllisonHaleySkillCategory.add(new SkillCategory("Running", "", AllisonHaleyRunningSkills));
			NatalieNormanSkillCategory.add(new SkillCategory("Running", "", NatalieNormanRunningSkills));
			JadonCharlesSkillCategory.add(new SkillCategory("Running", "", JadonCharlesRunningSkills));
			CohenMckinneySkillCategory.add(new SkillCategory("Running", "", CohenMckinneyRunningSkills));
			AnabelVargasSkillCategory.add(new SkillCategory("Running", "", AnabelVargasRunningSkills));
			AriaKiddSkillCategory.add(new SkillCategory("Running", "", AriaKiddRunningSkills));
			RolandPettySkillCategory.add(new SkillCategory("Running", "", RolandPettyRunningSkills));
			RobertoOdomSkillCategory.add(new SkillCategory("Running", "", RobertoOdomRunningSkills));
			CamrynWattsSkillCategory.add(new SkillCategory("Running", "", CamrynWattsRunningSkills));
			MarioMortonSkillCategory.add(new SkillCategory("Running", "", MarioMortonRunningSkills));
			SethSpencerSkillCategory.add(new SkillCategory("Running", "", SethSpencerRunningSkills));
			HamzaEsparzaSkillCategory.add(new SkillCategory("Running", "", HamzaEsparzaRunningSkills));
			BrandonBrockSkillCategory.add(new SkillCategory("Running", "", BrandonBrockRunningSkills));
			AlannaLucasSkillCategory.add(new SkillCategory("Running", "", AlannaLucasRunningSkills));
			CraigShawSkillCategory.add(new SkillCategory("Running", "", CraigShawRunningSkills));
			JaidenCarneySkillCategory.add(new SkillCategory("Running", "", JaidenCarneyRunningSkills));
			ShylaHuangSkillCategory.add(new SkillCategory("Running", "", ShylaHuangRunningSkills));
			KasenLeSkillCategory.add(new SkillCategory("Running", "", KasenLeRunningSkills));
			NoemiStoutSkillCategory.add(new SkillCategory("Running", "", NoemiStoutRunningSkills));
			IbrahimDaviesSkillCategory.add(new SkillCategory("Running", "", IbrahimDaviesRunningSkills));
			FranklinWhitneySkillCategory.add(new SkillCategory("Running", "", FranklinWhitneyRunningSkills));
			ManuelCobbSkillCategory.add(new SkillCategory("Running", "", ManuelCobbRunningSkills));
			MarkKentSkillCategory.add(new SkillCategory("Running", "", MarkKentRunningSkills));
			EmilyRyanSkillCategory.add(new SkillCategory("Running", "", EmilyRyanRunningSkills));
			KeonWernerSkillCategory.add(new SkillCategory("Running", "", KeonWernerRunningSkills));
			JaydonRuizSkillCategory.add(new SkillCategory("Running", "", JaydonRuizRunningSkills));
			MakaylaHarrellSkillCategory.add(new SkillCategory("Running", "", MakaylaHarrellRunningSkills));
			KendallCarneySkillCategory.add(new SkillCategory("Running", "", KendallCarneyRunningSkills));
			MichaelWallSkillCategory.add(new SkillCategory("Running", "", MichaelWallRunningSkills));
			WinstonHudsonSkillCategory.add(new SkillCategory("Running", "", WinstonHudsonRunningSkills));
			AntoineMelendezSkillCategory.add(new SkillCategory("Running", "", AntoineMelendezRunningSkills));
			ElisabethCareySkillCategory.add(new SkillCategory("Running", "", ElisabethCareyRunningSkills));
			EdwardGraySkillCategory.add(new SkillCategory("Running", "", EdwardGrayRunningSkills));
			
			MariannaFigueroaSkillCategory.add(new SkillCategory("Contact", "", MariannaFigueroaContactSkills));
			MichaelaOconnorSkillCategory.add(new SkillCategory("Contact", "", MichaelaOconnorContactSkills));
			ValentinaHowellSkillCategory.add(new SkillCategory("Contact", "", ValentinaHowellContactSkills));
			EstebanGibsonSkillCategory.add(new SkillCategory("Contact", "", EstebanGibsonContactSkills));
			AdisonChandlerSkillCategory.add(new SkillCategory("Contact", "", AdisonChandlerContactSkills));
			AlbertChandlerSkillCategory.add(new SkillCategory("Contact", "", AlbertChandlerContactSkills));
			DixieGreenSkillCategory.add(new SkillCategory("Contact", "", DixieGreenContactSkills));
			NoelleCoffeySkillCategory.add(new SkillCategory("Contact", "", NoelleCoffeyContactSkills));
			DaytonClarkSkillCategory.add(new SkillCategory("Contact", "", DaytonClarkContactSkills));
			JonahBradshawSkillCategory.add(new SkillCategory("Contact", "", JonahBradshawContactSkills));
			JessicaWeeksSkillCategory.add(new SkillCategory("Contact", "", JessicaWeeksContactSkills));
			AdelynDorseySkillCategory.add(new SkillCategory("Contact", "", AdelynDorseyContactSkills));
			BrendonHardinSkillCategory.add(new SkillCategory("Contact", "", BrendonHardinContactSkills));
			ElleCollierSkillCategory.add(new SkillCategory("Contact", "", ElleCollierContactSkills));
			TylerWeeksSkillCategory.add(new SkillCategory("Contact", "", TylerWeeksContactSkills));
			MiaDavilaSkillCategory.add(new SkillCategory("Contact", "", MiaDavilaContactSkills));
			BaronRichardsonSkillCategory.add(new SkillCategory("Contact", "", BaronRichardsonContactSkills));
			GideonTerrellSkillCategory.add(new SkillCategory("Contact", "", GideonTerrellContactSkills));
			AdysonPachecoSkillCategory.add(new SkillCategory("Contact", "", AdysonPachecoContactSkills));
			EmmaleeGlassSkillCategory.add(new SkillCategory("Contact", "", EmmaleeGlassContactSkills));
			IsaiasMckaySkillCategory.add(new SkillCategory("Contact", "", IsaiasMckayContactSkills));
			RogerWagnerSkillCategory.add(new SkillCategory("Contact", "", RogerWagnerContactSkills));
			AdriannaFernandezSkillCategory.add(new SkillCategory("Contact", "", AdriannaFernandezContactSkills));
			KoltonKaiserSkillCategory.add(new SkillCategory("Contact", "", KoltonKaiserContactSkills));
			AllisonHaleySkillCategory.add(new SkillCategory("Contact", "", AllisonHaleyContactSkills));
			NatalieNormanSkillCategory.add(new SkillCategory("Contact", "", NatalieNormanContactSkills));
			JadonCharlesSkillCategory.add(new SkillCategory("Contact", "", JadonCharlesContactSkills));
			CohenMckinneySkillCategory.add(new SkillCategory("Contact", "", CohenMckinneyContactSkills));
			AnabelVargasSkillCategory.add(new SkillCategory("Contact", "", AnabelVargasContactSkills));
			AriaKiddSkillCategory.add(new SkillCategory("Contact", "", AriaKiddContactSkills));
			RolandPettySkillCategory.add(new SkillCategory("Contact", "", RolandPettyContactSkills));
			RobertoOdomSkillCategory.add(new SkillCategory("Contact", "", RobertoOdomContactSkills));
			CamrynWattsSkillCategory.add(new SkillCategory("Contact", "", CamrynWattsContactSkills));
			MarioMortonSkillCategory.add(new SkillCategory("Contact", "", MarioMortonContactSkills));
			SethSpencerSkillCategory.add(new SkillCategory("Contact", "", SethSpencerContactSkills));
			HamzaEsparzaSkillCategory.add(new SkillCategory("Contact", "", HamzaEsparzaContactSkills));
			BrandonBrockSkillCategory.add(new SkillCategory("Contact", "", BrandonBrockContactSkills));
			AlannaLucasSkillCategory.add(new SkillCategory("Contact", "", AlannaLucasContactSkills));
			CraigShawSkillCategory.add(new SkillCategory("Contact", "", CraigShawContactSkills));
			JaidenCarneySkillCategory.add(new SkillCategory("Contact", "", JaidenCarneyContactSkills));
			ShylaHuangSkillCategory.add(new SkillCategory("Contact", "", ShylaHuangContactSkills));
			KasenLeSkillCategory.add(new SkillCategory("Contact", "", KasenLeContactSkills));
			NoemiStoutSkillCategory.add(new SkillCategory("Contact", "", NoemiStoutContactSkills));
			IbrahimDaviesSkillCategory.add(new SkillCategory("Contact", "", IbrahimDaviesContactSkills));
			FranklinWhitneySkillCategory.add(new SkillCategory("Contact", "", FranklinWhitneyContactSkills));
			ManuelCobbSkillCategory.add(new SkillCategory("Contact", "", ManuelCobbContactSkills));
			MarkKentSkillCategory.add(new SkillCategory("Contact", "", MarkKentContactSkills));
			EmilyRyanSkillCategory.add(new SkillCategory("Contact", "", EmilyRyanContactSkills));
			KeonWernerSkillCategory.add(new SkillCategory("Contact", "", KeonWernerContactSkills));
			JaydonRuizSkillCategory.add(new SkillCategory("Contact", "", JaydonRuizContactSkills));
			MakaylaHarrellSkillCategory.add(new SkillCategory("Contact", "", MakaylaHarrellContactSkills));
			KendallCarneySkillCategory.add(new SkillCategory("Contact", "", KendallCarneyContactSkills));
			MichaelWallSkillCategory.add(new SkillCategory("Contact", "", MichaelWallContactSkills));
			WinstonHudsonSkillCategory.add(new SkillCategory("Contact", "", WinstonHudsonContactSkills));
			AntoineMelendezSkillCategory.add(new SkillCategory("Contact", "", AntoineMelendezContactSkills));
			ElisabethCareySkillCategory.add(new SkillCategory("Contact", "", ElisabethCareyContactSkills));
			EdwardGraySkillCategory.add(new SkillCategory("Contact", "", EdwardGrayContactSkills));
			
			MariannaFigueroaSkillCategory.add(new SkillCategory("Passing", "", MariannaFigueroaPassingSkills));
			MichaelaOconnorSkillCategory.add(new SkillCategory("Passing", "", MichaelaOconnorPassingSkills));
			ValentinaHowellSkillCategory.add(new SkillCategory("Passing", "", ValentinaHowellPassingSkills));
			EstebanGibsonSkillCategory.add(new SkillCategory("Passing", "", EstebanGibsonPassingSkills));
			AdisonChandlerSkillCategory.add(new SkillCategory("Passing", "", AdisonChandlerPassingSkills));
			AlbertChandlerSkillCategory.add(new SkillCategory("Passing", "", AlbertChandlerPassingSkills));
			DixieGreenSkillCategory.add(new SkillCategory("Passing", "", DixieGreenPassingSkills));
			NoelleCoffeySkillCategory.add(new SkillCategory("Passing", "", NoelleCoffeyPassingSkills));
			DaytonClarkSkillCategory.add(new SkillCategory("Passing", "", DaytonClarkPassingSkills));
			JonahBradshawSkillCategory.add(new SkillCategory("Passing", "", JonahBradshawPassingSkills));
			JessicaWeeksSkillCategory.add(new SkillCategory("Passing", "", JessicaWeeksPassingSkills));
			AdelynDorseySkillCategory.add(new SkillCategory("Passing", "", AdelynDorseyPassingSkills));
			BrendonHardinSkillCategory.add(new SkillCategory("Passing", "", BrendonHardinPassingSkills));
			ElleCollierSkillCategory.add(new SkillCategory("Passing", "", ElleCollierPassingSkills));
			TylerWeeksSkillCategory.add(new SkillCategory("Passing", "", TylerWeeksPassingSkills));
			MiaDavilaSkillCategory.add(new SkillCategory("Passing", "", MiaDavilaPassingSkills));
			BaronRichardsonSkillCategory.add(new SkillCategory("Passing", "", BaronRichardsonPassingSkills));
			GideonTerrellSkillCategory.add(new SkillCategory("Passing", "", GideonTerrellPassingSkills));
			AdysonPachecoSkillCategory.add(new SkillCategory("Passing", "", AdysonPachecoPassingSkills));
			EmmaleeGlassSkillCategory.add(new SkillCategory("Passing", "", EmmaleeGlassPassingSkills));
			IsaiasMckaySkillCategory.add(new SkillCategory("Passing", "", IsaiasMckayPassingSkills));
			RogerWagnerSkillCategory.add(new SkillCategory("Passing", "", RogerWagnerPassingSkills));
			AdriannaFernandezSkillCategory.add(new SkillCategory("Passing", "", AdriannaFernandezPassingSkills));
			KoltonKaiserSkillCategory.add(new SkillCategory("Passing", "", KoltonKaiserPassingSkills));
			AllisonHaleySkillCategory.add(new SkillCategory("Passing", "", AllisonHaleyPassingSkills));
			NatalieNormanSkillCategory.add(new SkillCategory("Passing", "", NatalieNormanPassingSkills));
			JadonCharlesSkillCategory.add(new SkillCategory("Passing", "", JadonCharlesPassingSkills));
			CohenMckinneySkillCategory.add(new SkillCategory("Passing", "", CohenMckinneyPassingSkills));
			AnabelVargasSkillCategory.add(new SkillCategory("Passing", "", AnabelVargasPassingSkills));
			AriaKiddSkillCategory.add(new SkillCategory("Passing", "", AriaKiddPassingSkills));
			RolandPettySkillCategory.add(new SkillCategory("Passing", "", RolandPettyPassingSkills));
			RobertoOdomSkillCategory.add(new SkillCategory("Passing", "", RobertoOdomPassingSkills));
			CamrynWattsSkillCategory.add(new SkillCategory("Passing", "", CamrynWattsPassingSkills));
			MarioMortonSkillCategory.add(new SkillCategory("Passing", "", MarioMortonPassingSkills));
			SethSpencerSkillCategory.add(new SkillCategory("Passing", "", SethSpencerPassingSkills));
			HamzaEsparzaSkillCategory.add(new SkillCategory("Passing", "", HamzaEsparzaPassingSkills));
			BrandonBrockSkillCategory.add(new SkillCategory("Passing", "", BrandonBrockPassingSkills));
			AlannaLucasSkillCategory.add(new SkillCategory("Passing", "", AlannaLucasPassingSkills));
			CraigShawSkillCategory.add(new SkillCategory("Passing", "", CraigShawPassingSkills));
			JaidenCarneySkillCategory.add(new SkillCategory("Passing", "", JaidenCarneyPassingSkills));
			ShylaHuangSkillCategory.add(new SkillCategory("Passing", "", ShylaHuangPassingSkills));
			KasenLeSkillCategory.add(new SkillCategory("Passing", "", KasenLePassingSkills));
			NoemiStoutSkillCategory.add(new SkillCategory("Passing", "", NoemiStoutPassingSkills));
			IbrahimDaviesSkillCategory.add(new SkillCategory("Passing", "", IbrahimDaviesPassingSkills));
			FranklinWhitneySkillCategory.add(new SkillCategory("Passing", "", FranklinWhitneyPassingSkills));
			ManuelCobbSkillCategory.add(new SkillCategory("Passing", "", ManuelCobbPassingSkills));
			MarkKentSkillCategory.add(new SkillCategory("Passing", "", MarkKentPassingSkills));
			EmilyRyanSkillCategory.add(new SkillCategory("Passing", "", EmilyRyanPassingSkills));
			KeonWernerSkillCategory.add(new SkillCategory("Passing", "", KeonWernerPassingSkills));
			JaydonRuizSkillCategory.add(new SkillCategory("Passing", "", JaydonRuizPassingSkills));
			MakaylaHarrellSkillCategory.add(new SkillCategory("Passing", "", MakaylaHarrellPassingSkills));
			KendallCarneySkillCategory.add(new SkillCategory("Passing", "", KendallCarneyPassingSkills));
			MichaelWallSkillCategory.add(new SkillCategory("Passing", "", MichaelWallPassingSkills));
			WinstonHudsonSkillCategory.add(new SkillCategory("Passing", "", WinstonHudsonPassingSkills));
			AntoineMelendezSkillCategory.add(new SkillCategory("Passing", "", AntoineMelendezPassingSkills));
			ElisabethCareySkillCategory.add(new SkillCategory("Passing", "", ElisabethCareyPassingSkills));
			EdwardGraySkillCategory.add(new SkillCategory("Passing", "", EdwardGrayPassingSkills));
			
			johnSmithSkillCategory.add(new SkillCategory("Running", "", JohnRunningSkills));
			johnSmithSkillCategory.add(new SkillCategory("Contact", "", JohnContactSkills));
			johnSmithSkillCategory.add(new SkillCategory("Passing", "", JohnPassingSkills));
			
			BobDylanSkillCategory.add(new SkillCategory("Running", "", BobRunningSkills));
			BobDylanSkillCategory.add(new SkillCategory("Contact", "", BobContactSkills));
			BobDylanSkillCategory.add(new SkillCategory("Passing", "", BobPassingSkills));
			
			GinnyPotterSkillCategory.add(new SkillCategory("Running", "", GinnyRunningSkills));
			GinnyPotterSkillCategory.add(new SkillCategory("Contact", "", GinnyContactSkills));
			GinnyPotterSkillCategory.add(new SkillCategory("Passing", "", GinnyPassingSkills));
			
			/**
			 * Players ArrayList is initialised - player objects are created (60 players)
			 */
			ArrayList<Player> juniorPlayers = new ArrayList<Player>();
			ArrayList<Player> seniorPlayers = new ArrayList<Player>();
			ArrayList<Player> seniorPlayers2 = new ArrayList<Player>();
			
			juniorPlayers.add(new JuniorPlayer("Marianna", "Figueroa", "Marianna@player.com", date, "1 Player Lane", "01234567893", MariannaFigueroaSkillCategory, "Loose-head prop", "07617728915", "07617728915", "07617728915", "Lando Norris", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Michaela", "Oconnor", "Michaela@player.com", date, "2 Player Lane", "01234567893", MichaelaOconnorSkillCategory, "Hooker", "07617728915", "07617728915", "07617728915", "Luke price", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Valentina", "Howell", "Valentina@player.com", date, "3 Player Lane", "01234567893", ValentinaHowellSkillCategory, "Tight-head prop", "07617728915", "07617728915", "07617728915", "Seb Vettel", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Esteban", "Gibson", "Esteban@player.com", date, "4 Player Lane", "01234567893", EstebanGibsonSkillCategory, "Lock", "07617728915", "07617728915", "07617728915", "Ellie crowe", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Adison", "Chandler", "Adison@player.com", date, "5 Player Lane", "01234567893", AdisonChandlerSkillCategory, "Lock", "07617728915", "07617728915", "07617728915", "June October", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Albert", "Chandler", "Albert@player.com", date, "6 Player Lane", "01234567893", AlbertChandlerSkillCategory, "Open-side flanker", "07617728915", "07617728915", "07617728915", "GuardNameForBob", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Dixie", "Green", "Dixie@player.com", date, "7 Player Lane", "01234567893", DixieGreenSkillCategory, "Blind-side flanker", "07617728915", "07617728915", "07617728915", "Tony Corleone", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Noelle", "Coffey", "Noelle@player.com", date, "8 Player Lane", "01234567893", NoelleCoffeySkillCategory, "Number 8", "07617728915", "07617728915", "07617728915", "Eugene Zuckerburg", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Dayton", "Clark", "Dayton@player.com", date, "9 Player Lane", "01234567893", DaytonClarkSkillCategory, "Left wing", "07617728915", "07617728915", "07617728915", "Sammy Left", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Jonah", "Bradshaw", "Jonah@player.com", date, "10 Player Lane", "01234567893", JonahBradshawSkillCategory, "Scrum half", "07617728915", "07617728915", "07617728915", "Katie Condor", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Jessica", "Weeks", "Jessica@player.com", date, "11 Player Lane", "01234567893", JessicaWeeksSkillCategory, "Fly half", "07617728915", "07617728915", "07617728915", "Harry Potter", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Adelyn", "Dorsey", "Adelyn@player.com", date, "12 Player Lane", "01234567893", AdelynDorseySkillCategory, "Inside centre", "07617728915", "07617728915", "07617728915", "Ginny Weasley", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Brendon", "Hardin", "Brendon@player.com", date, "13 Player Lane", "01234567893", BrendonHardinSkillCategory, "Outside centre", "07617728915", "07617728915", "07617728915", "John Dorset", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Elle", "Collier", "Elle@player.com", date, "14 Player Lane", "01234567893", ElleCollierSkillCategory, "Right wing", "07617728915", "07617728915", "07617728915", "Luke Skywalker", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Tyler", "Weeks", "Tyler@player.com", date, "15 Player Lane", "01234567893", TylerWeeksSkillCategory, "Full Back", "07617728915", "07617728915", "07617728915", "Bruce McKenzie", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Mia", "Davila", "Mia@player.com", date, "16 Player Lane", "01234567893", MiaDavilaSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915", "Alan Miller", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Baron", "Richardson", "Baron@player.com", date, "17 Player Lane", "01234567893", BaronRichardsonSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915", "Dan Hunter", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Gideon", "Terrell", "Gideon@player.com", date, "18 Player Lane", "01234567893", GideonTerrellSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915", "Izzy McDonald", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Adyson", "Pacheco", "Adyson@player.com", date, "19 Player Lane", "01234567893", AdysonPachecoSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915", "Luke Jordan", "07625637153"));
			juniorPlayers.add(new JuniorPlayer("Emmalee", "Glass", "Emmalee@player.com", date, "20 Player Lane", "01234567893", EmmaleeGlassSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915", "Jean Paul", "07625637153"));
			
			seniorPlayers.add(new Player("Isaias", "Mckay", "Isaias@player.com", date, "21 Player Lane", "01234567893", IsaiasMckaySkillCategory, "Loose-head prop", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Roger", "Wagner", "Roger@player.com", date, "22 Player Lane", "01234567893", RogerWagnerSkillCategory, "Hooker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Adrianna", "Fernandez", "Adrianna@player.com", date, "23 Player Lane", "01234567893", AdriannaFernandezSkillCategory, "Tight-head prop", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Kolton", "Kaiser", "Kolton@player.com", date, "24 Player Lane", "01234567893", KoltonKaiserSkillCategory, "Lock", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Allison", "Haley", "Allison@player.com", date, "25 Player Lane", "01234567893", AllisonHaleySkillCategory, "Lock", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Natalie", "Norman", "Natalie@player.com", date, "26 Player Lane", "01234567893", NatalieNormanSkillCategory, "Open-side flanker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Jadon", "Charles", "Jadon@player.com", date, "27 Player Lane", "01234567893", JadonCharlesSkillCategory, "Blind-side flanker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Cohen", "Mckinney", "Cohen@player.com", date, "28 Player Lane", "01234567893", CohenMckinneySkillCategory, "Number 8", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Anabel", "Vargas", "Anabel@player.com", date, "29 Player Lane", "01234567893", AnabelVargasSkillCategory, "Left wing", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Aria", "Kidd", "Aria@player.com", date, "30 Player Lane", "01234567893", AriaKiddSkillCategory, "Scrum half", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Roland", "Petty", "Roland@player.com", date, "31 Player Lane", "01234567893", RolandPettySkillCategory, "Fly half", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Roberto", "Odom", "Roberto@player.com", date, "32 Player Lane", "01234567893", RobertoOdomSkillCategory, "Inside centre", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Camryn", "Watts", "Camryn@player.com", date, "33 Player Lane", "01234567893", CamrynWattsSkillCategory, "Outside centre", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Mario", "Morton", "Mario@player.com", date, "34 Player Lane", "01234567893", MarioMortonSkillCategory, "Right wing", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Seth", "Spencer", "Seth@player.com", date, "35 Player Lane", "01234567893", SethSpencerSkillCategory, "Full Back", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Hamza", "Esparza", "Hamza@player.com", date, "36 Player Lane", "01234567893", HamzaEsparzaSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Brandon", "Brock", "Brandon@player.com", date, "37 Player Lane", "01234567893", BrandonBrockSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Alanna", "Lucas", "Alanna@player.com", date, "38 Player Lane", "01234567893", AlannaLucasSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Craig", "Shaw", "Craig@player.com", date, "39 Player Lane", "01234567893", CraigShawSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers.add(new Player("Jaiden", "Carney", "Jaiden@player.com", date, "40 Player Lane", "01234567893", JaidenCarneySkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			
			seniorPlayers2.add(new Player("Shyla", "Huang", "Shyla@player.com", date, "41 Player Lane", "01234567893", ShylaHuangSkillCategory, "Loose-head prop", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Kasen", "Le", "Kasen@player.com", date, "42 Player Lane", "01234567893", KasenLeSkillCategory, "Hooker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Noemi", "Stout", "Noemi@player.com", date, "43 Player Lane", "01234567893", NoemiStoutSkillCategory, "Tight-head prop", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Ibrahim", "Davies", "Ibrahim@player.com", date, "44 Player Lane", "01234567893", IbrahimDaviesSkillCategory, "Lock", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Franklin", "Whitney", "Franklin@player.com", date, "45 Player Lane", "01234567893", FranklinWhitneySkillCategory, "Lock", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Manuel", "Cobb", "Manuel@player.com", date, "46 Player Lane", "01234567893", ManuelCobbSkillCategory, "Open-side flanker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Mark", "Kent", "Mark@player.com", date, "47 Player Lane", "01234567893", MarkKentSkillCategory, "Blind-side flanker", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Emily", "Ryan", "Emily@player.com", date, "48 Player Lane", "01234567893", EmilyRyanSkillCategory, "Number 8", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Keon", "Werner", "Keon@player.com", date, "49 Player Lane", "01234567893", KeonWernerSkillCategory, "Left wing", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Jaydon", "Ruiz", "Jaydon@player.com", date, "50 Player Lane", "01234567893", JaydonRuizSkillCategory, "Scrum half", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Makayla", "Harrell", "Makayla@player.com", date, "51 Player Lane", "01234567893", MakaylaHarrellSkillCategory, "Fly half", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Kendall", "Carney", "Kendall@player.com", date, "52 Player Lane", "01234567893", KendallCarneySkillCategory, "Inside centre", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Michael", "Wall", "Michael@player.com", date, "53 Player Lane", "01234567893", MichaelWallSkillCategory, "Outside centre", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Winston", "Hudson", "Winston@player.com", date, "54 Player Lane", "01234567893", WinstonHudsonSkillCategory, "Right wing", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Antoine", "Melendez", "Antoine@player.com", date, "55 Player Lane", "01234567893", AntoineMelendezSkillCategory, "Full Back", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Elisabeth", "Carey", "Elisabeth@player.com", date, "56 Player Lane", "01234567893", ElisabethCareySkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Edward", "Gray", "Edward@player.com", date, "57 Player Lane", "01234567893", EdwardGraySkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("john", "Smith", "john@player.com", date, "58 Player Lane", "01234567893", johnSmithSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Bob", "Dylan", "Bob@player.com", date, "59 Player Lane", "01234567893", BobDylanSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			seniorPlayers2.add(new Player("Ginny", "Potter", "Ginny@player.com", date, "60 Player Lane", "01234567893", GinnyPotterSkillCategory, "Reserve", "07617728915", "07617728915", "07617728915"));
			
			/**
			 * squads arrayList is initialised
			 */
			ArrayList<Squad> squads = new ArrayList<Squad>();
			
			/**
			 * squads are created with player lists
			 */
			squads.add(new Squad("Junior", juniorPlayers));
			squads.add(new Squad("Senior Squad A", seniorPlayers));
			squads.add(new Squad("Senior Squad B", seniorPlayers2));
			
			/**
			 * coaches and squads created are saved to file
			 */
			saveCoaches(coaches);
			saveSquads(squads);

			
		}
	}
	

	
}
	

