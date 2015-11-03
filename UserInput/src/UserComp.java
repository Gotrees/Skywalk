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
	int winnum=8, n = 5, s=1, dy = 0, speed = 30, dy1=0, dy2=0, dx=0, lastloss=0, jforce=3, sforce=3, t=0, u=0, c=0;
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
	Rectangle dsd = new Rectangle(220,0,1,1);
	Rectangle dsl = new Rectangle(436,236,1,1);
	String pressspace = new String("Press <space> to start.");
	String vict1 = new String("Victory to the");
	String vict2emp = new String("GALACTIC EMPIRE");
	String vict2reb = new String("REBEL ALLIANCE");
	String vict3 = new String("Press <space> to play again.");
	Color longago = new Color(30,241,224);
	boolean bmap = false, ready = false, wPressed = false, sPressed = false, downPressed = false, upPressed = false, spacePressed = false, dPressed = false, leftPressed = false;

	public void draw(Graphics2D win) {
		
		win.setColor(Color.BLACK);
		win.fill(bg);
		win.drawImage(background, null, 0, 44);
		
		
		
		
///////////DRAW SWORDS, BLASTER
		
		win.drawImage(jsword, null, (int)jedi.getX(), (int)jedi.getY()-4);
		win.drawImage(ssword, null, (int)sith.getX(), (int)sith.getY()-4);
		if(jediScore<winnum&&sithScore<winnum){
			win.drawImage(blaster, null, (int)ball.getX(), (int)ball.getY());
		}



		
//////////////JEDI WIN SCREEN
		if(jediScore>=winnum){
			wPressed=false;
			sPressed=false;
			dPressed=false;
			upPressed=false;
			downPressed=false;
			leftPressed=false;
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 85));
			win.setPaint(Color.YELLOW);
			win.drawString(vict1, 260, 710-u);
			win.setFont(new Font("Impact", Font.PLAIN, 100));
			win.drawString(vict2reb, 195, 830-u);
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 50));
			win.setPaint(longago);
			if(u<500){
				win.drawString(vict3, 190,980-u);
			}else{
				win.drawString(vict3, 190, 480);
			}
			
			u=u+2;
			
			
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
		
		if(jediScore==0){
			u=0;
		}
		
		
/////////////SITH WIN SCREEN
		if(sithScore>=winnum){
			wPressed=false;
			sPressed=false;
			dPressed=false;
			upPressed=false;
			downPressed=false;
			leftPressed=false;
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 85));
			win.setPaint(Color.YELLOW);
			win.drawString(vict1, 250, 710-t);
			win.setFont(new Font("Impact", Font.PLAIN, 100));
			win.drawString(vict2emp, 150, 830-t);
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 50));
			win.setPaint(longago);
			if(t<500){
				win.drawString(vict3, 190,980-t);
			}else{
				win.drawString(vict3, 190, 480);
			}
			
			
			t=t+2;
			
			
			if(spacePressed){
				sithScore=0;
				jediScore=0;
				jforce=3;
				sforce=3;
				ball.move(165,336);
				dy2=0; 
				dx=0;
				n=5;
			}
		}
		
		if(sithScore==0){
			t=0;
		}
		
/////////////SCOREBOARD, BORDER
		win.setColor(Color.BLACK);
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
		win.setFont( new Font("Franklin Gothic Medium",Font.PLAIN,15));
		win.setPaint(Color.WHITE);
		win.drawString("Rebel Alliance", 180, 33);
		win.setPaint(Color.WHITE);
		win.drawString("Galactic Empire", 720, 33);
		
		
		win.setFont( new Font("Impact",Font.PLAIN,30));
		win.setPaint(Color.WHITE);
		win.drawString(String.valueOf(sithScore), 512, 35);
		if(jediScore<10){
			win.drawString(String.valueOf(jediScore), 473, 35);
		}else{
			win.drawString(String.valueOf(jediScore), 462, 35);
		}
		
		
/////////////UPON SITH SCORE (AGAINST JEDI)
		if(ball.getX()<-80){
			ball.move(165,336);
			dy2=0;
			dx=0;
			n=n-1;
			lastloss=0;
			s=1;
			sithScore=sithScore+1;
			}
		
		
/////////////UPON JEDI SCORE(AGAINST SITH)
		if(ball.getX()>1015){
			ball.move(765,336);
			dy2=0; 
			dx=0;
			n=n-1;
			lastloss=1;
			s=1;
			jediScore=jediScore+1;
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
		
///////////INSTRUCTIONS
	
		if(dx==0&&ball.getX()==465&&c<100&&c!=-1){   //PAGE 1 (TIMED)
			
			c=c+1;																//basically, keep adding 1 to
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));	//c until c=100, then move on
			win.setPaint(longago);
			win.drawString("A long time ago, in a galaxy far,", 300,200);
			win.drawString("far away....", 300,232);	
			
		}	
		
		if(spacePressed&&c>=100){
			c=-1;
		}
		if(dx==0&&ball.getX()==465&&c>=100){         //PAGE 2 (PROCEED ON SPACEBAR)
			win.drawImage(title, null, 50, 82);
			win.drawImage(map, null, 300, 375);
			win.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 40));
			win.setPaint(Color.WHITE);
			win.drawString(pressspace, 300, 500);
			win.setFont(new Font("Ariel", Font.PLAIN, 25));
			win.setPaint(Color.WHITE);
			if(winnum>=10){													//this if/else just formats text
				win.drawString("First to " + winnum + " wins.", 407, 550);	//if winnum is 2-digits, the string
			}else{															//moves over a bit to the right
				win.drawString("First to " + winnum + " wins.", 411, 550);	//to maintain position in center
			}
			win.setFont(new Font("Ariel", Font.PLAIN, 10));
			win.setPaint(Color.LIGHT_GRAY);
			win.drawString("A game by", 465, 600);
			win.setFont(new Font("Ariel", Font.PLAIN, 12));
			win.drawString("Dylan Fabris   Brian Chiang", 415, 615);
	
		}
		
		
		
		
///////////START GAME UPON SPACEPRESS
		if(dx==0&&ball.getX()==465&&spacePressed&&c==-1){
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
	
	
	
	BufferedImage background = null;   	//stars bg
	BufferedImage jsword = null; 		//left paddle
	BufferedImage ssword = null;		//right paddle
	BufferedImage blaster = null;		//ball
	BufferedImage lightning = null;		//right powerup effect
	BufferedImage force = null;			//left powerup effect
	BufferedImage imperial = null;		//right powerup icon
	BufferedImage rebel = null;			//left powerup icon
	BufferedImage map = null;			//keymap (instructions)
	BufferedImage title = null;			//skywalker title
	
	public UserComp(){
		background = addImage("background.jpg");
		jsword = addImage("jedi.png");
		ssword = addImage("sith.png");
		blaster = addImage("blaster.png");
		lightning = addImage("lightning.png");
		force = addImage("force.png");
		imperial = addImage("imperial.png");
		rebel = addImage("rebel.png");
		map = addImage("map.png");
		title = addImage("title.png");
		
	}

}
