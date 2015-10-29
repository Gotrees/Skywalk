import java.awt.Color;
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
      |___________/    |___|   /____/      \____\ |___|  \__________|    .
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

	int  n = 5, s=1, dy = 0, speed = 20, dy1=0, dy2=0, dx=speed-n, lastloss=0;
	Rectangle jedi = new Rectangle(50,300,5,75);
	Rectangle sith = new Rectangle(930,300,5,75);
	Rectangle bg = new Rectangle(0,0,1000,700);
	Rectangle ball = new Rectangle(465,336,70,7);
	Rectangle top = new Rectangle(0,44,1000,3);
	Rectangle bottom = new Rectangle(0,629,1000,3);
	Rectangle middle = new Rectangle(500,0,1,700);
	boolean wPressed = false, sPressed = false, downPressed = false, upPressed = false, spacePressed = false;
	public void draw(Graphics2D win) {
		
		win.setColor(Color.BLACK);
		win.fill(bg);
		win.drawImage(background, null, 0, 44);
		win.setColor(Color.GREEN);
	//	win.fill(jedi);
		win.drawImage(jsword, null, (int)jedi.getX(), (int)jedi.getY()-4);
		win.setColor(Color.RED);
	//	win.fill(sith);
		win.drawImage(ssword, null, (int)sith.getX(), (int)sith.getY()-4);
		win.setColor(Color.RED);
	//	win.fill(ball);
		win.drawImage(blaster, null, (int)ball.getX(), (int)ball.getY());
		win.setColor(Color.YELLOW);
		win.fill(top);
		win.fill(bottom);
	//	win.fill(middle);

		
		if(ball.getX()<-80){//91-5=86 
			ball.move(465,336);
			dy2=0;
			dx=0;
			n=n-1;
			lastloss=0;
			}
		if(ball.getX()>1015){
			ball.move(465,336);
			dy2=0;
			dx=0;
			n=n-1;
			lastloss=1;
		}
		
		if(ball.getX()==465&&ball.getY()==336&&dx==0){
			if(spacePressed&&lastloss==0){
				dx=speed-n;
			}else if(spacePressed&&lastloss==1){
				dx=-(speed-n);
			}
		}
		
		if(wPressed&&jedi.getY()>=50){
			dy = -speed;
		} else if (sPressed&&jedi.getY()<550) {
			dy = speed;
		} else {
			dy = 0;
		}
		
		if(upPressed&&sith.getY()>50){
			dy1 = -speed;
		} else if (downPressed&&sith.getY()<550) {
			dy1 = speed;
		} else {
			dy1 = 0;
		}
		
		if((ball.intersects(sith)&&dx>0)||(ball.intersects(jedi)&&dx<0)){
			dx=-dx;
			s=s+1;
			if(dy2%2==0){
				dy2=(int)(Math.random()*10);
			}else{
				dy2=(int)(Math.random()*-10);
			}
			if(s%3==0){
				if(dx<0){
					dx=dx-1;
				}else{
					dx=dx+1;
				}
			}
		}
		if(ball.getY()>615||ball.getY()<50){
			dy2=-dy2;
		}
		
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
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			spacePressed = false;
		}
	}
	
	
	
	BufferedImage background = null;
	BufferedImage jsword = null;
	BufferedImage ssword = null;
	BufferedImage blaster = null;


	public UserComp(){
		background = addImage("background.jpg");
		jsword = addImage("jedi.png");
		ssword = addImage("sith.png");
		blaster = addImage("blaster.png");
	}

}
