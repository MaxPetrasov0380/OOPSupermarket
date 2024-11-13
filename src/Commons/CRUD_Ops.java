package Commons;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import Exceptions.UnexpectedErrorException;


public class CRUD_Ops {
	 static HelperPrikaz HP = new HelperPrikaz();

	static Helper Helper = new Helper();
	static HelperPrikaz HelperP = new HelperPrikaz();
	
	//ADMIN CRUD
	
	public static String prikazAdmina(JTable table) {
		String query = "SELECT * FROM admin";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 
	public static void dodajAdmina(String adminUsername, String adminPass, String adminEmail, String adminBT, String adminAdresa) throws UnexpectedErrorException {
    	if(adminUsername.equals("") ||  adminPass.equals("") || adminEmail.equals("") || adminBT.equals("") || adminAdresa.equals("")) {
    		throw new UnexpectedErrorException("Sva polja moraju biti popunjena.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO admin(adminUsername, adminPass, adminEmail, adminBT, adminAdresa) VALUES ('"+adminUsername+"', '"+adminPass+"', '"+adminEmail+"', '"+adminBT+"', '"+adminAdresa+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
	
	public static void izmeniAdmina(String adminUsername, String adminPass, String adminEmail, String adminBT, String adminAdresa, String adminID) throws UnexpectedErrorException {
    	if(adminUsername.equals("") ||  adminPass.equals("") || adminEmail.equals("") || adminBT.equals("") || adminAdresa.equals("") || adminID.equals("")) {
    		throw new UnexpectedErrorException("Greska pri izmeni. Neka polja su ostala prazna ili nista nije promenjeno.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "UPDATE admin SET adminUsername ='"+adminUsername+"', adminPass = '"+adminPass+"', adminEmail='"+adminEmail+"', adminBT ='"+adminBT+"', adminAdresa ='"+adminAdresa+"', WHERE adminID = "+adminID+"";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }


    public static void obrisiAdmina(String adminUsername, String adminPass, String adminEmail, String adminBT, String adminAdresa, String adminID) throws UnexpectedErrorException   {
    	Connection connect = Commons.Helper.getConnection();
		String sql = "DELETE FROM admin WHERE adminID = "+adminID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    //ARTIKAL CRUD
    
	public static String PrikazArtikala(JTable table) {
		String query = "SELECT * FROM artikal";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 
    public static void DodajArtikal(String artikalNaziv, String artikalVrsta, String artikalCena, String artikalKolicina) throws UnexpectedErrorException {
    	if(artikalNaziv.equals("") ||  artikalVrsta.equals("") || artikalCena.equals("") || artikalKolicina.equals("")) {
    		throw new UnexpectedErrorException("Sva polja moraju biti popunjena.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO artikal(artikalNaziv, artikalVrsta, artikalCena, artikalKolicina) VALUES ('"+artikalNaziv+"', '"+artikalVrsta+"', '"+artikalCena+"', '"+artikalKolicina+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
    
    public static void IzmeniArtikal(String artikalNaziv, String artikalVrsta, String artikalCena, String artikalKolicina, String artikalID) throws UnexpectedErrorException {
    	if(artikalNaziv.equals("") ||  artikalVrsta.equals("") || artikalCena.equals("") || artikalKolicina.equals("") || artikalID.equals("")) {
    		throw new UnexpectedErrorException("Greska pri izmeni. Neka polja su ostala prazna ili nista nije promenjeno.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "UPDATE artikal SET artikalNaziv = '"+artikalNaziv+"', artikalVrsta = '"+artikalVrsta+"', artikalCena = '"+artikalCena+"', artikalKolicina = '"+artikalKolicina+"', WHERE artikalID = "+artikalID+"";
					
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }
    
    public static void ObrisiArtikal(String artikalNaziv, String artikalVrsta, String artikalCena, String artikalKolicina, String artikalID) throws UnexpectedErrorException   {
    	Connection connect = Commons.Helper.getConnection();
		String sql = "DELETE FROM artikal WHERE ID = "+artikalID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    //KASIR CRUD
    
    public static String PrikazKasira(JTable table) {
		String query = "SELECT * FROM kasir";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 
    public static void DodajKasira(String kasirIme, String kasirPrezime, String kasirUsername, String kasirPassword, String kasirEmail, String kasirBT, String kasirAdresa) throws UnexpectedErrorException {
    	//kasirEmail je NULL vrednost
    	if(kasirIme.equals("") ||  kasirPrezime.equals("") || kasirUsername.equals("") || kasirPassword.equals("") || kasirBT.equals("") || kasirAdresa.equals("")) {
    		throw new UnexpectedErrorException("Sva trazena polja moraju biti popunjena.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO kasir(kasirIme, kasirPrezime, kasirUsername, kasirPassword, kasirEmail, kasirBT, kasirAdresa) VALUES ('"+kasirIme+"', '"+kasirPrezime+"', '"+kasirUsername+"', '"+kasirPassword+"', '"+kasirEmail+"', '"+kasirBT+"', '"+kasirAdresa+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
    
    public static void IzmeniKasira(String kasirIme, String kasirPrezime, String kasirUsername, String kasirPassword, String kasirEmail, String kasirBT, String kasirAdresa, String kasirID) throws UnexpectedErrorException {
    	if(kasirIme.equals("") ||  kasirPrezime.equals("") || kasirUsername.equals("") || kasirPassword.equals("") || kasirBT.equals("") || kasirAdresa.equals("")) {
    		throw new UnexpectedErrorException("Greska pri izmeni. Neka trazena polja su ostala prazna ili nista nije promenjeno.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "UPDATE artikal SET kasirIme = '"+kasirIme+"', kasirPrezime = '"+kasirPrezime+"', kasirUsername = '"+kasirUsername+"', kasirPassword = '"+kasirPassword+"', kasirEmail = '"+kasirEmail+"', kasirBT = '"+kasirBT+"', kasirAdresa = '"+kasirAdresa+"', WHERE kasirID = "+kasirID+"";
					
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }
    
    public static void ObrisiKasira(String kasirIme, String kasirPrezime, String kasirUsername, String kasirPassword, String kasirEmail, String kasirBT, String kasirAdresa, String kasirID) throws UnexpectedErrorException   {
    	Connection connect = Commons.Helper.getConnection();
		String sql = "DELETE FROM kasir WHERE kasirID = "+kasirID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    //NABAVKA CRUD, IzmeniNabavku() nije potrebno
    
    public static String PrikazNabavki(JTable table) {
		String query = "SELECT * FROM nabavka";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
    
    // pri dodavanju nabavke treba povecati kolicinu artikla za broj nabavljene kolicine
    // ne znam da li ce to tu da bude ili u frontu
    public static void DodajNabavku(String artikalID, String nabavljenaKolicina, String nabavkaDatum, String nabavkaCena, String sefID) throws UnexpectedErrorException {
    	if(artikalID.equals("") ||  nabavljenaKolicina.equals("") || nabavkaDatum.equals("") || nabavkaCena.equals("") || sefID.equals("")) {
    		throw new UnexpectedErrorException("Sva polja moraju biti popunjena.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO nabavka(artikalID, nabavljenaKolicina, nabavkaDatum, nabavkaCena, sefID) VALUES ('"+artikalID+"', '"+nabavljenaKolicina+"', '"+nabavkaDatum+"', '"+nabavkaCena+"', '"+sefID+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
    
    // pri brisanju nabavke treba vratiti kolicinu artikla za broj nabavljene kolicine
    // ne znam da li ce to tu da bude ili u frontu
    public static void ObrisiNabavku(String artikalID, String nabavljenaKolicina, String nabavkaDatum, String nabavkaCena, String sefID, String nabavkaID) throws UnexpectedErrorException   {
    	Connection connect = Commons.Helper.getConnection();
		String sql = "DELETE FROM nabavka WHERE nabavkaID = "+nabavkaID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    //RACUN CRUD, samo prikaz i dodavanje
    
    public static String PrikazRacuna(JTable table) {
		String query = "SELECT * FROM racun";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
    
    // racuni se cuvaju u <racunID>.txt , nisam jos implementirao
    public static void DodajRacun(String ukupnaCena, String datumVreme, String kasirID) throws UnexpectedErrorException {
    	if(ukupnaCena.equals("") ||  datumVreme.equals("") || kasirID.equals("")) {
    		throw new UnexpectedErrorException("Neocekivana greska pri potvrdi kupovine.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO racun(ukupnaCena, datumVreme, kasirID) VALUES ('"+ukupnaCena+"', '"+datumVreme+"', '"+kasirID+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
    
    //SEF NABAVKE CRUD
    
    public static String prikazSefova(JTable table) {
		String query = "SELECT * FROM sefnabavke";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 
	public static void dodajSefa(String sefUsername, String sefPassword, String sefEmail, String sefBT, String sefAdresa) throws UnexpectedErrorException {
    	if(sefUsername.equals("") ||  sefPassword.equals("") || sefEmail.equals("") || sefBT.equals("") || sefAdresa.equals("")) {
    		throw new UnexpectedErrorException("Sva polja moraju biti popunjena.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "INSERT INTO sefnabavke(sefUsername, sefPassword, sefEmail, sefBT, sefAdresa) VALUES ('"+sefUsername+"', '"+sefPassword+"', '"+sefEmail+"', '"+sefBT+"', '"+sefAdresa+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
	
	public static void izmeniSefa(String sefUsername, String sefPassword, String sefEmail, String sefBT, String sefAdresa, String sefID) throws UnexpectedErrorException {
    	if(sefUsername.equals("") ||  sefPassword.equals("") || sefEmail.equals("") || sefBT.equals("") || sefAdresa.equals("") || sefID.equals("")) {
    		throw new UnexpectedErrorException("Greska pri izmeni. Neka polja su ostala prazna ili nista nije promenjeno.");
		}else { 
			
			Connection conn = Commons.Helper.getConnection();
			String query = "UPDATE sefnabavke SET sefUsername ='"+sefUsername+"', sefPassword = '"+sefPassword+"', sefEmail='"+sefEmail+"', sefBT ='"+sefBT+"', sefAdresa ='"+sefAdresa+"', WHERE sefID = "+sefID+"";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }


    public static void obrisiSefa(String sefUsername, String sefPassword, String sefEmail, String sefBT, String sefAdresa, String sefID) throws UnexpectedErrorException   {
    	Connection connect = Commons.Helper.getConnection();
		String sql = "DELETE FROM sefnabavke WHERE sefID = "+sefID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    
}