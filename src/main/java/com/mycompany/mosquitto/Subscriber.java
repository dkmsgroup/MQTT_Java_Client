package com.mycompany.mosquitto;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Subscriber {

    
    private static final String USERNAME = "exams";
    private static final String PASSWORD = "summer2020";
    
  public static void main(String[] args) throws MqttException {

    MqttClient client=new MqttClient("tcp://147.102.16.56:1883", MqttClient.generateClientId());
    MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
    
    client.setCallback( new SimpleMqttCallBack() );
    client.connect(connOpts);

    client.subscribe("exams");

  }
  
  
  private static MqttConnectOptions setUpConnectionOptions(String username, String password) {
       MqttConnectOptions connOpts = new MqttConnectOptions();
       connOpts.setCleanSession(true);
       connOpts.setUserName(username);
       connOpts.setPassword(password.toCharArray());
       return connOpts;
   }  

}