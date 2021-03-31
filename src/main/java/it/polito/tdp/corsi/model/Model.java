package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	private CorsoDAO corsoDAO;
	
	public Model() {
		corsoDAO = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDAO.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDAO.getIscrittiByPeriodo(pd);
	}
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDAO.getStudentiByCorso(new Corso(codice, null, null, null));
	}

	public boolean esisteCorso(String codice) {
		return corsoDAO.esisteCorso(new Corso(codice, null, null, null));
	}
	
	//per il quarto punto ci sono due metodo
	//senza usare il db
	public Map<String, Integer> getDivisioneCDS(String codice) {  //poteri ritornare una mappa Map<String, Integer> o una lista List<DivioneCDS> (ma col secondo servirebbe un'altra classe)
		
		/*
		 * cosa ci aspettiamo
		 * dato il corso con codice ABC
		 * GEST -> 50
		 * INF -> 40
		 * MEC -> 30
		 */
		
		//SOLUZIONE 1
		/*Map<String, Integer> divisione = new HashMap<String, Integer>();
		List<Studente> studenti = this.getStudentiByCorso(codice);
		for(Studente s: studenti) {
			if(s.getCDS()!=null && !s.getCDS().equals("")) {
				if(divisione.get(s.getCDS())==null) {  //nuovo corso
					divisione.put(s.getCDS(), 1);
				}else {   //corso già esistente
					divisione.put(s.getCDS(), divisione.get(s.getCDS()) +1);
				}
			}
			
		}*/
		
		//SOLUZIONE 2
		return corsoDAO.getDivisioneStudenti(new Corso(codice, null,null,null));
		
	}
	
	
	
}
