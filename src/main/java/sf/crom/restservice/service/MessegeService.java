package sf.crom.restservice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sf.crom.restservice.data.DataBaseStubClass;
import sf.crom.restservice.model.Messege;



public class MessegeService {
	
	private Map<Long, Messege> messeges=DataBaseStubClass.getMesseges();
	
	public MessegeService(){
		messeges.put(1L, new Messege(1,"This is Sandy","Sandipan"));
		messeges.put(2L, new Messege(2,"This is Ruchi","Ruchi"));
		messeges.put(3L, new Messege(3,"This is Both","Both"));
	}
	
	
	public List<Messege> getAllMesseges(){
		return new ArrayList<Messege>(messeges.values());
	}
	
	public List<Messege> getAllMessegesForAYear(int year){
		List<Messege> messegeForTheYear=new ArrayList<Messege>();
		Calendar calendar=Calendar.getInstance();
		for(Messege messege:messeges.values()){
			calendar.setTime(messege.getCreatedDate());
			if((calendar.get(Calendar.YEAR))==year){
				messegeForTheYear.add(messege);
			}
		}
		return messegeForTheYear;
	}
	
	public List<Messege> getAllMessegePaginated(int start, int size){
		//List<Messege> paginatedList=(List<Messege>) messeges.values();
		ArrayList<Messege> paginatedList=new ArrayList<Messege>(messeges.values());
		if(start+size>paginatedList.size()){
			return paginatedList;
		}
		return paginatedList.subList(start, ( start+size));
	}
	
	public Messege getMessegeUsingId(long id){
		System.out.println(messeges.get(id).getMessege());
		return messeges.get(id);
	}
	
	public Messege addMessege(Messege messege){
		messege.setId(messeges.size()+1);
		messeges.put(messege.getId(),messege);
		System.out.println(messeges);
		return messege;
	}
	
	public Messege updateMessege(Messege messege){
		if(messege.getId()<=0){
			return null;
		}
		messeges.put(messege.getId(), messege);
		return messege;
	}
	
	public void removeMessegeUsingId(long id){
		 messeges.remove(id);
	
	}

}
