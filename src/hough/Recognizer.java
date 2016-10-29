package hough;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Recognizer {

	

	public static void main(String[] args) throws IOException {
		
	   BufferedImage bmp = ImageIO.read(new File("bin\\hough\\count11.png"));
	   int[]tmp = new int[bmp.getHeight()*bmp.getWidth()];
	   int[]tmp2 = new int[bmp.getHeight()*bmp.getWidth()];
	   byte[] pixels=null;
	   int width = bmp.getWidth();
	   int height = bmp.getHeight();
	   pixels=((DataBufferByte) bmp.getRaster().getDataBuffer()).getData();
		for(int i=0;i<pixels.length;i++){
			tmp[i]=pixels[i]&0xff;
		}
		for(int i=0;i<pixels.length;i++){
			tmp2[i]=pixels[i]&0xff;
		}
		
		for(int i=0;i<tmp.length;i++){
			if(tmp[i]>120 && tmp[i]<200){
			}
			else{
				tmp[i]=0;
			}
		}
		for(int i=1;i<tmp.length-1;i++){
			if(tmp[i]>100){
				if(tmp[i+1]==0 && tmp[i-1]==0)
				tmp[i]=0;
			}
		}
		for(int i=width;i<tmp.length-width;i++){
			if(tmp[i]>100){
				if(tmp[i+width]==0 && tmp[i-width]==0)
				tmp[i]=0;
			}
		}
		for(int i=1;i<tmp.length-1;i++){
			if(tmp[i]>100){
				if(tmp[i+1]==0 && tmp[i-1]==0)
				tmp[i]=0;
			}
		}
		for(int i=width;i<tmp.length-width;i++){
			if(tmp[i]>100){
				if(tmp[i+width]==0 && tmp[i-width]==0)
				tmp[i]=0;
			}
		}
		for(int i=1;i<tmp.length-1;i++){
			if(tmp[i]>100){
				if(tmp[i+1]==0 && tmp[i-1]==0)
				tmp[i]=0;
			}
		}
		for(int i=width;i<tmp.length-width;i++){
			if(tmp[i]>100){
				if(tmp[i+width]==0 && tmp[i-width]==0)
				tmp[i]=0;
			}
		}
		
		///tmp2
		for(int i=0;i<tmp2.length;i++){
			if(tmp2[i]>110){
				tmp2[i]=0;
			}
			else{
				tmp2[i]=255;
			}
		}
		for(int i=1;i<tmp2.length-1;i++){
			if(tmp2[i]==0){
				if(tmp2[i+1]==255 && tmp2[i-1]==255)
				tmp2[i]=255;
			}
		}
		for(int i=width;i<tmp2.length-width;i++){
			if(tmp2[i]==0){
				if(tmp2[i+width]==255 && tmp2[i-width]==255)
				tmp2[i]=255;
			}
		}
		
		BufferedImage img = new BufferedImage(bmp.getWidth(),bmp.getHeight(), BufferedImage.TYPE_INT_RGB);
		img.setRGB(0, 0,bmp.getWidth(),bmp.getHeight(),tmp,0,bmp.getWidth());
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		frame.pack();
		frame.setVisible(true);		
		ImageIO.write(img, "png", new File("test.png"));
		
		BufferedImage img2 = new BufferedImage(bmp.getWidth(),bmp.getHeight(), BufferedImage.TYPE_INT_RGB);
		img2.setRGB(0, 0,bmp.getWidth(),bmp.getHeight(),tmp2,0,bmp.getWidth());
		JFrame frame2 = new JFrame();
		frame2.getContentPane().setLayout(new FlowLayout());
		frame2.getContentPane().add(new JLabel(new ImageIcon(img2)));
		frame2.pack();
		frame2.setVisible(true);
		ImageIO.write(img2, "png", new File("test2.png"));
		

	}
	

}
