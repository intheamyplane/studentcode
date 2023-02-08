package com.techelevator;

public class Television {
    private boolean isOn=false;
    private int currentChannel;
    private int currentVolume;
//getters

    public boolean isOn() {
        return isOn;
    }
    public int getCurrentChannel() {
        return currentChannel;
    }
    public int getCurrentVolume() {
        return currentVolume;
    }

    //methods

    public void turnOff(){
        if(isOn){
        this.isOn=false;}
    }
    public void turnOn(){
        isOn=true;
        currentChannel=3;
        currentVolume=2;
    }
    public void changeChannel(int newChannel){
        if(isOn==true && (newChannel>=3 && newChannel<=18)){
            currentChannel=newChannel;
        }
    }
    public void channelUp(){

            if (isOn && currentChannel >= 3 && currentChannel <= 17) {
                currentChannel++;
            }
            if (isOn && currentChannel == 18) {
                currentChannel = 3;
            }

    }
    public void channelDown(){

          if (isOn && (currentChannel >= 4 && currentChannel <= 18)) {
              currentChannel--;
          }
          if (isOn && currentChannel == 3) {
              currentChannel = 18;
          }

    }
    public void raiseVolume(){

            if(isOn && currentVolume<=10){
                currentVolume=currentVolume+1;
            }

    }
    public void lowerVolume(){

            if(isOn && currentVolume>=1&&currentVolume<=10){
                currentVolume=currentVolume-1;
            }


    }







}
