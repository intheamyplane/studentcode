package com.techelevator;

public class Television {
    private boolean isOn;
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
        isOn=isOn;
        currentChannel=3;
        currentVolume=2;
    }
    public void changeChannel(int newChannel){
        if(isOn==true && (newChannel>=3 && newChannel<=18)){
            currentChannel=newChannel;
        }
    }
    public void channelUp(){

            if (isOn==true && currentChannel >= 3 && currentChannel <= 17) {
                this.currentChannel++;
            }
            if (isOn==true && currentChannel == 18) {
                this.currentChannel = 3;
            }

    }
    public void channelDown(){

          if (isOn==true && (currentChannel >= 4 && currentChannel <= 18)) {
              this.currentChannel--;
          }
          if (isOn==true && currentChannel == 3) {
              this.currentChannel = 18;
          }

    }
    public void raiseVolume(){

            if(isOn==true && currentVolume<=9&&currentVolume>=0){
                this.currentVolume++;
            }

    }
    public void lowerVolume(){

            if(isOn==true && currentVolume>=1&&currentVolume<=10){
                this.currentVolume--;
            }


    }







}
