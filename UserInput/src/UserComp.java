import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

//brianchiang2012@gmail.com
//dylanf1998@gmail.com

/*                     .              .       .                    .      .
.        .               .       .     .            .
   .           .        .                     .        .            .
             .               .    .          .              .   .         .
               _________________      ____         __________
 .       .    /                 |    /    \    .  |          \
     .       /    ______   _____| . /      \      |    ___    |     .     .
             \    \    |   |       /   /\   \     |   |___>   |
           .  \    \   |   |      /   /__\   \  . |         _/               .
 .     ________>    |  |   | .   /            \   |   |\    \_______    .
      |            /   |   |    /    ______    \  |   | \           |
      |___________/    |___|   /____/      \____\ |___|  \__________|    . do up to 6 code hs
  .     ____    __  . _____   ____      .  __________   .  _________
       \    \  /  \  /    /  /    \       |          \    /         |      .
        \    \/    \/    /  /      \      |    ___    |  /    ______|  .
         \              /  /   /\   \ .   |   |___>   |  \    \
   .      \            /  /   /__\   \    |         _/.   \    \            +
           \    /\    /  /            \   |   |\    \______>    |   .
            \  /  \  /  /    ______    \  |   | \              /          .
 .       .   \/    \/  /____/      \____\ |___|  \____________/  
                               .                                        .
     .                           .         .               .                 .
                .                                   .            .*/



public class UserComp extends GameDriver{

	int sithScore=0,jediScore=0;
	int  n = 5, s=1, dy = 0, speed = 20, dy1=0, dy2=0, dx=0, lastloss=0, jforce=3, sforce=3, t=0;
	Rectangle jedi = new Rectangle(50,300,5,75);
	Rectangle sith = new Rectangle(930,300,5,75);
	Rectangle bg = new Rectangle(0,0,1000,700);
	Rectangle ball = new Rectangle(465,336,70,7);
	Rectangle top = new Rectangle(0,44,1000,3);
	Rectangle bottom = new Rectangle(0,629,1000,3);
	Rectangle bottomblack = new Rectangle(0,629,1000,71);
	Rectangle topblack = new Rectangle(0,0,1000,44);
	Rectangle middle = new Rectangle(500,4,1,36);
	Rectangle imperial1 = new Rectangle(900,7,30,30);
	Rectangle imperial2 = new Rectangle(865,7,30,30);
	Rectangle imperial3 = new Rectangle(830,7,30,30);
	Rectangle rebel1 = new Rectangle(70,7,30,30);
	Rectangle rebel2 = new Rectangle(105,7,30,30);
	Rectangle rebel3 = new Rectangle(140,7,30,30);
	String pressspace = new String("Press <space> to start.");
	String empirevict1 = new String("Victory to the");
	String empirevict2 = new String("GALACTIC EMPIRE");
	String pressspace1 = new String("Press <space> to play again.");
	Color longago = new Color(30,241,224);
	boolean wPressed = false, sPressed = false, downPressed = false, upPressed = false, spacePressed = false, dPressed = false, leftPressed = false;
	public void draw(Graphics2D win) {
		
		win.setColor(Color.BLACK);
		win.fill(bg);
		win.drawImage(background, null, 0, 44);
		win.drawImage(jsword, null, (int)jedi.getX(), (int)jedi.getY()-4);
		win.drawImage(ssword, null, (int)sith.getX(), (int)sith.getY()-4);
		win.drawImage(blaster, null, (int)ball.getX(), (int)ball.getY());
		win.fill(bottomblack);
		win.fill(topblack);
		win.setColor(Color.YELLOW);
		win.fill(top);
		win.fill(bottom);
		win.setColor(Color.WHITE);
		win.fill(middle);
		win.drawImage(imperial, null, 900, 7);
		win.drawImage(imperial, null, 865, 7);
		win.drawImage(imperial, null, 830, 7);
		win.drawImage(rebel, null, 70, 7);
		win.drawImage(rebel, null, 105, 7);
		win.drawImage(rebel, null, 140, 7);

	/*	if(ball.getX()<jedi.getX()-10){
			 jediScore=jediScore+1;
		}
		if(ball.getX()>sith.getX()){
			sithScore=sithScore+1;
		}*/
		
		
//////////////JEDI WIN SCREEN
		if(jediScore>=10){
			win.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			win.drawString("Player 1 Wins", 250, 230);
			win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			win.drawString("Hit Space to start ",300,500 );
			if(spacePressed){
				sithScore=0;
				jediScore=0;
				jforce=3;
				sforce=3;
				ball.move(765,336);
				dy2=0; 
				dx=0;
				n=5;
			}
		}
		
		
		
/////////////SITH WIN SCREEN
		if(sithScore>=10){
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 85));
			win.setPaint(Color.YELLOW);
			win.drawString(empirevict1, 250, 710-t);
			win.setFont(new Font("Impact", Font.PLAIN, 100));
			win.drawString(empirevict2, 150, 850-t);
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 50));
			win.setPaint(longago);
			if(t<500){
				win.drawString(pressspace1, 200,1000-t);
			}else{
				win.drawString(pressspace1, 200, 500);
			}
			
			t=t+1;
			
			
			if(spacePressed){
				sithScore=0;
				jediScore=0;
				jforce=3;
				sforce=3;
				ball.move(765,336);
				dy2=0; 
				dx=0;
				n=5;
			}
		}
		
		if(sithScore==0){
			t=0;
		}
		
/////////////SCOREBOARD
		win.setFont( new Font("Impact",Font.PLAIN,30));
		win.setPaint(Color.WHITE);
		win.drawString(String.valueOf(sithScore), 510, 35);
		win.drawString(String.valueOf(jediScore), 475, 35);
		
		
