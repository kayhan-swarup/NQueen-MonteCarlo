package nqueen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

public class ChessBoard extends JPanel{
	int n;
	public static Rectangle2D.Double[][] blocks;
	public static JPanel block[][];
	boolean hasQueen = false;
	public  ChessBoard(int n) {
		super();
		this.n=n;
		blocks = new Rectangle2D.Double[n][n];
		block = new JPanel[n][n];
		this.setLayout(new GridLayout(n,n));
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				block[i][j] = new JPanel();
				block[i][j].setLayout(new BorderLayout());
				block[i][j].setBackground(i%2==j%2?Color.BLACK:Color.WHITE);
				add(block[i][j]);
				
			}
			
		}
	}
	

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(800,800);
	}
	
	public  static void addQueen(Queen queen,int i,int j){
		block[i][j].add(queen);
		queen.row = i;queen.column=j;
			
	}
	public static void moveQueen(Queen queen,int column){
		block[queen.row][queen.column].remove(queen);
		block[queen.row][column].add(queen);
		queen.column = column;
		
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
//		if()
		
	}
	
	
	

}
