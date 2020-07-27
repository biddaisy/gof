package com.mr.gof.behavioral.observer;

public interface Subject {
  // methods to register and unregister observers
  void register(Observer obj);

  void unregister(Observer obj);

  // method to notify observers of change
  void notifyObservers();
}
