package com.netcracker.labs.servlets;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PaintImage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		OutputStream out=response.getOutputStream();
		Random rnd = new Random();
		try{
			BufferedImage img=new BufferedImage(640, 120, BufferedImage.TYPE_INT_RGB);
			Graphics gr=img.getGraphics();
			gr.setFont(new Font("Arial",0, 72));
			Color rndColor=new Color(rnd.nextInt());
			gr.setColor(rndColor);
			gr.drawString("Hello world!", 100, 100);
			ImageIO.write(img, "png", out);
		}
		finally{
			out.close();
		}
	}

	

}
