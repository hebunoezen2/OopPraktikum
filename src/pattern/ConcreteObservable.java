package pattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable implements Observable{

	
	//Erstellen einer ArrayList
		private List<Observer> observers = new ArrayList<>();
		
		@Override
		public void addObserver(Observer obs){
		
			boolean add = false;
			
			if(observers.isEmpty() == false){
				
				
				for (Observer o : observers){
					
					if(o.equals(obs)){
						add = true;
					}
				}
			}
			
			if(add == false){

				this.observers.add(obs);
			}	
		}
		
		@Override
		public void removeObserver(Observer obs){
			
			for(Observer o : observers){
				
				if(o.equals(obs)){
					int i = observers.indexOf(o);
					observers.remove(i);
				}
			}
		}
		
		@Override
		public void notifyObservers(){
			
			for(Observer o : observers){
				o.update();
			}
		}
}
