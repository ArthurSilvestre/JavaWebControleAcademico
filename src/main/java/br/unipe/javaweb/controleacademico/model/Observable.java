package br.unipe.javaweb.controleacademico.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<IListener> listeners;
	
	public Observable(){
		listeners = new ArrayList<IListener>();
	}
	
	public boolean addListener(IListener listener){
		try {
			this.listeners.add(listener);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean removeListener(IListener listener){
		try {
			this.listeners.remove(listener);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void notifyListeners(String estagio){
		for (IListener iListener : listeners) {
			iListener.sendNotification(estagio);
		}
	}

	public List<IListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<IListener> listeners) {
		this.listeners = listeners;
	}
	
}
