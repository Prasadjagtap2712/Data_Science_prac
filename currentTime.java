import java.applet.Applet;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class currentTime extends Applet implements Runnable {
	TextField t1;
    Button b1,b2;
    Thread t;
    int hr,min,sec;
    boolean buttonclicked = false;
    public void init()
    {
        t1=new TextField(10);
         add(t1);
        b1=new Button("Start");
         add(b1);
        b2=new Button("Stop");
          add(b2);
        t=new Thread(this);
        t.start();
     }
     public void run()
     {
       try{
    	 Thread.sleep(1000);
    	 if(sec < 60 ){
    		 sec++;
    		 if( sec == 59){
    			 min++;
    			  if(min == 59){
    				  hr++;
    				  min = 0;
    			  }
    			 sec =0;
    		 }
    		 
    	 }
    	
    	 repaint();
    	 
       } catch(Exception e){
    	   
       }
       
       
      }
     public void paint(Graphics g)
    {
    	 if(buttonclicked){
    		 t1.setText( hr+":"+min+":"+sec );
    		 run();
    	 }
        
    }
	
	public boolean action(Event evtObj, Object arg){
		if(evtObj.target instanceof Button){
			if(arg.equals("Start")){
				Calendar cal = Calendar.getInstance();
		        hr = cal.get(Calendar.HOUR);
		        min = cal.get(Calendar.MINUTE);
		        sec = cal.get(Calendar.SECOND);
		        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		        t1.setText( hr+":"+min+":"+sec );
		        buttonclicked = true;
		        repaint();
			} else if(arg.equals("Stop")){
				buttonclicked = false;
				repaint();
			}
		}
		
		return false;
		
	}
}