/////////////UPON SITH SCORE (AGAINST JEDI)
		if(ball.getX()<-80){
			ball.move(165,336);
			dy2=0;
			dx=0;
			n=n-1;
			lastloss=0;
			s=1;
			sithScore=sithScore+10;
			}
		
		
/////////////UPON JEDI SCORE(AGAINST SITH)
		if(ball.getX()>1015){
			ball.move(765,336);
			dy2=0; 
			dx=0;
			n=n-1;
			lastloss=1;
			s=1;
			jediScore=jediScore+10;
		}
		
		
//////////////SITH SCORE, RESET BALL
		if((ball.getX()==765&&dx==0)){
			ball.move(765,(int)sith.getCenterY());
			if(leftPressed){
				dx=-(speed-n);
			}
		}
		
/////////////JEDI SCORE, RESET BALL
		if((ball.getX()==165&&dx==0)){
			ball.move(165,(int)jedi.getCenterY());
			if(dPressed){
				dx=speed-n;
			}
		}
		
		
//////////////JEDI POWER UPS
		if(jforce>0&&dx<0&&dPressed){
			dx=-dx;
			jforce=jforce-1;
			win.drawImage(force, null, (int)jedi.getX(), (int)jedi.getCenterY()-150);
		}
		
		if(jforce<=2){
			win.setColor(Color.BLACK);
			win.fill(rebel3);				
		}
		if(jforce<=1){
			win.setColor(Color.BLACK);
			win.fill(rebel2);
		}
		if(jforce<=0){
			win.setColor(Color.BLACK);
			win.fill(rebel1);
		}
		
//////////////SITH POWER UPS
		if(sforce>0&&dx>0&&leftPressed){
			dx=-dx;
			sforce=sforce-1;
			win.drawImage(lightning, null, (int)sith.getX()-400, (int)sith.getCenterY()-196);
		}
		
		if(sforce<=2){
			win.setColor(Color.BLACK);
			win.fill(imperial3);				
		}
		if(sforce<=1){
			win.setColor(Color.BLACK);
			win.fill(imperial2);
		}
		if(sforce<=0){
			win.setColor(Color.BLACK);
			win.fill(imperial1);
		}
		
		
///////////JEDI MOVE SABER UP/DOWN
		if(wPressed&&jedi.getY()>=50){
			dy = -speed;
		} else if (sPressed&&jedi.getY()<550) {
			dy = speed;
		} else {
			dy = 0;
		}
		
///////////SITH MOVE SABER UP/DOWN
		if(upPressed&&sith.getY()>50){
			dy1 = -speed;
		} else if (downPressed&&sith.getY()<550) {
			dy1 = speed;
		} else {
			dy1 = 0;
		}
		
		
///////////BALL BOUNCE OFF SABER
		if((ball.intersects(sith)&&dx>0)||(ball.intersects(jedi)&&dx<0)){
			dx=-dx;
			s=s+1;
			if(ball.intersects(sith)&&dy1>0||ball.intersects(jedi)&&dy>0){
				dy2=(int)(Math.random()*10);                 //IF PADDLE MOVING DOWN, BALL BOUNCES DOWN
			}else if(ball.intersects(sith)&&dy1<0||ball.intersects(jedi)&&dy<0){
				dy2=(int)(Math.random()*-10);     //IF PADDLE MOVING UP, BALL BOUNCES UP
			}else if(dy2%2==0){
				dy2=(int)(Math.random()*10);   //IF PADDLE IS STILL, RANDOMLY CHOOSE BOUNCE UP/DOWN
			}else{  									   //(BASED ON ODD/EVEN Y-VELOCITY OF BALL)
				dy2=(int)(Math.random()*-10);
			}
			if(s%3==0){        //INCREASE X-VELOCITY BY ONE, EVERY THREE HITS
				if(dx<0){
					dx=dx-1;
				}else{
					dx=dx+1;
				}
			}
		}
		
////////////BALL BOUNCE OFF CEILING/FLOOR
		if((ball.getY()>615&&dy2>0)||(ball.getY()<50)&&dy2<0){
			dy2=-dy2;            
		}
		
///////////START GAME UPON SPACEPRESS
		if(dx==0&&ball.getX()==465&&spacePressed){
			if((int)(Math.random()*10)%2==0){
				dx=speed-n;                         //RANDOMLY CHOOSE FIRST SERVE
			}else{
				dx=-(speed-n);
			}
		}
		
//////////BASIC DEFAULT TRANSLATIONS
		jedi.translate(0, dy);
		sith.translate(0, dy1);
		ball.translate(dx, dy2);

	}
	
	public void keyPressed(KeyEvent e){
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			wPressed = true;
		}else if(e.getKeyCode() == KeyEvent.VK_S){
			sPressed = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			downPressed = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			dPressed = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			spacePressed = true;
		}
	}
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_W) {
			wPressed = false;
		}else if(e.getKeyCode() == KeyEvent.VK_S){
			sPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			downPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			dPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			spacePressed = false;
		}
	}
	
	
	
	BufferedImage background = null;
	BufferedImage jsword = null; 
	BufferedImage ssword = null;
	BufferedImage blaster = null;
	BufferedImage lightning = null;
	BufferedImage force = null;
	BufferedImage imperial = null;
	BufferedImage rebel = null;
	
	public UserComp(){
		background = addImage("background.jpg");
		jsword = addImage("jedi.png");
		ssword = addImage("sith.png");
		blaster = addImage("blaster.png");
		lightning = addImage("lightning.png");
		force = addImage("force.png");
		imperial = addImage("imperial.png");
		rebel = addImage("rebel.png");
	}

}
