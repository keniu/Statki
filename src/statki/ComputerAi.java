/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gameships;

import java.util.Random;

public class ShipsComputerAi {
    int [][] tab0=new int[10][10];
    int [][] tab1=new int[10][10];  
    int shotX=0;int shotY=0;
    int randX=0;int randY=0;
    int lastX=0,lastY=0;
  
    boolean ishit=false;
    Random rand=new Random();    
    boolean CheckIsSunk(int x,int y, int shiptype){
    boolean loop0=true;
    boolean loop1=true;
   int count=0;
    while(loop0==true){
       
     if(tab1[x][y]==shiptype){
      x=x-1;   
    if(x==-1) {x=0;break;}
     }else{
         loop0=false;
     x=x+1;  
    } }
 
    while(loop1==true){
     if(tab1[x][y]==shiptype){
      x=x+1;
    
      count=count+1;
       if(x==10) {x=9;break;}
     }else{
      loop1=false;
     }}
 
     if(count==shiptype){
     this.ishit=false;
    return true;  
     }
    else return false;
    }
    void Begin(){
        int shiptype=tab1[this.lastX][this.lastY];
      if(ishit==true) {

     SinkShip(this.lastX, this.lastY);
    
    
    }else{
     Rand();
    }
    }
    
        void Rand(){
    this.randX=rand.nextInt(10);
     this.randY=rand.nextInt(10);
     CheckRepeat(this.randX, this.randY);
    }
        
        void  CheckRepeat(int x,int y){
      if(this.tab0[x][y]==0)
          Fire();
      else
          Rand();
    }
        
    String Fire(){
     return randX+":"+randY;
    }
  


void SaveHit(int x,int y,int statek)  /// Pozniej dodam.
{

}

void SinkShip(int x,int y){
    boolean loop0=true;
    boolean loop1=true;
    int shiptype=tab1[x][y];
while(loop0==true){

     if(tab1[x][y]==shiptype){
         x=x-1;
  if(x==-1) {x=0;break;}
     }else if(tab0[x][y]==0){ 
loop0=false;
 loop1=false;
     }
             
     else {loop0=false;x++;}
}
while(loop1==true){

    if(tab1[x][y]==shiptype){
     x+=1;  
      if(x==10) {x=9;break;}
    }else if(tab0[x][y]==0){ loop1=false;
    } else {loop1=false; x--;}

}
 this.randX=x;
 this.randY=y;

}
ShipsComputerAi(){
 for(int x=0;x<10;x++){   
  for(int y=0;y<10;y++){
      tab0[x][y]=0;
      tab1[x][y]=6;
  }
      
 }
}

}
